package com.larus.bmhome.miniartifact.product;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.miniartifact.product.network.PreloadMiniArtifactShareHelper;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.mainbot.api.miniartifact.MiniArtifactProductParams;
import com.larus.network.bean.BizResponse;
import com.larus.security.api.ReportDialogHelper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.miniartifact.product.MiniArtifactProductComponent$performShare$1$onInterceptClick$1", f = "MiniArtifactProductComponent.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, s = {})
public final class MiniArtifactProductComponent$performShare$1$onInterceptClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MiniArtifactProductParams $miniArtifactProductParams;
    final /* synthetic */ jr9.a $shareItemConfig;
    int label;
    final /* synthetic */ MiniArtifactProductComponent this$0;

    public MiniArtifactProductComponent$performShare$1$onInterceptClick$1(MiniArtifactProductComponent r1, MiniArtifactProductParams r2, jr9.a r3, Context r4, Continuation<? super MiniArtifactProductComponent$performShare$1$onInterceptClick$1> r5) {
        this.this$0 = r1;
        this.$miniArtifactProductParams = r2;
        this.$shareItemConfig = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MiniArtifactProductComponent$performShare$1$onInterceptClick$1(this.this$0, this.$miniArtifactProductParams, this.$shareItemConfig, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(DialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public final Object invokeSuspend(Object r39) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r39);
        Object r3 = r39;
    L14:
        BizResponse r4 = (BizResponse) r3;
        if (r4.isSuccess() == false) goto L69;
        com.larus.bmhome.miniartifact.product.network.a r5 = (com.larus.bmhome.miniartifact.product.network.a) r4.getData();
        String r6 = null;
        if (r5 == null) goto L19;
        String r7 = r5.c();
    L21:
        if (o0.d(r7) == false) goto L69;
        if (Intrinsics.areEqual(this.$shareItemConfig.b(), "report") == false) goto L32;
        DialogFragment r8 = this.this$0.q;
        if (r8 == null) goto L27;
        INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(r8);
    L27:
        ReportDialogHelper r9 = ReportDialogHelper.a;
        FragmentActivity r10 = s1a.a.getActivity(this.this$0);
        List r11 = CollectionsKt.emptyList();
        com.larus.bmhome.miniartifact.product.network.a r12 = (com.larus.bmhome.miniartifact.product.network.a) r4.getData();
        if (r12 == null) goto L30;
        r6 = r12.c();
    L30:
        final MiniArtifactProductParams r13 = this.$miniArtifactProductParams;
        final MiniArtifactProductComponent r14 = this.this$0;
        ReportDialogHelper.d(r9, r10, r11, r6, null, new m(r13, r14), 8);
        return Unit.INSTANCE;
    L32:
        FLogger.a.i("MiniArtifactProductPage", "[biz_mini_artifact] performShare -> " + r4 + ".data?.shareUrl ");
        ShareServiceDelegate r15 = ShareServiceDelegate.b;
        Context r16 = this.$context;
        String r17 = this.$shareItemConfig.b();
        String r18 = this.$shareItemConfig.c();
        com.larus.bmhome.miniartifact.product.network.a r19 = (com.larus.bmhome.miniartifact.product.network.a) r4.getData();
        if (r19 == null) goto L35;
        String r110 = r19.c();
    L36:
        com.larus.bmhome.miniartifact.product.network.a r20 = (com.larus.bmhome.miniartifact.product.network.a) r4.getData();
        if (r20 == null) goto L39;
        String r21 = r20.b();
    L41:
        if (o0.d(r21) == true) goto L44;
        r21 = null;
    L44:
        if (r21 != null) goto L46;
        r21 = r15.p(s1a.a.c(this.this$0).getContext(), null);
    L46:
        String r111 = r21;
        com.larus.bmhome.miniartifact.product.network.a r22 = (com.larus.bmhome.miniartifact.product.network.a) r4.getData();
        if (r22 == null) goto L49;
        String r23 = r22.a();
    L51:
        if (o0.d(r23) == true) goto L54;
        r23 = null;
    L54:
        if (r23 != null) goto L59;
        Context r24 = this.$context;
        if (r24 == null) goto L58;
        r23 = r24.getString(2131909359);
        goto L59
    L58:
        String r112 = null;
    L60:
        com.larus.bmhome.miniartifact.product.network.a r25 = (com.larus.bmhome.miniartifact.product.network.a) r4.getData();
        if (r25 == null) goto L63;
        String r26 = r25.d();
    L65:
        if (o0.d(r26) == false) goto L67;
        String r113 = r26;
    L68:
        IShareService$a.d(r15, r16, r17, r18, new com.larus.bmhome.share.panel.b(null, null, r110, r113, null, null, null, r111, r112, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108467), null, 48);
    L70:
        INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss((l0) this.this$0.p.getValue());
        DialogFragment r27 = this.this$0.q;
        if (r27 == null) goto L74;
        INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r27);
    L74:
        return Unit.INSTANCE;
    L67:
        r113 = null;
        goto L68
    L63:
        r26 = null;
    L59:
        r112 = r23;
        goto L60
    L49:
        r23 = null;
        goto L51
    L39:
        r21 = null;
        goto L41
    L35:
        r110 = null;
        goto L36
    L19:
        r7 = null;
    L69:
        s.a.g(this.$context, 2131900870, false);
        goto L70
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r39);
        MiniArtifactProductComponent r28 = this.this$0;
        int r29 = MiniArtifactProductComponent.C;
        PreloadMiniArtifactShareHelper r30 = (PreloadMiniArtifactShareHelper) r28.o.getValue();
        String r31 = this.$miniArtifactProductParams.getMiniArtifactId();
        if (r31 != null) goto L11;
        r31 = "";
    L11:
        com.larus.bmhome.miniartifact.product.network.b r32 = new com.larus.bmhome.miniartifact.product.network.b(r31);
        this.label = 1;
        r3 = r30.b(r32, this);
        if (r3 != r1) goto L14;
        return r1;
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_miniartifact_product_MiniArtifactProductComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BaseTipOffDialog r2, FragmentManager r3, String r4) {
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
