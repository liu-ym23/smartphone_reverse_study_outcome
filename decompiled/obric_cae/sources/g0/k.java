package g0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n.f<String, Typeface> f7520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f7521b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f7522c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n.h<String, ArrayList<i0.a<a>>> f7523d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f7524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7525b;

        public a(int r8) {
            this.f7524a = null;
            this.f7525b = r8;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface r8) {
            this.f7524a = r8;
            this.f7525b = 0;
        }
    }

    static {
        f7520a = new n.f(16);
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(0, 1, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n());
        r8.allowCoreThreadTimeOut(true);
        f7521b = r8;
        f7522c = new Object();
        f7523d = new n.h();
    }

    public static a a(String r8, Context r10, f r11, int r12) {
        n.f<String, Typeface> r13 = f7520a;
        Typeface r14 = r13.a(r8);
        if (r14 != null) goto L5;
        l r15 = e.a(r10, r11);     // Catch: PackageManager.NameNotFoundException -> L34
        int r16 = 1;
        m[] r17 = r15.f7527b;
        int r18 = r15.f7526a;
        if (r18 == 0) goto L12;
        if (r18 != 1) goto L21;
        int r19 = -2;
    L25:
        if (r19 != 0) goto L27;
        Typeface r20 = a0.e.a(r10, r17, r12);
        if (r20 == null) goto L33;
        r13.b(r8, r20);
        return new a(r20);
    L33:
        return new a(-3);
    L27:
        return new a(r19);
    L21:
        r19 = -3;
        goto L25
    L12:
        if (r17 != null) goto L14;
    L24:
        r19 = r16;
        goto L25
    L14:
        if (r17.length == 0) goto L24;
        int r21 = r17.length;
        r16 = 0;
        int r22 = 0;
    L17:
        if (r22 >= r21) goto L24;
        int r23 = r17[r22].f7532e;
        if (r23 != 0) goto L20;
        r22 = r22 + 1;
        goto L17
    L20:
        if (r23 < 0) goto L21;
        r19 = r23;
    L35:
        return new a(-1);
    L5:
        return new a(r14);
    }
}
