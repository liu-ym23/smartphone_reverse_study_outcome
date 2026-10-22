package com.larus.voicecall.impl.component.bottom;

import com.larus.av_call.model.RealtimePageMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.bottom.a$a, reason: collision with other inner class name */
    public static final class C0014a implements w3a.i {
        public final /* synthetic */ a a;

        public C0014a(a r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(w3a.h r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof w3a.j) == false) goto L6;
            w3a.j r3 = (w3a.j) r2;
            this.a.getClass();
            return;
        L6:
            if ((r2 instanceof w3a.a) == false) goto L10;
            a r0 = this.a;
            RealtimePageMode r4 = ((w3a.a) r2).a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "newMode");
            return;
        }
    }

    public a(w3a.k r2) {
        C0014a r0 = new C0014a(this);
        if (r2 == null) goto L6;
        r2.c(r0);
        return;
    }
}
