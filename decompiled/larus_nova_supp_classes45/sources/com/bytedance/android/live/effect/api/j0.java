package com.bytedance.android.live.effect.api;

import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0 {
    public final k a;

    public static final class a implements k.i {
        public final /* synthetic */ q a;

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void b() {
            this.a.b();
        }

        public a(q r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void a(EffectChannelResponse r2) {
            this.a.a(r2);
        }
    }

    public j0(k r2) {
        Intrinsics.checkNotNullParameter(r2, "effectService");
        this.a = r2;
    }

    public final void a(String r3, q r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.l(r3, new a(r4));
    }
}
