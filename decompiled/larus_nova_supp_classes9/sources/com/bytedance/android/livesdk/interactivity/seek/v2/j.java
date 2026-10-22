package com.bytedance.android.livesdk.interactivity.seek.v2;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.message.config.depend.IMessageApi;
import com.bytedance.android.livesdk.utils.a4;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements com.ss.ugc.live.sdk.msg.network.i {
    public final IMessageApi a;
    public String b;
    public final h80.d<Long> c;
    public final h80.d<String> d;
    public final h80.d<String> e;
    public final h80.d<Map<String, String>> f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e b;

        public a(j r1, com.ss.ugc.live.sdk.msg.network.e r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Response r8 = ((SsResponse) r7).raw();
            if (r8.isSuccessful() == false) goto L16;
            TypedByteArray r0 = r8.getBody();
            if (r0 == null) goto L15;
            byte[] r1 = r0.getBytes();
            List r2 = r8.getHeaders();
            if (r2 != null) goto L9;
            r2 = CollectionsKt.emptyList();
        L9:
            List r3 = r2;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator<T> r5 = r3.iterator();
        L11:
            if (r5.hasNext() == false) goto L13;
            Header r6 = (Header) r5.next();
            r4.add(new com.ss.ugc.live.sdk.msg.network.d(r6.getName(), r6.getValue()));
            goto L11
        L13:
            com.ss.ugc.live.sdk.msg.network.g r9 = new com.ss.ugc.live.sdk.msg.network.g();
            r9.a = r8.getStatus();
            r9.b = r8.getReason();
            r9.c = r4;
            r9.d = r1;
            int r10 = com.ss.ugc.live.sdk.msg.utils.g.a;
            com.ss.ugc.live.sdk.msg.utils.g.c r11 = new com.ss.ugc.live.sdk.msg.utils.g.c(r9);
        L17:
            this.b.a(r11);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
        L16:
            bc2.c.e("http post response failed, code: " + r8.getStatus() + ". logId: " + this.a.e(r8));
            int r13 = com.ss.ugc.live.sdk.msg.utils.g.a;
            r11 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("response failed"));
            goto L17
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e a;

        public b(com.ss.ugc.live.sdk.msg.network.e r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.ss.ugc.live.sdk.msg.network.e r0 = this.a;
            int r1 = com.ss.ugc.live.sdk.msg.utils.g.a;
            r0.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception((Throwable) r3)));
        }
    }

    public final com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> a(com.ss.ugc.live.sdk.msg.network.f r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        HashMap r1 = new HashMap();     // Catch: Exception -> L31
        Map r2 = r7.h;     // Catch: Exception -> L31
        if (r2 == null) goto L6;
        r1.putAll(r2);     // Catch: Exception -> L31
    L6:
        r1.put("room_id", String.valueOf(((Number) this.c.get()).longValue()));     // Catch: Exception -> L31
        r1.put("room_tag", this.d.get());     // Catch: Exception -> L31
        r1.putAll((Map) this.f.get());     // Catch: Exception -> L31
        String r3 = (String) this.e.get();     // Catch: Exception -> L31
        if (TextUtils.isEmpty(this.b) == false) goto L9;
    L12:
        r1.put("cursor", r3);     // Catch: Exception -> L31
        IMessageApi r4 = this.a;     // Catch: Exception -> L31
        String r5 = r7.b;     // Catch: Exception -> L31
        List<Header> r6 = d(r7.c);     // Catch: Exception -> L31
        Map r8 = r7.d;     // Catch: Exception -> L31
        if (r8 != null) goto L15;
        r8 = new HashMap();     // Catch: Exception -> L31
    L15:
        Response r9 = r4.doPost(r5, r6, r8, r1).execute().raw();     // Catch: Exception -> L31
        if (r9.isSuccessful() == false) goto L29;
        this.b = r3;     // Catch: Exception -> L31
        TypedByteArray r0 = r9.getBody();     // Catch: Exception -> L31
        if (r0 == null) goto L28;
        byte[] r10 = r0.getBytes();     // Catch: Exception -> L31
        List r11 = r9.getHeaders();     // Catch: Exception -> L31
        if (r11 != null) goto L22;
        r11 = CollectionsKt.emptyList();     // Catch: Exception -> L31
    L22:
        List r13 = r11;     // Catch: Exception -> L31
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Exception -> L31
        Iterator r15 = r13.iterator();     // Catch: Exception -> L31
    L24:
        if (r15.hasNext() == false) goto L26;
        Header r16 = (Header) r15.next();     // Catch: Exception -> L31
        r14.add(new com.ss.ugc.live.sdk.msg.network.d(r16.getName(), r16.getValue()));     // Catch: Exception -> L31
        goto L24
    L26:
        com.ss.ugc.live.sdk.msg.network.g r17 = new com.ss.ugc.live.sdk.msg.network.g();     // Catch: Exception -> L31
        r17.a = r9.getStatus();     // Catch: Exception -> L31
        r17.b = r9.getReason();     // Catch: Exception -> L31
        r17.c = r14;     // Catch: Exception -> L31
        r17.d = r10;     // Catch: Exception -> L31
        int r18 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Exception -> L31
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r17);
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");     // Catch: Exception -> L31
    L29:
        bc2.c.e("http post response failed, code: " + r9.getStatus() + ". logId: " + e(r9));     // Catch: Exception -> L31
        a4.a(r9.getStatus(), e(r9), (String) this.d.get());     // Catch: Exception -> L31
        int r19 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Exception -> L31
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("response failed"));
    L9:
        if (TextUtils.equals(this.b, r3) == false) goto L12;
        int r20 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Exception -> L31
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("duplicate cursor"));
    L31:
        e = move-exception;
        bc2.c.e("http post failed: " + e.getMessage());
        int r21 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("http exception"));
    }

    public final List<Header> d(Map<String, String> r5) {
        if (r5 == null) goto L4;
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r6.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L7
    L9:
        return r0;
    L4:
        return new ArrayList();
    }

    public final String e(Response r4) {
        List r5 = r4.getHeaders();
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if (Intrinsics.areEqual("x-tt-logid", ((Header) r0).getName()) == false) goto L6;
    L11:
        Header r1 = (Header) r0;
        if (r1 == null) goto L15;
        String r7 = r1.getValue();
        if (r7 == null) goto L15;
        return r7;
    L10:
        r0 = null;
    L15:
        return BuildConfig.FLAVOR;
    }

    public final void b(com.ss.ugc.live.sdk.msg.network.f r5, com.ss.ugc.live.sdk.msg.network.e r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        TypedByteArray r0 = new TypedByteArray(r5.g, r5.a(), new String[0]);
        IMessageApi r1 = this.a;
        String r2 = r5.b;
        List<Header> r3 = d(r5.c);
        Map r7 = r5.d;
        if (r7 != null) goto L5;
        r7 = new HashMap();
    L5:
        r1.doPostAsync(r2, r3, r7, r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r6), new b(r6));
    }

    public final void c(com.ss.ugc.live.sdk.msg.network.f r4, lmc.a.f r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        IMessageApi r0 = this.a;
        String r1 = r4.b;
        List<Header> r2 = d(r4.c);
        Map r6 = r4.d;
        if (r6 != null) goto L5;
        r6 = new HashMap();
    L5:
        r0.doGetAsync(r1, r2, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r5), new i(r5));
    }

    public j(f.a r3, f.b r4, c r5) {
        f.c r0 = f.c.a;
        Intrinsics.checkNotNullParameter(r3, "roomIdSupplier");
        Intrinsics.checkNotNullParameter(r4, "roomTagSupplier");
        Intrinsics.checkNotNullParameter(r5, "cursorSupplier");
        Intrinsics.checkNotNullParameter(r0, "externalMessageFieldParams");
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r0;
        this.a = (IMessageApi) com.bytedance.android.live.network.c.b().e(IMessageApi.class);
        this.b = BuildConfig.FLAVOR;
    }
}
