package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
abstract class c extends com.google.android.material.internal.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputLayout f3883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f3884b;
    private final CalendarConstraints c;
    private final String d;
    private final Runnable e;
    private Runnable f;

    c(final String r2, DateFormat r3, TextInputLayout r4, CalendarConstraints r5) {
        this.f3884b = r3;
        this.f3883a = r4;
        this.c = r5;
        this.d = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_out_of_range, TypedValues.Custom.S_STRING, "mtrl_picker_out_of_range"));
        this.e = new AnonymousClass1(this, r2);
    }

    static /* synthetic */ TextInputLayout a(c r0) {
        return r0.f3883a;
    }

    private Runnable a(final long r2) {
        return new AnonymousClass2(this, r2);
    }

    static /* synthetic */ DateFormat b(c r0) {
        return r0.f3884b;
    }

    static /* synthetic */ String c(c r0) {
        return r0.d;
    }

    void a() {
    }

    public void a(View r3, Runnable r4) {
        r3.postDelayed((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"), 1000);
    }

    abstract void a(Long r1);

    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        this.f3883a.removeCallbacks(this.e);
        this.f3883a.removeCallbacks(this.f);
        this.f3883a.setError(null);
        a(null);
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return;
    L15:
        Date r6 = this.f3884b.parse(r5.toString());     // Catch: ParseException -> L13
        this.f3883a.setError(null);     // Catch: ParseException -> L13
        long r7 = r6.getTime();     // Catch: ParseException -> L13
        if (this.c.getDateValidator().isValid(r7) == true) goto L8;
    L11:
        Runnable r8 = a(r7);     // Catch: ParseException -> L13
        this.f = r8;     // Catch: ParseException -> L13
        a(this.f3883a, r8);     // Catch: ParseException -> L13
        return;
    L8:
        if (this.c.isWithinBounds(r7) == false) goto L11;
        a(Long.valueOf(r6.getTime()));     // Catch: ParseException -> L13
        return;
    L13:
        a(this.f3883a, this.e);
    }
}
