package com.bytedance.android.live.effect.beauty.sticker;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements k.i {
    public final /* synthetic */ LiveStickerBeautyFragment a;

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void b() {
        LoadingStatusView r0 = this.a.S90(2131387337);
        if (r0 == null) goto L6;
        r0.showError();
        return;
    }

    public a(LiveStickerBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void a(EffectChannelResponse r7) {
        if (r7 == null) goto L5;
        List r1 = r7.getAllCategoryEffects();
    L6:
        List r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L18;
        LiveEffectMonitor.d(this.a.l, 1000, "Empty effect list");
        LoadingStatusView r8 = this.a.S90(2131387337);
        if (r8 == null) goto L32;
        r8.showError();
        return;
    L32:
        return;
    L18:
        List<String> r4 = LiveEffectContext.h;
        List r5 = CollectionsKt.toMutableList(LiveEffectContext.a.a(this.a.getType()).b().d().c(d0.f));
        if (r7 == null) goto L23;
        List r9 = r7.getAllCategoryEffects();
        if (r9 == null) goto L23;
    L24:
        r5.addAll(r9);
        LiveStickerListAdapter r11 = this.a.U90();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "effects");
        if (r11.i == true) goto L28;
        r11.i = true;
        ((ArrayList) r11.b).clear();
        ((ArrayList) r11.c).clear();
        ((ArrayList) r11.b).add(null);
        ((ArrayList) r11.c).add(0L);
        Observable.create(new g(r11, r5)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r11));
    L28:
        LoadingStatusView r12 = this.a.S90(2131387337);
        if (r12 == null) goto L34;
        r12.reset();
        return;
    L34:
        return;
    L23:
        r9 = CollectionsKt.emptyList();
        goto L24
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }
}
