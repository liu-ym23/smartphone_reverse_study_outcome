package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0, 1, 1, 2}, l = {357, 359, 362}, m = "cleanPackageToDelete", n = {"this", "info", "this", "info", "info"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
final class AIPackageStorage$cleanPackageToDelete$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackage f2620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2621c;
    public final /* synthetic */ AIPackageStorage d;
    public int e;

    public AIPackageStorage$cleanPackageToDelete$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2621c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
