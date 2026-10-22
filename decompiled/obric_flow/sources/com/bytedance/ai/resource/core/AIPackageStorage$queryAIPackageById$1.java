package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10, 10, 11}, l = {100, 103, 105, 111, 114, 116, 123, 124, 127, 128, 130, 131}, m = "queryAIPackageById", n = {"item", "item", "item", "item", "item", "item", "item", "versionCode", "item", "item", "installStatus", "item", "item", "installStatus", "versionCode", "item"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "J$0", "L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "J$0", "L$0"})
final class AIPackageStorage$queryAIPackageById$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f2637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2639c;
    public /* synthetic */ Object d;
    public final /* synthetic */ AIPackageStorage e;
    public int f;

    public AIPackageStorage$queryAIPackageById$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.d = r10;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, null, false, 0, this);
    }
}
