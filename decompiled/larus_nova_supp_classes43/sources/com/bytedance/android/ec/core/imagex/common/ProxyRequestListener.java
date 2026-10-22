package com.bytedance.android.ec.core.imagex.common;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class ProxyRequestListener extends BaseRequestListener {
    public static final /* synthetic */ int c = 0;
    public final Map<String, Object> a;
    public final /* synthetic */ w<RequestListener> b;

    public static final class a {
        public static x a(RequestListener r10, BaseRequestListener r11) {
            x r0 = new x();
            if ((r10 instanceof ProxyRequestListener) == false) goto L8;
            Set<RequestListener> r12 = ((ProxyRequestListener) r10).b.a;
            w<RequestListener> r1 = r0.b;
            if (r12 == null) goto L7;
            r1.a.addAll(r12);
        L12:
            r0.b.a.add(r11);
            return r0;
        L7:
            r1.getClass();
            goto L12
        L8:
            w<RequestListener> r13 = r0.b;
            if (r10 == null) goto L11;
            r13.a.add(r10);
            goto L12
        L11:
            r13.getClass();
            goto L12
        }
    }

    static {
    }

    public final void b(Function1<? super RequestListener, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        this.b.a(r10);
    }

    public ProxyRequestListener() {
        this.b = new w(null);
        this.a = new LinkedHashMap();
    }

    public final Object a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return ((LinkedHashMap) this.a).get(r10);
    }

    public final void onRequestCancellation(final String r10) {
        b(new C02521(r10));
    }

    public final boolean requiresExtraMap(String r10) {
        RequestListener r0 = (RequestListener) CollectionsKt.firstOrNull(this.b.a);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.requiresExtraMap(r10) != true) goto L7;
        return true;
    }

    public final void onProducerStart(final String r10, final String r11) {
        b(new C02511(r10, r11));
    }

    public final void onProducerEvent(final String r10, final String r11, final String r12) {
        b(new AnonymousClass1(r10, r11, r12));
    }

    public final void onProducerFinishWithCancellation(final String r10, final String r11, final Map<String, String> r12) {
        b(new C02481(r10, r11, r12));
    }

    public final void onProducerFinishWithSuccess(final String r10, final String r11, final Map<String, String> r12) {
        b(new C02501(r10, r11, r12));
    }

    public final void onRequestIntermediateResult(final ImageRequest r10, final String r11, final boolean r12) {
        b(new ProxyRequestListener$onRequestIntermediateResult$$inlined$withEachType$1(r10, r11, r12));
    }

    public final void onRequestSuccess(final ImageRequest r10, final String r11, final boolean r12) {
        b(new C02551(r10, r11, r12));
    }

    public final void onUltimateProducerReached(final String r10, final String r11, final boolean r12) {
        b(new C02561(r10, r11, r12));
    }

    public final void onProducerFinishWithFailure(final String r10, final String r11, final Throwable r12, final Map<String, String> r13) {
        b(new C02491(r10, r11, r12, r13));
    }

    public final void onRequestFailure(final ImageRequest r10, final String r11, final Throwable r12, final boolean r13) {
        b(new C02531(r10, r11, r12, r13));
    }

    public final void onRequestStart(final ImageRequest r10, final Object r11, final String r12, final boolean r13) {
        b(new C02541(r10, r11, r12, r13));
    }
}
