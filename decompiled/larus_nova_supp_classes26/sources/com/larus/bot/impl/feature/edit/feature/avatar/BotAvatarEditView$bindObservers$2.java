package com.larus.bot.impl.feature.edit.feature.avatar;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarGenActionSheet;
import com.larus.platform.spi.IAIChatService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/avatar/AvatarUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditView$bindObservers$2", f = "BotAvatarEditView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotAvatarEditView$bindObservers$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotAvatarEditView this$0;

    public BotAvatarEditView$bindObservers$2(BotAvatarEditView r1, Continuation<? super BotAvatarEditView$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotAvatarEditView$bindObservers$2 r0 = new BotAvatarEditView$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r25);
        b r0 = (b) this.L$0;
        if ((r0 instanceof b.a) == false) goto L24;
        final BotAvatarEditView r2 = this.this$0;
        b.a r1 = (b.a) r0;
        String r5 = r1.a;
        final String r3 = r1.b;
        FragmentActivity r4 = r2.a.getActivity();
        if (r4 == null) goto L52;
        Dialog r6 = IAIChatService.a.x7(r4, r5, false, null, new l(r2), new m(r2, r3));
        r2.h = r6;
        if (r6 == null) goto L11;
        r6.setOnCancelListener(new n(r2));
    L11:
        Dialog r7 = r2.h;
        if (r7 != null) goto L14;
    L18:
        dv8.b r8 = r2.d;
        if (r8 == null) goto L52;
        if (r8.d() == null) goto L52;
        tx9.n.e(r2.d.d(), "click_head_preview", r2.d.c(), null, 24);
        tx9.n.g(r2.d.d(), "click_head_preview", r2.d.c(), null, 24);
        goto L52
    L14:
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(r7);
        goto L18
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L17:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    L52:
        return Unit.INSTANCE;
    L24:
        if ((r0 instanceof b.d) == false) goto L27;
        BotAvatarEditView r9 = this.this$0;
        String r10 = ((b.d) r0).a.toString(r9.a.getContext());
        t19.s r11 = t19.s.a;
        Context r12 = r9.a.getContext();
        r11.getClass();
        t19.s.c(r12, r10);
        goto L52
    L27:
        if ((r0 instanceof b.c) == false) goto L45;
        final BotAvatarEditView r13 = this.this$0;
        b.c r14 = (b.c) r0;
        String r15 = r14.a;
        final String r16 = r14.b;
        int r17 = BotAvatarEditView.n;
        r13.getClass();
        qu8.b.e("bot_create/avatar_setting", "bot_create", false);
        r13.l = r16;
        AvatarGenActionSheet r18 = r13.g;
        if (r18 != null) goto L63;
    L36:
        AvatarGenActionSheet r19 = new AvatarGenActionSheet();
        AvatarGenActionSheet.U90(r19, false, new BotAvatarIconData(null, null, null, null, r15, 15, null), null, null, null, null, null, null, null, r16, false, new p(r13, r16), new q(r13), 38909);
        FragmentManager r20 = r13.a.getParentFragmentManager();
        LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, "AvatarGenActionSheet", r21);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r19, r21) == false) goto L59;
    L41:
        r13.g = r19;
        FLogger.a.i("BotAvatarEditView", "showAvatarActionSheet, actionSheet isShowing = " + r19.isVisible());
        dv8.b r22 = r13.d;
        if (r22 == null) goto L52;
        tx9.n.g(r22.d(), r16, r22.c(), r13.a, 8);
        goto L52
    L59:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L58
    L40:
        r19.show(r20, "AvatarGenActionSheet");
        goto L41
    L63:
        r18.dismissAllowingStateLoss();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r23 = DialogFragmentLancet.sLastShowStack;
        if (r23 == null) goto L36;
        com.bytedance.crash.d.d(r23, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L36
    L45:
        if ((r0 instanceof b.C0056b) == false) goto L54;
        BotAvatarEditView r24 = this.this$0;
        int r26 = BotAvatarEditView.n;
        ev8.b.a(r24.a.getActivity(), new o(r24));
        dv8.b r27 = this.this$0.d;
        if (r27 == null) goto L52;
        if (r27.d() == null) goto L52;
        BotAvatarEditView r28 = this.this$0;
        tx9.n.d(r28.d.d(), r28.d.c(), ((b.C0056b) r0).a);
        goto L52
    L54:
        throw new NoWhenBranchMatchedException();
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
