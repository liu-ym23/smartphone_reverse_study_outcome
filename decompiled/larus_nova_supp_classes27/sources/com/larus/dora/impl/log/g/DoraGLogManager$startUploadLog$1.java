package com.larus.dora.impl.log.g;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$startUploadLog$1", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGLogManager$startUploadLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte $logType;
    final /* synthetic */ String $tempFilePath;
    int label;

    public DoraGLogManager$startUploadLog$1(String r1, byte r2, Continuation<? super DoraGLogManager$startUploadLog$1> r3) {
        this.$tempFilePath = r1;
        this.$logType = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGLogManager$startUploadLog$1(this.$tempFilePath, this.$logType, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r12);
        DoraGLogManager r13 = DoraGLogManager.a;
        String r0 = this.$tempFilePath;
        byte r1 = this.$logType;
        long r2 = System.currentTimeMillis();
        PolarisFileWrapper r4 = new PolarisFileWrapper(r0);
        if (r4.exists() == false) goto L7;
        long r8 = r4.length();
    L9:
        if (r8 <= 0) goto L11;
        xs3.a r14 = new xs3.a();
        String r5 = o.a.getDeviceId();
        g49.d.d("DoraGLogManager", "startUploadLog logType:" + r1);
        r14.c(String.valueOf(AppHost.a.getAppId()), r5, String.valueOf(r1), CollectionsKt.listOf(r0), "feedback", null, new j(r2));
    L16:
        return Unit.INSTANCE;
    L11:
        if (r4.exists() == false) goto L13;
        r4.delete();
    L13:
        g49.d.b("DoraGLogManager", "the log file size:" + r8 + " is invalid");
        r13.r(false, "the log file size:" + r8 + " is invalid");
        goto L16
    L7:
        r8 = 0;
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
