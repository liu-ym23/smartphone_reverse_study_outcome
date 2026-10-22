package com.bytedance.android.live.screenrotate.rotate;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.room.api.screenrotation.rotate.c {
    public final List<com.bytedance.android.live.room.api.screenrotation.rotate.a> a;
    public final List<c81.a> b;

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void d() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void release() {
        ((ArrayList) this.a).clear();
        this.b.clear();
    }

    public b() {
        this.a = new ArrayList();
        this.b = CollectionsKt.mutableListOf(new c81.a[]{oa1.a.a});
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final List<com.bytedance.android.live.room.api.screenrotation.rotate.a> b() {
        return this.a;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final List<c81.a> e() {
        return this.b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void a(com.bytedance.android.live.room.api.screenrotation.rotate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void c(c81.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        if (this.b.contains(r2) == true) goto L6;
        this.b.add(r2);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void f(com.bytedance.android.live.room.api.screenrotation.rotate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        ((ArrayList) this.a).remove(r2);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.c
    public final void g(c81.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.b.remove(r2);
    }
}
