package com.larus.dora.obric.onboarding;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.dora.o.api.IDoraODiaryService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGEnvAuthSheet$observeAuthResult$1", f = "ObricDoraGEnvAuthSheet.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class ObricDoraGEnvAuthSheet$observeAuthResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ m this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        public static void a(OSheet r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final Object emit(Object r2, Continuation r3) {
            com.larus.dora.impl.device.settings.lab.env.auth.c r4 = (com.larus.dora.impl.device.settings.lab.env.auth.c) r2;
            m r5 = this.a;
            if (r5.f == false) goto L19;
            if ((r4 instanceof com.larus.dora.impl.device.settings.lab.env.auth.c.a) == false) goto L19;
            r5.f = false;
            StringBuilder r6 = new StringBuilder("env auth sheet result, success=");
            com.larus.dora.impl.device.settings.lab.env.auth.c.a r7 = (com.larus.dora.impl.device.settings.lab.env.auth.c.a) r4;
            r6.append(r7.a);
            g49.d.d("ObricDoraGEnvAuthSheet", r6.toString());
            if (r7.a == false) goto L16;
            IDoraODiaryService r8 = (IDoraODiaryService) ServiceManager.get().getService(IDoraODiaryService.class);
            if (r8 == null) goto L12;
            r8.a(this.a.b);
        L12:
            Function0<Unit> r9 = this.a.c;
            if (r9 == null) goto L15;
            r9.invoke();
        L15:
            this.a.h.a(ObricDoraGEnvAuthResult.AUTHORIZED);
            a(this.a.i);
        L20:
            return Unit.INSTANCE;
        L16:
            this.a.h.a(ObricDoraGEnvAuthResult.FAILED);
            t19.s r10 = t19.s.a;
            AppCompatActivity r11 = this.a.a;
            String r0 = r11.getString(2131903992);
            r10.getClass();
            t19.s.c(r11, r0);
            a(this.a.i);
        L19:
            return Unit.INSTANCE;
        }
    }

    public ObricDoraGEnvAuthSheet$observeAuthResult$1(m r1, Continuation<? super ObricDoraGEnvAuthSheet$observeAuthResult$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricDoraGEnvAuthSheet$observeAuthResult$1(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.i1<com.larus.dora.impl.device.settings.lab.env.auth.c> r6 = this.this$0.e.getEnvAuthState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
