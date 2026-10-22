package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class PrintHelper {

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = false;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = false;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions;
    final Object mLock;
    int mOrientation;
    int mScaleMode;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @RequiresApi(19)
    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;
        final /* synthetic */ PrintHelper this$0;

        PrintBitmapAdapter(PrintHelper r10, String r11, int r12, Bitmap r13, OnPrintFinishCallback r14) {
            this.this$0 = r10;
            this.mJobName = r11;
            this.mFittingMode = r12;
            this.mBitmap = r13;
            this.mCallback = r14;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback r10 = this.mCallback;
            if (r10 == null) goto L6;
            r10.onFinish();
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes r10, PrintAttributes r11, CancellationSignal r12, PrintDocumentAdapter.LayoutResultCallback r13, Bundle r14) {
            this.mAttributes = r11;
            r13.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r11.equals(r10));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r10, ParcelFileDescriptor r11, CancellationSignal r12, PrintDocumentAdapter.WriteResultCallback r13) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r11, r12, r13);
        }
    }

    @RequiresApi(19)
    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        final /* synthetic */ PrintHelper this$0;

        PrintUriAdapter(PrintHelper r10, String r11, Uri r12, OnPrintFinishCallback r13, int r14) {
            this.this$0 = r10;
            this.mJobName = r11;
            this.mImageFile = r12;
            this.mCallback = r13;
            this.mFittingMode = r14;
            this.mBitmap = null;
        }

        void cancelLoad() {
            Object r10 = this.this$0.mLock;
            monitor-enter(r10);
            BitmapFactory.Options r11 = this.this$0.mDecodeOptions;     // Catch: Throwable -> L12
            if (r11 != null) goto L7;
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L7:
            if (Build.VERSION.SDK_INT >= 24) goto L9;
            r11.requestCancelDecode();     // Catch: Throwable -> L12
        L9:
            this.this$0.mDecodeOptions = null;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> r10 = this.mLoadBitmap;
            if (r10 == null) goto L5;
            r10.cancel(true);
        L5:
            OnPrintFinishCallback r11 = this.mCallback;
            if (r11 == null) goto L8;
            r11.onFinish();
        L8:
            Bitmap r12 = this.mBitmap;
            if (r12 == null) goto L12;
            r12.recycle();
            this.mBitmap = null;
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes r10, final PrintAttributes r11, final CancellationSignal r12, final PrintDocumentAdapter.LayoutResultCallback r13, Bundle r14) {
            monitor-enter(this);
            this.mAttributes = r11;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r12.isCanceled() == false) goto L10;
            r13.onLayoutCancelled();
            return;
        L10:
            if (this.mBitmap == null) goto L13;
            r13.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r11.equals(r10));
            return;
        L13:
            this.mLoadBitmap = new AnonymousClass1(this, r12, r11, r10, r13).execute(new Uri[0]);
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r10, ParcelFileDescriptor r11, CancellationSignal r12, PrintDocumentAdapter.WriteResultCallback r13) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r11, r12, r13);
        }
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        boolean r11 = false;
        if (r10 < 20) goto L7;
        if (r10 > 23) goto L7;
        boolean r12 = false;
    L8:
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = r12;
        if (r10 == 23) goto L11;
        r11 = true;
    L11:
        IS_MIN_MARGINS_HANDLING_CORRECT = r11;
        return;
    L7:
        r12 = true;
        goto L8
    }

    public PrintHelper(@NonNull Context r10) {
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = r10;
    }

    static Bitmap convertBitmapForColorMode(Bitmap r10, int r11) {
        if (r11 == 1) goto L5;
        return r10;
    L5:
        Bitmap r12 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r12);
        Paint r14 = new Paint();
        ColorMatrix r15 = new ColorMatrix();
        r15.setSaturation(0.0f);
        r14.setColorFilter(new ColorMatrixColorFilter(r15));
        r13.drawBitmap(r10, 0.0f, 0.0f, r14);
        r13.setBitmap(null);
        return r12;
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder copyAttributes(PrintAttributes r10) {
        PrintAttributes.Builder r11 = new PrintAttributes.Builder().setMediaSize(r10.getMediaSize()).setResolution(r10.getResolution()).setMinMargins(r10.getMinMargins());
        if (r10.getColorMode() == 0) goto L6;
        r11.setColorMode(r10.getColorMode());
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
    L10:
        return r11;
    L8:
        if (r10.getDuplexMode() == 0) goto L10;
        r11.setDuplexMode(r10.getDuplexMode());
        goto L10
    }

    static Matrix getMatrix(int r10, int r11, RectF r12, int r13) {
        Matrix r14 = new Matrix();
        float r15 = r10;
        float r16 = r12.width() / r15;
        if (r13 != 2) goto L5;
        float r17 = Math.max(r16, r12.height() / r11);
    L6:
        r14.postScale(r17, r17);
        r14.postTranslate((r12.width() - (r15 * r17)) / 2.0f, (r12.height() - (r11 * r17)) / 2.0f);
        return r14;
    L5:
        r17 = Math.min(r16, r12.height() / r11);
        goto L6
    }

    static boolean isPortrait(Bitmap r10) {
        if (r10.getWidth() > r10.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    private Bitmap loadBitmap(Uri r10, BitmapFactory.Options r11) {
        if (r10 == null) goto L25;
        Context r12 = this.mContext;
        if (r12 == null) goto L25;
        InputStream r13 = null;
        InputStream r14 = r12.getContentResolver().openInputStream(r10);     // Catch: Throwable -> L17
        Bitmap r15 = BitmapFactory.decodeStream(r14, null, r11);     // Catch: Throwable -> L15
        if (r14 != null) goto L30;
    L14:
        return r15;
    L30:
        r14.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Log.w(LOG_TAG, "close fail ", e);
    L15:
        th = th;
        r13 = r14;
    L18:
        if (r13 != null) goto L32;
    L23:
        throw th;
    L32:
        r13.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        Log.w(LOG_TAG, "close fail ", e);
    L17:
        th = th;
    L25:
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    public static boolean systemSupportsPrint() {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        return true;
    L5:
        return false;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (this.mOrientation != 0) goto L9;
        return 1;
    L9:
        return this.mOrientation;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    Bitmap loadConstrainedBitmap(Uri r10) {
        if (r10 == null) goto L44;
        if (this.mContext == null) goto L44;
        BitmapFactory.Options r11 = new BitmapFactory.Options();
        r11.inJustDecodeBounds = true;
        loadBitmap(r10, r11);
        int r12 = r11.outWidth;
        int r13 = r11.outHeight;
        if (r12 <= 0) goto L42;
        if (r13 <= 0) goto L42;
        int r14 = Math.max(r12, r13);
        int r15 = 1;
    L11:
        if (r14 <= MAX_PRINT_SIZE) goto L13;
        r14 = r14 >>> 1;
        r15 = r15 << 1;
        goto L11
    L13:
        if (r15 <= 0) goto L42;
        if ((Math.min(r12, r13) / r15) <= 0) goto L42;
        Object r16 = this.mLock;
        monitor-enter(r16);
        BitmapFactory.Options r17 = new BitmapFactory.Options();     // Catch: Throwable -> L39
        this.mDecodeOptions = r17;     // Catch: Throwable -> L39
        r17.inMutable = true;     // Catch: Throwable -> L39
        r17.inSampleSize = r15;     // Catch: Throwable -> L39
        monitor-exit(r16);     // Catch: Throwable -> L39
        Bitmap r18 = loadBitmap(r10, r17);     // Catch: Throwable -> L30
        Object r19 = this.mLock;
        monitor-enter(r19);
        this.mDecodeOptions = null;     // Catch: Throwable -> L27
        monitor-exit(r19);     // Catch: Throwable -> L27
        return r18;
    L27:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mDecodeOptions = null;     // Catch: Throwable -> L36
        throw th;
    L36:
        th = move-exception;
        throw th;
    L39:
        th = move-exception;
        throw th;
    L42:
        return null;
    L44:
        throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }

    public void printBitmap(@NonNull String r10, @NonNull Bitmap r11) {
        printBitmap(r10, r11, null);
    }

    public void printBitmap(@NonNull String r10, @NonNull Bitmap r11, @Nullable OnPrintFinishCallback r12) {
        if (Build.VERSION.SDK_INT < 19) goto L12;
        if (r11 == null) goto L13;
        PrintManager r13 = (PrintManager) this.mContext.getSystemService("print");
        if (isPortrait(r11) == false) goto L9;
        PrintAttributes.MediaSize r14 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    L10:
        PrintAttributes r15 = new PrintAttributes.Builder().setMediaSize(r14).setColorMode(this.mColorMode).build();
        r13.print(r10, new PrintBitmapAdapter(this, r10, this.mScaleMode, r11, r12), r15);
        return;
    L9:
        r14 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        goto L10
    L13:
        return;
    }

    public void printBitmap(@NonNull String r10, @NonNull Uri r11) {
        printBitmap(r10, r11, null);
    }

    public void printBitmap(@NonNull String r10, @NonNull Uri r11, @Nullable OnPrintFinishCallback r12) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        PrintUriAdapter r13 = new PrintUriAdapter(this, r10, r11, r12, this.mScaleMode);
        PrintManager r14 = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder r15 = new PrintAttributes.Builder();
        r15.setColorMode(this.mColorMode);
        int r16 = this.mOrientation;
        if (r16 == 1) goto L12;
        if (r16 == 0) goto L12;
        if (r16 != 2) goto L14;
        PrintAttributes.MediaSize r17 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    L13:
        r15.setMediaSize(r17);
    L14:
        r14.print(r10, r13, r15.build());
        return;
    L12:
        r17 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        goto L13
    }

    public void setColorMode(int r10) {
        this.mColorMode = r10;
    }

    public void setOrientation(int r10) {
        this.mOrientation = r10;
    }

    public void setScaleMode(int r10) {
        this.mScaleMode = r10;
    }

    @RequiresApi(19)
    void writeBitmap(final PrintAttributes r12, final int r13, final Bitmap r14, final ParcelFileDescriptor r15, final CancellationSignal r16, final PrintDocumentAdapter.WriteResultCallback r17) {
        if (IS_MIN_MARGINS_HANDLING_CORRECT == false) goto L5;
        final PrintAttributes r10 = r12;
    L6:
        new AnonymousClass1(this, r16, r10, r14, r12, r13, r15, r17).execute(new Void[0]);
        return;
    L5:
        r10 = copyAttributes(r12).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        goto L6
    }
}
