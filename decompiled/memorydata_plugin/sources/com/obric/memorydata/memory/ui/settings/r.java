package com.obric.memorydata.memory.ui.settings;

import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptInRequests;", "", "maxRememberedGenerations", "", "<init>", "(I)V", "generations", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "record", "", PendingPersonalInfoNotificationTask.KEY_GENERATION, "abandon", "abandonAll", "supersededGenerations", "", "consume", "", "clear", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<Long> f11504b;

    public r() {
        this(0, 1, null);
    }

    public r(int r1) {
        this.f11503a = r1;
        this.f11504b = new LinkedHashSet();
    }

    public /* synthetic */ r(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 32;
    L5:
        this(r1);
    }

    public final void a(long r3) {
        LinkedHashSet<Long> r0 = this.f11504b;
        monitor-enter(r0);
        this.f11504b.add(Long.valueOf(r3));     // Catch: Throwable -> L11
    L6:
        if (this.f11504b.size() <= this.f11503a) goto L8;
        LinkedHashSet<Long> r4 = this.f11504b;     // Catch: Throwable -> L11
        r4.remove(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a(Set<Long> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "supersededGenerations");
        LinkedHashSet<Long> r0 = this.f11504b;
        monitor-enter(r0);
        this.f11504b.removeAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(long r2) {
        LinkedHashSet<Long> r0 = this.f11504b;
        monitor-enter(r0);
        this.f11504b.remove(Long.valueOf(r2));     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean c(long r2) {
        LinkedHashSet<Long> r0 = this.f11504b;
        monitor-enter(r0);
        boolean r1 = this.f11504b.remove(Long.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
