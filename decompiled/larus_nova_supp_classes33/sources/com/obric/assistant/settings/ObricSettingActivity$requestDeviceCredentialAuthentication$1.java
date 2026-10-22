package com.obric.assistant.settings;

import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.n4;
import com.obric.assistant.o4;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.ObricSettingActivity$requestDeviceCredentialAuthentication$1", f = "ObricSettingActivity.kt", i = {}, l = {60, 62}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSettingActivity$requestDeviceCredentialAuthentication$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $description;
    final /* synthetic */ Function0<Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSucceeded;
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ ObricSettingActivity this$0;

    public static final class a implements n4 {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ Function0<Unit> b;

        public final void onAuthenticationCancelled() {
            this.b.invoke();
        }

        public final void onAuthenticationFailed() {
            this.b.invoke();
        }

        public final void onAuthenticationNotAvailable() {
            this.b.invoke();
        }

        public final void onAuthenticationPass() {
            this.a.invoke();
        }

        public final void onAuthenticationTimeout() {
            this.b.invoke();
        }

        public a(Function0<Unit> r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ObricSettingActivity$requestDeviceCredentialAuthentication$1(ObricSettingActivity r1, Function0<Unit> r2, String r3, String r4, Function0<Unit> r5, Continuation<? super ObricSettingActivity$requestDeviceCredentialAuthentication$1> r6) {
        this.this$0 = r1;
        this.$onFailed = r2;
        this.$title = r3;
        this.$description = r4;
        this.$onSucceeded = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricSettingActivity$requestDeviceCredentialAuthentication$1(this.this$0, this.$onFailed, this.$title, this.$description, this.$onSucceeded, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L19:
        if (this.this$0.isFinishing() == false) goto L21;
    L25:
        this.$onFailed.invoke();
        return Unit.INSTANCE;
    L21:
        if (this.this$0.isDestroyed() == true) goto L25;
        SessionAuthenticationServiceDelegate.b.e(new o4(this.$title, this.$description, null, 4), new a(this.$onSucceeded, this.$onFailed));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L11:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L15;
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L11;
        return r0;
    L15:
        this.label = 2;
        if (DelayKt.delay(300, this) != r0) goto L19;
        return r0;
    }
}
