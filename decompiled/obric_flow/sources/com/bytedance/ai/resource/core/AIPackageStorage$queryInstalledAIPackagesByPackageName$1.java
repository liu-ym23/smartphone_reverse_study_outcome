package com.bytedance.ai.resource.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0, 1, 1}, l = {233, 236}, m = "queryInstalledAIPackagesByPackageName", n = {"packageName", "aiPackages", "packageName", "aiPackages"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class AIPackageStorage$queryInstalledAIPackagesByPackageName$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2657c;
    public final /* synthetic */ AIPackageStorage d;
    public int e;

    public AIPackageStorage$queryInstalledAIPackagesByPackageName$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2657c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
