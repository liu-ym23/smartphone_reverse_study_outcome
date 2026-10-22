package com.bytedance.ai.resource;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0}, l = {251}, m = "onUpdateAIPackages", n = {"listener"}, s = {"L$0"})
final class AIPackageManager$onUpdateAIPackages$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f2526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Iterator f2527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2528c;
    public final /* synthetic */ r d;
    public int e;

    public AIPackageManager$onUpdateAIPackages$1(r r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2528c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.e(null, null, this);
    }
}
