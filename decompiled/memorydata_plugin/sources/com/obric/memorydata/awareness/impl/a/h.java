package com.obric.memorydata.awareness.impl.a;

import com.obric.memorydata.awareness.api.AwarenessManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/awareness/impl/policy/PassthroughFeatureEventPolicy;", "Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicy;", "<init>", "()V", "evaluate", "", "feature", "", "oldValue", "", "newValue", "extras", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8630a = null;

    static {
        f8630a = new h();
    }

    private h() {
    }

    @Override // com.obric.memorydata.awareness.impl.a.b
    public void a(String r2, Object r3, Object r4, Map<String, ? extends Object> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "feature");
        AwarenessManager.INSTANCE.onFeatureEvent(r2, r3, r4, c.a(r1));
    }
}
