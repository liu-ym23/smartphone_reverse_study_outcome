package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1}, l = {53, 55}, m = "deleteAIPackageById", n = {"item", "item"}, s = {"L$0", "L$0"})
final class AIPackageStorage$deleteAIPackageById$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f2622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageStorage f2624c;
    public int d;

    public AIPackageStorage$deleteAIPackageById$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.f2624c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2623b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f2624c.a(null, null, this);
    }
}
