package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 implements IFetchCategoryEffectListener {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.live.effect.api.k.e c;
    public final /* synthetic */ LiveStickerDataManager$fetchRewardEffectList$1 d;

    public final void onFail(ExceptionResult r2) {
        PthreadHandlerThreadV2 r3 = LiveEffectMonitor.a;
        LiveEffectMonitor.g(this.b, ColumnElement.typeLocalSimpleDivider);
        com.bytedance.android.live.effect.api.k.e r4 = this.c;
        if (r4 == null) goto L6;
        r4.onFetchFailed();
        return;
    }

    public final void onSuccess(Object r6) {
        CategoryPageModel r7 = (CategoryPageModel) r6;
        if (r7 == null) goto L7;
        CategoryEffectModel r8 = r7.getCategoryEffects();
        if (r8 == null) goto L7;
        List<Effect> r9 = r8.getEffects();
    L8:
        Map<String, List<Effect>> r1 = this.a.h;
        String r2 = this.b;
        if (r9 != null) goto L11;
        List<Effect> r3 = CollectionsKt.emptyList();
    L12:
        r1.put(r2, r3);
        if (r9 != null) goto L15;
    L18:
        PthreadHandlerThreadV2 r11 = LiveEffectMonitor.a;
        LiveEffectMonitor.g(this.b, 1000);
        com.bytedance.android.live.effect.api.k.e r12 = this.c;
        if (r12 == null) goto L23;
        r12.onFetchFailed();
        return;
    L23:
        return;
    L15:
        if (r9.isEmpty() == true) goto L18;
        this.d.invoke(r9);
        this.a.i.put(this.b, Long.valueOf(System.currentTimeMillis()));
        PthreadHandlerThreadV2 r13 = LiveEffectMonitor.a;
        String r14 = this.b;
        Intrinsics.checkNotNullParameter(r14, "panel");
        Intrinsics.checkNotNullParameter("", "extra");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GET_CAMPAIGN_STICKER, null, null, 14);
        r0.l(0);
        r0.c(r14);
        r0.i("extra", "");
        r0.a().report();
        return;
    L11:
        r3 = r9;
    L7:
        r9 = null;
        goto L8
    }

    public f0(LiveStickerDataManager r1, String r2, com.bytedance.android.live.effect.api.k.e r3, LiveStickerDataManager$fetchRewardEffectList$1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
