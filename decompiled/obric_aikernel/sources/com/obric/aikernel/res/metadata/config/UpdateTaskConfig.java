package com.obric.aikernel.res.metadata.config;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateTaskConfig extends DistConfig {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f5023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f5024g;

    public UpdateTaskConfig(String r10, String r11, final k r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "json");
        super(r10, r11, r12);
        this.f5023f = LazyKt.lazy(new UpdateTaskConfig$depVersion$2(r12));
        this.f5024g = LazyKt.lazy(new UpdateTaskConfig$res$2(this));
    }

    public final String k() {
        return (String) this.f5023f.getValue();
    }

    public final List<DistConfig> l() {
        return (List) this.f5024g.getValue();
    }

    public List<DistConfig> m() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public String toString() {
        return g() + '@' + i() + '@' + k() + '|' + h();
    }
}
