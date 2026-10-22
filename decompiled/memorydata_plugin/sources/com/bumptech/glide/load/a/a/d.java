package com.bumptech.glide.load.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.a.p;
import com.bumptech.glide.load.a.s;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d<DataT> implements o<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o<File, DataT> f580b;
    private final o<Uri, DataT> c;
    private final Class<DataT> d;

    private static abstract class a<DataT> implements p<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<DataT> f582b;

        a(Context r3, Class<DataT> r4) {
            this.f581a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.f582b = r4;
        }

        @Override // com.bumptech.glide.load.a.p
        public final o<Uri, DataT> a(s r6) {
            return new d(this.f581a, r6.a(File.class, this.f582b), r6.a(Uri.class, this.f582b), this.f582b);
        }
    }

    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ParcelFileDescriptor.class);
        }
    }

    public static final class c extends a<InputStream> {
        public c(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), InputStream.class);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a.d$d, reason: collision with other inner class name */
    private static final class C0059d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f583a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f584b;
        private final o<File, DataT> c;
        private final o<Uri, DataT> d;
        private final Uri e;
        private final int f;
        private final int g;
        private final com.bumptech.glide.load.e h;
        private final Class<DataT> i;
        private volatile boolean j;
        private volatile com.bumptech.glide.load.data.d<DataT> k;

        static {
            f583a = new String[]{"_data"};
        }

        C0059d(Context r3, o<File, DataT> r4, o<Uri, DataT> r5, Uri r6, int r7, int r8, com.bumptech.glide.load.e r9, Class<DataT> r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            o<File, DataT> r12 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            o<Uri, DataT> r13 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin");
            this.f584b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.c = r12;
            this.d = r13;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }

        private File a(Uri r9) {
            Cursor r0 = null;
            Cursor r1 = ZeusProviderTransform.query(this.f584b.getContentResolver(), r9, f583a, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            if (r1 == null) goto L16;
            if (r1.moveToFirst() == false) goto L16;
            String r8 = r1.getString(r1.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r8) == true) goto L14;
            File r10 = new File(r8);     // Catch: Throwable -> L17
            if (r1 == null) goto L12;
            r1.close();
        L12:
            return r10;
        L14:
            throw new FileNotFoundException("File path was empty in media store for: " + r9);     // Catch: Throwable -> L17
        L16:
            throw new FileNotFoundException("Failed to media store entry for: " + r9);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            if (0 == 0) goto L20;
            r0.close();
        L20:
            throw th;
        }

        private com.bumptech.glide.load.data.d<DataT> e() {
            o.a<DataT> r0 = f();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.c;
        }

        private o.a<DataT> f() {
            if (Environment.isExternalStorageLegacy() == false) goto L7;
            return this.c.a(a(this.e), this.f, this.g, this.h);
        L7:
            if (com.bumptech.glide.load.data.a.b.b(this.e) == false) goto L11;
            return this.d.a(this.e, this.f, this.g, this.h);
        L11:
            if (g() == false) goto L13;
            Uri r0 = MediaStore.setRequireOriginal(this.e);
        L15:
            return this.d.a(r0, this.f, this.g, this.h);
        L13:
            r0 = this.e;
            goto L15
        }

        private boolean g() {
            if (this.f584b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<DataT> a() {
            return this.i;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r3, com.bumptech.glide.load.data.d.a<? super DataT> r4) {
            com.bumptech.glide.load.data.d.a<? super DataT> r5 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.data.d<DataT> r0 = e();     // Catch: FileNotFoundException -> L12
            if (r0 != null) goto L7;
            r5.a(new IllegalArgumentException("Failed to build fetcher for: " + this.e));     // Catch: FileNotFoundException -> L12
            return;
        L7:
            this.k = r0;     // Catch: FileNotFoundException -> L12
            if (this.j == false) goto L10;
            c();     // Catch: FileNotFoundException -> L12
            return;
        L10:
            r0.a(r3, r5);     // Catch: FileNotFoundException -> L12
            return;
        L12:
            e = move-exception;
            r5.a(e);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> r0 = this.k;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
            this.j = true;
            com.bumptech.glide.load.data.d<DataT> r1 = this.k;
            if (r1 == null) goto L6;
            r1.c();
            return;
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    d(Context r3, o<File, DataT> r4, o<Uri, DataT> r5, Class<DataT> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        o<File, DataT> r8 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
        o<Uri, DataT> r9 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin");
        this.f579a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f580b = r8;
        this.c = r9;
        this.d = r6;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<DataT> a2(Uri r14, int r15, int r16, com.bumptech.glide.load.e r17) {
        return new o.a(new com.bumptech.glide.e.d(r14), new C0059d(this.f579a, this.f580b, this.c, r14, r15, r16, r17, this.d));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L7:
        return false;
    L5:
        if (com.bumptech.glide.load.data.a.b.a(r2) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
