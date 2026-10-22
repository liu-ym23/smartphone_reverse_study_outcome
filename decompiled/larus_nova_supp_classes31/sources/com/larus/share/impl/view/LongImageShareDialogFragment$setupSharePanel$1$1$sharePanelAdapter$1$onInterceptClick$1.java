package com.larus.share.impl.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.view.LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1", f = "LongImageShareDialogFragment.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
public final class LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ j $it;
    final /* synthetic */ jr9.a $shareItemConfig;
    int label;
    final /* synthetic */ LongImageShareDialogFragment this$0;

    public LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1(j r1, jr9.a r2, LongImageShareDialogFragment r3, Context r4, Continuation<? super LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1> r5) {
        this.$it = r1;
        this.$shareItemConfig = r2;
        this.this$0 = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1(this.$it, this.$shareItemConfig, this.this$0, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_share_impl_view_LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(LongImageShareDialogFragment r1) {
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

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r3 = r19;
    L11:
        com.larus.bmhome.share.panel.g r4 = (com.larus.bmhome.share.panel.g) r3;
        String r5 = this.$shareItemConfig.c();
        if (Intrinsics.areEqual(r5, "url") == false) goto L18;
        if (Intrinsics.areEqual(r4.c, r4.d) == false) goto L16;
        com.larus.bmhome.share.panel.b r6 = this.$it.c;
    L55:
        IShareService.a.d(ShareServiceDelegate.b, this.$context, this.$shareItemConfig.b(), this.$shareItemConfig.c(), com.larus.bmhome.share.panel.b.a(r6, null, null, null, null, null, null, true, 67043327), null, 48);
        FLogger.a.i("LongImageShareDialogFragment", "onInterceptClick: shareItemConfig.shareType = " + this.$shareItemConfig.c());
        if (this.$it.d.c == false) goto L59;
        INVOKEVIRTUAL_com_larus_share_impl_view_LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
    L59:
        return Unit.INSTANCE;
    L16:
        r6 = com.larus.bmhome.share.panel.b.a(this.$it.c, null, null, r4.c, null, null, null, false, 67108859);
        goto L55
    L18:
        if (Intrinsics.areEqual(r5, "image") == false) goto L54;
        com.larus.bmhome.share.panel.b r7 = this.$it.c;
        LongImageShareDialogFragment r8 = this.this$0;
        String r9 = r4.a;
        Bitmap r10 = r7.b;
        int r11 = LongImageShareDialogFragment.k;
        r8.getClass();
        if (r10 != null) goto L23;
        r10 = null;
    L53:
        r6 = com.larus.bmhome.share.panel.b.a(r7, null, r10, null, null, null, null, false, 67108861);
        goto L55
    L23:
        if (r10.getWidth() <= 0) goto L53;
        if (r10.getHeight() <= 0) goto L53;
        j r12 = r8.d;
        if (r12 == null) goto L53;
        FragmentActivity r13 = r12.a;
        if (r13 == null) goto L53;
        if (r12.d.a == false) goto L35;
        int r14 = p19.b.a;
        Bitmap r15 = p19.b.a(r9, r8.S90(), r8.S90(), -1);
    L36:
        if (r15 == null) goto L53;
        Bitmap r16 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r16);
        r17.drawBitmap(r10, 0.0f, 0.0f, null);
        int r18 = r17.getWidth() - ((Number) r8.h.getValue()).intValue();
        int r110 = (r17.getHeight() - ((Number) r8.i.getValue()).intValue()) - ((Number) r8.j.getValue()).intValue();
        int r111 = r18 - r8.S90();
        int r112 = r110 - r8.S90();
        j r20 = r8.d;
        if (r20 == null) goto L43;
        com.larus.bmhome.share.panel.e r113 = r20.d;
        if (r113 == null) goto L43;
        boolean r114 = r113.a;
    L44:
        if (r114 == false) goto L51;
        if (r20 == null) goto L53;
        com.larus.bmhome.share.panel.e r21 = r20.d;
        if (r21 == null) goto L53;
        Integer r22 = r21.b;
        if (r22 == null) goto L53;
        int r23 = r22.intValue();
        Rect r24 = new Rect(r111, r112, r18, r110);
        Paint r25 = new Paint();
        r25.setColor(r23);
        Unit r26 = Unit.INSTANCE;
        r17.drawRect(r24, r25);
    L52:
        r17.drawBitmap(r15, r111, r112, null);
        r10 = r16;
        goto L53
    L51:
        Rect r27 = new Rect(r111, r112, r18, r110);
        Paint r28 = new Paint();
        r28.setColor(ContextCompat.getColor(r13, 2131102529));
        Unit r29 = Unit.INSTANCE;
        r17.drawRect(r27, r28);
    L43:
        r114 = false;
        goto L44
    L35:
        int r30 = p19.b.a;
        r15 = p19.b.a(r9, r8.S90(), r8.S90(), ContextCompat.getColor(r13, 2131103136));
        goto L36
    L54:
        r6 = this.$it.c;
        goto L55
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        Function1 r31 = this.$it.d.h;
        this.label = 1;
        r3 = r31.invoke(this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
