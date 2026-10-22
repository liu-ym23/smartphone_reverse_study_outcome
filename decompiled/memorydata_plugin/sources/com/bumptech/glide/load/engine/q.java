package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<Data> f807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f808b;
    private final List<? extends g<Data, ResourceType, Transcode>> c;
    private final String d;

    public q(Class<Data> r3, Class<ResourceType> r4, Class<Transcode> r5, List<g<Data, ResourceType, Transcode>> r6, Pools.Pool<List<Throwable>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Pools.Pool<List<Throwable>> r9 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r7, Pools.Pool.class, "com.obric.memorydata.plugin");
        this.f807a = r3;
        this.f808b = r9;
        this.c = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r8), List.class, "com.obric.memorydata.plugin");
        this.d = "Failed LoadPath{" + r3.getSimpleName() + "->" + r4.getSimpleName() + "->" + r5.getSimpleName() + "}";
    }

    private s<Transcode> a(com.bumptech.glide.load.data.e<Data> r16, com.bumptech.glide.load.e r17, int r18, int r19, g.a<ResourceType> r20, List<Throwable> r21) {
        com.bumptech.glide.load.data.e r9 = (com.bumptech.glide.load.data.e) ZeusTransformUtils.wrapperContextForParams(r16, com.bumptech.glide.load.data.e.class, "com.obric.memorydata.plugin");
        g.a<ResourceType> r10 = (g.a) ZeusTransformUtils.wrapperContextForParams(r20, g.a.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        int r12 = this.c.size();
        s<Transcode> r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L12;
        r13 = ((g) ZeusTransformUtils.preCheckCast(this.c.get(r14), g.class, "com.obric.memorydata.plugin")).a(r9, r18, r19, r17, r10);     // Catch: GlideException -> L7
    L9:
        if (r13 != null) goto L12;
        r14 = r14 + 1;
    L7:
        e = move-exception;
        r11.add(e);
    L12:
        if (r13 == null) goto L15;
        return r13;
    L15:
        throw new GlideException(this.d, new ArrayList(r11));
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<Data> r10, com.bumptech.glide.load.e r11, int r12, int r13, g.a<ResourceType> r14) {
        com.bumptech.glide.load.data.e<Data> r3 = (com.bumptech.glide.load.data.e) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.data.e.class, "com.obric.memorydata.plugin");
        g.a<ResourceType> r7 = (g.a) ZeusTransformUtils.wrapperContextForParams(r14, g.a.class, "com.obric.memorydata.plugin");
        List<Throwable> r15 = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.f808b.acquire()), List.class, "com.obric.memorydata.plugin");
        s<Transcode> r16 = a(r3, r11, r12, r13, r7, r15);     // Catch: Throwable -> L6
        this.f808b.release(r15);
        return r16;
    L6:
        th = move-exception;
        this.f808b.release(r15);
        throw th;
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }
}
