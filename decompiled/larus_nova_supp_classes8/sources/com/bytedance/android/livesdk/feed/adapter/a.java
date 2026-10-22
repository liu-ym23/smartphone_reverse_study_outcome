package com.bytedance.android.livesdk.feed.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AppointmentListAdapter.AppointmentItemViewHolder a;

    public a(AppointmentListAdapter.AppointmentItemViewHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        qm1.a r8 = (qm1.a) r7;
        long r0 = r8.a;
        Appointment r2 = this.a.g;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0 != r2.appointmentId) goto L28;
        r2.isReserved = Boolean.valueOf(r8.b);
        AppointmentListAdapter.AppointmentItemViewHolder r9 = this.a;
        Appointment r1 = r9.g;
        Drawable r3 = null;
        if (r1 == null) goto L9;
        Boolean r4 = r1.isReserved;
    L11:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
        r9.j = "cancel_reserve";
        r9.e.setText(s1.B(2131917327));
        Drawable r10 = r9.e.getBackground();
        if ((r10 instanceof GradientDrawable) == false) goto L16;
        r3 = r10;
    L16:
        GradientDrawable r5 = (GradientDrawable) r3;
        if (r5 == null) goto L29;
        r5.setColor(s1.h(2131108318));
        return;
    L29:
        return;
    L19:
        r9.j = "reserve";
        r9.e.setText(s1.B(2131922190));
        Drawable r11 = r9.e.getBackground();
        if ((r11 instanceof GradientDrawable) == false) goto L23;
        r3 = r11;
    L23:
        GradientDrawable r6 = (GradientDrawable) r3;
        if (r6 == null) goto L31;
        r6.setColor(s1.h(2131107943));
        return;
    L31:
        return;
    L9:
        r4 = null;
        goto L11
    }
}
