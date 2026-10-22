package com.larus.dora.impl.feedback;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackFragment$getVideoDurationFromUri$2", f = "DoraGFeedbackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGFeedbackFragment$getVideoDurationFromUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public DoraGFeedbackFragment$getVideoDurationFromUri$2(Context r1, Uri r2, Continuation<? super DoraGFeedbackFragment$getVideoDurationFromUri$2> r3) {
        this.$context = r1;
        this.$uri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraGFeedbackFragment$getVideoDurationFromUri$2 r0 = new DoraGFeedbackFragment$getVideoDurationFromUri$2(this.$context, this.$uri, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static String a(MediaMetadataRetriever r110) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {9};
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r1, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r110.extractMetadata(9);
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        Context r11 = this.$context;
        Uri r0 = this.$uri;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        MediaMetadataRetriever r4 = new MediaMetadataRetriever();     // Catch: Throwable -> L13
        r4.setDataSource(r11, r0);     // Catch: Throwable -> L13
        String r12 = a(r4);     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        Long r13 = StringsKt.toLongOrNull(r12);     // Catch: Throwable -> L13
        if (r13 == null) goto L10;
        long r5 = r13.longValue();     // Catch: Throwable -> L13
    L11:
        r4.release();     // Catch: Throwable -> L13
        Object r14 = Result.constructor-impl(Boxing.boxLong(r5 / ((long) 1000)));     // Catch: Throwable -> L13
    L15:
        Long r1 = Boxing.boxLong(0);
        if (Result.isFailure-impl(r14) == true) goto L18;
        return r14;
    L18:
        return r1;
    L10:
        r5 = 0;
    L13:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
