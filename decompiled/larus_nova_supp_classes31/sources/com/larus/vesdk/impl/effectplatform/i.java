package com.larus.vesdk.impl.effectplatform;

import com.ss.ugc.effectplatform.EffectPlatform;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements IEffectPlatformBaseListener<EffectChannelResponse> {
    public final /* synthetic */ f a;
    public final /* synthetic */ EffectPlatform b;
    public final /* synthetic */ String c;

    public final void onSuccess(Object r3) {
        Intrinsics.checkNotNullParameter((EffectChannelResponse) r3, "response");
        System.out.println("EffectPlatformProvider: fetch loki success");
        f.b(this.a, this.b, this.c);
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        EffectChannelResponse r4 = (EffectChannelResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "exception");
        System.out.println("EffectPlatformProvider: fetch loki failed " + r3.getMsg());
    }

    public i(f r1, EffectPlatform r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
