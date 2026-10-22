package k11;

import com.bytedance.android.live.revlink.aio.ReplyParamsAndResultDataSerializableObjectImpl;
import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(ReplyParamsAndResultDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lk11/m;", "Lvh7/j;", "Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "getResult", "()Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "setResult", "(Lcom/bytedance/android/livesdk/link/model/bridge/d1;)V", "getResult$annotations", "()V", "result", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.ReplyParamsAndResultData")
public interface m extends vh7.j<m> {
    public static final a n = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static m a(q5 r4, d11.l r5, Map r6, o r7, long r8, long r10, String r12) {
            Class r0 = m.class.getAnnotation(JsonAdapter.class).value();
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
            Object r9 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
            if (r9 == null) goto L17;
            m r13 = (m) r9;
            r13.setResult(r4);
            r13.A6(r5);
            r13.e(r6);
            r13.a(r7);
            r13.d(r8);
            r13.b(r10);
            r13.setErrorMessage(r12);
            return r13;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.ReplyParamsAndResultData");
        }
    }

    @JsonAdapter(ReplyParamsAndResultDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        n = a.a;
    }

    @FieldName(name = "request_params#setter")
    void A6(d11.l r1);

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

    @FieldName(name = "response#setter")
    void setResult(d1 r1);
}
