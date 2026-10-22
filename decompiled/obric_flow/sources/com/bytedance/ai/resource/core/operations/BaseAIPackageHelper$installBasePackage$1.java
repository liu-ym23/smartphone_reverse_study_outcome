package com.bytedance.ai.resource.core.operations;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.BaseAIPackageHelper", f = "BaseAIPackageHelper.kt", i = {0, 0}, l = {75}, m = "installBasePackage", n = {"this", "file"}, s = {"L$0", "L$1"})
final class BaseAIPackageHelper$installBasePackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseAIPackageHelper f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f2703c;
    public /* synthetic */ Object d;
    public final /* synthetic */ BaseAIPackageHelper e;
    public int f;

    public BaseAIPackageHelper$installBasePackage$1(BaseAIPackageHelper r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, this);
    }
}
