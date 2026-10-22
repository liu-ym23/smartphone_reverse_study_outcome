package com.obric.aiproactive.impl.livecard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/RetainedDismissTimerState;", "", "<init>", "()V", "retainedRecommendIds", "", "", "retainForNextSessionDestroy", "", "recommendId", "shouldCancelOnSessionDestroy", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f6487a;

    public t() {
        this.f6487a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "recommendId");
        this.f6487a.add(r2);
    }

    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "recommendId");
        return !this.f6487a.remove(r2);
    }
}
