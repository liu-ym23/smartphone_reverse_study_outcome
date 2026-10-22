package com.bytedance.ai.widget.cache;

import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0, 0, 0, 1, 1, 1}, l = {ComposerKt.compositionLocalMapKey, 214}, m = "loadWidget$suspendImpl", n = {"$this", "deferredKey", "deferred", "$this", "deferredKey", "deferred"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class WidgetResourceLoader$loadWidget$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f2968c;
    public /* synthetic */ Object d;
    public final /* synthetic */ e e;
    public int f;

    public WidgetResourceLoader$loadWidget$1(e r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return e.h(this.e, this);
    }
}
