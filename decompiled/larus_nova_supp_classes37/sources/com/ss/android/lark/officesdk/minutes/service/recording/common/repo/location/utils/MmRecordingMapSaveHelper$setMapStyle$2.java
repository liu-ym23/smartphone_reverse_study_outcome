package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper$setMapStyle$2", f = "MmRecordingMapSaveHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingMapSaveHelper$setMapStyle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isDarkMode;
    final /* synthetic */ IPickLocationMap $map;
    int label;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$setMapStyle$2(MmRecordingMapSaveHelper r1, IPickLocationMap r2, Context r3, boolean r4, Continuation<? super MmRecordingMapSaveHelper$setMapStyle$2> r5) {
        this.this$0 = r1;
        this.$map = r2;
        this.$context = r3;
        this.$isDarkMode = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingMapSaveHelper$setMapStyle$2(this.this$0, this.$map, this.$context, this.$isDarkMode, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r15);
        MmRecordingMapSaveHelper r16 = this.this$0;
        IPickLocationMap r0 = this.$map;
        Context r1 = this.$context;
        boolean r2 = this.$isDarkMode;
        int r3 = MmRecordingMapSaveHelper.m;
        r16.getClass();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L39
        if (r2 == false) goto L8;
        String r6 = "recording_amap_style_night";
    L9:
        PolarisFileWrapper r7 = new PolarisFileWrapper(MmRecordingMapUtilKt.c(r1), r6);     // Catch: Throwable -> L39
        if (r7.exists() == true) goto L12;
        r7.mkdirs();     // Catch: Throwable -> L39
    L12:
        PolarisFileWrapper r8 = new PolarisFileWrapper(r7, "style.data");     // Catch: Throwable -> L39
        boolean r10 = true;
        if (r8.exists() == true) goto L16;
    L18:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L29;
        PolarisFileWrapper r11 = new PolarisFileWrapper(r7, "style_extra.data");     // Catch: Throwable -> L39
        if (r11.exists() == true) goto L24;
    L26:
        boolean r12 = false;
    L27:
        if (r12 == false) goto L29;
    L30:
        if (r10 == true) goto L32;
        r16.j(r1, r7, r2);     // Catch: Throwable -> L39
    L32:
        byte[] r4 = MmRecordingMapSaveHelper.g(r7, "style.data");     // Catch: Throwable -> L39
        byte[] r13 = MmRecordingMapSaveHelper.g(r7, "style_extra.data");     // Catch: Throwable -> L39
        if (r4 == null) goto L37;
        if (r13 == null) goto L37;
        r0.i();     // Catch: Throwable -> L39
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r17 = Result.exceptionOrNull-impl(r14);
        if (r17 == null) goto L45;
        lvb.a.b(r16.c, "[applyFeishuAmapStyleSafely] failed, isDarkMode=" + r2 + ", error=" + r17.getMessage());
    L45:
        return Unit.INSTANCE;
    L37:
        lvb.a.b(r16.c, "[applyFeishuAmapStyleSafely] style data is invalid, isDarkMode=" + r2);     // Catch: Throwable -> L39
        goto L45
    L24:
        if (r11.length() <= 0) goto L26;
        r12 = true;
    L29:
        r10 = false;
        goto L30
    L16:
        if (r8.length() <= 0) goto L18;
        r9 = true;
        goto L20
    L8:
        r6 = "recording_amap_style";
    L39:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
