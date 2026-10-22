package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.thread.ThreadTopicHitPointNew;
import com.ss.android.lark.utils.Contexts;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements w4b.w {
    public o() {
    }

    public final String a() {
        com.ss.android.lark.mergeforward.b.a r0 = com.ss.android.lark.mergeforward.b.a;
        String r1 = com.ss.android.lark.mergeforward.b.c;
        if (r1 != null) goto L8;
        String r2 = com.ss.android.lark.mergeforward.b.b;
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L8:
        return r1;
    }

    public final boolean c() {
        com.ss.android.lark.mergeforward.b.a r0 = com.ss.android.lark.mergeforward.b.a;
        String r1 = com.ss.android.lark.mergeforward.b.c;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    public final void d(m2b.a r11, y6b.a r12) {
        Intrinsics.checkNotNullParameter(r11, "chatContext");
        Intrinsics.checkNotNullParameter(r12, "item");
        com.ss.android.lark.chat.base.view.vo.message.c r0 = r12.b();
        if (com.ss.android.lark.mergeforward.c.a(r11.getContext(), ((v5b.a) r0).a, r0.h) == false) goto L5;
        return;
    L5:
        ((v5b.a) r0).a.setTranslated(r0.e());
        ((v5b.a) r0).a.setManualTranslated(((com.ss.android.lark.chat.base.view.vo.message.f) r0).d);
        ((v5b.a) r0).a.setMessageId(r12.getId());
        FragmentActivity r1 = r11.getContext();
        String r6 = r12.getChatId();
        MergeForwardContent r3 = ((v5b.a) r0).a;
        com.ss.android.lark.chat.base.view.vo.message.f r2 = ((com.ss.android.lark.chat.base.view.vo.message.f) r0).g;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        MergeForwardContent r4 = (MergeForwardContent) ((v5b.a) r2).a;
    L9:
        Message r5 = r0.h;
        int r7 = ((v5b.a) r0).a.getFromType();
        int r8 = com.ss.android.lark.flow.mergeforward.c.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r6, "chatId");
        Intrinsics.checkNotNullParameter(r3, "messageContent");
        com.ss.android.lark.flow.mergeforward.c.a(Contexts.requireActivity(r1), r3, r4, r5, r6, r7, null);
        if (r11.q() == true) goto L12;
    L16:
        Lazy r9 = ChatHitPointNew.a;
        ChatHitPointNew.f(r11.getChat(), "mergeforward", ChatHitPointNew.c("mergeforward"), ChatHitPointNew.b(r11, r12, null, null, null));
        return;
    L12:
        if ((r11 instanceof a7c.a) == false) goto L16;
        a7c.a r13 = (a7c.a) r11;
        Lazy r14 = ThreadTopicHitPointNew.a;
        throw null;
    L8:
        r4 = null;
        goto L9
    }

    public final void b(Context r6, String r7, Message r8, Message r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "originMergeForwardId");
        Intrinsics.checkNotNullParameter(r8, INotificationHitPoint.NoticeType.MESSAGE);
        String r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Thread r3 = r8.getContent().getThread();     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        String r4 = r3.id;     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == false) goto L14;
        r5 = null;
    L14:
        String r10 = (String) r5;
        if (r10 != null) goto L17;
        return;
    L17:
        if (r10.length() <= 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L22;
        r1 = r10;
    L22:
        if (r1 == null) goto L36;
        int r12 = whb.d.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        l1.a r0 = new l1.a();
        r0.e = r1;
        if (r7 != null) goto L26;
        r7 = "";
    L26:
        r0.p = r7;
        r0.d = true;
        if (r8 == null) goto L29;
        r0.r = r8;
    L29:
        if (r9 == null) goto L31;
        r0.s = r9;
    L31:
        whb.d.a(r6, new l1(r0));
        return;
    L36:
        return;
    L19:
        r11 = false;
        goto L20
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
