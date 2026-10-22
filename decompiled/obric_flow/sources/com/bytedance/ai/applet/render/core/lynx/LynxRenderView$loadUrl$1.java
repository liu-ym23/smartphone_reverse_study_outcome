package com.bytedance.ai.applet.render.core.lynx;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.render.core.lynx.LynxRenderView", f = "LynxRenderView.kt", i = {0, 0, 0}, l = {110}, m = "loadUrl", n = {"this", "url", "data"}, s = {"L$0", "L$1", "L$2"})
final class LynxRenderView$loadUrl$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f1756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f1758c;
    public /* synthetic */ Object d;
    public final /* synthetic */ i e;
    public int f;

    public LynxRenderView$loadUrl$1(i r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, this);
    }
}
