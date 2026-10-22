package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003/01B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\r\u0010#\u001a\u00020\u001eH\u0000¢\u0006\u0002\b$J!\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b&J!\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b)J\u0019\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J \u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ChildProcessLifecycleBinding;", "", "()V", "DEFAULT_RELEASE_DELAY_MS", "", "INFER_LIFECYCLE_SERVICE", "", "LLM_LIFECYCLE_SERVICE", "TAG", "activeBindings", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aikernel/phx/core/conn/ChildProcessLifecycleBinding$BindingRecord;", "pendingBindings", "Lcom/obric/aikernel/phx/core/conn/ChildProcessLifecycleBinding$PendingBinding;", "releaseDelayMsForTest", "getReleaseDelayMsForTest$sdk_release", "()J", "setReleaseDelayMsForTest$sdk_release", "(J)V", "releaseScope", "Lkotlinx/coroutines/CoroutineScope;", "bind", "Lcom/obric/aikernel/phx/core/conn/ProcessLifecycleHandle;", "context", "Landroid/content/Context;", "servicePackage", "targetProcess", "enabled", "", "clearBinding", "", "bindingKey", WsConstants.KEY_CONNECTION, "Landroid/content/ServiceConnection;", "release", "resetBindingsForTest", "resetBindingsForTest$sdk_release", "resolveBindingKey", "resolveBindingKey$sdk_release", "resolveComponent", "Landroid/content/ComponentName;", "resolveComponent$sdk_release", "resolveServiceClassName", "resolveServiceClassName$sdk_release", "unbindIfIdle", "unbindUnpublishedBinding", "appContext", "BindingRecord", "LifecycleLease", "PendingBinding", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChildProcessLifecycleBinding {
    private static final long DEFAULT_RELEASE_DELAY_MS = 300000;
    public static final String INFER_LIFECYCLE_SERVICE = "com.obric.aikernel.InferLifeCycleService";
    public static final ChildProcessLifecycleBinding INSTANCE = null;
    public static final String LLM_LIFECYCLE_SERVICE = "com.obric.aikernel.LLMLifeCycleService";
    private static final String TAG = "ChildLifecycleBinding";
    private static final ConcurrentHashMap<String, BindingRecord> activeBindings = null;
    private static final ConcurrentHashMap<String, PendingBinding> pendingBindings = null;
    private static long releaseDelayMsForTest;
    private static final al releaseScope = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ChildProcessLifecycleBinding$BindingRecord;", "", "appContext", "Landroid/content/Context;", WsConstants.KEY_CONNECTION, "Landroid/content/ServiceConnection;", "activeCount", "", "releaseJob", "Lkotlinx/coroutines/Job;", "(Landroid/content/Context;Landroid/content/ServiceConnection;ILkotlinx/coroutines/Job;)V", "getActiveCount", "()I", "setActiveCount", "(I)V", "getAppContext", "()Landroid/content/Context;", "getConnection", "()Landroid/content/ServiceConnection;", "getReleaseJob", "()Lkotlinx/coroutines/Job;", "setReleaseJob", "(Lkotlinx/coroutines/Job;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class BindingRecord {
        private int activeCount;
        private final Context appContext;
        private final ServiceConnection connection;
        private bx releaseJob;

        public BindingRecord(Context r3, ServiceConnection r4, int r5, bx r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin");
            bx r9 = (bx) ZeusTransformUtils.wrapperContextForParams(r6, bx.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "appContext");
            Intrinsics.checkNotNullParameter(r8, WsConstants.KEY_CONNECTION);
            this.appContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
            this.connection = r8;
            this.activeCount = r5;
            this.releaseJob = r9;
        }

        public /* synthetic */ BindingRecord(Context r2, ServiceConnection r3, int r4, bx r5, int r6, DefaultConstructorMarker r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
            bx r10 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
            if ((r6 & 8) == 0) goto L5;
            r10 = null;
        L5:
            this(r8, r9, r4, r10);
        }

        public static /* synthetic */ BindingRecord copy$default(BindingRecord r1, Context r2, ServiceConnection r3, int r4, bx r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
            bx r10 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
            if ((r6 & 1) == 0) goto L6;
            r8 = r1.appContext;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r9 = r1.connection;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = r1.activeCount;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r10 = r1.releaseJob;
        L15:
            return r1.copy(r8, r9, r4, r10);
        }

        public final Context component1() {
            return this.appContext;
        }

        public final ServiceConnection component2() {
            return this.connection;
        }

        public final int component3() {
            return this.activeCount;
        }

        public final bx component4() {
            return this.releaseJob;
        }

        public final BindingRecord copy(Context r2, ServiceConnection r3, int r4, bx r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
            bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "appContext");
            Intrinsics.checkNotNullParameter(r6, WsConstants.KEY_CONNECTION);
            return new BindingRecord(r1, r6, r4, r7);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, BindingRecord.class) == true) goto L8;
            return false;
        L8:
            BindingRecord r6 = (BindingRecord) ZeusTransformUtils.preCheckCast(r5, BindingRecord.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.appContext, r6.appContext) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.connection, r6.connection) == true) goto L15;
            return false;
        L15:
            if (this.activeCount == r6.activeCount) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.releaseJob, r6.releaseJob) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int getActiveCount() {
            return this.activeCount;
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        public final ServiceConnection getConnection() {
            return this.connection;
        }

        public final bx getReleaseJob() {
            return this.releaseJob;
        }

        public int hashCode() {
            int r0 = ((((this.appContext.hashCode() * 31) + this.connection.hashCode()) * 31) + Integer.hashCode(this.activeCount)) * 31;
            bx r2 = this.releaseJob;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final void setActiveCount(int r1) {
            this.activeCount = r1;
        }

        public final void setReleaseJob(bx r3) {
            this.releaseJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        }

        public String toString() {
            return "BindingRecord(appContext=" + this.appContext + ", connection=" + this.connection + ", activeCount=" + this.activeCount + ", releaseJob=" + this.releaseJob + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ChildProcessLifecycleBinding$LifecycleLease;", "Lcom/obric/aikernel/phx/core/conn/ProcessLifecycleHandle;", "bindingKey", "", "(Ljava/lang/String;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", IslandSession.REOPEN_VALUE_CLOSE, "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class LifecycleLease implements ProcessLifecycleHandle {
        private final String bindingKey;
        private final AtomicBoolean closed;

        public LifecycleLease(String r2) {
            Intrinsics.checkNotNullParameter(r2, "bindingKey");
            this.bindingKey = r2;
            this.closed = new AtomicBoolean(false);
        }

        @Override // com.obric.aikernel.phx.core.conn.ProcessLifecycleHandle
        public void close() {
            if (this.closed.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            ChildProcessLifecycleBinding.access$release(ChildProcessLifecycleBinding.INSTANCE, this.bindingKey);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ChildProcessLifecycleBinding$PendingBinding;", "", WsConstants.KEY_CONNECTION, "Landroid/content/ServiceConnection;", "(Landroid/content/ServiceConnection;)V", "cleared", "", "getCleared", "()Z", "setCleared", "(Z)V", "getConnection", "()Landroid/content/ServiceConnection;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class PendingBinding {
        private boolean cleared;
        private final ServiceConnection connection;

        public PendingBinding(ServiceConnection r3) {
            ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, WsConstants.KEY_CONNECTION);
            this.connection = r4;
        }

        public final boolean getCleared() {
            return this.cleared;
        }

        public final ServiceConnection getConnection() {
            return this.connection;
        }

        public final void setCleared(boolean r1) {
            this.cleared = r1;
        }
    }

    static {
        INSTANCE = new ChildProcessLifecycleBinding();
        activeBindings = new ConcurrentHashMap();
        pendingBindings = new ConcurrentHashMap();
        releaseScope = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
        releaseDelayMsForTest = 300000;
    }

    private ChildProcessLifecycleBinding() {
    }

    public static final /* synthetic */ void access$clearBinding(ChildProcessLifecycleBinding r2, String r3, ServiceConnection r4) {
        r2.clearBinding(r3, (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$release(ChildProcessLifecycleBinding r0, String r1) {
        r0.release(r1);
    }

    public static final /* synthetic */ void access$unbindIfIdle(ChildProcessLifecycleBinding r0, String r1) {
        r0.unbindIfIdle(r1);
    }

    public static /* synthetic */ ProcessLifecycleHandle bind$default(ChildProcessLifecycleBinding r1, Context r2, String r3, String r4, boolean r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L11;
        AIKernelConfig r9 = a.f5987a.a();
        if (r9 != null) goto L7;
    L9:
        r5 = false;
        goto L11
    L7:
        if (r9.getChildProcessImportantBindEnabled() != true) goto L9;
        r5 = true;
    L11:
        return r1.bind(r8, r3, r4, r5);
    }

    private final void clearBinding(String r7, ServiceConnection r8) {
        ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r8, ServiceConnection.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        PendingBinding r0 = (PendingBinding) ZeusTransformUtils.preCheckCast(pendingBindings.get(r7), PendingBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r0 == null) goto L7;
        ServiceConnection r2 = r0.getConnection();     // Catch: Throwable -> L23
    L9:
        if (Intrinsics.areEqual(r2, r9) == false) goto L11;
        r0.setCleared(true);     // Catch: Throwable -> L23
    L11:
        ConcurrentHashMap<String, BindingRecord> r1 = activeBindings;     // Catch: Throwable -> L23
        BindingRecord r3 = (BindingRecord) ZeusTransformUtils.preCheckCast(r1.get(r7), BindingRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r3 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        Intrinsics.checkNotNullExpressionValue(r3, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r3.getConnection(), r9) == false) goto L20;
        r1.remove(r7);     // Catch: Throwable -> L23
        bx r10 = r3.getReleaseJob();     // Catch: Throwable -> L23
        if (r10 == null) goto L20;
        bx.a.a(r10, null, 1, null);     // Catch: Throwable -> L23
    L20:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L7:
        r2 = null;
    L23:
        th = move-exception;
        throw th;
    }

    private final void release(String r8) {
        monitor-enter(this);
        BindingRecord r0 = (BindingRecord) ZeusTransformUtils.preCheckCast(activeBindings.get(r8), BindingRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Intrinsics.checkNotNullExpressionValue(r0, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L19
        if (r0.getActiveCount() <= 0) goto L11;
        r0.setActiveCount(r0.getActiveCount() - 1);     // Catch: Throwable -> L19
    L11:
        if (r0.getActiveCount() != 0) goto L16;
        bx r1 = r0.getReleaseJob();     // Catch: Throwable -> L19
        if (r1 == null) goto L15;
        bx.a.a(r1, null, 1, null);     // Catch: Throwable -> L19
    L15:
        r0.setReleaseJob(i.a(releaseScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ChildProcessLifecycleBinding$release$1$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));     // Catch: Throwable -> L19
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private final void unbindIfIdle(String r5) {
        monitor-enter(this);
        ConcurrentHashMap<String, BindingRecord> r0 = activeBindings;     // Catch: Throwable -> L21
        BindingRecord r1 = (BindingRecord) ZeusTransformUtils.preCheckCast(r0.get(r5), BindingRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r1 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Intrinsics.checkNotNullExpressionValue(r1, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L21
        if (r1.getActiveCount() == 0) goto L11;
        monitor-exit(this);
        return;
    L11:
        r0.remove(r5);     // Catch: Throwable -> L21
        r1.setReleaseJob(null);     // Catch: Throwable -> L21
        monitor-exit(this);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        ChildProcessLifecycleBinding r4 = (ChildProcessLifecycleBinding) ZeusTransformUtils.preCheckCast(this, ChildProcessLifecycleBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        ZeusTransformUtils.unbindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getAppContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1.getConnection(), "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L28;
        AIKLog.INSTANCE.w(TAG, "unbind child lifecycle service failed, key=" + r5 + ' ' + r7);
        return;
    L28:
        return;
    L15:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        throw th;
    }

    private final void unbindUnpublishedBinding(Context r3, ServiceConnection r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r7 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ChildProcessLifecycleBinding r2 = (ChildProcessLifecycleBinding) ZeusTransformUtils.preCheckCast(this, ChildProcessLifecycleBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        ZeusTransformUtils.unbindService(r6, r7, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L13;
        AIKLog.INSTANCE.w(TAG, "unbind unpublished child lifecycle service failed, key=" + r5 + ' ' + r9);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final ProcessLifecycleHandle bind(Context r12, String r13, String r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "servicePackage");
        if (r15 == true) goto L9;
        AIKLog.INSTANCE.d(TAG, "skip child lifecycle important bind by config, process=" + r14);
    L5:
        Object r11 = NoOpProcessLifecycleHandle.INSTANCE;
    L7:
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(r11, ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");
    L9:
        if (r16 == null) goto L11;
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L12:
        if (r17 == null) goto L5;
        ComponentName r0 = resolveComponent$sdk_release(r13, r14);
        if (r0 == null) goto L5;
        final String r18 = resolveBindingKey$sdk_release(r13, r14);
        if (r18 == null) goto L5;
        ServiceConnection r7 = new ChildProcessLifecycleBinding$bind$connection$1(r18);
        Intent r1 = new Intent();
        r1.setComponent(r0);
        monitor-enter(this);
        BindingRecord r2 = (BindingRecord) ZeusTransformUtils.preCheckCast(activeBindings.get(r18), BindingRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        boolean r8 = true;
        if (r2 == null) goto L30;
        r2.setActiveCount(r2.getActiveCount() + 1);     // Catch: Throwable -> L67
        bx r19 = r2.getReleaseJob();     // Catch: Throwable -> L67
        if (r19 == null) goto L27;
        bx.a.a(r19, null, 1, null);     // Catch: Throwable -> L67
    L27:
        r2.setReleaseJob(null);     // Catch: Throwable -> L67
        ProcessLifecycleHandle r110 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(new LifecycleLease(r18), ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        monitor-exit(this);
        return r110;
    L30:
        ConcurrentHashMap<String, PendingBinding> r111 = pendingBindings;     // Catch: Throwable -> L67
        if (r111.containsKey(r18) == false) goto L35;
        AIKLog.INSTANCE.d(TAG, "skip child lifecycle bind, pending process=" + r14);     // Catch: Throwable -> L67
        ProcessLifecycleHandle r112 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        monitor-exit(this);
        return r112;
    L35:
        PendingBinding r3 = new PendingBinding((ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L67
        ((Map) ZeusTransformUtils.preCheckCast(r111, Map.class, "com.obric.memorydata.plugin")).put(r18, r3);     // Catch: Throwable -> L67
        monitor-exit(this);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L39
        ChildProcessLifecycleBinding r114 = (ChildProcessLifecycleBinding) ZeusTransformUtils.preCheckCast(this, ChildProcessLifecycleBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        Object r115 = Result.m1421constructorimpl(Boolean.valueOf(ProcessPriorityBindingKt.bindForChildProcessPriority(r17, r1, bo.a(ba.c()), (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L39
    L41:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r115);
        if (r4 == null) goto L45;
        AIKLog.INSTANCE.w(TAG, "bind child lifecycle service failed, process=" + r14 + ' ' + r4);
    L45:
        if (Result.m1427isFailureimpl(r115) == false) goto L47;
        r115 = false;
    L47:
        boolean r116 = ((Boolean) ZeusTransformUtils.preCheckCast(r115, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        monitor-enter(this);
        ConcurrentHashMap<String, PendingBinding> r5 = pendingBindings;     // Catch: Throwable -> L64
        if (Intrinsics.areEqual(r5.get(r18), r3) == true) goto L52;
    L51:
        r8 = false;
    L58:
        monitor-exit(this);
        if (r8 == true) goto L63;
        if (r116 == true) goto L62;
        AIKLog.INSTANCE.i(TAG, "skip bind child lifecycle service, process=" + r14 + " result=false");
        goto L5
    L62:
        AIKLog.INSTANCE.i(TAG, "skip bind child lifecycle service, process=" + r14 + " connection cleared");
        unbindUnpublishedBinding(r17, (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.memorydata.plugin"), r18);
        goto L5
    L63:
        r11 = new LifecycleLease(r18);
        goto L7
    L52:
        r5.remove(r18);     // Catch: Throwable -> L64
        if (r116 == false) goto L51;
        if (r3.getCleared() == true) goto L51;
        ((Map) ZeusTransformUtils.preCheckCast(activeBindings, Map.class, "com.obric.memorydata.plugin")).put(r18, new BindingRecord(r17, (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.memorydata.plugin"), 1, null, 8, null));     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;
    L39:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r115 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L67:
        th = move-exception;
        throw th;
    L11:
        r17 = null;
        goto L12
    }

    public final long getReleaseDelayMsForTest$sdk_release() {
        return releaseDelayMsForTest;
    }

    public final void resetBindingsForTest$sdk_release() {
        monitor-enter(this);
        Collection<BindingRecord> r0 = activeBindings.values();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullExpressionValue(r0, "activeBindings.values");     // Catch: Throwable -> L12
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L9;
        bx r2 = ((BindingRecord) ZeusTransformUtils.preCheckCast(r1.next(), BindingRecord.class, "com.obric.memorydata.plugin")).getReleaseJob();     // Catch: Throwable -> L12
        if (r2 == null) goto L5;
        bx.a.a(r2, null, 1, null);     // Catch: Throwable -> L12
        goto L5
    L9:
        activeBindings.clear();     // Catch: Throwable -> L12
        pendingBindings.clear();     // Catch: Throwable -> L12
        releaseDelayMsForTest = 300000;     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final String resolveBindingKey$sdk_release(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "servicePackage");
        String r1 = resolveServiceClassName$sdk_release(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r2 + '/' + r1;
    }

    public final ComponentName resolveComponent$sdk_release(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "servicePackage");
        String r1 = resolveServiceClassName$sdk_release(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return new ComponentName(r2, r1);
    }

    public final String resolveServiceClassName$sdk_release(String r5) {
        boolean r1 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        return INFER_LIFECYCLE_SERVICE;
    L10:
        if (r5 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L19;
        return LLM_LIFECYCLE_SERVICE;
    L19:
        return null;
    L12:
        if (StringsKt.endsWith$default(r5, ":llm", false, 2, null) != true) goto L14;
    L5:
        if (StringsKt.endsWith$default(r5, ":infer", false, 2, null) != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void setReleaseDelayMsForTest$sdk_release(long r1) {
        releaseDelayMsForTest = r1;
    }
}
