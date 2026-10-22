package com.obric.cae.utils;

import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelUtils", f = "AIKernelUtils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2}, l = {54, 61, 73}, m = "loadAndCacheModel", n = {"this", "biz", TrackerImpl.PARAMS, "useCloud", "this", "biz", TrackerImpl.PARAMS, "pkgResult", "useCloud", "biz", "pkgResult", "updateResult"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2"})
public final class AIKernelUtils$a extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7342b;
    public Object c;
    public PackageResource d;
    public boolean e;
    public /* synthetic */ Object f;
    public final /* synthetic */ c g;
    public int h;

    public AIKernelUtils$a(c r3, Continuation<? super AIKernelUtils$a> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.g = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.f = r3;
        this.h |= Integer.MIN_VALUE;
        return this.g.a(null, false, null, this);
    }
}
