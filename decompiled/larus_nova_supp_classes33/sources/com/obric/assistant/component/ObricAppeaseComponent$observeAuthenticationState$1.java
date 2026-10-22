package com.obric.assistant.component;

import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1", f = "ObricAppeaseComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricAppeaseComponent$observeAuthenticationState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricAppeaseComponent this$0;

    /* JADX INFO: renamed from: com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1$1", f = "ObricAppeaseComponent.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricAppeaseComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricAppeaseComponent a;

            public a(ObricAppeaseComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                if (((Boolean) r1).booleanValue() == false) goto L6;
                ObricAppeaseComponent.Y2(this.a, "dismissing keyguard");
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ObricAppeaseComponent r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IKeyguardService r6 = (IKeyguardService) ServiceManager.get().getService(IKeyguardService.class);
            if (r6 == null) goto L18;
            kotlinx.coroutines.flow.i1 r7 = r6.isDismissingKeyguard();
            if (r7 == null) goto L18;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1$2", f = "ObricAppeaseComponent.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricAppeaseComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.component.ObricAppeaseComponent$observeAuthenticationState$1$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricAppeaseComponent a;

            public a(ObricAppeaseComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                if (((Boolean) r1).booleanValue() == false) goto L6;
                ObricAppeaseComponent.Y2(this.a, "biometric authenticating");
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ObricAppeaseComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ISessionAuthenticationService r6 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
            if (r6 == null) goto L18;
            kotlinx.coroutines.flow.i1 r7 = r6.l();
            if (r7 == null) goto L18;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public ObricAppeaseComponent$observeAuthenticationState$1(ObricAppeaseComponent r1, Continuation<? super ObricAppeaseComponent$observeAuthenticationState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricAppeaseComponent$observeAuthenticationState$1 r0 = new ObricAppeaseComponent$observeAuthenticationState$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        BuildersKt.launch$default(r9, null, null, new AnonymousClass1(this.this$0, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
