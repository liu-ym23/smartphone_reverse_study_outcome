package com.ttnet.org.chromium.base;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class LifetimeAssert {
    static TestHook sTestHook;
    final WrappedReference mWrapper;

    public static class CreationException extends RuntimeException {
        public CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    public static class LifetimeAssertException extends RuntimeException {
        public LifetimeAssertException(String r8, Throwable r10) {
            super(r8, r10);
        }
    }

    public interface TestHook {
        void onCleaned(WrappedReference r8, String r10);
    }

    public static class WrappedReference extends PhantomReference<Object> {
        private static Set<WrappedReference> sActiveWrappers;
        private static ReferenceQueue<Object> sReferenceQueue;
        final CreationException mCreationException;
        boolean mSafeToGc;
        final Class<?> mTargetClass;

        static {
            sReferenceQueue = new ReferenceQueue();
            sActiveWrappers = Collections.synchronizedSet(new HashSet());
            final String r8 = "GcStateAssertQueue";
            new AnonymousClass1(r8);
        }

        public WrappedReference(Object r8, CreationException r10, boolean r11) {
            super(r8, sReferenceQueue);
            this.mCreationException = r10;
            this.mSafeToGc = r11;
            this.mTargetClass = r8.getClass();
            sActiveWrappers.add(this);
        }

        public static /* synthetic */ ReferenceQueue access$000() {
            return sReferenceQueue;
        }

        public static /* synthetic */ Set access$100() {
            return sActiveWrappers;
        }
    }

    private LifetimeAssert(WrappedReference r8) {
        this.mWrapper = r8;
    }

    public static void assertAllInstancesDestroyedForTesting() {
        if (BuildConfig.DCHECK_IS_ON == true) goto L5;
        return;
    L5:
        Set r8 = WrappedReference.access$100();
        monitor-enter(r8);
        Iterator r10 = WrappedReference.access$100().iterator();     // Catch: Throwable -> L17
    L9:
        if (r10.hasNext() == false) goto L15;
        WrappedReference r11 = (WrappedReference) r10.next();     // Catch: Throwable -> L17
        if (r11.mSafeToGc == true) goto L9;
        throw new LifetimeAssertException(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", new Object[]{r11.mTargetClass.getName()}), r11.mCreationException);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r8);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static LifetimeAssert create(Object r8) {
        if (BuildConfig.DCHECK_IS_ON == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r8, new CreationException(), false));
    }

    public static void setSafeToGc(LifetimeAssert r8, boolean r10) {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        r8.mWrapper.mSafeToGc = r10;
        return;
    }

    public static LifetimeAssert create(Object r8, boolean r10) {
        if (BuildConfig.DCHECK_IS_ON == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r8, new CreationException(), r10));
    }
}
