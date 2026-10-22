package com.larus.bmhome.chat.deepsearch.component;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements nf9.c {
    public final /* synthetic */ DeepSearchContentComponent a;
    public final /* synthetic */ String b;

    public final void A(Message r50) {
        Intrinsics.checkNotNullParameter(r50, "message");
        FLogger.a.d(this.a.m, "[biz_deep_search]onStreamEnd , content_type : " + r50.getContentType() + " , " + this.b + " -> " + r50.getContent());
        Map r2 = r50.getExt();
        q0 r46 = null;
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("deep_search_from_id");
    L6:
        DeepSearchParam r4 = this.a.Y2();
        if (r4 == null) goto L9;
        String r5 = r4.b;
    L11:
        if (Intrinsics.areEqual(r3, r5) == false) goto L52;
        RecyclerView r6 = this.a.r;
        if (r6 == null) goto L15;
        RecyclerView.Adapter r7 = r6.getAdapter();
    L17:
        if ((r7 instanceof q0) == false) goto L19;
        q0 r15 = (q0) r7;
    L21:
        if (r15 == null) goto L23;
        com.larus.bmhome.chat.deepsearch.j.a(r15, CollectionsKt.listOf(new Message[]{r50, Message.copy$default(r50, null, null, null, 0, 0, null, 2, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null)}), false);
    L23:
        RecyclerView r1 = this.a.r;
        if (r1 == null) goto L26;
        RecyclerView.Adapter r8 = r1.getAdapter();
    L28:
        if ((r8 instanceof q0) == false) goto L30;
        q0 r9 = (q0) r8;
    L31:
        String r10 = "";
        if (r9 == null) goto L37;
        String r11 = r50.getMessageId();
        if (r11 != null) goto L36;
        r11 = "";
    L36:
        r9.x7(r11, 800);
    L37:
        RecyclerView r12 = this.a.r;
        if (r12 == null) goto L40;
        RecyclerView.Adapter r13 = r12.getAdapter();
    L42:
        if ((r13 instanceof q0) == false) goto L44;
        r46 = (q0) r13;
    L44:
        q0 r14 = r46;
        if (r14 == null) goto L53;
        String r16 = r50.getMessageId();
        if (r16 == null) goto L50;
        r10 = r16;
    L50:
        r14.x7(r10, 2);
        return;
    L53:
        return;
    L40:
        r13 = null;
        goto L42
    L30:
        r9 = null;
        goto L31
    L26:
        r8 = null;
        goto L28
    L19:
        r15 = null;
        goto L21
    L15:
        r7 = null;
        goto L17
    L52:
        return;
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final void B(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        FLogger r0 = FLogger.a;
        String r1 = this.a.m;
        StringBuilder r2 = new StringBuilder("[biz_deep_search]onStreamUpdate, content_type : ");
        r2.append(r7.getContentType());
        r2.append(", deep_search_from_id = ");
        Map r3 = r7.getExt();
        q0 r5 = null;
        if (r3 == null) goto L5;
        String r4 = (String) r3.get("deep_search_from_id");
    L6:
        r2.append(r4);
        r2.append(". onStreamUpdate ");
        r2.append(this.b);
        r2.append(" -> ");
        r2.append(r7.getContent());
        r0.d(r1, r2.toString());
        Map r6 = r7.getExt();
        if (r6 == null) goto L9;
        String r8 = (String) r6.get("deep_search_from_id");
    L10:
        DeepSearchParam r9 = this.a.Y2();
        if (r9 == null) goto L13;
        String r10 = r9.b;
    L15:
        if (Intrinsics.areEqual(r8, r10) == false) goto L54;
        RecyclerView r11 = this.a.r;
        if (r11 == null) goto L19;
        RecyclerView.Adapter r12 = r11.getAdapter();
    L21:
        if ((r12 instanceof q0) == false) goto L23;
        q0 r13 = (q0) r12;
    L24:
        if (r13 == null) goto L26;
        com.larus.bmhome.chat.deepsearch.j.a(r13, CollectionsKt.listOf(r7), false);
    L26:
        RecyclerView r14 = this.a.r;
        if (r14 == null) goto L29;
        RecyclerView.Adapter r15 = r14.getAdapter();
    L31:
        if ((r15 instanceof q0) == false) goto L33;
        q0 r16 = (q0) r15;
    L34:
        String r17 = "";
        if (r16 == null) goto L40;
        String r18 = r7.getMessageId();
        if (r18 != null) goto L39;
        r18 = "";
    L39:
        r16.x7(r18, 800);
    L40:
        RecyclerView r19 = this.a.r;
        if (r19 == null) goto L43;
        RecyclerView.Adapter r20 = r19.getAdapter();
    L45:
        if ((r20 instanceof q0) == false) goto L47;
        r5 = (q0) r20;
    L47:
        if (r5 == null) goto L55;
        String r21 = r7.getMessageId();
        if (r21 == null) goto L52;
        r17 = r21;
    L52:
        r5.x7(r17, 2);
        return;
    L55:
        return;
    L43:
        r20 = null;
        goto L45
    L33:
        r16 = null;
        goto L34
    L29:
        r15 = null;
        goto L31
    L23:
        r13 = null;
        goto L24
    L19:
        r12 = null;
        goto L21
    L54:
        return;
    L13:
        r10 = null;
        goto L15
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void C(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        String r0 = r6.getConversationId();
        String r1 = r6.getMessageId();
        FLogger.a.d("streamService", "onStreamBegin, content type " + r6.getContentType() + "  : " + r0 + ", " + r1);
        Map r2 = r6.getExt();
        q0 r3 = null;
        if (r2 == null) goto L5;
        String r4 = (String) r2.get("deep_search_from_id");
    L6:
        DeepSearchContentComponent r5 = this.a;
        int r7 = DeepSearchContentComponent.s;
        DeepSearchParam r8 = r5.Y2();
        if (r8 == null) goto L9;
        String r9 = r8.b;
    L11:
        if (Intrinsics.areEqual(r4, r9) == false) goto L50;
        RecyclerView r10 = this.a.r;
        if (r10 == null) goto L15;
        RecyclerView.Adapter r11 = r10.getAdapter();
    L17:
        if ((r11 instanceof q0) == false) goto L19;
        q0 r12 = (q0) r11;
    L20:
        if (r12 == null) goto L22;
        com.larus.bmhome.chat.deepsearch.j.a(r12, CollectionsKt.listOf(r6), false);
    L22:
        RecyclerView r13 = this.a.r;
        if (r13 == null) goto L25;
        RecyclerView.Adapter r14 = r13.getAdapter();
    L27:
        if ((r14 instanceof q0) == false) goto L29;
        q0 r15 = (q0) r14;
    L30:
        String r16 = "";
        if (r15 == null) goto L36;
        String r17 = r6.getMessageId();
        if (r17 != null) goto L35;
        r17 = "";
    L35:
        r15.x7(r17, 800);
    L36:
        RecyclerView r18 = this.a.r;
        if (r18 == null) goto L39;
        RecyclerView.Adapter r19 = r18.getAdapter();
    L41:
        if ((r19 instanceof q0) == false) goto L43;
        r3 = (q0) r19;
    L43:
        if (r3 == null) goto L51;
        String r20 = r6.getMessageId();
        if (r20 == null) goto L48;
        r16 = r20;
    L48:
        r3.x7(r16, 2);
        return;
    L51:
        return;
    L39:
        r19 = null;
        goto L41
    L29:
        r15 = null;
        goto L30
    L25:
        r14 = null;
        goto L27
    L19:
        r12 = null;
        goto L20
    L15:
        r11 = null;
        goto L17
    L50:
        return;
    L9:
        r9 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public k(DeepSearchContentComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
