package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class LifetimeAssert {
    static TestHook sTestHook;
    private final Object mTarget;
    final WrappedReference mWrapper;

    private static class CreationException extends RuntimeException {
        CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    static class LifetimeAssertException extends RuntimeException {
        LifetimeAssertException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    interface TestHook {
        void onCleaned(WrappedReference r1, String r2);
    }

    static class WrappedReference extends PhantomReference<Object> {
        private static Set<WrappedReference> sActiveWrappers;
        private static ReferenceQueue<Object> sReferenceQueue;
        final CreationException mCreationException;
        boolean mSafeToGc;
        final Class<?> mTargetClass;

        static {
            sReferenceQueue = new ReferenceQueue();
            sActiveWrappers = Collections.synchronizedSet(new HashSet());
            final String r1 = "GcStateAssertQueue";
            new AnonymousClass1(r1);
        }

        public WrappedReference(Object r2, CreationException r3, boolean r4) {
            super(r2, sReferenceQueue);
            this.mCreationException = r3;
            this.mSafeToGc = r4;
            this.mTargetClass = r2.getClass();
            sActiveWrappers.add(this);
        }

        static /* synthetic */ ReferenceQueue access$000() {
            return sReferenceQueue;
        }

        static /* synthetic */ Set access$100() {
            return sActiveWrappers;
        }
    }

    private LifetimeAssert(WrappedReference r1, Object r2) {
        this.mWrapper = r1;
        this.mTarget = r2;
    }

    public static void assertAllInstancesDestroyedForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        Set r0 = WrappedReference.access$100();
        monitor-enter(r0);
        Iterator r1 = WrappedReference.access$100().iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L15;
        WrappedReference r2 = (WrappedReference) ZeusTransformUtils.preCheckCast(r1.next(), WrappedReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r2.mSafeToGc == true) goto L9;
        throw new LifetimeAssertException(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", new Object[]{r2.mTargetClass.getName()}), r2.mCreationException);     // Catch: Throwable -> L18
    L15:
        WrappedReference.access$100().clear();     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        WrappedReference.access$100().clear();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    }

    public static LifetimeAssert create(Object r4) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r4, new CreationException(), false), r4);
    }

    public static LifetimeAssert create(Object r3, boolean r4) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r3, new CreationException(), r4), r3);
    }

    public static void resetForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        WrappedReference.access$100().clear();
    }

    public static void setSafeToGc(LifetimeAssert r1, boolean r2) {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L12;
        Object r0 = r1.mTarget;
        monitor-enter(r0);
        r1.mWrapper.mSafeToGc = r2;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
