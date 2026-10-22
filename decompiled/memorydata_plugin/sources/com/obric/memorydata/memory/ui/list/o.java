package com.obric.memorydata.memory.ui.list;

import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarDefaultDatePolicy;", "", "<init>", "()V", "resolveInitialDate", "Ljava/time/LocalDate;", "currentSelectedDate", "today", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f11323a = null;

    static {
        f11323a = new o();
    }

    private o() {
    }

    public static /* synthetic */ LocalDate a(o r0, LocalDate r1, LocalDate r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = LocalDate.now();
    L6:
        return r0.a(r1, r2);
    }

    public final LocalDate a(LocalDate r1, LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "today");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return r2;
    }
}
