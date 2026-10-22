package k11;

import com.bytedance.android.live.revlink.aio.ApplyParamsAndResultDataSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(ApplyParamsAndResultDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lk11/a;", "Lvh7/j;", "Lcom/bytedance/android/livesdk/link/model/bridge/e;", "getResult", "()Lcom/bytedance/android/livesdk/link/model/bridge/e;", "setResult", "(Lcom/bytedance/android/livesdk/link/model/bridge/e;)V", "getResult$annotations", "()V", "result", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.ApplyParamsAndResultData")
public interface a extends vh7.j<a> {
    public static final C0258a i = null;

    /* JADX INFO: renamed from: k11.a$a, reason: collision with other inner class name */
    public static final class C0258a {
        public static final /* synthetic */ C0258a a = null;

        public C0258a() {
        }

        static {
            a = new C0258a();
        }

        public static a a(com.bytedance.android.livesdk.link.model.f r4, d11.h r5, Map r6, o r7, long r8, long r10, String r12) {
            Class r0 = a.class.getAnnotation(JsonAdapter.class).value();
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
            a r13 = (a) r9;
            r13.setResult(r4);
            r13.U0(r5);
            r13.e(r6);
            r13.a(r7);
            r13.d(r8);
            r13.b(r10);
            r13.setErrorMessage(r12);
            return r13;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.ApplyParamsAndResultData");
        }
    }

    @JsonAdapter(ApplyParamsAndResultDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        i = C0258a.a;
    }

    @FieldName(name = "request_params#setter")
    void U0(d11.h r1);

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
    void setResult(com.bytedance.android.livesdk.link.model.bridge.e r1);
}
