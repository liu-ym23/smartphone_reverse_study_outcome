package com.larus.bmhome.video.fragment;

import android.content.Context;
import android.content.res.Resources;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.platform.service.e0;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$deleteCreation$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {421, 430}, m = "invokeSuspend", n = {}, s = {})
final class AiGenVideoDetailFragment$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$deleteCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$deleteCreation$1$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AiGenVideoDetailFragment this$0;

        public AnonymousClass1(AiGenVideoDetailFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            AiGenVideoDetailFragment r3 = this.this$0;
            r3.pa0(r3.M);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AiGenVideoDetailFragment$deleteCreation$1(AiGenVideoDetailFragment r1, Continuation<? super AiGenVideoDetailFragment$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AiGenVideoDetailFragment$deleteCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L13:
        Pair r15 = (Pair) r14;
        if (r15 == null) goto L16;
        Boolean r16 = (Boolean) r15.getFirst();
    L18:
        if (Intrinsics.areEqual(r16, Boxing.boxBoolean(true)) == true) goto L22;
        AiGenVideoDetailFragment r4 = this.this$0;
        e2.a.b(new tx9.u("chat", "creation_detail", TriggerSendLoading.NO_LOADING, r4.P, zp9.y.b(r4.ha0()), null, null, 193), null, 3);
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r17, r3, this) != r0) goto L31;
        return r0;
    L22:
        AiGenVideoDetailFragment r2 = this.this$0;
        e2.a.b(new tx9.u("chat", "creation_detail", "1", r2.P, zp9.y.b(r2.ha0()), null, null, 193), null, 3);
        e0.a.X0(this.this$0.P);
        t19.s r18 = t19.s.a;
        Context r5 = this.this$0.getContext();
        Context r6 = this.this$0.getContext();
        if (r6 == null) goto L28;
        Resources r7 = r6.getResources();
        if (r7 == null) goto L28;
        String r8 = r7.getString(2131900648);
        if (r8 == null) goto L28;
    L29:
        r18.getClass();
        t19.s.p(r5, r8);
    L28:
        r8 = "";
        goto L29
    L16:
        r16 = null;
        goto L18
    L10:
        ResultKt.throwOnFailure(r14);
        e0 r19 = e0.a;
        String r9 = this.this$0.P;
        this.label = 1;
        r14 = r19.g(r9, this);
        if (r14 != r0) goto L13;
        return r0;
    }
}
