package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<DataType> f777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.f<DataType, ResourceType>> f778b;
    private final com.bumptech.glide.load.resource.d.e<ResourceType, Transcode> c;
    private final Pools.Pool<List<Throwable>> d;
    private final String e;

    interface a<ResourceType> {
        s<ResourceType> a(s<ResourceType> r1);
    }

    public g(Class<DataType> r3, Class<ResourceType> r4, Class<Transcode> r5, List<? extends com.bumptech.glide.load.f<DataType, ResourceType>> r6, com.bumptech.glide.load.resource.d.e<ResourceType, Transcode> r7, Pools.Pool<List<Throwable>> r8) {
        List<? extends com.bumptech.glide.load.f<DataType, ResourceType>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.resource.d.e<ResourceType, Transcode> r10 = (com.bumptech.glide.load.resource.d.e) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.resource.d.e.class, "com.obric.memorydata.plugin");
        Pools.Pool<List<Throwable>> r11 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r8, Pools.Pool.class, "com.obric.memorydata.plugin");
        this.f777a = r3;
        this.f778b = r9;
        this.c = r10;
        this.d = r11;
        this.e = "Failed DecodePath{" + r3.getSimpleName() + "->" + r4.getSimpleName() + "->" + r5.getSimpleName() + "}";
    }

    private s<ResourceType> a(com.bumptech.glide.load.data.e<DataType> r9, int r10, int r11, com.bumptech.glide.load.e r12) {
        com.bumptech.glide.load.data.e<DataType> r3 = (com.bumptech.glide.load.data.e) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.data.e.class, "com.obric.memorydata.plugin");
        List<Throwable> r13 = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.d.acquire()), List.class, "com.obric.memorydata.plugin");
        s<ResourceType> r14 = a(r3, r10, r11, r12, r13);     // Catch: Throwable -> L6
        this.d.release(r13);
        return r14;
    L6:
        th = move-exception;
        this.d.release(r13);
        throw th;
    }

    private s<ResourceType> a(com.bumptech.glide.load.data.e<DataType> r10, int r11, int r12, com.bumptech.glide.load.e r13, List<Throwable> r14) {
        com.bumptech.glide.load.data.e r15 = (com.bumptech.glide.load.data.e) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.data.e.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        int r0 = this.f778b.size();
        s<ResourceType> r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        com.bumptech.glide.load.f r4 = (com.bumptech.glide.load.f) ZeusTransformUtils.preCheckCast(this.f778b.get(r3), com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        if (Log.isLoggable("DecodePath", 2) == false) goto L13;
        Log.v("DecodePath", "Failed to decode data for " + r4, e);
    L13:
        r16.add(e);
    L14:
        if (r2 != null) goto L17;
        r3 = r3 + 1;
        goto L3
    L6:
        if (r4.a(r15.a(), r13) == false) goto L14;
        r2 = r4.a(r15.a(), r11, r12, r13);     // Catch: Throwable -> L9
    L17:
        if (r2 == null) goto L20;
        return r2;
    L20:
        throw new GlideException(this.e, new ArrayList(r16));
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<DataType> r3, int r4, int r5, com.bumptech.glide.load.e r6, a<ResourceType> r7) {
        com.bumptech.glide.load.data.e<DataType> r8 = (com.bumptech.glide.load.data.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.e.class, "com.obric.memorydata.plugin");
        s<ResourceType> r9 = ((a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin")).a(a(r8, r4, r5, r6));
        return this.c.a(r9, r6);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f777a + ", decoders=" + this.f778b + ", transcoder=" + this.c + '}';
    }
}
