package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectFragment$bindObservers$2", f = "BgSelectFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BgSelectFragment$bindObservers$2 extends SuspendLambda implements Function2<k, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BgSelectFragment this$0;

    public BgSelectFragment$bindObservers$2(BgSelectFragment r1, Continuation<? super BgSelectFragment$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BgSelectFragment$bindObservers$2 r0 = new BgSelectFragment$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(k r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(PictureSaveActionSheet r1) {
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

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L60;
        ResultKt.throwOnFailure(r23);
        k r1 = (k) this.L$0;
        if ((r1 instanceof k.d) == false) goto L8;
        BgSelectFragment r4 = this.this$0;
        k.d r2 = (k.d) r1;
        BotAvatarIconData r5 = r2.a;
        BgImage r6 = r2.b;
        String r7 = r2.c;
        String r8 = r2.d;
        String r9 = r2.e;
        String r10 = r2.f;
        Boolean r11 = r2.g;
        BotModel r12 = r2.h;
        String r13 = r2.i;
        String r14 = r2.j;
        String r15 = r2.k;
        String r3 = r2.l;
        int r16 = BgSelectFragment.k;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.getViewLifecycleOwner()), null, null, new BgSelectFragment$openPreviewPage$1(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, null), 3, null);
    L56:
        return Unit.INSTANCE;
    L8:
        if ((r1 instanceof k.f) == false) goto L18;
        if (((k.f) r1).a == false) goto L14;
        l0 r17 = (l0) this.this$0.i.getValue();
        if (r17 == null) goto L56;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r17);
        goto L56
    L14:
        l0 r18 = (l0) this.this$0.i.getValue();
        if (r18 == null) goto L56;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r18);
        goto L56
    L18:
        if ((r1 instanceof k.b) == false) goto L30;
        FragmentActivity r19 = this.this$0.getActivity();
        if (r19 == null) goto L26;
        Bundle r20 = ((k.b) r1).a;
        if (r20 == null) goto L24;
        Intent r21 = new Intent().putExtras(r20);
    L25:
        r19.setResult(11, r21);
        goto L26
    L24:
        r21 = null;
    L26:
        FragmentActivity r22 = this.this$0.getActivity();
        if (r22 == null) goto L56;
        r22.finish();
        goto L56
    L30:
        if ((r1 instanceof k.c) == false) goto L36;
        com.bytedance.router.i r24 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/create_bot");
        BgSelectFragment r25 = this.this$0;
        if (r25.getArguments() == null) goto L34;
        r24.g(r25.getArguments());
    L34:
        ((k.c) r1).getClass();
        r24.d = 2130772401;
        r24.e = 2130772399;
        r24.e(11);
        goto L56
    L36:
        if ((r1 instanceof k.g) == false) goto L39;
        t19.s r26 = t19.s.a;
        Context r27 = this.this$0.getContext();
        String r28 = ((k.g) r1).a.toString(this.this$0.getContext());
        r26.getClass();
        t19.s.c(r27, r28);
        goto L56
    L39:
        if ((r1 instanceof k.a) == false) goto L50;
        FragmentActivity r29 = this.this$0.getActivity();
        if (r29 == null) goto L43;
        r29.setResult(100, new Intent().putExtras(((k.a) r1).a));
    L43:
        FragmentActivity r30 = this.this$0.getActivity();
        if (r30 == null) goto L46;
        r30.finish();
    L46:
        FragmentActivity r31 = this.this$0.getActivity();
        if (r31 == null) goto L56;
        r31.overridePendingTransition(0, 2130772384);
        goto L56
    L50:
        if ((r1 instanceof k.e) == false) goto L58;
        PictureSaveActionSheet r32 = this.this$0.g;
        if (r32 == null) goto L54;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r32);
    L54:
        PictureSaveActionSheet r33 = new PictureSaveActionSheet();
        k.e r34 = (k.e) r1;
        BgSelectViewHolder.a r35 = r34.a;
        String r36 = r34.b;
        String r37 = r34.c;
        Intrinsics.checkNotNullParameter(r35, "pictureData");
        r33.i = r35;
        r33.f = r36;
        r33.g = r37;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r33, this.this$0.getParentFragmentManager(), "PictureSaveActionSheet");
        this.this$0.g = r33;
        goto L56
    L58:
        throw new NoWhenBranchMatchedException();
    L60:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_select_BgSelectFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(PictureSaveActionSheet r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        PictureSaveActionSheet r0 = r2;
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
