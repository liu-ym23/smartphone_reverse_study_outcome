package com.obric.aiproactive.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/impl/RegisteredNowListener;", "", "limit", "", "hubListener", "Lcom/obric/aiproactive/impl/now/NowSnapshotListener;", "<init>", "(ILcom/obric/aiproactive/impl/now/NowSnapshotListener;)V", "getLimit", "()I", "getHubListener", "()Lcom/obric/aiproactive/impl/now/NowSnapshotListener;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiproactive.impl.now.c f6444b;

    public d(int r3, com.obric.aiproactive.impl.now.c r4) {
        com.obric.aiproactive.impl.now.c r5 = (com.obric.aiproactive.impl.now.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiproactive.impl.now.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "hubListener");
        this.f6443a = r3;
        this.f6444b = r5;
    }

    public final int a() {
        return this.f6443a;
    }

    public final com.obric.aiproactive.impl.now.c b() {
        return this.f6444b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (this.f6443a == r6.f6443a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6444b, r6.f6444b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f6443a) * 31) + this.f6444b.hashCode();
    }

    public String toString() {
        return "RegisteredNowListener(limit=" + this.f6443a + ", hubListener=" + this.f6444b + ')';
    }
}
