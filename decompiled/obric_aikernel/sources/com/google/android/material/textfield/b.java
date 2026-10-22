package com.google.android.material.textfield;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class b extends c {
    b(@NonNull TextInputLayout r10, @DrawableRes int r11) {
        super(r10, r11);
    }

    @Override // com.google.android.material.textfield.c
    void a() {
        this.f3973a.setEndIconDrawable(this.f3976d);
        this.f3973a.setEndIconOnClickListener(null);
        this.f3973a.setEndIconOnLongClickListener(null);
    }
}
