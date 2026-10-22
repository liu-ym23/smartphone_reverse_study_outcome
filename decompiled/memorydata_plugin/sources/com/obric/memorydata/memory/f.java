package com.obric.memorydata.memory;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/InAppFavoriteEventDeduplicator;", "", "windowMs", "", "<init>", "(J)V", "previousEvents", "", "", "Lcom/obric/memorydata/memory/InAppFavoriteEventDeduplicator$Event;", "clear", "", "isDuplicate", "", "key", "favorite", OaidModel.KEY_TIME, "Event", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, a> f10119b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/InAppFavoriteEventDeduplicator$Event;", "", "favorite", "", OaidModel.KEY_TIME, "", "<init>", "(ZJ)V", "getFavorite", "()Z", "getTime", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f10120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10121b;

        public a(boolean r1, long r2) {
            this.f10120a = r1;
            this.f10121b = r2;
        }

        public final boolean a() {
            return this.f10120a;
        }

        public final long b() {
            return this.f10121b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (this.f10120a == r8.f10120a) goto L12;
            return false;
        L12:
            if (this.f10121b == r8.f10121b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f10120a) * 31) + Long.hashCode(this.f10121b);
        }

        public String toString() {
            return "Event(favorite=" + this.f10120a + ", time=" + this.f10121b + ')';
        }
    }

    public f(long r2) {
        this.f10118a = r2;
        this.f10119b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.f10119b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(String r6, boolean r7, long r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "key");     // Catch: Throwable -> L21
        a r9 = (a) ZeusTransformUtils.preCheckCast(this.f10119b.put(r6, new a(r7, r8)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        boolean r0 = false;
        if (r9 != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (r9.a() != r7) goto L19;
        long r3 = this.f10118a;     // Catch: Throwable -> L21
        long r10 = r8 - r9.b();
        if (0 <= r10) goto L14;
    L16:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L19;
        r0 = true;
        goto L19
    L14:
        if (r10 > r3) goto L16;
        r11 = true;
    L19:
        monitor-exit(this);
        return r0;
    L21:
        th = move-exception;
        throw th;
    }
}
