package com.bytedance.android.live.revenue.platform.network.api;

import android.util.Base64;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.h;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.NetworkService")
public interface IDynamicHostNetworkService extends uh7.a, dy0.d {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$ContentType;", "", "JSON", "PROTOBUF", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ContentType extends Enum<ContentType> {
        public static final ContentType JSON = null;
        public static final ContentType PROTOBUF = null;
        public static final /* synthetic */ ContentType[] a = null;

        static {
            ContentType r1 = new ContentType("JSON", 0);
            JSON = r1;
            ContentType r2 = new ContentType("PROTOBUF", 1);
            PROTOBUF = r2;
            a = new ContentType[]{r1, r2};
        }

        public static ContentType valueOf(String r1) {
            return (ContentType) r27.a.a(ContentType.class, r1);
        }

        public static ContentType[] values() {
            return (ContentType[]) a.clone();
        }

        public ContentType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(IDynamicHostNetworkService_FormPostBodySerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$a;", "Lvh7/j;", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpRequest.FormPostRequestBody")
    public interface a extends j<a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService$a$a, reason: collision with other inner class name */
        @JsonAdapter(IDynamicHostNetworkService_FormPostBodySerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C0097a {
        }

        @FieldName(name = "content")
        Map<String, String> getContent();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0015\u000eB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b;", "", "", "statusCode", "I", "c", "()I", "f", "(I)V", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "headers", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "e", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", "body", "Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", "a", "()Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", "d", "(Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpResponse")
    public static final class b {
        public static final C0099b a = null;

        @SerializedName("body")
        private a body;

        @SerializedName("headers")
        private Map<String, String> headers;

        @SerializedName("status_code")
        private int statusCode;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", "", "", "contentType", "I", "b", "()I", "d", "(I)V", "content", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "c", "(Ljava/lang/Object;)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
        @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpResponse.Body")
        public static final class a {
            public static final C0098a a = null;

            @SerializedName("content")
            private Object content;

            @SerializedName("content_type")
            private int contentType;

            /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService$b$a$a, reason: collision with other inner class name */
            public static final class C0098a implements uh7.c.b<a> {
                public C0098a() {
                }

                public final void a() {
                    C0098a r0 = a.a;
                }

                public final boolean b(KClass<?> r2) {
                    Intrinsics.checkNotNullParameter(r2, "type");
                    return Intrinsics.areEqual(r2, Reflection.getOrCreateKotlinClass(a.class));
                }

                public final JsonObject e(Object r3, uh7.c.a r4) {
                    a r5 = (a) r3;
                    Intrinsics.checkNotNullParameter(r5, "obj");
                    Intrinsics.checkNotNullParameter(r4, "context");
                    JsonObject r6 = new JsonObject();
                    r6.addProperty("content_type", Integer.valueOf(r5.b()));
                    Object r7 = r5.a();
                    if (r7 != null) goto L6;
                L11:
                    return r6;
                L6:
                    if ((r7 instanceof byte[]) == false) goto L9;
                    int r0 = com.bytedance.revenue.platform.api.core.a.a;
                    byte[] r8 = (byte[]) r7;
                    Intrinsics.checkNotNullParameter(r8, "input");
                    r6.addProperty("content", Base64.encodeToString(r8, 2));
                    goto L11
                L9:
                    if ((r7 instanceof JsonElement) == false) goto L13;
                    r6.add("content", (JsonElement) r7);
                    goto L11
                L13:
                    throw new IllegalStateException(("unknown type of content: " + r7).toString());
                }

                public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r3, Object r4, uh7.c.a r5) {
                    a r6 = (a) r4;
                    Intrinsics.checkNotNullParameter(r3, "$this$writeProtobuf");
                    Intrinsics.checkNotNullParameter(r6, "obj");
                    Intrinsics.checkNotNullParameter(r5, "context");
                    com.bytedance.tools.kcp.modelx.runtime.protobuf.b r7 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(r3.b);
                    r7.c(r6.b(), 1);
                    Object r8 = r6.a();
                    if (r8 != null) goto L6;
                L11:
                    MessagePayload r9 = r7.a(4);
                    if (r3.b == true) goto L14;
                L15:
                    ((ArrayList) r3.a).add(r9);
                    return;
                L14:
                    if (r9.d() == true) goto L15;
                    return;
                L6:
                    if ((r8 instanceof byte[]) == false) goto L9;
                    r7.b((byte[]) r8, 2);
                    goto L11
                L9:
                    if ((r8 instanceof JsonElement) == false) goto L18;
                    r7.d(r8.toString(), 2);
                    goto L11
                L18:
                    throw new IllegalStateException(("unknown type of content: " + r8).toString());
                }

                public final Object d(KClass r2, JsonObject r3, uh7.c.a r4) {
                    Intrinsics.checkNotNullParameter(r2, "type");
                    Intrinsics.checkNotNullParameter(r3, "jsonObject");
                    Intrinsics.checkNotNullParameter(r4, "context");
                    a r5 = new a();
                    JsonElement r6 = r3.get("content_type");
                    if (r6 == null) goto L5;
                    r5.d(r6.getAsInt());
                L5:
                    JsonElement r7 = r3.get("content");
                    if (r7 == null) goto L16;
                    int r8 = r5.b();
                    if (r8 != ContentType.JSON.ordinal()) goto L11;
                    Object r9 = GsonProtectorUtils.parse(new JsonParser(), r7.getAsString()).getAsJsonObject();
                L13:
                    r5.c(r9);
                    goto L16
                L11:
                    if (r8 != ContentType.PROTOBUF.ordinal()) goto L15;
                    int r10 = com.bytedance.revenue.platform.api.core.a.a;
                    r9 = com.bytedance.revenue.platform.api.core.a.a(r7.getAsString());
                    goto L13
                L15:
                    throw new IllegalStateException(("Unknown content type " + r5.b()).toString());
                L16:
                    return r5;
                }
            }

            static {
                a = new C0098a();
            }

            public a() {
                this.contentType = ContentType.JSON.ordinal();
            }

            public final Object a() {
                return this.content;
            }

            public final int b() {
                return this.contentType;
            }

            public final void c(Object r1) {
                this.content = r1;
            }

            public final void d(int r1) {
                this.contentType = r1;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService$b$b, reason: collision with other inner class name */
        public static final class C0099b implements uh7.c.b<b> {
            public C0099b() {
            }

            public final void a() {
                C0099b r0 = b.a;
            }

            public final boolean b(KClass<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "type");
                return Intrinsics.areEqual(r2, Reflection.getOrCreateKotlinClass(b.class));
            }

            public final JsonObject e(Object r4, uh7.c.a r5) {
                b r6 = (b) r4;
                Intrinsics.checkNotNullParameter(r6, "obj");
                Intrinsics.checkNotNullParameter(r5, "context");
                JsonObject r0 = new JsonObject();
                r0.addProperty("status_code", Integer.valueOf(r6.c()));
                Map<String, String> r1 = r6.b();
                r0.add(Constants.Keys.HEADER, GsonProtectorUtils.toJsonTree(l97.a.a, r1));
                a r7 = r6.a();
                if (r7 == null) goto L5;
                r0.add("body", r5.b(r7));
            L5:
                return r0;
            }

            public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r10, Object r12, uh7.c.a r13) {
                b r14 = (b) r12;
                Intrinsics.checkNotNullParameter(r10, "$this$writeProtobuf");
                Intrinsics.checkNotNullParameter(r14, "obj");
                Intrinsics.checkNotNullParameter(r13, "context");
                r10.c(r14.c(), 1);
                Iterator<Map.Entry<String, String>> r0 = r14.b().entrySet().iterator();
            L4:
                if (r0.hasNext() == false) goto L25;
                Map.Entry<String, String> r2 = r0.next();
                boolean r3 = r10.b;
                ArrayList r4 = new ArrayList();
                String r5 = r2.getKey();
                Intrinsics.checkNotNullParameter(r5, "value");
                boolean r7 = false;
                if (r3 == true) goto L8;
            L12:
                r4.add(new h(1, r5));
            L13:
                String r6 = r2.getValue();
                Intrinsics.checkNotNullParameter(r6, "value");
                if (r3 == true) goto L16;
            L19:
                r4.add(new h(2, r6));
            L20:
                MessagePayload r8 = new MessagePayload(2, r4);
                if (r10.b == false) goto L24;
                if (r8.d() == false) goto L4;
            L24:
                ((ArrayList) r10.a).add(r8);
                goto L4
            L16:
                if (r6.length() <= 0) goto L18;
                r7 = true;
            L18:
                if (r7 == false) goto L20;
            L8:
                if (r5.length() <= 0) goto L10;
                boolean r9 = true;
            L11:
                if (r9 == false) goto L13;
            L10:
                r9 = false;
                goto L11
            L25:
                a r15 = r14.a();
                if (r15 == null) goto L35;
                r13.c(r10, r15);
                return;
            }

            public final Object d(KClass r6, JsonObject r7, uh7.c.a r8) {
                Intrinsics.checkNotNullParameter(r6, "type");
                Intrinsics.checkNotNullParameter(r7, "jsonObject");
                Intrinsics.checkNotNullParameter(r8, "context");
                b r9 = new b();
                JsonElement r0 = r7.get("zd");
                if (r0 == null) goto L5;
                r9.f(r0.getAsInt());
            L5:
                JsonElement r1 = r7.get("headers");
                if (r1 == null) goto L13;
                JsonObject r2 = r1.getAsJsonObject();
                if (r2 == null) goto L13;
                Iterator r3 = r2.keySet().iterator();
            L11:
                if (r3.hasNext() == false) goto L13;
                String r4 = (String) r3.next();
                Map<String, String> r5 = r9.b();
                JsonElement r10 = r2.get(r4);
                Intrinsics.checkNotNull(r10);
                r5.put(r4, r10.getAsString());
            L13:
                JsonElement r12 = r7.get("body");
                if (r12 == null) goto L20;
                JsonObject r13 = r12.getAsJsonObject();
                if (r13 == null) goto L20;
                a r14 = (a) r8.a(r13, Reflection.getOrCreateKotlinClass(a.class));
                if (r14 == null) goto L20;
                r9.d(r14);
            L20:
                return r9;
            }
        }

        static {
            a = new C0099b();
        }

        public b() {
            this.statusCode = 200;
            this.headers = new LinkedHashMap();
        }

        public final a a() {
            return this.body;
        }

        public final Map<String, String> b() {
            return this.headers;
        }

        public final int c() {
            return this.statusCode;
        }

        public final void d(a r1) {
            this.body = r1;
        }

        public final void e(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.headers = r2;
        }

        public final void f(int r1) {
            this.statusCode = r1;
        }
    }

    @JsonAdapter(IDynamicHostNetworkService_JsonPostBodySerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$c;", "Lvh7/j;", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpRequest.JsonPostRequestBody")
    public interface c extends j<c> {

        @JsonAdapter(IDynamicHostNetworkService_JsonPostBodySerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = "content")
        String getContent();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$d;", "", Constants.Keys.DATA, "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "b", "(Ljava/lang/Object;)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.RegisterMessageResponse")
    public static final class d {
        public static final a a = null;

        @SerializedName(Constants.Keys.DATA)
        private Object data;

        public static final class a implements uh7.c.b<d> {
            public a() {
            }

            public final void a() {
                a r0 = d.a;
            }

            public final boolean b(KClass<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "type");
                return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), r2);
            }

            public final JsonObject e(Object r2, uh7.c.a r3) {
                d r4 = (d) r2;
                Intrinsics.checkNotNullParameter(r4, "obj");
                Intrinsics.checkNotNullParameter(r3, "context");
                JsonObject r5 = new JsonObject();
                Object r6 = r4.a();
                if (r6 == null) goto L5;
                int r0 = com.bytedance.revenue.platform.api.core.a.a;
                byte[] r7 = (byte[]) r6;
                Intrinsics.checkNotNullParameter(r7, "input");
                r5.addProperty(Constants.Keys.DATA, Base64.encodeToString(r7, 2));
            L5:
                return r5;
            }

            public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r2, Object r3, uh7.c.a r4) {
                d r5 = (d) r3;
                Intrinsics.checkNotNullParameter(r2, "$this$writeProtobuf");
                Intrinsics.checkNotNullParameter(r5, "obj");
                Intrinsics.checkNotNullParameter(r4, "context");
                Object r6 = r5.a();
                if (r6 == null) goto L6;
                r2.b((byte[]) r6, 1);
                return;
            }

            public final Object d(KClass r2, JsonObject r3, uh7.c.a r4) {
                Intrinsics.checkNotNullParameter(r2, "type");
                Intrinsics.checkNotNullParameter(r3, "jsonObject");
                Intrinsics.checkNotNullParameter(r4, "context");
                d r5 = new d();
                JsonElement r6 = r3.get(Constants.Keys.DATA);
                if (r6 != null) goto L5;
            L13:
                return r5;
            L5:
                if (r6.isJsonObject() == false) goto L8;
                Object r7 = r6.getAsJsonObject();
            L10:
                r5.b(r7);
                goto L13
            L8:
                if (r6.isJsonPrimitive() == false) goto L12;
                int r8 = com.bytedance.revenue.platform.api.core.a.a;
                r7 = com.bytedance.revenue.platform.api.core.a.a(r6.getAsString());
                goto L10
            L12:
                throw new IllegalStateException(("unknown data type: " + r6).toString());
            }
        }

        static {
            a = new a();
        }

        public d() {
        }

        public final Object a() {
            return this.data;
        }

        public final void b(Object r1) {
            this.data = r1;
        }
    }

    @BindsRpc(rpcName = "RegisterMessage")
    Observable<d> registerMessage(i57.a r1, @RpcParam(paramName = "method") String r2, @RpcParam(paramName = "wrds") Boolean r3, @RpcParam(paramName = "wrds_subkey") String r4, @RpcParam(paramName = "message_type") Integer r5);

    @BindsRpc(rpcName = "SendHttp")
    Single<b> requestHttp(@RpcParam(paramName = "path") String r1, @RpcParam(paramName = "method") String r2, @RpcParam(paramName = "queries") Map<String, String> r3, @RpcParam(paramName = "headers") Map<String, String> r4, @RpcParam(paramName = "preferred_response_body_content_type") int r5, @RpcParam(paramName = "json_body") c r6, @RpcParam(paramName = "form_body") a r7);
}
