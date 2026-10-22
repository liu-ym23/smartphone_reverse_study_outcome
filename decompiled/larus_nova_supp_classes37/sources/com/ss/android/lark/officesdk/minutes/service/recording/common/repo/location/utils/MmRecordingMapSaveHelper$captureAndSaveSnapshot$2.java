package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper$captureAndSaveSnapshot$2", f = "MmRecordingMapSaveHelper.kt", i = {0, 1, 2}, l = {353, 492, 393}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout", "newBitmap"}, s = {"L$0", "L$0", "L$0"})
final class MmRecordingMapSaveHelper$captureAndSaveSnapshot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ double $latitude;
    final /* synthetic */ double $longitude;
    final /* synthetic */ IPickLocationMap $map;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public static final class a implements IPickLocationMap.c {
        public final /* synthetic */ MmRecordingMapSaveHelper a;
        public final /* synthetic */ i<Bitmap> b;

        public final void onMapScreenShot(Bitmap r4) {
            if (r4 != null) goto L4;
            lvb.a.b(this.a.c, "[captureAndSaveSnapshot] Bitmap is null");
        L4:
            lvb.a.e(this.a.c, "[captureAndSaveSnapshot] isActive=" + this.b.isActive());
            if (this.b.isActive() == false) goto L8;
            this.b.resumeWith(Result.constructor-impl(r4));
            return;
        }

        public a(MmRecordingMapSaveHelper r1, j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public MmRecordingMapSaveHelper$captureAndSaveSnapshot$2(MmRecordingMapSaveHelper r1, String r2, IPickLocationMap r3, double r4, double r6, Context r8, Continuation<? super MmRecordingMapSaveHelper$captureAndSaveSnapshot$2> r9) {
        this.this$0 = r1;
        this.$fileName = r2;
        this.$map = r3;
        this.$latitude = r4;
        this.$longitude = r6;
        this.$context = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        MmRecordingMapSaveHelper$captureAndSaveSnapshot$2 r10 = new MmRecordingMapSaveHelper$captureAndSaveSnapshot$2(this.this$0, this.$fileName, this.$map, this.$latitude, this.$longitude, this.$context, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        Bitmap r2 = (Bitmap) this.L$0;
        ResultKt.throwOnFailure(r14);
    L58:
        boolean r15 = ((Boolean) r14).booleanValue();
        if (r15 == false) goto L61;
        lvb.a.e(this.this$0.c, "[captureAndSaveSnapshot] success, bitmap=[" + r2.getWidth() + ", " + r2.getHeight() + "], fileName=" + this.$fileName);
    L63:
        return Boxing.boxBoolean(r15);
    L61:
        lvb.a.b(this.this$0.c, "[captureAndSaveSnapshot] save failed, fileName=" + this.$fileName);
        goto L63
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        MmRecordingMapSaveHelper r3 = (MmRecordingMapSaveHelper) this.L$2;
        IPickLocationMap r4 = (IPickLocationMap) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L27:
        Bitmap r16 = (Bitmap) r14;
        if (r16 != null) goto L30;
    L64:
        lvb.a.b(this.this$0.c, "[captureAndSaveSnapshot] Bitmap is null or invalid");
        return Boxing.boxBoolean(false);
    L30:
        if (r16.getWidth() <= 0) goto L64;
        if (r16.getHeight() <= 0) goto L64;
        MmRecordingMapSaveHelper r6 = this.this$0;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L45
        int r8 = (r16.getHeight() - ((Number) r6.f.getValue()).intValue()) / 2;     // Catch: Throwable -> L45
        if (r16.getWidth() <= MmRecordingMapSaveHelper.b(r6)) goto L38;
        int r9 = (r16.getWidth() - MmRecordingMapSaveHelper.b(r6)) / 2;     // Catch: Throwable -> L45
    L40:
        if (r16.getWidth() <= MmRecordingMapSaveHelper.b(r6)) goto L42;
        int r10 = MmRecordingMapSaveHelper.b(r6);     // Catch: Throwable -> L45
    L43:
        Object r17 = Result.constructor-impl(Bitmap.createBitmap(r16, r9, r8, r10, ((Number) r6.f.getValue()).intValue()));     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r17) == false) goto L50;
        r17 = null;
    L50:
        Bitmap r18 = (Bitmap) r17;
        if (r18 == null) goto L53;
        MmRecordingMapSaveHelper r11 = this.this$0;
        Context r12 = this.$context;
        String r13 = this.$fileName;
        this.L$0 = r18;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        int r19 = MmRecordingMapSaveHelper.m;
        r11.getClass();
        Object r20 = BuildersKt.withContext(Dispatchers.getIO(), new MmRecordingMapSaveHelper$saveBitmapToFile$2(r12, r13, r18, r11, null), this);
        if (r20 != r0) goto L57;
        return r0;
    L57:
        r2 = r18;
        r14 = r20;
        goto L58
    L53:
        return Boxing.boxBoolean(false);
    L42:
        r10 = r16.getWidth();     // Catch: Throwable -> L45
        goto L43
    L38:
        r9 = 0;
    L45:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L11:
        CoroutineScope r22 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L15:
        IPickLocationMap r110 = this.$map;
        MmRecordingMapSaveHelper r23 = this.this$0;
        this.L$0 = r22;
        this.L$1 = r110;
        this.L$2 = r23;
        this.label = 2;
        j r24 = new j(IntrinsicsKt.intercepted(this), 1);
        r24.C();
        r110.n(new a(r23, r24));     // Catch: Throwable -> L18
    L22:
        r14 = r24.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(this);
    L25:
        if (r14 != r0) goto L27;
        return r0;
    L18:
        th = move-exception;
        lvb.a.b(r23.c, "[captureAndSaveSnapshot] Operation failed, error=" + th.getMessage());
        if (r24.isActive() == false) goto L22;
        r24.resumeWith(Result.constructor-impl(null));
        goto L22
    L12:
        ResultKt.throwOnFailure(r14);
        r22 = (CoroutineScope) this.L$0;
        lvb.a.e(this.this$0.c, "[captureAndSaveSnapshot] start fileName=" + this.$fileName);
        this.$map.f(this.$latitude, this.$longitude, null);
        long r25 = this.this$0.d;
        this.L$0 = r22;
        this.label = 1;
        if (DelayKt.delay(r25, this) != r0) goto L15;
        return r0;
    }
}
