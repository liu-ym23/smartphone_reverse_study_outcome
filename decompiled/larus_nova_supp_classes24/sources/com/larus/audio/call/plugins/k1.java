package com.larus.audio.call.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k1 extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {

    public static final class a extends com.larus.im.service.audio.a1 {
        public final /* synthetic */ k1 a;

        public final String g() {
            this.a.getClass();
            return "RealtimeModelProactivePlugin";
        }

        public a(k1 r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof pf9.d0) == true) goto L5;
            return;
        L5:
            if (((pf9.d0) r3).b == false) goto L9;
            com.larus.audio.call.util.e r4 = com.larus.audio.call.util.e.a;
            this.a.getClass();
            r4.i("RealtimeModelProactivePlugin", "model proactive speak");
            com.larus.audio.call.arch.b.a(this.a.getContext()).e0().d(true, true, "model proactive");
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "RealtimeModelProactivePlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public k1(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
