package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class h extends d {
    private final TextWatcher e;
    private final TextInputLayout.a f;
    private final TextInputLayout.b g;

    h(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.e = new AnonymousClass1(this);
        this.f = new AnonymousClass2(this);
        this.g = new AnonymousClass3(this);
    }

    private static boolean a(EditText r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r2.getInputType() == 128) goto L11;
        if (r2.getInputType() == 144) goto L11;
        if (r2.getInputType() != 224) goto L12;
        goto L11
    }

    static /* synthetic */ boolean a(h r0) {
        return r0.c();
    }

    static /* synthetic */ TextWatcher b(h r0) {
        return r0.e;
    }

    private boolean c() {
        EditText r1 = this.f4166a.getEditText();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1.getTransformationMethod(), PasswordTransformationMethod.class) == false) goto L7;
        return true;
    }

    @Override // com.google.android.material.textfield.d
    void a() {
        TextInputLayout r0 = this.f4166a;
        if (this.d != 0) goto L5;
        int r1 = ZeusTransformUtils.mapRes(R.drawable.design_password_eye, "drawable", "design_password_eye");
    L6:
        r0.setEndIconDrawable(r1);
        this.f4166a.setEndIconContentDescription(ZeusTransformUtils.getResources(this.f4166a, "com.obric.memorydata.plugin").getText(ZeusTransformUtils.mapRes(R.string.password_toggle_content_description, TypedValues.Custom.S_STRING, "password_toggle_content_description")));
        this.f4166a.setEndIconVisible(true);
        this.f4166a.setEndIconCheckable(true);
        this.f4166a.setEndIconOnClickListener(new AnonymousClass4(this));
        this.f4166a.a(this.f);
        this.f4166a.a(this.g);
        EditText r5 = this.f4166a.getEditText();
        if (a(r5) == false) goto L10;
        r5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    L10:
        return;
    L5:
        r1 = this.d;
        goto L6
    }
}
