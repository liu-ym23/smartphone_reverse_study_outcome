package com.obric.memorydata.awareness.impl.collector;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\f\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "", "<init>", "()V", "isCollecting", "", "()Z", "setCollecting", "(Z)V", "startCollect", "", "stopCollect", "queryFeatureAndExtra", "Lkotlin/Pair;", "", "", "featureName", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8645a;

    public e() {
    }

    public Pair<Object, Map<String, Object>> a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return null;
    }

    public void b() {
        this.f8645a = true;
    }

    public void c() {
        this.f8645a = false;
    }

    public final boolean d() {
        return this.f8645a;
    }
}
