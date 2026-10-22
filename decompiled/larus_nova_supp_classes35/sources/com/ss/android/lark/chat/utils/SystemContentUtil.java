package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.lark.pb.basic.v1.SendLarkCommandPayloadResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback;
import com.ss.android.lark.share_group.RecallGroupChatterActivity;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SystemContentUtil {
    public static final Set<Integer> a = null;
    public static final w4b.u b = null;
    public static final BrowserDependency c = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$3, reason: invalid class name */
    class AnonymousClass3 implements IGetDataCallback<SendLarkCommandPayloadResponse> {
        final /* synthetic */ com.ss.android.lark.chat.export.entity.message.content.d val$localAction;

        public static /* synthetic */ void a(ErrorResult r0) {
            lambda$onError$0(r0);
        }

        public void onSuccess(SendLarkCommandPayloadResponse r1) {
        }

        public AnonymousClass3(com.ss.android.lark.chat.export.entity.message.content.d r1) {
            this.val$localAction = r1;
        }

        private static /* synthetic */ void lambda$onError$0(ErrorResult r1) {
            if (r1 != null) goto L4;
        L7:
            String r2 = UIHelper.getString(2131891714);
        L8:
            UDToast.show(UIHelper.getContext(), r2);
            return;
        L4:
            if (StringUtils.isEmpty(r1.getDisplayMsg()) == true) goto L7;
            r2 = r1.getDisplayMsg();
            goto L8
        }

        public void onError(final ErrorResult r3) {
            Set<Integer> r0 = SystemContentUtil.a;
            HashSet r1 = (HashSet) r0;
            if (r1.contains(Integer.valueOf(this.val$localAction.c)) == false) goto L6;
            ThreadUtils.runOnUIThread(new j1(r3));
            return;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((SendLarkCommandPayloadResponse) r1);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$4, reason: invalid class name */
    class AnonymousClass4 implements IGetDataCallback<Map<String, Boolean>> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$groupId;

        public void onError(ErrorResult r1) {
            Log.e(r1.toString());
        }

        public void onSuccess(Map<String, Boolean> r5) {
            if (r5 != null) goto L5;
        L19:
            SystemContentUtil.a(this.val$context.getString(2131890792));
            return;
        L5:
            if (r5.size() == 0) goto L19;
            final ArrayList r1 = new ArrayList();
            Iterator<Map.Entry<String, Boolean>> r6 = r5.entrySet().iterator();
        L9:
            if (r6.hasNext() == false) goto L14;
            Map.Entry<String, Boolean> r2 = r6.next();
            if (r2.getValue().booleanValue() == true) goto L9;
            r1.add(r2.getKey());
            goto L9
        L14:
            if (r1.size() != 0) goto L17;
            SystemContentUtil.a(this.val$context.getString(2131890792));
            return;
        L17:
            final Context r7 = this.val$context;
            final String r0 = this.val$groupId;
            Set<Integer> r3 = SystemContentUtil.a;
            ChatService r4 = ChatService.c.a;
            IGetDataCallback<Chat> r8 = new AnonymousClass6(r7, r0, r1);
            r4.getClass();
            ChatService.b(r0, r1, r8);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((Map) r1);
        }

        public AnonymousClass4(Context r1, String r2) {
            this.val$context = r1;
            this.val$groupId = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$5, reason: invalid class name */
    class AnonymousClass5 implements IJoinGroupCallback {
        final /* synthetic */ Context val$context;

        public void joinGroupChatSuccess(String r1) {
        }

        public void onCancelSendApply() {
        }

        public void onShowSendApplyDialog() {
        }

        public void sendApplySuccess() {
            SystemContentUtil.a(this.val$context.getString(2131892133));
        }

        public AnonymousClass5(Context r1) {
            this.val$context = r1;
        }

        public void onError(ErrorResult r2) {
            if (TextUtils.isEmpty(r2.getDisplayMsg()) == true) goto L6;
            SystemContentUtil.b(this.val$context, r2.getDisplayMsg());
            return;
        }

        public void onSendApplyError(ErrorResult r2) {
            if (TextUtils.isEmpty(r2.getDisplayMsg()) == true) goto L6;
            SystemContentUtil.a(r2.getDisplayMsg());
            Log.e(r2.toString());
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$9, reason: invalid class name */
    class AnonymousClass9 extends UIGetDataCallback<List<GroupRecallEntity>> {
        final /* synthetic */ Chat val$chat;
        final /* synthetic */ Context val$context;
        final /* synthetic */ a val$listener;
        final /* synthetic */ List val$memberEntities;

        public void onErrored(ErrorResult r3) {
            UDToast.show(UIHelper.getContext(), r3.getDisplayMsg(UIHelper.getString(2131891714)));
        }

        public void onSuccessed(List<GroupRecallEntity> r6) {
            if (r6.isEmpty() == false) goto L6;
            int r7 = SystemContentUtil.c(this.val$memberEntities, this.val$chat.isThread());
            Context r0 = this.val$context;
            h7b.i.b(r0, null, r0.getResources().getString(r7));
            return;
        L6:
            Context r1 = this.val$context;
            Chat r2 = this.val$chat;
            a r3 = this.val$listener;
            Set<Integer> r4 = SystemContentUtil.a;
            if (r6.size() <= 1) goto L9;
            Intent r5 = new Intent(r1, RecallGroupChatterActivity.class);
            r5.putExtra("key_chatId", r2.getId());
            r5.putExtra("key_is_thread", r2.isThread());
            r5.putParcelableArrayListExtra("key_entities", new ArrayList(r6));
            r1.startActivity(r5);
            return;
        L9:
            h7b.i.d(r1, new g1(r3, r2, r6));
        }

        public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
            onSuccessed((List) r1);
        }

        public AnonymousClass9(List r1, Chat r2, Context r3, a r4) {
            this.val$memberEntities = r1;
            this.val$chat = r2;
            this.val$context = r3;
            this.val$listener = r4;
        }
    }

    public interface a {
        void B(String r1, List<GroupRecallEntity> r2);
    }

    static {
        SystemMessageType.SystemContent_CHECK_USER_PHONE_NUMBER.getNumber();
        SystemMessageType.USER_CHECK_OTHERS_TELEPHONE.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_NAME.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_AVATAR.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_DESCRIPTION.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_SETTINGS.getNumber();
        SystemMessageType.USER_START_GROUP_AND_INVITE.getNumber();
        SystemMessageType.SYSTEM_WELCOME_USER.getNumber();
        SystemMessageType r0 = SystemMessageType.USER_INVITE_OTHERS_JOIN;
        r0.getNumber();
        SystemMessageType.USER_QUIT_GROUP.getNumber();
        SystemMessageType.USER_REMOVE_OTHERS.getNumber();
        SystemMessageType.DERIVE_FROM_P2P_CHAT.getNumber();
        SystemMessageType r1 = SystemMessageType.USER_JOIN_VIA_SHARE;
        r1.getNumber();
        SystemMessageType.TRANSFER_GROUP_CHAT_OWNER.getNumber();
        SystemMessageType.TRANSFER_GROUP_CHAT_OWNER_AND_QUIT.getNumber();
        SystemMessageType.USER_SYNC_MESSAGE.getNumber();
        SystemMessageType r2 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT;
        r2.getNumber();
        SystemMessageType.USER_START_CRYPTO_GROUP_AND_INVITE.getNumber();
        SystemMessageType.USER_START_GROUP.getNumber();
        SystemMessageType r3 = SystemMessageType.USER_JOIN_VIA_QR_CODE;
        r3.getNumber();
        SystemMessageType.USER_SHARE_DOC_PERMISSION.getNumber();
        SystemMessageType.USER_CHANGE_DOC_PERMISSION.getNumber();
        SystemMessageType.USER_SHARE_DOC_FOLDER.getNumber();
        SystemMessageType.USER_OPEN_ONLY_ADMIN_POST.getNumber();
        SystemMessageType.USER_SEPECIFY_MEMBERS_POST.getNumber();
        SystemMessageType.USER_OPEN_ANYONE_POST.getNumber();
        SystemMessageType.USER_INVITE_OTHERS_JOIN_MEETING.getNumber();
        SystemMessageType.USER_QUIT_MEETING_CHAT.getNumber();
        SystemMessageType.USER_DISMISSED_MEETING_CHAT.getNumber();
        SystemMessageType.USER_REMOVE_OTHERS_FROM_MEETING.getNumber();
        SystemMessageType.USER_ADD_MEETING_CHAT.getNumber();
        SystemMessageType r4 = SystemMessageType.USER_START_MEETING_GROUP_AND_INVITE;
        r4.getNumber();
        SystemMessageType.INVITE_CHAT_MEMBER_2_OUT_CHAT.getNumber();
        SystemMessageType.CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER.getNumber();
        r4.getNumber();
        SystemMessageType.AUTO_TRANSLATE_GUIDANCE.getNumber();
        SystemMessageType.WITHDRAW_ADDED_USER.getNumber();
        SystemMessageType.SAIPAN_REMIND_ONCALL_REPLY.getNumber();
        SystemMessageType.SAIPAN_REMIND_ONCALL_DONE.getNumber();
        SystemMessageType.SAIPAN_REMIND_ONCALL_AUTO_DONE.getNumber();
        SystemMessageType.SAIPAN_ADD_ONCALL.getNumber();
        SystemMessageType.USER_OPEN_ONLY_ADMIN_POST_THREAD.getNumber();
        SystemMessageType.USER_SPECIFY_MEMBERS_POST_THREAD.getNumber();
        SystemMessageType r5 = SystemMessageType.USER_OPEN_ANYONE_POST_THREAD;
        r5.getNumber();
        SystemMessageType.INVITE_AT_CHATTERS.getNumber();
        r5.getNumber();
        SystemMessageType.VC_MEETING_STARTED.getNumber();
        SystemMessageType.VC_MEETING_ENDED_OVER_ONE_HOUR.getNumber();
        SystemMessageType.VC_MEETING_ENDED_LESS_ONE_HOUR.getNumber();
        SystemMessageType.VC_MEETING_ENDED_LESS_ONE_MINUTE.getNumber();
        SystemMessageType.VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR.getNumber();
        SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR.getNumber();
        SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_NO_ANSWER.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_REFUSE.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWER_CANCEL.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_BUSY.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_NO_ANSWER.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_REFUSE.getNumber();
        SystemMessageType.VOIP_INTERVIEWER_CANCEL.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_BUSY.getNumber();
        SystemMessageType.CANCEL_EMERGENCY_CALL.getNumber();
        SystemMessageType.HANGUP_EMERGENCY_CALL.getNumber();
        SystemMessageType.START_EMERGENCY_CALL.getNumber();
        SystemMessageType.EMERGENCY_CALL_NOTANSWER.getNumber();
        SystemMessageType.MEETING_TRANSFER_TO_CHAT.getNumber();
        SystemMessageType.MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_NOT_ONLINE.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_NOT_ONLINE.getNumber();
        SystemMessageType.USER_JOIN_CHAT_AUTO_MUTE.getNumber();
        SystemMessageType r6 = SystemMessageType.INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD;
        r6.getNumber();
        SystemMessageType r7 = SystemMessageType.INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD;
        r7.getNumber();
        SystemMessageType.USER_CHANGE_TURN_ON_GROUP_MAIL.getNumber();
        SystemMessageType.USER_CHANGE_TURN_OFF_GROUP_MAIL.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE.getNumber();
        SystemMessageType r8 = SystemMessageType.USER_JOIN_VIA_GROUP_LINK;
        r8.getNumber();
        SystemMessageType r9 = SystemMessageType.USER_INVITE_BOT_JOIN;
        r9.getNumber();
        SystemMessageType.DOC_TEMPLATE_GROUP_SHARE.getNumber();
        SystemMessageType.SHEET_TEMPLATE_GROUP_SHARE.getNumber();
        SystemMessageType.MIND_NOTE_TEMPLATE_GROUP_SHARE.getNumber();
        SystemMessageType r10 = SystemMessageType.BUILD_ONE_WAY_RELATION;
        r10.getNumber();
        SystemMessageType r11 = SystemMessageType.INVITE_FRIENDS_SUCCESS;
        r11.getNumber();
        SystemMessageType.CREATE_P2P_SOURCE.getNumber();
        SystemMessageType.CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT.getNumber();
        SystemMessageType.MENTIONED_PERSON_NOT_IN_CIRCLE.getNumber();
        SystemMessageType.INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE.getNumber();
        r6.getNumber();
        r7.getNumber();
        SystemMessageType.JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD.getNumber();
        SystemMessageType.CIRCLE_WELCOME_NEW_MEMBERS.getNumber();
        SystemMessageType.TRANSFER_CIRCLE_OWNER.getNumber();
        SystemMessageType.TRANSFER_CIRCLE_OWNER_AND_LEAVE.getNumber();
        SystemMessageType.CIRCLE_USER_CHANGE_DOC_PERMISSION.getNumber();
        SystemMessageType r12 = SystemMessageType.USER_INVITE_BOT_JOIN_CIRCLE;
        r12.getNumber();
        SystemMessageType r13 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE;
        r13.getNumber();
        SystemMessageType r14 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK;
        r14.getNumber();
        SystemMessageType.CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED.getNumber();
        SystemMessageType r15 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE;
        r15.getNumber();
        SystemMessageType r16 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD;
        r16.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_AVATAR.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_DESCRIPTION.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_NAME.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_OWNER.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_SETTINGS.getNumber();
        SystemMessageType.USER_SET_ONLY_CIRCLE_OWNER_CAN_POST.getNumber();
        SystemMessageType.USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS.getNumber();
        SystemMessageType.USER_LEAVE_CIRCLE.getNumber();
        SystemMessageType r17 = SystemMessageType.USER_REMOVE_CIRCLE_MEMBERS;
        r17.getNumber();
        r17.getNumber();
        SystemMessageType.USER_CREATE_CIRCLE.getNumber();
        SystemMessageType.USER_CREATE_CIRCLE_AND_INVITE.getNumber();
        SystemMessageType.USER_SYNC_MESSAGE_TO_CIRCLE.getNumber();
        SystemMessageType.USER_WITHDRAW_CIRCLE_INVITATION.getNumber();
        SystemMessageType.CIRCLE_ANONYMOUS_ON.getNumber();
        SystemMessageType.CIRCLE_ANONYMOUS_OFF.getNumber();
        SystemMessageType.USER_CLEAR_CIRCLE_ANNOUNCEMENT.getNumber();
        SystemMessageType.USER_REMOVE_CIRCLE_DESCRIPTION.getNumber();
        SystemMessageType.USER_CREATE_FACE_TO_FACE_CHAT.getNumber();
        SystemMessageType.WELCOME_USER_JOIN_FACE_TO_FACE_CHAT.getNumber();
        SystemMessageType.INVITE_CHAT_MEMBER_2_CHAT.getNumber();
        SystemMessageType.WILL_REACH_CHAT_CHATTER_COUNT_LIMIT.getNumber();
        SystemMessageType.ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT.getNumber();
        SystemMessageType.USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT.getNumber();
        SystemMessageType r18 = SystemMessageType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN;
        r18.getNumber();
        SystemMessageType.CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER.getNumber();
        SystemMessageType.USER_OPEN_ONLY_SPECIFY_MEMBERS_POST.getNumber();
        SystemMessageType.USER_OPEN_ONLY_SPECIFY_MEMBERS_POST_THREAD.getNumber();
        SystemMessageType.USER_REMOVE_SPECIFY_MEMBERS_POST.getNumber();
        SystemMessageType.USER_REMOVE_SPECIFY_MEMBERS_POST_THREAD.getNumber();
        SystemMessageType.ADD_MEMBER_TO_ADMIN_LIST.getNumber();
        SystemMessageType.REMOVE_MEMBER_FROM_ADMIN_LIST.getNumber();
        SystemMessageType.USER_OPEN_ONLY_OWNER_AND_ADMIN_POST.getNumber();
        SystemMessageType.USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD.getNumber();
        SystemMessageType.ADMIN_OPEN_ANYONE_POST.getNumber();
        SystemMessageType.ADMIN_OPEN_ANYONE_POST_THREAD.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN.getNumber();
        SystemMessageType.GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON.getNumber();
        SystemMessageType.GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF.getNumber();
        SystemMessageType r19 = SystemMessageType.GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES;
        r19.getNumber();
        SystemMessageType.CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY.getNumber();
        SystemMessageType.JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY.getNumber();
        SystemMessageType r110 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY;
        r110.getNumber();
        SystemMessageType r111 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY;
        r111.getNumber();
        SystemMessageType r112 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY;
        r112.getNumber();
        SystemMessageType r113 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY;
        r113.getNumber();
        SystemMessageType r114 = SystemMessageType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HIStORY;
        r114.getNumber();
        SystemMessageType r20 = SystemMessageType.USER_JOIN_VIA_QR_CODE_NO_HISTORY;
        r20.getNumber();
        SystemMessageType.USER_JOIN_CHAT_WELCOME_MESSAGE.getNumber();
        SystemMessageType.USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY.getNumber();
        SystemMessageType r21 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE;
        r21.getNumber();
        SystemMessageType r22 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY;
        r22.getNumber();
        SystemMessageType r23 = SystemMessageType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW;
        r23.getNumber();
        SystemMessageType r24 = SystemMessageType.USER_JOIN_VIA_QR_NEW;
        r24.getNumber();
        SystemMessageType r25 = SystemMessageType.USER_JOIN_VIA_SHARE_NEW;
        r25.getNumber();
        SystemMessageType r26 = SystemMessageType.USER_JOIN_VIA_SHARE_NO_HISTORY;
        r26.getNumber();
        SystemMessageType r27 = SystemMessageType.USER_JOIN_CHAT_BY_LINK;
        r27.getNumber();
        SystemMessageType r28 = SystemMessageType.USER_JOIN_CHAT_BY_LINK_NO_HISTORY;
        r28.getNumber();
        SystemMessageType.HELP_DESK_USER_JOIN_CHAT.getNumber();
        SystemMessageType.HELP_DESK_USER_JOIN_CHAT_NO_HISTORY.getNumber();
        SystemMessageType.BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE.getNumber();
        SystemMessageType.UPGRADE_SUPER_CHAT.getNumber();
        SystemMessageType.CREATE_TEAM_AND_INVITE_MEMBERS.getNumber();
        SystemMessageType.INVITE_MEMBERS_JOIN_TEAM.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_FAIL.getNumber();
        SystemMessageType.KICK_MEMBERS_OUT_TEAM.getNumber();
        SystemMessageType.MEMBER_LEAVE_TEAM.getNumber();
        SystemMessageType.TRANSFER_TEAM_OWNER.getNumber();
        SystemMessageType.MODIFY_TEAM_NAME.getNumber();
        SystemMessageType.ENABLE_TEAM_CREATE_CHAT_PERMISSION.getNumber();
        SystemMessageType.CLOSE_TEAM_CREATE_CHAT_PERMISSION.getNumber();
        SystemMessageType.ENABLE_TEAM_ADD_MEMBERS_PERMISSION.getNumber();
        SystemMessageType.CLOSE_TEAM_ADD_MEMBERS_PERMISSION.getNumber();
        SystemMessageType.DISSOLVE_TEAM_AND_UNBIND_CHAT.getNumber();
        SystemMessageType.CREATE_TEAM_CHAT.getNumber();
        SystemMessageType.BIND_CHAT_INTO_TEAM.getNumber();
        SystemMessageType.UNBIND_CHAT_WITH_TEAM.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_CHAT_FAIL.getNumber();
        SystemMessageType.UPDATE_CHAT_TO_TEAM.getNumber();
        SystemMessageType.MEMBERS_LEAVE_AND_TRANSFER.getNumber();
        SystemMessageType.USER_CREATE_TEAM.getNumber();
        SystemMessageType.MODIFY_TEAM_AVATAR.getNumber();
        SystemMessageType.MODIFY_TEAM_DESCRIPTION.getNumber();
        SystemMessageType.DELETE_TEAM_DESCRIPTION.getNumber();
        SystemMessageType.CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON.getNumber();
        SystemMessageType.CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF.getNumber();
        SystemMessageType.CREATE_TEAM_CHAT_V2_MANAGER.getNumber();
        SystemMessageType.BIND_CHAT_INTO_TEAM_MANAGER.getNumber();
        SystemMessageType.AUTO_OPEN_TYPING_TRANSLATE.getNumber();
        SystemMessageType.AUTO_OPEN_TYPING_TRANSLATE_V1.getNumber();
        SystemMessageType.MANUAL_OPEN_TYPING_TRANSLATE.getNumber();
        SystemMessageType.MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS.getNumber();
        SystemMessageType.CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT.getNumber();
        SystemMessageType.CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS.getNumber();
        SystemMessageType.CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING.getNumber();
        new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(r0.getNumber()), Integer.valueOf(r2.getNumber()), Integer.valueOf(r1.getNumber()), Integer.valueOf(r3.getNumber()), Integer.valueOf(r8.getNumber()), Integer.valueOf(r9.getNumber()), Integer.valueOf(r13.getNumber()), Integer.valueOf(r16.getNumber()), Integer.valueOf(r15.getNumber()), Integer.valueOf(r12.getNumber()), Integer.valueOf(r14.getNumber()), Integer.valueOf(r18.getNumber()), Integer.valueOf(r19.getNumber()), Integer.valueOf(r110.getNumber()), Integer.valueOf(r111.getNumber()), Integer.valueOf(r113.getNumber()), Integer.valueOf(r112.getNumber()), Integer.valueOf(r114.getNumber()), Integer.valueOf(r20.getNumber()), Integer.valueOf(r21.getNumber()), Integer.valueOf(r22.getNumber()), Integer.valueOf(r23.getNumber()), Integer.valueOf(r24.getNumber()), Integer.valueOf(r25.getNumber()), Integer.valueOf(r26.getNumber()), Integer.valueOf(r27.getNumber()), Integer.valueOf(r28.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_UserAndGroup_OwnerInvite.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite.getNumber())}));
        Integer[] r29 = {Integer.valueOf(r10.getNumber()), Integer.valueOf(r11.getNumber()), Integer.valueOf(SystemMessageType.SEND_MESSAGE_COLLABORATION_AUTH_FAILED.getNumber()), Integer.valueOf(SystemMessageType.NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY.getNumber()), Integer.valueOf(SystemMessageType.NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT.getNumber())};
        SystemMessageType.SystemContent_Lark_IM_BotCustomization.getNumber();
        new HashSet(Arrays.asList(r29));
        a = new AnonymousClass1();
        b = ChatCoreModule.a().getLoginDependency();
        c = ChatCoreModule.a().getBrowserDependency();
        ChatCoreModule.a().getProfileDependency();
    }

    public static void a(String r2) {
        CoreThreadPool.getDefault().getUIExecutor().execute(new h1(r2));
    }

    public static void b(Context r2, String r3) {
        if (TextUtils.isEmpty(null) == true) goto L5;
    L7:
        CoreThreadPool.getDefault().getUIExecutor().execute(new i1(r2, r3));
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
    }

    public static int c(List<? extends PickChatEntity> r6, boolean r7) {
        HashMap r0 = new HashMap(r6.size());
        Iterator<? extends PickChatEntity> r1 = r6.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        PickChatEntity r2 = r1.next();
        List r4 = (List) r0.get(Integer.valueOf(r2.a));
        if (r4 != null) goto L8;
        r4 = new ArrayList(r6.size() / 3);
        r0.put(Integer.valueOf(r2.a), r4);
    L8:
        r4.add(r2);
        goto L4
    L10:
        if (r0.size() != 1) goto L39;
        ArrayList r8 = new ArrayList(r0.keySet());
        boolean r5 = false;
        int r9 = ((Integer) ListProtector.get(r8, 0)).intValue();
        if (((List) r0.get(Integer.valueOf(r9))).size() <= 1) goto L14;
        r5 = true;
    L14:
        if (r9 != 1) goto L16;
        if (r5 == false) goto L34;
        if (r7 == false) goto L33;
        return 2131890870;
    L33:
        return 2131890809;
    L34:
        if (r7 == false) goto L37;
        return 2131890869;
    L37:
        return 2131890810;
    L16:
        if (r9 == 2) goto L24;
        if (r9 != 3) goto L39;
        if (r5 == false) goto L22;
        return 2131892687;
    L22:
        return 2131892690;
    L24:
        if (r5 == false) goto L27;
        return 2131892688;
    L27:
        return 2131892691;
    L39:
        return 2131890809;
    }
}
