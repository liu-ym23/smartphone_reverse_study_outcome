package com.larus.bmhome.utils;

import android.content.Context;
import android.net.Uri;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.ImFileUtil$isAudioFileOverDuration$2", f = "ImFileUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImFileUtil$isAudioFileOverDuration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    int label;

    public ImFileUtil$isAudioFileOverDuration$2(Context r1, Uri r2, Continuation<? super ImFileUtil$isAudioFileOverDuration$2> r3) {
        this.$context = r1;
        this.$uri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImFileUtil$isAudioFileOverDuration$2(this.$context, this.$uri, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r6);
        ImFileUtil r7 = ImFileUtil.a;
        Context r0 = this.$context;
        Uri r1 = this.$uri;
        r7.getClass();
        Long r8 = ImFileUtil.d(r0, r1);
        boolean r2 = false;
        if (r8 == null) goto L14;
        long r3 = r8.longValue();
        if (r3 > 0) goto L9;
    L10:
        r2 = true;
    L12:
        return Boxing.boxBoolean(r2);
    L9:
        if (r3 <= ((Number) ImFileUtil.p.getValue()).longValue()) goto L12;
    L14:
        return Boxing.boxBoolean(false);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
