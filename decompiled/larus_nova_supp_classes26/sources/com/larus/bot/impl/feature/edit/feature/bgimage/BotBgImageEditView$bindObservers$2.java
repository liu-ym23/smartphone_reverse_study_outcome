package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.auth.BgImageAbParam;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgImageBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarGenActionSheet;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.Img2BgImageActivity;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewActivity;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/BgImageUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditView$bindObservers$2", f = "BotBgImageEditView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotBgImageEditView$bindObservers$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotBgImageEditView this$0;

    public BotBgImageEditView$bindObservers$2(BotBgImageEditView r1, Continuation<? super BotBgImageEditView$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotBgImageEditView$bindObservers$2 r0 = new BotBgImageEditView$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_BotBgImageEditView$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(AvatarGenActionSheet r1) {
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

    public final Object invokeSuspend(Object r30) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L138;
        ResultKt.throwOnFailure(r30);
        b r0 = (b) this.L$0;
        int r3 = 8;
        boolean r4 = true;
        if (Intrinsics.areEqual(r0, b.g.a) == false) goto L11;
        final BotBgImageEditView r1 = this.this$0;
        final LarusLayoutBotEditBgImageBinding r2 = r1.b;
        t19.s.j(t19.s.a, r2.a.getContext(), r2.a.getContext().getString(2131906510), null, false, 28);
        RoundFrameLayout r6 = r2.e;
        e10 r7 = e10.a;
        if ((true ^ e10.B0()) == false) goto L9;
        r3 = 0;
    L9:
        r6.setVisibility(r3);
        r2.g.setImageResource(2131243574);
        e1.d(r2.e, new d(r1, r2));
        r2.b.setEnabled(false);
    L134:
        return Unit.INSTANCE;
    L11:
        if ((r0 instanceof b.f) == false) goto L56;
        b.f r5 = (b.f) r0;
        if (r5.a == false) goto L52;
        qu8.b.e("bot_create/bg_setting", "bot_create", false);
        final BotBgImageEditView r8 = this.this$0;
        BotAvatarIconData r9 = r5.b;
        BgImageInfo r10 = r5.c;
        String r11 = r5.d;
        String r12 = r5.e;
        String r13 = r5.f;
        String r14 = r5.g;
        final String r15 = r5.h;
        r8.j = r15;
        AvatarGenActionSheet r16 = r8.f;
        if (r16 != null) goto L140;
    L22:
        AvatarGenActionSheet r17 = new AvatarGenActionSheet();
        dv8.b r18 = r8.d;
        if (r18 == null) goto L25;
        String r19 = r18.d();
    L26:
        dv8.b r20 = r8.d;
        if (r20 == null) goto L29;
        String r21 = r20.c();
    L30:
        if (r9 == null) goto L40;
        String r22 = r9.getIconUrl();
        if (r22 != null) goto L34;
    L37:
        boolean r23 = true;
    L38:
        if (r23 == true) goto L40;
        boolean r110 = true;
    L41:
        AvatarGenActionSheet.U90(r17, true, r9, r10, r11, r12, r13, r14, r19, r21, r15, r110, new m(r8, r15), new n(r8), 32768);
        if (r8.a.getParentFragmentManager().isStateSaved() == true) goto L134;
        FragmentManager r24 = r8.a.getParentFragmentManager();
        LandscapeRestrictionOperation r25 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, "AvatarGenActionSheet", r25);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r24, r17, r25) == false) goto L142;
    L49:
        r8.f = r17;
        FLogger.a.i("BotBgImageEditView", "showAvatarActionSheet, actionSheet isShowing = " + r17.isVisible());
        dv8.b r26 = r8.d;
        if (r26 == null) goto L134;
        tx9.n.g(r26.d(), r15, r26.c(), r8.a, 8);
        goto L134
    L142:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L139
    L48:
        r17.show(r24, "AvatarGenActionSheet");
        goto L49
    L34:
        if (r22.length() == 0) goto L37;
        r23 = false;
    L40:
        r110 = false;
        goto L41
    L29:
        r21 = null;
        goto L30
    L25:
        r19 = null;
        goto L26
    L140:
        r16.dismissAllowingStateLoss();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r27 = DialogFragmentLancet.sLastShowStack;
        if (r27 == null) goto L22;
        com.bytedance.crash.d.d(r27, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L22
    L52:
        AvatarGenActionSheet r28 = this.this$0.f;
        if (r28 == null) goto L134;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_BotBgImageEditView$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r28);
        goto L134
    L56:
        if ((r0 instanceof b.d) == false) goto L67;
        BotBgImageEditView r29 = this.this$0;
        b.d r31 = (b.d) r0;
        BotAvatarIconData r32 = r31.a;
        BgImage r33 = r31.b;
        String r111 = r31.c;
        String r112 = r31.d;
        String r113 = r31.e;
        String r114 = r31.f;
        String r34 = r31.g;
        String r35 = r31.h;
        Boolean r36 = r31.i;
        String r115 = r31.j;
        boolean r37 = r31.k;
        String r38 = r31.l;
        int r116 = BotBgImageEditView.q;
        r29.getClass();
        int r117 = BotEditAvatarPreviewActivity.h;
        Context r118 = r29.b.a.getContext();
        Boolean r119 = Boolean.FALSE;
        dv8.b r39 = r29.d;
        if (r39 == null) goto L60;
        String r40 = r39.d();
    L61:
        dv8.b r120 = r29.d;
        if (r120 == null) goto L64;
        String r210 = r120.c();
    L65:
        BotEditAvatarPreviewActivity.a.a(r118, r32, r33, r111, r112, r113, r114, null, null, r119, r40, r210, r34, null, null, null, r35, r36, r115, Boolean.valueOf(r37), r38, r29.a);
        goto L134
    L64:
        r210 = null;
        goto L65
    L60:
        r40 = null;
        goto L61
    L67:
        if ((r0 instanceof b.h) == false) goto L70;
        t19.s r41 = t19.s.a;
        Context r42 = this.this$0.b.a.getContext();
        String r43 = ((b.h) r0).a.toString(this.this$0.b.a.getContext());
        r41.getClass();
        t19.s.c(r42, r43);
        goto L134
    L70:
        if ((r0 instanceof b.c) == false) goto L81;
        BotBgImageEditView r44 = this.this$0;
        b.c r45 = (b.c) r0;
        String r46 = r45.a;
        String r47 = r45.b;
        int r48 = BotBgImageEditView.q;
        r44.getClass();
        int r49 = Img2BgImageActivity.h;
        Context r50 = r44.b.a.getContext();
        dv8.b r51 = r44.d;
        if (r51 == null) goto L74;
        String r121 = r51.d();
    L75:
        dv8.b r52 = r44.d;
        if (r52 == null) goto L78;
        String r122 = r52.c();
    L79:
        Img2BgImageActivity.a.a(r50, null, null, null, null, r46, r47, null, null, null, r121, r122, null, Boolean.FALSE, r44.a);
        goto L134
    L78:
        r122 = null;
        goto L79
    L74:
        r121 = null;
        goto L75
    L81:
        if (Intrinsics.areEqual(r0, b.a.a) == false) goto L86;
        AvatarGenActionSheet r53 = this.this$0.f;
        if (r53 == null) goto L134;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_BotBgImageEditView$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r53);
        goto L134
    L86:
        if ((r0 instanceof b.e) == false) goto L93;
        BotBgImageEditView r54 = this.this$0;
        int r55 = BotBgImageEditView.q;
        ev8.b.a(r54.a.getActivity(), new h(r54));
        dv8.b r56 = this.this$0.d;
        if (r56 == null) goto L134;
        if (r56.d() == null) goto L134;
        BotBgImageEditView r57 = this.this$0;
        tx9.n.d(r57.d.d(), r57.d.c(), ((b.e) r0).a);
        goto L134
    L93:
        if ((r0 instanceof b.C0064b) == false) goto L136;
        LaunchInfo r58 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r58 == null) goto L99;
        BgImageConfig r59 = r58.h();
        if (r59 == null) goto L99;
        BgImageAbParam r60 = r59.a();
    L101:
        if (z2.a.chatImmerseEnable() == false) goto L132;
        if (r60 == null) goto L104;
        boolean r61 = Intrinsics.areEqual(Boxing.boxBoolean(true), r60.b());
    L105:
        if (r61 == false) goto L132;
        if (Intrinsics.areEqual(Boxing.boxBoolean(true), r60.c()) == false) goto L131;
        BotBgImageEditView r62 = this.this$0;
        b.C0064b r63 = (b.C0064b) r0;
        Context r64 = r62.a.getContext();
        if (r64 == null) goto L134;
        int r65 = Img2BgImageActivity.h;
        BgImageInfo r66 = r63.b;
        BotAvatarIconData r67 = r63.a;
        String r68 = r63.c;
        String r123 = r63.d;
        String r124 = r63.e;
        String r125 = r63.f;
        Bundle r126 = r62.a.getArguments();
        dv8.b r69 = r62.d;
        if (r69 == null) goto L113;
        String r127 = r69.d();
    L114:
        dv8.b r70 = r62.d;
        if (r70 == null) goto L117;
        String r128 = r70.c();
    L118:
        String r71 = r63.g;
        BotAvatarIconData r72 = r63.a;
        if (r72 == null) goto L129;
        String r73 = r72.getIconUrl();
        if (r73 != null) goto L123;
    L126:
        boolean r74 = true;
    L127:
        if (r74 == true) goto L129;
    L130:
        Img2BgImageActivity.a.a(r64, r66, r67, r68, r123, r124, r125, null, null, r126, r127, r128, r71, Boolean.valueOf(r4), r62.a);
        goto L134
    L123:
        if (r73.length() == 0) goto L126;
        r74 = false;
    L129:
        r4 = false;
        goto L130
    L117:
        r128 = null;
        goto L118
    L113:
        r127 = null;
        goto L114
    L131:
        BotBgImageEditView.b(this.this$0, true, (b.C0064b) r0);
        goto L134
    L104:
        r61 = false;
    L132:
        BotBgImageEditView.b(this.this$0, false, (b.C0064b) r0);
    L99:
        r60 = null;
        goto L101
    L136:
        throw new NoWhenBranchMatchedException();
    L138:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
