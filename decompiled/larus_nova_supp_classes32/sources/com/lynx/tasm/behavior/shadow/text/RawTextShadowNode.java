package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RawTextShadowNode extends ShadowNode {
    public String v;
    public boolean w;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean p() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final String toString() {
        return n() + " [text: " + this.v + "]";
    }

    public RawTextShadowNode() {
        this.v = null;
        this.w = false;
    }

    @LynxProp(name = "pseudo")
    public void setPsuedo(boolean r1) {
        this.w = r1;
    }

    @LynxProp(name = "text")
    public void setText(f6a.a r1) {
        this.v = b.b(r1);
        q();
    }
}
