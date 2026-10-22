package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.BaseAIPackageHelper", f = "BaseAIPackageHelper.kt", i = {0, 1}, l = {29, 36}, m = "fetchManifest", n = {"this", "this"}, s = {"L$0", "L$0"})
final class BaseAIPackageHelper$fetchManifest$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseAIPackageHelper f2698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseAIPackageHelper f2699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AIPackageManifestBean.Companion f2700c;
    public /* synthetic */ Object d;
    public final /* synthetic */ BaseAIPackageHelper e;
    public int f;

    public BaseAIPackageHelper$fetchManifest$1(BaseAIPackageHelper r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(this);
    }
}
