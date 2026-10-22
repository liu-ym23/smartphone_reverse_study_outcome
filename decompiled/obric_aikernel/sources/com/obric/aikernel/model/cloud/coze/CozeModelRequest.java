package com.obric.aikernel.model.cloud.coze;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CloudModelRequest;
import com.obric.aikernel.model.cloud.common.CloudRequestConfigs;
import com.obric.aikernel.model.cloud.common.CommonNetworkImpl;
import com.obric.aikernel.model.cloud.common.e;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.utils.h;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
public final class CozeModelRequest extends CloudModelRequest {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f4661g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f4662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f4663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f4664c;

        public b(boolean r10, Bundle r11, String r12) {
            this.f4662a = r10;
            this.f4663b = r11;
            this.f4664c = r12;
        }

        public /* synthetic */ b(boolean r10, Bundle r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = null;
        L6:
            if ((r13 & 4) == 0) goto L8;
            r12 = null;
        L8:
            this(r10, r11, r12);
        }

        public final String a() {
            return this.f4664c;
        }

        public final Bundle b() {
            return this.f4663b;
        }

        public final boolean c() {
            return this.f4662a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f4662a == r11.f4662a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4663b, r11.f4663b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4664c, r11.f4664c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r10 = this.f4662a;
            ?? r11 = r10;
            if (r10 == false) goto L5;
            r11 = 1;
        L5:
            int r12 = r11 * 31;
            Bundle r13 = this.f4663b;
            int r14 = 0;
            if (r13 != null) goto L8;
            int r15 = 0;
        L9:
            int r16 = (r12 + r15) * 31;
            String r17 = this.f4664c;
            if (r17 == null) goto L14;
            r14 = r17.hashCode();
        L14:
            return r16 + r14;
        L8:
            r15 = r13.hashCode();
            goto L9
        }

        public String toString() {
            return "RunCloudPackageResult(success=" + this.f4662a + ", outputData=" + this.f4663b + ", error=" + this.f4664c + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f4665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f4667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bundle f4668d;

        public c(long r10, String r11, boolean r12, Bundle r13) {
            Intrinsics.checkNotNullParameter(r11, "bizName");
            Intrinsics.checkNotNullParameter(r13, "argsBundle");
            this.f4665a = r10;
            this.f4666b = r11;
            this.f4667c = r12;
            this.f4668d = r13;
        }

        public final long a() {
            return this.f4665a;
        }

        public final String b() {
            return this.f4666b;
        }

        public final boolean c() {
            return this.f4667c;
        }

        public final Bundle d() {
            return this.f4668d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.f4665a == r11.f4665a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4666b, r11.f4666b) == true) goto L15;
            return false;
        L15:
            if (this.f4667c == r11.f4667c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f4668d, r11.f4668d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            int r10 = ((Long.hashCode(this.f4665a) * 31) + this.f4666b.hashCode()) * 31;
            boolean r11 = this.f4667c;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return ((r10 + r12) * 31) + this.f4668d.hashCode();
        }

        public String toString() {
            return "RunCloudPrepareInfo(taskId=" + this.f4665a + ", bizName=" + this.f4666b + ", useStreaming=" + this.f4667c + ", argsBundle=" + this.f4668d + ')';
        }
    }

    static {
        new a(null);
    }

    public CozeModelRequest(Context r10, String r11, String r12, RequestParams r13, com.obric.aikernel.b r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bizName");
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        super(r10, r11, r12, r13, r14);
        this.f4661g = r13.getBackend();
    }

    public static final /* synthetic */ RequestParams g(CozeModelRequest r10) {
        return r10.d();
    }

    private final c h(Bundle r10) {
        long r11 = h.f5594a.a();
        r10.putLong(IdlKeys.Args_TaskId, r11);
        boolean r12 = StringsKt.equals$default(r10.getString(EnsureReportData.METHOD), "stream", false, 2, null);
        return new c(r11, a(), r12, r10);
    }

    private final Object i(String r30, boolean r31, Bundle r32, com.obric.aikernel.b r33, Continuation<? super b> r34) {
        o r10 = new o(IntrinsicsKt.intercepted(r34), 1);
        r10.F();
        String r11 = r32.getString("boe_env");
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        e r13 = CommonNetworkImpl.f4638a.h();
    L12:
        AIKLog r14 = AIKLog.INSTANCE;
        r14.i("CloudModelRequest", "run package " + r30 + ", boeEnv: " + r11);
        String r15 = r32.getString(EnsureReportData.METHOD);
        if (TextUtils.isEmpty(r15) == true) goto L85;
        if (r13 == null) goto L85;
        LinkedHashMap r16 = new LinkedHashMap();
        if (r11 != null) goto L19;
    L24:
        boolean r17 = false;
    L25:
        if (r17 == false) goto L27;
        r16.put("X-TT-Env", r11);
    L27:
        r14.i("CloudModelRequest", "post package " + r30 + ", header: " + r16 + ", boeEnv: " + r11);
        HashMap r18 = (HashMap) r32.getSerializable("cozeKeyHeader");
        if (r18 == null) goto L30;
        r16.putAll(r18);
    L30:
        Object r19 = (HashMap) r32.getSerializable("cozeKeyBody");
        if (r19 != null) goto L34;
        r19 = new LinkedHashMap();
    L34:
        Map<String, String> r20 = (HashMap) r32.getSerializable("cozeKeyQuery");
        if (r20 != null) goto L38;
        r20 = new LinkedHashMap();
    L38:
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, g(this).getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);
        if (r15 == null) goto L41;
        String r110 = r15.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r110, "this as java.lang.String).toLowerCase(Locale.ROOT)");
    L43:
        if (Intrinsics.areEqual(r110, "post") == false) goto L46;
        com.obric.aikernel.model.cloud.common.c r21 = r13.a(CloudRequestConfigs.f4631a.d(), r19, r20, r16);
        r14.i("CloudModelRequest", "run package resp： " + r30 + ", resp: " + r21 + ", status=" + r21.f());
    L70:
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, g(this).getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        if (r21 == null) goto L83;
        Bundle r22 = new Bundle();
        r22.putString(IdlKeys.Result, r21.b());
        r22.putInt(IdlKeys.ErrorCode, r21.f());
        Throwable r23 = r21.c();
        if (r23 == null) goto L76;
        String r24 = r23.toString();
        if (r24 == null) goto L76;
    L77:
        r22.putString(IdlKeys.ErrorInfo, r24);
        r22.putBoolean("status", r21.i());
        Map<String, String> r25 = r21.d();
        if (r25 == null) goto L81;
        String r26 = r25.get("x-tt-logid");
        if (r26 == null) goto L81;
    L82:
        r22.putString(IdlKeys.Args_Logid, r26);
        b r27 = new b(true, r22, null, 4, null);
    L84:
        com.obric.aikernel.sdk.a.a(r10, r27);
    L86:
        Object r28 = r10.B();
        if (r28 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L89;
        DebugProbesKt.probeCoroutineSuspended(r34);
    L89:
        return r28;
    L81:
        r26 = "";
    L76:
        r24 = r21.e();
        goto L77
    L83:
        r27 = new b(false, null, "result is null or unsupported method. base URL delegate API " + r13 + ", method: " + r15, 2, null);
        goto L84
    L46:
        if (Intrinsics.areEqual(r110, "stream") == false) goto L69;
        r21 = r13.d(CloudRequestConfigs.f4631a.d(), r19, r20, r16);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L67
        String r35 = "";
    L49:
        BufferedReader r36 = r21.g();     // Catch: Throwable -> L67
        if (r36 == null) goto L52;
        String r37 = r36.readLine();     // Catch: Throwable -> L67
    L53:
        if (r37 == null) goto L55;
        r35 = r37;
    L55:
        if (r37 == null) goto L65;
        Bundle r38 = new Bundle();     // Catch: Throwable -> L67
        AIKLog r39 = AIKLog.INSTANCE;     // Catch: Throwable -> L67
        r39.i("CloudModelRequest", "stream line:" + r35);     // Catch: Throwable -> L67
        if (r35.length() != 0) goto L59;
        boolean r111 = true;
    L60:
        if (r111 == true) goto L49;
        r38.putInt(IdlKeys.ErrorCode, r21.f());     // Catch: Throwable -> L67
        r38.putString(IdlKeys.Result, r35);     // Catch: Throwable -> L67
        r38.putBoolean("status", true);     // Catch: Throwable -> L67
        r38.putBoolean(IdlKeys.IsFinish, false);     // Catch: Throwable -> L67
        e8.a.r(r33, r38);     // Catch: Throwable -> L67
        if (Intrinsics.areEqual(r35, "data:\"[DONE]\"") == false) goto L49;
        r39.i("CloudModelRequest", "########################");     // Catch: Throwable -> L67
        goto L65
    L59:
        r111 = false;
    L65:
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
        goto L70
    L52:
        r37 = null;
    L67:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L70
    L69:
        r21 = null;
        goto L70
    L41:
        r110 = null;
        goto L43
    L19:
        if (r11.length() <= 0) goto L21;
        boolean r112 = true;
    L22:
        if (r112 != true) goto L24;
        r17 = true;
        goto L25
    L21:
        r112 = false;
    L85:
        com.obric.aikernel.sdk.a.a(r10, new b(false, null, "base URL delegate API " + r13 + ", method: " + r15, 2, null));
        goto L86
    L11:
        r13 = CommonNetworkImpl.f4638a.j();
        goto L12
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    @Override // com.obric.aikernel.model.cloud.common.CloudModelRequest
    public Object e(Continuation<? super Bundle> r12) {
        if ((r12 instanceof CozeModelRequest$run$1) == false) goto L7;
        CozeModelRequest$run$1 r10 = (CozeModelRequest$run$1) r12;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        CozeModelRequest$run$1 r13 = r10;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        String r17 = (String) r13.L$1;
        CozeModelRequest r18 = (CozeModelRequest) r13.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        b r19 = (b) r14;
        Bundle r20 = r19.b();
        if (r20 == null) goto L21;
        r20.putBoolean(IdlKeys.IsFinish, true);
    L21:
        AIKLog r21 = AIKLog.INSTANCE;
        StringBuilder r22 = new StringBuilder();
        r22.append("run package ");
        r22.append(r17);
        r22.append(", ret: ");
        r22.append(r19.c());
        r22.append(", outputData: ");
        Bundle r110 = r19.b();
        if (r110 == null) goto L24;
        String r111 = r110.toString();
    L25:
        r22.append(r111);
        r22.append(", error: ");
        r22.append(r19.a());
        r21.i("CloudModelRequest", r22.toString());
        if (r19.c() == false) goto L28;
        Bundle r112 = r19.b();
        if (r112 != null) goto L32;
        r112 = e8.a.B(new Bundle(), 108, "invalid output value", false, 4, null);
    L32:
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r18.d().getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        e8.a.r(r18.b(), r112);
        return r112;
    L28:
        return e8.a.B(new Bundle(), 105, String.valueOf(r19.a()), false, 4, null);
    L24:
        r111 = null;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        c r113 = h(this.f4661g);
        r113.a();
        String r114 = r113.b();
        boolean r23 = r113.c();
        Bundle r24 = r113.d();
        AIKLog.INSTANCE.i("CloudModelRequest", "run package " + r114);
        com.obric.aikernel.b r25 = b();
        r13.L$0 = this;
        r13.L$1 = r114;
        r13.label = 1;
        r14 = i(r114, r23, r24, r25, r13);
        if (r14 != r15) goto L17;
        return r15;
    L17:
        r18 = this;
        r17 = r114;
    L7:
        r10 = new CozeModelRequest$run$1(this, r12);
        goto L8
    }
}
