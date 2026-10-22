package com.ss.android.lark.contact.base.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v2.SetupBlockUserRequest;
import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.bytedance.lark.pb.im.v1.SendChatApplicationRequest;
import com.bytedance.lark.pb.im.v1.SendChatApplicationResponse;
import com.bytedance.lark.pb.im.v1.UpdateChatApplicationMeReadRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.customized.mygroup.repository.OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y implements z {
    public final IChatParser a;

    public y() {
        this.a = ContactBaseModuleDependency.b.getChatParser();
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void i(IGetDataCallback r3) {
        RxScheduledExecutor.justInIO(new v(this, GetMyGroupChatsRequest.Type.JOIN, r3));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void a(String r3, OfficeProfileModel.acceptFriend.2.1 r4) {
        int r0 = d.a;
        d.d(r3, ChatApplication.Status.AGREED, Boolean.TRUE, r4);
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void c(String r2, OfficeProfileModel.deleteFriend.2.1 r3) {
        ImSdkService.d().N7(r2, r3);
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void d(List r3, OfficeProfileModel.updateChatApplicationMeRead.2.1 r4) {
        int r0 = d.a;
        Intrinsics.checkNotNullParameter(r3, "applicationIds");
        UpdateChatApplicationMeReadRequest.Builder r5 = new UpdateChatApplicationMeReadRequest.Builder().read_all_applications(Boolean.FALSE).application_ids(r3);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_CHAT_APPLICATION_ME_READ, r5, r4, k.a);
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void g(long r3, IGetDataCallback r5) {
        j(r3, GetMyGroupChatsRequest.Type.ADMINISTRATE, new DefaultOfficeContactRepository$4(this, r5));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void h(long r3, IGetDataCallback r5) {
        j(r3, GetMyGroupChatsRequest.Type.JOIN, new DefaultOfficeContactRepository$4(this, r5));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void e(String r2, boolean r3, OfficeProfileModel.blockUser.2.1 r4) {
        SetupBlockUserRequest.Builder r5 = new SetupBlockUserRequest.Builder().block_status(Boolean.valueOf(r3)).block_user_id(r2);
        SdkSender.asynSendRequestNonWrap(Command.SETUP_BLOCK_USER, r5, r4, new u());
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void f(long r1, GetMyGroupChatsRequest.Type r3, OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1 r4) {
        j(r1, r3, r4);
    }

    public final void j(long r4, GetMyGroupChatsRequest.Type r6, IGetDataCallback r7) {
        SdkSender.asynSendRequestNonWrap(Command.GET_MY_GROUP_CHATS, new GetMyGroupChatsRequest.Builder().count(50).type(r6).time(Long.valueOf(r4)), r7, new x(this));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void b(String r4, String r5, String r6, ContactSource r7, final OfficeProfileModel.applyFriend.2.1 r8) {
        IGetDataCallback<SendChatApplicationResponse> r0 = new DefaultOfficeContactRepository$1(this, r8);
        SendChatApplicationRequest.Builder r9 = new SendChatApplicationRequest.Builder().token(null);
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r9.extra_message(r5);
    L6:
        if (TextUtils.isEmpty(null) == true) goto L8;
        r9.chat_id(null);
    L8:
        if (r7 == null) goto L10;
        r9.sender = r7.getSender();
        r9.source_name = r7.getSourceName();
        r9.source(com.bytedance.lark.pb.basic.v1.ContactSource.fromValue(r7.getSourceType()));
        r9.sender_id = r7.getSenderId();
        r9.source_id = r7.getSourceId();
        r9.sub_source_type = r7.getSubSourceType();
    L10:
        r9.user_alias = r6;
        r9.user_id = r4;
        StringBuilder r10 = new StringBuilder("send add friend request user tns:false sourceType=");
        if (r7 == null) goto L13;
        int r11 = r7.getSourceType();
    L14:
        r10.append(r11);
        Log.i("DefaultOfficeContactRepository", r10.toString());
        Command r12 = Command.SEND_CHAT_APPLICATION;
        final ProtoAdapter r13 = SendChatApplicationResponse.ADAPTER;
        Objects.requireNonNull(r13);
        SdkSender.asynSendRequestNonWrap(r12, r9, r0, new t(r13));
        return;
    L13:
        r11 = -1;
        goto L14
    }
}
