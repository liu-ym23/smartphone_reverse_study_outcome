package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.im.bean.message.SendFile;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.DownloadFileMenuHandler$handleAction$1", f = "SaveMenuItem.kt", i = {}, l = {260, 262}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadFileMenuHandler$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ ef8.b $menuContext;
    final /* synthetic */ SendFile $sendFile;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.menu.item.DownloadFileMenuHandler$handleAction$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.DownloadFileMenuHandler$handleAction$1$1", f = "SaveMenuItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        public AnonymousClass1(Context r1, Continuation<? super AnonymousClass1> r2) {
            this.$context = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$context, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            t19.s r3 = t19.s.a;
            Context r0 = this.$context;
            r3.getClass();
            t19.s.s(r0, 2131908982);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a extends AbsDownloadListener {
        public com.larus.common_ui.dialog.l0 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ ef8.b c;

        public static void a(com.larus.common_ui.dialog.l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final void onCanceled(DownloadInfo r1) {
            com.larus.common_ui.dialog.l0 r2 = this.a;
            if (r2 == null) goto L6;
            a(r2);
            return;
        }

        public final void onStart(DownloadInfo r5) {
            com.larus.common_ui.dialog.l0 r6 = new com.larus.common_ui.dialog.l0(this.b, 0.0f, false, 6);
            this.a = r6;
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r6);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
        }

        public final void onSuccessed(DownloadInfo r11) {
            com.larus.common_ui.dialog.l0 r0 = this.a;
            if (r0 == null) goto L5;
            a(r0);
        L5:
            ef8.b r1 = this.c;
            if (r11 == null) goto L8;
            String r12 = r11.getTargetFilePath();
        L10:
            if (r12 != null) goto L12;
        L15:
            boolean r3 = true;
        L16:
            if (r3 == true) goto L23;
            com.larus.bmhome.chat.api.q0.a r4 = r1.b;
            if (r4 == null) goto L23;
            LifecycleCoroutineScope r5 = r4.F9();
            if (r5 == null) goto L23;
            BuildersKt.launch$default(r5, Dispatchers.getIO(), null, new SaveMenuItemKt$updateDownloadedFileLocalPath$1(r1, r12, null), 2, null);
        L23:
            t19.s r13 = t19.s.a;
            Context r2 = this.b;
            r13.getClass();
            t19.s.o(r2, 2131909923, false);
            return;
        L12:
            if (r12.length() == 0) goto L15;
            r3 = false;
            goto L16
        L8:
            r12 = null;
            goto L10
        }

        public a(Context r1, ef8.b r2) {
            this.b = r1;
            this.c = r2;
        }

        public final void onFailed(DownloadInfo r4, BaseException r5) {
            com.larus.common_ui.dialog.l0 r6 = this.a;
            if (r6 == null) goto L5;
            a(r6);
        L5:
            FLogger r7 = FLogger.a;
            StringBuilder r0 = new StringBuilder("download file failed, code=");
            String r1 = null;
            if (r5 == null) goto L8;
            Integer r2 = Integer.valueOf(r5.getErrorCode());
        L9:
            r0.append(r2);
            r0.append(", msg=");
            if (r5 == null) goto L12;
            r1 = r5.getErrorMessage();
        L12:
            r0.append(r1);
            r7.e("DownloadFileMenuHandler", r0.toString());
            t19.s r8 = t19.s.a;
            Context r9 = this.b;
            r8.getClass();
            t19.s.s(r9, 2131908982);
            return;
        L8:
            r2 = null;
            goto L9
        }
    }

    public DownloadFileMenuHandler$handleAction$1(SendFile r1, Context r2, String r3, ef8.b r4, Continuation<? super DownloadFileMenuHandler$handleAction$1> r5) {
        this.$sendFile = r1;
        this.$context = r2;
        this.$fileName = r3;
        this.$menuContext = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DownloadFileMenuHandler$handleAction$1(this.$sendFile, this.$context, this.$fileName, this.$menuContext, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        String r8 = (String) r7;
        if (r8 != null) goto L16;
    L19:
        if (r3 == false) goto L25;
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$context, null);
        this.label = 2;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L24;
        return r0;
    L25:
        b$a.a(ChatInputService.b.f(), this.$context, r8, this.$fileName, new a(this.$context, this.$menuContext));
        return Unit.INSTANCE;
    L16:
        if (r8.length() == 0) goto L19;
        r3 = false;
        goto L19
    L10:
        ResultKt.throwOnFailure(r7);
        SendFile r10 = this.$sendFile;
        this.label = 1;
        r7 = SaveMenuItemKt.a(r10, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
