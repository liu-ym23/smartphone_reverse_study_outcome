package com.obric.aikernel.runtime.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/obric/aikernel/runtime/utils/RuntimeMetrics;", "", "()V", "timestampEngineInitResEnd", "", "getTimestampEngineInitResEnd", "()J", "timestampEngineInitResEnd$delegate", "Lkotlin/Lazy;", "timestampEngineInitResStart", "getTimestampEngineInitResStart", "timestampEngineInitResStart$delegate", "timestampInitAddPackageResEnd", "getTimestampInitAddPackageResEnd", "timestampInitAddPackageResEnd$delegate", "timestampInitAddPackageResStart", "getTimestampInitAddPackageResStart", "timestampInitAddPackageResStart$delegate", "timestampResourceManagerEnd", "getTimestampResourceManagerEnd", "timestampResourceManagerEnd$delegate", "timestampResourceManagerStart", "getTimestampResourceManagerStart", "timestampResourceManagerStart$delegate", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f6232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f6233b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;
    private static final Lazy g = null;

    static {
        f6232a = new k();
        f6233b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(RuntimeMetrics$timestampEngineInitResStart$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(RuntimeMetrics$timestampEngineInitResEnd$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(RuntimeMetrics$timestampInitAddPackageResStart$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(RuntimeMetrics$timestampInitAddPackageResEnd$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(RuntimeMetrics$timestampResourceManagerStart$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(RuntimeMetrics$timestampResourceManagerEnd$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private k() {
    }

    public final long a() {
        return ((Number) ZeusTransformUtils.preCheckCast(f6233b.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final long b() {
        return ((Number) ZeusTransformUtils.preCheckCast(c.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final long c() {
        return ((Number) ZeusTransformUtils.preCheckCast(d.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final long d() {
        return ((Number) ZeusTransformUtils.preCheckCast(e.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final long e() {
        return ((Number) ZeusTransformUtils.preCheckCast(f.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final long f() {
        return ((Number) ZeusTransformUtils.preCheckCast(g.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }
}
