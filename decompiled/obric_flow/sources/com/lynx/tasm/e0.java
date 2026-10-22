package com.lynx.tasm;

import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10838a;

    @Override // com.lynx.tasm.o0
    public final void onDataUpdated() {
        LynxLog.b(1, "LynxTemplateRender", "onDataUpdated time:" + (System.currentTimeMillis() - this.f10838a));
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstScreen() {
        LynxLog.b(1, "LynxTemplateRender", "onFirstScreen time: " + (System.currentTimeMillis() - this.f10838a));
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        LynxLog.b(1, "LynxTemplateRender", "onLoadSuccess time: " + (System.currentTimeMillis() - this.f10838a));
    }

    @Override // com.lynx.tasm.o0
    public final void onPageStart(String r5) {
        this.f10838a = System.currentTimeMillis();
    }

    @Override // com.lynx.tasm.o0
    public final void onPageUpdate() {
        LynxLog.b(1, "LynxTemplateRender", "onPageUpdate time:" + (System.currentTimeMillis() - this.f10838a));
    }
}
