package com.obric.aikernel.sdk.config;

import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.AIKernelConfig;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
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
    public static final a Companion = null;
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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(Bundle r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            if (r10.containsKey(RequestParams.Args_Pid) == true) goto L6;
            r10.putInt(RequestParams.Args_Pid, r11);
        L6:
            if (r10.containsKey(RequestParams.Args_Uid) == true) goto L9;
            r10.putInt(RequestParams.Args_Uid, r12);
        L9:
            if (r10.containsKey(IdlKeys.Args_TraceId) == true) goto L12;
            r10.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
        L12:
            if (r10.containsKey(IdlKeys.Args_ReqTime) == true) goto L15;
            r10.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        L15:
            if (r10.containsKey(IdlKeys.Args_Priority) == true) goto L18;
            r10.putInt(IdlKeys.Args_Priority, 0);
        L18:
            if (r10.containsKey(IdlKeys.Args_Force_Execute) == true) goto L21;
            r10.putInt(IdlKeys.Args_Force_Execute, 0);
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public RequestParams(Bundle r10, Function1<? super RequestParams, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "backend");
        this.backend = r10;
        this.clientId$delegate = LazyKt.lazy(new RequestParams$clientId$2(this));
        this.traceIdStr$delegate = LazyKt.lazy(new RequestParams$traceIdStr$2(this));
        if (r11 == null) goto L6;
        r11.invoke(this);
        return;
    }

    public /* synthetic */ RequestParams(Bundle r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = new Bundle();
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Bundle r11 = new Bundle();
        r11.putAll(r10.backend);
        this(r11, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ String access$getCallerName(RequestParams r10) {
        return r10.getCallerName();
    }

    private final String getCallerName() {
        return this.backend.getString("_PackageName");
    }

    private final void setCallerName(String r10) {
        this.backend.putString("_PackageName", r10);
    }

    public final Bundle getBackend() {
        return this.backend;
    }

    public final String getClientId() {
        return (String) this.clientId$delegate.getValue();
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
        return (String) this.traceIdStr$delegate.getValue();
    }

    public final boolean getUseLocalPapaya() {
        return this.useLocalPapaya;
    }

    public final boolean getUseStream() {
        return this.backend.getBoolean(IdlKeys.Args_StreamingCall);
    }

    public final String getVersion() {
        String r10 = this.backend.getString("version");
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    public final void setEvent(int r10) {
        this.backend.putInt(Args_PostEvent, r10);
    }

    public final void setPriority(int r10) {
        this.backend.putInt(IdlKeys.Args_Priority, r10);
    }

    public final void setSourcePackageName(String r10) {
        this.backend.putString(IdlKeys.Args_SourcePackageName, r10);
    }

    public final void setTargetComponent(int r10) {
        this.backend.putInt(Args_EventComp, r10);
    }

    public final void setTimeout(long r10) {
        this.backend.putLong(IdlKeys.Args_Timeout, r10);
    }

    public final void setUseLocalPapaya(boolean r10) {
        this.useLocalPapaya = r10;
    }

    public final void setUseStream(boolean r10) {
        this.backend.putBoolean(IdlKeys.Args_StreamingCall, r10);
    }

    public final Bundle start() {
        if (this.backend.containsKey("_PackageName") == true) goto L10;
        Bundle r10 = this.backend;
        AIKernelConfig r11 = f7.a.f8866a.a();
        if (r11 == null) goto L7;
        String r12 = r11.getPackageName();
    L8:
        r10.putString("_PackageName", r12);
        goto L10
    L7:
        r12 = null;
    L10:
        if (this.backend.containsKey("_SdkVer") == true) goto L12;
        this.backend.putString("_SdkVer", f7.a.f8866a.b());
    L12:
        AIKernelConfig r13 = f7.a.f8866a.a();
        if (r13 == null) goto L17;
        Function0<Integer> r14 = r13.getLlmUsageMode();
        if (r14 == null) goto L17;
        this.backend.putInt(Args_llmUsageMode, r14.invoke().intValue());
    L17:
        Companion.a(this.backend, Process.myPid(), Process.myUid());
        return this.backend;
    }
}
