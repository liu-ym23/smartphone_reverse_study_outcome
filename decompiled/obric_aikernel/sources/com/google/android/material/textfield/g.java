package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.j;

/* JADX INFO: loaded from: classes.dex */
class g extends com.google.android.material.textfield.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f4004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.e f4005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.f f4006g;

    class a extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f4007c;

        a(g r10) {
            this.f4007c = r10;
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            g r14 = this.f4007c;
            r14.f3975c.setChecked(!g.e(r14));
        }
    }

    class b implements TextInputLayout.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4008a;

        b(g r10) {
            this.f4008a = r10;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(@NonNull TextInputLayout r10) {
            EditText r11 = r10.getEditText();
            g r12 = this.f4008a;
            r12.f3975c.setChecked(!g.e(r12));
            r11.removeTextChangedListener(g.f(this.f4008a));
            r11.addTextChangedListener(g.f(this.f4008a));
        }
    }

    class c implements TextInputLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4009a;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ EditText f4010c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f4011g;

            a(c r10, EditText r11) {
                this.f4011g = r10;
                this.f4010c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4010c.removeTextChangedListener(g.f(this.f4011g.f4009a));
            }
        }

        c(g r10) {
            this.f4009a = r10;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout r10, int r11) {
            EditText r12 = r10.getEditText();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r11 != 1) goto L9;
            r12.setTransformationMethod(PasswordTransformationMethod.getInstance());
            r12.post(new a(this, r12));
            return;
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f4012c;

        d(g r10) {
            this.f4012c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            EditText r11 = this.f4012c.f3973a.getEditText();
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r11.getSelectionEnd();
            if (g.e(this.f4012c) == false) goto L8;
            PasswordTransformationMethod r13 = null;
        L9:
            r11.setTransformationMethod(r13);
            if (r12 < 0) goto L12;
            r11.setSelection(r12);
        L12:
            this.f4012c.f3973a.U();
            return;
        L8:
            r13 = PasswordTransformationMethod.getInstance();
            goto L9
        }
    }

    g(@NonNull TextInputLayout r10, @DrawableRes int r11) {
        super(r10, r11);
        this.f4004e = new a(this);
        this.f4005f = new b(this);
        this.f4006g = new c(this);
    }

    static /* synthetic */ boolean e(g r10) {
        return r10.g();
    }

    static /* synthetic */ TextWatcher f(g r10) {
        return r10.f4004e;
    }

    private boolean g() {
        EditText r10 = this.f3973a.getEditText();
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r10.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        return true;
    }

    private static boolean h(EditText r10) {
        if (r10 != null) goto L4;
    L12:
        return false;
    L4:
        if (r10.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r10.getInputType() == 128) goto L11;
        if (r10.getInputType() == 144) goto L11;
        if (r10.getInputType() != 224) goto L12;
        goto L11
    }

    @Override // com.google.android.material.textfield.c
    void a() {
        TextInputLayout r10 = this.f3973a;
        int r11 = this.f3976d;
        if (r11 != 0) goto L5;
        r11 = q5.e.design_password_eye;
    L5:
        r10.setEndIconDrawable(r11);
        TextInputLayout r12 = this.f3973a;
        r12.setEndIconContentDescription(r12.getResources().getText(q5.j.password_toggle_content_description));
        this.f3973a.setEndIconVisible(true);
        this.f3973a.setEndIconCheckable(true);
        this.f3973a.setEndIconOnClickListener(new d(this));
        this.f3973a.g(this.f4005f);
        this.f3973a.h(this.f4006g);
        EditText r13 = this.f3973a.getEditText();
        if (h(r13) == false) goto L9;
        r13.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }
}
