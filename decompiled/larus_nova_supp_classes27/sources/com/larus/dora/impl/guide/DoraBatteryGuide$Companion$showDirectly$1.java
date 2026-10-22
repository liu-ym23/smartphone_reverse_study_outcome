package com.larus.dora.impl.guide;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBatteryGuide$Companion$showDirectly$1", f = "DoraBatteryGuide.kt", i = {0, 2}, l = {94, 95, 100}, m = "invokeSuspend", n = {"startTime", "startTime"}, s = {"J$0", "J$0"})
public final class DoraBatteryGuide$Companion$showDirectly$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ DoraBatteryGuide $interactor;
    long J$0;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.guide.DoraBatteryGuide$Companion$showDirectly$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.guide.DoraBatteryGuide$Companion$showDirectly$1$1", f = "DoraBatteryGuide.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ DoraBatteryGuide $interactor;
        int label;

        public AnonymousClass1(DoraBatteryGuide r1, Activity r2, Continuation<? super AnonymousClass1> r3) {
            this.$interactor = r1;
            this.$activity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$interactor, this.$activity, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraBatteryGuide r6 = this.$interactor;
            Activity r2 = this.$activity;
            this.label = 1;
            r6.getClass();
            g49.d.d("DoraBatteryGuide", "showGuideDirectly() called");
            if (r6.h() == false) goto L11;
            Object r7 = Unit.INSTANCE;
        L15:
            if (r7 != r0) goto L18;
            return r0;
        L11:
            r7 = r6.i(r2, null, null, this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            r7 = Unit.INSTANCE;
            goto L15
        }
    }

    public DoraBatteryGuide$Companion$showDirectly$1(DoraBatteryGuide r1, Activity r2, Continuation<? super DoraBatteryGuide$Companion$showDirectly$1> r3) {
        this.$interactor = r1;
        this.$activity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraBatteryGuide$Companion$showDirectly$1(this.$interactor, this.$activity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007e -> B:14:0x0033). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r13);
    L13:
        DoraBatteryGuide$Companion$showDirectly$1 r14 = this;
    L15:
        if ((System.currentTimeMillis() - r5) >= 5000) goto L31;
        DoraBatteryGuide r2 = r14.$interactor;
        r14.J$0 = r5;
        r14.label = 1;
        Object r3 = r2.c(r14);
        if (r3 != r0) goto L19;
        return r0;
    L19:
        Object r11 = r0;
        DoraBatteryGuide$Companion$showDirectly$1 r4 = r14;
        r13 = r3;
        Object r6 = r11;
    L21:
        if (((Boolean) r13).booleanValue() == false) goto L27;
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AnonymousClass1 r7 = new AnonymousClass1(r4.$interactor, r4.$activity, null);
        r4.label = 2;
        if (BuildersKt.withContext(r15, r7, r4) != r6) goto L26;
        return r6;
    L26:
        return Unit.INSTANCE;
    L27:
        r4.J$0 = r5;
        r4.label = 3;
        if (DelayKt.delay(500, r4) != r6) goto L30;
        return r6;
    L30:
        r14 = r4;
        r0 = r6;
        goto L15
    L31:
        g49.d.d("DoraBatteryGuide", "showDirectly: condition not met within 5s timeout");
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);
        goto L26
    L11:
        r5 = this.J$0;
        ResultKt.throwOnFailure(r13);
        r6 = r0;
        r4 = this;
        goto L21
    L12:
        ResultKt.throwOnFailure(r13);
        r5 = System.currentTimeMillis();
        goto L13
    }
}
