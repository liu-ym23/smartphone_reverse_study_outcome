package com.bytedance.android.live.effect.soundeffect;

import com.bytedance.android.live.effect.api.k;
import com.bytedance.common.utility.Lists;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements k.i {
    public final /* synthetic */ LiveSoundEffectHelper a;
    public final /* synthetic */ LiveSoundEffectHelper.c b;

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void b() {
        this.a.getClass();
        LiveSoundEffectHelper.c r0 = this.b;
        if (r0 == null) goto L6;
        r0.onError();
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void a(EffectChannelResponse r4) {
        if (r4 != null) goto L4;
    L8:
        LiveSoundEffectHelper.c r5 = this.b;
        if (r5 == null) goto L12;
        r5.onError();
        return;
    L12:
        return;
    L4:
        if (Lists.isEmpty(r4.getAllCategoryEffects()) == true) goto L8;
        LiveSoundEffectHelper r0 = this.a;
        List r6 = r4.getAllCategoryEffects();
        LiveSoundEffectHelper.c r1 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "list");
        r0.a.clear();
        com.bytedance.android.live.effect.sticker.d.e(r6).subscribe(new f(r0, r1));
    }

    public e(LiveSoundEffectHelper r1, LiveSoundEffectHelper.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
