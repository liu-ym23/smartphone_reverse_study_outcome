package com.obric.assistant.omnidetailpage.componment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.nestedfile.NestFileService;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.omnidetailpage.localmedia.OmniDetailInputFileCache;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$openOrDownloadHeaderAttachment$2", f = "OmniDetailContentComponent.kt", i = {0, 0, 1, 1}, l = {795, 810}, m = "invokeSuspend", n = {"context", "loadingDialog", "loadingDialog", "downloadedPath"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class OmniDetailContentComponent$openOrDownloadHeaderAttachment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ifa.a $attachment;
    final /* synthetic */ String $fileCacheKey;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    final /* synthetic */ Function1<String, Unit> $onReady;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public OmniDetailContentComponent$openOrDownloadHeaderAttachment$2(View r1, String r2, OmniDetailContentComponent r3, ifa.a r4, Function1<? super String, Unit> r5, UplinkFileInfo r6, Continuation<? super OmniDetailContentComponent$openOrDownloadHeaderAttachment$2> r7) {
        this.$view = r1;
        this.$fileCacheKey = r2;
        this.this$0 = r3;
        this.$attachment = r4;
        this.$onReady = r5;
        this.$fileInfo = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        OmniDetailContentComponent$openOrDownloadHeaderAttachment$2 r8 = new OmniDetailContentComponent$openOrDownloadHeaderAttachment$2(this.$view, this.$fileCacheKey, this.this$0, this.$attachment, this.$onReady, this.$fileInfo, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_omnidetailpage_componment_OmniDetailContentComponent$openOrDownloadHeaderAttachment$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_obric_assistant_omnidetailpage_componment_OmniDetailContentComponent$openOrDownloadHeaderAttachment$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.common_ui.dialog.l0] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.common_ui.dialog.l0] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.larus.common_ui.dialog.l0] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.common_ui.dialog.l0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L12;
        String r0 = (String) this.L$1;
        ?? r3 = (l0) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L9
        r3 = r3;
    L65:
        this.$onReady.invoke(r0);     // Catch: Throwable -> L9
        this.this$0.z.remove(this.$attachment.a);
        INVOKEVIRTUAL_com_obric_assistant_omnidetailpage_componment_OmniDetailContentComponent$openOrDownloadHeaderAttachment$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r3);
        return Unit.INSTANCE;
    L9:
        th = th;
    L72:
        this.this$0.z.remove(this.$attachment.a);
        INVOKEVIRTUAL_com_obric_assistant_omnidetailpage_componment_OmniDetailContentComponent$openOrDownloadHeaderAttachment$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r3);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        l0 r4 = (l0) this.L$1;
        Context r5 = (Context) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L16
        r2 = r4;
    L23:
        Object r13 = Result.constructor-impl(((lr8.g) r12).h);     // Catch: Throwable -> L16
        r2 = r2;
    L26:
        String r6 = this.$fileCacheKey;     // Catch: Throwable -> L70
        Throwable r7 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L70
        if (r7 == null) goto L29;
        FLogger.a.e("OmniDetailContentComponent", "download header attachment failed, fileCacheKey=" + r6, r7);     // Catch: Throwable -> L70
    L29:
        String r8 = null;
        if (Result.isFailure-impl(r13) == false) goto L32;
        r13 = null;
    L32:
        String r14 = (String) r13;     // Catch: Throwable -> L70
        if (r14 != null) goto L35;
    L37:
        r0 = null;
    L38:
        if (r0 != null) goto L42;
        t19.s r15 = t19.s.a;     // Catch: Throwable -> L70
        String r9 = r5.getString(2131905676);     // Catch: Throwable -> L70
        r15.getClass();     // Catch: Throwable -> L70
        t19.s.c(r5, r9);     // Catch: Throwable -> L70
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L70
        this.this$0.z.remove(this.$attachment.a);
        INVOKEVIRTUAL_com_obric_assistant_omnidetailpage_componment_OmniDetailContentComponent$openOrDownloadHeaderAttachment$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r2);
        return r16;
    L42:
        OmniDetailInputFileCache r17 = OmniDetailInputFileCache.a;     // Catch: Throwable -> L70
        String r10 = this.$fileCacheKey;     // Catch: Throwable -> L70
        monitor-enter(r17);     // Catch: Throwable -> L70
        Intrinsics.checkNotNullParameter(r0, "path");     // Catch: Throwable -> L50
        if (r10 != null) goto L48;
    L52:
        if (r8 != null) goto L55;
        monitor-exit(r17);     // Catch: Throwable -> L70
    L61:
        OmniDetailContentComponent r18 = this.this$0;     // Catch: Throwable -> L70
        String r11 = this.$attachment.a;     // Catch: Throwable -> L70
        this.L$0 = r2;     // Catch: Throwable -> L70
        this.L$1 = r0;     // Catch: Throwable -> L70
        this.label = 2;     // Catch: Throwable -> L70
        if (OmniDetailContentComponent.C3(r18, r11, r0, this) != r1) goto L64;
        return r1;
    L64:
        r3 = r2;
        goto L65
    L55:
        String r19 = OmniDetailInputFileCache.f(r0, OmniDetailInputFileCache.b());     // Catch: Throwable -> L50
        if (r19 != null) goto L59;
        monitor-exit(r17);     // Catch: Throwable -> L70
        goto L61
    L59:
        OmniDetailInputFileCache.d().storeString(r8, r19);     // Catch: Throwable -> L50
        monitor-exit(r17);     // Catch: Throwable -> L70
        goto L61
    L48:
        if ((true ^ StringsKt.isBlank(r10)) == false) goto L52;
        r8 = r10;
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L70
    L35:
        if (new PolarisFileWrapper(r14).isFile() == false) goto L37;
        r0 = r14;
        goto L38
    L18:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        r5 = this.$view.getContext();
        Intrinsics.checkNotNull(r5);
        l0 r20 = new l0(r5, 0.0f, false, 6);
        INVOKEVIRTUAL_com_obric_assistant_omnidetailpage_componment_OmniDetailContentComponent$openOrDownloadHeaderAttachment$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r20);
        UplinkFileInfo r111 = this.$fileInfo;     // Catch: Throwable -> L70
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L16
        NestFileService r22 = NestFileService.b;     // Catch: Throwable -> L16
        this.L$0 = r5;     // Catch: Throwable -> L16
        this.L$1 = r20;     // Catch: Throwable -> L16
        this.label = 1;     // Catch: Throwable -> L16
        r12 = r22.f(r5, r111, this);     // Catch: Throwable -> L16
        r2 = r20;
        if (r12 != r1) goto L23;
        return r1;
    L16:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L70
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L70
        r2 = r2;
    L70:
        th = th;
        r3 = r2;
        goto L72
    }
}
