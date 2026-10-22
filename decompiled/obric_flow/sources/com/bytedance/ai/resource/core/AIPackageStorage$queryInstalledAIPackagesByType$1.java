package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {286, 291, 296, 299}, m = "queryInstalledAIPackagesByType", n = {"packageType", "aiPackages", "packageType", "aiPackages", "packageType", "aiPackages", "packageType", "aiPackages"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class AIPackageStorage$queryInstalledAIPackagesByType$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackage.AIPackageType f2658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2660c;
    public final /* synthetic */ AIPackageStorage d;
    public int e;

    public AIPackageStorage$queryInstalledAIPackagesByType$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2660c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
