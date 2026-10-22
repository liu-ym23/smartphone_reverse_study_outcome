package com.bytedance.android.live.network.impl.factory;

import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.i;
import com.bytedance.android.live.network.NetworkSettingKeys;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.impl.utils.NetworkGson;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiTypeRequestConverterFactory extends Converter.Factory {
    public final ThreadLocal<g> a;
    public final rx5.a b;

    public final class a<T> implements am3.c<T> {
        public final Class<T> a;
        public final /* synthetic */ MultiTypeRequestConverterFactory b;

        public final T decode(g r5) {
            Intrinsics.checkNotNullParameter(r5, "reader");
            long r0 = r5.c();
        L4:
            if (r5.f() == (-1)) goto L5;
            h.e(r5);
            goto L4
        L5:
            r5.d(r0);
            return (T) MultiTypeRequestConverterFactory.a(this.b, this.a);
        }

        public a(MultiTypeRequestConverterFactory r2, Class<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            this.b = r2;
            this.a = r3;
        }
    }

    public final class b implements am3.c<com.bytedance.android.live.base.model.h> {
        public b() {
        }

        public final Object decode(g r3) {
            Intrinsics.checkNotNullParameter(r3, "reader");
            return new com.bytedance.android.live.base.model.h(h.b(r3), null);
        }
    }

    public final class c implements am3.c<i> {
        public c() {
        }

        public final Object decode(g r3) {
            Intrinsics.checkNotNullParameter(r3, "reader");
            return new i(h.b(r3), null);
        }
    }

    public final class d implements Converter<TypedInput, Object> {
        public final Type a;
        public final Function0<Collection<Object>> b;
        public final Class<?> c;
        public final Class<?> d;
        public final Class<?> e;
        public final Function1<TypedInput, Object> f;
        public final /* synthetic */ MultiTypeRequestConverterFactory g;

        public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r2) {
            return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r2);
        }

        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.-CC.$default$needRequestBuilder(this);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.android.live.network.impl.factory.MultiTypeRequestConverterFactory$ProtoConverter$convert$1] */
        public final Object convert(Object r6) {
            TypedInput r7 = (TypedInput) r6;
            Intrinsics.checkNotNullParameter(r7, "typedInput");
            if ((!Intrinsics.areEqual(r7.mimeType(), "application/x-protobuf")) == true) goto L39;
            final g r8 = this.g.e(r7);
            ho0.b r0 = ho0.b.a(r8);
            byte[] r1 = r0.body;
            if (r1 == null) goto L8;
            r8.k(new am3.b(r1));
        L9:
            final ho0.a r2 = r0.header;
            if (r2 == null) goto L38;
            ?? r3 = new MultiTypeRequestConverterFactory$ProtoConverter$convert$1(this, r8, r2);
            if (r2.a != 0) goto L26;
            Pair<Object, Extra> r9 = r3.m600invoke();
            Object r4 = r9.component1();
            Extra r10 = (Extra) r9.component2();
            if (com.bytedance.android.live.network.response.a.class.isAssignableFrom(this.c) == false) goto L17;
            return new com.bytedance.android.live.network.response.b.C0138b(r10);
        L17:
            if (com.bytedance.android.live.network.response.e.class.isAssignableFrom(this.c) == false) goto L21;
            Object r5 = new com.bytedance.android.live.network.response.f.b(r4, r10);
        L41:
            return r5;
        L21:
            if (ExtraResponse.class.isAssignableFrom(this.c) == false) goto L24;
            r5 = new com.bytedance.android.live.network.response.d.b(r4, r10);
            goto L41
        L24:
            throw new IllegalStateException(("Response type [" + this.c + "] is not supported").toString());
        L26:
            if (com.bytedance.android.live.network.response.a.class.isAssignableFrom(this.c) == false) goto L29;
            int r11 = r2.a;
            MultiTypeRequestConverterFactory r12 = this.g;
            RequestError r13 = new RequestError();
            r12.getClass();
            MultiTypeRequestConverterFactory.d(r13, r2);
            MultiTypeRequestConverterFactory r14 = this.g;
            Class<?> r15 = this.e;
            r14.getClass();
            return new com.bytedance.android.live.network.response.b.a(r11, r13, MultiTypeRequestConverterFactory.c(r2, r15));
        L29:
            if (com.bytedance.android.live.network.response.e.class.isAssignableFrom(this.c) == false) goto L32;
            int r16 = r2.a;
            MultiTypeRequestConverterFactory r17 = this.g;
            RequestError r18 = new RequestError();
            r17.getClass();
            MultiTypeRequestConverterFactory.d(r18, r2);
            MultiTypeRequestConverterFactory r19 = this.g;
            Class<?> r20 = this.e;
            r19.getClass();
            return new com.bytedance.android.live.network.response.f.a(r16, r18, MultiTypeRequestConverterFactory.c(r2, r20));
        L32:
            if (ExtraResponse.class.isAssignableFrom(this.c) == false) goto L36;
            int r21 = r2.a;
            MultiTypeRequestConverterFactory r22 = this.g;
            RequestError r23 = new RequestError();
            r22.getClass();
            MultiTypeRequestConverterFactory.d(r23, r2);
            MultiTypeRequestConverterFactory r24 = this.g;
            Class<?> r25 = this.e;
            r24.getClass();
            return new com.bytedance.android.live.network.response.d.a(r21, r23, MultiTypeRequestConverterFactory.c(r2, r25));
        L36:
            throw new IllegalStateException(("Response type [" + this.c + "] is not supported").toString());
        L38:
            throw new IllegalArgumentException(("Response missing header: " + this.a).toString());
        L8:
            r8 = null;
            goto L9
        L39:
            return this.f.invoke(r7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(MultiTypeRequestConverterFactory r2, Type r3, Function0<? extends Collection<Object>> r4, Class<?> r5, Class<?> r6, Class<?> r7, Function1<? super TypedInput, ? extends Object> r8) {
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r5, "rawType");
            Intrinsics.checkNotNullParameter(r6, "dataClassType");
            Intrinsics.checkNotNullParameter(r7, "extraType");
            Intrinsics.checkNotNullParameter(r8, "handleJson");
            this.g = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    public static final class e {
        public static final Class<Object> e = null;
        public final Class<?> a;
        public final Type b;
        public final int c;
        public final boolean d;

        public static final class a {
        }

        static {
            e = Object.class;
        }

        public final void a() {
            if (this.d == false) goto L6;
            return;
        L6:
            throw new IllegalStateException(("failed to resolve type parameter at " + this.c).toString());
        }

        public e(Class<?> r2, Type r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "rawType");
            Intrinsics.checkNotNullParameter(r3, "resolved");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class f<F, T> implements Converter {
        public final /* synthetic */ MultiTypeRequestConverterFactory a;
        public final /* synthetic */ Annotation[] b;
        public final /* synthetic */ Class c;
        public final /* synthetic */ e d;
        public final /* synthetic */ e e;
        public final /* synthetic */ Type f;
        public final /* synthetic */ Retrofit g;
        public final /* synthetic */ AnonymousClass1 h;

        public f(MultiTypeRequestConverterFactory r1, Annotation[] r2, Class r3, e r4, e r5, Type r6, Retrofit r7, AnonymousClass1 r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r2) {
            return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r2);
        }

        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.-CC.$default$needRequestBuilder(this);
        }

        /* JADX WARN: Type inference failed for: r3v10, types: [R extends com.bytedance.android.live.base.model.Extra, com.bytedance.android.live.base.model.Extra] */
        /* JADX WARN: Type inference failed for: r3v5, types: [R extends com.bytedance.android.live.base.model.Extra, com.bytedance.android.live.base.model.Extra] */
        /* JADX WARN: Type inference failed for: r9v35, types: [R extends com.bytedance.android.live.base.model.Extra, com.bytedance.android.live.base.model.Extra] */
        /* JADX WARN: Type inference failed for: r9v4, types: [R extends com.bytedance.android.live.base.model.Extra, com.bytedance.android.live.base.model.Extra] */
        public final Object convert(Object r17) {
            TypedInput r0 = (TypedInput) r17;
            g r3 = null;
            if (Intrinsics.areEqual(r0.mimeType(), "application/x-protobuf") == false) goto L212;
            MultiTypeRequestConverterFactory r2 = this.a;
            POST[] r4 = this.b;
            r2.getClass();
            int r5 = r4.length;
            int r6 = 0;
        L5:
            if (r6 >= r5) goto L13;
            POST r7 = r4[r6];
            if ((r7 instanceof GET) == true) goto L8;
            if ((r7 instanceof POST) == true) goto L11;
            r6 = r6 + 1;
            goto L5
        L11:
            String r8 = r7.value();
        L15:
            if (r8.length() <= 0) goto L17;
            boolean r9 = true;
        L18:
            if (r9 == true) goto L21;
            r8 = null;
        L21:
            MultiTypeRequestConverterFactory r10 = this.a;
            Class r11 = this.c;
            e r12 = this.d;
            e r13 = this.e;
            g r1 = r10.e(r0);
            ho0.b r14 = ho0.b.a(r1);
            byte[] r15 = r14.body;
            if (r15 == null) goto L24;
            r1.k(new am3.b(r15));
            r3 = r1;
        L24:
            Object r16 = r11.newInstance();
            int r18 = 2;
            int r19 = -1;
            if (Response.class.isAssignableFrom(r11) == false) goto L53;
            if (r16 == null) goto L51;
            Response r20 = (Response) r16;
            Type r21 = r12.b;
            if (r21 == null) goto L49;
            Class r22 = (Class) r21;
            ho0.a r23 = r14.header;
            r20.statusCode = r23.a;
            ?? r24 = new Extra();
            ((Extra) r24).now = r23.e;
            r20.extra = r24;
            if (r23.a != 0) goto L32;
            boolean r25 = true;
        L33:
            if (r25 == false) goto L47;
            if (r3 == null) goto L45;
            long r26 = r3.c();
        L36:
            int r110 = r3.f();
            if (r110 == (-1)) goto L38;
            if (r110 != 1) goto L41;
            r20.data = (T) MultiTypeRequestConverterFactory.b(r10, r22).decode(r3);
            boolean r111 = true;
        L42:
            if (r111 == true) goto L36;
            h.e(r3);
            goto L36
        L41:
            r111 = false;
            goto L42
        L38:
            r3.d(r26);
        L45:
            if (r20.data != null) goto L174;
            r20.data = (T) r22.newInstance();
        L174:
            if (r8 == null) goto L247;
            MultiTypeRequestConverterFactory r27 = this.a;
            Type r28 = this.f;
            Annotation[] r29 = this.b;
            Retrofit r30 = this.g;
            r27.getClass();
            Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L207
            if ((r16 instanceof com.bytedance.android.live.network.response.c) == false) goto L180;
            Triple r32 = new Triple(Integer.valueOf(((com.bytedance.android.live.network.response.c) r16).getStatusCode()), ((com.bytedance.android.live.network.response.c) r16).getError(), ((com.bytedance.android.live.network.response.c) r16).a());     // Catch: Throwable -> L207
        L188:
            int r33 = ((Number) r32.component1()).intValue();     // Catch: Throwable -> L207
            Object r112 = r32.component2();     // Catch: Throwable -> L207
            Extra r34 = (Extra) r32.component3();     // Catch: Throwable -> L207
            Integer r113 = (Integer) NetworkSettingKeys.USE_PB_OBJECT_JSON_PASS_THROUGH.getValue();     // Catch: Throwable -> L207
            if (r113.intValue() <= 0) goto L204;
            JsonObject r114 = new JsonObject();     // Catch: Throwable -> L207
            r114.addProperty("status_code", Integer.valueOf(r33));     // Catch: Throwable -> L207
            r114.add("data", NetworkGson.a().toJsonTree(r112));     // Catch: Throwable -> L207
            r114.add("extra", NetworkGson.a().toJsonTree(r34));     // Catch: Throwable -> L207
            INetworkService r35 = (INetworkService) k.n(INetworkService.class);     // Catch: Throwable -> L207
            String r36 = "https://board.bytedance.net/api/json/" + r8;     // Catch: Throwable -> L207
            List r37 = CollectionsKt.emptyList();     // Catch: Throwable -> L207
            String r38 = NetworkGson.a().toJson(r114);     // Catch: Throwable -> L207
            Charset r115 = Charsets.UTF_8;     // Catch: Throwable -> L207
            if (r38 == null) goto L203;
            ByteArrayInputStream r39 = new ByteArrayInputStream(((HttpResponse) r35.post(r36, r37, "application/json", r38.getBytes(r115)).execute()).getBody());     // Catch: Throwable -> L207
            if (r113.intValue() != 2) goto L204;
            rx5.c r40 = r27.b.responseBodyConverter(r28, r29, r30);     // Catch: Throwable -> L207
            InputStreamReader r41 = new InputStreamReader(r39, MimeUtil.parseCharset("application/json", "UTF-8"));     // Catch: Throwable -> L207
            Object r42 = r40.b.read(r40.a.newJsonReader(r41));     // Catch: Throwable -> L199
        L222:
            r41.close();     // Catch: IOException -> L216 Throwable -> L207
        L205:
            Object r43 = Result.constructor-impl(r42);     // Catch: Throwable -> L207
        L209:
            Object r44 = r43;
            if (Result.isFailure-impl(r44) == true) goto L247;
            return r44;
        L199:
            th = move-exception;
            r41.close();     // Catch: IOException -> L217 Throwable -> L207
        L201:
            throw th;     // Catch: Throwable -> L207
        L203:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L207
        L204:
            r42 = r16;
            goto L205
        L180:
            if ((r16 instanceof ExtraResponse) == false) goto L183;
            r32 = new Triple(0, ((ExtraResponse) r16).data, ((ExtraResponse) r16).extra);     // Catch: Throwable -> L207
            goto L188
        L183:
            if ((r16 instanceof BaseResponse) == false) goto L186;
            r32 = new Triple(Integer.valueOf(((BaseResponse) r16).statusCode), ((BaseResponse) r16).data, ((BaseResponse) r16).extra);     // Catch: Throwable -> L207
            goto L188
        L186:
            if ((r16 instanceof BaseListResponse) == false) goto L204;
            r32 = new Triple(Integer.valueOf(((BaseListResponse) r16).statusCode), ((BaseListResponse) r16).data, ((BaseListResponse) r16).extra);     // Catch: Throwable -> L207
        L207:
            th = move-exception;
            Result.Companion r45 = Result.Companion;
            r43 = Result.constructor-impl(ResultKt.createFailure(th));
        L247:
            return r16;
        L47:
            RequestError r46 = new RequestError();
            MultiTypeRequestConverterFactory.d(r46, r23);
            r20.error = r46;
            goto L174
        L32:
            r25 = false;
            goto L33
        L49:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        L51:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.network.response.Response<*>");
        L53:
            if (ListResponse.class.isAssignableFrom(r11) == false) goto L79;
            if (r16 == null) goto L78;
            ListResponse r47 = (ListResponse) r16;
            Type r48 = r12.b;
            if (r48 == null) goto L76;
            Class r49 = (Class) r48;
            ho0.a r50 = r14.header;
            r47.statusCode = r50.a;
            ?? r51 = new Extra();
            ((Extra) r51).now = r50.e;
            r47.extra = r51;
            if (r50.a != 0) goto L60;
            boolean r52 = true;
        L61:
            if (r52 == false) goto L74;
            ArrayList r53 = new ArrayList();
            if (r3 == null) goto L73;
            long r54 = r3.c();
        L65:
            int r116 = r3.f();
            if (r116 == (-1)) goto L67;
            if (r116 != 1) goto L70;
            r53.add(MultiTypeRequestConverterFactory.b(r10, r49).decode(r3));
            boolean r117 = true;
        L71:
            if (r117 == true) goto L65;
            h.e(r3);
            goto L65
        L70:
            r117 = false;
            goto L71
        L67:
            r3.d(r54);
        L73:
            r47.data = r53;
            goto L174
        L74:
            RequestError r55 = new RequestError();
            MultiTypeRequestConverterFactory.d(r55, r50);
            r47.error = r55;
            goto L174
        L60:
            r52 = false;
            goto L61
        L76:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        L78:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.network.response.ListResponse<*>");
        L79:
            String r118 = "null cannot be cast to non-null type com.bytedance.android.live.base.model.Extra";
            if (BaseResponse.class.isAssignableFrom(r11) == false) goto L128;
            if (r16 == null) goto L126;
            BaseResponse r56 = (BaseResponse) r16;
            Type r57 = r12.b;
            if (r57 == null) goto L124;
            Class r58 = (Class) r57;
            Type r59 = r13.b;
            if (r59 == null) goto L122;
            Class r60 = (Class) r59;
            ho0.a r61 = r14.header;
            int r119 = r61.a;
            r56.statusCode = r119;
            if (r119 != 0) goto L89;
            boolean r120 = true;
        L90:
            if (r120 == false) goto L120;
            if (r3 == null) goto L111;
            long r62 = r3.c();
        L93:
            int r121 = r3.f();
            if (r121 == r19) goto L95;
            if (r121 == 1) goto L105;
            if (r121 == r18) goto L100;
            boolean r122 = false;
        L107:
            if (r122 == true) goto L109;
            h.e(r3);
        L109:
            r18 = 2;
            r19 = -1;
            goto L93
        L100:
            Object r123 = MultiTypeRequestConverterFactory.b(r10, r60).decode(r3);
            if (r123 == null) goto L104;
            R r124 = (R) r123;
            ((Extra) r124).now = r61.e;
            r56.extra = r124;
        L106:
            r122 = true;
            goto L107
        L104:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.Extra");
        L105:
            r56.data = (T) MultiTypeRequestConverterFactory.b(r10, r58).decode(r3);
            goto L106
        L95:
            r3.d(r62);
        L111:
            if (r56.data != null) goto L114;
            r56.data = (T) r58.newInstance();
        L114:
            if (r56.extra != 0) goto L174;
            Object r63 = r60.newInstance();
            if (r63 == null) goto L119;
            R r65 = (R) r63;
            ((Extra) r65).now = r61.e;
            r56.extra = r65;
            goto L174
        L119:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.Extra");
        L120:
            RequestError r66 = new RequestError();
            MultiTypeRequestConverterFactory.d(r66, r61);
            r56.error = r66;
            r56.extra = MultiTypeRequestConverterFactory.c(r61, r60);
            goto L174
        L89:
            r120 = false;
            goto L90
        L122:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        L124:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        L126:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.network.response.BaseResponse<*, *>");
        L128:
            if (BaseListResponse.class.isAssignableFrom(r11) == false) goto L174;
            if (r16 == null) goto L173;
            BaseListResponse r67 = (BaseListResponse) r16;
            Type r68 = r12.b;
            if (r68 == null) goto L171;
            Class r69 = (Class) r68;
            Type r70 = r13.b;
            if (r70 == null) goto L169;
            Class r71 = (Class) r70;
            ho0.a r72 = r14.header;
            int r73 = r72.a;
            r67.statusCode = r73;
            if (r73 != 0) goto L137;
            boolean r125 = true;
        L138:
            if (r125 == false) goto L167;
            ArrayList r74 = new ArrayList();
            if (r3 == null) goto L160;
            long r75 = r3.c();
        L142:
            int r126 = r3.f();
            if (r126 == (-1)) goto L144;
            if (r126 != 1) goto L148;
            String r127 = r118;
            r74.add(MultiTypeRequestConverterFactory.b(r10, r69).decode(r3));
        L156:
            boolean r128 = true;
        L157:
            if (r128 == true) goto L159;
            h.e(r3);
        L159:
            r118 = r127;
            goto L142
        L148:
            if (r126 == 2) goto L150;
            r127 = r118;
            r128 = false;
            goto L157
        L150:
            Object r129 = MultiTypeRequestConverterFactory.b(r10, r71).decode(r3);
            if (r129 == null) goto L154;
            R r130 = (R) r129;
            ((Extra) r130).now = r72.e;
            r67.extra = r130;
            r127 = r118;
            goto L156
        L154:
            throw new NullPointerException(r118);
        L144:
            r3.d(r75);
        L160:
            String r131 = r118;
            r67.data = r74;
            if (r67.extra != 0) goto L174;
            Object r76 = r71.newInstance();
            if (r76 == null) goto L166;
            R r77 = (R) r76;
            ((Extra) r77).now = r72.e;
            r67.extra = r77;
            goto L174
        L166:
            throw new NullPointerException(r131);
        L167:
            RequestError r78 = new RequestError();
            MultiTypeRequestConverterFactory.d(r78, r72);
            r67.error = r78;
            r67.extra = MultiTypeRequestConverterFactory.c(r72, r71);
            goto L174
        L137:
            r125 = false;
            goto L138
        L169:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        L171:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        L173:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.network.response.BaseListResponse<*, *>");
        L17:
            r9 = false;
            goto L18
        L8:
            r8 = ((GET) r7).value();
            goto L15
        L13:
            r8 = "";
            goto L15
        L212:
            Converter<TypedInput, ?> r79 = this.h.invoke();
            if (r79 != null) goto L215;
            return null;
        L215:
            return r79.convert(r0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.network.impl.factory.MultiTypeRequestConverterFactory$responseBodyConverter$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"fallbackToGson", "Lcom/bytedance/retrofit2/Converter;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Converter<TypedInput, ?>> {
        final /* synthetic */ Annotation[] $annotations;
        final /* synthetic */ Retrofit $retrofit;
        final /* synthetic */ Type $type;
        final /* synthetic */ MultiTypeRequestConverterFactory this$0;

        public AnonymousClass1(MultiTypeRequestConverterFactory r1, Type r2, Annotation[] r3, Retrofit r4) {
            this.this$0 = r1;
            this.$type = r2;
            this.$annotations = r3;
            this.$retrofit = r4;
            super(0);
        }

        public final Converter<TypedInput, ?> invoke() {
            return this.this$0.b.responseBodyConverter(this.$type, this.$annotations, this.$retrofit);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m603invoke() {
            return invoke();
        }
    }

    public MultiTypeRequestConverterFactory(rx5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "gsonConverterFactory");
        this.b = r2;
        this.a = new ThreadLocal();
    }

    public final g e(TypedInput r5) {
        g r0 = this.a.get();
        if (r0 != null) goto L5;
        r0 = new g();
        this.a.set(r0);
    L5:
        r0.k(new am3.d(r5.in(), 0, (int) r5.length()));
        return r0;
    }

    public static final Object a(MultiTypeRequestConverterFactory r0, Class r1) {
        r0.getClass();
        if (Intrinsics.areEqual(r1, Unit.class) == false) goto L6;
        return Unit.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r1, Object.class) == false) goto L9;
        return new Object();
    L9:
        return r1.newInstance();
    }

    public static final am3.c b(MultiTypeRequestConverterFactory r1, Class r2) {
        r1.getClass();
        if (Intrinsics.areEqual(r2, Object.class) == false) goto L6;
        return new a(r1, Object.class);
    L6:
        if (Intrinsics.areEqual(r2, Unit.class) == false) goto L9;
        return new a(r1, Unit.class);
    L9:
        if (Intrinsics.areEqual(r2, com.bytedance.android.live.base.model.h.class) == false) goto L12;
        return new b();
    L12:
        if (Intrinsics.areEqual(r2, i.class) == false) goto L15;
        return new c();
    L15:
        return ((INetworkService) k.n(INetworkService.class)).getProtoDecoder(r2);
    }

    public static Extra c(ho0.a r3, Class r4) {
        String r0 = r3.f;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L16;
        Object r5 = r4.newInstance();
        if (r5 == null) goto L15;
        Extra r6 = (Extra) r5;
    L21:
        r6.now = r3.e;
        return r6;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.Extra");
    L16:
        Object r2 = GsonProtectorUtils.fromJson(NetworkGson.a(), r3.f, r4);
        if (r2 != null) goto L19;
        r2 = r4.newInstance();
    L19:
        if (r2 == null) goto L24;
        r6 = (Extra) r2;
        goto L21
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.Extra");
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static void d(RequestError r1, ho0.a r2) {
        r1.message = r2.b;
        r1.prompts = r2.c;
        r1.alert = r2.d;
    }

    public static e f(Type r11, Set r12, int r13) {
        boolean r0 = r11 instanceof ParameterizedType;
        Type r3 = null;
        if (r0 == false) goto L5;
        ParameterizedType r5 = (ParameterizedType) r11;
        if (CollectionsKt.contains(r12, r5.getRawType()) == false) goto L29;
        Type r14 = r5.getRawType();
        if (r14 == null) goto L28;
        return new e((Class) r14, r5.getActualTypeArguments()[r13], r13, true);
    L28:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L29:
        boolean r4 = r11 instanceof Class;
        if (r4 == false) goto L32;
        Type r8 = ((Class) r11).getGenericSuperclass();
    L40:
        if (r8 == null) goto L110;
        boolean r9 = r8 instanceof ParameterizedType;
        if (r9 == false) goto L44;
        ParameterizedType r10 = (ParameterizedType) r8;
        Type r15 = r10.getRawType();
        if (r15 == null) goto L108;
        Class r16 = (Class) r15;
        if (r12.contains(r16) == false) goto L65;
        int r17 = r13;
    L79:
        Type r18 = r10.getActualTypeArguments()[r17];
        int r1 = -1;
        if ((r18 instanceof TypeVariable) == false) goto L98;
        Type r19 = r5.getRawType();
        if (r19 == null) goto L96;
        TypeVariable[] r110 = ((Class) r19).getTypeParameters();
        int r111 = r110.length;
        int r2 = 0;
    L84:
        if (r2 >= r111) goto L89;
        if (Intrinsics.areEqual(r110[r2].getName(), ((TypeVariable) r18).getName()) == true) goto L87;
        r2 = r2 + 1;
        goto L84
    L87:
        r1 = r2;
    L89:
        boolean r112 = !(r5.getActualTypeArguments()[r1] instanceof TypeVariable);
        if (r112 == false) goto L92;
        Type r113 = r5.getActualTypeArguments()[r1];
    L94:
        return new e(r16, r113, r1, r112);
    L92:
        r113 = e.e;
        goto L94
    L96:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L98:
        if ((r18 instanceof Class) == false) goto L102;
        return new e(r16, r18, -1, true);
    L102:
        throw new IllegalStateException((r13 + " of type args of genericSuperClass of " + r11 + " must be class or type variable").toString());
    L65:
        if (r4 == false) goto L67;
        r3 = ((Class) r11).getGenericSuperclass();
    L74:
        if (r3 == null) goto L104;
        e r114 = f(r3, r12, r13);
        if (r114.d == false) goto L78;
        return r114;
    L78:
        r17 = r114.c;
        goto L79
    L104:
        throw new IllegalStateException(("super class of " + r11 + " must not be null").toString());
    L67:
        if (r0 == false) goto L106;
        Type r6 = r5.getRawType();
        if ((r6 instanceof Class) == true) goto L71;
        r6 = null;
    L71:
        Class r7 = (Class) r6;
        if (r7 == null) goto L74;
        r3 = r7.getGenericSuperclass();
        goto L74
    L106:
        throw new IllegalStateException(("Unable to get generic super class for " + r11.getClass()).toString());
    L108:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L44:
        if ((r8 instanceof Class) == false) goto L46;
        r3 = ((Class) r8).getGenericSuperclass();
    L53:
        if (r3 == null) goto L57;
        return f(r3, r12, r13);
    L57:
        throw new IllegalStateException(("failed to get super class of " + r8).toString());
    L46:
        if (r9 == false) goto L59;
        Type r115 = ((ParameterizedType) r8).getRawType();
        if ((r115 instanceof Class) == true) goto L50;
        r115 = null;
    L50:
        Class r116 = (Class) r115;
        if (r116 == null) goto L53;
        r3 = r116.getGenericSuperclass();
        goto L53
    L59:
        throw new IllegalStateException(("Unable to get generic super class for " + r8.getClass()).toString());
    L110:
        throw new IllegalStateException(("failed to get genericSuperclass for " + r11).toString());
    L32:
        if (r0 == false) goto L112;
        Type r20 = r5.getRawType();
        if ((r20 instanceof Class) == true) goto L36;
        r20 = null;
    L36:
        Class r21 = (Class) r20;
        if (r21 == null) goto L39;
        r8 = r21.getGenericSuperclass();
        goto L40
    L39:
        r8 = null;
        goto L40
    L112:
        throw new IllegalStateException(("Unable to get generic super class for " + r11.getClass()).toString());
    L5:
        if ((r11 instanceof Class) == false) goto L7;
        r3 = ((Class) r11).getGenericSuperclass();
    L14:
        if (r3 == null) goto L18;
        return f(r3, r12, r13);
    L18:
        throw new IllegalStateException(("genericSuperclass of " + r11 + " must not be null").toString());
    L7:
        if (r0 == false) goto L20;
        Type r22 = ((ParameterizedType) r11).getRawType();
        if ((r22 instanceof Class) == true) goto L11;
        r22 = null;
    L11:
        Class r23 = (Class) r22;
        if (r23 == null) goto L14;
        r3 = r23.getGenericSuperclass();
        goto L14
    L20:
        throw new IllegalStateException(("Unable to get generic super class for " + r11.getClass()).toString());
    }

    public final Converter<?, Header> headerConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.b.headerConverter(r2, r3, r4);
    }

    public final Converter<?, Object> objectConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.b.objectConverter(r2, r3, r4);
    }

    public final Converter<TypedInput, ?> responseBodyConverter(Type r12, Annotation[] r13, Retrofit r14) {
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "annotations");
        Intrinsics.checkNotNullParameter(r14, "retrofit");
        final AnonymousClass1 r9 = new AnonymousClass1(this, r12, r13, r14);
        if (Intrinsics.areEqual(r12, com.bytedance.android.live.network.response.a.class) == false) goto L7;
        return new d(this, com.bytedance.android.live.network.response.a.class, null, com.bytedance.android.live.network.response.a.class, Unit.class, Extra.class, new AnonymousClass2(r9));
    L7:
        if ((r12 instanceof ParameterizedType) == false) goto L9;
        ParameterizedType r3 = (ParameterizedType) r12;
        Type r1 = r3.getRawType();
        if (r1 == null) goto L151;
        boolean r4 = false;
        Type r6 = null;
        if (ExtraResponse.class.isAssignableFrom((Class) r1) == false) goto L152;
        Function1<TypedInput, Object> r8 = new AnonymousClass3(r9);
        Type r15 = r3.getRawType();
        if (r15 == null) goto L89;
        Class r16 = (Class) r15;
        if (CollectionsKt.contains(SetsKt.setOf(new Class[]{com.bytedance.android.live.network.response.e.class, ExtraResponse.class}), r16) == false) goto L87;
        if (com.bytedance.android.live.network.response.e.class.isAssignableFrom(r16) == false) goto L21;
        e r17 = f(r3, SetsKt.setOf(com.bytedance.android.live.network.response.e.class), 0);
        r17.a();
        Pair r18 = new Pair(r17.b, Extra.class);
    L22:
        Type r19 = (Type) r18.component1();
        Type r110 = (Type) r18.component2();
        boolean r0 = r110 instanceof Class;
        if (r0 == true) goto L25;
    L27:
        if (r4 == false) goto L85;
        if (r0 == false) goto L32;
        Class r2 = (Class) r110;
    L37:
        if ((!Collection.class.isAssignableFrom(r2)) == false) goto L79;
        MultiTypeRequestConverterFactory$handleCustomResponse$4 r5 = MultiTypeRequestConverterFactory$handleCustomResponse$4.INSTANCE;
        boolean r7 = r19 instanceof Class;
        if (r7 == false) goto L42;
        Class r10 = (Class) r19;
    L47:
        if (Intrinsics.areEqual(r10, List.class) == false) goto L54;
        if ((r19 instanceof ParameterizedType) == false) goto L52;
        Pair r11 = new Pair(MultiTypeRequestConverterFactory$handleCustomResponse$6.INSTANCE, r5.invoke((ParameterizedType) r19));
    L71:
        return new d(this, r3, (Function0) r11.component1(), r16, (Class) r11.component2(), (Class) r110, r8);
    L52:
        throw new IllegalStateException(("Type [" + r19 + "] must have one type argument.").toString());
    L54:
        if (Intrinsics.areEqual(r10, Set.class) == false) goto L61;
        if ((r19 instanceof ParameterizedType) == false) goto L59;
        r11 = new Pair(MultiTypeRequestConverterFactory$handleCustomResponse$8.INSTANCE, r5.invoke((ParameterizedType) r19));
        goto L71
    L59:
        throw new IllegalStateException(("Type [" + r19 + "] must have one type argument.").toString());
    L61:
        if (r10.isInterface() == false) goto L65;
        if (vh7.c.class.isAssignableFrom(r10) == true) goto L65;
    L73:
        throw new IllegalStateException(("Unsupported data type: " + r19).toString());
    L65:
        if (Collection.class.isAssignableFrom(r10) == true) goto L73;
        if (Map.class.isAssignableFrom(r10) == true) goto L73;
        if (r7 == false) goto L73;
        r11 = new Pair(null, r19);
        goto L71
    L42:
        if ((r19 instanceof ParameterizedType) == false) goto L77;
        Type r20 = ((ParameterizedType) r19).getRawType();
        if (r20 == null) goto L75;
        r10 = (Class) r20;
        goto L47
    L75:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L77:
        throw new IllegalStateException(("Unable to get classType for " + r19.getClass()).toString());
    L79:
        throw new IllegalStateException(("Extra must not be collection: " + r3).toString());
    L32:
        if ((r110 instanceof ParameterizedType) == false) goto L83;
        Type r21 = ((ParameterizedType) r110).getRawType();
        if (r21 == null) goto L81;
        r2 = (Class) r21;
        goto L37
    L81:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L83:
        throw new IllegalStateException(("Unable to get classType for " + r110.getClass()).toString());
    L85:
        throw new IllegalStateException(("Unsupported extra type: [" + r110 + ']').toString());
    L25:
        if (Extra.class.isAssignableFrom((Class) r110) == false) goto L27;
        r4 = true;
        goto L27
    L21:
        e r111 = f(r3, SetsKt.setOf(ExtraResponse.class), 0);
        r111.a();
        Type r112 = r111.b;
        e r22 = f(r3, SetsKt.setOf(ExtraResponse.class), 1);
        r22.a();
        r18 = new Pair(r112, r22.b);
        goto L22
    L87:
        throw new IllegalStateException(("Response type [" + r16 + "] is not supported").toString());
    L89:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L152:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L131
        Set r24 = SetsKt.setOf(new Class[]{BaseResponse.class, BaseListResponse.class});     // Catch: Throwable -> L131
        Set r25 = SetsKt.setOf(new Class[]{Response.class, ListResponse.class});     // Catch: Throwable -> L131
        if (CollectionsKt.contains(r25, r3.getRawType()) == false) goto L106;
        Type r26 = r3.getRawType();     // Catch: Throwable -> L131
        if (r26 == null) goto L104;
        Class r27 = (Class) r26;     // Catch: Throwable -> L131
        Type r28 = r3.getActualTypeArguments()[0];     // Catch: Throwable -> L131
        if (r28 == null) goto L102;
        e r29 = new e(r27, (Class) r28, -1, true);     // Catch: Throwable -> L131
        Type r30 = r3.getRawType();     // Catch: Throwable -> L131
        if (r30 == null) goto L100;
        Pair r31 = new Pair(r29, new e((Class) r30, Extra.class, -1, true));     // Catch: Throwable -> L131
    L129:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L131
    L134:
        if (Result.isFailure-impl(r32) == false) goto L136;
        r32 = null;
    L136:
        Pair r33 = (Pair) r32;
        if (r33 == null) goto L139;
        e r34 = (e) r33.component1();
        e r35 = (e) r33.component2();
        Type r36 = r3.getRawType();
        if ((r36 instanceof Class) == false) goto L144;
        r6 = r36;
    L144:
        Class r37 = (Class) r6;
        if (r37 != null) goto L149;
        return r9.invoke();
    L149:
        return new f(this, r13, r37, r34, r35, r12, r14, r9);
    L139:
        return r9.invoke();
    L100:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L102:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L104:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L106:
        if (CollectionsKt.contains(r24, r3.getRawType()) == false) goto L124;
        Type r38 = r3.getRawType();     // Catch: Throwable -> L131
        if (r38 == null) goto L123;
        Class r39 = (Class) r38;     // Catch: Throwable -> L131
        Type r40 = r3.getActualTypeArguments()[0];     // Catch: Throwable -> L131
        if (r40 == null) goto L121;
        e r41 = new e(r39, (Class) r40, -1, true);     // Catch: Throwable -> L131
        Type r42 = r3.getRawType();     // Catch: Throwable -> L131
        if (r42 == null) goto L119;
        Class r43 = (Class) r42;     // Catch: Throwable -> L131
        Type r113 = r3.getActualTypeArguments()[1];     // Catch: Throwable -> L131
        if (r113 == null) goto L117;
        r31 = new Pair(r41, new e(r43, (Class) r113, -1, true));     // Catch: Throwable -> L131
        goto L129
    L117:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L119:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L121:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L123:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L131
    L124:
        e r44 = f(r3, SetsKt.plus(r24, r25), 0);     // Catch: Throwable -> L131
        r44.a();     // Catch: Throwable -> L131
        if (r24.contains(r44.a) == false) goto L127;
        e r45 = f(r3, SetsKt.plus(r24, r25), 1);     // Catch: Throwable -> L131
        r45.a();     // Catch: Throwable -> L131
    L128:
        r31 = new Pair(r44, r45);     // Catch: Throwable -> L131
        goto L129
    L127:
        r45 = new e(r44.a, Extra.class, -1, true);     // Catch: Throwable -> L131
    L131:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L134
    L151:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L9:
        return r9.invoke();
    }

    public final Converter<?, String> stringConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.b.stringConverter(r2, r3, r4);
    }

    public final Converter<?, TypedOutput> requestBodyConverter(Type r2, Annotation[] r3, Annotation[] r4, Retrofit r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(r4, "methodAnnotations");
        Intrinsics.checkNotNullParameter(r5, "retrofit");
        return this.b.requestBodyConverter(r2, r3, r4, r5);
    }
}
