package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends com.google.android.material.internal.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f4662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4663b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DateFormat f4664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CalendarConstraints f4665n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f4666o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final s1.x f4667p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f4668q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4669r;

    public d(String r8, SimpleDateFormat r10, TextInputLayout r11, CalendarConstraints r12) {
        this.f4669r = 0;
        this.f4663b = r8;
        this.f4664m = r10;
        this.f4662a = r11;
        this.f4665n = r12;
        this.f4666o = r11.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f4667p = new s1.x(2, this, r8);
    }

    public abstract void a();

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r8) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) == false) goto L6;
        return;
    L6:
        if (r8.length() == 0) goto L16;
        int r10 = r8.length();
        String r11 = this.f4663b;
        if (r10 < r11.length()) goto L10;
        return;
    L10:
        if (r8.length() < this.f4669r) goto L19;
        char r12 = r11.charAt(r8.length());
        if (Character.isDigit(r12) == true) goto L18;
        r8.append(r12);
        return;
    L18:
        return;
    L19:
        return;
    }

    public abstract void b(Long r8);

    @Override // com.google.android.material.internal.k, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
        this.f4669r = r8.length();
    }

    @Override // com.google.android.material.internal.k, android.text.TextWatcher
    public final void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        CalendarConstraints r14 = this.f4665n;
        TextInputLayout r15 = this.f4662a;
        s1.x r16 = this.f4667p;
        r15.removeCallbacks(r16);
        r15.removeCallbacks(this.f4668q);
        r15.setError(null);
        b(null);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (r10.length() < this.f4663b.length()) goto L24;
        Date r17 = this.f4664m.parse(r10.toString());     // Catch: ParseException -> L20
        r15.setError(null);     // Catch: ParseException -> L20
        long r8 = r17.getTime();     // Catch: ParseException -> L20
        if (r14.f4601m.c(r8) == false) goto L18;
        Calendar r18 = g0.c(r14.f4599a.f4621a);     // Catch: ParseException -> L20
        boolean r19 = true;
        r18.set(5, 1);     // Catch: ParseException -> L20
        if (r18.getTimeInMillis() > r8) goto L14;
        Month r110 = r14.f4600b;     // Catch: ParseException -> L20
        int r20 = r110.f4625o;     // Catch: ParseException -> L20
        Calendar r111 = g0.c(r110.f4621a);     // Catch: ParseException -> L20
        r111.set(5, r20);     // Catch: ParseException -> L20
        if (r8 > r111.getTimeInMillis()) goto L14;
    L15:
        if (r19 == false) goto L18;
        b(Long.valueOf(r17.getTime()));     // Catch: ParseException -> L20
        return;
    L14:
        r19 = false;
    L18:
        c r21 = new c(0, this, r8);     // Catch: ParseException -> L20
        this.f4668q = r21;     // Catch: ParseException -> L20
        r15.post(r21);     // Catch: ParseException -> L20
        return;
    L20:
        r15.post(r16);
        return;
    }
}
