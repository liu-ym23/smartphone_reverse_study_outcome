package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.a;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0002\u000f\u001a\u0018\u0000 B2\u00020\u0001:\u0004ABCDB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020!H\u0003J\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\b\u0010'\u001a\u00020(H\u0003J\u001b\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020+H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001d\u0010.\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010/\u001a\u000200H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\u001f\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u0010/\u001a\u000200H\u0080@ø\u0001\u0000¢\u0006\u0004\b4\u00101J\b\u00105\u001a\u00020\u0018H\u0003J\b\u00106\u001a\u00020(H\u0002J\u0010\u00107\u001a\u0002002\u0006\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u00020(H\u0003J\u0015\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\u0018H\u0000¢\u0006\u0002\b<J\r\u0010=\u001a\u00020(H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0014H\u0002R\u0012\u0010\t\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector;", "", "context", "Landroid/content/Context;", "aiKernelConfig", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "connName", "Landroid/content/ComponentName;", "(Landroid/content/Context;Lcom/obric/aikernel/sdk/AIKernelConfig;Landroid/content/ComponentName;)V", "activeRequestCount", "", "connectTask", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/aikernel/AIKBinder;", WsConstants.KEY_CONNECTION, "com/obric/aikernel/phx/core/conn/ServiceConnector$connection$1", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$connection$1;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "idleReleaseJob", "Lkotlinx/coroutines/Job;", "idleReleaseScope", "Lkotlinx/coroutines/CoroutineScope;", "idleReleaseSuppressedForCurrentBinding", "", "lifeCycleConnection", "com/obric/aikernel/phx/core/conn/ServiceConnector$lifeCycleConnection$1", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$lifeCycleConnection$1;", "lifecycleServiceBound", "mainServiceBound", "mainServiceIdleReleaseEnabled", "remote", "acquireMainProcessIpcLease", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcLease;", "acquireMainProcessIpcLease$sdk_release", "acquireMainProcessIpcLeaseLocked", "bindingStateSnapshotForTest", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$BindingStateSnapshot;", "bindingStateSnapshotForTest$sdk_release", "clearMainBindingStateLocked", "", "connectViaAuthProvider", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectViaBindService", "getService", LocationMonitorConst.TIMEOUT, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServiceWithMainProcessIpcLease", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcBinding;", "getServiceWithMainProcessIpcLease$sdk_release", "isIdleReleaseActiveLocked", "releaseMainProcessIpcLease", "remainMs", "deadlineMs", "scheduleIdleReleaseLocked", "setMainServiceIdleReleaseEnabled", "enable", "setMainServiceIdleReleaseEnabled$sdk_release", "suppressIdleReleaseForCurrentBinding", "suppressIdleReleaseForCurrentBinding$sdk_release", "unbindIfIdle", "expectedJob", "BindingStateSnapshot", "Companion", "MainProcessIpcBinding", "MainProcessIpcLease", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ServiceConnector {
    public static final long BINDER_TIMEOUT = 5000;
    public static final Companion Companion = null;
    private static final String TAG = "ServiceConnector";
    private int activeRequestCount;
    private final AIKernelConfig aiKernelConfig;
    private final ComponentName connName;
    private ar<? extends a> connectTask;
    private final ServiceConnector$connection$1 connection;
    private final Context context;
    private volatile n<? super a> continuation;
    private bx idleReleaseJob;
    private final al idleReleaseScope;
    private volatile boolean idleReleaseSuppressedForCurrentBinding;
    private final ServiceConnector$lifeCycleConnection$1 lifeCycleConnection;
    private boolean lifecycleServiceBound;
    private boolean mainServiceBound;
    private volatile boolean mainServiceIdleReleaseEnabled;
    private volatile a remote;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector$BindingStateSnapshot;", "", "mainServiceIdleReleaseEnabled", "", "idleReleaseSuppressedForCurrentBinding", "mainServiceBound", "lifecycleServiceBound", "activeRequestCount", "", "idleReleaseScheduled", "hasRemote", "(ZZZZIZZ)V", "getActiveRequestCount", "()I", "getHasRemote", "()Z", "getIdleReleaseScheduled", "getIdleReleaseSuppressedForCurrentBinding", "getLifecycleServiceBound", "getMainServiceBound", "getMainServiceIdleReleaseEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BindingStateSnapshot {
        private final int activeRequestCount;
        private final boolean hasRemote;
        private final boolean idleReleaseScheduled;
        private final boolean idleReleaseSuppressedForCurrentBinding;
        private final boolean lifecycleServiceBound;
        private final boolean mainServiceBound;
        private final boolean mainServiceIdleReleaseEnabled;

        public BindingStateSnapshot(boolean r1, boolean r2, boolean r3, boolean r4, int r5, boolean r6, boolean r7) {
            this.mainServiceIdleReleaseEnabled = r1;
            this.idleReleaseSuppressedForCurrentBinding = r2;
            this.mainServiceBound = r3;
            this.lifecycleServiceBound = r4;
            this.activeRequestCount = r5;
            this.idleReleaseScheduled = r6;
            this.hasRemote = r7;
        }

        public static /* synthetic */ BindingStateSnapshot copy$default(BindingStateSnapshot r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.mainServiceIdleReleaseEnabled;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.idleReleaseSuppressedForCurrentBinding;
        L8:
            boolean r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.mainServiceBound;
        L11:
            boolean r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.lifecycleServiceBound;
        L14:
            boolean r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.activeRequestCount;
        L17:
            int r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.idleReleaseScheduled;
        L20:
            boolean r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.hasRemote;
        L23:
            boolean r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final boolean component1() {
            return this.mainServiceIdleReleaseEnabled;
        }

        public final boolean component2() {
            return this.idleReleaseSuppressedForCurrentBinding;
        }

        public final boolean component3() {
            return this.mainServiceBound;
        }

        public final boolean component4() {
            return this.lifecycleServiceBound;
        }

        public final int component5() {
            return this.activeRequestCount;
        }

        public final boolean component6() {
            return this.idleReleaseScheduled;
        }

        public final boolean component7() {
            return this.hasRemote;
        }

        public final BindingStateSnapshot copy(boolean r9, boolean r10, boolean r11, boolean r12, int r13, boolean r14, boolean r15) {
            return new BindingStateSnapshot(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, BindingStateSnapshot.class) == true) goto L8;
            return false;
        L8:
            BindingStateSnapshot r6 = (BindingStateSnapshot) ZeusTransformUtils.preCheckCast(r5, BindingStateSnapshot.class, "com.obric.memorydata.plugin");
            if (this.mainServiceIdleReleaseEnabled == r6.mainServiceIdleReleaseEnabled) goto L12;
            return false;
        L12:
            if (this.idleReleaseSuppressedForCurrentBinding == r6.idleReleaseSuppressedForCurrentBinding) goto L15;
            return false;
        L15:
            if (this.mainServiceBound == r6.mainServiceBound) goto L18;
            return false;
        L18:
            if (this.lifecycleServiceBound == r6.lifecycleServiceBound) goto L21;
            return false;
        L21:
            if (this.activeRequestCount == r6.activeRequestCount) goto L24;
            return false;
        L24:
            if (this.idleReleaseScheduled == r6.idleReleaseScheduled) goto L27;
            return false;
        L27:
            if (this.hasRemote == r6.hasRemote) goto L29;
            return false;
        L29:
            return true;
        }

        public final int getActiveRequestCount() {
            return this.activeRequestCount;
        }

        public final boolean getHasRemote() {
            return this.hasRemote;
        }

        public final boolean getIdleReleaseScheduled() {
            return this.idleReleaseScheduled;
        }

        public final boolean getIdleReleaseSuppressedForCurrentBinding() {
            return this.idleReleaseSuppressedForCurrentBinding;
        }

        public final boolean getLifecycleServiceBound() {
            return this.lifecycleServiceBound;
        }

        public final boolean getMainServiceBound() {
            return this.mainServiceBound;
        }

        public final boolean getMainServiceIdleReleaseEnabled() {
            return this.mainServiceIdleReleaseEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        public int hashCode() {
            boolean r0 = this.mainServiceIdleReleaseEnabled;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.idleReleaseSuppressedForCurrentBinding;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.mainServiceBound;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.lifecycleServiceBound;
            ?? r11 = r10;
            if (r10 == false) goto L14;
            r11 = 1;
        L14:
            int r12 = (((r9 + r11) * 31) + Integer.hashCode(this.activeRequestCount)) * 31;
            boolean r13 = this.idleReleaseScheduled;
            ?? r14 = r13;
            if (r13 == false) goto L17;
            r14 = 1;
        L17:
            int r15 = (r12 + r14) * 31;
            boolean r16 = this.hasRemote;
            if (r16 == true) goto L22;
            r1 = r16;
        L22:
            return r15 + r1;
        }

        public String toString() {
            return "BindingStateSnapshot(mainServiceIdleReleaseEnabled=" + this.mainServiceIdleReleaseEnabled + ", idleReleaseSuppressedForCurrentBinding=" + this.idleReleaseSuppressedForCurrentBinding + ", mainServiceBound=" + this.mainServiceBound + ", lifecycleServiceBound=" + this.lifecycleServiceBound + ", activeRequestCount=" + this.activeRequestCount + ", idleReleaseScheduled=" + this.idleReleaseScheduled + ", hasRemote=" + this.hasRemote + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector$Companion;", "", "()V", "BINDER_TIMEOUT", "", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcBinding;", "Ljava/io/Closeable;", "binder", "Lcom/obric/aikernel/AIKBinder;", "lease", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcLease;", "(Lcom/obric/aikernel/AIKBinder;Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcLease;)V", "getBinder", "()Lcom/obric/aikernel/AIKBinder;", IslandSession.REOPEN_VALUE_CLOSE, "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MainProcessIpcBinding implements Closeable {
        private final a binder;
        private final MainProcessIpcLease lease;

        public MainProcessIpcBinding(a r3, MainProcessIpcLease r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "binder");
            Intrinsics.checkNotNullParameter(r4, "lease");
            this.binder = r5;
            this.lease = r4;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.lease.close();
        }

        public final a getBinder() {
            return this.binder;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcLease;", "Ljava/io/Closeable;", "connector", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector;", "(Lcom/obric/aikernel/phx/core/conn/ServiceConnector;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", IslandSession.REOPEN_VALUE_CLOSE, "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MainProcessIpcLease implements Closeable {
        private final AtomicBoolean closed;
        private final ServiceConnector connector;

        public MainProcessIpcLease(ServiceConnector r2) {
            this.connector = r2;
            this.closed = new AtomicBoolean(false);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed.compareAndSet(false, true) == false) goto L8;
            ServiceConnector r3 = this.connector;
            if (r3 == null) goto L9;
            ServiceConnector.access$releaseMainProcessIpcLease(r3);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/AIKBinder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2", f = "ServiceConnector.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super a>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ServiceConnector this$0;

        AnonymousClass2(ServiceConnector r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super a> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super a> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            IBinder r3 = null;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7
        L56:
            Object r13 = Result.m1421constructorimpl((a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        L59:
            Throwable r2 = Result.m1424exceptionOrNullimpl(r13);
            if (r2 == null) goto L63;
            AIKLog.INSTANCE.w(ServiceConnector.TAG, "connectTask failed by " + r2);
        L63:
            if (Result.m1427isFailureimpl(r13) == false) goto L65;
            r13 = null;
        L65:
            a r14 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L80;
            ServiceConnector r11 = this.this$0;
            AIKLog r4 = AIKLog.INSTANCE;
            StringBuilder r5 = new StringBuilder().append("await finished ");
            a r15 = ServiceConnector.access$getRemote$p(r11);
            if (r15 == null) goto L70;
            r3 = r15.asBinder();
        L70:
            r4.v(ServiceConnector.TAG, r5.append(r3).toString());
            return r14;
        L80:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r12);
            al r16 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            ServiceConnector r17 = this.this$0;
            monitor-enter(r17);
            a r6 = ServiceConnector.access$getRemote$p(r17);     // Catch: Throwable -> L72
            boolean r7 = false;
            if (r6 == null) goto L20;
            IBinder r8 = r6.asBinder();     // Catch: Throwable -> L72
            if (r8 == null) goto L20;
            if (r8.isBinderAlive() != true) goto L20;
            boolean r9 = true;
        L22:
            if (r9 == true) goto L39;
            AIKLog r10 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r18 = new StringBuilder().append("should rebind ");     // Catch: Throwable -> L72
            a r19 = ServiceConnector.access$getRemote$p(r17);     // Catch: Throwable -> L72
            if (r19 == null) goto L26;
            IBinder r20 = r19.asBinder();     // Catch: Throwable -> L72
        L27:
            StringBuilder r21 = r18.append(r20).append(' ').append(ServiceConnector.access$getConnectTask$p(r17)).append(' ');     // Catch: Throwable -> L72
            ar r22 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            if (r22 == null) goto L30;
            Boolean r23 = Boxing.boxBoolean(r22.q_());     // Catch: Throwable -> L72
        L31:
            r10.d(ServiceConnector.TAG, r21.append(r23).toString());     // Catch: Throwable -> L72
            ar r24 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            if (r24 != null) goto L34;
        L36:
            if (r7 == false) goto L39;
            ServiceConnector.access$setConnectTask$p(r17, null);     // Catch: Throwable -> L72
            goto L39
        L34:
            if (r24.q_() != true) goto L36;
            r7 = true;
            goto L36
        L30:
            r23 = null;
            goto L31
        L26:
            r20 = null;
        L39:
            if (ServiceConnector.access$getConnectTask$p(r17) != null) goto L45;
            AIKLog r25 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r26 = new StringBuilder().append("new task ");     // Catch: Throwable -> L72
            a r27 = ServiceConnector.access$getRemote$p(r17);     // Catch: Throwable -> L72
            if (r27 == null) goto L43;
            IBinder r28 = r27.asBinder();     // Catch: Throwable -> L72
        L44:
            r25.i(ServiceConnector.TAG, r26.append(r28).toString());     // Catch: Throwable -> L72
            ServiceConnector.access$setConnectTask$p(r17, i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ServiceConnector$getService$2$1$1(r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));     // Catch: Throwable -> L72
            i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ServiceConnector$getService$2$1$2(ServiceConnector.access$getConnectTask$p(r17), null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L72
        L50:
            ar r29 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            monitor-exit(r17);
            if (r29 == null) goto L79;
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r12 = r29.a(this);     // Catch: Throwable -> L7
            if (r12 != r0) goto L56;
            return r0;
        L79:
            return null;
        L43:
            r28 = null;
            goto L44
        L45:
            AIKLog r30 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r31 = new StringBuilder().append("reuse task ").append(ServiceConnector.access$getConnectTask$p(r17)).append(' ');     // Catch: Throwable -> L72
            ar r32 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            if (r32 == null) goto L48;
            Boolean r33 = Boxing.boxBoolean(r32.q_());     // Catch: Throwable -> L72
        L49:
            r30.d(ServiceConnector.TAG, r31.append(r33).toString());     // Catch: Throwable -> L72
            goto L50
        L48:
            r33 = null;
        L20:
            r9 = false;
        L72:
            th = move-exception;
            throw th;
        L7:
            th = move-exception;
            Result.Companion r34 = Result.Companion;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L59
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.obric.aikernel.phx.core.conn.ServiceConnector$connection$1] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.obric.aikernel.phx.core.conn.ServiceConnector$lifeCycleConnection$1] */
    public ServiceConnector(Context r3, AIKernelConfig r4, ComponentName r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r4, "aiKernelConfig");
        Intrinsics.checkNotNullParameter(r5, "connName");
        this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.aiKernelConfig = r4;
        this.connName = r5;
        this.idleReleaseScope = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        this.connection = new ServiceConnector$connection$1(this);
        this.lifeCycleConnection = new ServiceConnector$lifeCycleConnection$1(this);
    }

    public static final /* synthetic */ void access$clearMainBindingStateLocked(ServiceConnector r0) {
        r0.clearMainBindingStateLocked();
    }

    public static final /* synthetic */ Object access$connectViaAuthProvider(ServiceConnector r2, Intent r3, Continuation r4) {
        return r2.connectViaAuthProvider(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$connectViaBindService(ServiceConnector r2, Intent r3, Continuation r4) {
        return r2.connectViaBindService(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ AIKernelConfig access$getAiKernelConfig$p(ServiceConnector r0) {
        return r0.aiKernelConfig;
    }

    public static final /* synthetic */ ComponentName access$getConnName$p(ServiceConnector r0) {
        return r0.connName;
    }

    public static final /* synthetic */ ar access$getConnectTask$p(ServiceConnector r0) {
        return r0.connectTask;
    }

    public static final /* synthetic */ n access$getContinuation$p(ServiceConnector r0) {
        return r0.continuation;
    }

    public static final /* synthetic */ a access$getRemote$p(ServiceConnector r0) {
        return r0.remote;
    }

    public static final /* synthetic */ void access$releaseMainProcessIpcLease(ServiceConnector r0) {
        r0.releaseMainProcessIpcLease();
    }

    public static final /* synthetic */ void access$scheduleIdleReleaseLocked(ServiceConnector r0) {
        r0.scheduleIdleReleaseLocked();
    }

    public static final /* synthetic */ void access$setConnectTask$p(ServiceConnector r2, ar r3) {
        r2.connectTask = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setContinuation$p(ServiceConnector r2, n r3) {
        r2.continuation = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setLifecycleServiceBound$p(ServiceConnector r0, boolean r1) {
        r0.lifecycleServiceBound = r1;
    }

    public static final /* synthetic */ void access$setMainServiceBound$p(ServiceConnector r0, boolean r1) {
        r0.mainServiceBound = r1;
    }

    public static final /* synthetic */ void access$setRemote$p(ServiceConnector r2, a r3) {
        r2.remote = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$unbindIfIdle(ServiceConnector r2, bx r3) {
        r2.unbindIfIdle((bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin"));
    }

    private final MainProcessIpcLease acquireMainProcessIpcLeaseLocked() {
        if (isIdleReleaseActiveLocked() == false) goto L5;
        this.activeRequestCount++;
        bx r0 = this.idleReleaseJob;
        if (r0 == null) goto L9;
        bx.a.a(r0, null, 1, null);
    L9:
        this.idleReleaseJob = null;
        return new MainProcessIpcLease(this);
    L5:
        return new MainProcessIpcLease(null);
    }

    private final void clearMainBindingStateLocked() {
        bx r0 = this.idleReleaseJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.idleReleaseJob = null;
        n<? super a> r1 = this.continuation;
        if (r1 != null) goto L8;
    L13:
        this.continuation = null;
        this.connectTask = null;
        this.activeRequestCount = 0;
        this.mainServiceBound = false;
        this.lifecycleServiceBound = false;
        this.idleReleaseSuppressedForCurrentBinding = false;
        return;
    L8:
        if (r1.a() == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        ExtsKt.resume((Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin"), null);
        goto L13
    }

    private final Object connectViaAuthProvider(Intent r7, Continuation<? super a> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        ContentResolver r0 = this.context.getContentResolver();
        Bundle r4 = new Bundle();
        r4.putParcelable(MemorySourceLinkType.INTENT, (Parcelable) ZeusTransformUtils.preCheckCast(r7, Parcelable.class, "com.obric.memorydata.plugin"));
        Unit r10 = Unit.INSTANCE;
        Bundle r11 = ZeusProviderTransform.call(r0, "com.obric.aikernel.service.auth", "onBind", null, r4, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        IBinder r12 = r11.getBinder("binder");
        if (r12 == null) goto L23;
        a r13 = a.AbstractBinderC0246a.a(r12);
        if (r13 == null) goto L23;
        this.remote = r13;
        boolean r14 = false;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        ServiceConnector r2 = (ServiceConnector) ZeusTransformUtils.preCheckCast(this, ServiceConnector.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Context r3 = r2.context;     // Catch: Throwable -> L11
        Intent r5 = new Intent();     // Catch: Throwable -> L11
        r5.setComponent(new ComponentName(r2.connName.getPackageName(), "com.obric.aikernel.LifeCycleService"));     // Catch: Throwable -> L11
        r14 = ProcessPriorityBindingKt.bindAutoCreate(r3, r5, bo.a(ba.c()), (ServiceConnection) ZeusTransformUtils.preCheckCast(r2.lifeCycleConnection, ServiceConnection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r6);
        if (r15 == null) goto L16;
        AIKLog.INSTANCE.w(TAG, "bind lifecycle service failed: " + r15);
    L16:
        monitor-enter(this);
        this.lifecycleServiceBound = r14;     // Catch: Throwable -> L20
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        AIKLog.INSTANCE.i(TAG, "auth provider got binder, lifecycleBound=" + r14);
        return r13;
    L20:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L23:
        return null;
    }

    private final Object connectViaBindService(Intent r6, Continuation<? super a> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        boolean r9 = ProcessPriorityBindingKt.bindAutoCreate(this.context, r6, bo.a(ba.c()), (ServiceConnection) ZeusTransformUtils.preCheckCast(this.connection, ServiceConnection.class, "com.obric.memorydata.plugin"));
        monitor-enter(this);
        this.mainServiceBound = r9;     // Catch: Throwable -> L20
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        AIKLog.INSTANCE.i(TAG, "start binding to " + this.connName + ", result = " + r9);
        boolean r1 = true;
        o r10 = new o(IntrinsicsKt.intercepted(r8), 1);
        r10.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.memorydata.plugin");
        access$setContinuation$p(this, r2);
        a r3 = access$getRemote$p(this);
        if (r3 == null) goto L13;
        IBinder r4 = r3.asBinder();
        if (r4 == null) goto L13;
        if (r4.isBinderAlive() != true) goto L13;
    L14:
        if (r1 == false) goto L16;
        ExtsKt.resume((Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin"), access$getRemote$p(this));
    L16:
        Object r5 = r10.h();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L19:
        return r5;
    L13:
        r1 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Object getService$default(ServiceConnector r1, long r2, Continuation r4, int r5, Object r6) {
        Continuation<? super a> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 5000;
    L6:
        return r1.getService(r2, r7);
    }

    public static /* synthetic */ Object getServiceWithMainProcessIpcLease$sdk_release$default(ServiceConnector r1, long r2, Continuation r4, int r5, Object r6) {
        Continuation<? super MainProcessIpcBinding> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 5000;
    L6:
        return r1.getServiceWithMainProcessIpcLease$sdk_release(r2, r7);
    }

    private final boolean isIdleReleaseActiveLocked() {
        if (this.mainServiceIdleReleaseEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (this.idleReleaseSuppressedForCurrentBinding == true) goto L9;
        if (this.aiKernelConfig.getMainServiceIdleUnbindTimeoutMs() < 0) goto L9;
        return true;
    }

    private final void releaseMainProcessIpcLease() {
        monitor-enter(this);
        int r0 = this.activeRequestCount;     // Catch: Throwable -> L10
        if (r0 <= 0) goto L6;
        this.activeRequestCount = r0 - 1;     // Catch: Throwable -> L10
    L7:
        scheduleIdleReleaseLocked();     // Catch: Throwable -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        AIKLog.INSTANCE.w(TAG, "main process ipc lease released with no active request.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private final long remainMs(long r3) {
        return Math.max(r3 - System.currentTimeMillis(), 0);
    }

    private final void scheduleIdleReleaseLocked() {
        if (isIdleReleaseActiveLocked() == true) goto L5;
        return;
    L5:
        a r0 = this.remote;
        boolean r1 = false;
        if (r0 == null) goto L12;
        IBinder r2 = r0.asBinder();
        if (r2 == null) goto L12;
        if (r2.isBinderAlive() != true) goto L12;
        r1 = true;
    L12:
        if (r1 == true) goto L15;
        return;
    L15:
        if (this.activeRequestCount <= 0) goto L17;
        return;
    L17:
        bx r3 = this.idleReleaseJob;
        if (r3 == null) goto L20;
        bx.a.a(r3, null, 1, null);
    L20:
        this.idleReleaseJob = i.a(this.idleReleaseScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ServiceConnector$scheduleIdleReleaseLocked$job$1(this.aiKernelConfig.getMainServiceIdleUnbindTimeoutMs(), this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void unbindIfIdle(bx r8) {
        bx r9 = (bx) ZeusTransformUtils.wrapperContextForParams(r8, bx.class, "com.obric.memorydata.plugin");
        AIKLog.INSTANCE.d(TAG, "[idleRelease] unbindIfIdle invoked, expectedJob=" + r9 + ", isActive=" + r9.a());
        monitor-enter(this);
    L67:
        th = move-exception;
        throw th;
    L5:
        if (this.idleReleaseJob == r9) goto L10;
        AIKLog.INSTANCE.d(TAG, "[idleRelease] race detected: current idleReleaseJob=" + this.idleReleaseJob + " != expectedJob=" + r9 + ", skip unbind");     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L10:
        if (r9.a() == true) goto L14;
        AIKLog.INSTANCE.d(TAG, "[idleRelease] expectedJob is not active, skip unbind");     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L14:
        boolean r1 = true;
        if (isIdleReleaseActiveLocked() == true) goto L17;
    L30:
        boolean r10 = false;
    L31:
        if (r10 == true) goto L43;
        AIKLog r11 = AIKLog.INSTANCE;     // Catch: Throwable -> L67
        StringBuilder r3 = new StringBuilder().append("[idleRelease] shouldUnbind=false, state: idleEnabled=").append(this.mainServiceIdleReleaseEnabled).append(", suppressed=").append(this.idleReleaseSuppressedForCurrentBinding).append(", activeRequests=").append(this.activeRequestCount).append(", remoteAlive=");     // Catch: Throwable -> L67
        a r4 = this.remote;     // Catch: Throwable -> L67
        if (r4 == null) goto L39;
        IBinder r5 = r4.asBinder();     // Catch: Throwable -> L67
        if (r5 == null) goto L39;
        if (r5.isBinderAlive() != true) goto L39;
    L40:
        r11.d(TAG, r3.append(r1).append(", connectTask=").append(this.connectTask).toString());     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L39:
        r1 = false;
        goto L40
    L43:
        boolean r12 = this.mainServiceBound;     // Catch: Throwable -> L67
        boolean r2 = this.lifecycleServiceBound;     // Catch: Throwable -> L67
        AIKLog.INSTANCE.i(TAG, "[idleRelease] proceeding to unbind: mainBound=" + r12 + ", lifecycleBound=" + r2 + ", activeRequests=" + this.activeRequestCount);     // Catch: Throwable -> L67
        this.mainServiceBound = false;     // Catch: Throwable -> L67
        this.lifecycleServiceBound = false;     // Catch: Throwable -> L67
        this.remote = null;     // Catch: Throwable -> L67
        clearMainBindingStateLocked();     // Catch: Throwable -> L67
        Pair r13 = TuplesKt.to(Boolean.valueOf(r12), Boolean.valueOf(r2));     // Catch: Throwable -> L67
        monitor-exit(this);
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r13.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r14 = ((Boolean) ZeusTransformUtils.preCheckCast(r13.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        AIKLog.INSTANCE.i(TAG, "main service idle timeout, unbind " + this.connName + ", main=" + r6 + ", lifecycle=" + r14);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L51
        ServiceConnector r15 = (ServiceConnector) ZeusTransformUtils.preCheckCast(this, ServiceConnector.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r6 == false) goto L49;
        AIKLog.INSTANCE.d(TAG, "[idleRelease] unbinding main service connection...");     // Catch: Throwable -> L51
        ZeusTransformUtils.unbindService(r15.context, (ServiceConnection) ZeusTransformUtils.preCheckCast(r15.connection, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        AIKLog.INSTANCE.d(TAG, "[idleRelease] main service unbound successfully");     // Catch: Throwable -> L51
    L49:
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L53:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L73;
        AIKLog.INSTANCE.w(TAG, "[idleRelease] unbind main service failed: " + r17);
    L73:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L61
        ServiceConnector r19 = (ServiceConnector) ZeusTransformUtils.preCheckCast(this, ServiceConnector.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        if (r14 == false) goto L59;
        AIKLog.INSTANCE.d(TAG, "[idleRelease] unbinding lifecycle service connection...");     // Catch: Throwable -> L61
        ZeusTransformUtils.unbindService(r19.context, (ServiceConnection) ZeusTransformUtils.preCheckCast(r19.lifeCycleConnection, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        AIKLog.INSTANCE.d(TAG, "[idleRelease] lifecycle service unbound successfully");     // Catch: Throwable -> L61
    L59:
        Object r20 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        Throwable r21 = Result.m1424exceptionOrNullimpl(r20);
        if (r21 == null) goto L75;
        AIKLog.INSTANCE.w(TAG, "[idleRelease] unbind lifecycle service failed: " + r21);
        return;
    L75:
        return;
    L61:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L51:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L53
    L17:
        if (this.activeRequestCount != 0) goto L30;
        a r24 = this.remote;     // Catch: Throwable -> L67
        if (r24 == null) goto L25;
        IBinder r25 = r24.asBinder();     // Catch: Throwable -> L67
        if (r25 == null) goto L25;
        if (r25.isBinderAlive() != true) goto L25;
        boolean r26 = true;
    L26:
        if (r26 == false) goto L30;
        if (this.connectTask != null) goto L30;
        r10 = true;
    L25:
        r26 = false;
        goto L26
    }

    public final MainProcessIpcLease acquireMainProcessIpcLease$sdk_release() {
        monitor-enter(this);
        MainProcessIpcLease r0 = acquireMainProcessIpcLeaseLocked();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final BindingStateSnapshot bindingStateSnapshotForTest$sdk_release() {
        monitor-enter(this);
        boolean r1 = this.mainServiceIdleReleaseEnabled;     // Catch: Throwable -> L19
        boolean r2 = this.idleReleaseSuppressedForCurrentBinding;     // Catch: Throwable -> L19
        boolean r3 = this.mainServiceBound;     // Catch: Throwable -> L19
        boolean r4 = this.lifecycleServiceBound;     // Catch: Throwable -> L19
        int r5 = this.activeRequestCount;     // Catch: Throwable -> L19
        bx r0 = this.idleReleaseJob;     // Catch: Throwable -> L19
        boolean r7 = false;
        if (r0 != null) goto L6;
    L8:
        boolean r9 = false;
    L9:
        a r6 = this.remote;     // Catch: Throwable -> L19
        if (r6 == null) goto L16;
        IBinder r8 = r6.asBinder();     // Catch: Throwable -> L19
        if (r8 == null) goto L16;
        if (r8.isBinderAlive() != true) goto L16;
        r7 = true;
    L16:
        BindingStateSnapshot r10 = new BindingStateSnapshot(r1, r2, r3, r4, r5, r9, r7);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r10;
    L6:
        if (r0.a() != true) goto L8;
        r9 = true;
    L19:
        th = move-exception;
        throw th;
    }

    public final Object getService(long r5, Continuation<? super a> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        a r0 = this.remote;
        boolean r2 = true;
        if (r0 == null) goto L9;
        IBinder r1 = r0.asBinder();
        if (r1 == null) goto L9;
        if (r1.isBinderAlive() != true) goto L9;
    L10:
        if (r2 == false) goto L14;
        return this.remote;
    L14:
        return da.b(r5, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    L9:
        r2 = false;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0073 -> B:18:0x0076). Please report as a decompilation issue!!! */
    public final Object getServiceWithMainProcessIpcLease$sdk_release(long r11, Continuation<? super MainProcessIpcBinding> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ServiceConnector$getServiceWithMainProcessIpcLease$1.class) == false) goto L7;
        ServiceConnector$getServiceWithMainProcessIpcLease$1 r0 = (ServiceConnector$getServiceWithMainProcessIpcLease$1) ZeusTransformUtils.preCheckCast(r14, ServiceConnector$getServiceWithMainProcessIpcLease$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        long r10 = r0.J$0;
        ServiceConnector r12 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r0.L$0, ServiceConnector.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        long r6 = r10;
        ServiceConnector this = r12;
    L18:
        a r16 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L21;
        return null;
    L21:
        monitor-enter(this);
        a r17 = this.remote;     // Catch: Throwable -> L40
        boolean r3 = false;
        if (r17 == null) goto L29;
        IBinder r8 = r17.asBinder();     // Catch: Throwable -> L40
        if (r8 == null) goto L29;
        if (r8.isBinderAlive() != true) goto L29;
        r3 = true;
    L29:
        if (r3 == true) goto L31;
    L35:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(this);
        if (this.remainMs(r6) <= 0) goto L39;
    L15:
        long r19 = this.remainMs(r6);
        r0.L$0 = this;
        r0.J$0 = r6;
        r0.label = 1;
        r15 = this.getService(r19, r0);
        if (r15 != r1) goto L18;
        return r1;
    L39:
        return null;
    L31:
        if (Intrinsics.areEqual(r17.asBinder(), r16.asBinder()) == false) goto L35;
        MainProcessIpcBinding r110 = new MainProcessIpcBinding(r17, this.acquireMainProcessIpcLeaseLocked());     // Catch: Throwable -> L40
        monitor-exit(this);
        return r110;
    L40:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r6 = System.currentTimeMillis() + Math.max(r11, 0);
    L7:
        r0 = new ServiceConnector$getServiceWithMainProcessIpcLease$1(this, r14);
        goto L8
    }

    public final void setMainServiceIdleReleaseEnabled$sdk_release(boolean r3) {
        monitor-enter(this);
        this.mainServiceIdleReleaseEnabled = r3;     // Catch: Throwable -> L13
        if (r3 == false) goto L6;
        scheduleIdleReleaseLocked();     // Catch: Throwable -> L13
    L10:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        bx r5 = this.idleReleaseJob;     // Catch: Throwable -> L13
        if (r5 == null) goto L9;
        bx.a.a(r5, null, 1, null);     // Catch: Throwable -> L13
    L9:
        this.idleReleaseJob = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void suppressIdleReleaseForCurrentBinding$sdk_release() {
        monitor-enter(this);
        this.idleReleaseSuppressedForCurrentBinding = true;     // Catch: Throwable -> L10
        bx r1 = this.idleReleaseJob;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        bx.a.a(r1, null, 1, null);     // Catch: Throwable -> L10
    L7:
        this.idleReleaseJob = null;     // Catch: Throwable -> L10
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
