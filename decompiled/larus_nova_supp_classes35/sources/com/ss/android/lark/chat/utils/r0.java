package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.doc.entity.DocCard;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.doc.entity.DocResult;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r0 {
    public static Pair<Integer, TimeUnit> a(long r5) {
        if (r5 >= 3600) goto L7;
        return new Pair(Integer.valueOf((int) (r5 / 60)), TimeUnit.MINUTES);
    L7:
        if (r5 > 86400) goto L11;
        return new Pair(Integer.valueOf((int) (r5 / 3600)), TimeUnit.HOURS);
    L11:
        return new Pair(Integer.valueOf((int) (r5 / 86400)), TimeUnit.DAYS);
    }

    public static MessageIdentity b(Message r5) {
        MessageIdentity r0 = new MessageIdentity(r5.getId(), r5.getChatId(), r5.getSourceId(), r5.getSourceType());
        r0.setSenderId(r5.getFromId());
        r0.setSenderTenantId(r5.getFromChatterTenantId());
        r0.setHideStickerSave(true);
        if (r5.isPreMessage() == false) goto L6;
        r0.setHideEditor(true);
        r0.setHideForward(true);
        r0.setHideJumpChat(true);
        r0.setHideSaveToDriver(true);
        r0.setHideCopy(true);
        r0.setHideImageOCR(true);
    L17:
        return r0;
    L6:
        if (r5.getType() != Message.Type.IMAGE) goto L9;
        r0.setHideStickerSave(false);
        goto L17
    L9:
        if (r5.getType() != Message.Type.POST) goto L11;
    L16:
        r0.setHideStickerSave(false);
        goto L17
    L11:
        if (r5.getType() == Message.Type.TEXT) goto L16;
        if (r5.getType() != Message.Type.STICKER) goto L17;
        r0.setHideCopy(true);
        goto L17
    }

    public static MessageIdentity c(f5b.b r2) {
        MessageIdentity r0 = b(r2.getMessage());
        ChatChatter r3 = r2.getMessageSender();
        if (r0.getSenderTenantId() != null) goto L6;
        if (r3 == null) goto L6;
        r0.setSenderTenantId(r3.getTenantId());
    L6:
        return r0;
    }

    public static MessageUrlPreview d(MessageInfo r5) {
        Message r6 = r5.getMessage();
        if (r6.getStatus() != Message.Status.DELETED) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L24:
        return null;
    L9:
        if (r6.getType() != Message.Type.TEXT) goto L12;
        List<MessageUrlPreview> r7 = ((TextContent) r6.getContent()).getUrlPreviewList();
    L15:
        if (r7 == null) goto L24;
        if (r7.size() != 1) goto L24;
        if (((MessageUrlPreview) ListProtector.get(r7, 0)).isDeleted() == true) goto L24;
        if (TextUtils.isEmpty(((MessageUrlPreview) ListProtector.get(r7, 0)).getTitle()) == true) goto L24;
        return (MessageUrlPreview) ListProtector.get(r7, 0);
    L12:
        if (r6.getType() != Message.Type.POST) goto L14;
        r7 = ((PostContent) r6.getContent()).getUrlPreviewList();
        goto L15
    L14:
        r7 = null;
        goto L15
    L5:
        r0 = false;
        goto L7
    }

    public static boolean e(m6b.j r9, Message r10) {
        MessageTenantConfService.c r11 = (MessageTenantConfService.c) r9.getConfig().getValue();
        if (r11 == null) goto L17;
        if (r10 == null) goto L18;
        long r1 = r11.b;
        if (r1 != (-1)) goto L10;
        return true;
    L10:
        if (r1 != 0) goto L13;
        return false;
    L13:
        if ((ChatCoreModule.a().getSettingDependency().a() - (r10.getCreateTime() * 1000)) < ((r1 * 1000) + 5000)) goto L19;
        return false;
    L19:
        return true;
    L18:
        return true;
    L17:
        return true;
    }

    public static boolean f(DocResult r7, boolean r8) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.getDocCard() != null) goto L9;
        return false;
    L9:
        if (r7.getDoc() != null) goto L11;
        return false;
    L11:
        DocPermission r1 = r7.getDocCard().getUserPermission();
        if (r1 != null) goto L14;
    L25:
        DocCard r9 = r7.getDocCard();
        if (r8 == true) goto L28;
    L33:
        return true;
    L28:
        if (r9.isShouldRender() == true) goto L33;
        if (r9.getShareStatus() > 1) goto L33;
        if (r9.getPermissions().size() > 0) goto L33;
        return false;
    L14:
        if (r1.getPermCode() != (-1)) goto L25;
        DocCard r2 = r7.getDocCard();
        r2.getUserPermission().setPermCode(0);
        int r3 = 0;
    L17:
        if (r3 >= r2.getPermissions().size()) goto L25;
        DocPermission r4 = (DocPermission) ListProtector.get(r2.getPermissions(), r3);
        if (r4.canEdit() == false) goto L22;
        r2.getUserPermission().setEdit(true);
    L22:
        if (r4.canRead() == false) goto L24;
        r2.getUserPermission().setRead(true);
    L24:
        r2.getUserPermission().setShare(r8);
        r3 = r3 + 1;
        goto L17
    }
}
