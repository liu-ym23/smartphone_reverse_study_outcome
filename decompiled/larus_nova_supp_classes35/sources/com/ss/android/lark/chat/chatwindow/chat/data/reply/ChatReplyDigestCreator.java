package com.ss.android.lark.chat.chatwindow.chat.data.reply;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.service.impl.a1;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.e;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.chat.utils.n;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.span.i0;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatReplyDigestCreator extends BaseReplyMsgDigestCreator {
    public final Lazy d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public ChatReplyDigestCreator(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        super(r2);
        this.d = LazyKt.lazy(ChatReplyDigestCreator$extensionDependency$2.INSTANCE);
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.reply.BaseReplyMsgDigestCreator
    public final CharSequence b(ChatChatter r10, MessageInfo r11, boolean r12, PartialReplyInfo r13) {
        Intrinsics.checkNotNullParameter(r11, "replyMsgInfo");
        List r0 = null;
        String r1 = null;
        List r2 = null;
        String r3 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        int r4 = a.a[ReplyInThreadUtil.d(this.a.C()).ordinal()];
        boolean r5 = true;
        if (r4 != 1) goto L8;
    L13:
        String r14 = m.b(r10, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true) + 65306;
    L14:
        Message r6 = r11.getMessage();
        Message.Type r7 = r6.getType();
        boolean r8 = false;
        if (r7 != Message.Type.TEXT) goto L72;
        boolean r15 = !r11.isShowMessageOriginContent();
        if (r11.getMessage().getTranslateDisplayRule() != 3) goto L19;
        boolean r9 = true;
    L20:
        if (r15 == false) goto L24;
        if (r9 == true) goto L24;
        r5 = false;
    L24:
        TextContent r16 = (TextContent) r11.getTranslateContent(r5);
        if (r5 == true) goto L27;
        r14 = r14 + UIHelper.getString(2131892287);
    L27:
        if (r16 == null) goto L70;
        SpannableStringBuilder r17 = new SpannableStringBuilder(r14);
        PartialReplyInfo r18 = r11.getPartialReplyInfo();
        if (r18 == null) goto L31;
        RichText r19 = r18.getContent();
    L32:
        if (r19 == null) goto L37;
        PartialReplyInfo r110 = r11.getPartialReplyInfo();
        if (r110 == null) goto L36;
        RichText r111 = r110.getContent();
    L41:
        if (r11.getPartialReplyInfo() == null) goto L43;
        r13 = r11.getPartialReplyInfo();
    L43:
        CharSequence r112 = i.j(r111);
        if (TextUtils.isEmpty(r112) == false) goto L55;
        ArrayList<File> r113 = r16.getAttachments();
        TextContent r114 = (TextContent) r6.getContent();
        if (r114 == null) goto L48;
        List r115 = r114.getAttachments();
    L49:
        if (r115 != null) goto L52;
        r115 = CollectionsKt.emptyList();
    L52:
        if (e.b(r113, r115) == false) goto L54;
        r1 = UIHelper.getString(2131890956);
    L54:
        r112 = r1;
    L67:
        if (r112 == null) goto L70;
        r17.append(ReplyActionUtils.b(r112, r13));
        c(r17, r11, r13);
        return r17;
    L48:
        r115 = null;
        goto L49
    L55:
        ArrayList<File> r116 = r16.getAttachments();
        TextContent r20 = (TextContent) r6.getContent();
        if (r20 == null) goto L58;
        r2 = r20.getAttachments();
    L58:
        if (r2 != null) goto L61;
        r2 = CollectionsKt.emptyList();
    L61:
        if (ReplyActionUtils.c() == false) goto L64;
        if (r13 == null) goto L64;
    L65:
        if (r8 == false) goto L67;
        StringBuilder r117 = new StringBuilder();
        r117.append(r112);
        int r118 = e.a;
        r117.append(UIHelper.getString(2131890956));
        r112 = r117.toString();
    L64:
        r8 = e.b(r116, r2);
        goto L65
    L36:
        r111 = null;
        goto L41
    L37:
        if (r13 == null) goto L39;
        r111 = r13.getContent();
        goto L41
    L39:
        r111 = r16.getRichText();
        goto L41
    L31:
        r19 = null;
    L70:
        return BuildConfig.FLAVOR;
    L19:
        r9 = false;
        goto L20
    L72:
        if (r7 != Message.Type.IMAGE) goto L75;
        return r14 + UIUtils.getString(ChatCoreModule.a().getContext(), 2131891845);
    L75:
        if (r7 != Message.Type.MEDIA) goto L78;
        return r14 + UIUtils.getString(ChatCoreModule.a().getContext(), 2131891923);
    L78:
        if (r7 != Message.Type.STICKER) goto L81;
        return r14 + n.a((StickerContent) r6.getContent());
    L81:
        if (r7 != Message.Type.POST) goto L144;
        boolean r21 = !r11.isShowMessageOriginContent();
        if (r11.getMessage().getTranslateDisplayRule() != 3) goto L85;
        boolean r22 = true;
    L86:
        if (r21 == false) goto L90;
        if (r22 == true) goto L90;
        boolean r23 = false;
    L91:
        if (r23 == true) goto L93;
        r14 = r14 + UIHelper.getString(2131892287);
    L93:
        PostContent r24 = (PostContent) r11.getTranslateContent(r23);
        if (r24 == null) goto L178;
        SpannableStringBuilder r25 = new SpannableStringBuilder(r14);
        if (r11.getPartialReplyInfo() == null) goto L98;
        r13 = r11.getPartialReplyInfo();
    L98:
        if (r13 == null) goto L101;
        RichText r119 = r13.getContent();
        if (r119 == null) goto L101;
    L102:
        if (r13 != null) goto L104;
    L106:
        r5 = false;
    L108:
        if (TextUtils.isEmpty(r24.getTitleWithFilter(ChatCoreModule.a().getContext())) == true) goto L112;
        if (r5 == true) goto L112;
        CharSequence r120 = r24.getTitleWithFilter(ChatCoreModule.a().getContext());
    L114:
        if (TextUtils.isEmpty(r120) == false) goto L125;
        ArrayList<File> r121 = r24.getAttachments();
        PostContent r26 = (PostContent) r6.getContent();
        if (r26 == null) goto L118;
        List r27 = r26.getAttachments();
    L119:
        if (r27 != null) goto L122;
        r27 = CollectionsKt.emptyList();
    L122:
        if (e.b(r121, r27) == false) goto L124;
        r3 = UIHelper.getString(2131890956);
    L124:
        r120 = r3;
    L137:
        if (r12 == false) goto L139;
        r25.append(UIUtils.getString(ChatCoreModule.a().getContext(), 2131892092));
        r25.append(" ");
    L139:
        if (r120 == null) goto L141;
        r25.append(ReplyActionUtils.b(r120, r13));
    L141:
        c(r25, r11, r13);
        return r25;
    L118:
        r27 = null;
        goto L119
    L125:
        ArrayList<File> r28 = r24.getAttachments();
        PostContent r29 = (PostContent) r6.getContent();
        if (r29 == null) goto L128;
        r0 = r29.getAttachments();
    L128:
        if (r0 != null) goto L131;
        r0 = CollectionsKt.emptyList();
    L131:
        if (ReplyActionUtils.c() == false) goto L134;
        if (r13 == null) goto L134;
    L135:
        if (r8 == false) goto L137;
        StringBuilder r30 = new StringBuilder();
        r30.append(r120);
        int r122 = e.a;
        r30.append(UIHelper.getString(2131890956));
        r120 = r30.toString();
    L134:
        r8 = e.b(r28, r0);
    L112:
        r120 = i.j(r119);
        goto L114
    L104:
        if (ReplyActionUtils.c() == false) goto L106;
    L101:
        r119 = r24.getRichText();
        goto L102
    L178:
        return null;
    L90:
        r23 = true;
        goto L91
    L85:
        r22 = false;
        goto L86
    L144:
        if (r7 != Message.Type.FILE) goto L147;
        FileContent r123 = (FileContent) r6.getContent();
        StringBuilder r31 = new StringBuilder();
        r31.append(r14);
        r31.append(UIUtils.getString(ChatCoreModule.a().getContext(), 2131891743) + ' ' + r123.getName());
        return r31.toString();
    L147:
        if (r7 != Message.Type.AUDIO) goto L150;
        AudioContent r124 = (AudioContent) r6.getContent();
        return r14 + UIUtils.getString(ChatCoreModule.a().getContext(), 2131891532);
    L150:
        if (r7 != Message.Type.SHARE_GROUP_CHAT) goto L153;
        ShareGroupChatContent r125 = (ShareGroupChatContent) r6.getContent();
        return r14 + h0.e(r6);
    L153:
        if (r7 != Message.Type.MERGE_FORWARD) goto L160;
        MergeForwardContent r126 = (MergeForwardContent) r6.getContent();
        StringBuilder r127 = new StringBuilder();
        r127.append(r14);
        if (r126.isFromPrivateTopic() == false) goto L157;
        String r128 = UIHelper.getString(2131891921);
    L158:
        r127.append(r128);
        return r127.toString();
    L157:
        r128 = a1.a(r126).a;
        goto L158
    L160:
        if (r7 != Message.Type.RED_PACKET) goto L163;
        return r14 + UIHelper.getString(2131890895);
    L163:
        if (r7 != Message.Type.SHARE_USER_CARD) goto L166;
        return r14 + UIHelper.mustacheFormat(2131892097, "user_name", ((ProfileContent) r6.getContent()).getDisplayName());
    L166:
        if (r7 != Message.Type.FOLDER) goto L168;
        FolderContent r129 = (FolderContent) r6.getContent();
        StringBuilder r32 = new StringBuilder();
        r32.append(r14);
        r32.append(UIUtils.getString(ChatCoreModule.a().getContext(), 2131891743) + ' ' + r129.getName());
        return r32.toString();
    L168:
        Context r130 = ChatCoreModule.a().getContext();
        MessageType.a r131 = MessageType.Companion;
        int r132 = r6.getType().getNumber();
        r131.getClass();
        gya.a<Content> r133 = ((d) this.d.getValue()).a(MessageType.a.a(r132));
        if (r133 == null) goto L174;
        Content r134 = r6.getContent();
        Intrinsics.checkNotNull(r130);
        String r135 = r133.d(r130, r134);
        if (r135 != null) goto L173;
        return null;
    L173:
        r14 = r14 + r135;
    L175:
        if (r5 == true) goto L189;
        return null;
    L189:
        return r14;
    L174:
        r5 = false;
        goto L175
    L8:
        if (r4 == 2) goto L13;
        if (r4 != 3) goto L12;
        r14 = UIHelper.mustacheFormat(2131892132, IPortraitService.NAME, m.b(r10, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true)) + 65306;
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
