package com.larus.bmhome.chat.model.repo;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/ServiceBotNoticeApi;", "", "requestFullPermissionSetting", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/model/repo/FullPermissionSettings;", "request", "Lcom/larus/bmhome/chat/model/repo/GetFullPermissionSettingReq;", "(Lcom/larus/bmhome/chat/model/repo/GetFullPermissionSettingReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDetailedPermissionSetting", "Lcom/larus/bmhome/chat/model/repo/DetailedPermissionSetting;", "Lcom/larus/bmhome/chat/model/repo/GetDetailedPermissionSettingReq;", "(Lcom/larus/bmhome/chat/model/repo/GetDetailedPermissionSettingReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDetailedPermissionSetting", "Lcom/larus/bmhome/chat/model/repo/UpdateDetailedPermissionSettingReq;", "(Lcom/larus/bmhome/chat/model/repo/UpdateDetailedPermissionSettingReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface ServiceBotNoticeApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r10, Continuation r11) {
            if (AppHost.a.isOversea() == false) goto L8;
            FlowHttpConnection r0 = FlowHttpConnection.a;
            if (HttpExtKt.e().a == false) goto L7;
            String r1 = com.larus.platform.api.b2.a.k();
        L10:
            return FlowHttpConnection.g("Basic", ServiceBotNoticeApi.class, r10, true, null, r1, null, r11, 176);
        L7:
            r1 = com.larus.platform.api.b2.a.j();
            goto L10
        L8:
            FlowHttpConnection r2 = FlowHttpConnection.a;
            r1 = FlowHttpConnection.a();
            goto L10
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/biz_notice/get_detailed_perm")
    Object requestDetailedPermissionSetting(@Body GetDetailedPermissionSettingReq r1, Continuation<? super BizResponse<DetailedPermissionSetting>> r2);

    @POST("/alice/biz_notice/get_full_perm")
    Object requestFullPermissionSetting(@Body GetFullPermissionSettingReq r1, Continuation<? super BizResponse<FullPermissionSettings>> r2);

    @POST("/alice/biz_notice/update_detailed_perm")
    Object updateDetailedPermissionSetting(@Body UpdateDetailedPermissionSettingReq r1, Continuation<? super BizResponse<DetailedPermissionSetting>> r2);
}
