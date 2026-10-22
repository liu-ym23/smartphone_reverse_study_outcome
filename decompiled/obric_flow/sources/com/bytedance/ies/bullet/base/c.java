package com.bytedance.ies.bullet.base;

import ai.j0;
import android.app.Application;
import kotlin.jvm.internal.Intrinsics;
import tc.d;
import wc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f5178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f5180c;
    public mb.b d;
    public e e;
    public rd.a f;
    public final d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c5.a f5181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ies.bullet.secure.e f5182i;

    public c(Application r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.f5178a = r5;
        this.f5179b = r10;
        com.lynx.animax.player.b r11 = new com.lynx.animax.player.b(15);
        Intrinsics.checkNotNullParameter(r10, "bid");
        r11.f9658c = r10;
        this.g = new d(r11);
    }

    public final void a(Class r5, rc.c r10) {
        Intrinsics.checkNotNullParameter(r5, "cls");
        Intrinsics.checkNotNullParameter(r10, "instance");
        String r11 = r5.getName();
        this.g.a(r11, r10);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        Application r11 = r10.f5178a;
        if (Intrinsics.areEqual(this.f5178a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5179b, r10.f5179b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5178a.hashCode() * 31;
        return this.f5179b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("InitializeConfig(application=");
        r5.append(this.f5178a);
        r5.append(", bid=");
        return j0.p(r5, this.f5179b, ')');
    }
}
