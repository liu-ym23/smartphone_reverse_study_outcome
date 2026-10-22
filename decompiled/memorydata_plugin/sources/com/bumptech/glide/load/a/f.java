package com.bumptech.glide.load.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class f<DataT> implements o<Integer, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<DataT> f598b;

    private static final class a implements e<AssetFileDescriptor>, p<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f599a;

        a(Context r3) {
            this.f599a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        public AssetFileDescriptor a(Resources.Theme r1, Resources r2, int r3) {
            return r2.openRawResourceFd(r3);
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Integer, AssetFileDescriptor> a(s r2) {
            return new f(this.f599a, this);
        }

        @Override // com.bumptech.glide.load.a.f.e
        public Class<AssetFileDescriptor> a() {
            return AssetFileDescriptor.class;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(AssetFileDescriptor r1) {
            r1.close();
        }

        @Override // com.bumptech.glide.load.a.f.e
        public /* synthetic */ void a(AssetFileDescriptor r3) {
            a2((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r3, AssetFileDescriptor.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bumptech.glide.load.a.f.e
        public /* synthetic */ AssetFileDescriptor b(Resources.Theme r1, Resources r2, int r3) {
            return a(r1, r2, r3);
        }
    }

    private static final class b implements e<Drawable>, p<Integer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f600a;

        b(Context r3) {
            this.f600a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        public Drawable a(Resources.Theme r1, Resources r2, int r3) {
            return com.bumptech.glide.load.resource.b.b.a(this.f600a, r3, r1);
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Integer, Drawable> a(s r2) {
            return new f(this.f600a, this);
        }

        @Override // com.bumptech.glide.load.a.f.e
        public Class<Drawable> a() {
            return Drawable.class;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(Drawable r1) {
        }

        @Override // com.bumptech.glide.load.a.f.e
        public /* synthetic */ void a(Drawable r3) {
            a2((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bumptech.glide.load.a.f.e
        public /* synthetic */ Drawable b(Resources.Theme r1, Resources r2, int r3) {
            return a(r1, r2, r3);
        }
    }

    private static final class c implements e<InputStream>, p<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f601a;

        c(Context r3) {
            this.f601a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Integer, InputStream> a(s r2) {
            return new f(this.f601a, this);
        }

        public InputStream a(Resources.Theme r1, Resources r2, int r3) {
            return r2.openRawResource(r3);
        }

        @Override // com.bumptech.glide.load.a.f.e
        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(InputStream r1) {
            r1.close();
        }

        @Override // com.bumptech.glide.load.a.f.e
        public /* synthetic */ void a(InputStream r3) {
            a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bumptech.glide.load.a.f.e
        public /* synthetic */ InputStream b(Resources.Theme r1, Resources r2, int r3) {
            return a(r1, r2, r3);
        }
    }

    private static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources.Theme f602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Resources f603b;
        private final e<DataT> c;
        private final int d;
        private DataT e;

        d(Resources.Theme r3, Resources r4, e<DataT> r5, int r6) {
            e<DataT> r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            this.f602a = r3;
            this.f603b = r4;
            this.c = r7;
            this.d = r6;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<DataT> a() {
            return this.c.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r4, com.bumptech.glide.load.data.d.a<? super DataT> r5) {
            com.bumptech.glide.load.data.d.a r6 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            DataT r7 = this.c.b(this.f602a, this.f603b, this.d);     // Catch: Resources.NotFoundException -> L5
            this.e = r7;     // Catch: Resources.NotFoundException -> L5
            r6.a(r7);     // Catch: Resources.NotFoundException -> L5
            return;
        L5:
            e = move-exception;
            r6.a(e);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            DataT r0 = this.e;
            if (r0 == null) goto L9;
            this.c.a(r0);     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    private interface e<DataT> {
        Class<DataT> a();

        void a(DataT r1);

        DataT b(Resources.Theme r1, Resources r2, int r3);
    }

    f(Context r3, e<DataT> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        e<DataT> r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        this.f597a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f598b = r6;
    }

    public static p<Integer, InputStream> a(Context r2) {
        return new c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static p<Integer, AssetFileDescriptor> b(Context r2) {
        return new a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static p<Integer, Drawable> c(Context r2) {
        return new b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<DataT> a2(Integer r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        Resources.Theme r7 = (Resources.Theme) ZeusTransformUtils.preCheckCast(r6.b(com.bumptech.glide.load.resource.b.e.f833a), Resources.Theme.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        if (r7 == null) goto L6;
        Resources r8 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin");
    L8:
        return new o.a(new com.bumptech.glide.e.d(r3), new d(r7, r8, this.f598b, r3.intValue()));
    L6:
        r8 = ZeusTransformUtils.getResources(this.f597a, "com.obric.memorydata.plugin");
        goto L8
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(Integer r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Integer r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Integer r3) {
        return a2((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin"));
    }
}
