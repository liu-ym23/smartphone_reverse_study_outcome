package com.bytedance.ai.applet.render.core.relax;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.render.core.relax.RelaxRenderView", f = "RelaxRenderView.kt", i = {0, 0}, l = {87}, m = "loadUrl", n = {"this", "url"}, s = {"L$0", "L$1"})
final class RelaxRenderView$loadUrl$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1788c;
    public final /* synthetic */ f d;
    public int e;

    public RelaxRenderView$loadUrl$1(f r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f1788c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, null, this);
    }
}
