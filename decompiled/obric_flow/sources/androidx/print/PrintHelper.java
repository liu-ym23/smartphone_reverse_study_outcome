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
import java.io.FileNotFoundException;
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
    public class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;
        final /* synthetic */ PrintHelper this$0;

        public PrintBitmapAdapter(PrintHelper r5, String r10, int r11, Bitmap r12, OnPrintFinishCallback r13) {
            this.this$0 = r5;
            this.mJobName = r10;
            this.mFittingMode = r11;
            this.mBitmap = r12;
            this.mCallback = r13;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback r5 = this.mCallback;
            if (r5 == null) goto L6;
            r5.onFinish();
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes r5, PrintAttributes r10, CancellationSignal r11, PrintDocumentAdapter.LayoutResultCallback r12, Bundle r13) {
            this.mAttributes = r10;
            r12.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r10.equals(r5));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r10, ParcelFileDescriptor r11, CancellationSignal r12, PrintDocumentAdapter.WriteResultCallback r13) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r11, r12, r13);
        }
    }

    @RequiresApi(19)
    public class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        final /* synthetic */ PrintHelper this$0;

        public PrintUriAdapter(PrintHelper r5, String r10, Uri r11, OnPrintFinishCallback r12, int r13) {
            this.this$0 = r5;
            this.mJobName = r10;
            this.mImageFile = r11;
            this.mCallback = r12;
            this.mFittingMode = r13;
            this.mBitmap = null;
        }

        public void cancelLoad() {
            Object r5 = this.this$0.mLock;
            monitor-enter(r5);
            PrintHelper r10 = this.this$0;     // Catch: Throwable -> L7
            if (r10.mDecodeOptions == null) goto L9;
            r10.mDecodeOptions = null;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r5);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> r5 = this.mLoadBitmap;
            if (r5 == null) goto L5;
            r5.cancel(true);
        L5:
            OnPrintFinishCallback r10 = this.mCallback;
            if (r10 == null) goto L8;
            r10.onFinish();
        L8:
            Bitmap r11 = this.mBitmap;
            if (r11 == null) goto L12;
            r11.recycle();
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
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = true;
        IS_MIN_MARGINS_HANDLING_CORRECT = true;
    }

    public PrintHelper(@NonNull Context r5) {
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = r5;
    }

    public static Bitmap convertBitmapForColorMode(Bitmap r5, int r10) {
        if (r10 == 1) goto L5;
        return r5;
    L5:
        Bitmap r11 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r12 = new Canvas(r11);
        Paint r13 = new Paint();
        ColorMatrix r14 = new ColorMatrix();
        r14.setSaturation(0.0f);
        r13.setColorFilter(new ColorMatrixColorFilter(r14));
        r12.drawBitmap(r5, 0.0f, 0.0f, r13);
        r12.setBitmap(null);
        return r11;
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder copyAttributes(PrintAttributes r5) {
        PrintAttributes.Builder r10 = new PrintAttributes.Builder().setMediaSize(r5.getMediaSize()).setResolution(r5.getResolution()).setMinMargins(r5.getMinMargins());
        if (r5.getColorMode() == 0) goto L6;
        r10.setColorMode(r5.getColorMode());
    L6:
        if (r5.getDuplexMode() == 0) goto L8;
        r10.setDuplexMode(r5.getDuplexMode());
    L8:
        return r10;
    }

    public static Matrix getMatrix(int r5, int r10, RectF r11, int r12) {
        Matrix r13 = new Matrix();
        float r14 = r5;
        float r15 = r11.width() / r14;
        if (r12 != 2) goto L5;
        float r16 = Math.max(r15, r11.height() / r10);
    L6:
        r13.postScale(r16, r16);
        r13.postTranslate((r11.width() - (r14 * r16)) / 2.0f, (r11.height() - (r10 * r16)) / 2.0f);
        return r13;
    L5:
        r16 = Math.min(r15, r11.height() / r10);
        goto L6
    }

    public static boolean isPortrait(Bitmap r5) {
        if (r5.getWidth() > r5.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    private Bitmap loadBitmap(Uri r5, BitmapFactory.Options r10) throws FileNotFoundException {
        if (r5 == null) goto L25;
        Context r11 = this.mContext;
        if (r11 == null) goto L25;
        InputStream r12 = null;
        InputStream r13 = r11.getContentResolver().openInputStream(r5);     // Catch: Throwable -> L17
        Bitmap r14 = BitmapFactory.decodeStream(r13, null, r10);     // Catch: Throwable -> L15
        if (r13 != null) goto L30;
    L14:
        return r14;
    L30:
        r13.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Log.w(LOG_TAG, "close fail ", e);
    L15:
        th = th;
        r12 = r13;
    L18:
        if (r12 != null) goto L32;
    L23:
        throw th;
    L32:
        r12.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        Log.w(LOG_TAG, "close fail ", e);
    L17:
        th = th;
    L25:
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        int r5 = this.mOrientation;
        if (r5 != 0) goto L6;
        return 1;
    L6:
        return r5;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public Bitmap loadConstrainedBitmap(Uri r10) throws FileNotFoundException {
        if (r10 == null) goto L44;
        if (this.mContext == null) goto L44;
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        r5.inJustDecodeBounds = true;
        loadBitmap(r10, r5);
        int r11 = r5.outWidth;
        int r12 = r5.outHeight;
        if (r11 <= 0) goto L42;
        if (r12 <= 0) goto L42;
        int r13 = Math.max(r11, r12);
        int r14 = 1;
    L11:
        if (r13 <= MAX_PRINT_SIZE) goto L13;
        r13 = r13 >>> 1;
        r14 = r14 << 1;
        goto L11
    L13:
        if (r14 <= 0) goto L42;
        if ((Math.min(r11, r12) / r14) <= 0) goto L42;
        Object r15 = this.mLock;
        monitor-enter(r15);
        BitmapFactory.Options r16 = new BitmapFactory.Options();     // Catch: Throwable -> L39
        this.mDecodeOptions = r16;     // Catch: Throwable -> L39
        r16.inMutable = true;     // Catch: Throwable -> L39
        r16.inSampleSize = r14;     // Catch: Throwable -> L39
        monitor-exit(r15);     // Catch: Throwable -> L39
        Bitmap r17 = loadBitmap(r10, r16);     // Catch: Throwable -> L30
        Object r18 = this.mLock;
        monitor-enter(r18);
        this.mDecodeOptions = null;     // Catch: Throwable -> L27
        monitor-exit(r18);     // Catch: Throwable -> L27
        return r17;
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

    public void printBitmap(@NonNull String r5, @NonNull Bitmap r10) {
        printBitmap(r5, r10, null);
    }

    public void setColorMode(int r5) {
        this.mColorMode = r5;
    }

    public void setOrientation(int r5) {
        this.mOrientation = r5;
    }

    public void setScaleMode(int r5) {
        this.mScaleMode = r5;
    }

    @RequiresApi(19)
    public void writeBitmap(final PrintAttributes r12, final int r13, final Bitmap r14, final ParcelFileDescriptor r15, final CancellationSignal r16, final PrintDocumentAdapter.WriteResultCallback r17) {
        if (IS_MIN_MARGINS_HANDLING_CORRECT == false) goto L5;
        final PrintAttributes r5 = r12;
    L6:
        new AnonymousClass1(this, r16, r5, r14, r12, r13, r15, r17).execute(new Void[0]);
        return;
    L5:
        r5 = copyAttributes(r12).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        goto L6
    }

    public void printBitmap(@NonNull String r10, @NonNull Bitmap r11, @Nullable OnPrintFinishCallback r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        PrintManager r5 = (PrintManager) this.mContext.getSystemService("print");
        if (isPortrait(r11) == false) goto L7;
        PrintAttributes.MediaSize r13 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    L8:
        PrintAttributes r14 = new PrintAttributes.Builder().setMediaSize(r13).setColorMode(this.mColorMode).build();
        r5.print(r10, new PrintBitmapAdapter(this, r10, this.mScaleMode, r11, r12), r14);
        return;
    L7:
        r13 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        goto L8
    }

    public void printBitmap(@NonNull String r5, @NonNull Uri r10) throws FileNotFoundException {
        printBitmap(r5, r10, null);
    }

    public void printBitmap(@NonNull String r10, @NonNull Uri r11, @Nullable OnPrintFinishCallback r12) throws FileNotFoundException {
        PrintUriAdapter r13 = new PrintUriAdapter(this, r10, r11, r12, this.mScaleMode);
        PrintManager r14 = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder r15 = new PrintAttributes.Builder();
        r15.setColorMode(this.mColorMode);
        int r16 = this.mOrientation;
        if (r16 == 1) goto L9;
        if (r16 == 0) goto L9;
        if (r16 != 2) goto L10;
        r15.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
    L10:
        r14.print(r10, r13, r15.build());
        return;
    L9:
        r15.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        goto L10
    }
}
