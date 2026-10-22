package com.larus.uaigc.helper;

import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/uaigc/helper/CreationImageUploadPolicy$ReusablePreprocessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageUploadPolicy$findReusablePreprocessResult$2$1", f = "CreationImageUploadPolicy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationImageUploadPolicy$findReusablePreprocessResult$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CreationImageUploadPolicy.b>, Object> {
    final /* synthetic */ m.a $candidate;
    final /* synthetic */ File $file;
    final /* synthetic */ String $filePath;
    final /* synthetic */ long $fileSize;
    final /* synthetic */ CreationImageUploadPolicy $this_runCatching;
    int label;

    public CreationImageUploadPolicy$findReusablePreprocessResult$2$1(m.a r1, File r2, long r3, String r5, CreationImageUploadPolicy r6, Continuation<? super CreationImageUploadPolicy$findReusablePreprocessResult$2$1> r7) {
        this.$candidate = r1;
        this.$file = r2;
        this.$fileSize = r3;
        this.$filePath = r5;
        this.$this_runCatching = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CreationImageUploadPolicy$findReusablePreprocessResult$2$1(this.$candidate, this.$file, this.$fileSize, this.$filePath, this.$this_runCatching, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super CreationImageUploadPolicy.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L41;
        ResultKt.throwOnFailure(r18);
        FLogger.a.i(CreationImageUploadPolicy.b, "findReusablePreprocessResult candidate: " + this.$candidate);
        ImFileUtil r0 = ImFileUtil.a;
        File r2 = this.$file;
        r0.getClass();
        String r1 = ImFileUtil.g(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        m r3 = m.a;
        m.a r4 = this.$candidate;
        monitor-enter(r3);
        Intrinsics.checkNotNullParameter(r4, "record");     // Catch: Throwable -> L37
        if (StringsKt.isBlank(r1) == false) goto L14;
        monitor-exit(r3);
    L21:
        r4 = null;
    L24:
        if (r4 == null) goto L45;
        ic8.m0 r15 = new ic8.m0(this.$filePath, null, r4.d, r4.e, r4.c, null, null, 16354);
        CreationImageUploadPolicy r6 = this.$this_runCatching;
        String r5 = r4.f;
        r6.getClass();
        ProcessFileResultCode[] r7 = ProcessFileResultCode.values();
        int r8 = r7.length;
        int r9 = 0;
    L27:
        if (r9 >= r8) goto L32;
        ProcessFileResultCode r10 = r7[r9];
        if (Intrinsics.areEqual(r10.getValue(), r5) == true) goto L33;
        r9 = r9 + 1;
    L33:
        if (r10 != null) goto L36;
        r10 = ProcessFileResultCode.SUCCESS;
    L36:
        return new CreationImageUploadPolicy.b(new ic8.n0(r15, r10), this.$fileSize, r1);
    L32:
        r10 = null;
        goto L33
    L45:
        return new CreationImageUploadPolicy.b(null, this.$fileSize, r1);
    L14:
        if (Intrinsics.areEqual(r4.b, r1) == true) goto L18;
        monitor-exit(r3);
        goto L21
    L18:
        if (m.d(r4) == true) goto L22;
        r3.f(r4.a);     // Catch: Throwable -> L37
        monitor-exit(r3);
        goto L21
    L22:
        m.h(r4);     // Catch: Throwable -> L37
        monitor-exit(r3);
    L37:
        th = move-exception;
        throw th;
    L41:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
