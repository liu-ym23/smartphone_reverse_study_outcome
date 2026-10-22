package com.lynx.tasm.behavior.ui.canvas;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxHeliumCanvas extends LynxUI<LynxHeliumCanvasView> {
    public boolean a;

    public LynxHeliumCanvas(Context r1) {
        super(r1);
        this.mContext.getRuntimeId();
        this.a = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        LynxHeliumCanvasView r0 = new LynxHeliumCanvasView(r2);
        r0.setCanvasUI(this);
        r0.setConsumeAllEvents(this.a);
        this.mView = r0;
        r0.setOpaque(false);
        return (LynxHeliumCanvasView) this.mView;
    }

    @LynxProp(name = "consume-android-events")
    public void setConsumeAllEvents(boolean r2) {
        this.a = r2;
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((LynxHeliumCanvasView) r0).setConsumeAllEvents(r2);
        return;
    }
}
