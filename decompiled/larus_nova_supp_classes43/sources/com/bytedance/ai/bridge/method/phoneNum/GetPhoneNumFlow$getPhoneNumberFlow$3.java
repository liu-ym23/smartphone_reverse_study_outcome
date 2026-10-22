package com.bytedance.ai.bridge.method.phoneNum;

import com.bytedance.ai.applet.login.j;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$getPhoneNumberFlow$3", f = "GetPhoneNumFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GetPhoneNumFlow$getPhoneNumberFlow$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ j $loginContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetPhoneNumFlow this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$getPhoneNumberFlow$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$getPhoneNumberFlow$3$1", f = "GetPhoneNumFlow.kt", i = {}, l = {184, 186}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ j $loginContext;
        int label;
        final /* synthetic */ GetPhoneNumFlow this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$getPhoneNumberFlow$3$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$getPhoneNumberFlow$3$1$1", f = "GetPhoneNumFlow.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00351 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ String $appletId;
            int label;
            final /* synthetic */ GetPhoneNumFlow this$0;

            public C00351(GetPhoneNumFlow r1, String r10, Continuation<? super C00351> r11) {
                this.this$0 = r1;
                this.$appletId = r10;
                super(1, r11);
            }

            public final Continuation<Unit> create(Continuation<?> r10) {
                return new C00351(this.this$0, this.$appletId, r10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r10) {
                return create(r10).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r10);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                GetPhoneNumFlow r11 = this.this$0;
                String r12 = this.$appletId;
                this.label = 1;
                if (GetPhoneNumFlow.c(r11, r12, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(j r1, GetPhoneNumFlow r10, String r11, Continuation<? super AnonymousClass1> r12) {
            this.$loginContext = r1;
            this.this$0 = r10;
            this.$appletId = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$loginContext, this.this$0, this.$appletId, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L21:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
            j r11 = this.$loginContext;
            if (r11 == null) goto L17;
            AppletAuthTaskMonitor.Session r12 = r11.h;
            if (r12 == null) goto L17;
            C00351 r13 = new C00351(this.this$0, this.$appletId, null);
            this.label = 1;
            if (r12.f(r13, this) != r0) goto L21;
            return r0;
        L17:
            GetPhoneNumFlow r14 = this.this$0;
            String r15 = this.$appletId;
            this.label = 2;
            if (GetPhoneNumFlow.c(r14, r15, this) != r0) goto L21;
            return r0;
        }
    }

    public GetPhoneNumFlow$getPhoneNumberFlow$3(j r1, GetPhoneNumFlow r10, String r11, Continuation<? super GetPhoneNumFlow$getPhoneNumberFlow$3> r12) {
        this.$loginContext = r1;
        this.this$0 = r10;
        this.$appletId = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        GetPhoneNumFlow$getPhoneNumberFlow$3 r0 = new GetPhoneNumFlow$getPhoneNumberFlow$3(this.$loginContext, this.this$0, this.$appletId, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Job> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        return BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$loginContext, this.this$0, this.$appletId, null), 3, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
