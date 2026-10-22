package com.larus.share.impl.util;

import android.content.Context;
import android.os.SystemClock;
import com.larus.platform.service.z2;
import com.larus.security.api.TTCNPAHelper;
import com.larus.security.api.m;
import com.larus.security.api.n;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
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
import org.json.JSONObject;
import tx9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/share/impl/util/AigcImageMetadataOutputHelper$MetadataWriteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.util.AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2", f = "AigcImageMetadataOutputHelper.kt", i = {0, 0, 1, 1}, l = {54, 61}, m = "invokeSuspend", n = {"enabledMetadataInfo", "startTime", "enabledMetadataInfo", "startTime"}, s = {"L$0", "J$0", "L$0", "J$0"})
public final class AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AigcImageMetadataOutputHelper.a>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    final /* synthetic */ com.larus.bmhome.share.panel.f $metadataInfo;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    public AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2(com.larus.bmhome.share.panel.f r1, String r2, Context r3, Continuation<? super AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2> r4) {
        this.$metadataInfo = r1;
        this.$imagePath = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2 r0 = new AigcImageMetadataOutputHelper$writeMetadataIfNeeded$2(this.$metadataInfo, this.$imagePath, this.$context, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AigcImageMetadataOutputHelper.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r6 = null;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        long r4 = this.J$0;
        com.larus.bmhome.share.panel.f r1 = (com.larus.bmhome.share.panel.f) this.L$0;
        ResultKt.throwOnFailure(r19);
        com.larus.bmhome.share.panel.f r10 = r1;
        Object r3 = r19;
    L49:
        n r5 = (n) r3;
        long r13 = SystemClock.elapsedRealtime() - r4;
        if (r5.a == false) goto L52;
        h.b(true, null, r13, false, r10.b, r10.c);
        return new AigcImageMetadataOutputHelper.a(this.$imagePath, true, false);
    L52:
        String r7 = r5.c;
        if (r7 != null) goto L55;
    L58:
        r6 = "write_manifest_failed";
    L59:
        int r8 = AigcImageMetadataOutputHelper.a;
        return AigcImageMetadataOutputHelper.a(this.$imagePath, r6, r13, r10);
    L55:
        if ((!StringsKt.isBlank(r7)) == false) goto L57;
        r6 = r7;
    L57:
        if (r6 != null) goto L59;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r9 = this.J$0;
        r10 = (com.larus.bmhome.share.panel.f) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L32
    L30:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        String r12 = this.$imagePath;
        Throwable r14 = Result.exceptionOrNull-impl(r11);
        if (r14 == null) goto L45;
        FLogger.a.e("AigcImageMetadataOutput", "init ttcnpa failed before writing metadata", r14);
        String r15 = r14.getMessage();
        if (r15 != null) goto L39;
    L42:
        r6 = "init_ttcnpa_failed";
    L43:
        int r16 = AigcImageMetadataOutputHelper.a;
        return AigcImageMetadataOutputHelper.a(r12, r6, SystemClock.elapsedRealtime() - r9, r10);
    L39:
        if ((!StringsKt.isBlank(r15)) == false) goto L41;
        r6 = r15;
    L41:
        if (r6 != null) goto L43;
    L45:
        TTCNPAHelper r17 = TTCNPAHelper.a;
        String r18 = this.$imagePath;
        m r20 = new m(r18, r18, r10.a);
        this.L$0 = r10;
        this.J$0 = r9;
        this.label = 2;
        r3 = r17.d(r20, this);
        if (r3 != r2) goto L48;
        return r2;
    L48:
        r4 = r9;
        goto L49
    L12:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r21 = (CoroutineScope) this.L$0;
        int r22 = AigcImageMetadataOutputHelper.a;
        com.larus.bmhome.share.panel.f r23 = this.$metadataInfo;
        if (r23 != null) goto L16;
    L18:
        r10 = null;
    L20:
        if (r10 == null) goto L22;
        r9 = SystemClock.elapsedRealtime();
        final String r24 = r10.b;
        final int r110 = r10.c;
        JSONObject r111 = new JSONObject();
        Intrinsics.checkNotNullParameter(r24, "produceIdType");
        Intrinsics.checkNotNullParameter(r111, "params");
        h.a("aigc_metadata_write_start", r111, null, new tx9.f(r24, r110));
        if (StringsKt.isBlank(r10.a) == true) goto L26;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L32
        TTCNPAHelper r26 = TTCNPAHelper.a;     // Catch: Throwable -> L32
        this.L$0 = r10;     // Catch: Throwable -> L32
        this.J$0 = r9;     // Catch: Throwable -> L32
        this.label = 1;     // Catch: Throwable -> L32
        r26.getClass();     // Catch: Throwable -> L32
        if (TTCNPAHelper.c("001191110102MACQD9K64010000", "", this) != r2) goto L30;
        return r2;
    L26:
        return AigcImageMetadataOutputHelper.a(this.$imagePath, "empty_produce_id", SystemClock.elapsedRealtime() - r9, r10);
    L22:
        return new AigcImageMetadataOutputHelper.a(this.$imagePath, true, false);
    L16:
        if (z2.a.aigcMetadataConfig().getEnableConversationImageMetadata() == true) goto L19;
        FLogger.a.i("AigcImageMetadataOutput", "manual image metadata disabled by settings");
        goto L18
    L19:
        r10 = r23;
    L32:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }
}
