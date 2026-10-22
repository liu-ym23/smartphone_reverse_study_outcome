package oh;

import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: oh.a$a, reason: collision with other inner class name */
    public static final class C0184a implements w {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ String b;

        public final k r() {
            r r0 = new r();
            r0.c = true;
            return r0.g.b();
        }

        public final void run() {
            this.a.run();
            System.out.println("Django: Task: event async: " + this.b);
        }

        public C0184a(Runnable r1, String r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class b implements w {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ String b;

        public final k r() {
            r r0 = new r();
            r0.b = true;
            return r0.f;
        }

        public final void run() {
            this.a.run();
            System.out.println("Django: Task: fps event async: " + this.b);
        }

        public b(Runnable r1, String r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final void a(Runnable r1) {
        Intrinsics.checkNotNullParameter(r1, "runnable");
        b("", r1);
    }

    public static final void b(String r1, Runnable r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r10, "runnable");
        r10.run();
    }

    public static final void c(String r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "runnable");
        if (c.q() != 1) goto L5;
        t.b(new C0184a(r11, r10));
        return;
    L5:
        r11.run();
    }

    public static final void d(String r1, Runnable r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r10, "runnable");
        t.b(new b(r10, r1));
    }
}
