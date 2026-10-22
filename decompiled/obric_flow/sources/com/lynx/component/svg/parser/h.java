package com.lynx.component.svg.parser;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f9811b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f9812c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9813a;

    static {
        f9811b = new h(ViewCompat.MEASURED_STATE_MASK);
        f9812c = new h(0);
    }

    public h(int r5) {
        this.f9813a = r5;
    }

    public final String toString() {
        return String.format("#%08x", new Object[]{Integer.valueOf(this.f9813a)});
    }
}
