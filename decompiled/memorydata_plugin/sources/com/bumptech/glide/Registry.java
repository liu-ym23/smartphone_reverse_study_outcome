package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.a.p;
import com.bumptech.glide.load.a.q;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.pool.FactoryPools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Registry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.d.a f503b;
    private final com.bumptech.glide.d.e c;
    private final com.bumptech.glide.d.f d;
    private final com.bumptech.glide.load.data.f e;
    private final com.bumptech.glide.load.resource.d.f f;
    private final com.bumptech.glide.d.b g;
    private final com.bumptech.glide.d.d h;
    private final com.bumptech.glide.d.c i;
    private final Pools.Pool<List<Throwable>> j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String r1) {
            super(r1);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Class<?> r3, Class<?> r4) {
            super("Failed to find any ModelLoaders for model: " + r3 + " and data: " + r4);
        }

        public NoModelLoaderAvailableException(Object r3) {
            super("Failed to find any ModelLoaders registered for model class: " + r3.getClass());
        }

        public <M> NoModelLoaderAvailableException(M r3, List<o<M, ?>> r4) {
            super("Found ModelLoaders for model class: " + ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")) + ", but none that handle this specific model instance: " + r3);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> r3) {
            super("Failed to find result encoder for resource class: " + r3 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> r3) {
            super("Failed to find source encoder for data class: " + r3);
        }
    }

    public Registry() {
        this.h = new com.bumptech.glide.d.d();
        this.i = new com.bumptech.glide.d.c();
        Pools.Pool<List<Throwable>> r0 = FactoryPools.a();
        this.j = r0;
        this.f502a = new q(r0);
        this.f503b = new com.bumptech.glide.d.a();
        this.c = new com.bumptech.glide.d.e();
        this.d = new com.bumptech.glide.d.f();
        this.e = new com.bumptech.glide.load.data.f();
        this.f = new com.bumptech.glide.load.resource.d.f();
        this.g = new com.bumptech.glide.d.b();
        a(Arrays.asList(new String[]{"Animation", "Bitmap", "BitmapDrawable"}));
    }

    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.g<Data, TResource, Transcode>> c(Class<Data> r13, Class<TResource> r14, Class<Transcode> r15) {
        ArrayList r0 = new ArrayList();
        Iterator r16 = this.c.b(r13, r14).iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        Class r1 = (Class) ZeusTransformUtils.preCheckCast(r16.next(), Class.class, "com.obric.memorydata.plugin");
        Iterator r2 = this.f.b(r1, r15).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Class r7 = (Class) ZeusTransformUtils.preCheckCast(r2.next(), Class.class, "com.obric.memorydata.plugin");
        r0.add(new com.bumptech.glide.load.engine.g(r13, r1, r7, this.c.a(r13, r1), this.f.a(r1, r7), this.j));
        goto L7
    L9:
        return r0;
    }

    public Registry a(ImageHeaderParser r3) {
        ImageHeaderParser r4 = (ImageHeaderParser) ZeusTransformUtils.wrapperContextForParams(r3, ImageHeaderParser.class, "com.obric.memorydata.plugin");
        this.g.a(r4);
        return this;
    }

    public Registry a(com.bumptech.glide.load.data.e.a<?> r3) {
        com.bumptech.glide.load.data.e.a<?> r4 = (com.bumptech.glide.load.data.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.e.a.class, "com.obric.memorydata.plugin");
        this.e.a(r4);
        return this;
    }

    public <Data> Registry a(Class<Data> r3, com.bumptech.glide.load.a<Data> r4) {
        com.bumptech.glide.load.a r5 = (com.bumptech.glide.load.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.class, "com.obric.memorydata.plugin");
        this.f503b.a(r3, r5);
        return this;
    }

    public <TResource> Registry a(Class<TResource> r3, com.bumptech.glide.load.g<TResource> r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.memorydata.plugin");
        this.d.a(r3, r5);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> r3, Class<Data> r4, p<Model, Data> r5) {
        p<? extends Model, ? extends Data> r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.memorydata.plugin");
        this.f502a.a(r3, r4, r6);
        return this;
    }

    public <Data, TResource> Registry a(Class<Data> r3, Class<TResource> r4, com.bumptech.glide.load.f<Data, TResource> r5) {
        a("legacy_append", r3, r4, (com.bumptech.glide.load.f) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin"));
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> r3, Class<Transcode> r4, com.bumptech.glide.load.resource.d.e<TResource, Transcode> r5) {
        com.bumptech.glide.load.resource.d.e r6 = (com.bumptech.glide.load.resource.d.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.resource.d.e.class, "com.obric.memorydata.plugin");
        this.f.a(r3, r4, r6);
        return this;
    }

    public <Data, TResource> Registry a(String r3, Class<Data> r4, Class<TResource> r5, com.bumptech.glide.load.f<Data, TResource> r6) {
        com.bumptech.glide.load.f r7 = (com.bumptech.glide.load.f) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");
        this.c.a(r3, r7, r4, r5);
        return this;
    }

    public final Registry a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(r6.size());
        r0.add("legacy_prepend_all");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.add((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        r0.add("legacy_append");
        this.c.a(r0);
        return this;
    }

    public <X> com.bumptech.glide.load.a<X> a(X r2) {
        com.bumptech.glide.load.a<X> r1 = this.f503b.a(r2.getClass());
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSourceEncoderAvailableException(r2.getClass());
    }

    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.q<Data, TResource, Transcode> a(Class<Data> r10, Class<TResource> r11, Class<Transcode> r12) {
        com.bumptech.glide.load.engine.q<Data, TResource, Transcode> r0 = this.i.a(r10, r11, r12);
        if (this.i.a(r0) == false) goto L5;
        return null;
    L5:
        if (r0 != null) goto L11;
        List<com.bumptech.glide.load.engine.g<Data, TResource, Transcode>> r7 = c(r10, r11, r12);
        if (r7.isEmpty() == false) goto L9;
        r0 = null;
    L10:
        this.i.a(r10, r11, r12, r0);
        goto L11
    L9:
        r0 = new com.bumptech.glide.load.engine.q(r10, r11, r12, r7, this.j);
    L11:
        return r0;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> r1 = this.g.a();
        if (r1.isEmpty() == true) goto L6;
        return r1;
    L6:
        throw new NoImageHeaderParserException();
    }

    public boolean a(s<?> r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        if (this.d.a(r4.c()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public <X> com.bumptech.glide.load.data.e<X> b(X r1) {
        return this.e.a(r1);
    }

    public <X> com.bumptech.glide.load.g<X> b(s<X> r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.g<X> r2 = this.d.a(r4.c());
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new NoResultEncoderAvailableException(r4.c());
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> r7, Class<TResource> r8, Class<Transcode> r9) {
        List<Class<?>> r0 = this.h.a(r7, r8, r9);
        if (r0 != null) goto L16;
        r0 = new ArrayList();
        Iterator<Class<?>> r1 = this.f502a.a(r7).iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        Class r2 = (Class) ZeusTransformUtils.preCheckCast(r1.next(), Class.class, "com.obric.memorydata.plugin");
        Iterator r3 = this.c.b(r2, r8).iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        Class<?> r4 = (Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.memorydata.plugin");
        if (this.f.b(r4, r9).isEmpty() == true) goto L9;
        if (r0.contains(r4) == true) goto L9;
        r0.add(r4);
        goto L9
    L15:
        this.h.a(r7, r8, r9, Collections.unmodifiableList(r0));
    L16:
        return r0;
    }

    public <Model> List<o<Model, ?>> c(Model r1) {
        return this.f502a.a(r1);
    }
}
