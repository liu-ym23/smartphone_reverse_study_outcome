package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f3973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f3974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f3975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @DrawableRes
    final int f3976d;

    c(@NonNull TextInputLayout r10, @DrawableRes int r11) {
        this.f3973a = r10;
        this.f3974b = r10.getContext();
        this.f3975c = r10.getEndIconView();
        this.f3976d = r11;
    }

    abstract void a();

    boolean b(int r10) {
        return true;
    }

    void c(boolean r10) {
    }

    boolean d() {
        return false;
    }
}
