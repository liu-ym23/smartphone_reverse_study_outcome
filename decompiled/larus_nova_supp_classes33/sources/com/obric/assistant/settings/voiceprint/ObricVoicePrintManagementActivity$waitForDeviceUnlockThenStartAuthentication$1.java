package com.obric.assistant.settings.voiceprint;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1", f = "ObricVoicePrintManagementActivity.kt", i = {}, l = {368, 379}, m = "invokeSuspend", n = {}, s = {})
public final class ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricVoicePrintManagementActivity this$0;

    /* JADX INFO: renamed from: com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1$1", f = "ObricVoicePrintManagementActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricVoicePrintManagementActivity this$0;

        public AnonymousClass1(ObricVoicePrintManagementActivity r1, Continuation<? super AnonymousClass1> r2) {
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
            ObricVoicePrintManagementActivity r4 = this.this$0;
            r4.l = null;
            if (r4.n == false) goto L7;
            r4.i = false;
            r4.X1();
        L9:
            return Unit.INSTANCE;
        L7:
            FLogger.a.i("[ObricVoicePrintManagementActivity]", "waitForDeviceUnlockThenStartAuthentication: activity stopped before retry, defer to onResume");
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1(ObricVoicePrintManagementActivity r1, Continuation<? super ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L27:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
    L12:
        if (this.this$0.isFinishing() == true) goto L31;
        if (this.this$0.isDestroyed() == true) goto L31;
        ObricVoicePrintManagementActivity r2 = this.this$0;
        if (r2.n == false) goto L31;
        if (r2.i == false) goto L31;
        if (r2.h == ObricVoicePrintManagementActivity.AuthState.PASSED) goto L31;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L23;
        this.label = 2;
        if (DelayKt.delay(200, this) != r0) goto L12;
        return r0;
    L23:
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "waitForDeviceUnlockThenStartAuthentication: device unlocked, retry authentication");
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L27;
        return r0;
    L31:
        this.this$0.l = null;
        return Unit.INSTANCE;
    }
}
