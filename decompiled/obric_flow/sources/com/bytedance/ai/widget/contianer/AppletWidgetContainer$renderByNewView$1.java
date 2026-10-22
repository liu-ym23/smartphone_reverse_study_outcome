package com.bytedance.ai.widget.contianer;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer", f = "AppletWidgetContainer.kt", i = {0, 0, 0, 0, 1}, l = {725, 730}, m = "renderByNewView", n = {"this", "widget", "renderView", "url", "this"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
final class AppletWidgetContainer$renderByNewView$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppletWidgetContainer f3015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppletWidgetContainer f3017c;
    public int d;

    public AppletWidgetContainer$renderByNewView$1(AppletWidgetContainer r5, ContinuationImpl r10) {
        this.f3017c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f3016b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f3017c.p(null, null, null, this);
    }
}
