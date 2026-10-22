package com.lynx.tasm.behavior;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.obric.oui.infopanel.OInfoPanelView;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10280b;

    public /* synthetic */ m(Object r5, int r10) {
        this.f10279a = r10;
        this.f10280b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Object r5 = this.f10280b;
        switch(this.f10279a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = OInfoPanelView.f13512o;
        ((OInfoPanelView) r5).getClass();
        return;
    L6:
        ((b0) r5).h();
        return;
    L8:
        LynxLog.b(1, LynxMonitorService.DEFAULT_PID, "onGlobalLayout invoked.");
        ((o) r5).a();
    }

    public m(OInfoPanelView r5, Context r10) {
        this.f10279a = 2;
        this.f10280b = r5;
    }
}
