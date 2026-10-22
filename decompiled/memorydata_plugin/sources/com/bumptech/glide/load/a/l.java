package com.bumptech.glide.load.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class l implements o<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f614a;

    public static final class a implements p<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f615a;

        public a(Context r3) {
            this.f615a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, File> a(s r1) {
            return new l(this.f615a);
        }
    }

    private static class b implements com.bumptech.glide.load.data.d<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f616a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f617b;
        private final Uri c;

        static {
            f616a = new String[]{"_data"};
        }

        b(Context r3, Uri r4) {
            this.f617b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.c = r4;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r8, com.bumptech.glide.load.data.d.a<? super File> r9) {
            com.bumptech.glide.load.data.d.a r10 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            Cursor r11 = ZeusProviderTransform.query(this.f617b.getContentResolver(), this.c, f616a, null, null, null, "com.obric.memorydata.plugin");
            String r0 = null;
            if (r11 == null) goto L12;
        L8:
            th = move-exception;
            r11.close();
            throw th;
        L5:
            if (r11.moveToFirst() == false) goto L7;
            r0 = r11.getString(r11.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L8
        L7:
            r11.close();
        L12:
            if (TextUtils.isEmpty(r0) == false) goto L14;
            r10.a(new FileNotFoundException("Failed to find file path for: " + this.c));
            return;
        L14:
            r10.a(new File(r0));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public l(Context r3) {
        this.f614a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<File> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), new b(this.f614a, r1));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a<File> a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return com.bumptech.glide.load.data.a.b.a(r1);
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
