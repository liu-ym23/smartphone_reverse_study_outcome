package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10174c;
    public final boolean d;

    public a(String r5, boolean r10, boolean r11, boolean r12) {
        this.f10172a = r5;
        this.f10173b = r10;
        this.f10174c = r11;
        this.d = r12;
    }

    public com.lynx.tasm.a a() {
        return null;
    }

    public LynxFlattenUI b(com.lynx.tasm.b0 r5, com.lynx.tasm.behavior.ui.z r10) {
        return null;
    }

    public LynxUI c(com.lynx.tasm.b0 r5) {
        throw new RuntimeException(this.f10172a.concat(" is a virtual node, do not have real ui!"));
    }

    public ShadowNode d() {
        return null;
    }

    public LynxUI e(com.lynx.tasm.b0 r5, com.lynx.tasm.behavior.ui.z r10) {
        return c(r5);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[");
        r5.append(getClass().getSimpleName());
        r5.append(" - ");
        return ai.j0.q(r5, this.f10172a, "]");
    }
}
