package j01;

import com.bytedance.android.live.revenue.platform.trace.api.MonitorRequestSerializableObjectImpl;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(MonitorRequestSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lj01/c;", "Lvh7/j;", "a", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.foundation.MonitorRequest")
public interface c extends j<c> {
    public static final a g = null;

    public static final class a implements uh7.c.b<c> {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        public final void a() {
        }

        static {
            a = new a();
        }

        public final boolean b(KClass<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), r2);
        }

        public final JsonObject e(Object r4, uh7.c.a r5) {
            c r6 = (c) r4;
            Intrinsics.checkNotNullParameter(r6, "obj");
            Intrinsics.checkNotNullParameter(r5, "context");
            JsonObject r0 = new JsonObject();
            j01.a.InterfaceC0254a r1 = r6.getMeta();
            if (r1 == null) goto L5;
            r0.add("meta", r5.b(r1));
        L5:
            JsonOrBytesJvm r2 = r6.getCategory();
            if (r2 == null) goto L8;
            r0.add("category", r5.b(r2));
        L8:
            JsonOrBytesJvm r3 = r6.y6();
            if (r3 == null) goto L11;
            r0.add("metric", r5.b(r3));
        L11:
            JsonOrBytesJvm r7 = r6.getExtra();
            if (r7 == null) goto L14;
            r0.add("extra", r5.b(r7));
        L14:
            return r0;
        }

        public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r4, Object r5, uh7.c.a r6) {
            c r7 = (c) r5;
            Intrinsics.checkNotNullParameter(r4, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r7, "obj");
            Intrinsics.checkNotNullParameter(r6, "context");
            j01.a.InterfaceC0254a r0 = r7.getMeta();
            if (r0 == null) goto L9;
            com.bytedance.tools.kcp.modelx.runtime.protobuf.b r1 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(r4.b);
            r6.c(r1, r0);
            MessagePayload r8 = r1.a(1);
            if (r4.b == true) goto L7;
        L8:
            ((ArrayList) r4.a).add(r8);
            goto L9
        L7:
            if (r8.d() == true) goto L8;
        L9:
            JsonOrBytesJvm r9 = r7.getCategory();
            JsonOrBytesJvm r2 = null;
            if (r9 != null) goto L12;
        L17:
            JsonOrBytesJvm r10 = r7.y6();
            if (r10 != null) goto L20;
        L25:
            JsonOrBytesJvm r12 = r7.getExtra();
            if (r12 != null) goto L28;
            return;
        L28:
            if (r12.a() == false) goto L30;
            r2 = r12;
        L30:
            if (r2 == null) goto L34;
            r4.d(r2.b().toString(), 4);
            return;
        L34:
            return;
        L20:
            if (r10.a() == true) goto L23;
            r10 = null;
        L23:
            if (r10 == null) goto L25;
            r4.d(r10.b().toString(), 3);
            goto L25
        L12:
            if (r9.a() == true) goto L15;
            r9 = null;
        L15:
            if (r9 == null) goto L17;
            r4.d(r9.b().toString(), 2);
            goto L17
        }

        public final Object d(KClass r4, JsonObject r5, uh7.c.a r6) {
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "jsonObject");
            Intrinsics.checkNotNullParameter(r6, "context");
            Class r7 = c.class.getAnnotation(JsonAdapter.class).value();
            ConcurrentHashMap r0 = vh7.b.a;
            Object r1 = r0.get(r7);
            if (r1 != null) goto L12;
            r1 = r7.getConstructor(new Class[0]);
            if (r1 == null) goto L11;
            Object r8 = r0.putIfAbsent(r7, r1);
            if (r8 == null) goto L12;
            r1 = r8;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r9 = ((SerializableObjectJsonAdapterBase) ((Constructor) r1).newInstance(new Object[0])).createInstance();
            if (r9 == null) goto L28;
            c r10 = (c) r9;
            JsonElement r2 = r5.get("meta");
            if (r2 == null) goto L17;
            r10.i4((j01.a.InterfaceC0254a) r6.a(r2.getAsJsonObject(), Reflection.getOrCreateKotlinClass(j01.a.InterfaceC0254a.class)));
        L17:
            JsonElement r12 = r5.get("category");
            if (r12 == null) goto L20;
            r10.f1(new JsonOrBytesJvm(r12));
        L20:
            JsonElement r13 = r5.get("metric");
            if (r13 == null) goto L23;
            r10.D3(new JsonOrBytesJvm(r13));
        L23:
            JsonElement r14 = r5.get("extra");
            if (r14 == null) goto L26;
            r10.W0(new JsonOrBytesJvm(r14));
        L26:
            return r10;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.trace.api.MonitorRequest");
        }
    }

    @JsonAdapter(MonitorRequestSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        g = a.a;
    }

    @FieldName(name = "metric#setter")
    void D3(JsonOrBytesJvm r1);

    @FieldName(name = "extra#setter")
    void W0(JsonOrBytesJvm r1);

    @FieldName(name = "category#setter")
    void f1(JsonOrBytesJvm r1);

    @FieldName(name = "category")
    JsonOrBytesJvm getCategory();

    @FieldName(name = "extra")
    JsonOrBytesJvm getExtra();

    @FieldName(name = "meta")
    j01.a.InterfaceC0254a getMeta();

    @FieldName(name = "meta#setter")
    void i4(j01.a.InterfaceC0254a r1);

    @FieldName(name = "metric")
    JsonOrBytesJvm y6();
}
