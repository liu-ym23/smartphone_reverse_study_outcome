package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import androidx.core.util.Pools;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/MultiLinkSimplePools;", "", "T", "Landroidx/core/util/Pools$Pool;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkSimplePools<T> implements Pools.Pool<T> {
    public final ArrayDeque<T> a;
    public final String b;
    public final int c;

    public final int a() {
        return this.a.size();
    }

    public final T acquire() {
        if (this.a.size() > 0) goto L7;
        return null;
    L7:
        return (T) this.a.removeFirst();
    }

    public MultiLinkSimplePools(int r2) {
        this.c = r2;
        this.a = new ArrayDeque();
        this.b = "MultiLinkSimplePools";
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        new ArrayList(r2);
        return;
    L10:
        throw new IllegalArgumentException("The max pool size must be > 0".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final boolean release(T r6) {
        Intrinsics.checkNotNullParameter(r6, "instance");
        int r0 = this.a.size();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L9;
        if (this.a.get(r2) == r6) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        int r7 = x8.a.a;
        x8.a.b(this.b, "Already in the pool!", false);
        return true;
    L14:
        if (this.a.size() >= this.c) goto L19;
        this.a.addLast(r6);
        return true;
    L19:
        return false;
    L9:
        r1 = false;
        goto L10
    }
}
