package com.bumptech.glide.load.a;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g<Data> implements o<File, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<Data> f604a;

    public static class a<Data> implements p<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<Data> f605a;

        public a(d<Data> r3) {
            this.f605a = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.a.p
        public final o<File, Data> a(s r1) {
            return new g(this.f605a);
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new AnonymousClass1());
        }
    }

    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d<Data> f607b;
        private Data c;

        c(File r3, d<Data> r4) {
            d<Data> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            this.f606a = r3;
            this.f607b = r5;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f607b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r2, com.bumptech.glide.load.data.d.a<? super Data> r3) {
            com.bumptech.glide.load.data.d.a r4 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            Data r5 = this.f607b.b(this.f606a);     // Catch: FileNotFoundException -> L5
            this.c = r5;     // Catch: FileNotFoundException -> L5
            r4.a(r5);     // Catch: FileNotFoundException -> L5
            return;
        L5:
            e = move-exception;
            if (Log.isLoggable("FileLoader", 3) == false) goto L9;
            Log.d("FileLoader", "Failed to open file", e);
        L9:
            r4.a(e);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data r0 = this.c;
            if (r0 == null) goto L9;
            this.f607b.a(r0);     // Catch: IOException -> L6
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

    public interface d<Data> {
        Class<Data> a();

        void a(Data r1);

        Data b(File r1);
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new AnonymousClass1());
        }
    }

    public g(d<Data> r3) {
        this.f604a = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(File r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), new c(r1, this.f604a));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(File r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(File r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(File r3) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"));
    }
}
