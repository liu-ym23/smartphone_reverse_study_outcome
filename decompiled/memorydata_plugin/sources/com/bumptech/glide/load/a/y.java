package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class y<Data> implements o<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f650a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<Data> f651b;

    public static final class a implements p<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f652a;

        public a(ContentResolver r1) {
            this.f652a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, AssetFileDescriptor> a(s r1) {
            return new y(this);
        }

        @Override // com.bumptech.glide.load.a.y.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri r2) {
            return new com.bumptech.glide.load.data.a(this.f652a, r2);
        }
    }

    public static class b implements p<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f653a;

        public b(ContentResolver r1) {
            this.f653a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, ParcelFileDescriptor> a(s r1) {
            return new y(this);
        }

        @Override // com.bumptech.glide.load.a.y.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri r2) {
            return new com.bumptech.glide.load.data.i(this.f653a, r2);
        }
    }

    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri r1);
    }

    public static class d implements p<Uri, InputStream>, c<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f654a;

        public d(ContentResolver r1) {
            this.f654a = r1;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, InputStream> a(s r1) {
            return new y(this);
        }

        @Override // com.bumptech.glide.load.a.y.c
        public com.bumptech.glide.load.data.d<InputStream> a(Uri r2) {
            return new com.bumptech.glide.load.data.n(this.f654a, r2);
        }
    }

    static {
        f650a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", Params.CONTENT, "android.resource"})));
    }

    public y(c<Data> r3) {
        this.f651b = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), this.f651b.a(r1));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return f650a.contains(r1.getScheme());
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
