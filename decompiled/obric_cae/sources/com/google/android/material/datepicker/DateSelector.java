package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    static void g(EditText... r8) {
        if (r8.length != 0) goto L5;
        return;
    L5:
        e r10 = new e(r8, 0);
        int r11 = r8.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r8[r12].setOnFocusChangeListener(r10);
        r12 = r12 + 1;
        goto L6
    L8:
        final EditText r13 = r8[0];
        r13.postDelayed(new com.google.android.material.bottomappbar.a(r13), 100);
    }

    String a(Context r8);

    int b(Context r8);

    String d(Context r8);

    ArrayList e();

    View f(LayoutInflater r8, ViewGroup r10, CalendarConstraints r11, u.a r12);

    boolean h();

    ArrayList i();

    S p();

    void r(long r8);
}
