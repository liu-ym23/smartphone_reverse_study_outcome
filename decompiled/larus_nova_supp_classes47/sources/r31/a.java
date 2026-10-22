package r31;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import com.bytedance.android.livesdk.link.model.e4;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.i8;
import com.bytedance.android.livesdk.link.model.l4;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.o;
import com.bytedance.android.livesdk.link.model.q3;
import com.bytedance.android.livesdk.link.model.r3;
import com.bytedance.android.livesdk.link.model.r4;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.w7;
import com.bytedance.android.livesdk.link.model.z0;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    public static final C0307a a = null;

    /* JADX INFO: renamed from: r31.a$a, reason: collision with other inner class name */
    public static final class C0307a {
        public static final /* synthetic */ C0307a a = null;

        public C0307a() {
        }

        static {
            a = new C0307a();
        }
    }

    static {
        a = C0307a.a;
    }

    Observable<ExtraResponse<IPropInfoNotifyResponse, Extra>> A(int r1, long r2, long r4, String r6);

    Observable B(String r1, int r2);

    Observable C(boolean r1, boolean r2, long r3, long r5);

    Observable D(int r1, String r2, String r3, int r4, int r5, int r6, int r7, String r8, String r9);

    Observable<ExtraResponse<n9, Extra>> E(List<String> r1, int r2, int r3, long r4, long r6, String r8);

    Observable<ExtraResponse<Object, Extra>> F(int r1, long r2, String r4, long r5, String r7, String r8, String r9);

    Observable<ExtraResponse<e4, Extra>> G();

    Observable<ExtraResponse<Object, Extra>> H(int r1, long r2, long r4, String r6, String r7, String r8, long r9);

    Observable I(long r1, String r3);

    Observable<ExtraResponse<u6, Extra>> J(String r1, int r2, int r3, String r4, String r5, int r6);

    Observable<ExtraResponse<Object, Extra>> K(int r1, String r2, long r3, long r5);

    Observable<ExtraResponse<Object, Extra>> L(int r1, String r2, long r3, long r5, long r7, long r9, int r12, int r13);

    Observable M(long r1, int r3, long r4, int r6, boolean r7, String r8);

    Observable<ExtraResponse<Object, Extra>> N(long r1, String r3, int r4, Map<String, ? extends Object> r5);

    Observable O(long r1, long r3, int r5, boolean r6, String r7, long r8, String r10);

    Observable P(String r1);

    Observable<ExtraResponse<Object, Extra>> Q(int r1, String r2, long r3, long r5);

    Observable<ExtraResponse<Object, Extra>> R(long r1, long r3);

    Observable<ExtraResponse<Object, Extra>> a(int r1, long r2, int r4, String r5, long r6);

    Observable b();

    Observable c(int r1, boolean r2, int r3, String r4, int r5, int r6);

    Observable<ExtraResponse<Object, Extra>> d(List<String> r1, long r2, long r4, int r6, int r7);

    Observable e(long r1, long r3, String r5, int r6, String r7, String r8, Long r9, String r10, int r12, Map r13);

    Observable<ExtraResponse<f1, Extra>> f(long r1, int r3, int r4, long r5, int r7, String r8, long r9, int r12, long r13);

    Observable<ExtraResponse<Object, Extra>> feedback(Map<String, ? extends Object> r1);

    Observable g(long r1, long r3, long r5, int r7, int r8);

    Observable<ExtraResponse<o, Extra>> getAnchorLinkSetting(long r1, String r3);

    Observable<ExtraResponse<bf2.a, Extra>> getLatestBanRecord(long r1);

    Observable<ExtraResponse<q3, Extra>> h(long r1, long r3, int r5, String r6);

    Observable i(long r1, String r3, int r4);

    Observable<ExtraResponse<l4, Extra>> intercomClose(long r1, long r3);

    Observable<ExtraResponse<l4, Extra>> intercomInvite(long r1, long r3);

    Observable<ExtraResponse<l4, Extra>> intercomReply(long r1, long r3, int r5, boolean r6);

    Observable<ExtraResponse<i8, Extra>> j(String r1, int r2);

    Observable<ExtraResponse<Object, Extra>> k(long r1, long r3, String r5, int r6, int r7, int r8, int r9);

    Observable<ExtraResponse<Object, Extra>> l(long r1, int r3, String r4, int r5, long r6);

    Observable m(long r1, int r3, String r4);

    Observable<ExtraResponse<Object, Extra>> mute(long r1, int r3, String r4, long r5);

    Observable<ExtraResponse<r3, Extra>> n(long r1, long r3, String r5);

    Observable<ExtraResponse<Object, Extra>> o(long r1, long r3, String r5, String r6);

    Observable<ExtraResponse<Object, Extra>> p(long r1, int r3, String r4, long r5, long r7, int r9);

    Observable<ExtraResponse<z0, Extra>> q(int r1);

    Observable r(int r1, String r2, int r3);

    Observable s(String r1, int r2);

    Observable<ExtraResponse<r4, com.bytedance.android.livesdk.link.model.a>> t(long r1, int r3, int r4, int r5, boolean r6, String r7, int r8, List<com.bytedance.android.live.revlink.impl.multianchor.match.o> r9, int r10, String r12, String r13, String r14);

    Observable u(long r1, boolean r3, int r4, long r5, long r7, String r9, int r10, String r12);

    Observable<ExtraResponse<Object, Extra>> updateAnchorLinkSetting(long r1, String r3, int r4, Map<String, ? extends Object> r5);

    Observable<ExtraResponse<Object, Extra>> updateLinkMicConfig(long r1, long r3, String r5, boolean r6, boolean r7);

    Observable v(long r1, long r3, long r5);

    Observable w(long r1, String r3, String r4, long r5, int r7);

    Observable<ExtraResponse<w7, Extra>> x(String r1, long r2, long r4, String r6);

    Observable y(List r1, int r2, int r3);

    Observable<ExtraResponse<Object, Extra>> z(int r1, long r2, long r4, String r6, int r7);
}
