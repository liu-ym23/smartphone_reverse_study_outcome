package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {}, l = {323}, m = "installPackageFromGecko$ai_sdk_release", n = {}, s = {})
final class AIPackageManager$installPackageFromGecko$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f2518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2519c;

    public AIPackageManager$installPackageFromGecko$1(r r5, ContinuationImpl r10) {
        this.f2518b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2517a = r5;
        this.f2519c |= Integer.MIN_VALUE;
        return this.f2518b.f(null, this);
    }
}
