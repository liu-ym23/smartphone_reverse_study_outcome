package com.bytedance.ai.resource.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {}, l = {493}, m = "checkOldPackageVersion", n = {}, s = {})
final class AIPackageOperationGroup$checkOldPackageVersion$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIPackageOperationGroup f2581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2582c;

    public AIPackageOperationGroup$checkOldPackageVersion$1(AIPackageOperationGroup r5, ContinuationImpl r10) {
        this.f2581b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2580a = r5;
        this.f2582c |= Integer.MIN_VALUE;
        return this.f2581b.a(null, null, false, this);
    }
}
