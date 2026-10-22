package hda;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 {
    public static final Bitmap b(Context r4, Uri r5, BitmapFactory.Options r6) {
        String r0 = r5.getScheme();
        if (r0 == null) goto L29;
        int r1 = r0.hashCode();
        if (r1 == 0) goto L27;
        if (r1 == 3143036) goto L23;
        if (r1 == 951530617) goto L12;
        return null;
    L12:
        if (r0.equals(LynxAccessibilityModule.MSG_CONTENT) == false) goto L38;
        InputStream r7 = ContentResolverWrapper.openInputStream(r4.getContentResolver(), r5);
        if (r7 == null) goto L39;
        Bitmap r8 = BitmapFactory.decodeStream(r7, null, r6);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r7, null);
        return r8;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L39:
        return null;
    L38:
        return null;
    L23:
        if (r0.equals("file") == true) goto L41;
        return null;
    L41:
        return BitmapFactory.decodeFile(r5.getPath(), r6);
    L27:
        if (r0.equals(NameKeys.UnloadStrategy_No_Strategy) == true) goto L29;
        return null;
    L29:
        String r9 = r5.getPath();
        if (r9 != null) goto L33;
        r9 = r5.toString();
    L33:
        return BitmapFactory.decodeFile(r9, r6);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [hda.d0, java.lang.Object] */
    public static final void d(ImageView r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "uriText");
        if (StringsKt.isBlank(r9) == false) goto L6;
        r8.setImageDrawable(null);
        return;
    L6:
        final Uri r0 = UriProtector.parse(r9);
        int r3 = 0;
        if (r10 == false) goto L10;
        Resources r5 = r8.getResources();
        int r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels;
    L22:
        if (r10 == false) goto L25;
        Resources r4 = r8.getResources();
        r3 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels;
    L36:
        final i0 r2 = new i0(r9, r10, r6, r3);
        r8.setTag(r2.e);
        Handler r11 = c0.a;
        final Context r12 = r8.getContext().getApplicationContext();
        final ?? r13 = new d0(r0);
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r8, "target");
        Intrinsics.checkNotNullParameter(r13, "fallback");
        Bitmap r1 = c0.d.get(r2.e);
        if (r1 == null) goto L39;
        r8.setImageBitmap(r1);
        return;
    L39:
        r8.setImageDrawable(null);
        final WeakReference r7 = new WeakReference(r8);
        c0.c.execute(new a0(r2, r12, r7, r13));
        return;
    L25:
        if (r8.getHeight() <= 0) goto L27;
        r3 = r8.getHeight();
        goto L36
    L27:
        Object r14 = r8.getParent();
        if ((r14 instanceof View) == false) goto L30;
        View r15 = (View) r14;
    L31:
        if (r15 == null) goto L33;
        r3 = r15.getHeight();
    L33:
        if (r3 > 0) goto L36;
        Resources r16 = r8.getResources();
        r3 = RangesKt.coerceAtLeast((int) (WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).widthPixels * 0.72f), 240);
        goto L36
    L30:
        r15 = null;
        goto L31
    L10:
        if (r8.getWidth() <= 0) goto L12;
        r6 = r8.getWidth();
        goto L22
    L12:
        Object r17 = r8.getParent();
        if ((r17 instanceof View) == false) goto L15;
        View r18 = (View) r17;
    L16:
        if (r18 == null) goto L18;
        r6 = r18.getWidth();
    L19:
        if (r6 > 0) goto L22;
        Resources r19 = r8.getResources();
        r6 = RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r19, r19.getDisplayMetrics()).widthPixels / 2, 240);
        goto L22
    L18:
        r6 = 0;
        goto L19
    L15:
        r18 = null;
        goto L16
    }

    public static final Bitmap a(Context r4, Uri r5, final int r6, final int r7) {
        if (Build.VERSION.SDK_INT < 28) goto L33;
        String r0 = r5.getScheme();
        if (r0 == null) goto L26;
        int r1 = r0.hashCode();
        if (r1 == 0) goto L24;
        if (r1 == 3143036) goto L17;
        if (r1 == 951530617) goto L14;
    L25:
        ImageDecoder.Source r8 = null;
    L30:
        if (r8 != null) goto L40;
        return null;
    L40:
        return ImageDecoder.decodeBitmap(r8, new e0(r6, r7));
    L14:
        if (r0.equals(LynxAccessibilityModule.MSG_CONTENT) == false) goto L25;
        r8 = ImageDecoder.createSource(r4.getContentResolver(), r5);
        goto L30
    L17:
        if (r0.equals("file") == false) goto L25;
        String r9 = r5.getPath();
        if (r9 == null) goto L25;
        r8 = ImageDecoder.createSource(new PolarisFileWrapper(r9));
        goto L30
    L24:
        if (r0.equals(NameKeys.UnloadStrategy_No_Strategy) == false) goto L25;
    L26:
        String r2 = r5.getPath();
        if (r2 != null) goto L29;
        r2 = r5.toString();
    L29:
        r8 = ImageDecoder.createSource(new PolarisFileWrapper(r2));
        goto L30
    L33:
        BitmapFactory.Options r3 = new BitmapFactory.Options();
        r3.inJustDecodeBounds = true;
        b(r4, r5, r3);
        if (r3.outWidth > 0) goto L36;
        return null;
    L36:
        if (r3.outHeight <= 0) goto L43;
        BitmapFactory.Options r10 = new BitmapFactory.Options();
        r10.inSampleSize = c(r3.outWidth, r3.outHeight, r6, r7);
        r10.inPreferredConfig = Bitmap.Config.RGB_565;
        return b(r4, r5, r10);
    L43:
        return null;
    }

    public static final int c(int r4, int r5, int r6, int r7) {
        if (r4 <= 0) goto L16;
        if (r5 <= 0) goto L16;
        if (r6 <= 0) goto L16;
        if (r7 <= 0) goto L16;
        int r1 = 1;
    L9:
        int r2 = r1 * 2;
        if ((r4 / r2) < r6) goto L15;
        if ((r5 / r2) < r7) goto L15;
        r1 = r2;
    L15:
        return RangesKt.coerceAtLeast(r1, 1);
    L16:
        return 1;
    }
}
