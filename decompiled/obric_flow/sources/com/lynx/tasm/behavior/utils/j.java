package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.y0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f10796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f10797c;

    public j(c0 r5, Method r10) {
        this.f10795a = r5.name();
        if ("__default_type__".equals(r5.customType()) == true) goto L6;
        r5.customType();
    L6:
        this.f10796b = r10;
        this.f10797c = null;
    }

    public abstract Object a(y0 r5);

    public j(d0 r5, Method r10, int r11) {
        this.f10795a = r5.names()[r11];
        if ("__default_type__".equals(r5.customType()) == true) goto L6;
        r5.customType();
    L6:
        this.f10796b = r10;
        this.f10797c = Integer.valueOf(r11);
    }
}
