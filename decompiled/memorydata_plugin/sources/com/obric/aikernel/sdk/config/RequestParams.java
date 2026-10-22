package com.obric.aikernel.sdk.config;

import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B,\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0006\u0010=\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0011R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R(\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R$\u0010(\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR$\u0010+\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010$\"\u0004\b-\u0010.R\u001b\u0010/\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0017\u001a\u0004\b0\u0010\u0011R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0002032\u0006\u0010\r\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u0011\u0010;\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b<\u0010\u0011¨\u0006?"}, d2 = {"Lcom/obric/aikernel/sdk/config/RequestParams;", "", AILabCheckPermissionTask.KEY_SOURCE, "(Lcom/obric/aikernel/sdk/config/RequestParams;)V", "backend", "Landroid/os/Bundle;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;)V", "getBackend", "()Landroid/os/Bundle;", EventBody.KEY_VALUE, "", "callerName", "getCallerName", "()Ljava/lang/String;", "setCallerName", "(Ljava/lang/String;)V", "clientId", "getClientId", "clientId$delegate", "Lkotlin/Lazy;", "", "event", "getEvent", "()I", "setEvent", "(I)V", "priority", "getPriority", "setPriority", "reqTime", "", "getReqTime", "()J", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", "targetComponent", "getTargetComponent", "setTargetComponent", LocationMonitorConst.TIMEOUT, "getTimeout", "setTimeout", "(J)V", "traceIdStr", "getTraceIdStr", "traceIdStr$delegate", "useLocalPapaya", "", "getUseLocalPapaya", "()Z", "setUseLocalPapaya", "(Z)V", "useStream", "getUseStream", "setUseStream", "version", "getVersion", CommonConsts.APM_INNER_EVENT_COST_START, "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RequestParams {
    private static final String Args_EventComp = "_EComp";
    public static final String Args_Pid = "_cpid";
    private static final String Args_PkgName = "_PackageName";
    private static final String Args_PostEvent = "_PEvent";
    private static final String Args_SdkVer = "_SdkVer";
    public static final String Args_Uid = "_cuid";
    public static final String Args_llmUsageMode = "_llm_usage_mode";
    public static final int COMPONENT_CLIENT_MGR = 2;
    public static final int COMPONENT_PYVM = 1;
    public static final Companion Companion = null;
    public static final int EVENT_REQUEST_CANCELED = 1;
    public static final int EVENT_REQUEST_COMPLETE = 2;
    public static final int EVENT_REQUEST_EXCEPTION = 3;
    public static final int EVENT_RESUME_PENDING_DOWNLOADS_ON_BIND = 4;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 0;
    public static final int USE_LLM_IN_BACKGROUND_ON_DEMAND = 1;
    private final Bundle backend;
    private final Lazy clientId$delegate;
    private final Lazy traceIdStr$delegate;
    private boolean useLocalPapaya;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/sdk/config/RequestParams$Companion;", "", "()V", "Args_EventComp", "", "Args_Pid", "Args_PkgName", "Args_PostEvent", "Args_SdkVer", "Args_Uid", "Args_llmUsageMode", "COMPONENT_CLIENT_MGR", "", "COMPONENT_PYVM", "EVENT_REQUEST_CANCELED", "EVENT_REQUEST_COMPLETE", "EVENT_REQUEST_EXCEPTION", "EVENT_RESUME_PENDING_DOWNLOADS_ON_BIND", "PRIORITY_HIGH", "PRIORITY_NORMAL", "USE_LLM_IN_BACKGROUND_ON_DEMAND", "ensureCallerInfo", "", "Landroid/os/Bundle;", CrashBody.PID, "uid", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void ensureCallerInfo(Bundle r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            if (r2.containsKey(RequestParams.Args_Pid) == true) goto L6;
            r2.putInt(RequestParams.Args_Pid, r3);
        L6:
            if (r2.containsKey(RequestParams.Args_Uid) == true) goto L9;
            r2.putInt(RequestParams.Args_Uid, r4);
        L9:
            if (r2.containsKey(IdlKeys.Args_TraceId) == true) goto L12;
            r2.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
        L12:
            if (r2.containsKey(IdlKeys.Args_ReqTime) == true) goto L15;
            r2.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        L15:
            if (r2.containsKey(IdlKeys.Args_Priority) == true) goto L18;
            r2.putInt(IdlKeys.Args_Priority, 0);
        L18:
            if (r2.containsKey(IdlKeys.Args_Force_Execute) == true) goto L21;
            r2.putInt(IdlKeys.Args_Force_Execute, 0);
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public RequestParams(Bundle r3, Function1<? super RequestParams, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "backend");
        this.backend = r3;
        this.clientId$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new RequestParams$clientId$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.traceIdStr$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new RequestParams$traceIdStr$2(this), Function0.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L6;
        r5.invoke(this);
        return;
    }

    public /* synthetic */ RequestParams(Bundle r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new Bundle();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams(RequestParams r3) {
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Bundle r0 = new Bundle();
        r0.putAll(r3.backend);
        this(r0, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ String access$getCallerName(RequestParams r0) {
        return r0.getCallerName();
    }

    private final String getCallerName() {
        return this.backend.getString("_PackageName");
    }

    private final void setCallerName(String r2) {
        this.backend.putString("_PackageName", r2);
    }

    public final Bundle getBackend() {
        return this.backend;
    }

    public final String getClientId() {
        return (String) ZeusTransformUtils.preCheckCast(this.clientId$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final int getEvent() {
        return this.backend.getInt(Args_PostEvent);
    }

    public final int getPriority() {
        return this.backend.getInt(IdlKeys.Args_Priority, 0);
    }

    public final long getReqTime() {
        return this.backend.getLong(IdlKeys.Args_ReqTime);
    }

    public final String getSourcePackageName() {
        return this.backend.getString(IdlKeys.Args_SourcePackageName);
    }

    public final int getTargetComponent() {
        return this.backend.getInt(Args_EventComp);
    }

    public final long getTimeout() {
        return this.backend.getLong(IdlKeys.Args_Timeout);
    }

    public final String getTraceIdStr() {
        return (String) ZeusTransformUtils.preCheckCast(this.traceIdStr$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final boolean getUseLocalPapaya() {
        return this.useLocalPapaya;
    }

    public final boolean getUseStream() {
        return this.backend.getBoolean(IdlKeys.Args_StreamingCall);
    }

    public final String getVersion() {
        String r1 = this.backend.getString("version");
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    public final void setEvent(int r2) {
        this.backend.putInt(Args_PostEvent, r2);
    }

    public final void setPriority(int r2) {
        this.backend.putInt(IdlKeys.Args_Priority, r2);
    }

    public final void setSourcePackageName(String r2) {
        this.backend.putString(IdlKeys.Args_SourcePackageName, r2);
    }

    public final void setTargetComponent(int r2) {
        this.backend.putInt(Args_EventComp, r2);
    }

    public final void setTimeout(long r2) {
        this.backend.putLong(IdlKeys.Args_Timeout, r2);
    }

    public final void setUseLocalPapaya(boolean r1) {
        this.useLocalPapaya = r1;
    }

    public final void setUseStream(boolean r2) {
        this.backend.putBoolean(IdlKeys.Args_StreamingCall, r2);
    }

    public final Bundle start() {
        if (this.backend.containsKey("_PackageName") == true) goto L10;
        Bundle r0 = this.backend;
        AIKernelConfig r2 = a.f5987a.a();
        if (r2 == null) goto L7;
        String r3 = r2.getPackageName();
    L8:
        r0.putString("_PackageName", r3);
        goto L10
    L7:
        r3 = null;
    L10:
        if (this.backend.containsKey("_SdkVer") == true) goto L12;
        this.backend.putString("_SdkVer", a.f5987a.b());
    L12:
        AIKernelConfig r1 = a.f5987a.a();
        if (r1 == null) goto L17;
        Function0<Integer> r4 = r1.getLlmUsageMode();
        if (r4 == null) goto L17;
        this.backend.putInt(Args_llmUsageMode, ((Number) ZeusTransformUtils.preCheckCast(r4.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue());
    L17:
        Companion.ensureCallerInfo(this.backend, Process.myPid(), Process.myUid());
        return this.backend;
    }
}
