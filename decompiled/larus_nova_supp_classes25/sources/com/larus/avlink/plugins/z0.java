package com.larus.avlink.plugins;

import com.larus.platform.model.LocateScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z0 extends com.larus.audio.call.arch.a<n4> {

    public static final class a extends com.larus.im.service.audio.z0 {
        public final /* synthetic */ z0 a;

        public final String g() {
            this.a.getClass();
            return "DoraLocationPlugin";
        }

        public a(z0 r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof pf9.z) == false) goto L6;
            com.larus.platform.service.l1.a.a(LocateScene.DORA_G_ASR, null);
            return;
        }
    }

    public final String T2() {
        return "DoraLocationPlugin";
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public z0(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
