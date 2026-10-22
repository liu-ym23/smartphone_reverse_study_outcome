package io.reactivex.observers;

/* JADX INFO: loaded from: classes3.dex */
public abstract enum BaseTestConsumer$TestWaitStrategy extends Enum<BaseTestConsumer$TestWaitStrategy> implements Runnable {
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_1000MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_100MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_10MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_1MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SPIN = null;
    public static final BaseTestConsumer$TestWaitStrategy YIELD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseTestConsumer$TestWaitStrategy[] f18174a = null;

    static {
        final String r5 = "SPIN";
        final int r10 = 0;
        BaseTestConsumer$TestWaitStrategy r11 = new AnonymousClass1(r5, r10);
        SPIN = r11;
        final String r12 = "YIELD";
        final int r13 = 1;
        BaseTestConsumer$TestWaitStrategy r14 = new AnonymousClass2(r12, r13);
        YIELD = r14;
        final String r15 = "SLEEP_1MS";
        final int r16 = 2;
        BaseTestConsumer$TestWaitStrategy r17 = new AnonymousClass3(r15, r16);
        SLEEP_1MS = r17;
        final String r18 = "SLEEP_10MS";
        final int r19 = 3;
        BaseTestConsumer$TestWaitStrategy r20 = new AnonymousClass4(r18, r19);
        SLEEP_10MS = r20;
        final String r21 = "SLEEP_100MS";
        final int r110 = 4;
        BaseTestConsumer$TestWaitStrategy r22 = new AnonymousClass5(r21, r110);
        SLEEP_100MS = r22;
        final String r111 = "SLEEP_1000MS";
        final int r112 = 5;
        BaseTestConsumer$TestWaitStrategy r23 = new AnonymousClass6(r111, r112);
        SLEEP_1000MS = r23;
        f18174a = new BaseTestConsumer$TestWaitStrategy[]{r11, r14, r17, r20, r22, r23};
    }

    public BaseTestConsumer$TestWaitStrategy(String r5, int r10, a r11) {
        super(r5, r10);
    }

    public static void sleep(int r5) {
        Thread.sleep(r5);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static BaseTestConsumer$TestWaitStrategy valueOf(String r5) {
        return (BaseTestConsumer$TestWaitStrategy) Enum.valueOf(BaseTestConsumer$TestWaitStrategy.class, r5);
    }

    public static BaseTestConsumer$TestWaitStrategy[] values() {
        return (BaseTestConsumer$TestWaitStrategy[]) f18174a.clone();
    }

    @Override // java.lang.Runnable
    public abstract void run();
}
