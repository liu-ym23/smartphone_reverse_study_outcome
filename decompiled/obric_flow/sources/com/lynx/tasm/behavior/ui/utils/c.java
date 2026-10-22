package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f10740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f10741b;

    public static c a(int r5, ReadableArray r10) {
        c r11 = new c();
        r11.f10740a = new k(r10.getDynamic(r5), r10.getInt(r5 + 1));
        r11.f10741b = new k(r10.getDynamic(r5 + 2), r10.getInt(r5 + 3));
        return r11;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        c r10 = (c) r5;
        if (Objects.equals(this.f10740a, r10.f10740a) == true) goto L8;
    L11:
        return false;
    L8:
        if (Objects.equals(this.f10741b, r10.f10741b) == false) goto L11;
        return true;
    }
}
