package com.obric.memorydata.sdk.screencapture;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/PendingOperation;", "", "screenEventReaction", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", LocationMonitorConst.TIMEOUT, "", "callback", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;JLcom/obric/memorydata/sdk/screencapture/EventReactionCallback;)V", "getScreenEventReaction", "()Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "getTimeout", "()J", "getCallback", "()Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScreenEventReaction f12853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12854b;
    private final b c;

    public f(ScreenEventReaction r3, long r4, b r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "screenEventReaction");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.f12853a = r3;
        this.f12854b = r4;
        this.c = r7;
    }

    public final ScreenEventReaction a() {
        return this.f12853a;
    }

    public final long b() {
        return this.f12854b;
    }

    public final b c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12853a, r10.f12853a) == true) goto L12;
        return false;
    L12:
        if (this.f12854b == r10.f12854b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f12853a.hashCode() * 31) + Long.hashCode(this.f12854b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PendingOperation(screenEventReaction=" + this.f12853a + ", timeout=" + this.f12854b + ", callback=" + this.c + ')';
    }
}
