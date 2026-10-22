package com.larus.disk.impl;

import com.larus.disk.api.ManualCacheCleanError;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
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
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/disk/impl/AppDiskManager$CleanExecutionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$cleanCacheWithResult$2", f = "AppDiskManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1809, 1906}, m = "invokeSuspend", n = {"$this$withContext", "handlerOperationsLocked", "beforeCleanableBytes", "$this$withContext", "interruptionStatus", "handlerOperationsLocked", "beforeCleanableBytes", "startTime", "handlerDiskFlag", "effectiveIsLowDisk", "beforeAppUsedSize", "beforeAppCacheSize", "cacheFilesCleanSucceeded", "configuredPathsCleanSucceeded"}, s = {"L$0", "I$0", "J$0", "L$0", "L$1", "I$0", "J$0", "J$1", "Z$0", "I$1", "J$2", "J$3", "Z$1", "I$2"})
final class AppDiskManager$cleanCacheWithResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppDiskManager$b>, Object> {
    final /* synthetic */ boolean $customBizCacheClean;
    final /* synthetic */ String $expectedAccountScope;
    final /* synthetic */ boolean $isLowDisk;
    final /* synthetic */ boolean $isManual;
    final /* synthetic */ boolean $requireAccountConsistency;
    final /* synthetic */ boolean $requireAppBackground;
    final /* synthetic */ AppDiskManager$CleanScene $scene;
    final /* synthetic */ String $taskId;
    final /* synthetic */ boolean $useExtendedPolicy;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;

    public AppDiskManager$cleanCacheWithResult$2(AppDiskManager$CleanScene r1, boolean r2, boolean r3, boolean r4, String r5, boolean r6, String r7, boolean r8, boolean r9, Continuation<? super AppDiskManager$cleanCacheWithResult$2> r10) {
        this.$scene = r1;
        this.$isManual = r2;
        this.$customBizCacheClean = r3;
        this.$isLowDisk = r4;
        this.$taskId = r5;
        this.$requireAccountConsistency = r6;
        this.$expectedAccountScope = r7;
        this.$requireAppBackground = r8;
        this.$useExtendedPolicy = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        AppDiskManager$cleanCacheWithResult$2 r11 = new AppDiskManager$cleanCacheWithResult$2(this.$scene, this.$isManual, this.$customBizCacheClean, this.$isLowDisk, this.$taskId, this.$requireAccountConsistency, this.$expectedAccountScope, this.$requireAppBackground, this.$useExtendedPolicy, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppDiskManager$b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v8, types: [int] */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r22v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r29v1, types: [boolean] */
    public final Object invokeSuspend(Object r71) {
        AppDiskManager$cleanCacheWithResult$2 r1 = this;
        String r4 = "clearCache error is manual ";
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r1.label;
        if (r6 == 0) goto L29;
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L16;
        int r3 = r1.I$2;
        boolean r7 = r1.Z$1;
        long r9 = r1.J$3;
        long r8 = r1.J$2;
        int r13 = r1.I$1;
        boolean r10 = r1.Z$0;
        String r20 = "failed";
        long r11 = r1.J$1;
        long r12 = r1.J$0;
        int r14 = r1.I$0;
        Ref.ObjectRef r15 = (Ref.ObjectRef) r1.L$1;
        CoroutineScope r16 = (CoroutineScope) r1.L$0;
        ResultKt.throwOnFailure(r71);     // Catch: Throwable -> L9 Exception -> L11 CancellationException -> L13
        r4 = "clearCache error is manual ";
        long r42 = r12;
        String r37 = "partial";
        String r38 = "AppDiskManager";
        boolean r17 = r7;
        int r18 = r3;
        Ref.ObjectRef r2 = r15;
        Object r21 = r71;
        int r110 = r14;
        long r22 = r11;
        ?? r23 = r13;
        long r111 = r8;
        long r112 = r9;
    L383:
        AppDiskManager$d r24 = (AppDiskManager$d) r21;     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L268
        long r25 = com.larus.utils.k.b(AppDiskManager.h());     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L268
        Ref.ObjectRef r26 = r2;
        long r27 = com.larus.utils.k.a(AppDiskManager.h());     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        boolean r72 = r10;
        long r28 = RangesKt.coerceAtLeast(r112 - r27, 0);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        long r60 = System.currentTimeMillis() - r22;
        if (r17 == false) goto L142;
        if (r18 == 0) goto L142;
    L133:
        if ((!r24.b.isEmpty()) == true) goto L142;
        boolean r30 = false;
    L144:
        if (r28 <= 0) goto L146;
    L161:
        boolean r31 = true;
    L162:
        Object r32 = r26.element;     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        if (r32 == null) goto L166;
        if (r31 == false) goto L166;
        AppDiskManager$CleanExecutionStatus r33 = AppDiskManager$CleanExecutionStatus.PARTIAL;     // Catch: Throwable -> L152 Exception -> L155 CancellationException -> L158
    L174:
        r1 = this;
    L280:
        e = e;
        r1 = r1;
    L269:
        String r113 = r38;
    L258:
        Exception r34 = e;
        int r35 = r110;
        long r210 = r42;
    L397:
        FLogger.a.e(r113, r4 + r1.$isManual + " error " + r34);     // Catch: Throwable -> L359
        if (r1.$isManual == false) goto L342;
        boolean r36 = r1.$useExtendedPolicy;     // Catch: Throwable -> L359
        boolean r40 = r1.$isLowDisk;     // Catch: Throwable -> L359
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L331
        AppDiskManager r43 = AppDiskManager.a;     // Catch: Throwable -> L331
        if (r40 == false) goto L323;
        boolean r44 = true;
    L324:
        boolean r45 = AppDiskManager.h0();     // Catch: Throwable -> L331
        if (r36 == false) goto L327;
        boolean r46 = true;
    L328:
        boolean r47 = w.a(r44, r45, r46);     // Catch: Throwable -> L331
        r43.getClass();     // Catch: Throwable -> L331
        if (r36 == false) goto L333;
        AppDiskManager$c r48 = AppDiskManager.B(new j(), new k());     // Catch: Throwable -> L331
    L334:
        Object r50 = Result.constructor-impl(Boxing.boxLong(r48.a));     // Catch: Throwable -> L331
    L338:
        Long r51 = Boxing.boxLong(-1);     // Catch: Throwable -> L359
        if (Result.isFailure-impl(r50) == false) goto L341;
        r50 = r51;
    L341:
        long r211 = ((Number) r50).longValue();     // Catch: Throwable -> L359
    L343:
        int r212 = r1.$scene.getCleanType();     // Catch: Throwable -> L359
        if (r210 >= 0) goto L346;
    L353:
        String r213 = r20;
    L354:
        boolean r52 = r1.$isManual;     // Catch: Throwable -> L359
        boolean r53 = r1.$customBizCacheClean;     // Catch: Throwable -> L359
        Boolean r214 = Boxing.boxBoolean(r1.$isLowDisk);     // Catch: Throwable -> L359
        String r54 = r1.$taskId;     // Catch: Throwable -> L359
        ManualCacheCleanError r55 = ManualCacheCleanError.EXECUTION_FAILED;     // Catch: Throwable -> L359
        i.b(r212, r213, r210, r211, r52, r53, r214, r54, r55, 7168);     // Catch: Throwable -> L359
        AppDiskManager$b r56 = new AppDiskManager$b(AppDiskManager$CleanExecutionStatus.FAILED, r1.$taskId, r55);     // Catch: Throwable -> L359
        if (r35 == 0) goto L357;
        kotlinx.coroutines.sync.a.a.c(AppDiskManager.j());
    L357:
        AppDiskManager.f(AppDiskManager.a);
    L358:
        return r56;
    L346:
        if (0 <= r211) goto L348;
    L350:
        boolean r114 = false;
    L351:
        if (r114 == false) goto L353;
        r213 = r37;
        goto L354
    L348:
        if (r211 >= r210) goto L350;
        r114 = true;
        goto L351
    L333:
        r48 = AppDiskManager.C(r47);     // Catch: Throwable -> L331
        goto L334
    L327:
        r46 = false;
        goto L328
    L323:
        r44 = false;
    L331:
        th = move-exception;
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L359
        r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L359
        goto L338
    L342:
        r211 = -1;
    L359:
        th = move-exception;
        Throwable r58 = th;
    L367:
        int r115 = r35;
    L368:
        if (r115 == 0) goto L370;
        kotlinx.coroutines.sync.a.a.c(AppDiskManager.j());
    L370:
        AppDiskManager.f(AppDiskManager.a);
        throw r58;
    L282:
        e = e;
    L259:
        CancellationException r61 = e;
        int r116 = r110;
    L401:
        throw r61;     // Catch: Throwable -> L365
    L365:
        th = move-exception;
        r58 = th;
        r35 = r116;
    L278:
        th = th;
    L257:
        r58 = th;
        r115 = r110;
        goto L368
    L176:
        if (r1.$isManual == true) goto L410;
        long r215 = -1;
    L195:
        if (r1.$isManual == true) goto L198;
        AppDiskManager.a.getClass();     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
        String r62 = AppDiskManager.Z(r33);     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
    L203:
        String r117 = r62;
    L225:
        AppDiskManager$CleanExecutionStatus r63 = (AppDiskManager$CleanExecutionStatus) r26.element;     // Catch: Throwable -> L278 Exception -> L280 CancellationException -> L282
        if (r18 == 0) goto L228;
        boolean r216 = true;
    L405:
        if ((!r24.b.isEmpty()) == true) goto L234;
        boolean r118 = true;
    L235:
        AppDiskManager$CleanExecutionStatus r64 = r33;
        boolean r65 = r17;
        String r66 = r117;
        boolean r217 = r17;
        long r67 = r112;
        boolean r119 = r118;
        AppDiskManager$CleanExecutionStatus r120 = r33;
        long r68 = r111;
        ManualCacheCleanError r70 = w.b(r64, r63, r65, r216, r119, r1.$isManual, r215);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        String r73 = w.c(r70, r24.b());     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        AppDiskManager r121 = AppDiskManager.a;     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        double r410 = AppDiskManager.r(r121, r68);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        double r411 = AppDiskManager.r(r121, r67);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        double r412 = AppDiskManager.r(r121, r25);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        double r510 = AppDiskManager.r(r121, r27);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        double r511 = AppDiskManager.r(r121, r24.a());     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        double r512 = AppDiskManager.r(r121, r28);     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        if (r23 == 0) goto L240;
        boolean r513 = true;
    L241:
        r1 = this;
        a r74 = new a(r410, r411, r412, r510, r511, r512, r513, r1.$isManual, r1.$customBizCacheClean, r60);     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L268
        r113 = r38;
        FLogger.a.i(r113, "clearCache " + r74 + " status=" + r66);     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L266
        int r218 = r1.$scene.getCleanType();     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L266
        boolean r75 = r1.$isManual;     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L266
        boolean r76 = r1.$customBizCacheClean;     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L266
        if (r23 == 0) goto L247;
        boolean r122 = true;
    L248:
        Boolean r310 = Boxing.boxBoolean(r122);     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L266
        String r123 = r1.$taskId;     // Catch: Throwable -> L260 CancellationException -> L264 Exception -> L266
        boolean r311 = !r217;
        if (r18 != 0) goto L252;
        boolean r312 = true;
    L374:
        i.a(r74, r218, r66, r42, r215, r75, r76, r310, r123, r70, r311, r312, !r24.b.isEmpty());     // Catch: Throwable -> L260 Exception -> L262 CancellationException -> L264
        r56 = new AppDiskManager$b(r120, r1.$taskId, r70, r73);     // Catch: Throwable -> L260 Exception -> L262 CancellationException -> L264
        if (r110 == 0) goto L256;
        kotlinx.coroutines.sync.a.a.c(AppDiskManager.j());
    L256:
        AppDiskManager.f(r121);
        goto L358
    L262:
        e = e;
        goto L258
    L252:
        r312 = false;
        goto L374
    L247:
        r122 = false;
    L266:
        e = e;
        goto L258
    L240:
        r513 = false;
        goto L241
    L234:
        r118 = false;
    L276:
        e = e;
        r1 = r1;
        r113 = r38;
        goto L258
    L228:
        r216 = false;
        goto L405
    L191:
        CancellationException e = e;
    L160:
        CancellationException r77 = e;
    L208:
        r14 = r110;
    L209:
        r116 = r14;
    L210:
        r61 = r77;
    L189:
        Exception e2 = e;
    L157:
        Exception r78 = e2;
    L207:
        r35 = r110;
        r113 = r38;
        r210 = r42;
        AppDiskManager$cleanCacheWithResult$2 r610 = r1;
        r34 = r78;
        r1 = r610;
    L187:
        Throwable th = th;
    L154:
        Throwable r80 = th;
    L204:
        r14 = r110;
    L205:
        r115 = r14;
    L206:
        r58 = r80;
        goto L368
    L198:
        AppDiskManager$CleanExecutionStatus r81 = AppDiskManager$CleanExecutionStatus.COMPLETED;     // Catch: Throwable -> L278 Exception -> L280 CancellationException -> L282
        if (r33 != r81) goto L212;
        if (r215 != 0) goto L212;
        r62 = FlowDoraConnectReason.SUCCESS;
    L212:
        if (0 <= r215) goto L214;
    L216:
        boolean r82 = false;
    L217:
        if (r82 == false) goto L220;
    L223:
        r117 = r37;
        goto L225
    L220:
        if (r33 == AppDiskManager$CleanExecutionStatus.PARTIAL) goto L223;
        if (r33 == r81) goto L223;
        r117 = r20;
        goto L225
    L214:
        if (r215 >= r42) goto L216;
        r82 = true;
        goto L217
    L410:
        AppDiskManager r83 = AppDiskManager.a;     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
        boolean r84 = r1.$useExtendedPolicy;     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
        if (r72 == false) goto L180;
        boolean r219 = true;
    L181:
        r83.getClass();     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
        if (r84 == false) goto L184;
        AppDiskManager$c r85 = AppDiskManager.B(new j(), new k());     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
    L186:
        r215 = r85.a;     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
        goto L195
    L184:
        r85 = AppDiskManager.C(r219);     // Catch: Throwable -> L187 Exception -> L189 CancellationException -> L191
        goto L186
    L180:
        r219 = false;
    L166:
        if (r32 == null) goto L168;
        r33 = (AppDiskManager$CleanExecutionStatus) r32;     // Catch: Throwable -> L152 Exception -> L155 CancellationException -> L158
        goto L174
    L168:
        if (r30 == true) goto L170;
        r33 = AppDiskManager$CleanExecutionStatus.COMPLETED;     // Catch: Throwable -> L152 Exception -> L155 CancellationException -> L158
        goto L174
    L170:
        if (r31 == false) goto L173;
        r33 = AppDiskManager$CleanExecutionStatus.PARTIAL;     // Catch: Throwable -> L152 Exception -> L155 CancellationException -> L158
        goto L174
    L173:
        r33 = AppDiskManager$CleanExecutionStatus.FAILED;     // Catch: Throwable -> L270 Exception -> L272 CancellationException -> L274
        goto L174
    L146:
        if (r111 > r25) goto L161;
    L158:
        e = e;
        r1 = this;
    L155:
        e2 = e;
        r1 = this;
    L152:
        th = th;
        r1 = this;
        goto L154
    L149:
        if (r24.a() > 0) goto L161;
        r31 = false;
    L140:
        e = move-exception;
        r77 = e;
        r1 = this;
    L138:
        e = move-exception;
        r78 = e;
        r1 = this;
    L136:
        th = move-exception;
        r80 = th;
        r1 = this;
    L142:
        r30 = true;
    L274:
        e = e;
    L272:
        e = e;
        r1 = this;
        r113 = r38;
    L270:
        th = th;
    L268:
        e = e;
    L264:
        e = e;
    L260:
        th = th;
        goto L257
    L13:
        e = e;
    L28:
        r77 = e;
    L11:
        e = move-exception;
        r34 = e;
        r4 = "clearCache error is manual ";
        r37 = "partial";
        r38 = "AppDiskManager";
    L115:
        r210 = r12;
        r35 = r14;
        r113 = r38;
    L9:
        th = th;
    L22:
        r80 = th;
        goto L205
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r20 = "failed";
        long r86 = r1.J$0;
        r35 = r1.I$0;
        CoroutineScope r87 = (CoroutineScope) r1.L$0;
        ResultKt.throwOnFailure(r71);     // Catch: Throwable -> L20 Exception -> L23 CancellationException -> L26
        CoroutineScope r88 = r87;
        long r90 = r86;
    L403:
        FLogger.a.i("AppDiskManager", "clearCache start, scene=" + r1.$scene);     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        Ref.ObjectRef r91 = new Ref.ObjectRef();     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        if (r1.$requireAccountConsistency == false) goto L52;
        String r124 = r1.$expectedAccountScope;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        if (r124 == null) goto L43;
        Lazy r125 = d.a;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        if (Intrinsics.areEqual(r124, d.c()) == true) goto L52;
    L43:
        int r220 = r1.$scene.getCleanType();     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        AppDiskManager r92 = AppDiskManager.a;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        AppDiskManager$CleanExecutionStatus r93 = AppDiskManager$CleanExecutionStatus.ACCOUNT_CHANGED;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        r92.getClass();     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        String r221 = AppDiskManager.Z(r93);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        boolean r94 = r1.$customBizCacheClean;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        Boolean r222 = Boxing.boxBoolean(r1.$isLowDisk);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        String r95 = r1.$taskId;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        ManualCacheCleanError r126 = ManualCacheCleanError.ACCOUNT_CHANGED;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        i.b(r220, r221, 0, 0, false, r94, r222, r95, r126, 7192);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        AppDiskManager$b r96 = new AppDiskManager$b(r93, r1.$taskId, r126);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
    L56:
        kotlinx.coroutines.sync.a.a.c(AppDiskManager.j());
        AppDiskManager.f(r92);
        return r96;
    L47:
        e = move-exception;
        r34 = e;
        r4 = "clearCache error is manual ";
        r210 = r90;
        r37 = "partial";
        r113 = "AppDiskManager";
        r35 = 1;
    L49:
        e = move-exception;
        r116 = 1;
        r1 = r1;
        r77 = e;
    L45:
        th = move-exception;
        r115 = 1;
        r1 = r1;
        r80 = th;
    L52:
        if (r1.$requireAppBackground == true) goto L54;
    L59:
        long r127 = System.currentTimeMillis();     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        boolean r97 = r1.$isLowDisk;     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        if (r1.$useExtendedPolicy == false) goto L64;
        if (r97 == true) goto L63;
        boolean r98 = true;
    L65:
        r10 = w.a(r97, r98, r1.$useExtendedPolicy);     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        boolean r100 = r1.$useExtendedPolicy;     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        if (r100 == true) goto L379;
        long r223 = r90;
        if (r10 == true) goto L74;
        ?? r128 = 1;
    L381:
        if (r1.$isManual == true) goto L393;
        long r101 = r223;
    L372:
        r37 = "partial";
        r38 = "AppDiskManager";
        long r129 = com.larus.utils.k.b(AppDiskManager.h());     // Catch: Exception -> L293 Throwable -> L303 CancellationException -> L307
        r4 = "clearCache error is manual ";
        long r102 = com.larus.utils.k.a(AppDiskManager.h());     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        AppDiskManager r103 = AppDiskManager.a;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r17 = AppDiskManager.b(r103, r128, r1.$isManual, r1.$customBizCacheClean, r1.$useExtendedPolicy, new AppDiskManager$cleanCacheWithResult$2$cacheFilesCleanSucceeded$1(r1.$isManual, r1.$requireAccountConsistency, r1.$expectedAccountScope, r1.$requireAppBackground, r91));     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        if (r1.$isManual == false) goto L102;
    L99:
        e = move-exception;
        r34 = e;
        r12 = r101;
    L114:
        r14 = 1;
        goto L115
    L97:
        if (r1.$useExtendedPolicy == false) goto L102;
    L103:
        int r104 = 1;
    L105:
        if (r10 == false) goto L107;
        boolean r313 = true;
    L108:
        boolean r105 = r1.$isManual;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        String r130 = r1.$expectedAccountScope;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        if (r130 != null) goto L117;
        Lazy r131 = d.a;     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L99
        r130 = d.c();     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L99
    L117:
        String r314 = r130;
        boolean r132 = r1.$useExtendedPolicy;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        String r133 = r1.$taskId;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        int r315 = r1.$scene.getCleanType();     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        AppDiskManager$cleanCacheWithResult$2$handlerResult$1 r316 = new AppDiskManager$cleanCacheWithResult$2$handlerResult$1(r1.$isManual, r1.$requireAccountConsistency, r1.$expectedAccountScope, r1.$requireAppBackground, r91);     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.L$0 = r88;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.L$1 = r91;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.I$0 = 1;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.J$0 = r101;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.J$1 = r127;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.Z$0 = r10;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.I$1 = r128;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.J$2 = r129;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.J$3 = r102;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.Z$1 = r17;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.I$2 = r104;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r1.label = 2;     // Catch: Exception -> L290 Throwable -> L303 CancellationException -> L307
        r21 = AppDiskManager.c(r103, r128, r313, r105, r314, r132, r133, r315, r316);     // Catch: Exception -> L287 Throwable -> L303 CancellationException -> L307
    L122:
        if (r21 != r5) goto L124;
        return r5;
    L124:
        r112 = r102;
        r42 = r101;
        r23 = r128;
        r22 = r127;
        r111 = r129;
        r110 = 1;
        r18 = r104;
        r2 = r91;
    L287:
        e = e;
    L291:
        r113 = r38;
    L289:
        r34 = e;
        long r106 = r101;
    L306:
        r210 = r106;
        r35 = 1;
        goto L397
    L107:
        r313 = false;
    L102:
        if (AppDiskManager.d(r103, r1.$useExtendedPolicy, new AppDiskManager$cleanCacheWithResult$2$configuredPathsCleanSucceeded$1(r1.$isManual, r1.$requireAccountConsistency, r1.$expectedAccountScope, r1.$requireAppBackground, r91)) == true) goto L103;
        r104 = 0;
    L290:
        e = e;
    L293:
        e = e;
        r4 = "clearCache error is manual ";
    L295:
        e = e;
        r4 = "clearCache error is manual ";
        r37 = "partial";
        r113 = "AppDiskManager";
        goto L289
    L393:
        AppDiskManager r107 = AppDiskManager.a;     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L87
        if (r10 == false) goto L80;
        boolean r134 = true;
    L81:
        r107.getClass();     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L87
        if (r100 == false) goto L84;
        AppDiskManager$c r108 = AppDiskManager.B(new j(), new k());     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L87
    L85:
        r101 = r108.a;     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L87
        goto L372
    L84:
        r108 = AppDiskManager.C(r134);     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L87
        goto L85
    L80:
        r134 = false;
    L87:
        e = move-exception;
        r34 = e;
        r4 = "clearCache error is manual ";
        r37 = "partial";
        r38 = "AppDiskManager";
        r12 = r223;
    L298:
        e = e;
    L302:
        r37 = "partial";
        r113 = "AppDiskManager";
        r34 = e;
        r106 = r223;
        goto L306
    L74:
        r128 = 0;
        goto L381
    L379:
        r223 = r90;
        r128 = r1.$isLowDisk;     // Catch: Throwable -> L45 CancellationException -> L49 Exception -> L69
    L69:
        e = move-exception;
        r34 = e;
        r4 = "clearCache error is manual ";
        r12 = r90;
        r37 = "partial";
        r38 = "AppDiskManager";
        goto L114
    L63:
        r98 = false;
        goto L65
    L64:
        r98 = AppDiskManager.h0();     // Catch: Exception -> L300 Throwable -> L303 CancellationException -> L307
        goto L65
    L54:
        if (AppDiskManager.g() == true) goto L59;
        int r224 = r1.$scene.getCleanType();     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        r92 = AppDiskManager.a;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        AppDiskManager$CleanExecutionStatus r109 = AppDiskManager$CleanExecutionStatus.APP_FOREGROUND;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        r92.getClass();     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        String r225 = AppDiskManager.Z(r109);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        boolean r135 = r1.$customBizCacheClean;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        Boolean r226 = Boxing.boxBoolean(r1.$isLowDisk);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        String r136 = r1.$taskId;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        ManualCacheCleanError r137 = ManualCacheCleanError.APP_FOREGROUND;     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        i.b(r224, r225, 0, 0, false, r135, r226, r136, r137, 7192);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
        r96 = new AppDiskManager$b(r109, r1.$taskId, r137);     // Catch: Throwable -> L45 Exception -> L47 CancellationException -> L49
    L300:
        e = e;
        r223 = r90;
    L307:
        e = move-exception;
        r61 = e;
        r116 = 1;
    L303:
        th = move-exception;
        r58 = th;
        r115 = 1;
        goto L368
    L26:
        e = e;
        r14 = r35;
    L23:
        e = move-exception;
        r34 = e;
        r4 = "clearCache error is manual ";
        r210 = r86;
        r37 = "partial";
        r113 = "AppDiskManager";
    L20:
        th = th;
        r14 = r35;
        goto L22
    L29:
        r20 = "failed";
        ResultKt.throwOnFailure(r71);
        CoroutineScope r138 = (CoroutineScope) r1.L$0;
        AppDiskManager r139 = AppDiskManager.a;
        if (AppDiskManager.s(r139) == true) goto L418;
        FLogger.a.i("AppDiskManager", "clearCache: is clearing");
        int r140 = r1.$scene.getCleanType();
        AppDiskManager$CleanExecutionStatus r141 = AppDiskManager$CleanExecutionStatus.TASK_RUNNING;
        String r142 = AppDiskManager.k(r139, r141);
        boolean r143 = r1.$isManual;
        boolean r144 = r1.$customBizCacheClean;
        Boolean r145 = Boxing.boxBoolean(r1.$isLowDisk);
        String r146 = r1.$taskId;
        ManualCacheCleanError r147 = ManualCacheCleanError.TASK_RUNNING;
        i.b(r140, r142, 0, 0, r143, r144, r145, r146, r147, 7192);
        return new AppDiskManager$b(r141, r1.$taskId, r147);
    L418:
        MutexImpl r148 = AppDiskManager.j();     // Catch: Exception -> L311 Throwable -> L313 CancellationException -> L361
        r1.L$0 = r138;     // Catch: Exception -> L311 Throwable -> L313 CancellationException -> L361
        r1.I$0 = 0;     // Catch: Exception -> L311 Throwable -> L313 CancellationException -> L361
        r1.J$0 = -1;     // Catch: Exception -> L311 Throwable -> L313 CancellationException -> L361
        r1.label = 1;     // Catch: Exception -> L311 Throwable -> L313 CancellationException -> L361
        if (kotlinx.coroutines.sync.a.a.a(r148, r1) != r5) goto L36;
        return r5;
    L36:
        r88 = r138;
        r90 = -1;
        goto L403
    L361:
        e = move-exception;
        r61 = e;
        r116 = 0;
    L311:
        e = move-exception;
        r4 = "clearCache error is manual ";
        r37 = "partial";
        r113 = "AppDiskManager";
        r34 = e;
        r35 = 0;
        r210 = -1;
    L313:
        th = move-exception;
        r58 = th;
        r115 = 0;
        goto L368
    }

    public static final boolean access$invokeSuspend$shouldContinue(boolean r0, boolean r1, String r2, boolean r3, Ref.ObjectRef r4) {
        if (r0 == true) goto L17;
        if (r1 == false) goto L9;
        if (r2 == null) goto L8;
        Lazy r5 = d.a;
        if (Intrinsics.areEqual(r2, d.c()) == true) goto L9;
    L8:
        AppDiskManager$CleanExecutionStatus r6 = AppDiskManager$CleanExecutionStatus.ACCOUNT_CHANGED;
    L14:
        if (r6 == null) goto L16;
        r4.element = r6;
    L16:
        if (r6 == null) goto L17;
        return false;
    L9:
        if (r3 == true) goto L11;
    L13:
        r6 = null;
        goto L14
    L11:
        if (AppDiskManager.u == true) goto L13;
        r6 = AppDiskManager$CleanExecutionStatus.APP_FOREGROUND;
    L17:
        return true;
    }
}
