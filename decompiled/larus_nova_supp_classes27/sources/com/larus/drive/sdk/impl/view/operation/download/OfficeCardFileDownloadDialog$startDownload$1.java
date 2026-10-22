package com.larus.drive.sdk.impl.view.operation.download;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.download.DriveDownloadStatus;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.service.u;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.operation.download.OfficeCardFileDownloadDialog$startDownload$1", f = "OfficeCardFileDownloadDialog.kt", i = {0, 1, 1}, l = {131, 144}, m = "invokeSuspend", n = {"fileService", "fileService", "file"}, s = {"L$0", "L$0", "L$1"})
final class OfficeCardFileDownloadDialog$startDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OfficeCardFileDownloadDialog this$0;

    public static final class a implements u {
        public final /* synthetic */ OfficeCardFileDownloadDialog a;
        public final /* synthetic */ DriveFileItem b;

        /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.operation.download.OfficeCardFileDownloadDialog$startDownload$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0117a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DriveDownloadStatus.values().length];
                r0[DriveDownloadStatus.FINISH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[DriveDownloadStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[DriveDownloadStatus.CANCELED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[DriveDownloadStatus.UNSTARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[DriveDownloadStatus.DOWNLOADING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        @Override // com.larus.drive.sdk.impl.service.u
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "filePath");
            this.a.i = r2;
        }

        public a(OfficeCardFileDownloadDialog r1, DriveFileItem r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // t79.a
        public final void onFailed(String r1, int r2) {
            OfficeCardFileDownloadDialog r3 = this.a;
            r3.e = r1;
            if (r3.g == true) goto L6;
            r3.W90();
            return;
        }

        @Override // t79.a
        public final void b(String r7, DriveDownloadStatus r8, long r9, long r11) {
            Intrinsics.checkNotNullParameter(r8, "status");
            OfficeCardFileDownloadDialog r10 = this.a;
            r10.e = r7;
            if (r10.g == false) goto L6;
            r10.U90();
            return;
        L6:
            int r12 = C0117a.a[r8.ordinal()];
            boolean r13 = true;
            if (r12 != 1) goto L9;
            OfficeCardFileDownloadDialog r14 = this.a;
            String r15 = this.b.a;
            String r16 = r14.i;
            if (r16 != null) goto L24;
        L27:
            if (r13 == false) goto L29;
            r14.W90();
            return;
        L29:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new OfficeCardFileDownloadDialog$shareDownloadedFile$1(r14, r16, r15, null), 3, null);
            return;
        L24:
            if (StringsKt.isBlank(r16) == true) goto L27;
            r13 = false;
            goto L27
        L9:
            if (r12 != 2) goto L11;
            this.a.W90();
            return;
        L11:
            if (r12 != 3) goto L13;
            this.a.V90();
            return;
        L13:
            if (r12 != 4) goto L15;
            return;
        L15:
            if (r12 != 5) goto L18;
            return;
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    public OfficeCardFileDownloadDialog$startDownload$1(OfficeCardFileDownloadDialog r1, Context r2, Continuation<? super OfficeCardFileDownloadDialog$startDownload$1> r3) {
        this.this$0 = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OfficeCardFileDownloadDialog$startDownload$1 r0 = new OfficeCardFileDownloadDialog$startDownload$1(this.this$0, this.$context, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [e89.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [e89.c] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        DriveFileItem r2 = (DriveFileItem) this.L$1;
        e89.c r3 = (e89.c) this.L$0;
        ResultKt.throwOnFailure(r8);
        ?? r4 = r3;
    L34:
        int r9 = ((Number) r8).intValue();
        if (r9 != 10001) goto L37;
        OfficeCardFileDownloadDialog r10 = this.this$0;
        if (r10.g == true) goto L53;
        if (r10.isAdded() == false) goto L53;
        Context r11 = this.$context;
        a r5 = new a(this.this$0, r2);
        String r12 = r4.a(r2, r11, DriveDownloadPriority.NORMAL, r5);
        OfficeCardFileDownloadDialog r6 = this.this$0;
        r6.e = r12;
        if (r6.g == false) goto L51;
        r6.U90();
    L51:
        return Unit.INSTANCE;
    L53:
        return Unit.INSTANCE;
    L37:
        if (r9 == 10002) goto L40;
        s r13 = s.a;
        Context r7 = this.$context;
        r13.getClass();
        s.s(r7, 2131899179);
        OfficeCardFileDownloadDialog r14 = this.this$0;
        int r15 = OfficeCardFileDownloadDialog.j;
        r14.V90();
        return Unit.INSTANCE;
    L40:
        s r16 = s.a;
        Context r17 = this.$context;
        r16.getClass();
        s.s(r17, 2131901792);
        OfficeCardFileDownloadDialog r18 = this.this$0;
        int r20 = OfficeCardFileDownloadDialog.j;
        r18.V90();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        e89.c r21 = (e89.c) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L18
        r1 = r21;
    L16:
        Object r22 = Result.constructor-impl((DriveFileItem) r8);     // Catch: Throwable -> L18
        ?? r23 = r1;
    L20:
        Throwable r24 = Result.exceptionOrNull-impl(r22);
        if (r24 == null) goto L24;
        FLogger.a.e("OfficeCardFileDownloadDialog", "[startDownload] Failed to fetch file info", r24);
    L24:
        if (Result.isFailure-impl(r22) == false) goto L26;
        r22 = null;
    L26:
        DriveFileItem r25 = (DriveFileItem) r22;
        if (r25 != null) goto L30;
        OfficeCardFileDownloadDialog r26 = this.this$0;
        int r27 = OfficeCardFileDownloadDialog.j;
        r26.W90();
        return Unit.INSTANCE;
    L30:
        String r28 = r25.b;
        int r30 = r25.d;
        this.L$0 = r23;
        this.L$1 = r25;
        this.label = 2;
        Object r31 = r23.i(r28, r30, "DOWNLOAD", this);
        if (r31 != r0) goto L33;
        return r0;
    L33:
        r2 = r25;
        r8 = r31;
        r4 = r23;
        goto L34
    L12:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r32 = (CoroutineScope) this.L$0;
        e89.c r33 = t.a();
        OfficeCardFileDownloadDialog r34 = this.this$0;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L18
        String r36 = r34.f;     // Catch: Throwable -> L18
        this.L$0 = r33;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r8 = r33.b(r36, 12, false, this);     // Catch: Throwable -> L18
        r1 = r33;
        if (r8 != r0) goto L16;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        r23 = r1;
        goto L20
    }
}
