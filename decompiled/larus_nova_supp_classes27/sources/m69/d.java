package m69;

import com.larus.audio.call.plugins.t0;
import com.larus.im.service.audio.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
    public b f;

    public static final class a extends z0 {
        public final /* synthetic */ d a;

        public final String g() {
            this.a.getClass();
            return "DoraLLMPlugin";
        }

        public a(d r1) {
            this.a = r1;
        }

        public final void n(z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r2, "event");
            c.a.e(r2);
        }
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final void a() {
            c.a.a();
        }

        public b() {
        }

        public final void b(Map<String, String> r2) {
            c.a.b(r2);
        }

        public final void i(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "audio");
            c.a.c(r2);
        }
    }

    public final String T2() {
        return "DoraLLMPlugin";
    }

    public final z0 S2() {
        return new a(this);
    }

    public final void e3() {
        super.e3();
        b r0 = new b();
        t0 r1 = getContext().c(Reflection.getOrCreateKotlinClass(t0.class), null);
        if (r1 == null) goto L7;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L7;
        r2.i(r0);
    L7:
        this.f = r0;
    }

    public final void g3() {
        super.g3();
        c.a.d(getContext().params().n.a);
        b r0 = this.f;
        if (r0 == null) goto L10;
        t0 r1 = getContext().c(Reflection.getOrCreateKotlinClass(t0.class), null);
        if (r1 == null) goto L11;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L12;
        r2.j(r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public d(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
