package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.b;

/* JADX INFO: loaded from: classes2.dex */
public class UIBounceView extends UISimpleView<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10635a;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new b(r5);
    }

    @c0(customType = "right", name = "direction")
    public void setDirection(pm.a r5) {
        if (r5.getType() != ReadableType.String) goto L20;
        String r10 = r5.asString();
        if (r10.equals("right") == false) goto L9;
        this.f10635a = 0;
        return;
    L9:
        if (r10.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L13;
        this.f10635a = 1;
        return;
    L13:
        if (r10.equals("top") == false) goto L17;
        this.f10635a = 2;
        return;
    L17:
        if (r10.equals("bottom") == false) goto L21;
        this.f10635a = 3;
        return;
    L21:
        return;
    }
}
