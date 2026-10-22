package com.obric.memorydata.memory.review.provider;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.bridge.HttpMethod;
import com.obric.memorydata.middleware.api.bridge.HttpRequest;
import com.obric.memorydata.middleware.api.bridge.NetworkBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.Response;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/NetworkMemoryReviewServerClient;", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRemoteDataSource;", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRemoteDataSource;", "Lcom/obric/memorydata/memory/review/provider/InAppTraceReportRemoteDataSource;", "hostProvider", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "submitUserFeedback", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewServerResponse;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/provider/MemoryReviewUserFeedbackRequest;", "submitTraceReport", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportRequest;", "submitInAppTrace", "Lcom/obric/memorydata/memory/review/provider/InAppTraceReportRequest;", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "path", "body", "Lorg/json/JSONObject;", "extractLogId", "responseData", "logRequestSummary", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class av implements ad, ap, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<String> f10428a;

    /* JADX WARN: Multi-variable type inference failed */
    public av() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public av(Function0<String> r3) {
        Function0<String> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "hostProvider");
        this.f10428a = r4;
    }

    public /* synthetic */ av(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$av$USrZhoefXY3A_YzFsNtIAcx9fsY.INSTANCE;
    L5:
        this(r5);
    }

    private final am a(String r23, JSONObject r24) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L33
        av r1 = (av) ZeusTransformUtils.preCheckCast(this, av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        r1.b(r23, r24);     // Catch: Throwable -> L33
        HttpMethod r2 = HttpMethod.POST;     // Catch: Throwable -> L33
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.f10428a.invoke(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        JsonObject r8 = JsonParser.parseString(r24.toString()).getAsJsonObject();     // Catch: Throwable -> L33
        Intrinsics.checkNotNullExpressionValue(r8, "getAsJsonObject(...)");     // Catch: Throwable -> L33
        Response r4 = NetworkBridgeAPI.INSTANCE.sendRequest(new HttpRequest(r2, r3, r23, true, null, null, r8, 0, 0, 0, 944, null));     // Catch: Throwable -> L31
        JSONObject r5 = r4.getData();     // Catch: Throwable -> L31
        if (r5 == null) goto L8;
        String r6 = r5.toString();     // Catch: Throwable -> L31
    L9:
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        String r7 = r6;
        String r9 = r1.a(r7);     // Catch: Throwable -> L31
        String r10 = "com.obric.memorydata.plugin";
        String r11 = r23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r10), "MemoryReviewServerClient", "memory review response path=" + r11 + " code=" + r4.getCode() + " msg=" + StringsKt.take(r4.getMsg(), 200) + " logId=" + r9 + " data=" + StringsKt.take(r7, 500), false, 4, null);     // Catch: Throwable -> L27
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getMsg(), CharSequence.class, r10);     // Catch: Throwable -> L27
        if (StringsKt.isBlank(r12) == true) goto L18;
    L21:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, r10);     // Catch: Throwable -> L27
        if (r4.getCode() != 0) goto L24;
        boolean r14 = true;
    L25:
        Object r15 = Result.m1421constructorimpl(new am(r14, r13, r4.getCode(), r7, r9));     // Catch: Throwable -> L27
    L36:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L44;
        RunLog.INSTANCE.error("MemoryReviewServerClient", "post memory review server failed path=" + r11 + " error=" + r16.getMessage(), r16);
        String r17 = r16.getMessage();
        if (r17 != null) goto L42;
        r17 = "memory review server request failed";
    L42:
        r15 = new am(false, r17, 0, null, null, 28, null);
    L44:
        return (am) ZeusTransformUtils.preCheckCast(r15, am.class, r10);
    L24:
        r14 = false;
        goto L25
    L18:
        if (r4.getCode() != 0) goto L20;
        r12 = "success";
        goto L21
    L20:
        r12 = "server code=" + r4.getCode();     // Catch: Throwable -> L27
    L27:
        th = th;
    L35:
        Result.Companion r18 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L29:
        th = th;
        r11 = r23;
        goto L35
    L8:
        r6 = null;
    L31:
        th = th;
        r11 = r23;
        r10 = "com.obric.memorydata.plugin";
    L33:
        th = th;
        r10 = "com.obric.memorydata.plugin";
        r11 = r23;
        goto L35
    }

    private static final String a() {
        return "https://os.oceancloudapi.com";
    }

    private final String a(String r5) {
        Object r2 = "";
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L31;
        return "";
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        av r4 = (av) ZeusTransformUtils.preCheckCast(this, av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        JSONObject r6 = new JSONObject(r5);     // Catch: Throwable -> L23
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(a(r6), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        String r3 = null;
        if (StringsKt.isBlank(r7) == false) goto L13;
        JSONObject r8 = r6.optJSONObject("data");     // Catch: Throwable -> L23
        if (r8 == null) goto L10;
        r7 = a(r8);     // Catch: Throwable -> L23
    L11:
        if (r7 != null) goto L13;
        r7 = "";
        goto L13
    L10:
        r7 = null;
    L13:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r9) == false) goto L21;
        JSONObject r10 = r6.optJSONObject("result");     // Catch: Throwable -> L23
        if (r10 == null) goto L18;
        r3 = a(r10);     // Catch: Throwable -> L23
    L18:
        if (r3 != null) goto L20;
        r9 = "";
        goto L21
    L20:
        r9 = r3;
    L21:
        Object r11 = Result.m1421constructorimpl((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L26:
        if (Result.m1427isFailureimpl(r11) == true) goto L30;
        r2 = r11;
    L30:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    private static final String a(JSONObject r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.optString("log_id"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = r3.optString("logId");
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "ifBlank(...)");
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    private final void b(String r5, JSONObject r6) {
        RunLog.INSTANCE.debug("MemoryReviewServerClient", "memory review request path=" + r5 + " uniqId=" + r6.optString("uniq_id") + " logId=" + r6.optString("log_id") + " extraLength=" + r6.optString(WsConstants.KEY_EXTRA).length());
    }

    public static /* synthetic */ String lambda$USrZhoefXY3A_YzFsNtIAcx9fsY() {
        return a();
    }

    @Override // com.obric.memorydata.memory.review.provider.ad
    public am a(an r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return a("/intent/feedback/user/new", r2.b());
    }

    @Override // com.obric.memorydata.memory.review.provider.ap
    public am a(ar r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return a("/intent/feedback/user/memory-trace-report", r2.b());
    }

    @Override // com.obric.memorydata.memory.review.provider.x
    public am a(y r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return a("/intent/feedback/user/memory-trace-report", r2.a());
    }
}
