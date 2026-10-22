package com.larus.slides.impl.select;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.ChatParam;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.office.base.utils.SlidesFileUtils;
import com.larus.permission.api.IPermissionX;
import com.larus.slides.impl.select.utils.ImageSaveUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/slides/impl/select/GenerateImageUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageFragment$bindObservers$2", f = "GenerateImageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GenerateImageFragment$bindObservers$2 extends SuspendLambda implements Function2<o, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GenerateImageFragment this$0;

    public GenerateImageFragment$bindObservers$2(GenerateImageFragment r1, Continuation<? super GenerateImageFragment$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        GenerateImageFragment$bindObservers$2 r0 = new GenerateImageFragment$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(o r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((o) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(PictureSaveActionSheet r1) {
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

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.slides.impl.select.m, kotlin.jvm.functions.Function1] */
    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L108;
        ResultKt.throwOnFailure(r14);
        o r15 = (o) this.L$0;
        if ((r15 instanceof o.e) == false) goto L9;
        ((o.e) r15).getClass();
        l0 r16 = (l0) this.this$0.i.getValue();
        if (r16 == null) goto L104;
        INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r16);
    L104:
        return Unit.INSTANCE;
    L9:
        String r2 = null;
        if ((r15 instanceof o.b) == false) goto L18;
        FragmentActivity r0 = this.this$0.getActivity();
        if (r0 == null) goto L14;
        ((o.b) r15).getClass();
        r0.setResult(11, null);
    L14:
        FragmentActivity r17 = this.this$0.getActivity();
        if (r17 == null) goto L104;
        r17.finish();
        goto L104
    L18:
        if ((r15 instanceof o.c) == false) goto L24;
        com.bytedance.router.i r1 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/create_bot");
        GenerateImageFragment r3 = this.this$0;
        if (r3.getArguments() == null) goto L22;
        r1.g(r3.getArguments());
    L22:
        ((o.c) r15).getClass();
        r1.d = 2130772401;
        r1.e = 2130772399;
        r1.e(11);
        goto L104
    L24:
        if ((r15 instanceof o.g) == false) goto L26;
        t19.s r4 = t19.s.a;
        Context r5 = this.this$0.getContext();
        String r18 = ((o.g) r15).a.toString(this.this$0.getContext());
        r4.getClass();
        t19.s.c(r5, r18);
        goto L104
    L26:
        boolean r6 = false;
        if ((r15 instanceof o.a) == false) goto L38;
        FragmentActivity r7 = this.this$0.getActivity();
        if (r7 == null) goto L31;
        r7.setResult(100, new Intent().putExtras(((o.a) r15).a));
    L31:
        FragmentActivity r19 = this.this$0.getActivity();
        if (r19 == null) goto L34;
        r19.finish();
    L34:
        FragmentActivity r110 = this.this$0.getActivity();
        if (r110 == null) goto L104;
        r110.overridePendingTransition(0, 2130772384);
        goto L104
    L38:
        if ((r15 instanceof o.d) == false) goto L44;
        PictureSaveActionSheet r8 = this.this$0.g;
        if (r8 == null) goto L42;
        INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r8);
    L42:
        PictureSaveActionSheet r9 = new PictureSaveActionSheet();
        ((o.d) r15).getClass();
        Intrinsics.checkNotNullParameter(null, "pictureData");
        r9.i = null;
        r9.f = null;
        r9.g = null;
        INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r9, this.this$0.getParentFragmentManager(), "PictureSaveActionSheet");
        this.this$0.g = r9;
        goto L104
    L44:
        if ((r15 instanceof o.f) == false) goto L106;
        PolarisFileWrapper r10 = new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "images");
        if (r10.exists() == true) goto L48;
        r10.mkdirs();
    L48:
        Lazy r11 = ImageSaveUtils.a;
        FragmentActivity r12 = this.this$0.getActivity();
        String r111 = ((o.f) r15).a;
        String r13 = r10.getAbsolutePath();
        final GenerateImageFragment r20 = this.this$0;
        ?? r21 = new m(r20);
        if (r111 != null) goto L51;
    L52:
        r6 = true;
    L54:
        if (r6 == false) goto L56;
        FLogger.a.e("ImageSaveUtils", "no url");
    L67:
        GenerateImageFragment r112 = this.this$0;
        int r22 = GenerateImageFragment.n;
        lr9.a r113 = r112.U90();
        if (r113 == null) goto L70;
        String r23 = r113.e();
    L71:
        lr9.a r114 = this.this$0.U90();
        if (r114 == null) goto L74;
        String r24 = r114.f();
    L75:
        lr9.a r115 = this.this$0.U90();
        if (r115 == null) goto L78;
        Integer r25 = r115.g();
    L79:
        lr9.a r116 = this.this$0.U90();
        if (r116 == null) goto L82;
        String r26 = r116.b();
    L83:
        lr9.a r117 = this.this$0.U90();
        if (r117 == null) goto L86;
        Integer r27 = r117.c();
    L87:
        ChatParam r118 = (ChatParam) this.this$0.k.getValue();
        if (r118 == null) goto L90;
        String r28 = r118.a;
    L91:
        ChatParam r119 = (ChatParam) this.this$0.k.getValue();
        if (r119 == null) goto L94;
        String r120 = r119.b;
    L95:
        lr9.a r121 = this.this$0.U90();
        if (r121 == null) goto L98;
        String r122 = r121.d();
    L99:
        lr9.a r123 = this.this$0.U90();
        if (r123 == null) goto L102;
        r2 = r123.a();
    L102:
        tx9.a.a(r23, r24, r25, r26, r27, r2, r28, r120, r122, "use");
        goto L104
    L98:
        r122 = null;
        goto L99
    L94:
        r120 = null;
        goto L95
    L90:
        r28 = null;
        goto L91
    L86:
        r27 = null;
        goto L87
    L82:
        r26 = null;
        goto L83
    L78:
        r25 = null;
        goto L79
    L74:
        r24 = null;
        goto L75
    L70:
        r23 = null;
        goto L71
    L56:
        if (r12 != null) goto L59;
        FLogger.a.e("ImageSaveUtils", "no activity");
        goto L67
    L59:
        if (SlidesFileUtils.b(r13) == false) goto L62;
        FLogger.a.i("ImageSaveUtils", "save to sandbox dir, no need permission check");
        ImageSaveUtils.a(r111, r13, r21);
        goto L67
    L62:
        if (Build.VERSION.SDK_INT > 29) goto L66;
        IPermissionX r29 = (IPermissionX) ServiceManager.get().getService(IPermissionX.class);
        if (r29 == null) goto L67;
        r29.a(r12, CollectionsKt.mutableListOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}), new com.larus.slides.impl.select.utils.g(r111, r13, r21));
        goto L67
    L66:
        ImageSaveUtils.a(r111, r13, r21);
        goto L67
    L51:
        if (r111.length() != 0) goto L54;
    L106:
        throw new NoWhenBranchMatchedException();
    L108:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(PictureSaveActionSheet r2, FragmentManager r3, String r4) {
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
