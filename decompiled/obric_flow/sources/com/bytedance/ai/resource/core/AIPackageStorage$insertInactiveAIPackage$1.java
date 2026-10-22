package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1}, l = {36, 38}, m = "insertInactiveAIPackage", n = {"info", "info"}, s = {"L$0", "L$0"})
final class AIPackageStorage$insertInactiveAIPackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackage f2631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageStorage f2633c;
    public int d;

    public AIPackageStorage$insertInactiveAIPackage$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.f2633c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2632b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f2633c.d(null, this);
    }
}
