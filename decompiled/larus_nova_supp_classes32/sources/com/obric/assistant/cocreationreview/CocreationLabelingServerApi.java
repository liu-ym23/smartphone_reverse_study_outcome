package com.obric.assistant.cocreationreview;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationLabelingServerApi;", NameKeys.UnloadStrategy_No_Strategy, "submitUserFeedback", "Lcom/larus/network/bean/BizResponse;", "xTtToken", NameKeys.UnloadStrategy_No_Strategy, "request", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", "(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitUserFeedbackStat", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;", "(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitMemoryTraceReport", "Lcom/obric/assistant/cocreationreview/CocreationMemoryTraceReportRequest;", "(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/CocreationMemoryTraceReportRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface CocreationLabelingServerApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r9, Continuation r10) {
            FlowHttpConnection r0 = FlowHttpConnection.a;
            int r1 = k0.a;
            int r2 = iaa.a.a;
            StringBuilder r3 = new StringBuilder("https://");
            if (t9a.b.a().e() == false) goto L5;
            String r4 = "ofa.bytedance.net";
        L6:
            r3.append(r4);
            r3.append('/');
            return FlowHttpConnection.i("OBRIC", CocreationLabelingServerApi.class, r9, null, null, StringsKt.removeSuffix(r3.toString(), "/"), r10, SpeechEvent.SERVER_UPLINK_EVENT_MUTE_CALL);
        L5:
            r4 = "ofa.obriccloud.com";
            goto L6
        }
    }

    static {
        a = a.a;
    }

    @POST("/intent/feedback/user/memory-trace-report")
    Object submitMemoryTraceReport(@Header("X-Tt-Token") String r1, @Body CocreationMemoryTraceReportRequest r2, Continuation<? super BizResponse<Object>> r3);

    @POST("/intent/feedback/user/new")
    Object submitUserFeedback(@Header("X-Tt-Token") String r1, @Body CocreationUserFeedbackRequest r2, Continuation<? super BizResponse<Object>> r3);

    @POST("/intent/feedback/user/stat")
    Object submitUserFeedbackStat(@Header("X-Tt-Token") String r1, @Body CocreationUserFeedbackStatRequest r2, Continuation<? super BizResponse<Object>> r3);
}
