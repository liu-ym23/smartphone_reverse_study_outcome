package com.larus.bmhome.chat.cotdetail.component;

import com.larus.bmhome.chat.cotdetail.ability.CotDetailPageState;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.callback.IIMCallbackExt;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 implements IIMCallbackExt<List<? extends Message>> {
    public final /* synthetic */ CotDetailMessageListComponent a;

    public final boolean mustInMain() {
        return true;
    }

    public d0(CotDetailMessageListComponent r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("CotDetailMessageListComponent", "pullThreadMessageList, onFailure: " + r4);
        CotDetailMessageListComponent r5 = this.a;
        int r0 = CotDetailMessageListComponent.A;
        fe8.d r6 = (fe8.d) r5.r.getValue();
        if (r6 == null) goto L6;
        r6.OT(CotDetailPageState.Failed);
        return;
    }

    public final /* bridge */ /* synthetic */ void onLocalFinish(Object r1) {
        List r2 = (List) r1;
    }

    public final void onSuccess(Object r13) {
        List<Message> r14 = (List) r13;
        Intrinsics.checkNotNullParameter(r14, "result");
        boolean r0 = AppHost.a.isDebug();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("pullThreadMessageList, onSuccess:===message size");
        r2.append(r14.size());
        r2.append("===messageids:");
        List<Message> r3 = r14;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(((Message) r5.next()).getMessageId());
        goto L4
    L6:
        r2.append(r4);
        r2.append("=== result:");
        if (r0 == false) goto L9;
        Object r6 = r14;
    L10:
        r2.append(r6);
        r1.i("CotDetailMessageListComponent", r2.toString());
        CotDetailMessageListComponent r7 = this.a;
        int r8 = CotDetailMessageListComponent.A;
        r7.h3().init(r14);
        this.a.getClass();
        Iterator r15 = r3.iterator();
        boolean r9 = false;
    L12:
        if (r15.hasNext() == false) goto L71;
        Message r10 = (Message) r15.next();
        if (com.larus.bmhome.chat.bean.d.G0(r10) == true) goto L12;
        if (com.larus.im.bean.message.a.b0(r10) == false) goto L12;
        if (r9 == true) goto L19;
        List r11 = com.larus.im.bean.message.a.f(r10);
        Iterator r12 = r11.iterator();
    L23:
        Object r16 = null;
        if (r12.hasNext() == false) goto L31;
        Object r17 = r12.next();
        if (((Block) r17).getBlockType() != com.larus.bmhome.chat.deepresearch.view.j.A) goto L28;
        boolean r18 = true;
    L29:
        if (r18 == false) goto L23;
    L32:
        Block r19 = (Block) r17;
        Iterator r20 = r11.iterator();
    L34:
        if (r20.hasNext() == false) goto L49;
        Object r21 = r20.next();
        Block r22 = (Block) r21;
        if (r22.getBlockType() == com.larus.bmhome.chat.deepresearch.view.j.A) goto L46;
        String r23 = r22.getParentId();
        if (r23 != null) goto L40;
    L43:
        boolean r24 = true;
    L44:
        if (r24 == false) goto L46;
        boolean r25 = true;
    L47:
        if (r25 == false) goto L34;
        r16 = r21;
        goto L49
    L40:
        if (r23.length() == 0) goto L43;
        r24 = false;
    L46:
        r25 = false;
    L49:
        Block r26 = (Block) r16;
        if (r19 != null) goto L52;
    L54:
        boolean r27 = false;
    L55:
        if (r27 == false) goto L64;
        if (r26 == null) goto L64;
        if (r10.getMessageStatusLocal() != 21) goto L60;
    L63:
        boolean r28 = true;
    L65:
        if (r19 == null) goto L12;
        String r29 = r10.getMessageId();
        if (r29 == null) goto L12;
        Map<String, Boolean> r30 = ge8.a.a;
        Intrinsics.checkNotNullParameter(r29, "key");
        ge8.a.a.put(r29, Boolean.valueOf(!r28));
        if (r28 == false) goto L12;
        r9 = true;
        goto L12
    L60:
        if (r10.getMessageStatusLocal() == 23) goto L63;
        if (r10.getMessageStatusLocal() == 22) goto L63;
    L64:
        r28 = false;
        goto L65
    L52:
        if (r19.isFinish() != true) goto L54;
        r27 = true;
        goto L55
    L28:
        r18 = false;
        goto L29
    L31:
        r17 = null;
        goto L32
    L19:
        String r31 = r10.getMessageId();
        if (r31 == null) goto L12;
        Map<String, Boolean> r32 = ge8.a.a;
        Intrinsics.checkNotNullParameter(r31, "key");
        ge8.a.a.put(r31, Boolean.FALSE);
        goto L12
    L71:
        fe8.d r110 = (fe8.d) this.a.r.getValue();
        if (r110 == null) goto L104;
        r110.OT(CotDetailPageState.Success);
        return;
    L104:
        return;
    L9:
        r6 = "hidden";
        goto L10
    }
}
