package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletInitSyncHelper", f = "AppletInitSyncHelper.kt", i = {0, 0}, l = {72, 86}, m = "ensureInitialize", n = {"this", "attempt"}, s = {"L$0", "L$1"})
final class AppletInitSyncHelper$ensureInitialize$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f2540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2542c;
    public final /* synthetic */ y d;
    public int e;

    public AppletInitSyncHelper$ensureInitialize$1(y r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2542c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(this);
    }
}
