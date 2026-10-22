package com.larus.drive.sdk.impl.utils.file;

import com.larus.drive.sdk.api.file.download.DriveDownloadStatus;
import com.larus.drive.sdk.impl.view.operation.download.DriveDownloadDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.file.DriveDownloadManager$onDownloadProgress$1", f = "DriveDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DriveDownloadManager$onDownloadProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bytesTransferred;
    final /* synthetic */ DriveDownloadStatus $status;
    final /* synthetic */ String $taskId;
    final /* synthetic */ long $totalBytes;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveDownloadStatus.values().length];
            r0[DriveDownloadStatus.UNSTARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DriveDownloadStatus.DOWNLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DriveDownloadStatus.FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DriveDownloadStatus.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DriveDownloadStatus.CANCELED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public DriveDownloadManager$onDownloadProgress$1(String r1, DriveDownloadStatus r2, long r3, long r5, Continuation<? super DriveDownloadManager$onDownloadProgress$1> r7) {
        this.$taskId = r1;
        this.$status = r2;
        this.$totalBytes = r3;
        this.$bytesTransferred = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DriveDownloadManager$onDownloadProgress$1(this.$taskId, this.$status, this.$totalBytes, this.$bytesTransferred, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L49;
        ResultKt.throwOnFailure(r7);
        String r8 = this.$taskId;
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L13;
        CoroutineScope r10 = DriveDownloadManager.a;
        DriveDownloadManager.b = this.$taskId;
    L13:
        int r11 = a.a[this.$status.ordinal()];
        if (r11 != 1) goto L16;
        DriveDownloadManager.d = true;
        DriveDownloadManager.c = 0;
        DriveDownloadManager.a();
        WeakReference<DriveDownloadDialog> r12 = DriveDownloadManager.f;
        if (r12 == null) goto L47;
        DriveDownloadDialog r13 = r12.get();
        if (r13 == null) goto L47;
        r13.T90(0);
    L47:
        return Unit.INSTANCE;
    L16:
        if (r11 != 2) goto L18;
        DriveDownloadManager.d = true;
        long r2 = this.$totalBytes;
        if (r2 <= 0) goto L35;
        int r0 = (int) ((this.$bytesTransferred / r2) * ((double) 100));
    L36:
        DriveDownloadManager.c = RangesKt.coerceIn(r0, 0, 100);
        DriveDownloadManager.a();
        WeakReference<DriveDownloadDialog> r14 = DriveDownloadManager.f;
        if (r14 == null) goto L47;
        DriveDownloadDialog r15 = r14.get();
        if (r15 == null) goto L47;
        r15.T90(DriveDownloadManager.c);
        goto L47
    L35:
        r0 = 0;
        goto L36
    L18:
        if (r11 != 3) goto L20;
    L26:
        DriveDownloadManager.d = false;
        DriveDownloadManager.c = 0;
        DriveDownloadManager.b = null;
        WeakReference<DriveDownloadDialog> r1 = DriveDownloadManager.f;
        if (r1 == null) goto L31;
        DriveDownloadDialog r3 = r1.get();
        if (r3 == null) goto L31;
        r3.S90();
    L31:
        DriveDownloadManager.f = null;
        goto L47
    L20:
        if (r11 == 4) goto L26;
        if (r11 == 5) goto L26;
        throw new NoWhenBranchMatchedException();
    L7:
        if (StringsKt.isBlank(r8) == true) goto L10;
        r9 = false;
        goto L11
    L49:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
