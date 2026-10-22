package lz0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Llz0/b;", "", "", "interfaceId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "params", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "d", "(Ljava/lang/Object;)V", "<init>", "()V", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "core.service.LazyLoadRequest")
public final class b {
    public static final a a = null;

    @SerializedName("interface_id")
    private String interfaceId;

    @SerializedName("params")
    private Object params;

    public static final class a implements uh7.c.b<b> {
        public a() {
        }

        public final void a() {
            a r0 = b.a;
        }

        public final boolean b(KClass<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), r2);
        }

        public final JsonObject e(Object r2, uh7.c.a r3) {
            b r4 = (b) r2;
            Intrinsics.checkNotNullParameter(r4, "obj");
            Intrinsics.checkNotNullParameter(r3, "context");
            return uh7.c.b.a.a(r4, r3);
        }

        public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r2, Object r3, uh7.c.a r4) {
            b r5 = (b) r3;
            Intrinsics.checkNotNullParameter(r2, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r5, "obj");
            Intrinsics.checkNotNullParameter(r4, "context");
            r2.d(r5.a(), 1);
            Object r6 = r5.b();
            if ((r6 instanceof byte[]) == false) goto L5;
            r2.b((byte[]) r6, 2);
            return;
        L5:
            if (r6 != null) goto L8;
            return;
        L8:
            throw new IllegalStateException(("unknown type of params " + r6).toString());
        }

        public final Object d(KClass r4, JsonObject r5, uh7.c.a r6) {
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "jsonObject");
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "jsonObject");
            Intrinsics.checkNotNullParameter(r6, "context");
            return (b) r6.a(r5, r4);
        }
    }

    static {
        a = new a();
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("webcast.revenue.biz.luckyBox.LuckyBoxDataService", "<set-?>");
        this.interfaceId = "webcast.revenue.biz.luckyBox.LuckyBoxDataService";
    }

    public b() {
        this.interfaceId = "";
    }

    public final String a() {
        return this.interfaceId;
    }

    public final Object b() {
        return this.params;
    }

    public final void d(Object r1) {
        this.params = r1;
    }
}
