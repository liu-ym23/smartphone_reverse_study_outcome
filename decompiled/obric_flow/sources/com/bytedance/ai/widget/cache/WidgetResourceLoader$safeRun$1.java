package com.bytedance.ai.widget.cache;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0, 0}, l = {99}, m = "safeRun", n = {"this", "$this$safeRun"}, s = {"L$0", "L$1"})
final class WidgetResourceLoader$safeRun$1<T> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f2978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2979c;
    public final /* synthetic */ e d;
    public int e;

    public WidgetResourceLoader$safeRun$1(e r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2979c = r5;
        this.e |= Integer.MIN_VALUE;
        e r10 = this.d;
        ConcurrentHashMap r11 = e.f;
        return r10.c(null, null, this);
    }
}
