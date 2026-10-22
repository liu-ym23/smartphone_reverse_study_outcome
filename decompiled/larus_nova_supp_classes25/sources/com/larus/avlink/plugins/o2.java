package com.larus.avlink.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o2 extends com.larus.audio.call.arch.a<n4> implements com.larus.audio.call.arch.e {
    public final String f;
    public final List<Pair<TriggerMode, String>> g;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ o2 b;

        public final String getName() {
            return this.a;
        }

        public b(o2 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            if ((r5 instanceof jd9.c.a) == false) goto L20;
            o2 r6 = this.b;
            if (((ArrayList) r6.g).isEmpty() == true) goto L21;
            com.larus.avlink.n1.d(r6.f, "resendPendingNoiseControlTrigger size=" + ((ArrayList) r6.g).size());
            Iterator r7 = ((ArrayList) r6.g).iterator();
        L9:
            if (r7.hasNext() == false) goto L13;
            Pair r0 = (Pair) r7.next();
            TriggerMode r1 = (TriggerMode) r0.component1();
            String r2 = (String) r0.component2();
            id9.d r3 = ((n4) r6.getContext()).j();
            if (r3 == null) goto L9;
            r3.p(r1, r2);
            goto L9
        L13:
            ((ArrayList) r6.g).clear();
            return;
        L21:
            return;
        }
    }

    public static final class c extends com.larus.im.service.audio.a1 {
        public final String a;
        public final /* synthetic */ o2 b;

        public final String g() {
            return this.a;
        }

        public c(o2 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r12) {
            Intrinsics.checkNotNullParameter(r12, "event");
            if ((r12 instanceof pf9.q) == false) goto L39;
            o2 r0 = this.b;
            r0.getClass();
            Iterator r13 = ((pf9.q) r12).a.iterator();
        L6:
            if (r13.hasNext() == false) goto L59;
            pf9.p r1 = (pf9.p) r13.next();
            Long r2 = r1.a;
            if (r2 == null) goto L6;
            if (((int) r2.longValue()) != 900) goto L6;
            Map r3 = r1.b;
            if (r3 == null) goto L14;
            String r4 = (String) r3.get("mode");
        L15:
            com.larus.avlink.n1.d(r0.f, "DORA_NOISE_CONTROL mode=" + r4);
            if (r4 == null) goto L6;
            int r5 = r4.hashCode();
            if (r5 == (-2027160035)) goto L33;
            if (r5 == 94756344) goto L29;
            if (r5 != 929339181) goto L34;
            if (r4.equals("open_transparency") == false) goto L34;
            int r6 = 2;
        L36:
            CoroutineScope r7 = ((n4) r0.getContext()).r();
            if (r7 == null) goto L6;
            BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new DoraNoiseControlPlugin$handleNoiseControl$1(r6, r0, r4, null), 2, null);
        L34:
            com.larus.avlink.n1.d(r0.f, "handleNoiseControl unknown mode=".concat(r4));
            goto L6
        L29:
            if (r4.equals("close") == false) goto L34;
            r6 = 0;
            goto L36
        L33:
            if (r4.equals("open_noise_cancellation") == false) goto L34;
            r6 = 1;
            goto L36
        L14:
            r4 = null;
            goto L15
        L59:
            return;
        }
    }

    static {
    }

    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    public final String T2() {
        return this.f;
    }

    public o2(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraNoiseControlPlugin";
        this.g = new ArrayList();
    }
}
