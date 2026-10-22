package com.obric.aikernel.sdk.config;

import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.AIKernelConfig;
import ge.l;
import he.e;
import he.i;
import he.j;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class RequestParams {
    private static final String Args_EventComp = "_EComp";
    public static final String Args_Pid = "_cpid";
    private static final String Args_PkgName = "_PackageName";
    private static final String Args_PostEvent = "_PEvent";
    private static final String Args_SdkVer = "_SdkVer";
    public static final String Args_Uid = "_cuid";
    public static final int COMPONENT_CLIENT_MGR = 2;
    public static final int COMPONENT_PYVM = 1;
    public static final a Companion = null;
    public static final int EVENT_REQUEST_CANCELED = 1;
    public static final int EVENT_REQUEST_COMPLETE = 2;
    public static final int EVENT_REQUEST_EXCEPTION = 3;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 0;
    private final Bundle backend;
    private final xd.b clientId$delegate;
    private final xd.b traceIdStr$delegate;
    private boolean useLocalPapaya;

    public static final class a {
    }

    public static final class b extends j implements ge.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5350a;

        public b(RequestParams r8) {
            this.f5350a = r8;
            super(0);
        }

        @Override // ge.a
        public final String f() {
            RequestParams r8 = this.f5350a;
            Object r10 = RequestParams.access$getCallerName(r8);
            if (r10 != null) goto L6;
            r10 = Integer.valueOf(r8.getBackend().getInt(RequestParams.Args_Uid));
        L6:
            return String.valueOf(r10);
        }
    }

    public static final class c extends j implements ge.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5351a;

        public c(RequestParams r8) {
            this.f5351a = r8;
            super(0);
        }

        @Override // ge.a
        public final String f() {
            return String.valueOf(this.f5351a.getBackend().getString(IdlKeys.Args_TraceId));
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams() {
        Object[] r8 = 0 == true ? 1 : 0;
        this(null, r8, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ String access$getCallerName(RequestParams r8) {
        return r8.getCallerName();
    }

    private final String getCallerName() {
        return this.backend.getString("_PackageName");
    }

    private final void setCallerName(String r8) {
        this.backend.putString("_PackageName", r8);
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
        String r8 = this.backend.getString("version");
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8;
    }

    public final void setEvent(int r8) {
        this.backend.putInt(Args_PostEvent, r8);
    }

    public final void setPriority(int r8) {
        this.backend.putInt(IdlKeys.Args_Priority, r8);
    }

    public final void setSourcePackageName(String r8) {
        this.backend.putString(IdlKeys.Args_SourcePackageName, r8);
    }

    public final void setTargetComponent(int r8) {
        this.backend.putInt(Args_EventComp, r8);
    }

    public final void setTimeout(long r8) {
        this.backend.putLong(IdlKeys.Args_Timeout, r8);
    }

    public final void setUseLocalPapaya(boolean r8) {
        this.useLocalPapaya = r8;
    }

    public final void setUseStream(boolean r8) {
        this.backend.putBoolean(IdlKeys.Args_StreamingCall, r8);
    }

    public final Bundle start() {
        if (this.backend.containsKey("_PackageName") == true) goto L10;
        Bundle r8 = this.backend;
        AIKernelConfig r10 = ra.a.f11538a;
        if (r10 == null) goto L7;
        String r11 = r10.getPackageName();
    L8:
        r8.putString("_PackageName", r11);
        goto L10
    L7:
        r11 = null;
    L10:
        if (this.backend.containsKey("_SdkVer") == true) goto L12;
        this.backend.putString("_SdkVer", ra.a.f11539b);
    L12:
        a r12 = Companion;
        Bundle r13 = this.backend;
        int r14 = Process.myPid();
        int r15 = Process.myUid();
        r12.getClass();
        i.f(r13, "<this>");
        if (r13.containsKey(Args_Pid) == true) goto L16;
        r13.putInt(Args_Pid, r14);
    L16:
        if (r13.containsKey(Args_Uid) == true) goto L19;
        r13.putInt(Args_Uid, r15);
    L19:
        if (r13.containsKey(IdlKeys.Args_TraceId) == true) goto L22;
        r13.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
    L22:
        if (r13.containsKey(IdlKeys.Args_ReqTime) == true) goto L25;
        r13.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
    L25:
        if (r13.containsKey(IdlKeys.Args_Priority) == true) goto L28;
        r13.putInt(IdlKeys.Args_Priority, 0);
    L28:
        if (r13.containsKey(IdlKeys.Args_Force_Execute) == true) goto L31;
        r13.putInt(IdlKeys.Args_Force_Execute, 0);
    L31:
        return this.backend;
    }

    public RequestParams(Bundle r8, l<? super RequestParams, xd.j> r10) {
        i.f(r8, "backend");
        this.backend = r8;
        this.clientId$delegate = defpackage.c.R(new b(this));
        this.traceIdStr$delegate = defpackage.c.R(new c(this));
        if (r10 == null) goto L6;
        r10.invoke(this);
        return;
    }

    public /* synthetic */ RequestParams(Bundle r8, l r10, int r11, e r12) {
        if ((r11 & 1) == 0) goto L6;
        r8 = new Bundle();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParams(RequestParams r8) {
        i.f(r8, "source");
        Bundle r10 = new Bundle();
        r10.putAll(r8.backend);
        this(r10, null, 2, 0 == true ? 1 : 0);
    }
}
