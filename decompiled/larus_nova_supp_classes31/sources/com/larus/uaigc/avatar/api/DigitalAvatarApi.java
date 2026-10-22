package com.larus.uaigc.avatar.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import ey9.b;
import ey9.c;
import ey9.d;
import ey9.g;
import ey9.h;
import ey9.i;
import ey9.j;
import ey9.k;
import ey9.l;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/uaigc/avatar/api/DigitalAvatarApi;", "", "createDigitalAvatar", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarResponse;", "request", "Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarRequest;", "(Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDigitalAvatar", "Lcom/larus/uaigc/avatar/api/DeleteDigitalAvatarRequest;", "(Lcom/larus/uaigc/avatar/api/DeleteDigitalAvatarRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preGenDigitalAvatar", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "Lcom/larus/uaigc/avatar/api/PreGenDigitalAvatarRequest;", "(Lcom/larus/uaigc/avatar/api/PreGenDigitalAvatarRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCreateAvatarReadingText", "Lcom/larus/uaigc/avatar/api/ReadingTextInfo;", "Lcom/larus/uaigc/avatar/api/LoadCreateAvatarReadingTextRequest;", "(Lcom/larus/uaigc/avatar/api/LoadCreateAvatarReadingTextRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preCheckAvatarReadingText", "Lcom/larus/uaigc/avatar/api/PreCheckAvatarReadingTextResponse;", "Lcom/larus/uaigc/avatar/api/PreCheckAvatarReadingTextRequest;", "(Lcom/larus/uaigc/avatar/api/PreCheckAvatarReadingTextRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface DigitalAvatarApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object a(String r10, Function2 r11, Continuation r12) {
            FlowHttpConnection r0 = FlowHttpConnection.a;
            return FlowHttpConnection.g("Social", DigitalAvatarApi.class, r11, true, r10, null, null, r12, 224);
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/profile/avatar/create")
    Object createDigitalAvatar(@Body b r1, Continuation<? super BizResponse<c>> r2);

    @POST("/alice/profile/avatar/delete")
    Object deleteDigitalAvatar(@Body d r1, Continuation<? super BizResponse<?>> r2);

    @POST("/alice/profile/avatar/reading_text")
    Object loadCreateAvatarReadingText(@Body g r1, Continuation<? super BizResponse<l>> r2);

    @POST("/alice/profile/avatar/reading_text/pre_check")
    Object preCheckAvatarReadingText(@Body h r1, Continuation<? super BizResponse<i>> r2);

    @POST("/alice/profile/avatar/pre_gen")
    Object preGenDigitalAvatar(@Body j r1, Continuation<? super BizResponse<k>> r2);
}
