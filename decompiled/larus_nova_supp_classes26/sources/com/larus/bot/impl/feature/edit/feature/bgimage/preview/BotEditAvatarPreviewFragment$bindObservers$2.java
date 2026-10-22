package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusPageBotEditAvatarPreviewBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarGenActionSheet;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/PreviewUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$bindObservers$2", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotEditAvatarPreviewFragment$bindObservers$2 extends SuspendLambda implements Function2<x, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$bindObservers$2(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotEditAvatarPreviewFragment$bindObservers$2 r0 = new BotEditAvatarPreviewFragment$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(x r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((x) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_preview_BotEditAvatarPreviewFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_preview_BotEditAvatarPreviewFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    /* JADX WARN: Type inference failed for: r0v39, types: [android.view.ViewGroup, com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.BotBgImagePreviewView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L67;
        ResultKt.throwOnFailure(r26);
        x r0 = (x) this.L$0;
        if (Intrinsics.areEqual(r0, x.e.a) == false) goto L12;
        LarusPageBotEditAvatarPreviewBinding r1 = this.this$0.e;
        if (r1 == null) goto L63;
        ?? r2 = r1.e;
        if (r2 == 0) goto L63;
        int r3 = ColorProtector.parseColor("#1F1F1F");
        r2.setBackgroundColor(r3);
        r2.d.f.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r3, 0}));
        r2.d.b.setBackgroundColor(ColorProtector.parseColor("#808080"));
        r2.d.c.setBackgroundColor(ColorProtector.parseColor("#2E2E2E"));
        r2.d.d.setBackgroundColor(ColorProtector.parseColor("#4D4D4D"));
    L63:
        return Unit.INSTANCE;
    L12:
        if ((r0 instanceof x.b) == false) goto L22;
        if (((x.b) r0).a == false) goto L18;
        BotEditAvatarPreviewFragment r4 = this.this$0;
        int r5 = BotEditAvatarPreviewFragment.p;
        l0 r6 = (l0) r4.m.getValue();
        if (r6 == null) goto L63;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_preview_BotEditAvatarPreviewFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r6);
        goto L63
    L18:
        BotEditAvatarPreviewFragment r7 = this.this$0;
        int r8 = BotEditAvatarPreviewFragment.p;
        l0 r9 = (l0) r7.m.getValue();
        if (r9 == null) goto L63;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_preview_BotEditAvatarPreviewFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r9);
        goto L63
    L22:
        if ((r0 instanceof x.a) == false) goto L27;
        FragmentActivity r10 = this.this$0.getActivity();
        if (r10 == null) goto L63;
        r10.finish();
        goto L63
    L27:
        if ((r0 instanceof x.f) == false) goto L30;
        t19.s r11 = t19.s.a;
        Context r12 = this.this$0.getContext();
        String r13 = ((x.f) r0).a.toString(this.this$0.getContext());
        r11.getClass();
        t19.s.c(r12, r13);
        goto L63
    L30:
        if ((r0 instanceof x.d) == false) goto L55;
        final BotEditAvatarPreviewFragment r14 = this.this$0;
        x.d r15 = (x.d) r0;
        BotAvatarIconData r16 = r15.a;
        BgImageInfo r17 = r15.b;
        String r18 = r15.c;
        String r19 = r15.d;
        String r20 = r15.e;
        String r110 = r15.f;
        Boolean r111 = r15.g;
        BotModel r112 = r15.h;
        final String r113 = r15.i;
        AvatarGenActionSheet r21 = r14.o;
        if (r21 != null) goto L69;
    L39:
        AvatarGenActionSheet r22 = new AvatarGenActionSheet();
        r22.T90(true, r16, r17, r18, r19, r20, r110, r111, r112, r14.X90().getBotCreateTrace().c(), r14.X90().getBotCreateTrace().b(), r113, true, new g(r14, r113), null, new h());
        if (r14.getParentFragmentManager().isStateSaved() == true) goto L63;
        FragmentManager r23 = r14.getParentFragmentManager();
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r22, "AvatarGenActionSheet", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r22, r24) == false) goto L71;
    L47:
        r14.o = r22;
        FLogger.a.i("BotEditAvatarPreviewFragment", "showAvatarActionSheet, actionSheet isShowing = " + r22.isVisible());
        if (r14.X90().getBotCreateTrace().c() == null) goto L63;
        String r25 = r14.X90().getBotCreateTrace().c();
        if (r14.X90().getBotCreateTrace().d() == false) goto L52;
        String r27 = "click_head_preview";
    L53:
        tx9.n.g(r25, r27, r14.X90().getBotCreateTrace().b(), r14, 8);
        goto L63
    L52:
        r27 = "click_create_preview";
        goto L53
    L71:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L68
    L46:
        r22.show(r23, "AvatarGenActionSheet");
        goto L47
    L69:
        r21.dismissAllowingStateLoss();     // Catch: Exception -> L35
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r28 = DialogFragmentLancet.sLastShowStack;
        if (r28 == null) goto L39;
        com.bytedance.crash.d.d(r28, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L39
    L55:
        if ((r0 instanceof x.c) == false) goto L65;
        BotEditAvatarPreviewFragment r29 = this.this$0;
        x.c r30 = (x.c) r0;
        BotAvatarIconData r31 = r30.a;
        BgImage r32 = r30.b;
        String r33 = r30.c;
        String r34 = r30.d;
        String r35 = r30.e;
        String r36 = r30.f;
        Boolean r114 = r30.g;
        BotModel r115 = r30.h;
        String r116 = r30.i;
        String r117 = r30.j;
        String r118 = r30.k;
        Boolean r37 = r30.l;
        String r119 = r30.m;
        String r38 = r30.n;
        String r39 = r30.o;
        String r40 = r30.p;
        boolean r41 = r30.r;
        String r42 = r30.q;
        int r120 = BotEditAvatarPreviewFragment.p;
        FragmentActivity r121 = r29.getActivity();
        if (r121 == null) goto L59;
        r121.finish();
    L59:
        Context r122 = r29.getContext();
        if (r122 == null) goto L63;
        int r210 = BotEditAvatarPreviewActivity.h;
        BotEditAvatarPreviewActivity.a.a(r122, r31, r32, r33, r34, r35, r36, r114, r115, Boolean.FALSE, r116, r117, r118, r37, r119, r38, r39, null, r40, Boolean.valueOf(r41), r42, r29);
        goto L63
    L65:
        throw new NoWhenBranchMatchedException();
    L67:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
