package com.ss.android.lark.optrace.core;

import android.os.SystemClock;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.api.ITracing;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.api.TracingSpanData;
import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtension;
import com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtensionImpl;
import com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension;
import com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtensionImpl;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class TracingCoreTarget implements TracingCoreSpan {
    private static final long serialVersionUID = 446009563012766987L;

    @SerializedName("traceId")
    @Expose
    protected String cacheTracingId;

    @SerializedName("createTime")
    @Expose
    private long createTime;
    protected Map<TracingExtensionEnum, TracingExtension> extensions;
    private TracingCoreSpan parent;
    protected TracingSpanData spanData;

    public abstract void generateSpanData();

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationEndAll() {
        Iterator<TracingExtensionEnum> r0 = this.extensions.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        TracingExtensionEnum r1 = r0.next();
        TracingExtension r2 = this.extensions.get(r1);
        if (r2 == null) goto L4;
        if ((r2 instanceof TracingClientDurationExtension) == false) goto L4;
        ((TracingClientDurationExtension) r2).endAll();
        goto L4
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getRequestId() {
        TracingExtension r0 = this.extensions.get(TracingExtensionEnum.CLIENT_REQUEST);
        if ((r0 instanceof TrancingClientRequestExtension) == true) goto L5;
        return null;
    L5:
        return ((TrancingClientRequestExtension) r0).getRequestId();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("TracingCoreTarget{parent=");
        TracingCoreSpan r1 = this.parent;
        String r2 = "";
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        r0.append(r3);
        r0.append(", spanData=");
        TracingSpanData r4 = this.spanData;
        if (r4 == null) goto L9;
        String r5 = r4.toString();
    L10:
        r0.append(r5);
        r0.append(", cacheTracingId='");
        String r6 = this.cacheTracingId;
        if (r6 == null) goto L13;
        r2 = r6;
    L13:
        r0.append(r2);
        r0.append("', createTime=");
        r0.append(this.createTime);
        r0.append(", extensions=");
        r0.append(this.extensions.toString());
        r0.append('}');
        return r0.toString();
    L9:
        r5 = "";
        goto L10
    L5:
        r3 = "";
        goto L6
    }

    public TracingCoreTarget() {
        this.parent = null;
        this.createTime = SystemClock.elapsedRealtime();
        this.extensions = new ConcurrentHashMap();
        addExtension(TracingExtensionEnum.CLIENT_DURATION, new TracingClientDurationExtensionImpl());
        addExtension(TracingExtensionEnum.CLIENT_REQUEST, new TrancingClientRequestExtensionImpl());
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long createTime() {
        return this.createTime;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getTracingID() {
        return this.cacheTracingId;
    }

    public TracingCoreTarget(TracingCoreSpan r3) {
        this.parent = r3;
        this.createTime = SystemClock.elapsedRealtime();
        this.extensions = new ConcurrentHashMap();
        addExtension(TracingExtensionEnum.CLIENT_DURATION, new TracingClientDurationExtensionImpl());
        addExtension(TracingExtensionEnum.CLIENT_REQUEST, new TrancingClientRequestExtensionImpl());
        generateSpanData();
        TracingCoreSpan r4 = this.parent;
        if (r4 != null) goto L5;
        String r5 = "1";
    L6:
        this.cacheTracingId = r5 + "-" + this.spanData.getSpan();
        return;
    L5:
        r5 = r4.getTracingID();
        goto L6
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDuration(String r3) {
        TracingExtension r0 = this.extensions.get(TracingExtensionEnum.CLIENT_DURATION);
        if ((r0 instanceof TracingClientDurationExtension) == true) goto L5;
        Log.e("TracingCoreTarget", "Not implement Client Duration extension");
        return -1;
    L5:
        return ((TracingClientDurationExtension) r0).duration(r3);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDurationTagEnd(String r3) {
        TracingExtension r0 = this.extensions.get(TracingExtensionEnum.CLIENT_DURATION);
        if ((r0 instanceof TracingClientDurationExtension) == true) goto L5;
        Log.e("TracingCoreTarget", "Not implement Client Duration extension");
        return -1;
    L5:
        return ((TracingClientDurationExtension) r0).end(r3);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationTagStart(String r3) {
        TracingExtension r0 = this.extensions.get(TracingExtensionEnum.CLIENT_DURATION);
        if ((r0 instanceof TracingClientDurationExtension) == false) goto L5;
        ((TracingClientDurationExtension) r0).start(r3);
        return;
    L5:
        Log.e("TracingCoreTarget", "Not implement Client Duration extension");
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void setRequestId(String r3) {
        TracingExtension r0 = this.extensions.get(TracingExtensionEnum.CLIENT_REQUEST);
        if ((r0 instanceof TrancingClientRequestExtension) == false) goto L6;
        ((TrancingClientRequestExtension) r0).setRequestId(r3);
        return;
    }

    public TracingCoreTarget(String r1) {
        this();
        this.cacheTracingId = r1;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void addExtension(TracingExtensionEnum r2, TracingExtension r3) {
        this.extensions.put(r2, r3);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void d(String r4, Object... r5) {
        String r0 = getTracingID();
        int r1 = kyb.a.a;
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.d(r4, "[" + r0 + "] " + kyb.a.a(Arrays.copyOf(r5, r5.length)));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void e(String r7, Object... r8) {
        String r0 = getTracingID();
        int r1 = kyb.a.a;
        Intrinsics.checkNotNullParameter(r7, "tag");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r8, "msg");
        boolean r2 = false;
        if (r8.length != 0) goto L5;
        boolean r3 = true;
    L7:
        if ((!r3) == true) goto L9;
    L11:
        String r4 = kyb.a.a(Arrays.copyOf(r8, r8.length));
        if (r2 == false) goto L14;
        Object r9 = r8[r8.length - 1];
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Throwable");
        Log.e(r7, "[" + r0 + "] " + r4, (Throwable) r9);
        return;
    L14:
        Log.e(r7, "[" + r0 + "] " + r4);
        return;
    L9:
        if ((r8[r8.length - 1] instanceof Throwable) == false) goto L11;
        r2 = true;
        goto L11
    L5:
        r3 = false;
        goto L7
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void i(String r4, Object... r5) {
        String r0 = getTracingID();
        int r1 = kyb.a.a;
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.i(r4, "[" + r0 + "] " + kyb.a.a(Arrays.copyOf(r5, r5.length)));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void w(String r4, Object... r5) {
        String r0 = getTracingID();
        int r1 = kyb.a.a;
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.w(r4, "[" + r0 + "] " + kyb.a.a(Arrays.copyOf(r5, r5.length)));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public <T> void linkTracing(ITracing r4, T r5, hyb.b<T> r6) {
        if (r4 != null) goto L6;
        Log.e("TracingCoreTarget", "linkedTracing == null");
        return;
    L6:
        r4.getTracingID();
        r6.a();
        TracingCoreTarget r7 = (TracingCoreTarget) r4;
        Iterator<TracingExtensionEnum> r8 = r7.extensions.keySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L16;
        TracingExtensionEnum r0 = r8.next();
        TracingExtension r1 = r7.extensions.get(r0);
        if (r1 == null) goto L11;
        TracingExtension r2 = this.extensions.get(r0);
        if (r2 != null) goto L14;
        this.extensions.put(r0, r1);
        goto L8
    L14:
        r2.mergeExtension(r1);
        goto L8
    L11:
        Log.e("TracingCoreTarget", "linkExtension == null, enum = " + r0.name());
        goto L8
    }
}
