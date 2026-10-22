package com.larus.bmhome.chat.component.collection;

import android.content.Context;
import android.widget.Button;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import com.larus.bmhome.collection.CollectionReportDelegate;
import gd8.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s1a.d;
import tx9.k0;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ ChatCollectMessageComponent a;

    public /* synthetic */ a(ChatCollectMessageComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r32) {
        ChatCollectMessageComponent r1 = this.a;
        int r3 = ChatCollectMessageComponent.v;
        Intrinsics.checkNotNullParameter((Button) r32, "it");
        y r2 = (y) r1.u.getValue();
        if (r2 == null) goto L20;
        String r29 = r2.getBotId();
        String r30 = r2.Y1();
        ChatRouterHelper r4 = ChatRouterHelper.a;
        Context r5 = r1.getContext();
        e r6 = r2.h();
        String r7 = r1.f1().k();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        by7.e r8 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if ((r8 instanceof by7.e) == false) goto L7;
        by7.e r20 = r8;
    L8:
        ChatRouterHelper.h(r5, r29, r6, null, r7, "temporary_chat", null, null, r1.Y2(), null, null, null, Boolean.FALSE, true, false, false, false, r20, null, (ChatPassThroughParams) d.a(r1).a(ChatPassThroughParams.class), null, null, false, null, null, 32870088);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        by7.e r9 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if ((r9 instanceof by7.e) == false) goto L11;
        by7.e r18 = r9;
    L12:
        k0.a(r29, "click_continue_talk", r30, null, null, "collection", null, null, null, null, null, null, null, null, null, r18, null, null, 982961);
        CollectionReportDelegate r10 = CollectionReportDelegate.b;
        String r11 = r1.Y2();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        by7.e r12 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if ((r12 instanceof by7.e) == false) goto L15;
        by7.e r15 = r12;
    L16:
        r10.a(r11, "continue_talk", "None", r15);
        f r13 = (f) r1.t.getValue();
        if (r13 == null) goto L20;
        r13.N9(null);
        goto L20
    L15:
        r15 = null;
        goto L16
    L11:
        r18 = null;
        goto L12
    L7:
        r20 = null;
    L20:
        return Unit.INSTANCE;
    }
}
