package com.ivy.ivykit.plugin.impl.web;

import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.bytedance.ies.bullet.kit.web.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f9535a;

    public /* synthetic */ b(h r5) {
        this.f9535a = r5;
    }

    @Override // com.bytedance.ies.bullet.kit.web.g
    public void a(int r5, int r10, int r11, int r12) {
        ol.g r13 = this.f9535a.e;
    }

    public Function4 b() {
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        final h r10 = this.f9535a;
        return new PluginWebView$urlInterceptor$1$provideWebViewLoadUrlInterceptor$1(r5, r10);
    }
}
