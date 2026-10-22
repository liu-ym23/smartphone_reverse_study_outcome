package com.obric.aikernel.sdk.autotest;

import android.os.Bundle;
import ge.p;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends j implements p<Bundle, String, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5349a = null;

    static {
        f5349a = new a();
    }

    public a() {
        super(2);
    }

    @Override // ge.p
    public final Object invoke(Bundle r8, String r10) {
        Bundle r11 = r8;
        String r12 = r10;
        i.f(r11, "b");
        i.f(r12, "k");
        return r11.get(r12);
    }
}
