package com.bumptech.glide.load.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface o<Model, Data> {

    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.c f622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.c> f623b;
        public final com.bumptech.glide.load.data.d<Data> c;

        public a(com.bumptech.glide.load.c r3, com.bumptech.glide.load.data.d<Data> r4) {
            com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.data.d r6 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
            this(r5, Collections.emptyList(), r6);
        }

        public a(com.bumptech.glide.load.c r3, List<com.bumptech.glide.load.c> r4, com.bumptech.glide.load.data.d<Data> r5) {
            com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.data.d r8 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
            this.f622a = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r6), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
            this.f623b = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r7), List.class, "com.obric.memorydata.plugin");
            this.c = (com.bumptech.glide.load.data.d) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r8), com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
        }
    }

    a<Data> a(Model r1, int r2, int r3, com.bumptech.glide.load.e r4);

    boolean a(Model r1);
}
