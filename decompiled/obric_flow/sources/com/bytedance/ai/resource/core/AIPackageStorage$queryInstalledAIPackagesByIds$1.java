package com.bytedance.ai.resource.core;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0, 0}, l = {182}, m = "queryInstalledAIPackagesByIds", n = {"packages", "aiPackages", "tryActive"}, s = {"L$0", "L$1", "Z$0"})
final class AIPackageStorage$queryInstalledAIPackagesByIds$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f2652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f2654c;
    public boolean d;
    public /* synthetic */ Object e;
    public final /* synthetic */ AIPackageStorage f;
    public int g;

    public AIPackageStorage$queryInstalledAIPackagesByIds$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, false, this);
    }
}
