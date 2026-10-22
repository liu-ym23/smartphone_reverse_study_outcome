package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager", f = "WidgetManager.kt", i = {0, 0, 0}, l = {238}, m = "bindWidget", n = {"this", "context", "view"}, s = {"L$0", "L$1", "L$2"})
final class WidgetManager$bindWidget$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f2915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w2.r f2916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Ref.ObjectRef f2917c;
    public /* synthetic */ Object d;
    public final /* synthetic */ o e;
    public int f;

    public WidgetManager$bindWidget$1(o r5, Continuation r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return this.e.e(null, this);
    }
}
