package com.larus.share.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.ReportReason;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.tipoff.b;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.AppletSharePanelServiceImpl$handleReport$1", f = "AppletSharePanelServiceImpl.kt", i = {0, 1, 1, 1}, l = {107, 120}, m = "invokeSuspend", n = {"reportReasons", "reportReasons", "loading", "loadingAsync"}, s = {"L$0", "L$0", "L$1", "L$2"})
final class AppletSharePanelServiceImpl$handleReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ String $resourceId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AppletSharePanelServiceImpl$handleReport$1(FragmentActivity r1, String r2, Continuation<? super AppletSharePanelServiceImpl$handleReport$1> r3) {
        this.$activity = r1;
        this.$resourceId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AppletSharePanelServiceImpl$handleReport$1 r0 = new AppletSharePanelServiceImpl$handleReport$1(this.$activity, this.$resourceId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_share_impl_AppletSharePanelServiceImpl$handleReport$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object invokeSuspend(Object r33) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = false;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Deferred r1 = (Deferred) this.L$2;
        l0 r4 = (l0) this.L$1;
        Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r33);
        Ref.ObjectRef r15 = r5;
        Object r6 = r33;
    L27:
        b r7 = (b) r6;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
        INVOKEVIRTUAL_com_larus_share_impl_AppletSharePanelServiceImpl$handleReport$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r4);
        FLogger.a.d("flow.showSharePanel", "handleReport, loadingAsync await");
        if (r7 == null) goto L32;
        List r8 = r7.a();
        if (r8 == null) goto L32;
        List r9 = CollectionsKt.filterNotNull(r8);
    L33:
        r15.element = r9;
    L34:
        Collection r10 = (Collection) r15.element;
        if (r10 != null) goto L37;
    L38:
        r3 = true;
    L39:
        if (r3 == false) goto L41;
        FLogger.a.i("flow.showSharePanel", "handleReport, reportReasons is null or empty");
        s r11 = s.a;
        FragmentActivity r12 = this.$activity;
        r11.getClass();
        s.s(r12, 2131908080);
    L62:
        return Unit.INSTANCE;
    L41:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("handleReport, reportReasons size=");
        List r16 = (List) r15.element;
        if (r16 == null) goto L44;
        Integer r17 = Boxing.boxInt(r16.size());
    L45:
        r14.append(r17);
        r13.i("flow.showSharePanel", r14.toString());
        String r18 = this.$resourceId;
        FragmentActivity r19 = this.$activity;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L55
        IAIChatService.Companion r21 = IAIChatService.a;     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r18, "entityId");     // Catch: Throwable -> L55
        TipOffDialogParams r22 = new TipOffDialogParams(17, r18, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L55
        List r23 = (List) r15.element;     // Catch: Throwable -> L55
        if (r23 == null) goto L52;
        List r24 = r23;     // Catch: Throwable -> L55
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));     // Catch: Throwable -> L55
        Iterator r26 = r24.iterator();     // Catch: Throwable -> L55
    L50:
        if (r26.hasNext() == false) goto L53;
        ReportReason r27 = (ReportReason) r26.next();     // Catch: Throwable -> L55
        r25.add(new com.larus.bmhome.auth.ReportReason(r27.b(), r27.a()));     // Catch: Throwable -> L55
    L53:
        r22.n = r25;     // Catch: Throwable -> L55
        INVOKEVIRTUAL_com_larus_share_impl_AppletSharePanelServiceImpl$handleReport$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r21.g8(r22), r19.getSupportFragmentManager(), null);     // Catch: Throwable -> L55
        Object r28 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L60;
        FLogger.a.e("flow.showSharePanel", "handleReport, createTipOffDialog failed, e=" + r29, r29);
    L60:
        Result.box-impl(r28);
        goto L62
    L52:
        r25 = null;
    L55:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L44:
        r17 = null;
        goto L45
    L37:
        if (r10.isEmpty() == false) goto L39;
    L32:
        r9 = null;
        goto L33
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.ObjectRef r31 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r32 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r33);
        r15 = r32;
        Object r34 = r33;
    L16:
        b r35 = (b) r34;
        if (r35 == null) goto L21;
        List r36 = r35.a();
        if (r36 == null) goto L21;
        List r37 = CollectionsKt.filterNotNull(r36);
    L22:
        r31.element = r37;
    L21:
        r37 = null;
        goto L22
    L10:
        ResultKt.throwOnFailure(r33);
        CoroutineScope r38 = (CoroutineScope) this.L$0;
        Deferred r110 = BuildersKt.async$default(r38, null, null, new AppletSharePanelServiceImpl$handleReport$1$reportReasonAsync$1(null), 3, null);
        r15 = new Ref.ObjectRef();
        if (r110.isCompleted() == false) goto L23;
        FLogger.a.d("flow.showSharePanel", "handleReport, reportReasonAsync isCompleted");
        this.L$0 = r15;
        this.L$1 = r15;
        this.label = 1;
        r34 = r110.await(this);
        if (r34 != r0) goto L15;
        return r0;
    L15:
        r31 = r15;
        goto L16
    L23:
        FLogger.a.d("flow.showSharePanel", "handleReport, reportReasonAsync not completed");
        l0 r111 = new l0(this.$activity, 0.0f, false, 6);
        r111.setCancelable(true);
        r4 = r111;
        Deferred r39 = BuildersKt.async$default(r38, null, null, new AppletSharePanelServiceImpl$handleReport$1$loadingAsync$1(r110, r111, null), 3, null);
        this.L$0 = r15;
        this.L$1 = r4;
        this.L$2 = r39;
        this.label = 2;
        r6 = r110.await(this);
        if (r6 != r0) goto L26;
        return r0;
    L26:
        r1 = r39;
        goto L27
    }

    public static void INVOKEVIRTUAL_com_larus_share_impl_AppletSharePanelServiceImpl$handleReport$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BaseTipOffDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BaseTipOffDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
