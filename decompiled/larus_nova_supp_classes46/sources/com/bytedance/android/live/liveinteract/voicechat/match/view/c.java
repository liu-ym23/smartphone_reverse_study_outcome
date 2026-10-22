package com.bytedance.android.live.liveinteract.voicechat.match.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.voicechat.match.logger.JumpType;
import com.bytedance.android.livesdk.widget.desc.CountDownWithDescTextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ ChatMatchDialog a;
    public final /* synthetic */ int b;

    public c(ChatMatchDialog r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r8) {
        Integer r9 = (Integer) r8;
        String r4 = "";
        if (this.b != 9) goto L18;
        ChatMatchDialog r0 = this.a;
        if (r0.t != true) goto L9;
        CountDownWithDescTextView r1 = r0.N;
        if (r1 == null) goto L32;
        r1.setDescText(s1.B(2131917773));
    L32:
        ChatMatchDialog r2 = this.a;
        int r3 = ChatMatchDialog.V;
        r2.getClass();
        if (r9 != null) goto L35;
        return;
    L35:
        if (r9.intValue() > 0) goto L41;
        ek0.c r10 = r2.s;
        if (r10 == null) goto L42;
        ek0.c.a(r10, JumpType.WAITING_TIMEOUT.getValue());
        return;
    L42:
        return;
    L41:
        return;
    L9:
        CountDownWithDescTextView r5 = r0.N;
        if (r5 == null) goto L32;
        String r6 = s1.B(2131917773);
        if (r9 != null) goto L14;
    L17:
        r5.b(r6, r4);
        goto L32
    L14:
        if (this.a.t == true) goto L17;
        r4 = s1.C(2131917768, new Object[]{String.valueOf(r9.intValue())});
        goto L17
    L18:
        ChatMatchDialog r7 = this.a;
        if (r7.t != true) goto L23;
        CountDownWithDescTextView r11 = r7.N;
        if (r11 == null) goto L32;
        r11.setDescText(s1.B(2131917764));
        goto L32
    L23:
        CountDownWithDescTextView r12 = r7.N;
        if (r12 == null) goto L32;
        String r13 = s1.B(2131917764);
        if (r9 != null) goto L28;
    L31:
        r12.b(r13, r4);
        goto L32
    L28:
        if (this.a.t == true) goto L31;
        r4 = s1.C(2131917768, new Object[]{String.valueOf(r9.intValue())});
        goto L31
    }
}
