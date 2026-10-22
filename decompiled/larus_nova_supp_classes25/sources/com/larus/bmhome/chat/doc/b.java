package com.larus.bmhome.chat.doc;

import android.content.Context;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Message a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Context d;

    public /* synthetic */ b(Message r1, boolean r2, boolean r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final Message r0 = this.a;
        final boolean r1 = this.b;
        final boolean r2 = this.c;
        final Context r3 = this.d;
        FLogger r4 = FLogger.a;
        String r5 = DocumentMessageProcessor.c;
        StringBuilder r6 = new StringBuilder("tryToHandleDocBlock ");
        r6.append(r0.getMessageId());
        r6.append(' ');
        Message r8 = DocumentMessageProcessor.a;
        String r9 = null;
        if (r8 == null) goto L5;
        String r10 = r8.getMessageId();
    L6:
        r6.append(r10);
        r6.append(' ');
        r6.append(r1);
        r4.i(r5, r6.toString());
        String r7 = r0.getMessageId();
        Message r11 = DocumentMessageProcessor.a;
        if (r11 == null) goto L9;
        String r12 = r11.getMessageId();
    L11:
        if (Intrinsics.areEqual(r7, r12) == false) goto L13;
    L15:
        String r13 = r0.getMessageId();
        Message r14 = DocumentMessageProcessor.a;
        if (r14 == null) goto L18;
        String r15 = r14.getMessageId();
    L20:
        if (Intrinsics.areEqual(r13, r15) == true) goto L24;
        if (DocumentMessageProcessor.a == null) goto L24;
    L75:
        DocumentMessageProcessor.a = r0;
        return;
    L24:
        if (com.larus.im.bean.message.a.b0(r0) == false) goto L75;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        boolean r16 = true;
        if (com.larus.im.bean.message.a.g0(r0) == true) goto L28;
        boolean r17 = true;
    L33:
        if (r17 == true) goto L75;
        StringBuilder r18 = new StringBuilder("map:");
        DocumentMessageProcessor$map$1 r19 = DocumentMessageProcessor.b;
        r18.append(r19);
        r18.append(", last:");
        Message r110 = DocumentMessageProcessor.a;
        if (r110 == null) goto L37;
        String r111 = r110.getMessageId();
    L38:
        r18.append(r111);
        r18.append(", ");
        Message r112 = DocumentMessageProcessor.a;
        if (r112 == null) goto L43;
        Map r113 = r112.getExt();
        if (r113 == null) goto L43;
        String r114 = (String) r113.get("otter_page_info");
    L44:
        r18.append(r114);
        r18.append(", new:");
        r18.append(r0.getMessageId());
        r18.append(' ');
        Map r20 = r0.getExt();
        if (r20 == null) goto L47;
        String r21 = (String) r20.get("otter_page_info");
    L48:
        r18.append(r21);
        r4.i(r5, r18.toString());
        if (r19.containsKey(r0.getMessageId()) == true) goto L75;
        Message r22 = DocumentMessageProcessor.a;
        if (r22 == null) goto L55;
        Map r23 = r22.getExt();
        if (r23 == null) goto L55;
        String r24 = (String) r23.get("otter_page_info");
    L56:
        if (r24 != null) goto L75;
        Map r25 = r0.getExt();
        if (r25 == null) goto L61;
        r9 = (String) r25.get("otter_page_info");
    L61:
        if (o0.d(r9) == false) goto L75;
        String r26 = r0.getMessageId();
        if (r26 != null) goto L65;
        r26 = "";
    L65:
        r19.put(r26, Boolean.TRUE);
        IFlowSdkDepend r27 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r27 == null) goto L70;
        r27.N();
        if (n1.a.R() != 1) goto L70;
    L71:
        if (r16 == false) goto L73;
        long r28 = 0;
    L74:
        SoftReference r29 = y.a;
        Runnable r30 = new c(r0, r2, r1, r3);
        Intrinsics.checkNotNullParameter(r30, "action");
        y.d(r30, r28);
        goto L75
    L73:
        r28 = 1000;
    L70:
        r16 = false;
    L55:
        r24 = null;
        goto L56
    L47:
        r21 = null;
    L43:
        r114 = null;
        goto L44
    L37:
        r111 = null;
        goto L38
    L28:
        Map r31 = r0.getExt();
        if (r31 == null) goto L31;
        String r32 = (String) r31.get("ignore_doc_page_route");
    L32:
        r17 = Intrinsics.areEqual(r32, "true");
        goto L33
    L31:
        r32 = null;
        goto L32
    L18:
        r15 = null;
        goto L20
    L13:
        if (DocumentMessageProcessor.b.containsKey(r0.getMessageId()) == true) goto L15;
        DocumentMessageProcessor.a = null;
        goto L15
    L9:
        r12 = null;
        goto L11
    L5:
        r10 = null;
        goto L6
    }
}
