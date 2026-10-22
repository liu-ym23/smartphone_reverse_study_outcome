package com.bytedance.ai.bridge.method.info;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.info.AbsGetUserInfoMethodIDL;
import com.bytedance.ai.bridge.service.IHostUserDepend$UserModelExt;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostUserDependImpl;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetUserInfoMethod;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetUserInfoMethod extends AbsGetUserInfoMethodIDL {
    public GetUserInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetUserInfoMethodIDL.EmptyMessageModel) r10, r11);
    }

    public void handle(c r18, AbsGetUserInfoMethodIDL.EmptyMessageModel r19, f r20) {
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r19, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r20, "callback");
        ObricLauncherHostUserDependImpl r5 = d.f;
        if (r5 == null) goto L36;
        Intrinsics.checkNotNullParameter(AbsGetUserInfoMethodIDL.GetUserInfoResultModel.class, "<this>");
        BaseModel r10 = e.c(AbsGetUserInfoMethodIDL.GetUserInfoResultModel.class);
        AbsGetUserInfoMethodIDL.GetUserInfoResultModel r11 = (AbsGetUserInfoMethodIDL.GetUserInfoResultModel) r10;
        boolean r12 = r5.hasLogin();
        r11.setHasLoggedIn(r12);
        r11.setLogin(r12);
        if (r12 == false) goto L34;
        String r13 = r5.getUserId();
        if (r13 != null) goto L9;
        String r14 = "";
    L10:
        IHostUserDepend$UserModelExt r15 = r5.getUserModelExt();
        if (r15 == null) goto L16;
        String r16 = r15.getShortID();
        if (r16 == null) goto L16;
        String r17 = r16;
    L17:
        String r21 = r5.getSecUid();
        if (r21 != null) goto L20;
        String r22 = "";
    L21:
        String r23 = r5.getUniqueID();
        if (r23 != null) goto L24;
        String r110 = "";
    L25:
        String r24 = r5.getNickname();
        if (r24 != null) goto L28;
        String r111 = "";
    L29:
        String r25 = r5.getAvatarURL();
        if (r25 != null) goto L32;
        String r112 = "";
    L33:
        r11.setUserInfo(new AbsGetUserInfoMethodIDL.UserInfo(r14, r17, r22, r110, r111, r112, Boolean.valueOf(com.bytedance.ai.utils.c.l(r5.getBoundPhone())), null, 128, null));
        goto L34
    L32:
        r112 = r25;
        goto L33
    L28:
        r111 = r24;
        goto L29
    L24:
        r110 = r23;
        goto L25
    L20:
        r22 = r21;
    L16:
        r17 = "";
        goto L17
    L9:
        r14 = r13;
    L34:
        r20.b((ResultModel) r10, "");
        return;
    L36:
        r20.a("hostUserDepend is null");
    }
}
