package sb0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsb0/b;", "", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static Pair a() {
            sb0.a r0 = new sb0.a();
            Object r2 = Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{b.class}, r0);
            if (r2 == null) goto L7;
            return new Pair((b) r2, r0);
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ktv.common.model.entity.IDataEntity");
        }
    }

    static {
        a = a.a;
    }

    boolean a();

    e b();

    c c();

    d d();

    String e();

    String f();

    DataCenter getDataCenter();

    boolean isAnchor();
}
