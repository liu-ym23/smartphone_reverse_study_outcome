package com.google.common.cache;

import com.google.common.base.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r<f> f4353a = null;

    private static final class PureJavaLongAddable extends AtomicLong implements f {
        private PureJavaLongAddable() {
        }

        /* synthetic */ PureJavaLongAddable(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.cache.f
        public void add(long r1) {
            getAndAdd(r1);
        }

        @Override // com.google.common.cache.f
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.f
        public long sum() {
            return get();
        }
    }

    static {
        new LongAdder();     // Catch: Throwable -> L4
        r<f> r0 = new AnonymousClass1();     // Catch: Throwable -> L4
    L5:
        f4353a = r0;
        return;
    L4:
        r0 = new AnonymousClass2();
        goto L5
    }

    public static f a() {
        return (f) ZeusTransformUtils.preCheckCast(f4353a.get(), f.class, "com.obric.memorydata.plugin");
    }
}
