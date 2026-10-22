package com.larus.drive.biz.impl.viewmodel;

import androidx.fragment.app.FragmentActivity;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.sdk.api.file.download.DriveDownloadStatus;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$downloadFile$1$onProgressUpdated$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbsDriveListViewModel$downloadFile$1$onProgressUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bytesTransferred;
    final /* synthetic */ AbsDriveListFragment $fragment;
    final /* synthetic */ DriveDownloadStatus $status;
    final /* synthetic */ String $taskId;
    final /* synthetic */ long $totalBytes;
    int label;
    final /* synthetic */ AbsDriveListViewModel this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveDownloadStatus.values().length];
            r0[DriveDownloadStatus.FINISH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DriveDownloadStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public AbsDriveListViewModel$downloadFile$1$onProgressUpdated$1(String r1, DriveDownloadStatus r2, long r3, long r5, AbsDriveListViewModel r7, AbsDriveListFragment r8, Continuation<? super AbsDriveListViewModel$downloadFile$1$onProgressUpdated$1> r9) {
        this.$taskId = r1;
        this.$status = r2;
        this.$bytesTransferred = r3;
        this.$totalBytes = r5;
        this.this$0 = r7;
        this.$fragment = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AbsDriveListViewModel$downloadFile$1$onProgressUpdated$1(this.$taskId, this.$status, this.$bytesTransferred, this.$totalBytes, this.this$0, this.$fragment, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        FLogger.a.d("AbsDriveListViewModel", "onProgressUpdated: " + this.$taskId + ' ' + this.$status + ' ' + this.$bytesTransferred + ' ' + this.$totalBytes);
        int r6 = a.a[this.$status.ordinal()];
        if (r6 != 1) goto L7;
        AbsDriveListViewModel.access$get_isDownloading$p(this.this$0).setValue(Boxing.boxBoolean(false));
        t19.s r7 = t19.s.a;
        FragmentActivity r0 = this.$fragment.getActivity();
        String r1 = this.$fragment.getString(2131905398);
        r7.getClass();
        t19.s.p(r0, r1);
    L12:
        return Unit.INSTANCE;
    L7:
        if (r6 != 2) goto L12;
        AbsDriveListViewModel.access$get_isDownloading$p(this.this$0).setValue(Boxing.boxBoolean(false));
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
