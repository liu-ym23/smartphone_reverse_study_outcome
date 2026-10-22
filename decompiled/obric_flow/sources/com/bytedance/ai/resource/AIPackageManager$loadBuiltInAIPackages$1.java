package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {}, l = {613, 659}, m = "loadBuiltInAIPackages", n = {}, s = {})
final class AIPackageManager$loadBuiltInAIPackages$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f2521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2522c;

    public AIPackageManager$loadBuiltInAIPackages$1(r r5, ContinuationImpl r10) {
        this.f2521b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2520a = r5;
        this.f2522c |= Integer.MIN_VALUE;
        r r10 = this.f2521b;
        r r11 = r.f2752a;
        return r10.b(null, this);
    }
}
