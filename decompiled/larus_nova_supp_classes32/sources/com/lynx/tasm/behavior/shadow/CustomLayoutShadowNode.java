package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.LynxProp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CustomLayoutShadowNode extends ShadowNode {
    public boolean v;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean z() {
        return true;
    }

    public CustomLayoutShadowNode() {
        this.v = false;
    }

    @LynxProp(name = "custom-layout")
    public void setCustomLayout(boolean r1) {
        this.v = r1;
    }
}
