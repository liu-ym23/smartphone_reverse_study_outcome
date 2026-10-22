package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
abstract class c extends com.google.android.material.internal.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final TextInputLayout f3209c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DateFormat f3210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CalendarConstraints f3211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f3212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f3213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Runnable f3214k;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3215c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f3216g;

        a(c r10, String r11) {
            this.f3216g = r10;
            this.f3215c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout r10 = c.a(this.f3216g);
            DateFormat r11 = c.b(this.f3216g);
            Context r12 = r10.getContext();
            r10.setError(r12.getString(q5.j.mtrl_picker_invalid_format) + "\n" + String.format(r12.getString(q5.j.mtrl_picker_invalid_format_use), new Object[]{this.f3215c}) + "\n" + String.format(r12.getString(q5.j.mtrl_picker_invalid_format_example), new Object[]{r11.format(new Date(j.o().getTimeInMillis()))}));
            this.f3216g.e();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f3217c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f3218g;

        b(c r10, long r11) {
            this.f3218g = r10;
            this.f3217c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f3218g).setError(String.format(c.c(this.f3218g), new Object[]{d.c(this.f3217c)}));
            this.f3218g.e();
        }
    }

    c(String r10, DateFormat r11, @NonNull TextInputLayout r12, CalendarConstraints r13) {
        this.f3210g = r11;
        this.f3209c = r12;
        this.f3211h = r13;
        this.f3212i = r12.getContext().getString(q5.j.mtrl_picker_out_of_range);
        this.f3213j = new a(this, r10);
    }

    static /* synthetic */ TextInputLayout a(c r10) {
        return r10.f3209c;
    }

    static /* synthetic */ DateFormat b(c r10) {
        return r10.f3210g;
    }

    static /* synthetic */ String c(c r10) {
        return r10.f3212i;
    }

    private Runnable d(long r10) {
        return new b(this, r10);
    }

    abstract void e();

    abstract void f(@Nullable Long r10);

    public void g(View r10, Runnable r11) {
        r10.postDelayed(r11, 1000);
    }

    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence r10, int r11, int r12, int r13) {
        this.f3209c.removeCallbacks(this.f3213j);
        this.f3209c.removeCallbacks(this.f3214k);
        this.f3209c.setError(null);
        f(null);
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return;
    L15:
        Date r14 = this.f3210g.parse(r10.toString());     // Catch: ParseException -> L13
        this.f3209c.setError(null);     // Catch: ParseException -> L13
        long r15 = r14.getTime();     // Catch: ParseException -> L13
        if (this.f3211h.getDateValidator().isValid(r15) == true) goto L8;
    L11:
        Runnable r16 = d(r15);     // Catch: ParseException -> L13
        this.f3214k = r16;     // Catch: ParseException -> L13
        g(this.f3209c, r16);     // Catch: ParseException -> L13
        return;
    L8:
        if (this.f3211h.isWithinBounds(r15) == false) goto L11;
        f(Long.valueOf(r14.getTime()));     // Catch: ParseException -> L13
        return;
    L13:
        g(this.f3209c, this.f3213j);
    }
}
