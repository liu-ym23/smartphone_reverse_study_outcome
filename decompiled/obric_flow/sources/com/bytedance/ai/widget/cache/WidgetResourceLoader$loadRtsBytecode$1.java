package com.bytedance.ai.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {316, 325}, m = "loadRtsBytecode$suspendImpl", n = {"$this", "packageName", "widgetId", "deferredKey", "deferred", "$this", "deferredKey", "deferred"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
final class WidgetResourceLoader$loadRtsBytecode$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2944c;
    public String d;
    public r e;
    public /* synthetic */ Object f;
    public final /* synthetic */ e g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2945h;

    public WidgetResourceLoader$loadRtsBytecode$1(e r5, ContinuationImpl r10) {
        this.g = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f = r5;
        this.f2945h |= Integer.MIN_VALUE;
        return e.e(this.g, this);
    }
}
