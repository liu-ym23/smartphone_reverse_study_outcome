package com.ss.android.lark.integrator.flow.chat;

import aza.d;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.hilt.EntryPoints;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.integrator.flow.chat.FlowChatDependencyImpl$feedDependency$1$getBadge$1", f = "FlowChatDependencyImpl.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatDependencyImpl$feedDependency$1$getBadge$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.flow.chat.FlowChatDependencyImpl$feedDependency$1$getBadge$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.integrator.flow.chat.FlowChatDependencyImpl$feedDependency$1$getBadge$1$1", f = "FlowChatDependencyImpl.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            int r2 = 0;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7
            Object r6 = ((Result) r5).unbox-impl();     // Catch: Exception -> L7
        L18:
            if (Result.isFailure-impl(r6) == false) goto L20;
            r6 = null;
        L20:
            pza.a r7 = (pza.a) r6;     // Catch: Exception -> L7
            if (r7 == null) goto L26;
            r2 = r7.b;     // Catch: Exception -> L7
        L26:
            return Boxing.boxInt(r2);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r5);
            d r8 = ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(d.class);     // Catch: Exception -> L7
            if (r8 == null) goto L26;
            this.label = 1;     // Catch: Exception -> L7
            r6 = r8.ma(this);     // Catch: Exception -> L7
            if (r6 != r0) goto L18;
            return r0;
        L7:
            e = move-exception;
            Log.e("FlowChatDependencyImpl", e);
            goto L26
        }
    }

    public FlowChatDependencyImpl$feedDependency$1$getBadge$1(Continuation<? super FlowChatDependencyImpl$feedDependency$1$getBadge$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new FlowChatDependencyImpl$feedDependency$1$getBadge$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L14;
        int r6 = r5.intValue();
    L16:
        return Boxing.boxInt(r6);
    L14:
        r6 = 0;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        AnonymousClass1 r7 = new AnonymousClass1(null);
        this.label = 1;
        r4 = TimeoutKt.c(100, r7, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
