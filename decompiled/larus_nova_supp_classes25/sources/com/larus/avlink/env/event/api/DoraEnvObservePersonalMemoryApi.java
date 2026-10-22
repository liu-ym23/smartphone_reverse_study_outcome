package com.larus.avlink.env.event.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import n98.b;
import n98.c;
import n98.d;
import n98.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/avlink/env/event/api/DoraEnvObservePersonalMemoryApi;", "", "getUserProfileList", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/event/api/UserProfileListResponse;", "request", "Lcom/larus/avlink/env/event/api/GetUserProfileListRequest;", "(Lcom/larus/avlink/env/event/api/GetUserProfileListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUserProfile", "Lcom/larus/avlink/env/event/api/AddUserProfileRequest;", "(Lcom/larus/avlink/env/event/api/AddUserProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "Lcom/larus/avlink/env/event/api/UpdateUserProfileRequest;", "(Lcom/larus/avlink/env/event/api/UpdateUserProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserProfile", "Lcom/larus/avlink/env/event/api/DeleteUserProfileRequest;", "(Lcom/larus/avlink/env/event/api/DeleteUserProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface DoraEnvObservePersonalMemoryApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r10, Continuation r11) {
            FlowHttpConnection r0 = FlowHttpConnection.a;
            return FlowHttpConnection.g("DORA", DoraEnvObservePersonalMemoryApi.class, r10, false, null, null, null, r11, 248);
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/wearable/diary/add_user_profile")
    Object addUserProfile(@Body n98.a r1, Continuation<? super BizResponse<f>> r2);

    @POST("/alice/wearable/diary/delete_user_profile")
    Object deleteUserProfile(@Body b r1, Continuation<? super BizResponse<f>> r2);

    @POST("/alice/wearable/diary/get_user_profile_list")
    Object getUserProfileList(@Body c r1, Continuation<? super BizResponse<f>> r2);

    @POST("/alice/wearable/diary/update_user_profile")
    Object updateUserProfile(@Body d r1, Continuation<? super BizResponse<f>> r2);
}
