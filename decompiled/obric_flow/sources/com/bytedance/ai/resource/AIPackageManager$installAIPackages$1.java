package com.bytedance.ai.resource;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0}, l = {100}, m = "installAIPackages", n = {"listener"}, s = {"L$0"})
final class AIPackageManager$installAIPackages$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f2514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Iterator f2515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2516c;
    public final /* synthetic */ r d;
    public int e;

    public AIPackageManager$installAIPackages$1(r r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2516c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.g(null, null, this);
    }
}
