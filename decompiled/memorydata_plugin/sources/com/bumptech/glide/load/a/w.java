package com.bumptech.glide.load.a;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class w<Data> implements o<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<Uri, Data> f646a;

    public static final class a implements p<String, AssetFileDescriptor> {
        public a() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<String, AssetFileDescriptor> a(s r3) {
            return new w(r3.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements p<String, ParcelFileDescriptor> {
        public b() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<String, ParcelFileDescriptor> a(s r3) {
            return new w(r3.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements p<String, InputStream> {
        public c() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<String, InputStream> a(s r3) {
            return new w(r3.a(Uri.class, InputStream.class));
        }
    }

    public w(o<Uri, Data> r3) {
        this.f646a = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
    }

    private static Uri b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        if (r2.charAt(0) == '/') goto L14;
        Uri r0 = Uri.parse(r2);
        if (r0.getScheme() == null) goto L14;
        return r0;
    L14:
        return c(r2);
    }

    private static Uri c(String r1) {
        return Uri.fromFile(new File(r1));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(String r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(String r2, int r3, int r4, com.bumptech.glide.load.e r5) {
        Uri r6 = b(r2);
        if (r6 != null) goto L5;
        return null;
    L5:
        if (this.f646a.a(r6) == true) goto L8;
        return null;
    L8:
        return this.f646a.a(r6, r3, r4, r5);
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(String r3) {
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(String r1) {
        return true;
    }
}
