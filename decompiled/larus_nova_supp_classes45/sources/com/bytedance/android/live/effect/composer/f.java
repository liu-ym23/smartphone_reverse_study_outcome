package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdk.widget.u2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LiveComposerManagerB a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IFetchEffectListener c;

    public f(LiveComposerManagerB r1, String r2, u2.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        Pair r6 = (Pair) r5;
        this.a.a(this.b, (Sticker) r6.getSecond(), "ttlive_anchor_effect_LiveComposerManagerBloadStickerByEffectId");
        IFetchEffectListener r0 = this.c;
        if (r0 == null) goto L6;
        r0.onSuccess(r6.getFirst());
        return;
    }
}
