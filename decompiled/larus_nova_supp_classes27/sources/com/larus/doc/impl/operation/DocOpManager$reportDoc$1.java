package com.larus.doc.impl.operation;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.ReportReason;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$reportDoc$1", f = "DocOpManager.kt", i = {0, 1, 1, 1}, l = {750, 762}, m = "invokeSuspend", n = {"reportReasons", "reportReasons", "loading", "loadingAsync"}, s = {"L$0", "L$0", "L$1", "L$2"})
public final class DocOpManager$reportDoc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ String $resourceId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public static final class a implements com.larus.bmhome.tipoff.a {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        public final void a(boolean r5) {
            FLogger r0 = FLogger.a;
            r0.i("DocOpManager", "handleReport, onTipOffSubmitClick, success=" + r5);
            if (r5 == false) goto L14;
            Context r6 = this.a;
            View r3 = null;
            if ((r6 instanceof Activity) == false) goto L7;
            Activity r7 = (Activity) r6;
        L8:
            if (r7 == null) goto L10;
            r3 = r7.getCurrentFocus();
        L10:
            r0.i("DocOpManager", "handleReport, currentFocus: " + r3);
            KeyBoardUtils.hideKeyboard(this.a);
            if (r3 == null) goto L15;
            r3.clearFocus();
            return;
        L15:
            return;
        L7:
            r7 = null;
            goto L8
        }
    }

    public DocOpManager$reportDoc$1(Context r1, String r2, FragmentManager r3, Continuation<? super DocOpManager$reportDoc$1> r4) {
        this.$context = r1;
        this.$resourceId = r2;
        this.$fragmentManager = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DocOpManager$reportDoc$1 r0 = new DocOpManager$reportDoc$1(this.$context, this.$resourceId, this.$fragmentManager, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$reportDoc$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object invokeSuspend(Object r32) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = false;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Deferred r1 = (Deferred) this.L$2;
        l0 r4 = (l0) this.L$1;
        Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r32);
        Ref.ObjectRef r14 = r5;
        Object r6 = r32;
    L27:
        com.larus.bmhome.tipoff.b r7 = (com.larus.bmhome.tipoff.b) r6;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
        INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$reportDoc$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r4);
        FLogger.a.d("DocOpManager", "handleReport, loadingAsync await");
        if (r7 == null) goto L32;
        List r8 = r7.a();
        if (r8 == null) goto L32;
        List r9 = CollectionsKt.filterNotNull(r8);
    L33:
        r14.element = r9;
    L34:
        Collection r10 = (Collection) r14.element;
        if (r10 != null) goto L37;
    L38:
        r3 = true;
    L39:
        if (r3 == false) goto L41;
        FLogger.a.i("DocOpManager", "handleReport, reportReasons is null or empty");
        s r11 = s.a;
        Context r12 = this.$context;
        r11.getClass();
        s.s(r12, 2131908080);
    L62:
        return Unit.INSTANCE;
    L41:
        FLogger r13 = FLogger.a;
        StringBuilder r15 = new StringBuilder("handleReport, reportReasons size=");
        List r16 = (List) r14.element;
        if (r16 == null) goto L44;
        Integer r17 = Boxing.boxInt(r16.size());
    L45:
        r15.append(r17);
        r13.i("DocOpManager", r15.toString());
        String r18 = this.$resourceId;
        FragmentManager r20 = this.$fragmentManager;
        Context r21 = this.$context;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L55
        IAIChatService.Companion r23 = IAIChatService.a;     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r18, "entityId");     // Catch: Throwable -> L55
        TipOffDialogParams r24 = new TipOffDialogParams(24, r18, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L55
        List r25 = (List) r14.element;     // Catch: Throwable -> L55
        if (r25 == null) goto L52;
        List r26 = r25;     // Catch: Throwable -> L55
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));     // Catch: Throwable -> L55
        Iterator r28 = r26.iterator();     // Catch: Throwable -> L55
    L50:
        if (r28.hasNext() == false) goto L53;
        ReportReason r30 = (ReportReason) r28.next();     // Catch: Throwable -> L55
        r27.add(new com.larus.bmhome.auth.ReportReason(r30.b(), r30.a()));     // Catch: Throwable -> L55
    L53:
        r24.n = r27;     // Catch: Throwable -> L55
        BaseTipOffDialog r31 = r23.g8(r24);     // Catch: Throwable -> L55
        r31.S90(new a(r21));     // Catch: Throwable -> L55
        INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$reportDoc$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r31, r20, null);     // Catch: Throwable -> L55
        Object r33 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L60;
        FLogger.a.e("DocOpManager", "handleReport, createTipOffDialog failed, e=" + r34, r34);
    L60:
        Result.box-impl(r33);
        goto L62
    L52:
        r27 = null;
    L55:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
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
        Ref.ObjectRef r36 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r37 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r32);
        r14 = r37;
        Object r38 = r32;
    L16:
        com.larus.bmhome.tipoff.b r40 = (com.larus.bmhome.tipoff.b) r38;
        if (r40 == null) goto L21;
        List r41 = r40.a();
        if (r41 == null) goto L21;
        List r42 = CollectionsKt.filterNotNull(r41);
    L22:
        r36.element = r42;
    L21:
        r42 = null;
        goto L22
    L10:
        ResultKt.throwOnFailure(r32);
        CoroutineScope r43 = (CoroutineScope) this.L$0;
        r14 = new Ref.ObjectRef();
        Deferred r110 = BuildersKt.async$default(r43, null, null, new DocOpManager$reportDoc$1$reportReasonAsync$1(null), 3, null);
        if (r110.isCompleted() == false) goto L23;
        FLogger.a.d("DocOpManager", "handleReport, reportReasonAsync isCompleted");
        this.L$0 = r14;
        this.L$1 = r14;
        this.label = 1;
        r38 = r110.await(this);
        if (r38 != r0) goto L15;
        return r0;
    L15:
        r36 = r14;
        goto L16
    L23:
        l0 r111 = new l0(this.$context, 0.0f, false, 6);
        r111.setCancelable(true);
        r4 = r111;
        Deferred r44 = BuildersKt.async$default(r43, null, null, new DocOpManager$reportDoc$1$loadingAsync$1(r110, r111, null), 3, null);
        this.L$0 = r14;
        this.L$1 = r4;
        this.L$2 = r44;
        this.label = 2;
        r6 = r110.await(this);
        if (r6 != r0) goto L26;
        return r0;
    L26:
        r1 = r44;
        goto L27
    }

    public static void INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$reportDoc$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BaseTipOffDialog r2, FragmentManager r3, String r4) {
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
