package com.obric.assistant.cocreationreview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m6 implements TextWatcher {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ UsageCardTemplateRenderer b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ TextView d;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        UsageCardTemplateRenderer.a(this.a, this.b, this.c, this.d);
    }

    public m6(boolean r1, UsageCardTemplateRenderer r2, EditText r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
