package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class m extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f4709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f4710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f4711c;

    public m(i r8, x r10, MaterialButton r11) {
        this.f4711c = r8;
        this.f4709a = r10;
        this.f4710b = r11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public final void a(RecyclerView r8, int r10) {
        if (r10 != 0) goto L5;
        r8.announceForAccessibility(this.f4710b.getText());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public final void b(RecyclerView r8, int r10, int r11) {
        i r12 = this.f4711c;
        if (r10 >= 0) goto L5;
        int r13 = ((LinearLayoutManager) r12.f4692t.getLayoutManager()).J0();
    L6:
        x r14 = this.f4709a;
        Calendar r15 = g0.c(r14.f4741c.f4599a.f4621a);
        r15.add(2, r13);
        r12.f4688p = new Month(r15);
        Calendar r16 = g0.c(r14.f4741c.f4599a.f4621a);
        r16.add(2, r13);
        String r17 = new Month(r16).v();
        this.f4710b.setText(r17);
        return;
    L5:
        r13 = ((LinearLayoutManager) r12.f4692t.getLayoutManager()).K0();
        goto L6
    }
}
