package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.e0;

/* JADX INFO: loaded from: classes.dex */
public final class r implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f5108a;

    public r(s r8) {
        this.f5108a = r8;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
        s r13 = this.f5108a;
        if (r11 >= 0) goto L5;
        Object r14 = s.a(r13).e();
    L6:
        s.b(r13, r14);
        AdapterView.OnItemClickListener r15 = r13.getOnItemClickListener();
        if (r15 == null) goto L12;
        if (r10 == null) goto L10;
        if (r11 < 0) goto L10;
    L11:
        e0 r16 = s.a(r13).getListView();
        r15.onItemClick(r16, r10, r11, r12);
    L10:
        r10 = s.a(r13).h();
        r11 = s.a(r13).g();
        r12 = s.a(r13).f();
    L12:
        s.a(r13).dismiss();
        return;
    L5:
        r14 = r13.getAdapter().getItem(r11);
        goto L6
    }
}
