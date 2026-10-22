package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import android.widget.AdapterView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements AdapterView.OnItemClickListener {
    public final /* synthetic */ CustomRepeatBottomContainer a;

    public b(CustomRepeatBottomContainer r1) {
        this.a = r1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        CustomRepeatBottomContainer r5 = this.a;
        nab.a r6 = r5.p;
        if (r6.e == false) goto L36;
        int r7 = r5.c.c;
        String r8 = BuildConfig.FLAVOR;
        if (r7 != r3) goto L20;
        Integer r9 = r6.g;
        if (r9 == null) goto L38;
        String[] r10 = r5.i;
        if (r10 != null) goto L11;
    L17:
        LKUIToast.show(this.a.getContext(), UIHelper.mustacheFormat(r9.intValue(), "Type", r8));
        return;
    L11:
        if (r10.length <= 0) goto L17;
        if (r3 >= r10.length) goto L17;
        if (r3 < 0) goto L17;
        r8 = r10[r3];
        goto L17
    L38:
        return;
    L20:
        if (r6.d == false) goto L36;
        if (r5.o == null) goto L39;
        Integer r11 = r6.h;
        if (r11 == null) goto L40;
        int r12 = r11.intValue();
        CustomRepeatBottomContainer r13 = this.a;
        int r14 = r13.p.f.getMonthDay() - 1;
        String[] r15 = r13.i;
        if (r15 != null) goto L28;
    L34:
        LKUIToast.show(this.a.getContext(), UIHelper.mustacheFormat(r12, "WeekType", r8));
        return;
    L28:
        if (r15.length <= 0) goto L34;
        if (r14 >= r15.length) goto L34;
        if (r14 < 0) goto L34;
        r8 = r15[r14];
        goto L34
    L40:
        return;
    L39:
        return;
    L36:
        r5.c.c(r3);
        CustomRepeatBottomContainer r16 = this.a;
        r16.a(r16.c, r16.q);
    }
}
