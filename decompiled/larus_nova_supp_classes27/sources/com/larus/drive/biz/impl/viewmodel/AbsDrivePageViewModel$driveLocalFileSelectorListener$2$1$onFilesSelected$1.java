package com.larus.drive.biz.impl.viewmodel;

import android.app.Application;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.drive.biz.impl.file.DriveLocalFileSelector;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.sdk.api.file.upload.DriveUploadPriority;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1", f = "AbsDrivePageViewModel.kt", i = {0, 0}, l = {98}, m = "invokeSuspend", n = {"it", "parentDriveToken"}, s = {"L$3", "L$4"})
public final class AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.drive.biz.impl.file.i> $files;
    final /* synthetic */ String $scene;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AbsDrivePageViewModel this$0;

    public AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1(List<com.larus.drive.biz.impl.file.i> r1, AbsDrivePageViewModel r2, String r3, Continuation<? super AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1> r4) {
        this.$files = r1;
        this.this$0 = r2;
        this.$scene = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1(this.$files, this.this$0, this.$scene, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0064 -> B:29:0x00cc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008f -> B:24:0x0099). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 1;
        String r4 = "";
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        String r5 = (String) this.L$4;
        com.larus.drive.biz.impl.file.i r6 = (com.larus.drive.biz.impl.file.i) this.L$3;
        Iterator r7 = (Iterator) this.L$2;
        String r8 = (String) this.L$1;
        AbsDrivePageViewModel r9 = (AbsDrivePageViewModel) this.L$0;
        ResultKt.throwOnFailure(r23);
        AbsDrivePageViewModel r10 = r9;
        String r11 = r8;
        Iterator r12 = r7;
        com.larus.drive.biz.impl.file.i r13 = r6;
        String r14 = "";
        AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1 r15 = this;
    L24:
        DriveLocalFileSelector r16 = DriveLocalFileSelector.a;
        Application r17 = AppHost.a.getApplication();
        Uri r18 = r13.a;
        r16.getClass();
        String r110 = (String) DriveLocalFileSelector.g(r17, r18).getSecond();
        if (r110 != null) goto L27;
        String r111 = r5;
        AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1$onFilesSelected$1 r20 = r15;
        String r112 = r14;
        String r113 = r112;
        com.larus.drive.biz.impl.file.i r114 = r13;
        Iterator r115 = r12;
        String r116 = r11;
        AbsDrivePageViewModel r117 = r10;
    L29:
        Lazy r21 = com.larus.drive.biz.impl.file.t.a;
        String r22 = r114.a.toString();
        Intrinsics.checkNotNullParameter(r112, "fileName");
        Intrinsics.checkNotNullParameter(r22, "uri");
        Intrinsics.checkNotNullParameter(r111, "parentDriveToken");
        String r24 = r112;
        String r25 = r111;
        String r26 = DriveSdkService.a.t(r24, r22, r25, DriveUploadPriority.NORMAL, new com.larus.drive.biz.impl.file.s());
        if (r26 == null) goto L44;
        String r27 = r26 + '_' + System.currentTimeMillis();
        DriveFileType.a r28 = DriveFileType.Companion;
        String r30 = r114.b;
        r28.getClass();
        DriveFileType r31 = DriveFileType.a.b(r30);
        if (r114.d == true) goto L34;
    L36:
        DriveUploadStatus r32 = DriveUploadStatus.UNSTARTED;
    L37:
        DriveUploadStatus r118 = r32;
        JSONObject r33 = AbsDrivePageViewModel.access$getEventParams$p(r117);
        if (r33 == null) goto L41;
        String r34 = r33.toString();
        if (r34 == null) goto L41;
    L42:
        JSONObject r119 = new JSONObject(r34);
        r119.put("upload_from", r116);
        Unit r35 = Unit.INSTANCE;
        com.larus.drive.biz.impl.file.t.k(new com.larus.drive.biz.api.model.a(r27, r26, r112, r31, r111, r118, null, null, null, r119), false);
    L41:
        r34 = new JSONObject().toString();
        goto L42
    L34:
        if (StringsKt.isBlank(r112) == false) goto L36;
        r32 = DriveUploadStatus.FAILED;
    L44:
        r4 = r113;
        Iterator r36 = r115;
        AbsDrivePageViewModel r37 = r117;
        String r38 = r116;
        r3 = 1;
    L10:
        if (r36.hasNext() == false) goto L46;
        com.larus.drive.biz.impl.file.i r40 = (com.larus.drive.biz.impl.file.i) r36.next();
        String r41 = r37.getCurrentFolderDriveToken();
        if (r41 != null) goto L15;
        r41 = r4;
    L15:
        if (r40.d == true) goto L20;
        String r120 = r40.b;
        if (r120 != null) goto L28;
        r112 = r4;
        r113 = r112;
        r114 = r40;
        r115 = r36;
        r116 = r38;
        r117 = r37;
        r111 = r41;
        goto L29
    L28:
        r113 = r4;
        r114 = r40;
        r115 = r36;
        r116 = r38;
        r117 = r37;
        r111 = r41;
        r112 = r120;
        goto L29
    L20:
        r20.L$0 = r37;
        r20.L$1 = r38;
        r20.L$2 = r36;
        r20.L$3 = r40;
        r20.L$4 = r41;
        r20.label = r3;
        if (DelayKt.delay(100, r20) != r1) goto L23;
        return r1;
    L23:
        String r210 = r4;
        r15 = r20;
        r5 = r41;
        r10 = r37;
        r11 = r38;
        r12 = r36;
        r13 = r40;
        r14 = r210;
        goto L24
    L46:
        return Unit.INSTANCE;
    L27:
        String r121 = r5;
        r20 = r15;
        r113 = r14;
        r114 = r13;
        r115 = r12;
        r116 = r11;
        r117 = r10;
        r111 = r121;
        r112 = r110;
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        List<com.larus.drive.biz.impl.file.i> r42 = this.$files;
        AbsDrivePageViewModel r43 = this.this$0;
        r37 = r43;
        r38 = this.$scene;
        r36 = r42.iterator();
        r20 = this;
        goto L10
    }
}
