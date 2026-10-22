package com.larus.dora.impl.feedback;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackLog$submit$1", f = "DoraGFeedbackViewModel.kt", i = {2, 3, 3}, l = {969, 984, 1017, 1027}, m = "invokeSuspend", n = {"waitTime", "uploadSucceeded", "uploadError"}, s = {"J$0", "L$0", "L$1"})
final class DoraFeedbackLog$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $logFetchEnded;
    final /* synthetic */ Ref.LongRef $logUploadEnded;
    final /* synthetic */ Ref.LongRef $p2pConnectedTime;
    final /* synthetic */ long $startTime;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ l this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraFeedbackLog$submit$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackLog$submit$1$2", f = "DoraGFeedbackViewModel.kt", i = {0, 0, 1, 1}, l = {1033, 1039, 1045}, m = "invokeSuspend", n = {"appLogDeferred", "attempt", "appLogDeferred", "attempt"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $logUploadEnded;
        final /* synthetic */ Ref.ObjectRef<Exception> $uploadError;
        final /* synthetic */ Ref.BooleanRef $uploadSucceeded;
        int I$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ l this$0;

        public AnonymousClass2(l r1, Ref.BooleanRef r2, Ref.ObjectRef<Exception> r3, Ref.LongRef r4, Continuation<? super AnonymousClass2> r5) {
            this.this$0 = r1;
            this.$uploadSucceeded = r2;
            this.$uploadError = r3;
            this.$logUploadEnded = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass2 r6 = new AnonymousClass2(this.this$0, this.$uploadSucceeded, this.$uploadError, this.$logUploadEnded, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0083 -> B:30:0x0099). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0096 -> B:30:0x0099). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            l r2 = (l) this.L$0;
            ResultKt.throwOnFailure(r14);
        L37:
            r2.f = ((Boolean) r14).booleanValue();
        L40:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r3 = this.I$0;
            Deferred r6 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r14);
            Deferred r7 = r6;
            int r8 = r3;
            Object r4 = r0;
            AnonymousClass2 r5 = this;
        L30:
            AnonymousClass2 r15 = r5;
            r0 = r4;
            int r9 = r8 + 1;
            Deferred r10 = r7;
        L17:
            if (r9 >= 3) goto L32;
            l r11 = r15.this$0;     // Catch: Exception -> L23
            String r12 = r11.d;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r12);     // Catch: Exception -> L23
            r15.L$0 = r10;     // Catch: Exception -> L23
            r15.I$0 = r9;     // Catch: Exception -> L23
            r15.label = 1;     // Catch: Exception -> L23
            if (l.b(r11, r12, r15) != r0) goto L21;
            return r0;
        L21:
            r15.$uploadSucceeded.element = true;     // Catch: Exception -> L23
        L23:
            e = move-exception;
            Object r13 = r0;
            r5 = r15;
            Exception e = e;
            r7 = r10;
            r8 = r9;
            r4 = r13;
        L25:
            r5.$uploadError.element = e;
            if (r8 >= 2) goto L30;
            r5.L$0 = r7;
            r5.I$0 = r8;
            r5.label = 2;
            if (DelayKt.delay(((long) (r8 + 1)) * 1000, r5) != r4) goto L30;
            return r4;
        L32:
            if (r15.$uploadSucceeded.element == false) goto L38;
            Ref.LongRef r16 = r15.$logUploadEnded;
            r16.element = System.currentTimeMillis();
            l r17 = r15.this$0;
            r15.L$0 = r17;
            r15.label = 3;
            r14 = r10.await(r15);
            if (r14 != r0) goto L36;
            return r0;
        L36:
            r2 = r17;
            goto L37
        L38:
            Job.DefaultImpls.cancel$default(r10, null, 1, null);
            goto L40
        L11:
            r9 = this.I$0;
            r10 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L14
            r15 = this;
        L14:
            e = e;
            r7 = r10;
            r8 = r9;
            r4 = r0;
            r5 = this;
            goto L25
        L16:
            ResultKt.throwOnFailure(r14);
            r9 = 0;
            r10 = BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new DoraFeedbackLog$submit$1$2$appLogDeferred$1(this.this$0, null), 3, null);
            r15 = this;
            goto L17
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LogState.values().length];
            r0[LogState.ON_BUILDING_P2P_CONNECTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LogState.ON_FETCHING_LOGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LogState.ON_UPLOADING_LOGS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public DoraFeedbackLog$submit$1(l r1, Ref.LongRef r2, Ref.LongRef r3, long r4, Ref.LongRef r6, Continuation<? super DoraFeedbackLog$submit$1> r7) {
        this.this$0 = r1;
        this.$p2pConnectedTime = r2;
        this.$logFetchEnded = r3;
        this.$startTime = r4;
        this.$logUploadEnded = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DoraFeedbackLog$submit$1(this.this$0, this.$p2pConnectedTime, this.$logFetchEnded, this.$startTime, this.$logUploadEnded, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v13 */
    /* JADX WARN: Type inference failed for: r23v19 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v20 */
    /* JADX WARN: Type inference failed for: r23v21 */
    /* JADX WARN: Type inference failed for: r23v22 */
    /* JADX WARN: Type inference failed for: r23v23 */
    /* JADX WARN: Type inference failed for: r23v24 */
    /* JADX WARN: Type inference failed for: r23v28 */
    /* JADX WARN: Type inference failed for: r23v29 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v30 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v34 */
    /* JADX WARN: Type inference failed for: r23v35 */
    /* JADX WARN: Type inference failed for: r23v36 */
    /* JADX WARN: Type inference failed for: r23v37 */
    /* JADX WARN: Type inference failed for: r23v38 */
    /* JADX WARN: Type inference failed for: r23v39 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v40 */
    /* JADX WARN: Type inference failed for: r23v41 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0300 -> B:251:0x0302). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r45) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        ?? r11 = "scene";
        String r17 = "duration";
        String r2 = "total_duration";
        String r13 = "download_duration";
        String r14 = "conn_duration";
        Object r22 = "trigger_type";
        r11 = 0;
        String r25 = "fail_reason";
        String r26 = "DoraGFeedbackViewModel";
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L16;
        if (r1 == 3) goto L13;
        if (r1 != 4) goto L12;
        Ref.ObjectRef r0 = (Ref.ObjectRef) this.L$1;
        Ref.BooleanRef r3 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r45);     // Catch: Exception -> L20
        DoraFeedbackLog$submit$1 r6 = this;
        String r4 = "log_wifi_get_result";
        Object r37 = "manual";
        Object r310 = "type";
        Object r5 = "total_size";
        String r7 = "result";
        r4 = "";
        String r10 = "DoraGFeedbackViewModel";
    L241:
        if (r3.element == true) goto L283;
        r17 = r2;
        r10 = r10;
        Object r23 = "scene";
        String r18 = "download_duration";
        String r110 = "conn_duration";
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L164
        r6.this$0.a.getLogSubmitCallback();     // Catch: Exception -> L164
        DoraBuryPointManager r12 = DoraBuryPointManager.a;     // Catch: Exception -> L164
        Pair[] r15 = new Pair[4];     // Catch: Exception -> L164
        r15[0] = TuplesKt.to(r7, Boxing.boxInt(1));     // Catch: Exception -> L164
        r15[1] = TuplesKt.to(r25, "LOG_UPLOAD_FAILED");     // Catch: Exception -> L162
        String r16 = r6.this$0.d;     // Catch: Exception -> L162
        if (r16 == null) goto L145;
        Long r111 = Boxing.boxLong(new PolarisFileWrapper(r16).length());     // Catch: Exception -> L162
    L146:
        r15[2] = TuplesKt.to(r5, r111);     // Catch: Exception -> L162
        String r112 = r7;
        String r42 = r4;
        r15[3] = TuplesKt.to(r17, Boxing.boxLong(r8 - r6.$logFetchEnded.element));     // Catch: Exception -> L158
        r7 = null;
        DoraBuryPointManager.J(r12, "log_wifi_upload_result", MapsKt.mapOf(r15), false, 12);     // Catch: Exception -> L158
        l r20 = r6.this$0;     // Catch: Exception -> L158
        r4 = r4;
        r20.e = r4;     // Catch: Exception -> L156
        r20.f = false;     // Catch: Exception -> L156
        r20.b.setValue(LogState.LOG_UPLOAD_FAILED);     // Catch: Exception -> L156
        String r21 = r10;
        pk4.j.c(r21, "Device log upload failed", (Throwable) r0.element);     // Catch: Exception -> L154
        r11 = r23;
    L280:
    L234:
        String r24 = r6.this$0.d;
        if (r24 == null) goto L237;
        Boxing.boxBoolean(new PolarisFileWrapper(r24).delete());
    L237:
        r6.this$0.d = null;
        return Unit.INSTANCE;
    L154:
        e = e;
    L161:
        String r27 = r21;
        String r113 = "fail_reason";
        r2 = r17;
        r13 = r18;
        Object r114 = r22;
        Object r28 = r37;
        Object r30 = r310;
        String r31 = r17;
        String r32 = r110;
        ?? r210 = r23;
    L209:
        long r115 = System.currentTimeMillis();
        Exception r116 = e;
        int r33 = a.a[((LogState) r6.this$0.b.getValue()).ordinal()];
        String r211 = r4;
        if (r33 != 1) goto L212;
        String r34 = r42;
        r6.this$0.a.getLogSubmitCallback();
        StringBuilder r35 = new StringBuilder("P2P_CONNECTION_FAILED:");
        x39.b r36 = r6.this$0.g;
        if (r36 == null) goto L231;
        String r38 = r36.a;
        if (r38 == null) goto L231;
    L232:
        r35.append(r38);
        DoraBuryPointManager.J(DoraBuryPointManager.a, r34, MapsKt.mapOf(new Pair[]{TuplesKt.to(r112, Boxing.boxInt(1)), TuplesKt.to(r113, r35.toString()), TuplesKt.to(r30, Boxing.boxInt(1)), TuplesKt.to(r114, r28), TuplesKt.to(r32, Boxing.boxLong(r115 - r6.$startTime)), TuplesKt.to(r13, Boxing.boxInt(0)), TuplesKt.to(r2, Boxing.boxLong(r115 - r6.$startTime)), TuplesKt.to(r5, Boxing.boxInt(0))}), false, 12);
        LogState r40 = LogState.P2P_CONNECTION_FAILED;
    L233:
        DoraWifiLinkWrapper r41 = DoraWifiLinkWrapper.a;
        DoraWifiScene r43 = DoraWifiScene.LOG_FROM_FEEDBACK;
        r41.getClass();
        Intrinsics.checkNotNullParameter(r43, r210);
        DoraWifiLinkWrapper.d(r43, null);
        l r44 = r6.this$0;
        r44.e = r211;
        r44.f = false;
        r44.b.setValue(r40);
        pk4.j.c(r27, "Log submission failed at state " + r6.this$0.b.getValue(), r116);
    L231:
        r38 = "unknown";
        goto L232
    L212:
        if (r33 != 2) goto L214;
        r6.this$0.a.getLogSubmitCallback();
        DoraBuryPointManager r46 = DoraBuryPointManager.a;
        Pair[] r47 = new Pair[8];
        r47[0] = TuplesKt.to(r112, Boxing.boxInt(2));
        r47[1] = TuplesKt.to(r113, "LOG_FETCH_FAILED");
        r47[2] = TuplesKt.to(r30, Boxing.boxInt(1));
        r47[3] = TuplesKt.to(r114, r28);
        r47[4] = TuplesKt.to(r32, Boxing.boxLong(r6.$p2pConnectedTime.element - r6.$startTime));
        r47[5] = TuplesKt.to(r13, Boxing.boxLong(r115 - r6.$p2pConnectedTime.element));
        r47[6] = TuplesKt.to(r2, Boxing.boxLong(r115 - r6.$startTime));
        String r48 = r6.this$0.d;
        if (r48 == null) goto L224;
        Long r50 = Boxing.boxLong(new PolarisFileWrapper(r48).length());
    L225:
        r47[7] = TuplesKt.to(r5, r50);
        DoraBuryPointManager.J(r46, r42, MapsKt.mapOf(r47), false, 12);
        r40 = LogState.LOG_FETCH_FAILED;
        goto L233
    L224:
        r50 = null;
        goto L225
    L214:
        if (r33 == 3) goto L216;
        pk4.j.f(r27, "Unexpected failure in state " + r6.this$0.b.getValue());
        r40 = LogState.IDLE;
        goto L233
    L216:
        r6.this$0.a.getLogSubmitCallback();
        DoraBuryPointManager r51 = DoraBuryPointManager.a;
        Pair[] r52 = new Pair[4];
        r52[0] = TuplesKt.to(r112, Boxing.boxInt(1));
        r52[1] = TuplesKt.to(r113, "LOG_UPLOAD_FAILED");
        String r53 = r6.this$0.d;
        if (r53 == null) goto L219;
        Long r54 = Boxing.boxLong(new PolarisFileWrapper(r53).length());
    L220:
        r52[2] = TuplesKt.to(r5, r54);
        r52[3] = TuplesKt.to(r31, Boxing.boxLong(r115 - r6.$logFetchEnded.element));
        DoraBuryPointManager.J(r51, "log_wifi_upload_result", MapsKt.mapOf(r52), false, 12);
        r40 = LogState.LOG_UPLOAD_FAILED;
        goto L233
    L219:
        r54 = null;
    L156:
        e = e;
    L160:
        r21 = r10;
    L158:
        e = e;
        r4 = r4;
        goto L160
    L145:
        r111 = null;
    L162:
        e = e;
        r112 = r7;
        r42 = r4;
        r4 = r4;
        r26 = r10;
        DoraFeedbackLog$submit$1 r55 = r6;
        r25 = r25;
        r2 = r17;
        r13 = r18;
        Object r56 = r22;
        r17 = r17;
        ?? r212 = r23;
    L176:
        r114 = r56;
        r31 = r17;
        r32 = r110;
        r113 = r25;
        r27 = r26;
        r30 = r310;
        r6 = r55;
        r28 = r37;
        r210 = r212;
        goto L209
    L283:
        r6.this$0.b.setValue(LogState.LOG_UPLOAD_SUCCESS);     // Catch: Exception -> L137
        r6.this$0.b.setValue(LogState.READY);     // Catch: Exception -> L137
        DoraBuryPointManager r57 = DoraBuryPointManager.a;     // Catch: Exception -> L137
        r17 = r2;
        Pair[] r58 = new Pair[3];     // Catch: Exception -> L135
        r58[0] = TuplesKt.to(r7, Boxing.boxLong(0));     // Catch: Exception -> L135
        String r60 = r6.this$0.d;     // Catch: Exception -> L135
        if (r60 == null) goto L125;
        r18 = "download_duration";
        Long r61 = Boxing.boxLong(new PolarisFileWrapper(r60).length());     // Catch: Exception -> L123
    L275:
        r58[1] = TuplesKt.to(r5, r61);     // Catch: Exception -> L133
        r110 = "conn_duration";
        r10 = r10;
        r11 = "scene";
        r58[2] = TuplesKt.to(r17, Boxing.boxLong(r6.$logUploadEnded.element - r6.$logFetchEnded.element));     // Catch: Exception -> L164
        DoraBuryPointManager.J(r57, "log_wifi_upload_result", MapsKt.mapOf(r58), false, 12);     // Catch: Exception -> L164
    L131:
        e = e;
        r10 = r10;
        r11 = "scene";
    L165:
        r112 = r7;
        r42 = r4;
        r4 = r4;
        r26 = r10;
        Object r62 = r5;
        r55 = r6;
        r25 = r25;
        r2 = r17;
        r13 = r18;
        r56 = r22;
        r17 = r17;
        ?? r213 = r11;
    L175:
        r5 = r62;
        r212 = r213;
    L133:
        e = e;
    L140:
        r110 = "conn_duration";
    L123:
        e = e;
        r42 = r4;
        r25 = r25;
        ?? r214 = "scene";
        r2 = r17;
        r13 = r18;
        r4 = r4;
        r17 = r17;
        String r63 = r10;
        r114 = r22;
        Object r410 = r5;
        String r64 = r7;
        r62 = r410;
    L174:
        r55 = r6;
        r26 = r63;
        r56 = r114;
        r110 = r14;
        r112 = r64;
        r213 = r214;
        goto L175
    L125:
        r18 = "download_duration";
        r61 = null;
    L135:
        e = e;
    L139:
        r18 = "download_duration";
    L137:
        e = e;
        r17 = r2;
    L164:
        e = e;
    L166:
        e = e;
        String r117 = r2;
        r42 = r4;
        String r65 = r10;
        r214 = "scene";
        r4 = r4;
        String r118 = r7;
        r62 = r5;
        r25 = r25;
        r64 = r118;
        r14 = "conn_duration";
        r114 = r22;
        r63 = r65;
        r2 = r117;
        r17 = "duration";
        goto L174
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        long r66 = this.J$0;
        ResultKt.throwOnFailure(r45);     // Catch: Exception -> L20
        r6 = this;
        r4 = "log_wifi_get_result";
        r37 = "manual";
        r63 = "DoraGFeedbackViewModel";
        r310 = "type";
        Object r215 = "total_size";
        String r67 = "result";
        String r216 = "total_duration";
        r4 = "";
        r114 = r22;
        long r68 = 500;
    L251:
        r66 = r66 + r68;     // Catch: Exception -> L108
        String r70 = r216;
        Object r71 = r215;
    L255:
        AppHost.Companion r217 = AppHost.a;     // Catch: Exception -> L171
        if (NetworkUtils.isNetworkAvailable(r217.getApplication()) == false) goto L88;
    L104:
        r216 = r70;
        r215 = r71;
        r18 = r67;
        if (r66 <= 0) goto L278;
        pk4.j.d(r63, "Network wait finished. Available: " + NetworkUtils.isNetworkAvailable(r217.getApplication()));     // Catch: Exception -> L108
    L278:
        r6.this$0.b.setValue(LogState.ON_UPLOADING_LOGS);     // Catch: Exception -> L168
        r3 = new Ref.BooleanRef();     // Catch: Exception -> L168
        r0 = new Ref.ObjectRef();     // Catch: Exception -> L168
        AnonymousClass2 r72 = new AnonymousClass2(r6.this$0, r3, r0, r6.$logUploadEnded, null);     // Catch: Exception -> L168
        r6.L$0 = r3;     // Catch: Exception -> L168
        r6.L$1 = r0;     // Catch: Exception -> L168
        r6.label = 4;     // Catch: Exception -> L168
        if (CoroutineScopeKt.coroutineScope(r72, r6) != r9) goto L113;
        return r9;
    L113:
        r22 = r114;
        r7 = r18;
        r2 = r216;
        r5 = r215;
        r10 = r63;
    L168:
        e = e;
        r42 = r4;
        r4 = r4;
        r64 = r18;
    L170:
        r2 = r216;
        r62 = r215;
        r214 = r11;
        goto L174
    L88:
        if (r66 >= 5000) goto L104;
        if (r66 != 0) goto L94;
        r216 = r70;
        pk4.j.d(r63, "Waiting for network available...");     // Catch: Exception -> L102
    L95:
        r6.L$0 = null;     // Catch: Exception -> L102
        r6.J$0 = r66;     // Catch: Exception -> L102
        r6.label = 3;     // Catch: Exception -> L102
        r215 = r71;
        r18 = r67;
        r68 = 500;
        if (DelayKt.delay(500, r6) != r9) goto L100;
        return r9;
    L100:
        r67 = r18;
    L102:
        e = e;
        r215 = r71;
        r18 = r67;
    L109:
        r42 = r4;
        r64 = r18;
        r4 = r4;
        goto L170
    L94:
        r216 = r70;
    L171:
        e = e;
        r42 = r4;
        String r119 = r67;
        r4 = r4;
        DoraFeedbackLog$submit$1 r73 = r6;
        r2 = r70;
        Object r74 = r71;
        r26 = r63;
    L173:
        r62 = r74;
        r64 = r119;
        r63 = r26;
        r6 = r73;
        r214 = r11;
    L108:
        e = e;
        goto L109
    L16:
        l r75 = (l) this.L$0;
        ResultKt.throwOnFailure(r45);     // Catch: Exception -> L20
        Object r76 = r45;
        String r311 = "total_duration";
        r42 = "log_wifi_get_result";
        r37 = "manual";
        Object r312 = r22;
        r310 = "type";
        Object r77 = "total_size";
        String r411 = "result";
        int r412 = 1;
        char r78 = 2;
        int r313 = 0;
        r4 = "";
        int r120 = 7;
    L53:
        r75.d = (String) r76;     // Catch: Exception -> L199
        DoraWifiLinkWrapper r80 = DoraWifiLinkWrapper.a;     // Catch: Exception -> L199
        DoraWifiScene r81 = DoraWifiScene.LOG_FROM_FEEDBACK;     // Catch: Exception -> L199
        r80.getClass();     // Catch: Exception -> L199
        Intrinsics.checkNotNullParameter(r81, "scene");     // Catch: Exception -> L199
        DoraWifiLinkWrapper.d(r81, null);     // Catch: Exception -> L199
        this.$logFetchEnded.element = System.currentTimeMillis();     // Catch: Exception -> L199
        this.this$0.b.setValue(LogState.LOG_FETCH_SUCCESS);     // Catch: Exception -> L199
    L54:
        DoraBuryPointManager r82 = DoraBuryPointManager.a;     // Catch: Exception -> L199
        Pair[] r83 = new Pair[r120];     // Catch: Exception -> L199
        r67 = r411;
        r83[0] = TuplesKt.to(r67, Boxing.boxInt(r313));     // Catch: Exception -> L197
        Object r84 = r310;
        r83[1] = TuplesKt.to(r84, Boxing.boxInt(r412));     // Catch: Exception -> L194
        Object r85 = r37;
        r114 = r312;
        r83[r78] = TuplesKt.to(r114, r85);     // Catch: Exception -> L190
        r37 = r85;
        r310 = r84;
        r83[3] = TuplesKt.to("conn_duration", Boxing.boxLong(this.$p2pConnectedTime.element - this.$startTime));     // Catch: Exception -> L186
        r83[4] = TuplesKt.to("download_duration", Boxing.boxLong(this.$logFetchEnded.element - this.$p2pConnectedTime.element));     // Catch: Exception -> L186
        String r86 = r311;
        r83[5] = TuplesKt.to(r86, Boxing.boxLong(this.$logFetchEnded.element - this.$startTime));     // Catch: Exception -> L183
        String r87 = this.this$0.d;     // Catch: Exception -> L183
        if (r87 != null) goto L239;
        Long r88 = null;
    L257:
        r83[6] = TuplesKt.to(r77, r88);     // Catch: Exception -> L181
        r4 = r42;
        DoraBuryPointManager.J(r82, r4, MapsKt.mapOf(r83), false, 12);     // Catch: Exception -> L178
        if (this.this$0.b.getValue() != LogState.LOG_FETCH_SUCCESS) goto L269;
    L82:
        if (com.larus.utils.o0.d(this.this$0.d) == false) goto L177;
        r6 = this;
        r66 = 0;
        r63 = "DoraGFeedbackViewModel";
        r71 = r77;
        r70 = r86;
    L177:
        r6 = this;
        goto L234
    L269:
        if (this.this$0.b.getValue() != LogState.LOG_UPLOAD_FAILED) goto L177;
    L80:
        e = e;
    L81:
        r74 = r77;
        r2 = r86;
        r42 = r4;
        r119 = r67;
        r73 = this;
        r4 = r4;
    L178:
        e = e;
        r42 = r4;
    L180:
        r11 = "scene";
        r4 = r4;
    L208:
        r6 = this;
        r32 = "conn_duration";
        r31 = "duration";
        r113 = "fail_reason";
        r27 = "DoraGFeedbackViewModel";
        r28 = r37;
        r112 = r67;
        r5 = r77;
        r2 = r86;
        r30 = r310;
        r210 = r11;
    L181:
        e = e;
        goto L180
    L239:
        r88 = Boxing.boxLong(new PolarisFileWrapper(r87).length());     // Catch: Exception -> L70
    L70:
        e = e;
        r77 = r77;
        r4 = r42;
    L183:
        e = e;
    L185:
        r77 = r77;
    L186:
        e = e;
    L193:
        r86 = r311;
    L188:
        e = e;
    L192:
        r310 = r84;
    L190:
        e = e;
        r37 = r85;
    L194:
        e = e;
        r310 = r84;
    L196:
        r86 = r311;
        r114 = r312;
    L197:
        e = e;
    L199:
        e = e;
        r11 = "scene";
        r4 = r4;
        r86 = r311;
        r114 = r312;
        r77 = r77;
        r67 = r411;
        goto L208
    L18:
        ResultKt.throwOnFailure(r45);     // Catch: Exception -> L20
        Object r90 = r45;
        r311 = "total_duration";
        r42 = "log_wifi_get_result";
        r37 = "manual";
        r312 = r22;
        r310 = "type";
        r77 = "total_size";
        r411 = "result";
        r412 = 1;
        r313 = 0;
        r4 = "";
        r120 = 7;
    L39:
        x39.b r91 = (x39.b) r90;     // Catch: Exception -> L199
        if ((r91 instanceof x39.b.f) == false) goto L201;
        this.$p2pConnectedTime.element = System.currentTimeMillis();     // Catch: Exception -> L199
        this.this$0.b.setValue(LogState.P2P_CONNECTION_SUCCESS);     // Catch: Exception -> L199
    L43:
        if (this.this$0.b.getValue() != LogState.P2P_CONNECTION_SUCCESS) goto L263;
    L50:
        this.this$0.b.setValue(LogState.ON_FETCHING_LOGS);     // Catch: Exception -> L199
        r75 = this.this$0;     // Catch: Exception -> L199
        this.L$0 = r75;     // Catch: Exception -> L199
        r78 = 2;
        this.label = 2;     // Catch: Exception -> L199
        r76 = l.a(r75, this);     // Catch: Exception -> L199
        if (r76 != r9) goto L53;
        return r9;
    L263:
        if (this.this$0.b.getValue() == LogState.LOG_FETCH_FAILED) goto L50;
        r78 = 2;
    L48:
        e = e;
        r55 = this;
        r212 = "scene";
        r110 = "conn_duration";
        r4 = r4;
        r2 = r311;
        r56 = r312;
        r5 = r77;
        r112 = r411;
        goto L176
    L201:
        r11 = "scene";
        r4 = r4;
        r86 = r311;
        r114 = r312;
        r77 = r77;
        r67 = r411;
        this.this$0.g = r91;     // Catch: Exception -> L204
        throw new IOException("P2P connection failed: " + r91);     // Catch: Exception -> L204
    L204:
        e = e;
        goto L208
    L22:
        ResultKt.throwOnFailure(r45);
    L206:
        e = e;
        r86 = "total_duration";
        r4 = "";
        r11 = "scene";
        r42 = "log_wifi_get_result";
        r37 = "manual";
        r114 = r22;
        r310 = "type";
        r77 = "total_size";
        r67 = "result";
        goto L208
    L24:
        if (this.this$0.b.getValue() != LogState.IDLE) goto L26;
    L34:
        this.this$0.b.setValue(LogState.ON_BUILDING_P2P_CONNECTION);     // Catch: Exception -> L206
        DoraWifiLinkWrapper r92 = DoraWifiLinkWrapper.a;     // Catch: Exception -> L206
        DoraWifiScene r93 = DoraWifiScene.LOG_FROM_FEEDBACK;     // Catch: Exception -> L206
        this.label = 1;     // Catch: Exception -> L206
        r311 = "total_duration";
        r412 = 1;
        r313 = 0;
        r42 = "log_wifi_get_result";
        r37 = "manual";
        r312 = r22;
        r310 = "type";
        r77 = "total_size";
        r411 = "result";
        r4 = "";
        r120 = 7;
        r90 = r92.b(r93, null, true, null, null, this);     // Catch: Exception -> L199
        if (r90 != r9) goto L39;
        return r9;
    L26:
        if (this.this$0.b.getValue() == LogState.P2P_CONNECTION_FAILED) goto L34;
        if (this.this$0.b.getValue() == LogState.LOG_FETCH_FAILED) goto L34;
        if (this.this$0.b.getValue() == LogState.LOG_UPLOAD_FAILED) goto L34;
        r311 = "total_duration";
        r42 = "log_wifi_get_result";
        r37 = "manual";
        r312 = r22;
        r310 = "type";
        r77 = "total_size";
        r411 = "result";
        r412 = 1;
        r313 = 0;
        r4 = "";
        r120 = 7;
    L20:
        e = e;
        r6 = this;
        r4 = "";
        r210 = "scene";
        r32 = "conn_duration";
        r31 = "duration";
        r42 = "log_wifi_get_result";
        r28 = "manual";
        r114 = r22;
        r113 = "fail_reason";
        r27 = "DoraGFeedbackViewModel";
        r30 = "type";
        r5 = "total_size";
        r112 = "result";
        goto L209
    }
}
