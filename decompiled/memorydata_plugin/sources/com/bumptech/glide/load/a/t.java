package com.bumptech.glide.load.a;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class t<Data> implements o<Integer, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<Uri, Data> f636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f637b;

    public static final class a implements p<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f638a;

        public a(Resources r1) {
            this.f638a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Integer, AssetFileDescriptor> a(s r4) {
            return new t(this.f638a, r4.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements p<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f639a;

        public b(Resources r1) {
            this.f639a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Integer, InputStream> a(s r4) {
            return new t(this.f639a, r4.a(Uri.class, InputStream.class));
        }
    }

    public static class c implements p<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f640a;

        public c(Resources r1) {
            this.f640a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Integer, Uri> a(s r2) {
            return new t(this.f640a, x.a());
        }
    }

    public t(Resources r3, o<Uri, Data> r4) {
        o<Uri, Data> r5 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
        this.f637b = r3;
        this.f636a = r5;
    }

    private Uri b(Integer r5) {
        return Uri.parse("android.resource://" + this.f637b.getResourcePackageName(r5.intValue()) + '/' + this.f637b.getResourceTypeName(r5.intValue()) + '/' + this.f637b.getResourceEntryName(r5.intValue()));
    L4:
        e = move-exception;
        if (Log.isLoggable("ResourceLoader", 5) == false) goto L12;
        Log.w("ResourceLoader", "Received invalid resource id: " + r5, e);
        return null;
    L12:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(Integer r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        Uri r5 = b(r1);
        if (r5 != null) goto L6;
        return null;
    L6:
        return this.f636a.a(r5, r2, r3, r4);
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
