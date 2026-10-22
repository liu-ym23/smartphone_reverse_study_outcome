package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.content.res.Resources;
import com.larus.platform.service.e0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$deleteCreation$1", f = "CreationBottomView.kt", i = {}, l = {705, 714}, m = "invokeSuspend", n = {}, s = {})
final class CreationBottomView$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationBottomView this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.creation.gallery.providers.CreationBottomView$deleteCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$deleteCreation$1$1", f = "CreationBottomView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationBottomView this$0;

        public AnonymousClass1(CreationBottomView r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            CreationBottomView r4 = this.this$0;
            sz9.a r0 = r4.d;
            if (r0 == null) goto L7;
            Integer r1 = Boxing.boxInt(r0.c);
        L8:
            r4.k6(r1, "deleteCreation fail");
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationBottomView$deleteCreation$1(CreationBottomView r1, Continuation<? super CreationBottomView$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationBottomView$deleteCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r5 = "";
        String r6 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r17);
    L59:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        Object r3 = r17;
    L19:
        Pair r4 = (Pair) r3;
        if (r4 == null) goto L22;
        Boolean r7 = (Boolean) r4.getFirst();
    L24:
        if (Intrinsics.areEqual(r7, Boxing.boxBoolean(true)) == true) goto L32;
        CreationBottomView r8 = this.this$0;
        sz9.a r9 = r8.d;
        if (r9 == null) goto L28;
        String r11 = r9.p;
    L29:
        e2.a.b(new tx9.u("chat", "creation_detail", "0", r11, CreationBottomView.S5(r8), null, null, 193), null, 3);
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r12 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r10, r12, this) != r1) goto L59;
        return r1;
    L28:
        r11 = null;
        goto L29
    L32:
        CreationBottomView r13 = this.this$0;
        sz9.a r14 = r13.d;
        if (r14 == null) goto L35;
        String r15 = r14.p;
    L36:
        e2.a.b(new tx9.u("chat", "creation_detail", "1", r15, CreationBottomView.S5(r13), null, null, 193), null, 3);
        t19.s r16 = t19.s.a;
        Context r18 = this.this$0.getContext();
        Context r19 = this.this$0.getContext();
        if (r19 == null) goto L42;
        Resources r20 = r19.getResources();
        if (r20 == null) goto L42;
        String r21 = r20.getString(2131900648);
        if (r21 == null) goto L42;
    L43:
        r16.getClass();
        t19.s.p(r18, r21);
        e0 r22 = e0.a;
        sz9.a r23 = this.this$0.d;
        if (r23 == null) goto L46;
        String r24 = r23.p;
    L47:
        if (r24 != null) goto L49;
        r24 = "";
    L49:
        r22.X0(r24);
        CreationBottomView r25 = this.this$0;
        rz9.d r26 = r25.c;
        if (r26 == null) goto L59;
        sz9.a r27 = r25.d;
        if (r27 == null) goto L54;
        r6 = r27.e;
    L54:
        if (r6 == null) goto L57;
        r5 = r6;
    L57:
        r26.c(r5);
        goto L59
    L46:
        r24 = null;
    L42:
        r21 = "";
        goto L43
    L35:
        r15 = null;
        goto L36
    L22:
        r7 = null;
        goto L24
    L10:
        ResultKt.throwOnFailure(r17);
        e0 r28 = e0.a;
        sz9.a r29 = this.this$0.d;
        if (r29 == null) goto L13;
        String r30 = r29.p;
    L14:
        if (r30 != null) goto L16;
        r30 = "";
    L16:
        this.label = 1;
        r3 = r28.g(r30, this);
        if (r3 != r1) goto L19;
        return r1;
    L13:
        r30 = null;
        goto L14
    }
}
