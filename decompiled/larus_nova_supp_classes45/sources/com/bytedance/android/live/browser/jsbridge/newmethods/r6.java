package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveOpenLiveEffectSelectPanelResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r6 implements zg1.e2 {
    public final /* synthetic */ s6 a;

    public r6(s6 r1) {
        this.a = r1;
    }

    public final void a(Sticker r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r7, "extra");
        LiveOpenLiveEffectSelectPanelResultModel r0 = new LiveOpenLiveEffectSelectPanelResultModel();
        r0.b(LiveOpenLiveEffectSelectPanelResultModel.Code.Success);
        LiveOpenLiveEffectSelectPanelResultModel.a r1 = new LiveOpenLiveEffectSelectPanelResultModel.a();
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.getEffectId();
    L6:
        r1.e(r3);
        if (r6 == null) goto L9;
        String r4 = r6.getName();
    L10:
        r1.h(r4);
        if (r6 == null) goto L13;
        Long r5 = Long.valueOf(r6.getDefaultDuration());
    L14:
        r1.c(r5);
        String r8 = "";
        if (r6 == null) goto L22;
        UrlModel r9 = r6.getIcon();
        if (r9 == null) goto L22;
        List<String> r11 = r9.getUrlList();
        if (r11 == null) goto L22;
        String r12 = (String) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L22;
    L23:
        r1.f(r12);
        r1.g(LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue());
        if (r6 == null) goto L26;
        boolean r13 = r6.enableCustomizeDuration();
    L27:
        r1.d(Boolean.valueOf(r13));
        String r14 = r7.get("effect_type");
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        r1.i(r14);
        String r15 = r7.get("sub_effect_type");
        if (r15 == null) goto L34;
        r8 = r15;
    L34:
        r1.j(r8);
        Unit r16 = Unit.INSTANCE;
        r0.c(r1);
        StringBuilder r17 = new StringBuilder("result: effectID: ");
        LiveOpenLiveEffectSelectPanelResultModel.a r18 = r0.a();
        if (r18 == null) goto L37;
        String r19 = r18.a();
    L38:
        r17.append(r19);
        r17.append(", effectName: ");
        LiveOpenLiveEffectSelectPanelResultModel.a r21 = r0.a();
        if (r21 == null) goto L41;
        r2 = r21.b();
    L41:
        r17.append(r2);
        ALogger.d("live.openLiveEffectSelectPanel", r17.toString());
        this.a.finishWithResult(r0);
        return;
    L37:
        r19 = null;
        goto L38
    L26:
        r13 = true;
    L22:
        r12 = "";
        goto L23
    L13:
        r5 = LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue();
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
