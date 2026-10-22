package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f4713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f4714b;

    public o(i r8, x r10) {
        this.f4714b = r8;
        this.f4713a = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        i r10 = this.f4714b;
        int r11 = ((LinearLayoutManager) r10.f4692t.getLayoutManager()).J0() + 1;
        if (r11 >= r10.f4692t.getAdapter().a()) goto L6;
        Calendar r12 = g0.c(this.f4713a.f4741c.f4599a.f4621a);
        r12.add(2, r11);
        r10.c(new Month(r12));
        return;
    }
}
