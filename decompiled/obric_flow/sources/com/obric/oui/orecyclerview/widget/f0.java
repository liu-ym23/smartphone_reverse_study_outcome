package com.obric.oui.orecyclerview.widget;

import android.view.View;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements org.threeten.bp.temporal.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13810b;

    public f0(DayOfWeek r5, int r10) {
        jm.c.p(r5, "dayOfWeek");
        this.f13809a = r10;
        this.f13810b = r5.getValue();
    }

    public void a(x0 r5) {
        View r10 = r5.itemView;
        this.f13809a = r10.getLeft();
        this.f13810b = r10.getTop();
        r10.getRight();
        r10.getBottom();
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        int r10 = r5.get(ChronoField.DAY_OF_WEEK);
        int r11 = this.f13810b;
        int r12 = this.f13809a;
        if (r12 >= 2) goto L7;
        if (r10 != r11) goto L7;
        return r5;
    L7:
        if ((r12 & 1) != 0) goto L15;
        int r13 = r10 - r11;
        if (r13 < 0) goto L12;
        int r14 = 7 - r13;
    L14:
        return r5.plus(r14, ChronoUnit.DAYS);
    L12:
        r14 = -r13;
        goto L14
    L15:
        int r15 = r11 - r10;
        if (r15 < 0) goto L19;
        int r16 = 7 - r15;
    L21:
        return r5.minus(r16, ChronoUnit.DAYS);
    L19:
        r16 = -r15;
        goto L21
    }
}
