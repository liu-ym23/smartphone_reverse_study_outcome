package com.bytedance.ai.widget.cache;

import com.bytedance.ai.widget.contianer.h;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0}, l = {351}, m = "awaitRunApplet$suspendImpl", n = {"widgetContainerData"}, s = {"L$0"})
final class WidgetResourceLoader$awaitRunApplet$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f2939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f2941c;
    public int d;

    public WidgetResourceLoader$awaitRunApplet$1(e r5, ContinuationImpl r10) {
        this.f2941c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2940b = r5;
        this.d |= Integer.MIN_VALUE;
        return e.a(this.f2941c, null, this);
    }
}
