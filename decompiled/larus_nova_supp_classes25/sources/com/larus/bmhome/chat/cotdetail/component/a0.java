package com.larus.bmhome.chat.cotdetail.component;

import com.larus.bmhome.chat.cotdetail.ability.CotDetailPageState;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.thread.ThreadData;
import com.larus.im.bean.thread.ThreadMessageListRequest;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Function1 {
    public final /* synthetic */ CotDetailMessageListComponent a;

    public /* synthetic */ a0(CotDetailMessageListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r15) {
        CotDetailMessageListComponent r0 = this.a;
        String r16 = (ThreadData) r15;
        int r1 = CotDetailMessageListComponent.A;
        boolean r2 = AppHost.a.isDebug();
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("updateRecyclerView, threadId=");
        String r5 = null;
        if (r16 == null) goto L5;
        String r6 = r16.getThreadId();
    L6:
        r4.append(r6);
        r4.append("=====threadname=");
        if (r16 == null) goto L9;
        String r7 = r16.getThreadName();
    L10:
        r4.append(r7);
        r4.append(", threadData: ");
        if (r2 == false) goto L13;
        String r8 = r16;
    L14:
        r4.append(r8);
        r3.i("CotDetailMessageListComponent", r4.toString());
        r0.q = r16;
        if (r16 == null) goto L17;
        r5 = r16.getThreadId();
    L17:
        String r9 = r5;
        if (r9 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == false) goto L28;
        fe8.d r18 = (fe8.d) r0.r.getValue();
        if (r18 == null) goto L30;
        r18.OT(CotDetailPageState.Failed);
    L30:
        return Unit.INSTANCE;
    L28:
        r0.h3().setThreadId(r9);
        r3.d("CotDetailMessageListComponent", "pullThreadMessageList, threadId: " + r9);
        com.larus.im.d.e().q(new ThreadMessageListRequest(r9, null, 0, 5000, false, 22, null), new d0(r0));
        goto L30
    L20:
        if (r9.length() == 0) goto L23;
        r17 = false;
        goto L24
    L13:
        r8 = "hidden";
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
