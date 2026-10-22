package com.bytedance.ai.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0, 0, 0}, l = {112}, m = "loadWidgetFromPackage", n = {"this", "packageName", "widgetId"}, s = {"L$0", "L$1", "L$2"})
final class WidgetResourceLoader$loadWidgetFromPackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2976c;
    public /* synthetic */ Object d;
    public final /* synthetic */ e e;
    public int f;

    public WidgetResourceLoader$loadWidgetFromPackage$1(e r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return e.b(this.e, this);
    }
}
