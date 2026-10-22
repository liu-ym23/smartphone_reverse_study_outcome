package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.browser.jsbridge.base.ShareImageUrlToPanelResultModel;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.LiveQrCodeConfig;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SharePublishParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.qe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareImageUrlToPanel")
public final class kc extends w20.i6<qe, ShareImageUrlToPanelResultModel> {

    public static final class a {
    }

    static {
    }

    public kc() {
    }

    public final void invoke(Object r27, CallContext r28) {
        qe r0 = (qe) r27;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r28, "context");
        HashMap r1 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r3 == null) goto L5;
        r1.putAll(r3.getMap());
    L5:
        com.bytedance.android.livesdk.log.filter.o r4 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r3 == null) goto L8;
        r1.putAll(r4.getMap());
    L8:
        r1.put("enter_from", "sjb_afterheat");
        r1.put("room_type", "h5_activity");
        r1.put("content_type", "sjb_afterheat");
        r1.put("sjb_content_type", "sjb_afterheat");
        ILiveService r5 = TTLiveService.getLiveService();
        if (r5 == null) goto L11;
        ILiveQrCodeShareHelper r6 = r5.getQrCodeShareHelper(5);
    L12:
        int r7 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r0.d()) == false) goto L16;
        if (r6 == null) goto L16;
        r6.setRaceLogo(new ImageModel(r0.d(), CollectionsKt.listOf(r0.d())));
    L16:
        if (r6 == null) goto L18;
        r6.setOriginalPic(new ImageModel(r0.a(), CollectionsKt.listOf(r0.a())));
    L18:
        LiveQrCodeConfig r8 = new LiveQrCodeConfig();
        r8.setPanelType(4);
        if ((r6 instanceof IQrCodeShareHelper) == true) goto L21;
        ILiveQrCodeShareHelper r9 = null;
    L22:
        IQrCodeShareHelper r11 = (IQrCodeShareHelper) r9;
        if (r11 == null) goto L25;
        r8.setQrCodeShareHelper(r11);
    L25:
        ShareParams.Builder r12 = ShareParams.builder();
        if (r12 == null) goto L42;
        r12.setUrl(r0.b());
        r12.setShareSceneConfigName(r0.c());
        r12.setLiveQrCodeConfig(r8);
        r12.setShareSubScene(ShareSubScene.LiveAfterMatch);
        r12.setLogExtraParams(r1);
        r12.setEnterFrom("sjb_afterheat");
        SharePublishParam r2 = new SharePublishParam();
        if (r6 == null) goto L31;
        String r13 = r6.getRelatedReviewContent();
        if (r13 == null) goto L31;
    L32:
        r2.setRelatedReviewContent(r13);
        Unit r14 = Unit.INSTANCE;
        r12.setSharePublishParam(r2);
        ShareParams r15 = r12.build();
        if (r15 == null) goto L42;
        Context r16 = r28.getContext();
        if ((r16 instanceof Activity) == true) goto L37;
        r16 = null;
    L37:
        Activity r17 = (Activity) r16;
        if (r17 == null) goto L40;
        Activity r18 = r17;
    L41:
        jc1.k.n(ILiveShareService.class).share(new i81.a(null, r18, null, r15, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareImageUrlToPanelMethod", LiveShareType.SHARE_DIALOG, null);
        goto L42
    L40:
        r18 = null;
    L31:
        r13 = "";
    L42:
        finishWithSuccess();
        return;
    L21:
        r9 = r6;
        goto L22
    L11:
        r6 = null;
        goto L12
    }
}
