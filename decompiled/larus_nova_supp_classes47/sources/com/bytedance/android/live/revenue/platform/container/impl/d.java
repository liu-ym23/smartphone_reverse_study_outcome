package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Throwable f;

        public a(View r1, String r2, String r3, String r4, String r5, Throwable r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r12) {
            Integer r13 = (Integer) r12;
            cq2.c r0 = vh6.c.b(cq2.c.class);
            View r1 = this.a;
            String r3 = this.b;
            JSONObject r4 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
            r4.put("caller", "android");
            r4.put("callee", "lynx");
            NativeHostServiceImpl r5 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
            com.bytedance.android.live.revenue.core.b r6 = com.bytedance.android.live.revenue.core.util.j.C0.a();
            if ((r6 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L5;
            r6 = null;
        L5:
            com.bytedance.android.live.revenue.core.a r7 = (com.bytedance.android.live.revenue.core.a) r6;
            if (r7 == null) goto L8;
            cy0.k r8 = r7.getScope();
        L9:
            String r9 = r5.E(r8);
            if (r9 == null) goto L12;
            r4.put("service_version", r9);
        L12:
            Unit r10 = Unit.INSTANCE;
            LinkedHashMap r14 = new LinkedHashMap();
            r14.put("channel_id", this.c);
            r14.put("interface_id", this.d);
            r14.put("method_id", this.e);
            Iterator r15 = r14.entrySet().iterator();
        L14:
            if (r15.hasNext() == false) goto L16;
            Map.Entry r16 = (Map.Entry) r15.next();
            r4.put((String) r16.getKey(), r16.getValue());
            goto L14
        L16:
            Unit r17 = Unit.INSTANCE;
            JSONObject r18 = new JSONObject();
            Iterator r19 = new LinkedHashMap().entrySet().iterator();
        L18:
            if (r19.hasNext() == false) goto L20;
            Map.Entry r20 = (Map.Entry) r19.next();
            r18.put((String) r20.getKey(), r20.getValue());
            goto L18
        L20:
            Unit r22 = Unit.INSTANCE;
            if (r18.length() <= 0) goto L23;
            boolean r23 = true;
        L24:
            if (r23 == true) goto L27;
            r18 = null;
        L27:
            JSONObject r24 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.b)});
            LinkedHashMap r110 = new LinkedHashMap();
            r110.put("message", String.valueOf(this.f.getMessage()));
            r110.put("stacktrace", ExceptionsKt.stackTraceToString(this.f));
            Iterator r111 = r110.entrySet().iterator();
        L29:
            if (r111.hasNext() == false) goto L31;
            Map.Entry r25 = (Map.Entry) r111.next();
            r24.put((String) r25.getKey(), r25.getValue());
            goto L29
        L31:
            Unit r112 = Unit.INSTANCE;
            r0.Y2(r1, "ttlive_aio_foundation_biz_error", r3, r4, r18, r24, false);
            return;
        L23:
            r23 = false;
            goto L24
        L8:
            r8 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public b(View r1, String r2, String r3, String r4, String r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r12) {
            Integer r13 = (Integer) r12;
            cq2.c r0 = vh6.c.b(cq2.c.class);
            View r1 = this.a;
            String r3 = this.b;
            JSONObject r4 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
            String r5 = this.c;
            if (r5 == null) goto L5;
            r4.put("interface_id", r5);
        L5:
            String r6 = this.d;
            if (r6 == null) goto L8;
            r4.put("method_id", r6);
        L8:
            r4.put("caller", "android");
            r4.put("callee", "lynx");
            NativeHostServiceImpl r7 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
            com.bytedance.android.live.revenue.core.b r8 = com.bytedance.android.live.revenue.core.util.j.C0.a();
            if ((r8 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L11;
            r8 = null;
        L11:
            com.bytedance.android.live.revenue.core.a r9 = (com.bytedance.android.live.revenue.core.a) r8;
            if (r9 == null) goto L14;
            cy0.k r10 = r9.getScope();
        L15:
            String r14 = r7.E(r10);
            if (r14 == null) goto L18;
            r4.put("service_version", r14);
        L18:
            Unit r15 = Unit.INSTANCE;
            LinkedHashMap r16 = new LinkedHashMap();
            r16.put("status", Integer.valueOf(this.f));
            Iterator r17 = r16.entrySet().iterator();
        L20:
            if (r17.hasNext() == false) goto L22;
            Map.Entry r18 = (Map.Entry) r17.next();
            r4.put((String) r18.getKey(), r18.getValue());
            goto L20
        L22:
            Unit r19 = Unit.INSTANCE;
            JSONObject r20 = new JSONObject();
            Iterator r22 = new LinkedHashMap().entrySet().iterator();
        L24:
            if (r22.hasNext() == false) goto L26;
            Map.Entry r23 = (Map.Entry) r22.next();
            r20.put((String) r23.getKey(), r23.getValue());
            goto L24
        L26:
            Unit r24 = Unit.INSTANCE;
            if (r20.length() <= 0) goto L29;
            boolean r25 = true;
        L30:
            if (r25 == true) goto L33;
            r20 = null;
        L33:
            JSONObject r26 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.b)});
            String r110 = this.e;
            if (r110 == null) goto L36;
            r26.put("channel_id", r110);
        L36:
            Iterator r111 = new LinkedHashMap().entrySet().iterator();
        L38:
            if (r111.hasNext() == false) goto L40;
            Map.Entry r27 = (Map.Entry) r111.next();
            r26.put((String) r27.getKey(), r27.getValue());
            goto L38
        L40:
            Unit r112 = Unit.INSTANCE;
            r0.Y2(r1, "ttlive_aio_foundation_call_all", r3, r4, r20, r26, true);
            return;
        L29:
            r25 = false;
            goto L30
        L14:
            r10 = null;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Throwable h;

        public c(View r1, String r2, String r3, String r4, String r5, String r6, String r7, Throwable r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r13) {
            Integer r14 = (Integer) r13;
            cq2.c r0 = vh6.c.b(cq2.c.class);
            View r1 = this.a;
            String r3 = this.b;
            JSONObject r4 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
            String r5 = this.c;
            if (r5 == null) goto L5;
            r4.put("interface_id", r5);
        L5:
            r4.put("caller", "android");
            r4.put("callee", "lynx");
            NativeHostServiceImpl r6 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
            com.bytedance.android.live.revenue.core.b r7 = com.bytedance.android.live.revenue.core.util.j.C0.a();
            if ((r7 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L8;
            r7 = null;
        L8:
            com.bytedance.android.live.revenue.core.a r8 = (com.bytedance.android.live.revenue.core.a) r7;
            if (r8 == null) goto L11;
            cy0.k r9 = r8.getScope();
        L12:
            String r10 = r6.E(r9);
            if (r10 == null) goto L15;
            r4.put("service_version", r10);
        L15:
            Unit r12 = Unit.INSTANCE;
            LinkedHashMap r15 = new LinkedHashMap();
            r15.put("channel_id", this.e);
            r15.put("interface_id", this.f);
            r15.put("method_id", this.g);
            Iterator r16 = r15.entrySet().iterator();
        L17:
            if (r16.hasNext() == false) goto L19;
            Map.Entry r17 = (Map.Entry) r16.next();
            r4.put((String) r17.getKey(), r17.getValue());
            goto L17
        L19:
            Unit r18 = Unit.INSTANCE;
            JSONObject r19 = new JSONObject();
            Iterator r20 = new LinkedHashMap().entrySet().iterator();
        L21:
            if (r20.hasNext() == false) goto L23;
            Map.Entry r22 = (Map.Entry) r20.next();
            r19.put((String) r22.getKey(), r22.getValue());
            goto L21
        L23:
            Unit r23 = Unit.INSTANCE;
            if (r19.length() <= 0) goto L26;
            boolean r24 = true;
        L27:
            if (r24 == true) goto L30;
            r19 = null;
        L30:
            JSONObject r25 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.b)});
            String r110 = this.d;
            if (r110 == null) goto L33;
            r25.put("channel_id", r110);
        L33:
            LinkedHashMap r111 = new LinkedHashMap();
            r111.put("message", String.valueOf(this.h.getMessage()));
            r111.put("stacktrace", ExceptionsKt.stackTraceToString(this.h));
            Iterator r112 = r111.entrySet().iterator();
        L35:
            if (r112.hasNext() == false) goto L37;
            Map.Entry r26 = (Map.Entry) r112.next();
            r25.put((String) r26.getKey(), r26.getValue());
            goto L35
        L37:
            Unit r113 = Unit.INSTANCE;
            r0.Y2(r1, "ttlive_aio_foundation_internal_error", r3, r4, r19, r25, false);
            return;
        L26:
            r24 = false;
            goto L27
        L11:
            r9 = null;
            goto L12
        }
    }

    public d() {
    }

    static {
    }

    public static void a(View r9, String r10, String r12, String r13, String r14, Throwable r15) {
        Intrinsics.checkNotNullParameter(r12, "channelId");
        Intrinsics.checkNotNullParameter(r13, "interfaceId");
        Intrinsics.checkNotNullParameter(r14, "methodId");
        Intrinsics.checkNotNullParameter(r15, "throwable");
        Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new a(r9, r10, r12, r13, r14, r15), k.a);
    }

    public static void b(View r9, String r10, String r12, String r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "channelId");
        Intrinsics.checkNotNullParameter(r13, "interfaceId");
        Intrinsics.checkNotNullParameter(r14, "methodId");
        Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new b(r9, r10, r13, r14, r12, r15), k.a);
    }

    public static /* synthetic */ void d(View r8, String r9, String r10, String r12, String r13, Throwable r14) {
        c(r8, r9, r10, r12, r13, r14, "android", "lynx");
    }

    public static void c(View r12, String r13, String r14, String r15, String r16, Throwable r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r14, "channelId");
        Intrinsics.checkNotNullParameter(r15, "interfaceId");
        Intrinsics.checkNotNullParameter(r16, "methodId");
        Intrinsics.checkNotNullParameter(r17, "throwable");
        Intrinsics.checkNotNullParameter(r18, "caller");
        Intrinsics.checkNotNullParameter(r19, "callee");
        Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new c(r12, r13, r19, r18, r14, r15, r16, r17), k.a);
    }
}
