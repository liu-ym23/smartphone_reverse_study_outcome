package com.bytedance.ai.bridge.remote;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService", f = "UserAuthService.kt", i = {}, l = {31}, m = "checkPrivacy-0E7RQCE", n = {}, s = {})
final class UserAuthService$checkPrivacy$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2045c;

    public UserAuthService$checkPrivacy$1(b r5, ContinuationImpl r10) {
        this.f2044b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2043a = r5;
        this.f2045c |= Integer.MIN_VALUE;
        Object r10 = this.f2044b.c(null, null, this);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Result.m123boximpl(r10);
    }
}
