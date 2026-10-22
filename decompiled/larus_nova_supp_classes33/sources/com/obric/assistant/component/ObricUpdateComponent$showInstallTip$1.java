package com.obric.assistant.component;

import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$showInstallTip$1", f = "ObricUpdateComponent.kt", i = {}, l = {282, 293}, m = "invokeSuspend", n = {}, s = {})
final class ObricUpdateComponent$showInstallTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public ObricUpdateComponent$showInstallTip$1(ObricUpdateComponent r1, Continuation<? super ObricUpdateComponent$showInstallTip$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricUpdateComponent$showInstallTip$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_component_ObricUpdateComponent$showInstallTip$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.obric.oui.dialog.v2.alert.c r1) {
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

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L49
    L36:
        if (((Boolean) r9).booleanValue() == false) goto L39;
        FLogger.a.i("ObricUpdateComponent", "showInstallTip return, blocked by configInterval");     // Catch: Exception -> L49
        return Unit.INSTANCE;
    L39:
        ObricUpdateComponent r10 = this.this$0;     // Catch: Exception -> L49
        com.obric.oui.dialog.v2.alert.g r2 = new com.obric.oui.dialog.v2.alert.g(r10.getContext());     // Catch: Exception -> L49
        r2.w = false;     // Catch: Exception -> L49
        Drawable r3 = AppCompatResources.getDrawable(r2.g, 2131244432);     // Catch: Exception -> L49
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r3, "drawable");     // Catch: Exception -> L49
        r2.k = r3;     // Catch: Exception -> L49
        String r5 = this.this$0.getContext().getString(2131912666);     // Catch: Exception -> L49
        r2.j = false;     // Catch: Exception -> L49
        r2.h = r5;     // Catch: Exception -> L49
        r2.i = this.this$0.getContext().getString(2131912665);     // Catch: Exception -> L49
        com.obric.oui.dialog.v2.alert.g.c(r2);     // Catch: Exception -> L49
        String r6 = this.this$0.getContext().getString(2131912663);     // Catch: Exception -> L49
        final ObricUpdateComponent r7 = this.this$0;     // Catch: Exception -> L49
        r2.e(r6, new w4(r7));     // Catch: Exception -> L49
        String r8 = this.this$0.getContext().getString(2131912664);     // Catch: Exception -> L49
        final ObricUpdateComponent r11 = this.this$0;     // Catch: Exception -> L49
        r2.h(r8, new x4(r11));     // Catch: Exception -> L49
        r10.E = r2.a();     // Catch: Exception -> L49
        com.obric.oui.dialog.v2.alert.c r12 = this.this$0.E;     // Catch: Exception -> L49
        if (r12 == null) goto L42;
        INVOKEVIRTUAL_com_obric_assistant_component_ObricUpdateComponent$showInstallTip$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r12);     // Catch: Exception -> L49
    L42:
        this.this$0.D = true;     // Catch: Exception -> L49
        IObricUpdateService r13 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L49
        if (r13 == null) goto L45;
        r4 = r13.m();     // Catch: Exception -> L49
    L45:
        IObricUpdateService r14 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L49
        if (r14 == null) goto L52;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L49
        r15.put("source", r4);     // Catch: Exception -> L49
        r15.put("popup_type", "obric_upgrade_install_dialog");     // Catch: Exception -> L49
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L49
        r14.h("obric_upgrade_popup_show", r15);     // Catch: Exception -> L49
    L52:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L49
    L17:
        if (this.this$0.D == false) goto L20;
        FLogger.a.i("ObricUpdateComponent", "showInstallTip return, is showing");     // Catch: Exception -> L49
        return Unit.INSTANCE;
    L20:
        IObricUpdateService r17 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L49
        if (r17 == null) goto L23;
        Integer r18 = Boxing.boxInt(r17.l());     // Catch: Exception -> L49
    L24:
        if (r18 == null) goto L52;
        if (r18.intValue() != 4) goto L52;
        if (this.this$0.E != null) goto L31;
        CoroutineDispatcher r19 = Dispatchers.getIO();     // Catch: Exception -> L49
        ObricUpdateComponent$showInstallTip$1$blocked$1 r20 = new ObricUpdateComponent$showInstallTip$1$blocked$1(this.this$0, null);     // Catch: Exception -> L49
        this.label = 2;     // Catch: Exception -> L49
        r9 = BuildersKt.withContext(r19, r20, this);     // Catch: Exception -> L49
        if (r9 != r0) goto L36;
        return r0;
    L31:
        return Unit.INSTANCE;
    L23:
        r18 = null;
        goto L24
    L12:
        ResultKt.throwOnFailure(r9);
        this.label = 1;     // Catch: Exception -> L49
        if (DelayKt.delay(1000, this) != r0) goto L17;
        return r0;
    L49:
        e = move-exception;
        FLogger.a.i("ObricUpdateComponent", "showInstallTip, " + e);
        goto L52
    }
}
