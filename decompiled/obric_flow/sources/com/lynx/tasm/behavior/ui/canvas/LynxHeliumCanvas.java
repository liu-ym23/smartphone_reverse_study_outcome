package com.lynx.tasm.behavior.ui.canvas;

import android.content.Context;
import android.view.View;
import bn.a;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.e0;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.core.JSProxy;

/* JADX INFO: loaded from: classes2.dex */
@e0
public class LynxHeliumCanvas extends LynxUI<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10444a;

    public LynxHeliumCanvas(b0 r5) {
        super(r5, null);
        JSProxy r10 = (JSProxy) this.mContext.f10142j.get();
        this.f10444a = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        a r10 = new a(r5);
        r10.setCanvasUI(this);
        r10.setConsumeAllEvents(this.f10444a);
        this.mView = r10;
        r10.setOpaque(false);
        return (a) this.mView;
    }

    @c0(name = "consume-android-events")
    public void setConsumeAllEvents(boolean r5) {
        this.f10444a = r5;
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((a) r10).setConsumeAllEvents(r5);
        return;
    }
}
