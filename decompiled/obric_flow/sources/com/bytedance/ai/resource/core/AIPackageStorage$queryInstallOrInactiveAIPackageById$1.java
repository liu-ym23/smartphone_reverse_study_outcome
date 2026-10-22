package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0}, l = {172, 175}, m = "queryInstallOrInactiveAIPackageById", n = {"this", "item"}, s = {"L$0", "L$1"})
final class AIPackageStorage$queryInstallOrInactiveAIPackageById$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackageStorage f2649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f2650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2651c;
    public final /* synthetic */ AIPackageStorage d;
    public int e;

    public AIPackageStorage$queryInstallOrInactiveAIPackageById$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2651c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
