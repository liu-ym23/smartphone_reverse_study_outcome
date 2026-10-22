package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.effect.soundeffect.LiveSoundAdapter;
import com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.SingleEmitter;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l1 implements LiveSoundEffectHelper.b {
    public final /* synthetic */ LiveSoundEffectHelper a;
    public final /* synthetic */ SingleEmitter b;

    public final void x1(int r1, LiveSoundAdapter.ViewHolder r2) {
    }

    public final void onError() {
        this.b.onSuccess(TuplesKt.to(1, "download failed"));
    }

    public final void a(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        this.a.b(r4, true, false);
        this.b.onSuccess(TuplesKt.to(0, "success"));
    }

    public l1(LiveSoundEffectHelper r1, SingleEmitter r2) {
        this.a = r1;
        this.b = r2;
    }
}
