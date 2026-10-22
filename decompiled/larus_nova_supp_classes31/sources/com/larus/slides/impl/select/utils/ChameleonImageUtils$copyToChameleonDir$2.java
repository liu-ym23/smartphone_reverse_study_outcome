package com.larus.slides.impl.select.utils;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.slides.sdk.api.media.ThumbType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.select.utils.ChameleonImageUtils$copyToChameleonDir$2", f = "ChameleonImageUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonImageUtils$copyToChameleonDir$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $maxSizeBytes;
    final /* synthetic */ Function0<String> $obtainRootCacheDir;
    final /* synthetic */ Function1<ThumbType, Unit> $onFinalImageProcess;
    final /* synthetic */ ThumbType $thumbType;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChameleonImageUtils$copyToChameleonDir$2(ThumbType r1, Function1<? super ThumbType, Unit> r2, Function0<String> r3, Long r4, Continuation<? super ChameleonImageUtils$copyToChameleonDir$2> r5) {
        this.$thumbType = r1;
        this.$onFinalImageProcess = r2;
        this.$obtainRootCacheDir = r3;
        this.$maxSizeBytes = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ChameleonImageUtils$copyToChameleonDir$2 r6 = new ChameleonImageUtils$copyToChameleonDir$2(this.$thumbType, this.$onFinalImageProcess, this.$obtainRootCacheDir, this.$maxSizeBytes, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L68;
        ResultKt.throwOnFailure(r18);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        Function0<String> r1 = this.$obtainRootCacheDir;     // Catch: Exception -> L63
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl((String) r1.invoke());     // Catch: Throwable -> L8
    L10:
        Long r7 = null;
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        String r3 = (String) r2;     // Catch: Exception -> L63
        if (r3 != null) goto L22;
        File r4 = AppHost.a.getApplication().getFilesDir();     // Catch: Exception -> L63
        if (r4 == null) goto L18;
        r3 = new PolarisFileWrapper(r4, "web_container").toString();     // Catch: Exception -> L63
    L19:
        if (r3 != null) goto L22;
        return Unit.INSTANCE;
    L18:
        r3 = null;
    L22:
        PolarisFileWrapper r8 = new PolarisFileWrapper(r3, "pic_cache");     // Catch: Exception -> L63
        boolean r9 = false;
        boolean r10 = true;
        if (r8.exists() == true) goto L32;
        boolean r5 = r8.mkdirs();     // Catch: Exception -> L63
        FLogger r11 = FLogger.a;     // Catch: Exception -> L63
        StringBuilder r12 = new StringBuilder("Make dir ");     // Catch: Exception -> L63
        r12.append(r8.getCanonicalPath());     // Catch: Exception -> L63
        r12.append(" result: ");     // Catch: Exception -> L63
        if (r5 == false) goto L27;
        boolean r13 = true;
    L28:
        r12.append(r13);     // Catch: Exception -> L63
        r11.i("ChameleonImageUtils", r12.toString());     // Catch: Exception -> L63
        if (r5 == true) goto L32;
        return Unit.INSTANCE;
    L27:
        r13 = false;
    L32:
        String r14 = this.$thumbType.getSrc();     // Catch: Exception -> L63
        if (r14 == null) goto L61;
        ThumbType r15 = this.$thumbType;     // Catch: Exception -> L63
        Long r16 = this.$maxSizeBytes;     // Catch: Exception -> L63
        if (StringsKt.startsWith$default(r14, "docsource://", false, 2, null) == false) goto L37;
        PolarisFileWrapper r17 = new PolarisFileWrapper(r14.substring(12));     // Catch: Exception -> L63
    L38:
        String r19 = r15.getFileName();     // Catch: Exception -> L63
        if (r19 != null) goto L41;
    L45:
        r19 = r17.getName();     // Catch: Exception -> L63
    L46:
        PolarisFileWrapper r110 = new PolarisFileWrapper(r8, r19);     // Catch: Exception -> L63
        if (r16 == null) goto L55;
        long r111 = r16.longValue();     // Catch: Exception -> L63
        if (r111 > 0) goto L51;
    L53:
        if (r9 == false) goto L55;
        r7 = r16;
        goto L55
    L51:
        if (r17.length() <= r111) goto L53;
        r9 = true;
    L55:
        if (r7 == null) goto L57;
        r10 = ChameleonImageUtils.a(ChameleonImageUtils.a, r17, r110, r7.longValue());     // Catch: Exception -> L63
    L58:
        if (r10 == true) goto L60;
        FLogger.a.w("ChameleonImageUtils", "Copy image failed, fallback to raw copy: " + r17.getCanonicalPath());     // Catch: Exception -> L63
        r.c(r17, r110);     // Catch: Exception -> L63
    L60:
        r15.setSrc("docsource://" + r110.getCanonicalPath());     // Catch: Exception -> L63
        r15.setFileSize(Boxing.boxLong(r110.length()));     // Catch: Exception -> L63
        goto L61
    L57:
        r.c(r17, r110);     // Catch: Exception -> L63
        goto L58
    L41:
        if ((!StringsKt.isBlank(r19)) == true) goto L44;
        r19 = null;
    L44:
        if (r19 != null) goto L46;
    L37:
        r17 = new PolarisFileWrapper(r14);     // Catch: Exception -> L63
    L61:
        this.$onFinalImageProcess.invoke(this.$thumbType);     // Catch: Exception -> L63
    L66:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Exception -> L63
        r2 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L63
    L63:
        e = move-exception;
        FLogger.a.e("ChameleonImageUtils", "copyToChameleonDir error", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        this.$onFinalImageProcess.invoke(this.$thumbType);
        goto L66
    L68:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
