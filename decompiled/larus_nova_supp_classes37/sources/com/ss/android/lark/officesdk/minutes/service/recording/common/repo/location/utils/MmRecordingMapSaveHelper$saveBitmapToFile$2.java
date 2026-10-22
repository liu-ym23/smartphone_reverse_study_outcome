package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper$saveBitmapToFile$2", f = "MmRecordingMapSaveHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingMapSaveHelper$saveBitmapToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$saveBitmapToFile$2(Context r1, String r2, Bitmap r3, MmRecordingMapSaveHelper r4, Continuation<? super MmRecordingMapSaveHelper$saveBitmapToFile$2> r5) {
        this.$context = r1;
        this.$fileName = r2;
        this.$bitmap = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingMapSaveHelper$saveBitmapToFile$2 r6 = new MmRecordingMapSaveHelper$saveBitmapToFile$2(this.$context, this.$fileName, this.$bitmap, this.this$0, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L46;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Context r10 = this.$context;
        String r0 = this.$fileName;
        Bitmap r1 = this.$bitmap;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L36
        PolarisFileWrapper r11 = MmRecordingMapUtilKt.c(r10);     // Catch: Throwable -> L36
        File r4 = new PolarisFileWrapper(r11, r0);     // Catch: Throwable -> L36
        PolarisFileWrapper r5 = new PolarisFileWrapper(r11, r0 + ".tmp");     // Catch: Throwable -> L36
        if (r5.exists() == false) goto L8;
        r5.delete();     // Catch: Throwable -> L36
    L8:
        PolarisFileOutputStreamWrapper r12 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L36
        boolean r2 = r1.compress(Bitmap.CompressFormat.PNG, 100, r12);     // Catch: Throwable -> L31
        r12.flush();     // Catch: Throwable -> L31
    L11:
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L36
        if (r2 == true) goto L14;
    L27:
        r5.delete();     // Catch: Throwable -> L36
    L28:
        boolean r13 = false;
    L29:
        Object r14 = Result.constructor-impl(Boxing.boxBoolean(r13));     // Catch: Throwable -> L36
    L38:
        MmRecordingMapSaveHelper r6 = this.this$0;
        Throwable r7 = Result.exceptionOrNull-impl(r14);
        if (r7 == null) goto L41;
        lvb.a.b(r6.c, "[saveBitmapToFile] failed: " + ExceptionsKt.stackTraceToString(r7));
    L41:
        Boolean r15 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r14) == true) goto L44;
        return r14;
    L44:
        return r15;
    L14:
        if (r5.length() <= 0) goto L27;
        if (r4.exists() == false) goto L20;
        r4.delete();     // Catch: Throwable -> L36
    L20:
        if (r5.renameTo(r4) == true) goto L23;
        r5.delete();     // Catch: Throwable -> L36
        goto L28
    L23:
        if (r4.exists() == false) goto L28;
        if (r4.length() <= 0) goto L28;
        r13 = true;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L46:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
