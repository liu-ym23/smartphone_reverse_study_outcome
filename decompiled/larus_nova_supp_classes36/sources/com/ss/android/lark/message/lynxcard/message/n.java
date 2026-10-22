package com.ss.android.lark.message.lynxcard.message;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.message.card.CardMessageUtils;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements v5b.b<LynxCardContentVO> {
    public n() {
    }

    public final MessageType a() {
        return MessageType.CARD;
    }

    public final CharSequence b(p5b.c r6) {
        Intrinsics.checkNotNullParameter(r6, "messageInfo");
        CardContent r0 = r6.getMessage().getContent();
        if (r0.getType() != CardContent.Type.VOTE) goto L6;
        int r7 = 2131892324;
    L28:
        return UIHelper.getString(r7);
    L6:
        if (r0.getType() != CardContent.Type.TEXT) goto L24;
        p5b.a r1 = (p5b.a) r6;
        boolean r2 = true;
        boolean r3 = !r1.isShowMessageOriginContent();
        if (r6.getMessage().getTranslateDisplayRule() != 3) goto L10;
        boolean r8 = true;
    L11:
        if (r3 == false) goto L15;
        if (r8 == true) goto L15;
        r2 = false;
    L15:
        CardContent r9 = r1.getTranslateContent(r2);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.CardContent");
        String r10 = r9.getLynxSimpleDigest();
        if (TextUtils.isEmpty(r10) == true) goto L22;
        if (r10 == null) goto L22;
        if (r2 == true) goto L21;
        r10 = UIHelper.getString(2131892287) + r10;
    L21:
        return r10.toString();
    L22:
        r7 = 2131892261;
        goto L28
    L10:
        r8 = false;
        goto L11
    L24:
        if (r0.getType() != CardContent.Type.VCHAT) goto L26;
        r7 = 2131892309;
        goto L28
    L26:
        r7 = 2131892296;
        goto L28
    }

    public final v5b.a c(p5b.c r7) {
        Intrinsics.checkNotNullParameter(r7, "messageInfo");
        Message r0 = r7.getMessage();
        CardContent r1 = r0.getContent();
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r0 instanceof Message) == false) goto L8;
        Message r3 = r0;
        r1.setMessageId(r3.getId());
        r1.setContentVersion(r3.getContentVersion());
        long r4 = r3.getCreateTime();
    L10:
        if (lrb.a.a(r1, r4) == false) goto L22;
        LynxCardContentVO r5 = new LynxCardContentVO(r1);
        ((v5b.a) r5).a.setRichText(null);
        int r6 = CardMessageUtils.a;
        if (CardMessageUtils.a.a(r1) == false) goto L21;
        if ((r7 instanceof f5b.b) == false) goto L21;
        f5b.b r8 = (f5b.b) r7;
        Message r9 = r8.getMessage();
        ((com.ss.android.lark.chat.base.view.vo.message.f) r5).b = r9.getTranslateLanguage();
        ((com.ss.android.lark.chat.base.view.vo.message.f) r5).e = r9.isAutoTranslatedForReceiver();
        ((com.ss.android.lark.chat.base.view.vo.message.f) r5).f = r0.getTranslateDisplayRule();
        ((com.ss.android.lark.chat.base.view.vo.message.f) r5).c = r8.isTranslating();
        r1.setTranslate(Boolean.FALSE);
        TranslateInfo r10 = r8.getTranslateInfo();
        if (r10 == null) goto L21;
        CardContent r2 = r10.getTranslateContent();
        if (r2 == null) goto L21;
        LynxCardContentVO r11 = new LynxCardContentVO(r2);
        ((com.ss.android.lark.chat.base.view.vo.message.f) r11).b = r10.getLanguage();
        ((v5b.a) r11).a.setRichText(null);
        ((com.ss.android.lark.chat.base.view.vo.message.f) r5).g = r11;
        r2.setTranslate(Boolean.TRUE);
        r2.setMessageId(r1.getMessageId());
    L21:
        return r5;
    L22:
        return null;
    L8:
        r4 = 0;
        goto L10
    }
}
