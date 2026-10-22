package l5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f19538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Bitmap f19539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f19540c = 0.0f;

    static {
        f19538a = Bitmap.Config.ARGB_8888;
        f19540c = 0.1f;
    }

    public static android.support.v4.media.c a(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        android.support.v4.media.c r5 = new android.support.v4.media.c();
        float r11 = r10.getWidth();
        float r12 = f19540c;
        int r13 = (int) ((r11 * r12) + 0.5f);
        int r14 = (int) ((r10.getHeight() * r12) + 0.5f);
        if (r13 <= 0) goto L5;
        if (r14 <= 0) goto L5;
    L6:
        Bitmap r15 = f19539b;
        if (r15 == null) goto L15;
        Intrinsics.checkNotNull(r15);
        if (r15.isRecycled() == true) goto L15;
        Bitmap r16 = f19539b;
        Intrinsics.checkNotNull(r16);
        if (r16.getWidth() != r13) goto L15;
        Bitmap r17 = f19539b;
        Intrinsics.checkNotNull(r17);
        if (r17.getHeight() != r14) goto L15;
        Log.i("WebViewShotService", "hit cache");
        Bitmap r18 = f19539b;
        boolean r19 = false;
    L16:
        if (r18 != null) goto L18;
        r18 = Bitmap.createBitmap(r10.getContext().getResources().getDisplayMetrics(), r13, r14, f19538a);
    L18:
        if (r18 == null) goto L27;
        Canvas r20 = new Canvas(r18);
        r20.scale(r12, r12);
        r10.computeScroll();
        r20.translate(-r10.getScrollX(), -r10.getScrollY());
        r10.draw(r20);
        if (r19 == false) goto L26;
        Bitmap r21 = f19539b;
        if (r21 == null) goto L26;
        Intrinsics.checkNotNull(r21);
        if (r21.isRecycled() == true) goto L26;
        Bitmap r22 = f19539b;
        Intrinsics.checkNotNull(r22);
        r22.recycle();
    L26:
        f19539b = r18;
    L27:
        r5.f367a = r18;
        return r5;
    L15:
        r18 = null;
        r19 = true;
    L5:
        r13 = r10.getWidth();
        r14 = r10.getHeight();
        goto L6
    }
}
