package com.larus.bmhome.chat.list.cell.record;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.im.bean.message.Message;
import ic8.p0;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ RecordCardCell a;
    public final /* synthetic */ p0 b;
    public final /* synthetic */ Message c;

    public /* synthetic */ f(RecordCardCell r1, p0 r2, Message r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        RecordCardCell r7 = this.a;
        p0 r0 = this.b;
        Message r8 = this.c;
        u3 r1 = r7.e;
        RecordStatus r9 = null;
        if (r1 == null) goto L5;
        RecordStatus r2 = r1.getRecordStatus();
    L6:
        if (r2 != null) goto L8;
        int r3 = -1;
    L9:
        String r10 = "";
        if (r3 == 3) goto L13;
        switch(r3) {
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            default: goto L22;
        };
    L22:
        String r13 = r8.getMessageId();
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        String r4 = r8.getConversationId();
        if (r4 == null) goto L29;
        r10 = r4;
    L29:
        Pair[] r5 = new Pair[2];
        u3 r6 = r7.e;
        if (r6 == null) goto L32;
        r9 = r6.getRecordStatus();
    L32:
        r5[0] = TuplesKt.to("card_status", RecordCardCell.s(r9));
        r5[1] = TuplesKt.to("action_type", "click_other_area");
        r7.x("voice_note_card_click", r13, r10, r5);
        return;
    L13:
        Context r11 = r12.getContext();
        String r14 = r0.c();
        String r15 = r8.getMessageId();
        if (r15 != null) goto L16;
        String r16 = "";
    L17:
        String r17 = r8.getConversationId();
        if (r17 != null) goto L20;
        String r18 = "";
    L21:
        r7.u(r11, r14, false, r16, r18, "other");
        goto L22
    L20:
        r18 = r17;
        goto L21
    L16:
        r16 = r15;
        goto L17
    L8:
        r3 = RecordCardCell$c.a[r2.ordinal()];
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
