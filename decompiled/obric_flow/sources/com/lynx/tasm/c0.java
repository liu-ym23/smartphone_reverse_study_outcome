package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f10823b;

    public /* synthetic */ c0(d0 r5, int r10) {
        this.f10822a = r10;
        this.f10823b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10822a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        d0 r5 = this.f10823b;
        LynxTemplateRender r10 = (LynxTemplateRender) r5.f10837a;
        if (r10.f10033m == null) goto L12;
        r10.f0("Client.onPageUpdate");
        ((LynxTemplateRender) r5.f10837a).f10033m.onPageUpdate();
        ((LynxTemplateRender) r5.f10837a).getClass();
        LynxTemplateRender.j0("Client.onPageUpdate");
        return;
    L12:
        return;
    L8:
        p0 r11 = ((LynxTemplateRender) this.f10823b.f10837a).f10033m;
        if (r11 == null) goto L13;
        r11.onFirstScreen();
        return;
    }
}
