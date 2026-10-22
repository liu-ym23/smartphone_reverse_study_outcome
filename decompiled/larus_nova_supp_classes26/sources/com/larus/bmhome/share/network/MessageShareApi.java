package com.larus.bmhome.share.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/share/network/MessageShareApi;", "", "messageShareSaveLegacy", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "request", "Lcom/larus/bmhome/share/network/SaveMessageRequest;", "(Lcom/larus/bmhome/share/network/SaveMessageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageShareSaveNew", "messageExportSave", "Lcom/larus/bmhome/share/network/MessageExportSaveResponse;", "Lcom/larus/bmhome/share/network/MessageExportSaveRequest;", "(Lcom/larus/bmhome/share/network/MessageExportSaveRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "continueTalk", "Lcom/larus/bmhome/share/network/ContinueTalkResp;", "Lcom/larus/bmhome/share/network/ContinueTalkRequest;", "(Lcom/larus/bmhome/share/network/ContinueTalkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MessageShareApi {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;

        static {
            a = new Companion();
        }

        public Companion() {
        }

        public static Object a(f r2, Continuation r3) {
            return b(new MessageShareApi$Companion$messageShareSave$2(r2, null), r3);
        }

        public static Object b(Function2 r10, Continuation r11) {
            FlowHttpConnection r0 = FlowHttpConnection.a;
            return FlowHttpConnection.g("Basic", MessageShareApi.class, r10, false, null, null, null, r11, 248);
        }
    }

    static {
        a = Companion.a;
    }

    @POST("/im/message/share/continue_chat")
    Object continueTalk(@Body a r1, Continuation<? super BizResponse<b>> r2);

    @POST("/alice/message/export/save")
    Object messageExportSave(@Body d r1, Continuation<? super BizResponse<e>> r2);

    @POST("/alice/message/share/save")
    Object messageShareSaveLegacy(@Body f r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2);

    @POST("/im/message/share/save")
    Object messageShareSaveNew(@Body f r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2);
}
