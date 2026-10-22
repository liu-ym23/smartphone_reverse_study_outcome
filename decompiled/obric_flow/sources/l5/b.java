package l5;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.crash.upload.k;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f19537a = null;

    static {
        k r5 = new k();
        r5.f4136a = 0;
        f19537a = r5;
    }

    public static a a(WebView r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        a r5 = new a();
        Context r10 = r12.getContext();
        if (r10 != null) goto L5;
    L23:
        r5.e = 4;
        r5.f = "context or context.getResources is null";
        r5.f19534a = 3;
        return r5;
    L5:
        if (r10.getResources() == null) goto L23;
        int r11 = r12.getWidth();
        int r13 = r12.getHeight();
        if (r11 <= 0) goto L21;
        if (r13 <= 0) goto L21;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L15;
        r5.e = 2;
        r5.f = "current thread is not main thread.";
        r5.f19534a = 3;
        return r5;
    L15:
        long r14 = System.currentTimeMillis();
        android.support.v4.media.c r15 = c.a(r12);     // Catch: Throwable -> L18
        r5.f19536c = System.currentTimeMillis() - r14;     // Catch: Throwable -> L18
        b((Bitmap) r15.f367a, r5);     // Catch: Throwable -> L18
        r5.f19535b = (System.currentTimeMillis() - r14) - r5.f19536c;     // Catch: Throwable -> L18
        r5.d = System.currentTimeMillis() - r14;     // Catch: Throwable -> L18
        return r5;
    L18:
        th = move-exception;
        Log.e("WebViewBlankDetector", "isViewPureColor", th);
        r5.e = 4;
        r5.f = th.getMessage();
        r5.f19534a = 3;
        r5.d = System.currentTimeMillis() - r14;
        return r5;
    L21:
        Log.w("WebViewBlankDetector", "width and height must be > 0");
        r5.e = 4;
        r5.f = "width and height must be > 0";
        r5.f19534a = 3;
        return r5;
    }

    public static void b(Bitmap r18, a r19) {
        if (r18 == null) goto L28;
        r18.getConfig();
        int r5 = r18.getWidth();
        int r10 = r18.getHeight();
        if (r5 <= 0) goto L32;
        if (r10 <= 0) goto L33;
        int r11 = r18.getPixel(0, 0);
        k r12 = f19537a;
        r12.f4136a = r11;
        int r13 = r18.getWidth();
        int r14 = r18.getHeight();
        int r15 = 1;
        if (r13 <= 0) goto L22;
        if (r14 <= 0) goto L22;
        int r16 = r12.f4136a;
        if (r16 != 0) goto L13;
        r16 = r18.getPixel(0, 0);
    L13:
        int r17 = r16;
        int[] r110 = new int[r13];
        Arrays.fill(r110, r17);
        int[] r20 = new int[r13];
        int r21 = 0;
    L14:
        if (r21 >= r14) goto L19;
        int r111 = r21;
        int[] r112 = r20;
        r18.getPixels(r20, 0, r13, 0, r21, r13, 1);
        if (Arrays.equals(r110, r112) == false) goto L17;
        r21 = r111 + 1;
        r20 = r112;
        goto L14
    L17:
        boolean r113 = false;
    L20:
        if (r113 == false) goto L23;
        Log.i("WebViewPixelChecker", "PixBlankDetector detect white screen , color : " + Integer.toHexString(r17));
    L23:
        if (r113 == true) goto L26;
        r15 = 2;
    L26:
        r19.f19534a = r15;
        return;
    L19:
        r113 = true;
    L22:
        r113 = false;
        goto L23
    L33:
        return;
    L32:
        return;
    L28:
        r19.e = 3;
        r19.f = "bitmap is null.";
        r19.f19534a = 3;
    }
}
