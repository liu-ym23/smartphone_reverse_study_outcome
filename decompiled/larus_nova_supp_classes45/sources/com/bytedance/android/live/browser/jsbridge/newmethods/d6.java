package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetLiveEffectInfoResultModel;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListByIdsListener;
import com.ss.android.ugc.effectmanager.effect.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d6 implements IFetchEffectListByIdsListener {
    public final /* synthetic */ f6 a;

    public d6(f6 r1) {
        this.a = r1;
    }

    public final void onFail(ExceptionResult r1) {
        this.a.finishWithFailure();
    }

    public final void onSuccess(Object r8) {
        EffectListResponse r9 = (EffectListResponse) r8;
        LiveGetLiveEffectInfoResultModel r0 = new LiveGetLiveEffectInfoResultModel();
        r0.a(LiveGetLiveEffectInfoResultModel.Code.Success);
        LiveGetLiveEffectInfoResultModel.a r1 = new LiveGetLiveEffectInfoResultModel.a();
        if (r9 == null) goto L17;
        List r11 = r9.getEffect_list();
        if (r11 == null) goto L17;
        List r12 = r11;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        Effect r3 = (Effect) r13.next();
        LiveGetLiveEffectInfoResultModel.b r4 = new LiveGetLiveEffectInfoResultModel.b();
        Sticker r5 = com.bytedance.android.live.effect.sticker.d.b(new com.ss.android.ugc.effectmanager.effect.model.Effect(r3));
        r4.c(r5.getEffectId());
        r4.f(r5.getName());
        r4.a(Long.valueOf(r5.getDefaultDuration()));
        UrlModel r6 = r5.getIcon();
        if (r6 == null) goto L15;
        List<String> r7 = r6.getUrlList();
        if (r7 == null) goto L15;
        String r14 = (String) CollectionsKt.firstOrNull(r7);
        if (r14 == null) goto L15;
    L16:
        r4.d(r14);
        r4.e(LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue());
        r4.b(Boolean.valueOf(r5.enableCustomizeDuration()));
        r2.add(r4);
    L15:
        r14 = "";
    L18:
        r1.a(r2);
        Unit r15 = Unit.INSTANCE;
        r0.b(r1);
        this.a.finishWithResult(r0);
        return;
    L17:
        r2 = null;
        goto L18
    }
}
