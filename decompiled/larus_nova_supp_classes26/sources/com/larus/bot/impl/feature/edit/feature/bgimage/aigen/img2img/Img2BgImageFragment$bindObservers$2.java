package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.router.SmartRouter;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectActivity;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.yalantis.ucrop.UCropFragment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BgImageGenerateUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.Img2BgImageFragment$bindObservers$2", f = "Img2BgImageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Img2BgImageFragment$bindObservers$2 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Img2BgImageFragment this$0;

    public Img2BgImageFragment$bindObservers$2(Img2BgImageFragment r1, Continuation<? super Img2BgImageFragment$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Img2BgImageFragment$bindObservers$2 r0 = new Img2BgImageFragment$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(c r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((c) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_Img2BgImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_Img2BgImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L86;
        ResultKt.throwOnFailure(r19);
        c r0 = (c) this.L$0;
        if ((r0 instanceof c.e) == false) goto L12;
        Img2BgImageFragment r2 = this.this$0;
        c.e r1 = (c.e) r0;
        Uri r4 = r1.a;
        int r5 = Img2BgImageFragment.o;
        r2.W90(r4);
        Img2BgImageFragment r3 = this.this$0;
        Uri r6 = r1.a;
        r3.n = r6;
        if (r6 != null) goto L82;
        if (((d) r3.V90().getUiState().getValue()).a != 0) goto L82;
        FLogger.a.i("BotBgImageGenerateFragment", "refresh UI state,because state is same ,flow not work");
        Img2BgImageFragment r7 = this.this$0;
        Img2BgImageFragment.U90(r7, (d) r7.V90().getUiState().getValue());
    L82:
        return Unit.INSTANCE;
    L12:
        if ((r0 instanceof c.h) == false) goto L14;
        t19.s r8 = t19.s.a;
        Context r9 = this.this$0.getContext();
        String r10 = ((c.h) r0).a.toString(this.this$0.getContext());
        r8.getClass();
        t19.s.t(r9, r10);
        goto L82
    L14:
        Unit r11 = null;
        if (Intrinsics.areEqual(r0, c.a.a) == false) goto L30;
        Img2BgImageFragment r12 = this.this$0;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L22
        UCropFragment r14 = r12.j;     // Catch: Throwable -> L22
        if (r14 == null) goto L20;
        r14.w.setClickable(true);     // Catch: Throwable -> L22
        r14.d.vg(true);     // Catch: Throwable -> L22
        r14.l.t(r14.x, r14.y, new com.yalantis.ucrop.a(r14));     // Catch: Throwable -> L22
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Object r15 = Result.constructor-impl(r11);     // Catch: Throwable -> L22
    L24:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L28;
        FLogger.a.e("BotBgImageGenerateFragment", "error : " + r16.getMessage());
        r15 = Unit.INSTANCE;
    L28:
        Unit r17 = (Unit) r15;
    L22:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L30:
        if ((r0 instanceof c.C0059c) == false) goto L48;
        Context r20 = this.this$0.getContext();
        if (r20 == null) goto L82;
        Img2BgImageFragment r21 = this.this$0;
        int r22 = BgSelectActivity.h;
        c.C0059c r23 = (c.C0059c) r0;
        BgImageInfo r24 = r23.a;
        String r25 = r23.b;
        String r26 = r23.c;
        String r110 = r23.d;
        String r111 = r23.e;
        Boolean r112 = r23.f;
        BotModel r113 = r23.g;
        String r114 = r23.h;
        String r115 = r23.i;
        Boolean r27 = r23.j;
        String r28 = r23.k;
        String r29 = r23.l;
        Bundle r30 = r21.getArguments();
        String r116 = r23.m;
        Boolean r31 = Boxing.boxBoolean(r23.n);
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "trackNode");
        com.bytedance.router.i r32 = SmartRouter.buildRoute(r20, "//flow/bot_bg_select");
        if (r30 == null) goto L36;
        r32.g(r30);
    L36:
        Bundle r33 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("bg_image_info", r24), TuplesKt.to("bot_name", r25), TuplesKt.to("bot_description", r26), TuplesKt.to("user_bot_gender", r110), TuplesKt.to("user_bot_type", r111), TuplesKt.to("if_base_image", r27), TuplesKt.to("visual_style_status", r28), TuplesKt.to("description_status", r29), TuplesKt.to("need_update_bot_info", r112), TuplesKt.to("bot_update_bot_argument", r113)});
        by7.h.k(r33, r21);
        r32.c.putExtras(r33);
        if (r114 == null) goto L39;
        r32.j("creation_id", r114);
    L39:
        if (r115 == null) goto L41;
        r32.j("create_way", r115);
    L41:
        if (r116 == null) goto L43;
        r32.j("click_from", r116);
    L43:
        if (r31 == null) goto L45;
        r32.k("has_origin_avatar", r31.booleanValue());
    L45:
        r32.d = 2130772380;
        r32.e = 2130772399;
        r32.e(986);
        goto L82
    L48:
        if ((r0 instanceof c.b) == false) goto L59;
        FragmentActivity r34 = this.this$0.getActivity();
        if (r34 == null) goto L55;
        Bundle r35 = ((c.b) r0).a;
        if (r35 == null) goto L54;
        r11 = new Intent().putExtras(r35);
    L54:
        r34.setResult(11, r11);
    L55:
        FragmentActivity r36 = this.this$0.getActivity();
        if (r36 == null) goto L82;
        r36.finish();
        goto L82
    L59:
        if (Intrinsics.areEqual(r0, c.f.a) == false) goto L69;
        Img2BgImageFragment r37 = this.this$0;
        int r38 = Img2BgImageFragment.o;
        Context r39 = r37.getContext();
        if (r39 == null) goto L82;
        CommonDialog.a r40 = new CommonDialog.a();
        r40.i(r39.getString(2131909224));
        CommonDialog.a.f(r40, new v(r37), r39.getString(2131905462), false, 12);
        CommonDialog.a.e(r40, new w(), r39.getString(2131909223), 4);
        CommonDialog r41 = r40.c();
        FragmentManager r42 = r37.getChildFragmentManager();
        LandscapeRestrictionOperation r43 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r41, null, r43);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r42, r41, r43) == true) goto L82;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L87
    L67:
        r41.show(r42, null);
        goto L82
    L69:
        if ((r0 instanceof c.d) == false) goto L79;
        if (((c.d) r0).a == false) goto L75;
        l0 r44 = (l0) this.this$0.m.getValue();
        if (r44 == null) goto L82;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_Img2BgImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r44);
        goto L82
    L75:
        l0 r45 = (l0) this.this$0.m.getValue();
        if (r45 == null) goto L82;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_img2img_Img2BgImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r45);
        goto L82
    L79:
        if ((r0 instanceof c.g) == false) goto L84;
        t19.s r46 = t19.s.a;
        Context r47 = this.this$0.getContext();
        String r48 = ((c.g) r0).a.toString(this.this$0.getContext());
        r46.getClass();
        t19.s.c(r47, r48);
        goto L82
    L84:
        throw new NoWhenBranchMatchedException();
    L86:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
