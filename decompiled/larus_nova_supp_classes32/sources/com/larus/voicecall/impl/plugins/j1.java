package com.larus.voicecall.impl.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j1 extends com.larus.audio.call.arch.a<r> {
    public final String f;

    public static final class a extends com.larus.im.service.audio.a1 {
        public final String a;
        public final /* synthetic */ j1 b;

        public final String g() {
            return this.a;
        }

        public a(j1 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void q(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            int r4 = r2.hashCode();
            if (r4 == (-1381107413)) goto L22;
            if (r4 == 1624133454) goto L16;
            if (r4 == 2027072059) goto L10;
            return;
        L10:
            if (r2.equals("OTHER_EVENT_REQUEST_RETRIED_TOAST") == false) goto L34;
            com.larus.voicecall.impl.q r5 = ((r) this.b.getContext()).h();
            if (r5 == null) goto L28;
            r5.onReconnected();
            return;
        L28:
            return;
        L34:
            return;
        L16:
            if (r2.equals("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST") == false) goto L35;
            com.larus.voicecall.impl.q r6 = ((r) this.b.getContext()).h();
            if (r6 == null) goto L30;
            r6.onReconnect();
            return;
        L30:
            return;
        L35:
            return;
        L22:
            if (r2.equals("OTHER_EVENT_TASK_FAILED_TOAST") == false) goto L36;
            com.larus.voicecall.impl.q r7 = ((r) this.b.getContext()).h();
            if (r7 == null) goto L32;
            r7.h();
            return;
        L32:
            return;
        }
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public final String T2() {
        return this.f;
    }

    public j1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeCallUIEventPlugin";
    }
}
