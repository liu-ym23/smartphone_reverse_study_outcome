package com.ss.android.lark.officesdk.feed.impl;

import com.ss.android.lark.flow.feed.sidebar.human.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowFeedApiProxy implements qtb.b {

    public static final class a {
    }

    static {
    }

    public FlowFeedApiProxy() {
    }

    public static qtb.b X0() {
        qtb.b r0 = (qtb.b) OfficeSDKManager.getHostGlobalService(qtb.b.class);
        if (r0 != null) goto L5;
        Log.e("FlowFeedApiProxy", "IOfficeSDKFeedApi is null");
    L5:
        return r0;
    }

    @Override // qtb.b
    public final boolean P0() {
        qtb.b r0 = X0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.P0();
    }

    @Override // qtb.b
    public final boolean Y1() {
        qtb.b r0 = X0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.Y1();
    }

    @Override // qtb.b
    public final boolean getIsImFeatureOpenedByHostManual() {
        qtb.b r0 = X0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getIsImFeatureOpenedByHostManual();
    }

    @Override // qtb.b
    public final boolean K(String r2) {
        Intrinsics.checkNotNullParameter(r2, "doubaoUid");
        qtb.b r0 = X0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.K(r2);
    }

    @Override // qtb.b
    public final void M(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        qtb.b r0 = X0();
        if (r0 == null) goto L6;
        r0.M(r2);
        return;
    }

    @Override // qtb.b
    public final void a0(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        qtb.b r0 = X0();
        if (r0 == null) goto L6;
        r0.a0(r2);
        return;
    }

    @Override // qtb.b
    public final Object N1(byte[] r5, Continuation<? super byte[]> r6) {
        if ((r6 instanceof FlowFeedApiProxy$packFeedChannel$1) == false) goto L7;
        FlowFeedApiProxy$packFeedChannel$1 r0 = (FlowFeedApiProxy$packFeedChannel$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L19:
        byte[] r8 = (byte[]) r7;
        if (r8 != null) goto L23;
    L21:
        Log.e("FlowFeedApiProxy", "packFeedChannel delegate is null");
        return new byte[0];
    L23:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        qtb.b r9 = X0();
        if (r9 == null) goto L21;
        r0.label = 1;
        r7 = r9.N1(r5, r0);
        if (r7 != r2) goto L19;
        return r2;
    L7:
        r0 = new FlowFeedApiProxy$packFeedChannel$1(this, r6);
        goto L8
    }

    @Override // qtb.b
    public final Object g0(byte[] r5, Continuation<? super byte[]> r6) {
        if ((r6 instanceof FlowFeedApiProxy$packFeedPreview$1) == false) goto L7;
        FlowFeedApiProxy$packFeedPreview$1 r0 = (FlowFeedApiProxy$packFeedPreview$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L19:
        byte[] r8 = (byte[]) r7;
        if (r8 != null) goto L23;
    L21:
        Log.e("FlowFeedApiProxy", "packFeedPreview delegate is null");
        return new byte[0];
    L23:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        qtb.b r9 = X0();
        if (r9 == null) goto L21;
        r0.label = 1;
        r7 = r9.g0(r5, r0);
        if (r7 != r2) goto L19;
        return r2;
    L7:
        r0 = new FlowFeedApiProxy$packFeedPreview$1(this, r6);
        goto L8
    }

    @Override // qtb.b
    public final Object z1(byte[] r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof FlowFeedApiProxy$verifyFeedData$1) == false) goto L7;
        FlowFeedApiProxy$verifyFeedData$1 r0 = (FlowFeedApiProxy$verifyFeedData$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        qtb.b r8 = X0();
        if (r8 == null) goto L19;
        r0.label = 1;
        if (r8.z1(r5, r0) != r2) goto L21;
        return r2;
    L19:
        Log.e("FlowFeedApiProxy", "verifyFeedData delegate is null");
    L7:
        r0 = new FlowFeedApiProxy$verifyFeedData$1(this, r6);
        goto L8
    }

    @Override // qtb.b
    public final boolean X1(String r2, boolean r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "doubaoUid");
        qtb.b r0 = X0();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.X1(r2, r3, r4);
    }
}
