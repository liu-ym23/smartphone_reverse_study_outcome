package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$h implements IEffectPlatformBaseListener<EffectChannelResponse> {
    public final /* synthetic */ EffectPlatform a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ IEffectPlatformBaseListener c;

    public final void onSuccess(Object r9) {
        EffectChannelResponse r10 = (EffectChannelResponse) r9;
        EffectPlatform.access$getEffectListStore$p(this.a).a.a = r10;
        if (this.b == false) goto L5;
        List r3 = EffectPlatform.access$getNeedDownloadEffectList(this.a, r10.getAll_category_effects());
        EffectPlatform.downloadEffectList$default(this.a, r3, new d(this, r10), null, 4, null);
        return;
    L5:
        IEffectPlatformBaseListener r0 = this.c;
        if (r0 == null) goto L10;
        r0.onSuccess(r10);
        return;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        EffectChannelResponse r4 = (EffectChannelResponse) r2;
        IEffectPlatformBaseListener r0 = this.c;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }

    public EffectPlatform$h(EffectPlatform r1, boolean r2, IEffectPlatformBaseListener r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
