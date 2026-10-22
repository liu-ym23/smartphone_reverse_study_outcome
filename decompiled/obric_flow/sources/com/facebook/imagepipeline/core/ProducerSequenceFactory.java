package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ProducerSequenceFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f8135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerFactory f8136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrlConnectionNetworkFetcher f8137c;
    public final boolean d;
    public final ThreadHandoffProducerQueue e;
    public final boolean f;
    public final MultiImageTranscoderFactory g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Producer f8138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ThreadHandoffProducer f8139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ThreadHandoffProducer f8140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ThreadHandoffProducer f8141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RemoveImageTransformMetaDataProducer f8142l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RemoveImageTransformMetaDataProducer f8143m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RemoveImageTransformMetaDataProducer f8144n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SwallowResultProducer f8145o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SwallowResultProducer f8146p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Producer f8147q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Producer f8148r;
    public Producer s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Producer f8149t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Producer f8150u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Producer f8151v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Producer f8152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Producer f8153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f8154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f8155z;

    public ProducerSequenceFactory(ContentResolver r5, ProducerFactory r10, HttpUrlConnectionNetworkFetcher r11, boolean r12, ThreadHandoffProducerQueue r13, boolean r14, MultiImageTranscoderFactory r15) {
        this.f8135a = r5;
        this.f8136b = r10;
        this.f8137c = r11;
        this.d = r12;
        this.f8154y = new HashMap();
        this.f8155z = new HashMap();
        new HashMap();
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public final synchronized Producer a() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        if (this.f8140j != null) goto L8;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        EncodedCacheKeyMultiplexProducer r10 = c(new LocalContentUriFetchProducer(r5.f8124h.f8059a, r5.f8125i, r5.f8121a));     // Catch: Throwable -> L6
        ProducerFactory r11 = this.f8136b;     // Catch: Throwable -> L6
        ThreadHandoffProducerQueue r12 = this.e;     // Catch: Throwable -> L6
        r11.getClass();     // Catch: Throwable -> L6
        this.f8140j = new ThreadHandoffProducer(r10, r12);     // Catch: Throwable -> L6
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
    L8:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        ThreadHandoffProducer r13 = this.f8140j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer b() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        if (this.f8139i != null) goto L8;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        EncodedCacheKeyMultiplexProducer r10 = c(new LocalFileFetchProducer(r5.f8124h.f8059a, r5.f8125i));     // Catch: Throwable -> L6
        ProducerFactory r11 = this.f8136b;     // Catch: Throwable -> L6
        ThreadHandoffProducerQueue r12 = this.e;     // Catch: Throwable -> L6
        r11.getClass();     // Catch: Throwable -> L6
        this.f8139i = new ThreadHandoffProducer(r10, r12);     // Catch: Throwable -> L6
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
    L8:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        ThreadHandoffProducer r13 = this.f8139i;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer c() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        if (this.f8141k != null) goto L7;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L10
        Producer r10 = d();     // Catch: Throwable -> L10
        ThreadHandoffProducerQueue r11 = this.e;     // Catch: Throwable -> L10
        r5.getClass();     // Catch: Throwable -> L10
        this.f8141k = new ThreadHandoffProducer(r10, r11);     // Catch: Throwable -> L10
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
    L7:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        ThreadHandoffProducer r12 = this.f8141k;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer d() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        if (this.f8147q != null) goto L7;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L10
        HttpUrlConnectionNetworkFetcher r10 = this.f8137c;     // Catch: Throwable -> L10
        AddImageTransformMetaDataProducer r11 = new AddImageTransformMetaDataProducer(c(new NetworkFetchProducer(r5.f8125i, r5.d, r10)));     // Catch: Throwable -> L10
        this.f8147q = r11;     // Catch: Throwable -> L10
        ProducerFactory r12 = this.f8136b;     // Catch: Throwable -> L10
        boolean r13 = this.d;     // Catch: Throwable -> L10
        MultiImageTranscoderFactory r14 = this.g;     // Catch: Throwable -> L10
        this.f8147q = new ResizeAndRotateProducer(r12.f8124h.f8061c, r12.f8125i, r11, r13, r14);     // Catch: Throwable -> L10
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
    L7:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        Producer r15 = this.f8147q;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r15;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer e() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f8152w != null) goto L11;
        Producer r5 = new DataFetchProducer(this.f8136b.f8125i);     // Catch: Throwable -> L8
        if (WebpSupportStatus.f7700a == false) goto L10;
        ProducerFactory r10 = this.f8136b;     // Catch: Throwable -> L8
        r5 = new WebpTranscodeProducer(r10.f8124h.f8061c, r10.f8125i, r5);     // Catch: Throwable -> L8
    L10:
        ProducerFactory r11 = this.f8136b;     // Catch: Throwable -> L8
        AddImageTransformMetaDataProducer r12 = new AddImageTransformMetaDataProducer(r5);     // Catch: Throwable -> L8
        MultiImageTranscoderFactory r13 = this.g;     // Catch: Throwable -> L8
        this.f8152w = b(new ResizeAndRotateProducer(r11.f8124h.f8061c, r11.f8125i, r12, true, r13));     // Catch: Throwable -> L8
    L11:
        Producer r14 = this.f8152w;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r14;
    }

    public final synchronized Producer f() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f8151v != null) goto L8;
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        this.f8151v = a(new LocalAssetFetchProducer(r5.f8124h.f8059a, r5.f8125i, r5.f8123c), new ThumbnailProducer[]{r5.a()});     // Catch: Throwable -> L6
    L8:
        Producer r10 = this.f8151v;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final Producer g() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        if (this.f8143m != null) goto L8;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        this.f8143m = new RemoveImageTransformMetaDataProducer(a());     // Catch: Throwable -> L6
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
    L8:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return this.f8143m;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer h() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f8149t != null) goto L8;
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        this.f8149t = a(new LocalContentUriFetchProducer(r5.f8124h.f8059a, r5.f8125i, r5.f8121a), new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(r5.f8124h.f8059a, r5.f8125i, r5.f8121a), this.f8136b.a()});     // Catch: Throwable -> L6
    L8:
        Producer r10 = this.f8149t;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final Producer i() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        if (this.f8142l != null) goto L8;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        this.f8142l = new RemoveImageTransformMetaDataProducer(b());     // Catch: Throwable -> L6
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
    L8:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return this.f8142l;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer j() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f8148r != null) goto L8;
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        this.f8148r = a(new LocalFileFetchProducer(r5.f8124h.f8059a, r5.f8125i), new ThumbnailProducer[]{r5.a()});     // Catch: Throwable -> L6
    L8:
        Producer r10 = this.f8148r;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final synchronized Producer k() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f8150u != null) goto L8;
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        this.f8150u = a(new LocalResourceFetchProducer(r5.f8124h.f8059a, r5.f8125i, r5.f8122b), new ThumbnailProducer[]{r5.a()});     // Catch: Throwable -> L6
    L8:
        Producer r10 = this.f8150u;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final synchronized Producer l() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.s != null) goto L8;
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        this.s = a(new LocalVideoThumbnailProducer(r5.f8124h.f8059a, r5.f8121a));     // Catch: Throwable -> L6
    L8:
        Producer r10 = this.s;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final Producer m() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        if (this.f8144n != null) goto L8;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        this.f8144n = new RemoveImageTransformMetaDataProducer(c());     // Catch: Throwable -> L6
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
    L8:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return this.f8144n;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer n() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        if (this.f8138h != null) goto L7;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        this.f8138h = b(d());     // Catch: Throwable -> L10
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
    L7:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L10
        Producer r5 = this.f8138h;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer o() {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        if (this.f8146p != null) goto L8;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        this.f8146p = new SwallowResultProducer(c());     // Catch: Throwable -> L6
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
    L8:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L6
        SwallowResultProducer r5 = this.f8146p;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Producer p() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f8153x != null) goto L8;
        ProducerFactory r5 = this.f8136b;     // Catch: Throwable -> L6
        this.f8153x = a(new QualifiedResourceFetchProducer(r5.f8124h.f8059a, r5.f8125i, r5.f8121a), new ThumbnailProducer[]{r5.a()});     // Catch: Throwable -> L6
    L8:
        Producer r10 = this.f8153x;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final Producer c(ImageRequest r5) {
        if (r5.f8419j.f8433a > 3) goto L29;
        int r10 = r5.f8416c;
        if (r10 == 0) goto L27;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L15;
        Uri r11 = r5.f8415b;
        StringBuilder r12 = new StringBuilder("Unsupported uri scheme for encoded image fetch! Uri is: ");
        String r13 = String.valueOf(r11);
        if (r13.length() <= 30) goto L13;
        r13 = r13.substring(0, 30) + "...";
    L13:
        r12.append(r13);
        throw new IllegalArgumentException(r12.toString());
    L15:
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L19
        if (this.f8145o != null) goto L21;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L19
        this.f8145o = new SwallowResultProducer(b());     // Catch: Throwable -> L19
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L19
    L21:
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L19
        SwallowResultProducer r14 = this.f8145o;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r14;
    L19:
        th = move-exception;
        throw th;
    L27:
        return o();
    L29:
        throw new IllegalArgumentException();
    }

    public final Producer a(ImageRequest r5) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L9
        r5.getClass();     // Catch: Throwable -> L9
        Uri r10 = r5.f8415b;     // Catch: Throwable -> L9
        Preconditions.a(r10, "Uri is null.");     // Catch: Throwable -> L9
        int r11 = r5.f8416c;     // Catch: Throwable -> L9
        if (r11 == 0) goto L26;
        switch(r11) {
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L25;
            case 10: goto L13;
            default: goto L6;
        };     // Catch: Throwable -> L9
    L6:
        StringBuilder r12 = new StringBuilder("Unsupported uri scheme! Uri is: ");     // Catch: Throwable -> L9
        String r13 = String.valueOf(r10);     // Catch: Throwable -> L9
        if (r13.length() <= 30) goto L11;
        r13 = r13.substring(0, 30) + "...";     // Catch: Throwable -> L9
    L11:
        r12.append(r13);     // Catch: Throwable -> L9
        throw new IllegalArgumentException(r12.toString());     // Catch: Throwable -> L9
    L13:
        Producer r14 = h();     // Catch: Throwable -> L9
    L27:
        FrescoSystrace.a().getClass();
        return r14;
    L14:
        r14 = p();     // Catch: Throwable -> L9
        goto L27
    L15:
        r14 = e();     // Catch: Throwable -> L9
        goto L27
    L16:
        r14 = k();     // Catch: Throwable -> L9
        goto L27
    L17:
        r14 = f();     // Catch: Throwable -> L9
        goto L27
    L18:
        String r15 = this.f8135a.getType(r10);     // Catch: Throwable -> L9
        Map r16 = MediaUtils.f7659a;     // Catch: Throwable -> L9
        if (r15 != null) goto L21;
    L23:
        r14 = h();     // Catch: Throwable -> L9
        goto L27
    L21:
        if (r15.startsWith("video/") == false) goto L23;
        r14 = l();     // Catch: Throwable -> L9
        goto L27
    L24:
        r14 = j();     // Catch: Throwable -> L9
        goto L27
    L25:
        r14 = l();     // Catch: Throwable -> L9
        goto L27
    L26:
        r14 = n();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final Producer b(ImageRequest r5) {
        FrescoSystrace.a().getClass();
        Producer r10 = a(r5);
        if (r5.f8422m == null) goto L15;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.f8154y.containsKey(r10) == true) goto L10;
        ProducerFactory r11 = this.f8136b;     // Catch: Throwable -> L8
        PostprocessorProducer r12 = new PostprocessorProducer(r10, r11.f8132p, r11.f8124h.f8061c);     // Catch: Throwable -> L8
        ProducerFactory r13 = this.f8136b;     // Catch: Throwable -> L8
        PostprocessedBitmapMemoryCacheProducer r14 = new PostprocessedBitmapMemoryCacheProducer(r13.f8130n, r13.f8131o, r12);     // Catch: Throwable -> L8
        this.f8154y.put(r10, r14);     // Catch: Throwable -> L8
    L10:
        r10 = (Producer) this.f8154y.get(r10);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L15:
        FrescoSystrace.a().getClass();
        return r10;
    }

    public final Producer d(ImageRequest r5) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L20
        if (r5.f8419j.f8433a > 3) goto L34;
        Uri r10 = r5.f8415b;     // Catch: Throwable -> L20
        int r11 = r5.f8416c;     // Catch: Throwable -> L20
        if (r11 != 0) goto L8;
        Producer r12 = m();     // Catch: Throwable -> L20
        FrescoSystrace.a().getClass();
        return r12;
    L8:
        if (r11 == 2) goto L27;
        if (r11 == 3) goto L27;
        if (r11 != 4) goto L13;
    L24:
        Producer r13 = g();     // Catch: Throwable -> L20
        FrescoSystrace.a().getClass();
        return r13;
    L13:
        if (r11 == 9) goto L24;
        if (r11 == 10) goto L24;
        StringBuilder r14 = new StringBuilder("Unsupported uri scheme for encoded image fetch! Uri is: ");     // Catch: Throwable -> L20
        String r15 = String.valueOf(r10);     // Catch: Throwable -> L20
        if (r15.length() <= 30) goto L22;
        r15 = r15.substring(0, 30) + "...";     // Catch: Throwable -> L20
    L22:
        r14.append(r15);     // Catch: Throwable -> L20
        throw new IllegalArgumentException(r14.toString());     // Catch: Throwable -> L20
    L27:
        Producer r16 = i();     // Catch: Throwable -> L20
        FrescoSystrace.a().getClass();
        return r16;
    L34:
        throw new IllegalArgumentException();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final EncodedCacheKeyMultiplexProducer c(Producer r14) {
        if (WebpSupportStatus.f7700a == false) goto L5;
        ProducerFactory r5 = this.f8136b;
        Producer r10 = new WebpTranscodeProducer(r5.f8124h.f8061c, r5.f8125i, r14);
    L7:
        if (this.f == false) goto L9;
        FrescoSystrace.a().getClass();
        ProducerFactory r15 = this.f8136b;
        BufferedDiskCache r11 = r15.f8126j;
        BufferedDiskCache r12 = r15.f8127k;
        HashMap r13 = r15.f8128l;
        DefaultCacheKeyFactory r16 = r15.f8131o;
        PooledByteBufferFactory r17 = r15.f8125i;
        r10 = new DiskCacheReadProducer(r11, r12, r13, r16, new DiskCacheWriteProducer(r11, r12, r13, r16, r10, r17), r17);
        FrescoSystrace.a().getClass();
    L9:
        ProducerFactory r18 = this.f8136b;
        InstrumentedMemoryCache r19 = r18.f8129m;
        DefaultCacheKeyFactory r110 = r18.f8131o;
        return new EncodedCacheKeyMultiplexProducer(r110, new EncodedMemoryCacheProducer(r19, r110, r10));
    L5:
        r10 = r14;
        goto L7
    }

    public final Producer b(Producer r12) {
        FrescoSystrace.a().getClass();
        ProducerFactory r5 = this.f8136b;
        Producer r11 = a(new DecodeProducer(r5.d, r5.f8124h.f8060b, r5.e, r5.f, r5.g, r12, r5.f8134r, r5.f8133q));
        FrescoSystrace.a().getClass();
        return r11;
    }

    public final Producer a(LocalFetchProducer r10, ThumbnailProducer[] r11) {
        AddImageTransformMetaDataProducer r5 = new AddImageTransformMetaDataProducer(c(r10));
        ProducerFactory r12 = this.f8136b;
        MultiImageTranscoderFactory r13 = this.g;
        ResizeAndRotateProducer r14 = new ResizeAndRotateProducer(r12.f8124h.f8061c, r12.f8125i, r5, true, r13);
        ThrottlingProducer r15 = new ThrottlingProducer(this.f8136b.f8124h.d, r14);
        this.f8136b.getClass();
        ThumbnailBranchProducer r16 = new ThumbnailBranchProducer(r11);
        ProducerFactory r17 = this.f8136b;
        MultiImageTranscoderFactory r18 = this.g;
        return b(new BranchOnSeparateImagesProducer(new ResizeAndRotateProducer(r17.f8124h.f8061c, r17.f8125i, r16, true, r18), r15));
    }

    public final Producer a(Producer r5) {
        ProducerFactory r10 = this.f8136b;
        InstrumentedMemoryCache r11 = r10.f8130n;
        DefaultCacheKeyFactory r12 = r10.f8131o;
        BitmapMemoryCacheKeyMultiplexProducer r13 = new BitmapMemoryCacheKeyMultiplexProducer(r12, new BitmapMemoryCacheProducer(r11, r12, r5));
        ProducerFactory r14 = this.f8136b;
        ThreadHandoffProducerQueue r15 = this.e;
        r14.getClass();
        ThreadHandoffProducer r16 = new ThreadHandoffProducer(r13, r15);
        ProducerFactory r17 = this.f8136b;
        return new BitmapMemoryCacheGetProducer(r17.f8130n, r17.f8131o, r16);
    }
}
