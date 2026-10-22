package com.obric.memorydata.awareness.persistent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/AwarenessEventDeduplicator;", "", "<init>", "()V", "lock", "latestEventByKey", "", "", "Lcom/obric/memorydata/awareness/persistent/AwarenessEventDeduplicator$EventState;", "dispatchIfNeeded", "", "key", "eventName", "timestamp", "", "dispatch", "Lkotlin/Function0;", "", "EventState", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, a> f8763b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/AwarenessEventDeduplicator$EventState;", "", "eventName", "", "timestamp", "", "<init>", "(Ljava/lang/String;J)V", "getEventName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8765b;

        public a(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            this.f8764a = r2;
            this.f8765b = r3;
        }

        public final String a() {
            return this.f8764a;
        }

        public final long b() {
            return this.f8765b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8764a, r8.f8764a) == true) goto L12;
            return false;
        L12:
            if (this.f8765b == r8.f8765b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8764a.hashCode() * 31) + Long.hashCode(this.f8765b);
        }

        public String toString() {
            return "EventState(eventName=" + this.f8764a + ", timestamp=" + this.f8765b + ')';
        }
    }

    public b() {
        this.f8762a = new Object();
        this.f8763b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(String r10, String r11, long r12, Function0<Unit> r14) {
        Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r15, "dispatch");
        a r0 = new a(r11, r12);
        Object r1 = this.f8762a;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f8763b.get(r10), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        String r5 = null;
        switch(r10.hashCode()) {
            case 666122425: goto L24;
            case 1328800982: goto L14;
            case 1925907146: goto L11;
            case 2125585246: goto L8;
            default: goto L30;
        };     // Catch: Throwable -> L52
    L30:
        boolean r13 = false;
    L31:
        if (r13 == false) goto L34;
        monitor-exit(r1);
        return false;
    L34:
        this.f8763b.put(r10, r0);     // Catch: Throwable -> L52
        monitor-exit(r1);
        r15.invoke();     // Catch: Throwable -> L38
        return true;
    L38:
        th = move-exception;
        monitor-enter(this.f8762a);
    L49:
        th = move-exception;
        throw th;
    L42:
        if (this.f8763b.get(r10) != r0) goto L46;
        if (r2 != null) goto L45;
        this.f8763b.remove(r10);     // Catch: Throwable -> L49
        goto L46
    L45:
        this.f8763b.put(r10, r2);     // Catch: Throwable -> L49
    L46:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L49
        throw th;
    L8:
        if (r10.equals("wearing_event") == false) goto L30;
    L26:
        if (r2 == null) goto L28;
        r5 = r2.a();     // Catch: Throwable -> L52
    L28:
        r13 = Intrinsics.areEqual(r5, r11);     // Catch: Throwable -> L52
        goto L31
    L11:
        if (r10.equals("sedentary_event") == true) goto L26;
    L14:
        if (r10.equals("fall_event") == false) goto L30;
        if (r2 == null) goto L19;
        r5 = r2.a();     // Catch: Throwable -> L52
    L19:
        if (Intrinsics.areEqual(r5, r11) == false) goto L30;
        if (r2.b() != r12) goto L30;
        r13 = true;
        goto L31
    L24:
        if (r10.equals("long_head_down_event") == true) goto L26;
    L52:
        th = move-exception;
        throw th;
    }
}
