package com.obric.memorydata.task;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.platform.godzilla.anr.monitor.idletask.ArrayListWrapper;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\bJ \u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0007J\b\u0010\u001c\u001a\u00020\u000bH\u0007J\u001a\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u001aJ!\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u000bH\u0002R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/task/PriorityArrayDeque;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "deque", "Lkotlin/collections/ArrayDeque;", "Lkotlin/Pair;", "", "lock", "add", "", "element", "(Ljava/lang/Object;)V", "priority", "(ILjava/lang/Object;)V", "addHead", "poll", "()Ljava/lang/Object;", "get", "isEmpty", "", "size", "removeIfMatch", "", "predicate", "Lkotlin/Function1;", "removeAll", "printAll", "hasElement", "firstElementOrNull", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "printForDebug", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque<Pair<Integer, T>> f12871b;
    private final Object c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/PriorityArrayDeque$Companion;", "", "<init>", "()V", "TAG", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12870a = new a(null);
    }

    public c() {
        this.f12871b = new ArrayDeque();
        this.c = new Object();
    }

    public final T a() {
        Object r0 = this.c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (b() == true) goto L7;
        T r3 = (T) ((Pair) ZeusTransformUtils.preCheckCast(this.f12871b.removeFirst(), Pair.class, "com.obric.memorydata.plugin")).getSecond();
        monitor-exit(r0);
        return r3;
    L7:
        monitor-exit(r0);
        return null;
    }

    public final List<T> a(Function1<? super T, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        ArrayListWrapper r0 = (List<T>) ((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Object r1 = this.c;
        monitor-enter(r1);
        Iterator r6 = this.f12871b.iterator();     // Catch: Throwable -> L13
    L6:
        if (r6.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r2.getSecond()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        r6.remove();     // Catch: Throwable -> L13
        r0.add(r2.getSecond());     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        return r0;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(int r8, T r9) {
        Object r0 = this.c;
        monitor-enter(r0);
        Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(this.f12871b, List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L21
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        if (((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() >= r8) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L15;
        r3 = r3 + 1;     // Catch: Throwable -> L21
    L15:
        if (r3 < 0) goto L17;
        RunLog.INSTANCE.debug("PriorityArrayDeque", "add " + r9 + " at index: " + r3 + ", total: " + this.f12871b.size());     // Catch: Throwable -> L21
        this.f12871b.add(r3, new Pair(Integer.valueOf(r8), r9));     // Catch: Throwable -> L21
    L18:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        return;
    L17:
        RunLog.INSTANCE.debug("PriorityArrayDeque", "add " + r9 + " at last, total: " + this.f12871b.size());     // Catch: Throwable -> L21
        this.f12871b.addLast(new Pair(Integer.valueOf(r8), r9));     // Catch: Throwable -> L21
        goto L18
    L10:
        r4 = false;
        goto L11
    L14:
        r3 = -1;
    L21:
        th = move-exception;
        throw th;
    }

    public final void a(T r2) {
        a(5, r2);
    }

    public final void b(T r5) {
        Object r0 = this.c;
        monitor-enter(r0);
        this.f12871b.add(0, new Pair(10, r5));     // Catch: Throwable -> L7
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r1 = this.f12871b.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean b(Function1<? super T, Boolean> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Object r0 = this.c;
        monitor-enter(r0);
        Iterator r4 = this.f12871b.iterator();     // Catch: Throwable -> L13
    L6:
        if (r4.hasNext() == false) goto L12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(((Pair) ZeusTransformUtils.preCheckCast(r4.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        boolean r7 = true;
    L10:
        monitor-exit(r0);
        return r7;
    L12:
        r7 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final int c() {
        Object r0 = this.c;
        monitor-enter(r0);
        int r1 = this.f12871b.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final T c(Function1<? super T, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        Object r0 = this.c;
        monitor-enter(r0);
        Iterator r5 = this.f12871b.iterator();     // Catch: Throwable -> L15
    L6:
        if (r5.hasNext() == false) goto L13;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r5.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r1.getSecond()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        T r8 = (T) r1.getSecond();
        monitor-exit(r0);
        return r8;
    L13:
        monitor-exit(r0);
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
