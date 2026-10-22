package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.biz.im.api.n1;
import com.ss.android.lark.biz.im.api.o1;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.export.entity.chatter.IChatterDesc;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements Function1<f5b.b, f5b.b> {
    public final a2b.f a;
    public final List<UrlPreViewEntries> b;
    public final ChatHitPointExtraParams.DataSource c;

    public final Object invoke(Object r8) {
        f5b.b r9 = (f5b.b) r8;
        Long r0 = null;
        if (r9 == null) goto L7;
        ChatChatter r1 = r9.getMessageSender();
        if (r1 == null) goto L7;
        Chatter r2 = r1.getChatter();
    L8:
        if (r2 == null) goto L10;
        String r3 = r2.getId();
    L11:
        if (r2 == null) goto L15;
        IChatterDesc r4 = r2.getDesc();
        if (r4 == null) goto L15;
        String r5 = r4.getContent();
    L16:
        if (r2 == null) goto L18;
        UserPrivateDescription r6 = r2.getPrivateDescription();
    L19:
        int r7 = o1.a;
        if (r6 != null) goto L22;
    L33:
        r6 = null;
    L34:
        if (r6 == null) goto L39;
        String r10 = r6.getContent();
        if (r10 == null) goto L39;
        r5 = r10;
    L39:
        if (r6 == null) goto L41;
        r0 = r6.getDescriptionId();
    L41:
        n1 r11 = o1.a(r3, r5, r0);
        if (r11 == null) goto L48;
        List<UrlPreViewEntries> r12 = this.b;
        if (r12 == null) goto L46;
        int r13 = UserStatusParseUrlPreViewUtils.a;
        UserStatusParseUrlPreViewUtils.c(r12, CollectionsKt.listOf(new UserStatusParseUrlPreViewUtils.b(r11.a, r11.b, r11.c, r11.d)), ChatHitPointExtraParams.UrlAnalysisScene.CHAT_STATUS, this.c);
    L46:
        if (r9 == null) goto L48;
        r9.setForceUpdate(true);
    L48:
        return r9;
    L22:
        if (Intrinsics.areEqual(r3, null) == false) goto L24;
    L30:
        boolean r14 = false;
    L31:
        if (r14 == false) goto L33;
    L24:
        if (r6.isClearMarker() == true) goto L30;
        if (r6.isFailedMarker() == true) goto L30;
        if (r6.hasContent() == false) goto L30;
        r14 = true;
        goto L31
    L18:
        r6 = null;
    L15:
        r5 = null;
        goto L16
    L10:
        r3 = null;
    L7:
        r2 = null;
        goto L8
    }

    public k(a2b.f r2, List<UrlPreViewEntries> r3, ChatHitPointExtraParams.DataSource r4) {
        Intrinsics.checkNotNullParameter(r2, "previewService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
