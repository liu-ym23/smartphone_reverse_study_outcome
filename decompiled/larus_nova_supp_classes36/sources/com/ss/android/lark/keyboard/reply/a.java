package com.ss.android.lark.keyboard.reply;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.reply.BaseReplyMsgDigestCreator;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.service.impl.a1;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.chat.utils.n;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.span.i0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import w4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BaseReplyMsgDigestCreator {
    public final Lazy d;

    public a(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        super(r2);
        this.d = LazyKt.lazy(FlowChatReplyDigestCreator$extensionDependency$2.INSTANCE);
    }

    public final void c(SpannableStringBuilder r4, MessageInfo r5, PartialReplyInfo r6) {
        if (r5.getMessage().getEditInfo().isEdited() == true) goto L6;
        return;
    L6:
        if (ReplyActionUtils.c() == false) goto L9;
        if (r6 == null) goto L9;
        return;
    L9:
        Context r7 = ChatCoreModule.a().getContext();
        String r8 = r7.getString(2131891078);
        Intrinsics.checkNotNull(r7);
        Object r0 = new i0(r8, UDColorUtils.getColor(r7, 2131106620), UIUtils.dp2px(r7, 12.0f));
        int r9 = r4.length();
        r4.append(r8);
        r4.setSpan(r0, r9, r4.length(), 33);
    }

    public final CharSequence b(ChatChatter r9, MessageInfo r10, boolean r11, PartialReplyInfo r12) {
        Intrinsics.checkNotNullParameter(r10, "replyMsgInfo");
        Message r13 = r10.getMessage();
        Message.Type r0 = r13.getType();
        boolean r4 = false;
        RichText r5 = null;
        String r7 = "";
        if (r0 != Message.Type.TEXT) goto L35;
        boolean r14 = !r10.isShowMessageOriginContent();
        if (r10.getMessage().getTranslateDisplayRule() != 3) goto L7;
        boolean r15 = true;
    L8:
        if (r14 == false) goto L10;
        if (r15 == true) goto L10;
    L11:
        TextContent r16 = r10.getTranslateContent(r4);
        if (r4 == true) goto L14;
        String r17 = "" + UIHelper.getString(2131892287);
    L15:
        if (r16 == null) goto L133;
        SpannableStringBuilder r1 = new SpannableStringBuilder(r17);
        PartialReplyInfo r18 = r10.getPartialReplyInfo();
        if (r18 == null) goto L19;
        RichText r19 = r18.getContent();
    L20:
        if (r19 == null) goto L24;
        PartialReplyInfo r20 = r10.getPartialReplyInfo();
        if (r20 == null) goto L27;
        r5 = r20.getContent();
    L27:
        CharSequence r21 = i.j(r5);
        if (r21 != null) goto L30;
        return "";
    L30:
        if (r10.getPartialReplyInfo() == null) goto L32;
        r12 = r10.getPartialReplyInfo();
    L32:
        r1.append(ReplyActionUtils.b(r21, r12));
        c(r1, r10, r12);
        return r1;
    L24:
        if (r12 == null) goto L26;
        r5 = r12.getContent();
        goto L27
    L26:
        r5 = r16.getRichText();
        goto L27
    L19:
        r19 = null;
        goto L20
    L133:
        return "";
    L14:
        r17 = "";
    L10:
        r4 = true;
        goto L11
    L7:
        r15 = false;
        goto L8
    L35:
        if (r0 != Message.Type.IMAGE) goto L38;
        return "" + UIUtils.getString(ChatCoreModule.a().getContext(), 2131891845);
    L38:
        if (r0 != Message.Type.MEDIA) goto L41;
        return "" + UIUtils.getString(ChatCoreModule.a().getContext(), 2131891923);
    L41:
        if (r0 != Message.Type.STICKER) goto L44;
        return "" + n.a(r13.getContent());
    L44:
        if (r0 != Message.Type.POST) goto L82;
        boolean r22 = !r10.isShowMessageOriginContent();
        if (r10.getMessage().getTranslateDisplayRule() != 3) goto L48;
        boolean r2 = true;
    L49:
        if (r22 == false) goto L53;
        if (r2 == true) goto L53;
        boolean r23 = false;
    L54:
        if (r23 == true) goto L56;
        r7 = "" + UIHelper.getString(2131892287);
    L56:
        PostContent r24 = r10.getTranslateContent(r23);
        if (r24 == null) goto L80;
        r5 = new SpannableStringBuilder(r7);
        if (r10.getPartialReplyInfo() == null) goto L61;
        r12 = r10.getPartialReplyInfo();
    L61:
        if (r12 == null) goto L64;
        RichText r3 = r12.getContent();
        if (r3 == null) goto L64;
    L65:
        if (r12 == null) goto L70;
        if (ReplyActionUtils.c() == false) goto L70;
        r4 = true;
    L70:
        if (TextUtils.isEmpty(r24.getTitleWithFilter(ChatCoreModule.a().getContext())) == true) goto L74;
        if (r4 == true) goto L74;
        CharSequence r25 = r24.getTitleWithFilter(ChatCoreModule.a().getContext());
    L75:
        if (r11 == false) goto L77;
        r5.append(UIUtils.getString(ChatCoreModule.a().getContext(), 2131892092));
        r5.append(" ");
    L77:
        if (r25 == null) goto L79;
        r5.append(ReplyActionUtils.b(r25, r12));
    L79:
        c(r5, r10, r12);
    L74:
        r25 = i.j(r3);
    L64:
        r3 = r24.getRichText();
    L80:
        return r5;
    L53:
        r23 = true;
        goto L54
    L48:
        r2 = false;
        goto L49
    L82:
        if (r0 != Message.Type.FILE) goto L85;
        return "" + r13.getContent().getName();
    L85:
        if (r0 != Message.Type.AUDIO) goto L88;
        AudioContent r26 = r13.getContent();
        StringBuilder r110 = new StringBuilder("");
        r110.append(UIUtils.getString(ChatCoreModule.a().getContext(), 2131891532) + ' ' + (String.valueOf(r26.getDuration() / AudioViewModel.ASR_SESSION_IDLE) + 8243));
        return r110.toString();
    L88:
        if (r0 != Message.Type.SHARE_GROUP_CHAT) goto L91;
        ShareGroupChatContent r111 = r13.getContent();
        return "" + h0.e(r13);
    L91:
        if (r0 != Message.Type.MERGE_FORWARD) goto L98;
        MergeForwardContent r27 = r13.getContent();
        StringBuilder r112 = new StringBuilder("");
        if (r27.isFromPrivateTopic() == false) goto L95;
        String r28 = UIHelper.getString(2131891921);
    L96:
        r112.append(r28);
        return r112.toString();
    L95:
        r28 = a1.a(r27).a;
        goto L96
    L98:
        if (r0 != Message.Type.RED_PACKET) goto L101;
        return "" + UIHelper.getString(2131890895);
    L101:
        if (r0 != Message.Type.SHARE_USER_CARD) goto L104;
        return "" + UIHelper.mustacheFormat(2131892097, "user_name", r13.getContent().getDisplayName());
    L104:
        if (r0 != Message.Type.FOLDER) goto L107;
        FolderContent r29 = r13.getContent();
        StringBuilder r113 = new StringBuilder("");
        r113.append(UIUtils.getString(ChatCoreModule.a().getContext(), 2131891743) + ' ' + r29.getName());
        return r113.toString();
    L107:
        if (r0 != Message.Type.DOUBAO) goto L125;
        SpannableStringBuilder r30 = new SpannableStringBuilder("");
        PartialReplyInfo r114 = r10.getPartialReplyInfo();
        if (r114 == null) goto L111;
        RichText r115 = r114.getContent();
    L112:
        if (r115 == null) goto L116;
        PartialReplyInfo r116 = r10.getPartialReplyInfo();
        if (r116 == null) goto L118;
        r5 = r116.getContent();
    L118:
        CharSequence r117 = i.j(r5);
        if (r117 != null) goto L121;
        return "";
    L121:
        if (r10.getPartialReplyInfo() == null) goto L123;
        r12 = r10.getPartialReplyInfo();
    L123:
        r30.append(ReplyActionUtils.b(r117, r12));
        c(r30, r10, r12);
        return r30;
    L116:
        if (r12 == null) goto L118;
        r5 = r12.getContent();
        goto L118
    L111:
        r115 = null;
        goto L112
    L125:
        Context r118 = ChatCoreModule.a().getContext();
        MessageType.a r119 = MessageType.Companion;
        int r120 = r13.getType().getNumber();
        r119.getClass();
        gya.a r121 = ((d) this.d.getValue()).a(MessageType.a.a(r120));
        if (r121 == null) goto L131;
        Content r31 = r13.getContent();
        Intrinsics.checkNotNull(r118);
        r7 = r121.d(r118, r31);
        if (r7 != null) goto L130;
        return null;
    L130:
        r4 = true;
    L131:
        if (r4 == true) goto L146;
        return null;
    L146:
        return r7;
    }
}
