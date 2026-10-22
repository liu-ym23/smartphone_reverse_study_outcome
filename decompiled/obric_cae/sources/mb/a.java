package mb;

import android.util.Log;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static C0116a f9321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0116a f9322b = null;

    /* JADX INFO: renamed from: mb.a$a, reason: collision with other inner class name */
    public static final class C0116a {
        public final void a(String r8, String r10) {
            i.f(r10, "msg");
            Log.i("OEA_SDK", r8 + "->" + r10);
        }
    }

    static {
        f9322b = new C0116a();
    }

    public static void a(String r8, String r10) {
        i.f(r10, "msg");
        if (f9321a == null) goto L6;
        Log.d("OEA_SDK", r8 + "->" + r10);
        return;
    }

    public static void b(String r8) {
        i.f(r8, "msg");
        Log.e("OEA_SDK", "SmoothCornerHelper->".concat(r8), null);
    }

    public static void c(String r8) {
        i.f(r8, "msg");
        C0116a r10 = f9321a;
        if (r10 == null) goto L6;
        r10.a("AnimatableRunner", r8);
        return;
    }

    public static void d(String r8, String r10) {
        i.f(r10, "msg");
        C0116a r11 = f9321a;
        if (r11 != null) goto L6;
        r11 = f9322b;
    L6:
        r11.a(r8, r10);
    }

    public static void e(String r8) {
        i.f(r8, "msg");
        if (f9321a == null) goto L6;
        Log.v("OEA_SDK", "AnimationLifecycleListener->".concat(r8));
        return;
    }
}
