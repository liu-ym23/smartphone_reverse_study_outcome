package com.bytedance.ai.applet.render.core.lynx;

import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.widgets.LynxViewFloatingPage;
import com.lynx.tasm.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1768b;

    public /* synthetic */ h(Object r5, int r10) {
        this.f1767a = r10;
        this.f1768b = r5;
    }

    @Override // com.lynx.tasm.o0
    public void onFirstScreen() {
        switch(this.f1767a) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        String r5 = "onFirstScreen " + ((PageInfo) this.f1768b).getPageName() + ' ';
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L9;
        r10.i("LynxViewFloatingPage", r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public void onLoadSuccess() {
        switch(this.f1767a) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        String r5 = "onLoadSuccess " + ((PageInfo) this.f1768b).getPageName();
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L9;
        r10.i("LynxViewFloatingPage", r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public void onLynxViewAndJSRuntimeDestroy() {
        switch(this.f1767a) {
            case 0: goto L9;
            case 1: goto L4;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        Intrinsics.checkNotNullParameter("onLynxViewAndJSRuntimeDestroy", "msg");
        a1.a.f43a.d("LynxViewFloatingPage", "onLynxViewAndJSRuntimeDestroy");
        m1.i r5 = ((LynxViewFloatingPage) this.f1768b).f2305k;
        if (r5 == null) goto L11;
        r5.g();
        return;
    L11:
        return;
    L9:
        Intrinsics.checkNotNullParameter("LynxRenderView", "tag");
        Intrinsics.checkNotNullParameter("onLynxViewAndJSRuntimeDestroy", "msg");
        a1.a.f43a.d("LynxRenderView", "onLynxViewAndJSRuntimeDestroy");
        ((i) this.f1768b).getBridge().g();
    }
}
