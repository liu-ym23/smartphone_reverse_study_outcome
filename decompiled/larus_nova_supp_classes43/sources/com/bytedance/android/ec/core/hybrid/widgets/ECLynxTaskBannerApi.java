package com.bytedance.android.ec.core.hybrid.widgets;

import com.bytedance.android.ec.core.hybrid.model.ECFloatWindowDetailResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/widgets/ECLynxTaskBannerApi;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "", "requestParams", "Lio/reactivex/Observable;", "Lcom/bytedance/android/ec/core/hybrid/model/ECFloatWindowDetailResponse;", "getFloatWindowDetail", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECLynxTaskBannerApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    @GET
    Observable<ECFloatWindowDetailResponse> getFloatWindowDetail(@Url String r1, @QueryMap Map<String, String> r10);
}
