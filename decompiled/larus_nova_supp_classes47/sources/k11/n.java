package k11;

import com.bytedance.android.live.revlink.aio.StateInfoSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(StateInfoSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lk11/n;", "Lvh7/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.StateInfo")
public interface n extends vh7.j<n> {
    public static final a o = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static n a(int r4, long r5) {
            Class r0 = n.class.getAnnotation(JsonAdapter.class).value();
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
            Object r6 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
            if (r6 == null) goto L17;
            n r7 = (n) r6;
            r7.N(r4);
            r7.setChannelId(r5);
            return r7;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.StateInfo");
        }
    }

    @JsonAdapter(StateInfoSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        o = a.a;
    }

    @FieldName(name = "state#setter")
    void N(int r1);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r1);
}
