package com.obric.memorydata.awareness.cae;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0005*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/cae/PoiEventDeduplicator;", "", "<init>", "()V", "lastEventIdentity", "", "latestSourceTimestampMs", "", "Ljava/lang/Long;", "syncBaseline", "", "observation", "Lcom/obric/memorydata/awareness/cae/PoiObservation;", "eventType", "Lcom/obric/memorydata/awareness/cae/PoiEventType;", "shouldDispatch", "", "eventIdentity", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f8598b;

    public g() {
    }

    private final String c(i r1, PoiEventType r2) {
        String r0 = r1.e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r2.getEventName() + ':' + r0;
    }

    public final void a(i r6, PoiEventType r7) {
        Intrinsics.checkNotNullParameter(r7, "eventType");
        Long r0 = null;
        if (r6 == null) goto L5;
        String r8 = c(r6, r7);
    L6:
        this.f8597a = r8;
        if (r6 == null) goto L16;
        Long r9 = r6.c();
        if (r9 == null) goto L16;
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        r0 = r9;
        goto L16
    L13:
        r10 = false;
    L16:
        this.f8598b = r0;
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final boolean b(i r10, PoiEventType r11) {
        Intrinsics.checkNotNullParameter(r11, "eventType");
        if (r10 == null) goto L12;
        Long r3 = r10.c();
        if (r3 == null) goto L12;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L13:
        Long r5 = this.f8598b;
        if (r3 == null) goto L19;
        if (r5 == null) goto L19;
        if (r3.longValue() >= r5.longValue()) goto L19;
        return false;
    L19:
        if (r3 == null) goto L21;
        this.f8598b = r3;
    L21:
        if (r10 == null) goto L23;
        String r12 = c(r10, r11);
    L24:
        if (r12 != null) goto L28;
        this.f8597a = null;
        return false;
    L28:
        if (Intrinsics.areEqual(r12, this.f8597a) == false) goto L30;
        return false;
    L30:
        this.f8597a = r12;
        return true;
    L23:
        r12 = null;
        goto L24
    L9:
        r4 = false;
    L12:
        r3 = null;
        goto L13
    }
}
