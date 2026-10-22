package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.content.Context;
import com.bytedance.crash.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.io.File;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment$saveDownloadedFile$2", f = "FileCardDownloadDialogFragment.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
final class FileCardDownloadDialogFragment$saveDownloadedFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ File $localFile;
    int label;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$saveDownloadedFile$2(FileCardDownloadDialogFragment r1, File r2, String r3, Continuation<? super FileCardDownloadDialogFragment$saveDownloadedFile$2> r4) {
        this.this$0 = r1;
        this.$localFile = r2;
        this.$fileName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FileCardDownloadDialogFragment$saveDownloadedFile$2(this.this$0, this.$localFile, this.$fileName, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_standarduikit_fileblock_download_FileCardDownloadDialogFragment$saveDownloadedFile$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(FileCardDownloadDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L24
    L13:
        boolean r9 = ((Boolean) r8).booleanValue();     // Catch: Throwable -> L24
        FileCardDownloadDialogFragment r2 = this.this$0;
        String r3 = this.$localFile.getAbsolutePath();
        int r4 = FileCardDownloadDialogFragment.j;
        r2.getClass();
        FileCardDownloadDialogFragment.Z90(r3);
        FileCardDownloadDialogFragment r5 = this.this$0;
        r5.h = null;
        if (r5.i == true) goto L17;
        r5.i = true;
        if (r9 == false) goto L21;
        FLogger.a.i("FileCardDownloadDialog", "download saved, fileName=" + this.$fileName);
        s r10 = s.a;
        Context r6 = this.this$0.getContext();
        r10.getClass();
        s.o(r6, 2131899624, false);
        INVOKEVIRTUAL_com_larus_bmhome_chat_standarduikit_fileblock_download_FileCardDownloadDialogFragment$saveDownloadedFile$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
    L23:
        return Unit.INSTANCE;
    L21:
        FileCardDownloadDialogFragment.U90(r5, null);
        goto L23
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        FileCardDownloadDialogFragment r11 = this.this$0;     // Catch: Throwable -> L24
        File r7 = this.$localFile;     // Catch: Throwable -> L24
        String r12 = this.$fileName;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        int r13 = FileCardDownloadDialogFragment.j;     // Catch: Throwable -> L24
        r11.getClass();     // Catch: Throwable -> L24
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new FileCardDownloadDialogFragment$exportFileToSystemDownloads$2(r7, r11, r12, null), this);     // Catch: Throwable -> L24
        if (r8 != r0) goto L13;
        return r0;
    L24:
        th = move-exception;
        FileCardDownloadDialogFragment r14 = this.this$0;
        String r15 = this.$localFile.getAbsolutePath();
        int r16 = FileCardDownloadDialogFragment.j;
        r14.getClass();
        FileCardDownloadDialogFragment.Z90(r15);
        this.this$0.h = null;
        throw th;
    }
}
