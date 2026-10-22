package com.obric.assistant.interaction.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tH\u0080@¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TOP_ACTIVITY_KEYGUARD_CHECK_COUNT", "", "TOP_ACTIVITY_KEYGUARD_CHECK_INTERVAL_MS", "", "waitForTopActivityKeyguardUnlocked", "", "isKeyguardLocked", "Lkotlin/Function0;", "waitForNextCheck", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ObricKeyguardServiceImplKt {
    private static final int TOP_ACTIVITY_KEYGUARD_CHECK_COUNT = 3;
    private static final long TOP_ACTIVITY_KEYGUARD_CHECK_INTERVAL_MS = 500;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.ObricKeyguardServiceImplKt$waitForTopActivityKeyguardUnlocked$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricKeyguardServiceImplKt", f = "ObricKeyguardServiceImpl.kt", i = {0, 0}, l = {380}, m = "waitForTopActivityKeyguardUnlocked", n = {"isKeyguardLocked", "waitForNextCheck"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ObricKeyguardServiceImplKt.waitForTopActivityKeyguardUnlocked(null, null, this);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005b -> B:27:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0074 -> B:26:0x007a). Please report as a decompilation issue!!! */
    public static final Object waitForTopActivityKeyguardUnlocked(Function0<Boolean> r8, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r12 = r0.I$1;
        int r13 = r0.I$0;
        Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r4 = (Function2) r0.L$1;
        Function0<Boolean> r5 = (Function0) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L26:
        int r14 = r13;
        Function0<Boolean> r15 = r5;
        Object r7 = r2;
        AnonymousClass1 r6 = r0;
        Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r16 = r4;
        Object r17 = r7;
    L27:
        r12 = r12 + 1;
    L15:
        if (r12 >= r14) goto L29;
        if (((Boolean) r15.invoke()).booleanValue() == true) goto L21;
        return Boxing.boxBoolean(true);
    L21:
        if (r12 >= 2) goto L27;
        Long r18 = Boxing.boxLong(TOP_ACTIVITY_KEYGUARD_CHECK_INTERVAL_MS);
        r6.L$0 = r15;
        r6.L$1 = r16;
        r6.I$0 = r14;
        r6.I$1 = r12;
        r6.label = 1;
        if (r16.invoke(r18, r6) != r17) goto L25;
        return r17;
    L25:
        r5 = r15;
        r13 = r14;
        Object r19 = r17;
        r4 = r16;
        r0 = r6;
        r2 = r19;
        goto L26
    L29:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r14 = 3;
        r17 = r2;
        r6 = r0;
        r16 = r9;
        r15 = r8;
        r12 = 0;
    L7:
        r0 = new AnonymousClass1(r10);
        goto L8
    }
}
