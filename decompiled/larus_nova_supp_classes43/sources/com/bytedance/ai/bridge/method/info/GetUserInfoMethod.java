package com.bytedance.ai.bridge.method.info;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.info.AbsGetUserInfoMethodIDL;
import com.bytedance.ai.bridge.service.IHostUserDepend;
import com.bytedance.ai.utils.f;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetUserInfoMethod;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserInfoMethod extends AbsGetUserInfoMethodIDL {
    public GetUserInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r18, ParamModel r19, h r20) {
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetUserInfoMethodIDL.a) r19, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        IHostUserDepend r1 = a.i;
        if (r1 == null) goto L28;
        Intrinsics.checkNotNullParameter(AbsGetUserInfoMethodIDL.b.class, "<this>");
        BaseModel r10 = c.a(AbsGetUserInfoMethodIDL.b.class);
        AbsGetUserInfoMethodIDL.b r11 = (AbsGetUserInfoMethodIDL.b) r10;
        boolean r12 = r1.hasLogin();
        r11.setHasLoggedIn(r12);
        r11.setLogin(r12);
        if (r12 == false) goto L27;
        String r13 = r1.getUserId();
        if (r13 != null) goto L9;
        String r14 = "";
    L10:
        r1.getUserModelExt();
        String r15 = r1.getSecUid();
        if (r15 != null) goto L13;
        String r16 = "";
    L14:
        String r17 = r1.getUniqueID();
        if (r17 != null) goto L17;
        String r110 = "";
    L18:
        String r21 = r1.getNickname();
        if (r21 != null) goto L21;
        String r111 = "";
    L22:
        String r22 = r1.getAvatarURL();
        if (r22 != null) goto L25;
        String r112 = "";
    L26:
        r1.getBoundPhone();
        r11.setUserInfo(new AbsGetUserInfoMethodIDL.UserInfo(r14, "", r16, r110, r111, r112, Boolean.valueOf(f.g(null)), null, 128, null));
        goto L27
    L25:
        r112 = r22;
        goto L26
    L21:
        r111 = r21;
        goto L22
    L17:
        r110 = r17;
        goto L18
    L13:
        r16 = r15;
        goto L14
    L9:
        r14 = r13;
    L27:
        r20.b((ResultModel) r10, "");
        return;
    L28:
        h.a.a(r20, "hostUserDepend is null", null, null, 14);
    }
}
