package com.ttnet.org.chromium.base;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("Lifetime assertions aren't used when DCHECK is off.")
public class LifetimeAssert {
    static TestHook sTestHook;
    private final Object mTarget;

    @VisibleForTesting
    final WrappedReference mWrapper;

    private static class CreationException extends RuntimeException {
        CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    static class LifetimeAssertException extends RuntimeException {
        LifetimeAssertException(String r10, Throwable r11) {
            super(r10, r11);
        }
    }

    interface TestHook {
        void onCleaned(WrappedReference r10, String r11);
    }

    @VisibleForTesting
    static class WrappedReference extends PhantomReference<Object> {
        private static Set<WrappedReference> sActiveWrappers;
        private static ReferenceQueue<Object> sReferenceQueue;
        final CreationException mCreationException;
        boolean mSafeToGc;
        final Class<?> mTargetClass;

        static {
            sReferenceQueue = new ReferenceQueue();
            sActiveWrappers = Collections.synchronizedSet(new HashSet());
            final String r10 = "GcStateAssertQueue";
            new AnonymousClass1(r10);
        }

        public WrappedReference(Object r10, CreationException r11, boolean r12) {
            super(r10, sReferenceQueue);
            this.mCreationException = r11;
            this.mSafeToGc = r12;
            this.mTargetClass = r10.getClass();
            sActiveWrappers.add(this);
        }

        static /* synthetic */ ReferenceQueue access$000() {
            return sReferenceQueue;
        }

        static /* synthetic */ Set access$100() {
            return sActiveWrappers;
        }
    }

    private LifetimeAssert(WrappedReference r10, Object r11) {
        this.mWrapper = r10;
        this.mTarget = r11;
    }

    public static void assertAllInstancesDestroyedForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        Set r10 = WrappedReference.access$100();
        monitor-enter(r10);
        Iterator r11 = WrappedReference.access$100().iterator();     // Catch: Throwable -> L18
    L9:
        if (r11.hasNext() == false) goto L15;
        WrappedReference r12 = (WrappedReference) r11.next();     // Catch: Throwable -> L18
        if (r12.mSafeToGc == true) goto L9;
        throw new LifetimeAssertException(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", new Object[]{r12.mTargetClass.getName()}), r12.mCreationException);     // Catch: Throwable -> L18
    L15:
        WrappedReference.access$100().clear();     // Catch: Throwable -> L21
        monitor-exit(r10);     // Catch: Throwable -> L21
        return;
    L18:
        th = move-exception;
        WrappedReference.access$100().clear();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public static LifetimeAssert create(Object r10) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r10, new CreationException(), false), r10);
    }

    public static LifetimeAssert create(Object r10, boolean r11) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r10, new CreationException(), r11), r10);
    }

    public static void resetForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        WrappedReference.access$100().clear();
    }

    public static void setSafeToGc(LifetimeAssert r10, boolean r11) {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L12;
        Object r12 = r10.mTarget;
        monitor-enter(r12);
        r10.mWrapper.mSafeToGc = r11;     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
