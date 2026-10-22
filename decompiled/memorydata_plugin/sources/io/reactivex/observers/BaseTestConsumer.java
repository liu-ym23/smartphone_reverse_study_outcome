package io.reactivex.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final CountDownLatch f17155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List<T> f17156b;
    protected final List<Throwable> c;
    protected long d;
    protected Thread e;
    protected boolean f;
    protected int g;
    protected int h;

    /* JADX INFO: renamed from: io.reactivex.observers.BaseTestConsumer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum TestWaitStrategy extends Enum<TestWaitStrategy> implements Runnable {
        private static final /* synthetic */ TestWaitStrategy[] $VALUES = null;
        public static final TestWaitStrategy SLEEP_1000MS = null;
        public static final TestWaitStrategy SLEEP_100MS = null;
        public static final TestWaitStrategy SLEEP_10MS = null;
        public static final TestWaitStrategy SLEEP_1MS = null;
        public static final TestWaitStrategy SPIN = null;
        public static final TestWaitStrategy YIELD = null;

        static {
            final String r1 = "SPIN";
            final int r2 = 0;
            TestWaitStrategy r0 = new AnonymousClass1(r1, r2);
            SPIN = r0;
            final String r3 = "YIELD";
            final int r4 = 1;
            TestWaitStrategy r5 = new AnonymousClass2(r3, r4);
            YIELD = r5;
            final String r6 = "SLEEP_1MS";
            final int r7 = 2;
            TestWaitStrategy r8 = new AnonymousClass3(r6, r7);
            SLEEP_1MS = r8;
            final String r9 = "SLEEP_10MS";
            final int r10 = 3;
            TestWaitStrategy r11 = new AnonymousClass4(r9, r10);
            SLEEP_10MS = r11;
            final String r12 = "SLEEP_100MS";
            final int r13 = 4;
            TestWaitStrategy r14 = new AnonymousClass5(r12, r13);
            SLEEP_100MS = r14;
            final String r15 = "SLEEP_1000MS";
            final int r16 = 5;
            TestWaitStrategy r17 = new AnonymousClass6(r15, r16);
            SLEEP_1000MS = r17;
            $VALUES = new TestWaitStrategy[]{r0, r5, r8, r11, r14, r17};
        }

        private TestWaitStrategy(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ TestWaitStrategy(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static void sleep(int r2) {
            Thread.sleep(r2);     // Catch: InterruptedException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public static TestWaitStrategy valueOf(String r2) {
            return (TestWaitStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(TestWaitStrategy.class, r2), TestWaitStrategy.class, "com.obric.memorydata.plugin");
        }

        public static TestWaitStrategy[] values() {
            return (TestWaitStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TestWaitStrategy[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }
}
