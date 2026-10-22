package com.bytedance.ies.bullet.service.base;

import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.bytedance.forest.pollyfill.ForestNetAPI$HttpResponse$Companion$ForestNetException;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements a1.b, com.bumptech.glide.load.resource.bitmap.y, kj.b, pt.o, ee.a, org.threeten.bp.temporal.i, s8.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5962a;

    public /* synthetic */ c(int r5) {
        this.f5962a = r5;
    }

    public static com.bytedance.forest.pollyfill.c b(String r5, AbstractMap r10) {
        return new com.bytedance.forest.pollyfill.c(StringsKt.W(r5, '#'), r10);
    }

    public static com.bytedance.forest.pollyfill.d e(com.bytedance.forest.pollyfill.k r5, com.bytedance.forest.utils.e r10) {
        Throwable r11 = null;
        if ((r5 instanceof com.bytedance.forest.pollyfill.c) == true) goto L5;
        com.bytedance.forest.pollyfill.k r12 = null;
    L7:
        if (((com.bytedance.forest.pollyfill.c) r12) == null) goto L37;
        List r13 = com.bytedance.forest.model.b.f4359a;     // Catch: Throwable -> L12 CronetIOException -> L14 HttpResponseException -> L16
        com.bytedance.ttnet.utils.d.c(com.bytedance.forest.pollyfill.e.class, r5.f4525c).getClass();
        throw new ClassCastException();     // Catch: Throwable -> L12 CronetIOException -> L14 HttpResponseException -> L16
    L14:
        e = move-exception;
        Throwable r14 = e.getCause();
        if ((r14 instanceof HttpResponseException) == false) goto L23;
        r11 = r14;
    L23:
        HttpResponseException r15 = (HttpResponseException) r11;
        if (r15 != null) goto L40;
        int r16 = e.getStatusCode();
        Throwable r17 = e.getCause();
        if (r17 == null) goto L31;
        String r18 = r17.getMessage();
        if (r18 == null) goto L31;
    L32:
        r15 = new HttpResponseException(r16, r18);
    L31:
        r18 = e.getMessage();
    L40:
        return new com.bytedance.forest.pollyfill.d(r15, (com.bytedance.forest.pollyfill.c) r5, r10);
    L16:
        e = move-exception;
        return new com.bytedance.forest.pollyfill.d(e, (com.bytedance.forest.pollyfill.c) r5, r10);
    L12:
        th = move-exception;
        throw th;
    L37:
        throw new ForestNetAPI$HttpResponse$Companion$ForestNetException();
    L5:
        r12 = r5;
        goto L7
    }

    @Override // s8.e
    public void a() {
    }

    @Override // pt.o
    public Object apply(Object r5) {
        return r5;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.y
    public void c(MediaMetadataRetriever r5, Object r10) {
        r5.setDataSource(new com.bumptech.glide.load.resource.bitmap.x((ByteBuffer) r10));
    }

    @Override // a1.b
    public void d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Log.d(r5, r10);
    }

    public com.obric.flow.cardlistpage.c f() {
        com.obric.flow.cardlistpage.c r5 = com.obric.flow.cardlistpage.c.f11463c;
        if (r5 != null) goto L15;
        monitor-enter(this);
        r5 = com.obric.flow.cardlistpage.c.f11463c;     // Catch: Throwable -> L9
        if (r5 != null) goto L11;
        r5 = new com.obric.flow.cardlistpage.c();     // Catch: Throwable -> L9
        com.obric.flow.cardlistpage.c.f11463c = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    L9:
        th = move-exception;
        throw th;
    L15:
        return r5;
    }

    @Override // a1.b
    public void i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Log.i(r5, r10);
    }

    @Override // s8.e
    public boolean isEnable() {
        return true;
    }

    public String toString() {
        switch(this.f5962a) {
            case 11: goto L8;
            case 17: goto L6;
            default: goto L5;
        };
    L6:
        return "SccConfig{mServiceUrl='https://scc.bytedance.com/scc_sdk/url_scan_v4?scc_mode=coreless&scc_from=Bullet&scc_sdk_version=30'}";
    L8:
        return "IdentityFunction";
    L5:
        return super.toString();
    }

    @Override // a1.b
    public void w(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Log.w(r5, r10);
    }

    public c(String r5) {
        this.f5962a = 0;
        Intrinsics.checkNotNullParameter(r5, "url");
    }

    @Override // s8.e
    public void a(s8.a r5) {
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f5962a) {
            case 14: goto L7;
            default: goto L5;
        };
    L5:
        return (ZoneId) r5.query(this);
    L7:
        return LocalDate.from(r5);
    }

    @Override // a1.b
    public void e(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (r11 == null) goto L6;
        Log.e(r5, r10, r11);
        return;
    L6:
        Log.e(r5, r10);
    }
}
