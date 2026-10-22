package com.larus.avlink.env.diary.feedback.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import j98.h;
import j98.i;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/api/DoraEnvObserveDiaryFeedbackApi;", "", "getFeedbackConfig", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackConfigData;", "request", "Lcom/larus/avlink/env/diary/feedback/model/GetDiaryFeedbackConfigRequest;", "(Lcom/larus/avlink/env/diary/feedback/model/GetDiaryFeedbackConfigRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitFeedback", "Lcom/larus/avlink/env/diary/feedback/model/SubmitDiaryFeedbackRequest;", "(Lcom/larus/avlink/env/diary/feedback/model/SubmitDiaryFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface DoraEnvObserveDiaryFeedbackApi {
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
            return FlowHttpConnection.g("DORA", DoraEnvObserveDiaryFeedbackApi.class, r10, false, null, null, null, r11, 248);
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/wearable/feedback/get_config")
    Object getFeedbackConfig(@Body h r1, Continuation<? super BizResponse<j98.a>> r2);

    @POST("/alice/wearable/feedback/submit")
    Object submitFeedback(@Body i r1, Continuation<? super BizResponse<Object>> r2);
}
