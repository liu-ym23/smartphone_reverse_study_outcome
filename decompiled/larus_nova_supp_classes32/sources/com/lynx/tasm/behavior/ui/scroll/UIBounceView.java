package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.View;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIBounceView extends UISimpleView<com.lynx.tasm.behavior.ui.view.a> {
    public int a;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new com.lynx.tasm.behavior.ui.view.a(r2);
    }

    @LynxProp(customType = "right", name = "direction")
    public void setDirection(f6a.a r3) {
        if (r3.getType() != ReadableType.String) goto L17;
        String r4 = r3.asString();
        if (r4.equals("right") == false) goto L8;
        this.a = 0;
        return;
    L8:
        if (r4.equals("left") == false) goto L11;
        this.a = 1;
        return;
    L11:
        if (r4.equals("top") == false) goto L14;
        this.a = 2;
        return;
    L14:
        if (r4.equals("bottom") == false) goto L21;
        this.a = 3;
        return;
    L21:
        return;
    }

    public UIBounceView(LynxContext r1, Object r2) {
        super(r1, r2);
        this.a = 0;
    }
}
