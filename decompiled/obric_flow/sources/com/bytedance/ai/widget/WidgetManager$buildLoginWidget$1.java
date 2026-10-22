package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager", f = "WidgetManager.kt", i = {0, 0, 0, 0, 0}, l = {380}, m = "buildLoginWidget", n = {"this", "context", "appletId", "widgetId", "view"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class WidgetManager$buildLoginWidget$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f2918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w2.r f2919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2920c;
    public String d;
    public Ref.ObjectRef e;
    public /* synthetic */ Object f;
    public final /* synthetic */ o g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2921h;

    public WidgetManager$buildLoginWidget$1(o r5, ContinuationImpl r10) {
        this.g = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f = r5;
        this.f2921h |= Integer.MIN_VALUE;
        return this.g.d(null, null, null, this);
    }
}
