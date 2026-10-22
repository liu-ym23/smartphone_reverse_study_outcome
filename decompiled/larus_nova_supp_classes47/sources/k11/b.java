package k11;

import com.bytedance.android.live.revlink.aio.CancelParamsAndResultDataSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(CancelParamsAndResultDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lk11/b;", "Lvh7/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.CancelParamsAndResultData")
public interface b extends vh7.j<b> {
    public static final a j = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a(d11.i r4, Map r5, o r6, long r7, long r9, String r12) {
            Class r0 = b.class.getAnnotation(JsonAdapter.class).value();
            ConcurrentHashMap r1 = vh7.b.a;
            Object r2 = r1.get(r0);
            if (r2 != null) goto L12;
            r2 = r0.getConstructor(new Class[0]);
            if (r2 == null) goto L11;
            Object r3 = r1.putIfAbsent(r0, r2);
            if (r3 == null) goto L12;
            r2 = r3;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r8 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
            if (r8 == null) goto L17;
            b r10 = (b) r8;
            r10.N3(r4);
            r10.e(r5);
            r10.a(r6);
            r10.d(r7);
            r10.b(r9);
            r10.setErrorMessage(r12);
            return r10;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.CancelParamsAndResultData");
        }
    }

    /* JADX INFO: renamed from: k11.b$b, reason: collision with other inner class name */
    @JsonAdapter(CancelParamsAndResultDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0259b {
    }

    static {
        j = a.a;
    }

    @FieldName(name = "request_params#setter")
    void N3(d11.i r1);

    @FieldName(name = "state_transition#setter")
    void a(o r1);

    @FieldName(name = "error_code#setter")
    void b(long r1);

    @FieldName(name = "start_ts#setter")
    void d(long r1);

    @FieldName(name = "client_params#setter")
    void e(Map<String, String> r1);

    @FieldName(name = "error_message#setter")
    void setErrorMessage(String r1);
}
