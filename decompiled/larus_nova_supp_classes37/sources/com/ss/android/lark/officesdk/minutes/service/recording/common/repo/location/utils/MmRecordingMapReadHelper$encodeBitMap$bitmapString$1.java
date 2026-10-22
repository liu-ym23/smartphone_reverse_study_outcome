package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper$encodeBitMap$bitmapString$1", f = "MmRecordingMapReadHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingMapReadHelper$encodeBitMap$bitmapString$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;

    public MmRecordingMapReadHelper$encodeBitMap$bitmapString$1(Bitmap r1, Continuation<? super MmRecordingMapReadHelper$encodeBitMap$bitmapString$1> r2) {
        this.$bitmap = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingMapReadHelper$encodeBitMap$bitmapString$1(this.$bitmap, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        Bitmap r0 = this.$bitmap;
        r0.compress(Bitmap.CompressFormat.PNG, 80, r5);     // Catch: Throwable -> L8
        String r1 = Base64.encodeToString(r5.toByteArray(), 2);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r5, null);
        return r1;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
