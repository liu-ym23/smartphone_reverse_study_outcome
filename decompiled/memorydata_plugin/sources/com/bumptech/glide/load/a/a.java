package com.bumptech.glide.load.a;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class a<Data> implements o<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f568a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f569b;
    private final InterfaceC0057a<Data> c;

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0057a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager r1, String r2);
    }

    public static class b implements InterfaceC0057a<AssetFileDescriptor>, p<Uri, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f570a;

        public b(AssetManager r1) {
            this.f570a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, AssetFileDescriptor> a(s r2) {
            return new a(this.f570a, this);
        }

        @Override // com.bumptech.glide.load.a.a.InterfaceC0057a
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(AssetManager r1, String r2) {
            return new com.bumptech.glide.load.data.h(r1, r2);
        }
    }

    public static class c implements InterfaceC0057a<InputStream>, p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f571a;

        public c(AssetManager r1) {
            this.f571a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, InputStream> a(s r2) {
            return new a(this.f571a, this);
        }

        @Override // com.bumptech.glide.load.a.a.InterfaceC0057a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager r1, String r2) {
            return new com.bumptech.glide.load.data.m(r1, r2);
        }
    }

    static {
    }

    public a(AssetManager r3, InterfaceC0057a<Data> r4) {
        InterfaceC0057a<Data> r5 = (InterfaceC0057a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0057a.class, "com.obric.memorydata.plugin");
        this.f569b = r3;
        this.c = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        String r5 = r1.toString().substring(f568a);
        return new o.a(new com.bumptech.glide.e.d(r1), this.c.a(this.f569b, r5));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r2) {
        if ("file".equals(r2.getScheme()) == true) goto L5;
        return false;
    L5:
        if (r2.getPathSegments().isEmpty() == false) goto L7;
        return false;
    L7:
        if ("android_asset".equals(r2.getPathSegments().get(0)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
