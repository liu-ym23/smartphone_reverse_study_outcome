package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.event.EventsListener;
import java.util.Map;
import y6a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsInlineImageShadowNode extends BaseTextShadowNode {
    public boolean M;
    public boolean N;
    public int O;
    public com.lynx.tasm.behavior.ui.utils.e P;

    public abstract com.lynx.tasm.behavior.ui.text.a O();

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean p() {
        return true;
    }

    @LynxProp(name = "mode")
    public abstract void setMode(String r1);

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public abstract void setSource(String r1);

    public final com.lynx.tasm.behavior.ui.utils.e P() {
        if (this.P != null) goto L6;
        this.P = new com.lynx.tasm.behavior.ui.utils.e(getContext());
    L6:
        return this.P;
    }

    public AbsInlineImageShadowNode() {
        this.O = 0;
    }

    public final void Q(String r4) {
        if (this.N == true) goto L5;
        return;
    L5:
        m7a.a r0 = new m7a.a(this.b, "error");
        r0.a("errMsg", r4);
        getContext().getEventEmitter().sendCustomEvent(r0);
    }

    public void S(com.lynx.tasm.behavior.ui.text.a r3) {
        n r0 = this.n;
        if (r0 == null) goto L6;
        int r1 = r0.a;
        float r2 = r0.b;
        r3.a = r1;
        r3.b = r2;
        return;
    }

    @LynxProp(defaultInt = 0, name = "background-color")
    public void setBackgroundColor(int r1) {
        this.O = r1;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = "vertical-align")
    public void setVerticalAlign(ReadableArray r1) {
        y(r1);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void x(Map<String, EventsListener> r2) {
        this.p = r2;
        if (r2 == null) goto L6;
        this.M = r2.containsKey("load");
        this.N = r2.containsKey("error");
        return;
    }

    public final void R(int r4, int r5) {
        if (this.M == true) goto L5;
        return;
    L5:
        m7a.a r0 = new m7a.a(this.b, "load");
        r0.a("height", Integer.valueOf(r5));
        r0.a("width", Integer.valueOf(r4));
        getContext().getEventEmitter().sendCustomEvent(r0);
    }

    @LynxPropGroup(customType = "Color", names = {"border-left-color", "border-right-color", "border-top-color", "border-bottom-color"})
    public void setBorderColor(int r3, Integer r4) {
        P().p(LynxBaseUI.SPACING_TYPES[r3 + 1], r4);
    }

    @LynxPropGroup(names = {"border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius"})
    public void setBorderRadius(int r2, ReadableArray r3) {
        P().q(r2, r3);
    }

    @LynxPropGroup(defaultInt = -1, names = {"border-style", "border-left-style", "border-right-style", "border-top-style", "border-bottom-style"})
    public void setBorderStyle(int r3, int r4) {
        P().s(LynxBaseUI.SPACING_TYPES[r3], r4);
    }

    @LynxPropGroup(names = {"border-width", "border-left-width", "border-right-width", "border-top-width", "border-bottom-width"})
    public void setBorderWidth(int r3, int r4) {
        P().b().c(LynxBaseUI.SPACING_TYPES[r3], r4);
    }
}
