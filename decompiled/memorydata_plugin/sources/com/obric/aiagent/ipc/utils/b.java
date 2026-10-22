package com.obric.aiagent.ipc.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002\"#B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010!\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\r\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyDetector;", "", "windowDurationMs", "", "slowCallThresholdUs", "frequentCallThreshold", "", "globalReportLimit", "globalReportWindowMs", "<init>", "(JJIIJ)V", "statesByDirection", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyDetector$MethodState;", "globalWindowLock", "globalWindowIndex", "globalReportCount", "saturatedGlobalWindow", "record", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyDecision;", "direction", LocationMonitorConst.TAG, "method", "durationUs", "failed", "", "nowMs", "stateFor", "takeWithinGlobalLimit", "", "Lcom/obric/aiagent/ipc/utils/IPCAnomalyType;", "candidates", "currentWindow", "MethodState", "Companion", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5944b;
    private final long c;
    private final int d;
    private final int e;
    private final long f;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>> g;
    private final Object h;
    private long i;
    private volatile long j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyDetector$Companion;", "", "<init>", "()V", "EMPTY_WINDOW", "", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5943a = new a(null);
    }

    public b(long r4, long r6, int r8, int r9, long r10) {
        this.f5944b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = new ConcurrentHashMap();
        this.h = new Object();
        this.i = Long.MIN_VALUE;
        this.j = Long.MIN_VALUE;
        boolean r5 = true;
        if (r4 <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L36;
        if (r6 < 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L34;
        if (r8 <= 0) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == false) goto L32;
        if (r9 <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L30;
        if (r10 > 0) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L28;
        return;
    L28:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L19:
        r12 = false;
        goto L20
    L32:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L15:
        r11 = false;
        goto L16
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L11:
        r7 = false;
        goto L12
    L36:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L7
    }

    public /* synthetic */ b(long r13, long r15, int r17, int r18, long r19, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        long r4 = 60000;
    L7:
        if ((r21 & 16) == 0) goto L9;
        long r10 = 60000;
    L10:
        this(r4, r15, r17, r18, r10);
        return;
    L9:
        r10 = r19;
        goto L10
    L5:
        r4 = r13;
        goto L7
    }
}
