package com.obric.aikernel.middleware.impl.obric;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f4577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f4578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4579c;

    public h(g r10, i r11) {
        Intrinsics.checkNotNullParameter(r10, "binder");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        this.f4577a = r10;
        this.f4578b = r11;
    }

    public final boolean a() {
        if (this.f4577a.c() == false) goto L6;
        return false;
    L6:
        if (this.f4579c == false) goto L8;
        this.f4577a.a();
        this.f4579c = false;
    L8:
        boolean r10 = this.f4577a.b(this.f4578b);
        if (r10 == false) goto L11;
        this.f4579c = true;
    L11:
        return r10;
    }

    public final boolean b() {
        return this.f4577a.c();
    }

    public final void c() {
        if (this.f4579c == true) goto L5;
        return;
    L5:
        this.f4577a.a();
        this.f4579c = false;
    }
}
