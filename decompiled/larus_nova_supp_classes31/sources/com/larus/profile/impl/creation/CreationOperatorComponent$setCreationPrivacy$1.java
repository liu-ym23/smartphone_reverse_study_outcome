package com.larus.profile.impl.creation;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationOperatorComponent$setCreationPrivacy$1", f = "CreationOperatorComponent.kt", i = {}, l = {212, 214, 217}, m = "invokeSuspend", n = {}, s = {})
public final class CreationOperatorComponent$setCreationPrivacy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $previousStatus;
    final /* synthetic */ boolean $private;
    final /* synthetic */ int $privateStatus;
    int label;
    final /* synthetic */ CreationOperatorComponent this$0;

    /* JADX INFO: renamed from: com.larus.profile.impl.creation.CreationOperatorComponent$setCreationPrivacy$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.creation.CreationOperatorComponent$setCreationPrivacy$1$1", f = "CreationOperatorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $previousStatus;
        int label;
        final /* synthetic */ CreationOperatorComponent this$0;

        public AnonymousClass1(CreationOperatorComponent r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$previousStatus = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$previousStatus, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.f(this.$previousStatus);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationOperatorComponent$setCreationPrivacy$1(CreationOperatorComponent r1, int r2, boolean r3, int r4, Continuation<? super CreationOperatorComponent$setCreationPrivacy$1> r5) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        this.$private = r3;
        this.$previousStatus = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationOperatorComponent$setCreationPrivacy$1(this.this$0, this.$privateStatus, this.$private, this.$previousStatus, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = "";
        boolean r5 = false;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L59:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);
    L35:
        Pair r10 = (Pair) r9;
    L36:
        if (r10 != null) goto L38;
    L40:
        if (r5 == true) goto L44;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$previousStatus, null);
        this.label = 3;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L59;
        return r0;
    L44:
        j2 r12 = this.this$0.f;
        if (r12 == null) goto L47;
        r12.fy(this.$private);
    L47:
        t19.s r13 = t19.s.a;
        AppHost.Companion r3 = AppHost.a;
        Application r6 = r3.getApplication();
        Application r7 = r3.getApplication();
        if (this.$private == false) goto L50;
        int r8 = 2131900633;
    L51:
        String r14 = r7.getString(r8);
        r13.getClass();
        t19.s.p(r6, r14);
        com.larus.platform.service.e0 r15 = com.larus.platform.service.e0.a;
        UserCreation r16 = this.this$0.d;
        if (r16 == null) goto L57;
        String r17 = r16.a;
        if (r17 == null) goto L57;
        r4 = r17;
    L57:
        r15.X0(r4);
        goto L59
    L50:
        r8 = 2131900634;
        goto L51
    L38:
        if (((Boolean) r10.getFirst()).booleanValue() != true) goto L40;
        r5 = true;
        goto L40
    L11:
        ResultKt.throwOnFailure(r9);
    L20:
        r10 = (Pair) r9;
        if (r10 != null) goto L23;
    L25:
        boolean r18 = false;
    L26:
        if (r18 == true) goto L36;
        com.larus.platform.service.e0 r19 = com.larus.platform.service.e0.a;
        UserCreation r20 = this.this$0.d;
        if (r20 == null) goto L31;
        String r21 = r20.a;
        if (r21 == null) goto L31;
    L32:
        int r22 = this.$privateStatus;
        this.label = 2;
        r9 = r19.h(r21, r22, this);
        if (r9 != r0) goto L35;
        return r0;
    L31:
        r21 = "";
        goto L32
    L23:
        if (((Boolean) r10.getFirst()).booleanValue() != true) goto L25;
        r18 = true;
        goto L26
    L12:
        ResultKt.throwOnFailure(r9);
        com.larus.platform.service.e0 r23 = com.larus.platform.service.e0.a;
        UserCreation r24 = this.this$0.d;
        if (r24 == null) goto L16;
        String r25 = r24.a;
        if (r25 == null) goto L16;
    L17:
        int r26 = this.$privateStatus;
        this.label = 1;
        r9 = r23.h(r25, r26, this);
        if (r9 != r0) goto L20;
        return r0;
    L16:
        r25 = "";
        goto L17
    }
}
