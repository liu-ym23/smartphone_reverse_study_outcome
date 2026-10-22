package com.ss.android.lark.contact.base.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.SendUserInvitationRequest;
import com.bytedance.lark.pb.contact.v1.SendUserInvitationResponse;
import com.bytedance.lark.pb.im.v1.GetChatApplicationsRequest;
import com.bytedance.lark.pb.im.v1.ProcessChatApplicationRequest;
import com.bytedance.lark.pb.im.v2.GetContactTokenRequest;
import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.entity.ChatApplicationGetType;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class c implements SdkSender.IParser<Boolean> {
        public c() {
        }

        public final Object parse(byte[] r1) {
            return Boolean.TRUE;
        }
    }

    static {
    }

    public static void a(IGetDataCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        Command r0 = Command.GET_CONTACT_TOKEN_V2;
        GetContactTokenRequest.Builder r1 = new GetContactTokenRequest.Builder().strategy(SyncDataStrategy.LOCAL);
        InvApmUtils.GetDataCallback r8 = new InvApmUtils.GetDataCallback(r9, "ug_invite_external_nondirectional_get_invite_info", null, 4, null);
        final ProtoAdapter r10 = GetContactTokenResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r0, r1, r8, new a(r10));
    }

    public static void b(IGetDataCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        Command r0 = Command.GET_CONTACT_TOKEN_V2;
        GetContactTokenRequest.Builder r1 = new GetContactTokenRequest.Builder();
        InvApmUtils.GetDataCallback r8 = new InvApmUtils.GetDataCallback(r9, "ug_invite_external_nondirectional_get_invite_info", null, 4, null);
        final ProtoAdapter r10 = GetContactTokenResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r0, r1, r8, new b(r10));
    }

    public static void e(String r3, boolean r4, UIGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r5, "callback");
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r1 = CommonCmd.AIDL_PLATFORM_TYPE_PHONE;
    L6:
        r0.put(IPortraitService.TYPE, r1);
        Command r2 = Command.SEND_USER_INVITATION;
        SendUserInvitationRequest.Builder r6 = new SendUserInvitationRequest.Builder().contact_content(r3);
        if (r4 == false) goto L9;
        SendUserInvitationRequest.Type r7 = SendUserInvitationRequest.Type.MOBILE;
    L10:
        SendUserInvitationRequest.Builder r8 = r6.type(r7);
        InvApmUtils.GetDataCallback r9 = new InvApmUtils.GetDataCallback(r5, "ug_invite_external_orientation_invite", r0);
        final ProtoAdapter r10 = SendUserInvitationResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r2, r8, r9, new i(r10));
        return;
    L9:
        r7 = SendUserInvitationRequest.Type.EMAIL;
        goto L10
    L5:
        r1 = "email";
        goto L6
    }

    public static void c(String r3, boolean r4, boolean r5, final IGetDataCallback r6) {
        ChatApplicationGetType r0 = ChatApplicationGetType.BEFORE;
        ChatApplication.Type r1 = ChatApplication.Type.FRIEND;
        IGetDataCallback<e9b.a> r2 = new ContactBaseService$getFriendRequests$1(r6);
        GetChatApplicationsRequest.Builder r7 = new GetChatApplicationsRequest.Builder().cursor(r3).count(20).type(com.bytedance.lark.pb.basic.v1.ChatApplication.Type.fromValue(r1.getNumber())).get_type(GetChatApplicationsRequest.GetType.fromValue(r0.getNumber()));
        if (r4 == false) goto L5;
        r7.sync_data_strategy(SyncDataStrategy.LOCAL);
    L5:
        if (r5 == false) goto L8;
        r7.ignore_chat_id_when_empty(Boolean.TRUE);
    L8:
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == true) goto L10;
        r7.chat_id(BuildConfig.FLAVOR);
    L10:
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_APPLICATIONS, r7, r2, com.ss.android.lark.contact.base.service.c.a);
    }

    public static void d(String r1, ChatApplication.Status r2, Boolean r3, IGetDataCallback r4) {
        ProcessChatApplicationRequest.Builder r5 = new ProcessChatApplicationRequest.Builder().id(r1).status(com.bytedance.lark.pb.basic.v1.ChatApplication.Status.fromValue(r2.getNumber())).auth_sync(r3);
        SdkSender.asynSendRequestNonWrap(Command.PROCESS_CHAT_APPLICATION, r5, r4, new c());
    }
}
