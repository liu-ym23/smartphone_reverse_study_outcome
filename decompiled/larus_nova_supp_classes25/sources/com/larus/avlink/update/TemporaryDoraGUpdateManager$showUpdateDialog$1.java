package com.larus.avlink.update;

import android.app.Activity;
import com.bytedance.keva.Keva;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import lq9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.update.TemporaryDoraGUpdateManager$showUpdateDialog$1", f = "TemporaryDoraGUpdateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemporaryDoraGUpdateManager$showUpdateDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $source;
    int label;

    public TemporaryDoraGUpdateManager$showUpdateDialog$1(int r1, Continuation<? super TemporaryDoraGUpdateManager$showUpdateDialog$1> r2) {
        this.$source = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TemporaryDoraGUpdateManager$showUpdateDialog$1(this.$source, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_avlink_update_TemporaryDoraGUpdateManager$showUpdateDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(c r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.avlink.update.e] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.avlink.update.f] */
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r7);
        if (h.c == false) goto L8;
        n1.d("TemporaryDoraGUpdateManager", "no show dialog due to isDialogShowing");
        return Unit.INSTANCE;
    L8:
        Activity r8 = AppHost.a.a().getCurrentActivity();
        Boolean r1 = null;
        String r2 = null;
        if (r8 != null) goto L11;
    L30:
        StringBuilder r3 = new StringBuilder("no show dialog due to activity is ");
        r3.append(r8);
        r3.append(">>>> ");
        if (r8 == null) goto L33;
        r1 = Boxing.boxBoolean(r8.isFinishing());
    L33:
        r3.append(r1);
        r3.append(", ");
        n1.d("TemporaryDoraGUpdateManager", r3.toString());
        return Unit.INSTANCE;
    L11:
        if (r8.isFinishing() == true) goto L30;
        h r4 = h.a;
        t r5 = h.c().b;
        if (r5 == null) goto L16;
        String r6 = r5.a;
    L17:
        t r9 = h.c().b;
        if (r9 == null) goto L20;
        String r10 = r9.b;
    L21:
        t r11 = h.c().b;
        if (r11 == null) goto L24;
        String r12 = r11.d;
    L25:
        t r13 = h.c().b;
        if (r13 == null) goto L28;
        r2 = r13.c;
    L28:
        i r0 = new i(r6, r10, r12, r2);
        final int r14 = this.$source;
        c r15 = new c(r8, r0, new e(r14), new f(r14));
        r15.setOnDismissListener(new g());
        new WeakReference(r15);
        h.c = true;
        Keva r16 = DoraConfig.a;
        DoraConfig.a.storeLong("key_g_update_cancel_time", System.currentTimeMillis());
        INVOKEVIRTUAL_com_larus_avlink_update_TemporaryDoraGUpdateManager$showUpdateDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r15);
        return Unit.INSTANCE;
    L24:
        r12 = null;
        goto L25
    L20:
        r10 = null;
        goto L21
    L16:
        r6 = null;
        goto L17
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
