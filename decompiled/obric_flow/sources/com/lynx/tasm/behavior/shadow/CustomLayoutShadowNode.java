package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.c0;

/* JADX INFO: loaded from: classes2.dex */
public class CustomLayoutShadowNode extends ShadowNode {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10333v;

    public CustomLayoutShadowNode() {
        this.f10333v = false;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean r() {
        return true;
    }

    @c0(name = "custom-layout")
    public void setCustomLayout(boolean r5) {
        this.f10333v = r5;
    }
}
