package com.larus.bmhome.banner;

import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/banner/BannerApi;", "", "getNoticeBanner", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/banner/BannerResponse;", "pageType", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface BannerApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object a(int r11, DowngradeSource r12, Continuation r13) {
            FlowDowngradeServiceDelegate r0 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r4 = new JSONObject();
            r4.put("page_type", r11);
            Unit r14 = Unit.INSTANCE;
            if (r12 == null) goto L5;
            Map r15 = MapsKt.mapOf(TuplesKt.to("source", r12.getValue()));
        L7:
            return IFlowDowngradeService.a.b(r0, "Basic", BannerResponse.class, "/alice/notice/banner", r4, null, true, null, r15, r13, 944);
        L5:
            r15 = null;
            goto L7
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/notice/banner")
    Object getNoticeBanner(@Query("page_type") int r1, Continuation<? super BizResponse<BannerResponse>> r2);
}
