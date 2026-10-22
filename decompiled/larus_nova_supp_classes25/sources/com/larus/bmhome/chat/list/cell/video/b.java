package com.larus.bmhome.chat.list.cell.video;

import com.larus.bmhome.chat.bean.OnboardingSug;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ AwemePostListCell a;

    public /* synthetic */ b(AwemePostListCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r43) {
        AwemePostListCell r1 = this.a;
        Content r2 = (Content) r43;
        Intrinsics.checkNotNullParameter(r2, "it");
        d r3 = (d) ((BaseMessageListCell) r1).d;
        if (r3 == null) goto L23;
        Message r4 = r3.a;
        if (r4 == null) goto L23;
        List r5 = r1.f;
        if (r5 == null) goto L23;
        Iterator r6 = r5.iterator();
    L10:
        Object r7 = null;
        if (r6.hasNext() == false) goto L18;
        Object r8 = r6.next();
        Content r9 = ((OnboardingSug) r8).getRichMediaDisplayContent();
        if (r9 == null) goto L16;
        r7 = r9.getItemId();
    L16:
        if (Intrinsics.areEqual(r7, r2.getItemId()) == false) goto L10;
        r7 = r8;
    L18:
        OnboardingSug r10 = (OnboardingSug) r7;
        if (r10 == null) goto L23;
        String r26 = r4.getSectionId();
        String r24 = String.valueOf(r10.getItemId());
        String r25 = String.valueOf(r10.getItemType());
        c0.u(null, null, null, null, null, null, null, null, null, "new_topic", null, null, null, null, null, null, null, com.larus.im.bean.message.a.x(r4), r24, r25, r26, null, null, null, null, null, null, null, null, null, null, null, null, null, -31461377, 63);
    L23:
        return Unit.INSTANCE;
    }
}
