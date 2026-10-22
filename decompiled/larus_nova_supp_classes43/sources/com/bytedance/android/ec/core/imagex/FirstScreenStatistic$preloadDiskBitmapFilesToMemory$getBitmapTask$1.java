package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$preloadDiskBitmapFilesToMemory$getBitmapTask$1", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FirstScreenStatistic$preloadDiskBitmapFilesToMemory$getBitmapTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ HashMap $extra;
    final /* synthetic */ File $file;
    final /* synthetic */ int $height;
    final /* synthetic */ String $md5Name;
    final /* synthetic */ int $width;
    int label;

    public FirstScreenStatistic$preloadDiskBitmapFilesToMemory$getBitmapTask$1(String r1, File r10, int r11, int r12, HashMap r13, Continuation r14) {
        this.$md5Name = r1;
        this.$file = r10;
        this.$width = r11;
        this.$height = r12;
        this.$extra = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new FirstScreenStatistic$preloadDiskBitmapFilesToMemory$getBitmapTask$1(this.$md5Name, this.$file, this.$width, this.$height, this.$extra, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r10);
        FirstScreenStatistic r11 = FirstScreenStatistic.S;     // Catch: Exception -> L15
        ConcurrentHashMap<String, p0> r0 = FirstScreenStatistic.N;     // Catch: Exception -> L15
        p0 r1 = r0.get(this.$md5Name);     // Catch: Exception -> L15
        if (r1 == null) goto L8;
        r1.a = System.currentTimeMillis();     // Catch: Exception -> L15
    L8:
        Bitmap r12 = FirstScreenStatistic.b(r11, this.$file, this.$width, this.$height);     // Catch: Exception -> L15
        if (r12 == null) goto L11;
        FirstScreenStatistic.O.putIfAbsent(this.$md5Name, r12);     // Catch: Exception -> L15
    L11:
        p0 r13 = r0.get(this.$md5Name);     // Catch: Exception -> L15
        if (r13 == null) goto L22;
        r13.b = System.currentTimeMillis();     // Catch: Exception -> L15
        return r12;
    L22:
        return r12;
    L15:
        e = move-exception;
        FirstScreenStatistic r14 = FirstScreenStatistic.S;
        HashMap r15 = this.$extra;
        r14.getClass();
        FirstScreenStatistic.n("preloadDiskBitmapFilesToMemory", "getBitmapTask error", e, r15);
        return null;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
