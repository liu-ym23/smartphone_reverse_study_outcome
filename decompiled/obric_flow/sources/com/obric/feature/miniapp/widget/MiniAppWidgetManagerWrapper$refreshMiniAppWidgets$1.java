package com.obric.feature.miniapp.widget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {0, 0}, l = {750}, m = "refreshMiniAppWidgets", n = {"context", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class MiniAppWidgetManagerWrapper$refreshMiniAppWidgets$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlinx.coroutines.sync.a f11419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f11420c;
    public final /* synthetic */ MiniAppWidgetManagerWrapper d;
    public int e;

    public MiniAppWidgetManagerWrapper$refreshMiniAppWidgets$1(MiniAppWidgetManagerWrapper r5, Continuation r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f11420c = r5;
        this.e |= Integer.MIN_VALUE;
        return MiniAppWidgetManagerWrapper.access$refreshMiniAppWidgets(this.d, null, this);
    }
}
