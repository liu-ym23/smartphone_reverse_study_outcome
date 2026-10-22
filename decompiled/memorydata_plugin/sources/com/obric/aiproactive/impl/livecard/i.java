package com.obric.aiproactive.impl.livecard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/LockScreenActionSessionHolder;", "S", "", "<init>", "()V", "session", "Ljava/lang/Object;", "bind", "", "(Ljava/lang/Object;)V", "get", "()Ljava/lang/Object;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile S f6470a;

    public i() {
    }

    public final S a() {
        return this.f6470a;
    }

    public final void a(S r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.f6470a = r2;
    }
}
