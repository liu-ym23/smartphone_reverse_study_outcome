package com.obric.memorydata.realtimecontext.tracker;

import android.content.ComponentName;
import com.obric.memorydata.realtimecontext.session.RealTimeContextLink;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0013\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u00104\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u0005R\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00069"}, d2 = {"Lcom/obric/memorydata/realtimecontext/tracker/OnScreenTrackerData;", "", "captureId", "", "<init>", "(I)V", "getCaptureId", "()I", "captureStartTime", "", "getCaptureStartTime", "()J", "setCaptureStartTime", "(J)V", "captureEndTime", "getCaptureEndTime", "setCaptureEndTime", "captureType", "Lcom/obric/memorydata/realtimecontext/tracker/ScreenMsgCaptureType;", "getCaptureType", "()Lcom/obric/memorydata/realtimecontext/tracker/ScreenMsgCaptureType;", "setCaptureType", "(Lcom/obric/memorydata/realtimecontext/tracker/ScreenMsgCaptureType;)V", "queryTime", "getQueryTime", "setQueryTime", "queryType", "getQueryType", "setQueryType", "assistStartTime", "getAssistStartTime", "setAssistStartTime", "fromCache", "", "getFromCache", "()Z", "setFromCache", "(Z)V", "componentName", "Landroid/content/ComponentName;", "getComponentName", "()Landroid/content/ComponentName;", "setComponentName", "(Landroid/content/ComponentName;)V", "linkType", "Lcom/obric/memorydata/realtimecontext/session/RealTimeContextLink;", "getLinkType", "()Lcom/obric/memorydata/realtimecontext/session/RealTimeContextLink;", "setLinkType", "(Lcom/obric/memorydata/realtimecontext/session/RealTimeContextLink;)V", "component1", "copy", "equals", "other", "hashCode", "toString", "", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12490b;
    private long c;
    private ScreenMsgCaptureType d;
    private long e;
    private int f;
    private long g;
    private boolean h;
    private ComponentName i;
    private RealTimeContextLink j;

    public final long a() {
        return this.f12490b;
    }

    public final void a(int r1) {
        this.f = r1;
    }

    public final void a(long r1) {
        this.e = r1;
    }

    public final long b() {
        return this.c;
    }

    public final ScreenMsgCaptureType c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f12489a == r6.f12489a) goto L11;
        return false;
    L11:
        return true;
    }

    public final long f() {
        return this.g;
    }

    public final boolean g() {
        return this.h;
    }

    public final ComponentName h() {
        return this.i;
    }

    public int hashCode() {
        return Integer.hashCode(this.f12489a);
    }

    public final RealTimeContextLink i() {
        return this.j;
    }

    public String toString() {
        return "OnScreenTrackerData(captureId=" + this.f12489a + ')';
    }
}
