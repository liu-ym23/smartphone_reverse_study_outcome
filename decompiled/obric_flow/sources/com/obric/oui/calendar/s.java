package com.obric.oui.calendar;

import androidx.core.view.PointerIconCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.Calendar;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ODatePickerView f12294a;

    public /* synthetic */ s(ODatePickerView r5) {
        this.f12294a = r5;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        zr.a r10 = (zr.a) r5;
        int r11 = ODatePickerView.I;
        ODatePickerView r12 = this.f12294a;
        Intrinsics.checkNotNullParameter(r12, "this$0");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        Integer r13 = (Integer) r10.f23579a.get(1001);
        Integer r14 = Integer.valueOf(PointerIconCompat.TYPE_HAND);
        Integer r15 = (Integer) r10.f23579a.get(r14);
        if (r13 != null) goto L5;
        int r16 = r12.f12198i;
    L6:
        r12.f12198i = r16;
        if (r15 != null) goto L9;
        int r17 = r12.f12199j;
    L10:
        r12.f12199j = r17;
        Calendar r18 = Calendar.getInstance();
        int r19 = r12.f12198i + 1900;
        r18.set(r19, RangesKt.coerceAtLeast(r12.f12199j, 0), 1);
        String r20 = ODatePickerView.n(r18.getTimeInMillis(), r12.D);
        r12.f12204o.setText(r20);
        if (r12.f12214z == true) goto L19;
        androidx.core.content.res.a r21 = r12.C;
        if (r21 == null) goto L17;
        r12.removeCallbacks(r21);
    L17:
        androidx.core.content.res.a r22 = new androidx.core.content.res.a(r19, 4, r12);
        r12.C = r22;
        r12.postDelayed(r22, 100);
        return;
    L19:
        return;
    L9:
        r17 = r15.intValue();
        goto L10
    L5:
        r16 = r13.intValue();
        goto L6
    }
}
