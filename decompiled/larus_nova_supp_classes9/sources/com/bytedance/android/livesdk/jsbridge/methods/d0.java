package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.BaseInfoResultModel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "baseInfo")
public final class d0 extends w20.j<JsonObject, BaseInfoResultModel> {
    public d0() {
    }

    public final void invoke(Object r7, CallContext r8) throws Exception {
        JsonObject r9 = (JsonObject) r7;
        BaseInfoResultModel r10 = new BaseInfoResultModel();
        ((Boolean) com.bytedance.android.livesdk.p4.a.getValue()).booleanValue();
        IBaseUser r11 = jc1.k.f(IMiddlewareUserService.class).user().b().cloneFrom();
        BaseInfoResultModel.c r0 = new BaseInfoResultModel.c();
        r0.e(String.valueOf(r11.getShortId()));
        r0.b(r11.getDisplayId());
        r0.f(r11.getIdString());
        r0.d(r11.getCastSecUid());
        if (r11.getAvatarThumbKt() == null) goto L5;
        r0.a((String) ListProtector.get(r11.getAvatarThumbKt().getUrls(), 0));
    L5:
        r0.c(r11.getNickName());
        r0.g(Integer.valueOf(r11.getLevel()));
        if (r11.getAnchorInfoExt() == null) goto L8;
        r0.h(Long.valueOf(r11.getAnchorInfoExt().getLevel()));
    L9:
        r10.e(r0);
        Room r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r13 == null) goto L31;
        BaseInfoResultModel.b r1 = new BaseInfoResultModel.b();
        r1.d(r13.getIdStr());
        r1.e(Long.valueOf(r13.getRoomLayout()));
        if (r13.getPaidLiveData() == null) goto L16;
        boolean r4 = true;
        if (r13.getPaidLiveData().getPaidType() != 1) goto L16;
    L17:
        r1.g(Boolean.valueOf(r4));
        r1.b(Long.valueOf(r13.getLiveRoomMode()));
        if (r13.getRoomAuthStatus() == null) goto L21;
        r1.a(Integer.valueOf(r13.isGameRoom()));
        r1.c(Long.valueOf(r13.getRoomAuthStatus().getQuizGamePointsPlaying()));
    L21:
        if (r13.getSceneTypeInfo() == null) goto L23;
        r1.f(Boolean.valueOf(r13.getSceneTypeInfo().isLife()));
    L23:
        r10.d(String.valueOf(r13.getCreateTime()));
        r10.c(r1);
        BaseInfoResultModel.a r2 = new BaseInfoResultModel.a();
        IBaseUser r14 = r13.getOwner();
        r2.g(String.valueOf(r14.getShortId()));
        r2.d(r14.getDisplayId());
        r2.h(r14.getIdString());
        r2.f(r14.getCastSecUid());
        if (r14.getAvatarThumbKt() == null) goto L26;
        r2.c((String) ListProtector.get(r14.getAvatarThumbKt().getUrls(), 0));
    L26:
        r2.e(r14.getNickName());
        if (r14.getAnchorInfoExt() == null) goto L29;
        r2.a(Long.valueOf(r14.getAnchorInfoExt().getLevel()));
        r2.b(String.valueOf(r14.getAnchorInfoExt().getType()));
    L30:
        r10.a(r2);
        goto L31
    L29:
        r2.a(0);
        r2.b(BuildConfig.FLAVOR);
    L16:
        r4 = false;
    L31:
        r10.b(BaseInfoResultModel.Code.Success);
        finishWithResult(r10);
        return;
    L8:
        r0.h(0);
        goto L9
    }
}
