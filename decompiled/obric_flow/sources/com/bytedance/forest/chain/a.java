package com.bytedance.forest.chain;

import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.ResourceFetcher;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.c;
import com.bytedance.forest.model.w;
import com.bytedance.forest.postprocessor.h;
import com.bytedance.forest.utils.d;
import com.bytedance.forest.utils.e;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResourceFetcher f4241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f4242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Request f4243c;
    public final w d;
    public final LinkedList e;
    public final h f;
    public final e g;

    public a(Request r5, w r10, LinkedList r11, h r12, e r13) {
        this.f4243c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
    }

    public final ResourceFetcher a(Request r12) {
        Class r5 = (Class) this.e.pop();
        e r10 = this.g;
        d.b(r10.g, 4, "ResourceFetcherChain", "try to create fetcher by class ".concat(r5.getSimpleName()), true, null, "create_fetcher", 16);
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L6 Exception -> L8
        String r13 = r5.getSimpleName();     // Catch: Throwable -> L6 Exception -> L8
        Locale r14 = Locale.ENGLISH;     // Catch: Throwable -> L6 Exception -> L8
        r11.append(r13.toLowerCase(r14));     // Catch: Throwable -> L6 Exception -> L8
        r11.append("_create_start");     // Catch: Throwable -> L6 Exception -> L8
        r10.b(new String[]{r11.toString()});     // Catch: Throwable -> L6 Exception -> L8
        ResourceFetcher r15 = (ResourceFetcher) r5.getConstructor(new Class[]{Forest.class}).newInstance(new Object[]{r12.getForest()});     // Catch: Throwable -> L6 Exception -> L8
        r15.setContext$forest_release(r10);     // Catch: Throwable -> L6 Exception -> L8
        this.f4241a = r15;     // Catch: Throwable -> L6 Exception -> L8
        r10.b(new String[]{r5.getSimpleName().toLowerCase(r14) + "_create_finish"});
        return r15;
    L6:
        th = move-exception;
        r10.b(new String[]{r5.getSimpleName().toLowerCase(Locale.ENGLISH) + "_create_finish"});
        throw th;
    L8:
        e = move-exception;
        throw new IllegalStateException("create fetcher failed", e);     // Catch: Throwable -> L6
    }

    public final void b(final Function1 r11) {
        d.c(this.g.g, 4, "ResourceFetcherChain", null, "res_pipeline", new ResourceFetcherChain$fetch$1(this), 8);
        if (this.f4243c.getFetcherSequence().contains(FetcherType.f4312a) == true) goto L6;
        c r5 = this.d.s;
        ErrorInfo$Type r10 = ErrorInfo$Type.f4311c;
        r5.getClass();
        r5.f4360a += r5.a(r10, 1, "disabled_by_config");
    L6:
        if (this.e.isEmpty() == false) goto L9;
        c r12 = this.d.s;
        ErrorInfo$Type r13 = ErrorInfo$Type.f4309a;
        String r14 = "ResourceFetcherChain# no fetcher for url:" + this.f4243c.getOriginUrl() + " geckoModel:" + this.f4243c.getGeckoModel();
        r12.getClass();
        r12.f4360a += r12.a(r13, 1, r14);
        r11.invoke(this.d);
        return;
    L9:
        String r15 = null;
        if (this.f != null) goto L12;
        Function1 r16 = r11;
    L13:
        if (r16 != null) goto L17;
        r16 = new ResourceFetcherChain$fetch$callbackWithProcessors$2(this, r11);
    L17:
        if (this.f4243c.isASync() == false) goto L21;
        c(r16);
        return;
    L21:
        if (this.e.isEmpty() == true) goto L41;
        ResourceFetcher r17 = a(this.f4243c);     // Catch: Throwable -> L26
        r17.fetchSync(this.f4243c, this.d);     // Catch: Throwable -> L26
        if (this.d.f4442r == false) goto L39;
        this.d.A = r17.getClass().getSimpleName();     // Catch: Throwable -> L26
        r16.invoke(this.d);     // Catch: Throwable -> L26
        return;
    L39:
        if (this.f4242b == false) goto L21;
        w r18 = this.d;
        r18.f4429a = true;
        c r19 = r18.s;
        ErrorInfo$Type r20 = ErrorInfo$Type.f4309a;
        r19.getClass();
        r19.f4360a += r19.a(r20, 2, "ResourceFetcherChain# on cancel load");
    L26:
        th = move-exception;
        if (this.e.isEmpty() == true) goto L29;
        this.g.g.a(6, "ResourceFetcherChain", true, th, "fetcher_load_error", new ResourceFetcherChain$fetchSync$1(th));
        goto L39
    L29:
        c r110 = this.d.s;
        ErrorInfo$Type r21 = ErrorInfo$Type.f4309a;
        StringBuilder r22 = new StringBuilder("catch error on ");
        ResourceFetcher r23 = this.f4241a;
        if (r23 == null) goto L32;
        String r24 = r23.getClass().getSimpleName();
    L33:
        r22.append(r24);
        r22.append(", error:");
        r22.append(th.getMessage());
        r22.append(' ');
        Throwable r25 = th.getCause();
        if (r25 == null) goto L36;
        r15 = r25.getMessage();
    L36:
        r22.append(r15);
        String r26 = r22.toString();
        r110.getClass();
        r110.f4360a += r110.a(r21, 3, r26);
        goto L41
    L32:
        r24 = null;
    L41:
        r16.invoke(this.d);
        return;
    L12:
        r16 = null;
        goto L13
    }

    public final void c(final Function1 r11) {
        w r5 = this.d;
        Request r10 = this.f4243c;
        final ResourceFetcher r12 = a(r10);     // Catch: Throwable -> L5
        r12.fetchAsync(r10, r5, new ResourceFetcherChain$fetchAsync$1(this, r11, r12));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.b(this.g.g, 6, "ResourceFetcherChain", " onException ", false, th, null, 40);
        if (this.e.isEmpty() == true) goto L9;
        c(r11);
        return;
    L9:
        c r13 = r5.s;
        ErrorInfo$Type r14 = ErrorInfo$Type.f4309a;
        String r15 = "ResourceFetcherChain# " + th.getMessage();
        r13.getClass();
        r13.f4360a += r13.a(r14, 3, r15);
        r11.invoke(r5);
    }
}
