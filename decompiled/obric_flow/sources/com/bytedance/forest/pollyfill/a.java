package com.bytedance.forest.pollyfill;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Function1 f4501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ w f4502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Request f4503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m f4504l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f4505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.forest.utils.e f4506n;

    public a(Function1 r5, w r10, Request r11, m r12, boolean r13, com.bytedance.forest.utils.e r14, w r15, com.bytedance.forest.utils.e r16) {
        this.f4501i = r5;
        this.f4502j = r10;
        this.f4503k = r11;
        this.f4504l = r12;
        this.f4505m = r13;
        this.f4506n = r14;
        super(r15, r16);
    }

    @Override // com.bytedance.forest.pollyfill.j
    public final void a() {
        this.f4519a = FetchTask$State.d;
        this.d = null;
        this.f4501i.invoke(Boolean.FALSE);
    }

    public final void b(final String r10) {
        this.f4521c = r10;
        this.f4519a = FetchTask$State.e;
        this.d = null;
        com.bytedance.forest.utils.d.c(this.f4506n.g, 4, "cdnfetcher", null, null, new CDNFetchDepender$fetchResourceFile$result$1$onRedirection$1(r10), 28);
        Object r5 = this.f4502j.f4441q.getWebResourceRequest();
        if ((r5 instanceof WebResourceRequest) == true) goto L5;
        r5 = null;
    L5:
        WebResourceRequest r11 = (WebResourceRequest) r5;
        if (r11 != null) goto L8;
    L11:
        this.f4503k.setUrl(r10);
        this.f4503k.setSupportShuffle(false);
        com.bytedance.forest.utils.e r12 = this.f4506n;
        r12.getClass();
        r12.e = "redirection";
        com.lynx.tasm.behavior.ui.utils.e.d(this.f4503k, this.f4502j, null, this.f4506n).b(new CDNFetchDepender$fetchResourceFile$result$1$onRedirection$2(this));
        return;
    L8:
        if (r11.isForMainFrame() != true) goto L11;
        d();
    }

    public final void c(boolean r5, Throwable r10) {
        this.f4522h.b(new String[]{"cdn_finish"});
        this.f4519a = FetchTask$State.f4461c;
        String r11 = null;
        this.d = null;
        com.bytedance.forest.model.c r12 = this.f4502j.s;
        String r13 = String.valueOf(r10.getMessage());
        r12.getClass();
        r12.f4367l = r13;
        if (this.f4502j.f4429a == true) goto L18;
        if (r5 == false) goto L18;
        Lazy r14 = b.f4507a;
        Request r15 = this.f4503k;
        if (r15.getSupportShuffle() == false) goto L14;
        LinkedList<String> r16 = r15.getRemainedFallbackDomains$forest_release();
        if (r16.size() <= 0) goto L11;
        String r17 = r16.pop();
    L12:
        if (r17 == null) goto L14;
        Uri r18 = r15.getUri$forest_release();
        r15.setUrl(new Uri.Builder().scheme(r18.getScheme()).authority(r17).query(r18.getQuery()).path(r18.getPath()).toString());
        r11 = r15.getUrl();
        goto L14
    L11:
        r17 = null;
    L14:
        if (r11 == null) goto L18;
        this.f4504l.a(this.f4502j, this, this.f4505m);
        return;
    L18:
        w r19 = this.f4502j;
        if (r19.f4429a == true) goto L25;
        com.bytedance.forest.model.c r20 = r19.s;
        ErrorInfo$Type r21 = ErrorInfo$Type.e;
        String r22 = r10.getMessage();
        if (r22 != null) goto L24;
        r22 = "download failed";
    L24:
        r20.getClass();
        r20.f4360a += r20.a(r21, 3, r22);
    L25:
        this.f4501i.invoke(Boolean.FALSE);
    }

    public final void d() {
        this.f4522h.b(new String[]{"cdn_finish"});
        this.f4519a = FetchTask$State.f4460b;
        this.g.f4442r = true;
        this.d = null;
        this.f4501i.invoke(Boolean.TRUE);
    }
}
