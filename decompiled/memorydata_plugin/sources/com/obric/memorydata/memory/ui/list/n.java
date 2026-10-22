package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarDay;", "", "date", "Ljava/time/LocalDate;", "isEmpty", "", "<init>", "(Ljava/time/LocalDate;Z)V", "getDate", "()Ljava/time/LocalDate;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDate f11321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11322b;

    public n(LocalDate r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "date");
        this.f11321a = r2;
        this.f11322b = r3;
    }

    public static /* synthetic */ n a(n r0, LocalDate r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f11321a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.f11322b;
    L9:
        return r0.a(r1, r2);
    }

    public final n a(LocalDate r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "date");
        return new n(r1, r2);
    }

    public final LocalDate a() {
        return this.f11321a;
    }

    public final boolean b() {
        return this.f11322b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11321a, r6.f11321a) == true) goto L12;
        return false;
    L12:
        if (this.f11322b == r6.f11322b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11321a.hashCode() * 31) + Boolean.hashCode(this.f11322b);
    }

    public String toString() {
        return "MemoryCalendarDay(date=" + this.f11321a + ", isEmpty=" + this.f11322b + ')';
    }
}
