package com.bytedance.android.live.revenue.platform.network.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.google.gson.JsonObject;
import dy0.c;
import f80.a;
import io.reactivex.Observable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface INetworkService extends a, c {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/INetworkService$Biz;", "", "Revenue", "MultiLink", "GameCp", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Biz extends Enum<Biz> {
        public static final Biz GameCp = null;
        public static final Biz MultiLink = null;
        public static final Biz Revenue = null;
        public static final /* synthetic */ Biz[] a = null;

        static {
            Biz r1 = new Biz("Revenue", 0);
            Revenue = r1;
            Biz r2 = new Biz("MultiLink", 1);
            MultiLink = r2;
            Biz r3 = new Biz("GameCp", 2);
            GameCp = r3;
            a = new Biz[]{r1, r2, r3};
        }

        public static Biz valueOf(String r1) {
            return (Biz) r27.a.a(Biz.class, r1);
        }

        public static Biz[] values() {
            return (Biz[]) a.clone();
        }

        public Biz(String r1, int r2) {
            super(r1, r2);
        }
    }

    void K0(Biz r1, com.bytedance.android.livesdk.revenue.network.a r2);

    <DATA, EXTRA extends Extra> Observable<ExtraResponse<DATA, EXTRA>> L4(Biz r1, String r2, Type r3, Type r4, List<? extends com.bytedance.android.livesdk.revenue.network.a> r5, Map<String, String> r6, Map<String, String> r7, Map<String, ? extends List<String>> r8, Map<String, String> r9, Map<String, ? extends List<String>> r10, JsonObject r12);

    void s(Biz r1, com.bytedance.android.livesdk.revenue.network.a r2);

    <DATA, EXTRA extends Extra> Observable<ExtraResponse<DATA, EXTRA>> x0(Biz r1, String r2, Type r3, Type r4, List<? extends com.bytedance.android.livesdk.revenue.network.a> r5, Map<String, String> r6, Map<String, String> r7, Map<String, ? extends List<String>> r8);
}
