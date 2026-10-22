package com.larus.bmhome.taskskill.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.taskskill.l2;
import com.larus.flowskill.impl.databinding.LayoutPcConnectionStatusBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ PcConnectionStatusManager a;

    public /* synthetic */ g(PcConnectionStatusManager r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        final PcConnectionStatusManager r0 = this.a;
        b r10 = (b) r9;
        FLogger.a.i("PcConnectionStatusManager", "receive connectionStatus change to " + r10);
        Intrinsics.checkNotNull(r10);
        bs8.a r1 = r0.f;
        ViewGroup r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        p r11 = d.b(r10, r3);
        if (r11.f == true) goto L17;
        LayoutPcConnectionStatusBinding r4 = r0.e;
        if (r4 == null) goto L15;
        PcConnectionStatusView r5 = r4.a;
        if (r5 == null) goto L15;
        r5.D(r11);
    L15:
        r0.b.g();
        return Unit.INSTANCE;
    L17:
        if (l2.c() == false) goto L31;
        bs8.a r6 = r0.f;
        if (r6 == null) goto L26;
        Integer r7 = r6.c;
        if (r7 == null) goto L26;
        if (r7.intValue() != 2) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L31;
        if (r0.b.b().a() == false) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == false) goto L55;
        ViewGroup r13 = r0.b.getContainerView();
        if (r13 == null) goto L55;
        LayoutPcConnectionStatusBinding r14 = r0.e;
        if (r14 != null) goto L42;
        Object r15 = LayoutInflater.from(r13.getContext()).inflate(2131563383, r13, false);
        if (r15 == null) goto L54;
        PcConnectionStatusView r16 = (PcConnectionStatusView) r15;
        LayoutPcConnectionStatusBinding r17 = new LayoutPcConnectionStatusBinding(r16);
        r16.setOnActionClick(new l(r0));
        r0.e = r17;
        r14 = r17;
        goto L42
    L54:
        throw new NullPointerException("rootView");
    L42:
        AppCompatTextView r18 = r14.a;
        e1.x(r13);
        if (r13.getChildCount() == 1) goto L45;
    L47:
        ViewParent r19 = r18.getParent();
        if ((r19 instanceof ViewGroup) == false) goto L50;
        r2 = (ViewGroup) r19;
    L50:
        if (r2 == null) goto L52;
        r2.removeView(r18);
    L52:
        r13.removeAllViews();
        r13.addView(r18);
        goto L55
    L45:
        if (r13.getChildAt(0) != r18) goto L47;
    L55:
        LayoutPcConnectionStatusBinding r20 = r0.e;
        if (r20 == null) goto L61;
        PcConnectionStatusView r21 = r20.a;
        if (r21 == null) goto L61;
        r21.D(r11);
    L61:
        return Unit.INSTANCE;
    L26:
        r8 = false;
    L31:
        r12 = false;
        goto L32
    L5:
        r3 = null;
        goto L6
    }
}
