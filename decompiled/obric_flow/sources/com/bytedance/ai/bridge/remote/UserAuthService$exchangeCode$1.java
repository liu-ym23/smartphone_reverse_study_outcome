package com.bytedance.ai.bridge.remote;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService", f = "UserAuthService.kt", i = {}, l = {205}, m = "exchangeCode-yxL6bBk", n = {}, s = {})
final class UserAuthService$exchangeCode$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2050c;

    public UserAuthService$exchangeCode$1(b r5, ContinuationImpl r10) {
        this.f2049b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2048a = r5;
        this.f2050c |= Integer.MIN_VALUE;
        Object r10 = this.f2049b.b(null, null, null, this);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Result.m123boximpl(r10);
    }
}
