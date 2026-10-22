package com.lynx.tasm;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f10921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10923c;

    public n0(String r5, View r10, String r11) {
        this.f10921a = r10;
        this.f10922b = r5;
        this.f10923c = r11;
    }

    public final String toString() {
        return String.format("ViewInfo @%d view %s, name %s, monitor-name %s", new Object[]{Integer.valueOf(hashCode()), this.f10921a.getClass().getSimpleName(), this.f10922b, this.f10923c});
    }
}
