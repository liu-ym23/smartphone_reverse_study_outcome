package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.lark.pb.basic.v1.CloudDraftContent;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.bytedance.lark.pb.basic.v1.ScheduleMessageItem;
import com.bytedance.lark.pb.im.v1.CreateDraftRequest;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdRequest;
import com.bytedance.lark.pb.im.v1.DeleteDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftRequest;
import com.bytedance.lark.pb.im.v1.GetDraftsRequest;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateRequest;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class r implements m6b.g {
    public final l6b.a a;
    public ExecutorService b;

    public interface a {
        Boolean a();
    }

    @Override // m6b.g
    public final Executor getExecutor() {
        ExecutorService r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        this.b = CoreThreadPool.getDefault().newSerialIODensityThreadPool("DraftService");
    L10:
        return this.b;
    L5:
        if (r0.isShutdown() == true) goto L8;
        if (this.b.isTerminated() == false) goto L10;
        goto L8
    }

    @Inject
    public r(l6b.a r1) {
        this.a = r1;
    }

    @Override // m6b.g
    public final Draft Ea(String r2) {
        return b(r2, 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.service.impl.q] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m6b.g
    public final Draft Na(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        FetchMessageReplyDraftRequest.Builder r0 = new FetchMessageReplyDraftRequest.Builder();
        r0.message_id(r3);
        return this.a.a(r0, new q());
    }

    @Override // m6b.g
    public final Draft Pc(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return se(Collections.singletonList(r2)).get(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.ss.android.lark.chat.service.impl.l] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final String a(Draft r8) {
        switch(r8.type) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        com.bytedance.lark.pb.basic.v1.Draft.Type r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.TEXT;
    L11:
        boolean r1 = true;
        com.bytedance.lark.pb.basic.v1.Draft.Builder r2 = new com.bytedance.lark.pb.basic.v1.Draft.Builder().content(JSON.toJSONString(r8, new SerializerFeature[]{SerializerFeature.WriteClassName})).type(r0);
        RichText r3 = r8.postRichText;
        if (r3 == null) goto L14;
        com.bytedance.lark.pb.basic.v1.RichText r4 = com.ss.android.lark.parser.internal.g0.d(r3);
    L15:
        r2.cloud_draft_content(new CloudDraftContent(r8.title, r4));
        if (TextUtils.isEmpty(r8.messageId) == true) goto L19;
        r2.message_id(r8.messageId);
    L19:
        if (TextUtils.isEmpty(r8.chatId) == true) goto L22;
        r2.chat_id(r8.chatId);
    L22:
        if (TextUtils.isEmpty(r8.reEditMessageId) == true) goto L25;
        r2.edit_message_id(r8.reEditMessageId);
    L25:
        if (TextUtils.isEmpty(r8.threadId) == true) goto L28;
        r2.thread_id(r8.threadId);
    L28:
        if (r8.scheduleDraftInfo == null) goto L37;
        com.bytedance.lark.pb.basic.v1.Draft.ScheduleInfo.Builder r5 = new com.bytedance.lark.pb.basic.v1.Draft.ScheduleInfo.Builder();
        r5.schedule_time(Long.valueOf(r8.scheduleDraftInfo.getScheduleSendTime()));
        if (TextUtils.isEmpty(r8.scheduleDraftInfo.getScheduleMessageId()) == true) goto L36;
        ScheduleMessageItem.Builder r6 = new ScheduleMessageItem.Builder();
        r6.item_id(r8.scheduleDraftInfo.getScheduleMessageId());
        if (r8.scheduleDraftInfo.isPreScheduleMessage() == false) goto L34;
        ScheduleMessageItem.ItemType r7 = ScheduleMessageItem.ItemType.QUASI_SCHEDULE_MESSAGE;
    L35:
        r6.item_type(r7);
        r5.item(r6.build());
        goto L36
    L34:
        r7 = ScheduleMessageItem.ItemType.SCHEDULE_MESSAGE;
    L36:
        r2.schedule_info(r5.build());
    L37:
        PartialReplyInfo r9 = r8.partialReplyInfo;
        if (r9 == null) goto L40;
        r2.partial_reply_info(ReplyActionUtils.e(r9));
    L40:
        DraftAttachmentSnapshot r10 = r8.attachmentSnapshot;
        if (r10 != null) goto L43;
    L45:
        r1 = false;
    L46:
        if (r1 == false) goto L49;
        r2.attachment_snapshot(r8.attachmentSnapshot);
    L49:
        return this.a.d(new CreateDraftRequest.Builder().draft(r2.build()), new l(), new m());
    L43:
        if (CollectionUtils.isNotEmpty(r10.attachments) == false) goto L45;
    L14:
        r4 = null;
        goto L15
    L5:
        r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.SCHEDULE_MESSAGE;
        goto L11
    L6:
        r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.EDIT_MESSAGE;
        goto L11
    L7:
        r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.MSG_THREAD;
        goto L11
    L8:
        r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.INDIVIDUAL_TOPIC;
        goto L11
    L9:
        r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.POST;
        goto L11
    L10:
        r0 = com.bytedance.lark.pb.basic.v1.Draft.Type.TEXT;
        goto L11
    }

    @Override // m6b.g
    public final void a8(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        DeleteDraftRequest.Builder r3 = new DeleteDraftRequest.Builder().draft_id(r2);
        this.a.b(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.service.impl.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m6b.g
    public final Draft b6(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        FetchChatInputDraftRequest.Builder r1 = new FetchChatInputDraftRequest.Builder();
        r1.chat_id(r3).thread_id(null);
        return this.a.e(r1, new n());
    }

    @Override // m6b.g
    public final Draft b8(String r2) {
        return b(r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.chat.service.impl.k] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m6b.g
    public final Map<String, Draft> se(final List<String> r4) {
        if (CollectionUtils.isEmpty(r4) == true) goto L5;
        GetDraftsRequest.Builder r0 = new GetDraftsRequest.Builder();
        r0.draft_ids(r4);
        Map<String, Draft> r5 = this.a.g(r0, new k(r4));
        if (r5 == null) goto L9;
        return r5;
    L9:
        return new HashMap();
    L5:
        return new HashMap();
    }

    @Override // m6b.g
    public final void M8(String r7, int r8) {
        List r0 = Collections.singletonList(r7);
        HashMap r1 = new HashMap();
        if (CollectionUtils.isEmpty(r0) == true) goto L23;
        com.ss.android.lark.chat.utils.z0.a();
        Map<String, List<Draft>> r2 = this.a.f(new p());
        if (CollectionUtils.isNotEmpty(r2) == false) goto L23;
        Iterator r3 = r0.iterator();
    L9:
        if (r3.hasNext() == false) goto L23;
        List<Draft> r4 = r2.get((String) r3.next());
        if (r4 == null) goto L9;
        Iterator<Draft> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L9;
        Draft r6 = r5.next();
        if (r6 == null) goto L15;
        if (r6.type != r8) goto L15;
        String r9 = r6.chatId;
        if (r9 == null) goto L15;
        r1.put(r9, r6);
    L23:
        Draft r10 = (Draft) r1.get(r7);
        if (r10 != null) goto L26;
        return;
    L26:
        a8(r10.id);
    }

    @Override // m6b.g
    public final void Mb(String r2, String r3) {
        CreateOrDeleteChatLastDraftIdRequest.Builder r0 = new CreateOrDeleteChatLastDraftIdRequest.Builder();
        r0.chat_id(r2).draft_id(r3);
        this.a.h(r0);
    }

    public final Draft b(String r5, int r6) {
        com.ss.android.lark.chat.utils.z0.a();
        Map<String, List<Draft>> r0 = this.a.f(new o());
        if (CollectionUtils.isNotEmpty(r0) == false) goto L15;
        Iterator<List<Draft>> r1 = r0.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L24;
        Iterator<Draft> r2 = r1.next().iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        Draft r3 = r2.next();
        if (r3.type != r6) goto L9;
        if (TextUtils.equals(r3.messageId, r5) == false) goto L9;
        return r3;
    L24:
        return null;
    L15:
        return null;
    }

    @Override // m6b.g
    public final String x8(Chat r12, Draft r13, boolean r14) {
        String r3 = BuildConfig.FLAVOR;
        boolean r4 = false;
        if (r12 != null) goto L5;
    L44:
        Log.i("DraftService", "saveAllDraftImpl: called");
        if (r12 != null) goto L48;
        Log.e("DraftService", "saveAllDraftImpl: chat is null , method return");
    L95:
        return r3;
    L48:
        if (r13.type != 6) goto L50;
        boolean r5 = true;
    L51:
        if (r5 == false) goto L53;
    L55:
        boolean r7 = false;
    L56:
        if (r5 == false) goto L58;
    L62:
        boolean r8 = false;
    L63:
        DraftAttachmentSnapshot r9 = r13.attachmentSnapshot;
        if (r9 != null) goto L66;
    L68:
        boolean r10 = false;
    L70:
        if (TextUtils.isEmpty(r13.title) == true) goto L72;
    L75:
        if (r8 == false) goto L81;
        Log.i("DraftService", "isChatGeneralDraft: true");
        if (r4 == false) goto L79;
        Log.i("DraftService", "draft is empty, remove chat post draft");
        a8(r12.getPostDraftId());
    L93:
        if (r14 == false) goto L95;
        Mb(r12.getId(), r3);
        goto L95
    L79:
        Draft r0 = new Draft();
        r0.title = r13.title;
        r0.postRichText = r13.postRichText;
        r0.queryStatusInfo = r13.queryStatusInfo;
        r0.attachmentSnapshot = r13.attachmentSnapshot;
        Log.i("DraftService", "addPostDraft");
        r0.chatId = r12.getId();
        r0.type = 1;
        String r15 = a(r0);
    L80:
        r3 = r15;
        goto L93
    L81:
        if (r7 == false) goto L88;
        if (r4 == false) goto L87;
        Log.i("DraftService", "remove message reply draft: " + r13.messageId);
        Draft r16 = b(r13.messageId, 3);
        if (r16 == null) goto L93;
        a8(r16.id);
        goto L93
    L87:
        Log.i("DraftService", "save message reply draft: " + r13.messageId);
        Draft r1 = new Draft();
        r1.messageId = r13.messageId;
        r1.title = r13.title;
        r1.postRichText = r13.postRichText;
        r1.partialReplyInfo = r13.partialReplyInfo;
        r1.queryStatusInfo = r13.queryStatusInfo;
        r1.attachmentSnapshot = r13.attachmentSnapshot;
        String r17 = r13.messageId;
        r1.type = 3;
        r1.messageId = r17;
        r15 = a(r1);
        goto L80
    L88:
        if (r5 == false) goto L93;
        if (TextUtils.isEmpty(r13.reEditMessageId) == false) goto L92;
        Log.i("DraftService", "remove reEdit message draft, chat id is : " + r13.chatId);
        a8(r12.getReEditDraftId());
        goto L93
    L92:
        Draft r2 = new Draft();
        r2.reEditMessageId = r13.reEditMessageId;
        r2.title = r13.title;
        r2.messageId = r13.messageId;
        r2.postRichText = r13.postRichText;
        r2.chatId = r12.getId();
        r2.type = 6;
        r2.queryStatusInfo = r13.queryStatusInfo;
        r2.attachmentSnapshot = r13.attachmentSnapshot;
        r15 = a(r2);
        goto L80
    L72:
        if (com.ss.android.lark.widget.richtext.i.l(r13.postRichText) == false) goto L75;
        if (r10 == true) goto L75;
        r4 = true;
        goto L75
    L66:
        if (CollectionUtils.isNotEmpty(r9.attachments) == false) goto L68;
        r10 = true;
        goto L70
    L58:
        if (TextUtils.isEmpty(r13.reEditMessageId) == false) goto L62;
        if (TextUtils.isEmpty(r13.messageId) == false) goto L62;
        r8 = true;
        goto L63
    L53:
        if (TextUtils.isEmpty(r13.messageId) == true) goto L55;
        r7 = true;
        goto L56
    L50:
        r5 = false;
        goto L51
    L5:
        if (r12.isSecret() == false) goto L44;
        String r6 = r13.messageId;
        String r11 = r12.getId();
        RichText r18 = r13.contentRichText;
        String r19 = r13.title;
        RichText r110 = r13.postRichText;
        if (TextUtils.isEmpty(r6) == false) goto L22;
        if (TextUtils.isEmpty(r11) == true) goto L22;
        if (com.ss.android.lark.widget.richtext.i.l(r18) == false) goto L13;
        Log.i("DraftService", "removeChatTextDraft:" + r12.getTextDraftId());
        a8(r12.getTextDraftId());
    L15:
        if (TextUtils.isEmpty(r19) == true) goto L17;
    L19:
        Draft r111 = new Draft();
        r111.title = r19;
        r111.postRichText = r110;
        r111.chatId = r11;
        r111.type = 1;
        a(r111);
    L20:
        Mb(r11, BuildConfig.FLAVOR);
    L43:
        return BuildConfig.FLAVOR;
    L17:
        if (com.ss.android.lark.widget.richtext.i.l(r110) == false) goto L19;
        Log.i("DraftService", "removeChatPostDraft:" + r12.getPostDraftId());
        a8(r12.getPostDraftId());
        goto L20
    L13:
        Draft r112 = new Draft();
        r112.contentRichText = r18;
        r112.chatId = r11;
        r112.type = 0;
        a(r112);
    L22:
        if (TextUtils.isEmpty(r6) == true) goto L43;
        if (com.ss.android.lark.widget.richtext.i.l(r18) == false) goto L31;
        Draft r113 = b(r6, 0);
        if (r113 == null) goto L29;
        a8(r113.id);
    L29:
        if (r14 == false) goto L35;
        Mb(r11, BuildConfig.FLAVOR);
    L35:
        if (TextUtils.isEmpty(r19) == true) goto L37;
    L42:
        Draft r114 = new Draft();
        r114.postRichText = r110;
        r114.type = 3;
        r114.messageId = r6;
        a(r114);
        goto L43
    L37:
        if (com.ss.android.lark.widget.richtext.i.l(r110) == false) goto L42;
        Draft r115 = b(r6, 3);
        if (r115 == null) goto L43;
        a8(r115.id);
        goto L43
    L31:
        Draft r116 = new Draft();
        r116.contentRichText = r18;
        r116.messageId = r6;
        String r117 = a(r116);
        if (r14 == false) goto L35;
        Mb(r11, r117);
        goto L35
    }

    @Override // m6b.g
    public final void o5(b2.a r3, String r4, String r5, a r6) {
        if (r3.a != null) goto L6;
        return;
    L6:
        if (r6.a().booleanValue() == true) goto L8;
        return;
    L8:
        PutChatOrThreadDraftsUpdateRequest.Builder r7 = new PutChatOrThreadDraftsUpdateRequest.Builder();
        r7.chat_id(r3.a).thread_id(null).chat_input_draft_id(r3.b).chat_type(r4).chat_type_detail(r5);
        this.a.c(r7);
    }

    @Override // m6b.g
    public final void tc(String r7, Draft r8, boolean r9, String r10) {
        Log.i("DraftService", "save schedule send draft, chat id = " + r7 + ", type = " + r8.type);
        if (r8.type == 7) goto L5;
        return;
    L5:
        ScheduleDraftInfo r11 = r8.scheduleDraftInfo;
        if (r11 != null) goto L8;
    L11:
        Log.i("DraftService", "remove schedule send draft, chat id is " + r7 + ", remove draft id = " + r10);
        a8(r10);
        String r12 = BuildConfig.FLAVOR;
    L12:
        Log.i("DraftService", "save schedule draft success, chat id = " + r7 + ", draft id = " + r12);
        Mb(r7, r12);
        return;
    L8:
        if (r11.getScheduleSendTime() == 0) goto L11;
        Draft r13 = new Draft();
        r13.title = r8.title;
        r13.messageId = r8.messageId;
        r13.threadId = r8.threadId;
        r13.chatId = r7;
        r13.postRichText = r8.postRichText;
        r13.type = 7;
        r13.scheduleDraftInfo = r8.scheduleDraftInfo;
        r13.partialReplyInfo = r8.partialReplyInfo;
        r13.attachmentSnapshot = r8.attachmentSnapshot;
        r12 = a(r13);
        goto L12
    }
}
