package com.larus.dora.obric.device_management.setting.g.feedback;

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
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.feedback.DoraObricGFeedbackFragment$getVideoDurationFromUri$2", f = "DoraObricGFeedbackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGFeedbackFragment$getVideoDurationFromUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public DoraObricGFeedbackFragment$getVideoDurationFromUri$2(Context r1, Uri r2, Continuation<? super DoraObricGFeedbackFragment$getVideoDurationFromUri$2> r3) {
        this.$context = r1;
        this.$uri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraObricGFeedbackFragment$getVideoDurationFromUri$2 r0 = new DoraObricGFeedbackFragment$getVideoDurationFromUri$2(this.$context, this.$uri, r5);
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

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        MediaMetadataRetriever r9 = new MediaMetadataRetriever();
        Context r0 = this.$context;
        Uri r1 = this.$uri;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        r9.setDataSource(r0, r1);     // Catch: Throwable -> L13
        String r2 = a(r9);     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        Long r3 = StringsKt.toLongOrNull(r2);     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        long r5 = r3.longValue();     // Catch: Throwable -> L13
    L11:
        Object r6 = Result.constructor-impl(Boxing.boxLong(r5 / ((long) 1000)));     // Catch: Throwable -> L13
    L25:
        r9.release();     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Long r10 = Boxing.boxLong(0);
        if (Result.isFailure-impl(r6) == true) goto L22;
        return r6;
    L22:
        return r10;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        r5 = 0;
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
