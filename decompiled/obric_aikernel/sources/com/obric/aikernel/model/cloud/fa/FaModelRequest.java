package com.obric.aikernel.model.cloud.fa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.obric.aikernel.b;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CloudModelRequest;
import com.obric.aikernel.model.cloud.common.CommonNetworkImpl;
import com.obric.aikernel.model.cloud.common.c;
import com.obric.aikernel.model.cloud.common.e;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.utils.f;
import com.obric.aikernel.utils.g;
import java.io.File;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class FaModelRequest extends CloudModelRequest {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public FaModelRequest(Context r10, String r11, String r12, RequestParams r13, b r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bizName");
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        super(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.aikernel.model.cloud.common.CloudModelRequest
    public Object e(Continuation<? super Bundle> r10) {
        if ((r10 instanceof FaModelRequest$run$1) == false) goto L7;
        FaModelRequest$run$1 r11 = (FaModelRequest$run$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        FaModelRequest this = (FaModelRequest) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        Bundle r16 = (Bundle) r13;
        ApiPerfDetails.a r17 = ApiPerfDetails.Companion;
        ApiPerfDetails.a.j(r17, this.d().getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        ApiPerfDetails.a.j(r17, this.d().getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        this.b().j2(r16);
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Bundle r18 = d().getBackend();
        r11.L$0 = this;
        r11.label = 1;
        r13 = g(r18, r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new FaModelRequest$run$1(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01fe -> B:12:0x004d). Please report as a decompilation issue!!! */
    public final Object g(Bundle r25, Continuation<? super Bundle> r26) {
        if ((r26 instanceof FaModelRequest$twoStepSlmModelFunctions$1) == false) goto L7;
        FaModelRequest$twoStepSlmModelFunctions$1 r10 = (FaModelRequest$twoStepSlmModelFunctions$1) r26;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
        FaModelRequest r12 = this;
    L8:
        Object r13 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        int r16 = 1;
        if (r15 == 0) goto L15;
        if (r15 != 1) goto L14;
        int r17 = r10.I$3;
        int r18 = r10.I$2;
        int r19 = r10.I$1;
        int r20 = r10.I$0;
        String r110 = (String) r10.L$2;
        Bundle r111 = (Bundle) r10.L$1;
        FaModelRequest r21 = (FaModelRequest) r10.L$0;
        ResultKt.throwOnFailure(r13);
        int r22 = r20;
    L12:
        Bundle r112 = r111;
        AIKLog.INSTANCE.d("FaModelRequest", "task is waiting " + r110 + " for " + r19 + " seconds");
        e r23 = CommonNetworkImpl.f4638a.p();
        StringBuilder r113 = new StringBuilder();
        r113.append("/api/v1/task/result?task_id=");
        r113.append(r110);
        c r24 = r23.b(r113.toString(), MapsKt.emptyMap(), MapsKt.emptyMap());
        String r114 = r24.b();
        if (r114 == null) goto L68;
        JSONObject r115 = g.b(r114);
        if (r115 == null) goto L68;
    L69:
        String r116 = r115.optString("data");
        Intrinsics.checkNotNullExpressionValue(r116, "respResultBody.optString(\"data\")");
        JSONObject r117 = g.b(r116);
        if (r117 != null) goto L73;
        r117 = new JSONObject();
    L73:
        if ((r24.f() / 100) == 2) goto L75;
    L91:
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r21.d().getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        return e8.a.z(new Bundle(), 110, "upload file failed", true);
    L75:
        if (r115.optInt("code", -1) != 0) goto L91;
        if (r117.length() == 0) goto L91;
        String r118 = r117.optString("status");
        String r27 = r117.optString("result");
        if (Intrinsics.areEqual(r118, "success") == false) goto L84;
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r21.d().getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        return e8.a.w(r112, r27, 0, null, 6, null);
    L84:
        if (Intrinsics.areEqual(r118, "failed") == false) goto L87;
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r21.d().getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        Bundle r28 = new Bundle();
        Intrinsics.checkNotNullExpressionValue(r27, "respResultBodyResult");
        return e8.a.z(r28, 110, r27, true);
    L87:
        if (r19 == r18) goto L89;
        int r29 = r19 + r17;
        r12 = r21;
        r111 = r112;
    L60:
        r10.L$0 = r12;
        r10.L$1 = r111;
        r10.L$2 = r110;
        r10.I$0 = r22;
        r10.I$1 = r29;
        r10.I$2 = r18;
        r10.I$3 = r17;
        r10.label = 1;
        if (DelayKt.b(((long) r22) * 1000, r10) != r14) goto L63;
        return r14;
    L63:
        r21 = r12;
        r19 = r29;
        goto L12
    L89:
        Bundle r30 = r112;
    L94:
        return e8.a.z(r30, 110, "request failed", true);
    L68:
        r115 = new JSONObject();
        goto L69
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        r30 = new Bundle();
        String r31 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r31, "randomUUID().toString()");
        Ref.ObjectRef r32 = new Ref.ObjectRef();
        AppContext r119 = AppContext.INSTANCE;     // Catch: Exception -> L97
        File r120 = new File(r119.getContext().getCacheDir(), "uploads");     // Catch: Exception -> L97
        if (r120.exists() == true) goto L19;
        r120.mkdirs();     // Catch: Exception -> L97
    L19:
        String r121 = null;
        boolean r122 = false;
        if (r25.containsKey("contentFile") == false) goto L22;
        T r33 = f.f5592a.e(r119.getContext(), Uri.parse(r25.getString("contentFile")), r120, r31);     // Catch: Exception -> L97
    L27:
        r32.element = r33;     // Catch: Exception -> L97
        if (r33 == 0) goto L30;
        v.a r34 = new v.a(r121, r16, r122 ? 1 : 0).e(v.f12054i);
        r34.a("file", ((File) r32.element).getAbsolutePath(), y.f12130a.a((File) r32.element, u.f12046d.b("text/plain")));
        v r35 = r34.d();
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, d().getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);
        c r36 = CommonNetworkImpl.f4638a.p().c("/api/v1/task/submit?task_type=summary", r35, MapsKt.emptyMap(), MapsKt.emptyMap());
        AIKLog.INSTANCE.d("FaModelRequest", "twoStepSlmModelFunctions response = " + r36);
        h.d(m0.a(z0.b()), null, null, new FaModelRequest$twoStepSlmModelFunctions$3(r32, null), 3, null);
        String r37 = r36.b();
        if (r37 == null) goto L35;
        JSONObject r38 = g.b(r37);
        if (r38 == null) goto L35;
    L36:
        String r39 = r38.optString("data");
        Intrinsics.checkNotNullExpressionValue(r39, "fileUploadResultBody.optString(\"data\")");
        JSONObject r40 = g.b(r39);
        if (r40 != null) goto L39;
        r40 = new JSONObject();
    L39:
        String r41 = r40.optString("task_id");
        if (r41 != null) goto L43;
        r41 = "";
    L43:
        if ((r36.f() / 100) != 2) goto L96;
        if (r41.length() != 0) goto L47;
        boolean r42 = true;
    L48:
        if (r42 == true) goto L96;
        if (r38.optInt("code", -1) != 0) goto L96;
        if (r38.length() == 0) goto L96;
        int r43 = RangesKt.coerceAtMost(r40.optInt("task_timeout_second"), 120);
        int r44 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r40.optInt("loop_query_interval_second"), 1), r43 / 2);
        IntProgression r45 = RangesKt.step(RangesKt.until(0, r43), r44);
        r29 = r45.getFirst();
        int r123 = r45.getLast();
        r17 = r45.getStep();
        if (r17 <= 0) goto L57;
        if (r29 > r123) goto L57;
    L59:
        r111 = r30;
        r22 = r44;
        r110 = r41;
        r18 = r123;
    L57:
        if (r17 >= 0) goto L94;
        if (r123 > r29) goto L94;
    L47:
        r42 = false;
    L96:
        return e8.a.z(new Bundle(), 110, "try to upload file failed", true);
    L35:
        r38 = new JSONObject();
        goto L36
    L30:
        return e8.a.z(new Bundle(), 110, "upload file is null", true);
    L22:
        String r46 = r25.getString("content");     // Catch: Exception -> L97
        if (r46 == null) goto L26;
        File r47 = f.f5592a.d(r119.getContext(), r46, r120, r31);     // Catch: Exception -> L97
        r33 = r47;
        if (r47 != null) goto L27;
    L26:
        r33 = 0;
    L98:
        return e8.a.z(new Bundle(), 110, "create upload file failed", true);
    L7:
        r12 = this;
        r10 = new FaModelRequest$twoStepSlmModelFunctions$1(r12, r26);
        goto L8
    }
}
