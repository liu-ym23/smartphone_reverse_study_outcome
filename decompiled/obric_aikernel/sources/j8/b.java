package j8;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import n8.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<d> f9788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<View, a<?>> f9789b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9790c = null;

    static {
        f9790c = new b();
        f9788a = new ArrayList();
        f9789b = new WeakHashMap();
    }

    private b() {
    }

    public final void a(View r10, a<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "animationInfo");
        f9789b.put(r10, r11);
    }

    public final void b(d r10) {
        Intrinsics.checkNotNullParameter(r10, "animationManager");
        ArrayList<d> r11 = f9788a;
        r11.add(r10);
        t8.b.f12973c.g("AnimationLifecycleListener", "addAnimationManager, size: " + r11.size());
    }

    public final a<?> c(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        return f9789b.get(r10);
    }

    public final void d(d r10) {
        Intrinsics.checkNotNullParameter(r10, "animationManager");
        ArrayList<d> r11 = f9788a;
        r11.remove(r10);
        t8.b.f12973c.g("AnimationLifecycleListener", "removeAnimationManager, size: " + r11.size());
    }
}
