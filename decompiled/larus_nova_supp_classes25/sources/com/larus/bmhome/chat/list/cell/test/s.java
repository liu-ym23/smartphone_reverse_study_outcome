package com.larus.bmhome.chat.list.cell.test;

import android.widget.TextView;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.utils.w2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.y2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ CrowdTestTabCell a;
    public final /* synthetic */ y b;

    public /* synthetic */ s(CrowdTestTabCell r1, y r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r13) {
        CrowdTestTabCell r0 = this.a;
        y r1 = this.b;
        Intrinsics.checkNotNullParameter((TextView) r13, "it");
        r0.getClass();
        CrowdTestTabCell.r(r1, 1);
        r0.o(false);
        String r2 = com.larus.im.bean.message.a.D(r1.a);
        if (r2 == null) goto L5;
        w2.b(r2, 1);
    L5:
        u7 r3 = (u7) r0.e.getValue();
        if (r3 == null) goto L8;
        r3.C90();
    L8:
        String r4 = r1.a.getReplyId();
        List r5 = r1.a.getSubListGroup();
        if (r5 == null) goto L13;
        List r14 = (List) CollectionsKt.getOrNull(r5, 1);
        if (r14 == null) goto L13;
        String r15 = CollectionsKt.joinToString$default(r14, ",", null, null, 0, null, new x(), 30, null);
    L14:
        y2.a(r4, r15, 2L, r1.a.getConversationId(), r1.a.getSenderId(), "top_tab_button");
        return Unit.INSTANCE;
    L13:
        r15 = null;
        goto L14
    }
}
