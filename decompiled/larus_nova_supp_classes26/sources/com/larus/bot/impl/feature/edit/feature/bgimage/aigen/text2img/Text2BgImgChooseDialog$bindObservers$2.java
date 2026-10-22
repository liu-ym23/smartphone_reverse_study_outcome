package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusDialogBotEditBgImageChooseBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewActivity;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
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
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.Text2BgImgChooseDialog$bindObservers$2", f = "Text2BgImgChooseDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Text2BgImgChooseDialog$bindObservers$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Text2BgImgChooseDialog this$0;

    public Text2BgImgChooseDialog$bindObservers$2(Text2BgImgChooseDialog r1, Continuation<? super Text2BgImgChooseDialog$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Text2BgImgChooseDialog$bindObservers$2 r0 = new Text2BgImgChooseDialog$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_text2img_Text2BgImgChooseDialog$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(Text2BgImgChooseDialog r1) {
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

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_text2img_Text2BgImgChooseDialog$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_text2img_Text2BgImgChooseDialog$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r26);
        b r1 = (b) this.L$0;
        if ((r1 instanceof b.d) == false) goto L12;
        LarusDialogBotEditBgImageChooseBinding r2 = this.this$0.d;
        if (r2 == null) goto L29;
        ViewPager2 r3 = r2.e;
        if (r3 == null) goto L29;
        r3.setCurrentItem(0);
    L29:
        return Unit.INSTANCE;
    L12:
        if ((r1 instanceof b.C0063b) == false) goto L18;
        Text2BgImgChooseDialog r4 = this.this$0;
        b.C0063b r5 = (b.C0063b) r1;
        BotAvatarIconData r6 = r5.a;
        BgImage r7 = r5.b;
        String r8 = r5.c;
        String r9 = r5.d;
        String r10 = r5.e;
        String r11 = r5.f;
        Boolean r12 = r5.g;
        BotModel r13 = r5.h;
        String r14 = r5.i;
        String r15 = r5.j;
        Boolean r22 = Boxing.boxBoolean(r5.k);
        int r16 = Text2BgImgChooseDialog.k;
        Context r17 = r4.getContext();
        if (r17 == null) goto L16;
        int r18 = BotEditAvatarPreviewActivity.h;
        BotEditAvatarPreviewActivity.a.a(r17, r6, r7, r8, r9, r10, r11, r12, r13, Boolean.TRUE, r14, r15, "click_create_preview", null, null, null, null, null, null, r22, null, r4);
    L16:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.getViewLifecycleOwner()), null, null, new Text2BgImgChooseDialog$openPreviewPage$2(null), 3, null);
        goto L29
    L18:
        if ((r1 instanceof b.c) == false) goto L23;
        ((b.c) r1).getClass();
        l0 r19 = (l0) this.this$0.j.getValue();
        if (r19 == null) goto L29;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_text2img_Text2BgImgChooseDialog$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r19);
        goto L29
    L23:
        if (Intrinsics.areEqual(r1, b.a.a) == false) goto L26;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_bgimage_aigen_text2img_Text2BgImgChooseDialog$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
        goto L29
    L26:
        if ((r1 instanceof b.e) == false) goto L31;
        t19.s r20 = t19.s.a;
        Context r21 = this.this$0.getContext();
        String r23 = ((b.e) r1).a.toString(this.this$0.getContext());
        r20.getClass();
        t19.s.c(r21, r23);
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
