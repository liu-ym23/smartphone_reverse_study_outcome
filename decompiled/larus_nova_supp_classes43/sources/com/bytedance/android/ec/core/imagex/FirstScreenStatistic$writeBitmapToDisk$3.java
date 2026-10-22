package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$writeBitmapToDisk$3", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FirstScreenStatistic$writeBitmapToDisk$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bitmapHeight;
    final /* synthetic */ int $bitmapWidth;
    final /* synthetic */ String $cleanUrl;
    final /* synthetic */ Map $extra;
    final /* synthetic */ Bitmap $saveBitmap;
    private /* synthetic */ Object L$0;
    int label;

    public FirstScreenStatistic$writeBitmapToDisk$3(String r1, int r10, int r11, Bitmap r12, Map r13, Continuation r14) {
        this.$cleanUrl = r1;
        this.$bitmapWidth = r10;
        this.$bitmapHeight = r11;
        this.$saveBitmap = r12;
        this.$extra = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        FirstScreenStatistic$writeBitmapToDisk$3 r0 = new FirstScreenStatistic$writeBitmapToDisk$3(this.$cleanUrl, this.$bitmapWidth, this.$bitmapHeight, this.$saveBitmap, this.$extra, r11);
        r0.L$0 = r10;
        return r0;
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L17
        FirstScreenStatistic.S.getClass();     // Catch: Throwable -> L17
        PolarisFileWrapper r13 = new PolarisFileWrapper((File) FirstScreenStatistic.R.getValue(), FirstScreenStatistic.t(this.$cleanUrl));     // Catch: Throwable -> L17
        String r1 = r13.getName() + "###" + StringsKt.padStart(String.valueOf(this.$bitmapWidth), 4, '0') + "_" + StringsKt.padStart(String.valueOf(this.$bitmapHeight), 4, '0');     // Catch: Throwable -> L17
        if (this.$saveBitmap.isRecycled() == true) goto L13;
        boolean r14 = FirstScreenStatistic.s(this.$saveBitmap, new PolarisFileWrapper(r13.getParent(), r1));     // Catch: Throwable -> L17
        if (r14 == true) goto L11;
        FirstScreenStatistic.n("cacheBitmap", "bitmap recycled", null, this.$extra);     // Catch: Throwable -> L17
    L11:
        if (r14 == false) goto L14;
        boolean r15 = true;
    L15:
        Object r16 = Result.constructor-impl(Boxing.boxBoolean(r15));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r16) == false) goto L23;
        FirstScreenStatistic r17 = FirstScreenStatistic.S;
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        Map r19 = this.$extra;
        r17.getClass();
        FirstScreenStatistic.n("cacheBitmap", "save bitmap error", r18, r19);
    L23:
        return Unit.INSTANCE;
    L14:
        r15 = false;
        goto L15
    L13:
        FirstScreenStatistic.n("cacheBitmap", "bitmap recycled", null, this.$extra);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
