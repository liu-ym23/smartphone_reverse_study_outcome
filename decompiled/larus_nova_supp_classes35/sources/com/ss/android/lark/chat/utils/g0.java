package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g0 {
    public static CharSequence a(RichText r4, int r5) {
        iec.g.a r0 = new iec.g.a();
        r0.a = false;
        r0.b = false;
        r0.d.a = true;
        iec.a r2 = r0.e;
        r2.a = true;
        r2.b = false;
        r2.d = r5;
        r0.b(new iec.f(UIHelper.getContext(), (int) UIHelper.sp2px(15.0f), (int) UIHelper.sp2px(13.0f)));
        return com.ss.android.lark.utils.o.c(com.ss.android.lark.widget.richtext.i.d(r4, r0.a()));
    }

    public static CharSequence b(Context r3, Message r4, int r5) {
        if (r4.isRemoved() == false) goto L6;
        return UIHelper.getString(2131891925);
    L6:
        if (r4.getStatus() == Message.Status.DELETED) goto L85;
        Message.Type r0 = r4.getType();
        if (r0 != Message.Type.TEXT) goto L12;
        TextContent r6 = (TextContent) r4.getContent();
        return e.a(a(r6.getRichText(), r5), r6.getAttachments(), null);
    L12:
        if (r0 != Message.Type.IMAGE) goto L15;
        return UIUtils.getString(r3, 2131891845);
    L15:
        if (r0 != Message.Type.MEDIA) goto L18;
        return UIUtils.getString(r3, 2131891923);
    L18:
        if (r0 != Message.Type.POST) goto L28;
        PostContent r1 = (PostContent) r4.getContent();
        if (TextUtils.isEmpty(r4.getRootId()) == true) goto L22;
    L25:
        CharSequence r7 = a(r1.getRichText(), r5);
    L89:
        return e.a(r7, r1.getAttachments(), null);
    L22:
        if (TextUtils.isEmpty(r1.getTitleWithFilter(r3)) == true) goto L25;
        r7 = r1.getTitleWithFilter(r3);
        goto L89
    L28:
        if (r0 != Message.Type.FILE) goto L31;
        return UIUtils.getString(r3, 2131891743) + ((FileContent) r4.getContent()).getName();
    L31:
        if (r0 != Message.Type.AUDIO) goto L34;
        return UIUtils.getString(r3, 2131891532);
    L34:
        if (r0 != Message.Type.STICKER) goto L37;
        return n.a((StickerContent) r4.getContent());
    L37:
        if (r0 == Message.Type.RED_PACKET) goto L93;
        Message.Type r8 = Message.Type.SHARE_GROUP_CHAT;
        String r2 = BuildConfig.FLAVOR;
        if (r0 != r8) goto L47;
        ShareGroupChatContent r9 = (ShareGroupChatContent) r4.getContent();
        if (r9 == null) goto L99;
        if (r9.getChat() == null) goto L99;
        return h0.e(r4);
    L99:
        return r2;
    L47:
        if (r0 != Message.Type.SYSTEM) goto L64;
        SystemContent r10 = (SystemContent) r4.getContent();
        if (r10 == null) goto L99;
        if (r10.isVoIPSystemMessage() == false) goto L98;
        String r11 = UIHelper.getString(2131892321);
        if (r10.getType() != SystemMessageType.USER_CALL_E2EE_VOICE_DURATION) goto L56;
        return r11 + r10.getFormattedContent();
    L56:
        if (r10.getType() != SystemMessageType.USER_CALL_E2EE_VOICE_ON_CANCELL) goto L59;
        return r11 + UIHelper.getString(2131892318);
    L59:
        if (r10.getType() != SystemMessageType.USER_CALL_E2EE_VOICE_ON_MISSING) goto L99;
        return r11 + UIHelper.getString(2131892320);
    L98:
        return r10.getFormattedContent();
    L64:
        if (r0 != Message.Type.MERGE_FORWARD) goto L67;
        return UIHelper.getString(2131891921);
    L67:
        if (r0 != Message.Type.SHARE_USER_CARD) goto L70;
        return UIHelper.mustacheFormat(2131892097, "user_name", ((ProfileContent) r4.getContent()).getDisplayName());
    L70:
        if (r0 == Message.Type.FOLDER) goto L102;
        w4b.d r12 = ChatCoreModule.a().getExtensionDependency();
        MessageType.a r13 = MessageType.Companion;
        int r14 = r4.getType().getNumber();
        r13.getClass();
        gya.a<Content> r15 = r12.a(MessageType.a.a(r14));
        if (r15 != null) goto L103;
        Content r16 = r4.getContent();
        if ((r16 instanceof TextContent) == false) goto L81;
        RichText r17 = ((TextContent) r16).getRichText();
        if (r17 == null) goto L81;
        r2 = r17.getInnerText();
    L81:
        if (TextUtils.isEmpty(r2) == false) goto L99;
        return UIHelper.getString(2131892305);
    L103:
        return r15.f(r3, r4.getContent());
    L102:
        return UIUtils.getString(r3, 2131891743) + ((FolderContent) r4.getContent()).getName();
    L93:
        return UIUtils.getString(r3, 2131892125);
    L85:
        return UIUtils.getString(r3, 2131891918);
    }
}
