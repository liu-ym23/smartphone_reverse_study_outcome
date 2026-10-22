package com.google.common.hash;

import com.google.common.base.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r<j> f4716a = null;

    private static final class PureJavaLongAddable extends AtomicLong implements j {
        private PureJavaLongAddable() {
        }

        /* synthetic */ PureJavaLongAddable(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.hash.j
        public void add(long r1) {
            getAndAdd(r1);
        }

        @Override // com.google.common.hash.j
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.j
        public long sum() {
            return get();
        }
    }

    static {
        new LongAdder();     // Catch: Throwable -> L4
        r<j> r0 = new AnonymousClass1();     // Catch: Throwable -> L4
    L5:
        f4716a = r0;
        return;
    L4:
        r0 = new AnonymousClass2();
        goto L5
    }

    public static j a() {
        return (j) ZeusTransformUtils.preCheckCast(f4716a.get(), j.class, "com.obric.memorydata.plugin");
    }
}
