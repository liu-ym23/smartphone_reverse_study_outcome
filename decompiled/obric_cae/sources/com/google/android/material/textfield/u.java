package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class u extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f5121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.material.datepicker.q f5122g;

    public u(m r8, int r10) {
        super(r8);
        this.f5120e = R.drawable.design_password_eye;
        this.f5122g = new com.google.android.material.datepicker.q(this, 2);
        if (r10 == 0) goto L6;
        this.f5120e = r10;
        return;
    }

    @Override // com.google.android.material.textfield.n
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return this.f5120e;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.f5122g;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean l() {
        EditText r8 = this.f5121f;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L9:
        return !r10;
    L5:
        if ((r8.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        r10 = true;
        goto L9
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText r8) {
        this.f5121f = r8;
        q();
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        EditText r8 = this.f5121f;
        if (r8 != null) goto L5;
    L13:
        boolean r10 = false;
    L14:
        if (r10 == false) goto L17;
        this.f5121f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    L17:
        return;
    L5:
        if (r8.getInputType() != 16) goto L7;
    L12:
        r10 = true;
        goto L14
    L7:
        if (r8.getInputType() == 128) goto L12;
        if (r8.getInputType() == 144) goto L12;
        if (r8.getInputType() != 224) goto L13;
        goto L12
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        EditText r8 = this.f5121f;
        if (r8 == null) goto L6;
        r8.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }
}
