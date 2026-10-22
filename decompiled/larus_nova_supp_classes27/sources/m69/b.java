package m69;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;
import pf9.a0;
import pf9.c0;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
    public String f;

    public static final class a extends z0 {
        public final /* synthetic */ b a;

        public final String g() {
            this.a.getClass();
            return "DoraAsrPlugin";
        }

        public a(b r1) {
            this.a = r1;
        }

        public final void n(z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof z) == false) goto L6;
            this.a.f = "";
            m69.a.a.a("");
            return;
        L6:
            if ((r2 instanceof c0) == false) goto L13;
            b r0 = this.a;
            pf9.a r3 = ((c0) r2).a;
            if (r3 == null) goto L10;
            String r4 = r3.a;
        L11:
            r0.f = r4;
            m69.a.a.a(r4);
            return;
        L10:
            r4 = null;
            goto L11
        L13:
            if ((r2 instanceof a0) == false) goto L18;
            m69.a.a.a(this.a.f);
            return;
        }
    }

    public final String T2() {
        return "DoraAsrPlugin";
    }

    public final z0 S2() {
        return new a(this);
    }

    public final void g3() {
        super.g3();
        this.f = null;
    }

    public b(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
