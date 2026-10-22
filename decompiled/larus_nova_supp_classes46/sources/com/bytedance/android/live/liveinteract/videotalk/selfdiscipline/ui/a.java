package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ SelfDisciplineTimerView a;
    public final /* synthetic */ String b;

    public a(SelfDisciplineTimerView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r18) {
        Long r1 = (Long) r18;
        Long r2 = this.a.getMDurationHolder().get(this.b);
        if (r2 != null) goto L9;
        ILinkPlayerInfoBridge r3 = this.a.getMPlayerInfo();
        if (r3 == null) goto L7;
        long r4 = r3.getSelfDisciplineDuration();
    L8:
        r2 = Long.valueOf(r4);
        goto L9
    L7:
        r4 = 0;
    L9:
        long r5 = r2.longValue();
        TextView r6 = (TextView) this.a.a(2131391592);
        if (r6 == null) goto L12;
        this.a.getClass();
        r6.setText(SelfDisciplineTimerView.d(r5));
    L12:
        SelfDisciplineContext.Companion.getClass();
        int r7 = SelfDisciplineContext.a.a();
        ILinkPlayerInfoBridge r8 = this.a.getMPlayerInfo();
        if (r8 == null) goto L15;
        long r9 = r8.getSelfDisciplineTargetDuration();
    L17:
        if (r7 == 1) goto L19;
    L51:
        this.a.getMDurationHolder().put(this.b, Long.valueOf(r5 + 1));
        return;
    L19:
        if (r9 != 0) goto L26;
        ImageView r10 = (ImageView) this.a.a(2131376677);
        if (r10 == null) goto L23;
        r10.setVisibility(8);
    L23:
        LinearLayout r11 = (LinearLayout) this.a.a(2131388695);
        if (r11 == null) goto L51;
        r11.setBackground(s1.m(2131253008));
        goto L51
    L26:
        long r12 = 3;
        long r13 = r5 - r9;
        if (0 > r13) goto L38;
        if (r12 < r13) goto L38;
        ImageView r14 = (ImageView) this.a.a(2131376677);
        if (r14 == null) goto L34;
        r14.setVisibility(0);
    L34:
        LinearLayout r15 = (LinearLayout) this.a.a(2131388695);
        if (r15 == null) goto L51;
        r15.setBackground(s1.m(2131253009));
    L38:
        if (r5 <= r9) goto L45;
        ImageView r16 = (ImageView) this.a.a(2131376677);
        if (r16 == null) goto L42;
        r16.setVisibility(0);
    L42:
        LinearLayout r17 = (LinearLayout) this.a.a(2131388695);
        if (r17 == null) goto L51;
        r17.setBackground(s1.m(2131253008));
        goto L51
    L45:
        ImageView r19 = (ImageView) this.a.a(2131376677);
        if (r19 == null) goto L48;
        r19.setVisibility(8);
    L48:
        LinearLayout r20 = (LinearLayout) this.a.a(2131388695);
        if (r20 == null) goto L51;
        r20.setBackground(s1.m(2131253008));
        goto L51
    L15:
        r9 = 0;
        goto L17
    }
}
