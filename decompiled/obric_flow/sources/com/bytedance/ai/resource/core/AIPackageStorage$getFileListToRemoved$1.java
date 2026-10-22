package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0}, l = {370}, m = "getFileListToRemoved", n = {"info"}, s = {"L$0"})
final class AIPackageStorage$getFileListToRemoved$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackage f2625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageStorage f2627c;
    public int d;

    public AIPackageStorage$getFileListToRemoved$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.f2627c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2626b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f2627c.b(null, this);
    }
}
