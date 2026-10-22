package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapUtilKt$isSnapShotFileExist$2", f = "MmRecordingMapUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingMapUtilKt$isSnapShotFileExist$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isDarkMode;
    int label;

    public MmRecordingMapUtilKt$isSnapShotFileExist$2(boolean r1, Context r2, Continuation<? super MmRecordingMapUtilKt$isSnapShotFileExist$2> r3) {
        this.$isDarkMode = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingMapUtilKt$isSnapShotFileExist$2(this.$isDarkMode, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r5);
        if (this.$isDarkMode == false) goto L7;
        String r6 = "mm_map_snapshot_dark.png";
    L8:
        PolarisFileWrapper r0 = new PolarisFileWrapper(MmRecordingMapUtilKt.c(this.$context), r6);
        if (r0.exists() == true) goto L11;
    L13:
        boolean r7 = false;
    L15:
        return Boxing.boxBoolean(r7);
    L11:
        if (r0.length() <= 0) goto L13;
        r7 = true;
        goto L15
    L7:
        r6 = "mm_map_snapshot_light.png";
        goto L8
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
