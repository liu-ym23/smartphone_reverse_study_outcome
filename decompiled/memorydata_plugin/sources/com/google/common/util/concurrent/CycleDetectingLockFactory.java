package com.google.common.util.concurrent;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class CycleDetectingLockFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, b>> f4810b = null;
    private static final Logger c = null;
    private static final ThreadLocal<ArrayList<b>> d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c f4811a;

    final class CycleDetectingReentrantLock extends ReentrantLock implements a {
        private final b lockGraphNode;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        private CycleDetectingReentrantLock(CycleDetectingLockFactory r1, b r2, boolean r3) {
            this.this$0 = r1;
            super(r3);
            this.lockGraphNode = (b) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r2), b.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory r1, b r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.a
        public b getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.a
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.a(this.this$0, this);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            CycleDetectingLockFactory.a(this.this$0, this);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.a(this.this$0, this);
            boolean r0 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this);
            return r0;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r2, TimeUnit r4) {
            CycleDetectingLockFactory.a(this.this$0, this);
            boolean r3 = super.tryLock(r2, r4);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this);
            return r3;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.a(this);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.a(this);
            throw th;
        }
    }

    private class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        CycleDetectingReentrantReadLock(CycleDetectingLockFactory r1, CycleDetectingReentrantReadWriteLock r2) {
            this.this$0 = r1;
            super(r2);
            this.readWriteLock = r2;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            boolean r0 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return r0;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r3, TimeUnit r5) {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            boolean r4 = super.tryLock(r3, r5);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return r4;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.a(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }
    }

    final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements a {
        private final b lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r1, b r2, boolean r3) {
            super(r3);
            this.readLock = new CycleDetectingReentrantReadLock(r1, this);
            this.writeLock = new CycleDetectingReentrantWriteLock(r1, this);
            this.lockGraphNode = (b) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r2), b.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r1, b r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.a
        public b getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.a
        public boolean isAcquiredByCurrentThread() {
            if (isWriteLockedByCurrentThread() == false) goto L5;
        L8:
            return true;
        L5:
            if (getReadHoldCount() > 0) goto L8;
            return false;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock readLock() {
            return readLock();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock writeLock() {
            return writeLock();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    private class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        CycleDetectingReentrantWriteLock(CycleDetectingLockFactory r1, CycleDetectingReentrantReadWriteLock r2) {
            this.this$0 = r1;
            super(r2);
            this.readWriteLock = r2;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            boolean r0 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return r0;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r3, TimeUnit r5) {
            CycleDetectingLockFactory.a(this.this$0, this.readWriteLock);
            boolean r4 = super.tryLock(r3, r5);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.a(this.readWriteLock);
            return r4;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.a(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.a(this.readWriteLock);
            throw th;
        }
    }

    private static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = null;
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = null;

        static {
            EMPTY_STACK_TRACE = new StackTraceElement[0];
            EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), b.class.getName());
        }

        ExampleStackTrace(b r4, b r5) {
            super(r4.a() + " -> " + r5.a());
            StackTraceElement[] r6 = getStackTrace();
            int r7 = r6.length;
            int r0 = 0;
        L3:
            if (r0 >= r7) goto L16;
            if (d.class.getName().equals(r6[r0].getClassName()) == true) goto L6;
            if (EXCLUDED_CLASS_NAMES.contains(r6[r0].getClassName()) == false) goto L9;
            r0 = r0 + 1;
            goto L3
        L9:
            setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r6, r0, r7), StackTraceElement[].class, "com.obric.memorydata.plugin"));
            return;
        L6:
            setStackTrace(EMPTY_STACK_TRACE);
            return;
        }
    }

    public static abstract enum Policies extends Enum<Policies> implements c {
        private static final /* synthetic */ Policies[] $VALUES = null;
        public static final Policies DISABLED = null;
        public static final Policies THROW = null;
        public static final Policies WARN = null;

        private static /* synthetic */ Policies[] $values() {
            return new Policies[]{THROW, WARN, DISABLED};
        }

        static {
            final String r1 = "THROW";
            final int r2 = 0;
            THROW = new AnonymousClass1(r1, r2);
            final String r3 = CipherConst.LEVEL_WARN;
            final int r4 = 1;
            WARN = new AnonymousClass2(r3, r4);
            final String r5 = "DISABLED";
            final int r6 = 2;
            DISABLED = new AnonymousClass3(r5, r6);
            $VALUES = $values();
        }

        private Policies(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Policies(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Policies valueOf(String r2) {
            return (Policies) ZeusTransformUtils.preCheckCast(Enum.valueOf(Policies.class, r2), Policies.class, "com.obric.memorydata.plugin");
        }

        public static Policies[] values() {
            return (Policies[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Policies[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        private PotentialDeadlockException(b r1, b r2, ExampleStackTrace r3) {
            super(r1, r2);
            this.conflictingStackTrace = r3;
            initCause(r3);
        }

        /* synthetic */ PotentialDeadlockException(b r1, b r2, ExampleStackTrace r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder r0 = new StringBuilder((String) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(super.getMessage()), String.class, "com.obric.memorydata.plugin"));
            Throwable r4 = this.conflictingStackTrace;
        L3:
            if (r4 == null) goto L6;
            r0.append(", ").append(r4.getMessage());
            r4 = r4.getCause();
            goto L3
        L6:
            return r0.toString();
        }
    }

    private interface a {
        b getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<b, ExampleStackTrace> f4812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<b, PotentialDeadlockException> f4813b;
        final String c;

        private ExampleStackTrace a(b r7, Set<b> r8) {
            Set<b> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
            if (r9.add(this) == true) goto L5;
            return null;
        L5:
            ExampleStackTrace r0 = (ExampleStackTrace) ZeusTransformUtils.preCheckCast(this.f4812a.get(r7), ExampleStackTrace.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L8;
            return r0;
        L8:
            Iterator<Map.Entry<b, ExampleStackTrace>> r1 = this.f4812a.entrySet().iterator();
        L10:
            if (r1.hasNext() == false) goto L15;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3.getKey(), b.class, "com.obric.memorydata.plugin");
            ExampleStackTrace r5 = r4.a(r7, r9);
            if (r5 == null) goto L10;
            ExampleStackTrace r10 = new ExampleStackTrace(r4, this);
            r10.setStackTrace(((ExampleStackTrace) ZeusTransformUtils.preCheckCast(r3.getValue(), ExampleStackTrace.class, "com.obric.memorydata.plugin")).getStackTrace());
            r10.initCause(r5);
            return r10;
        L15:
            return null;
        }

        String a() {
            return this.c;
        }

        void a(c r5, b r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
            if (this == r6) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0, "Attempted to acquire multiple locks with the same rank %s", r6.a());
            if (this.f4812a.containsKey(r6) == false) goto L9;
            return;
        L9:
            PotentialDeadlockException r1 = (PotentialDeadlockException) ZeusTransformUtils.preCheckCast(this.f4813b.get(r6), PotentialDeadlockException.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r2 = null;
            if (r1 == null) goto L13;
            r7.handlePotentialDeadlock(new PotentialDeadlockException(r6, this, r1.getConflictingStackTrace(), r2));
            return;
        L13:
            ExampleStackTrace r3 = r6.a(this, Sets.c());
            if (r3 != null) goto L16;
            this.f4812a.put(r6, new ExampleStackTrace(r6, this));
            return;
        L16:
            PotentialDeadlockException r4 = new PotentialDeadlockException(r6, this, r3, r2);
            this.f4813b.put(r6, r4);
            r7.handlePotentialDeadlock(r4);
            return;
        L5:
            r0 = false;
            goto L6
        }

        void a(c r4, List<b> r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            a(r6, (b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.memorydata.plugin"));
            goto L4
        }
    }

    public interface c {
        void handlePotentialDeadlock(PotentialDeadlockException r1);
    }

    public static final class d<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    static {
        f4810b = new MapMaker().d().g();
        c = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        d = new AnonymousClass1();
    }

    static /* synthetic */ Logger a() {
        return c;
    }

    static /* synthetic */ void a(a r2) {
        c((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(CycleDetectingLockFactory r2, a r3) {
        r2.b((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"));
    }

    private void b(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r5.isAcquiredByCurrentThread() == true) goto L6;
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(d.get(), ArrayList.class, "com.obric.memorydata.plugin");
        b r6 = r5.getLockGraphNode();
        r6.a(this.f4811a, r0);
        r0.add(r6);
        return;
    }

    private static void c(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (r4.isAcquiredByCurrentThread() == true) goto L10;
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(d.get(), ArrayList.class, "com.obric.memorydata.plugin");
        b r5 = r4.getLockGraphNode();
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L14;
        if (r0.get(r1) == r5) goto L8;
        r1 = r1 - 1;
        goto L5
    L8:
        r0.remove(r1);
        return;
    L14:
        return;
    }
}
