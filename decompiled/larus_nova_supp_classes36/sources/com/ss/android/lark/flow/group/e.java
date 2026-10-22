package com.ss.android.lark.flow.group;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChatLinkInfoRequest;
import com.bytedance.lark.pb.im.v1.GetChatQRCodeInfoRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.api.service.impl.g0;
import com.ss.android.lark.chat.api.service.impl.h0;
import com.ss.android.lark.dto.chat.ChatLinkInfoResponse;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberNonDirectionalPage$Param$Type;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.c0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends ova.d {
    public final boolean b(Context r1, AppLink r2) {
        return true;
    }

    public e() {
    }

    public final boolean a(Context r5, AppLink r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        Uri r7 = UriProtector.parse(r6.a);
        final String r0 = UriProtector.getQueryParameter(r7, "link_token");
        if (TextUtils.isEmpty(r0) == false) goto L8;
        Log.e("FlowGroupAppLinkHandler", "handle link or qrcode appLink failed: token from url is invalid!");
        return true;
    L8:
        if (TextUtils.equals(UriProtector.getQueryParameter(r7, InvRouter$InviteMemberNonDirectionalPage$Param$Type.QR_CODE), "true") == false) goto L13;
        Log.i("FlowGroupAppLinkHandler", "handle qrcode");
        int r8 = a.a;
        FlowGroupAppLinkHandler$1 r9 = new FlowGroupAppLinkHandler$1(this, r0, r5);
        Intrinsics.checkNotNullParameter(r0, "token");
        Intrinsics.checkNotNullParameter(r9, "callback");
        ChatService.c.a.getClass();
        GetChatQRCodeInfoRequest.Builder r10 = new GetChatQRCodeInfoRequest.Builder();
        if (TextUtils.isEmpty(r0) == true) goto L19;
        r10.token(r0);
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_QRCODE_INFO, r10, r9, new g0());
        return true;
    L19:
        return true;
    L13:
        Log.i("FlowGroupAppLinkHandler", "handle link");
        final Context r11 = r5.getApplicationContext();
        UICallbackExecutor.execute(new c0());
        int r12 = a.a;
        final IGetDataCallback<FlowChatLinkInfoResponse> r13 = new FlowGroupAppLinkHandler$2(this, r0, r11);
        Intrinsics.checkNotNullParameter(r0, "token");
        Intrinsics.checkNotNullParameter(r13, "callback");
        ChatService r14 = ChatService.c.a;
        IGetDataCallback<ChatLinkInfoResponse> r1 = new FlowChatQRCodeDependency$getChatLinkInfo$1(r13, r0);
        r14.getClass();
        GetChatLinkInfoRequest.Builder r15 = new GetChatLinkInfoRequest.Builder();
        r15.token(r0);
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_SHARE_LINK_INFO, r15, r1, new h0());
        return true;
    }
}
