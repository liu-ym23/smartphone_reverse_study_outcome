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
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ CrowdTestTabCell a;
    public final /* synthetic */ y b;

    public /* synthetic */ r(CrowdTestTabCell r1, y r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r13) {
        CrowdTestTabCell r0 = this.a;
        y r1 = this.b;
        Intrinsics.checkNotNullParameter((TextView) r13, "it");
        r0.getClass();
        CrowdTestTabCell.r(r1, 0);
        r0.o(true);
        String r2 = com.larus.im.bean.message.a.D(r1.a);
        if (r2 == null) goto L5;
        w2.b(r2, 0);
    L5:
        u7 r14 = (u7) r0.e.getValue();
        if (r14 == null) goto L8;
        r14.C90();
    L8:
        String r3 = r1.a.getReplyId();
        List r15 = r1.a.getSubListGroup();
        if (r15 == null) goto L13;
        List r16 = (List) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L13;
        String r17 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, new w(), 30, null);
    L14:
        y2.a(r3, r17, 1L, r1.a.getConversationId(), r1.a.getSenderId(), "top_tab_button");
        return Unit.INSTANCE;
    L13:
        r17 = null;
        goto L14
    }
}
