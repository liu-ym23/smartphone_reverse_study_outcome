package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.p;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.y;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.s;
import w9.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends p {
    public MaterialComponentsViewInflater() {
    }

    @Override // androidx.appcompat.app.p
    public final c a(Context r8, AttributeSet r10) {
        return new s(r8, r10);
    }

    @Override // androidx.appcompat.app.p
    public final e b(Context r8, AttributeSet r10) {
        return new MaterialButton(r8, r10);
    }

    @Override // androidx.appcompat.app.p
    public final f c(Context r8, AttributeSet r10) {
        return new MaterialCheckBox(r8, r10);
    }

    @Override // androidx.appcompat.app.p
    public final r d(Context r8, AttributeSet r10) {
        return new a(r8, r10);
    }

    @Override // androidx.appcompat.app.p
    public final y e(Context r8, AttributeSet r10) {
        return new da.a(r8, r10);
    }
}
