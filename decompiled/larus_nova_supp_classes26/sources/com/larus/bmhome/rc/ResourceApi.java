package com.larus.bmhome.rc;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 $2\u00020\u0001:\u0001$J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J*\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001bH§@¢\u0006\u0002\u0010\u001cJ,\u0010\u001d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\"H§@¢\u0006\u0002\u0010#¨\u0006%"}, d2 = {"Lcom/larus/bmhome/rc/ResourceApi;", "", "prepareUpload", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/rc/ResourcePrepareUploadData;", "requestBody", "Lcom/larus/bmhome/rc/ResourcePrepareUploadRequest;", "(Lcom/larus/bmhome/rc/ResourcePrepareUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "", "", "Lcom/larus/bmhome/rc/ResourceRegisterData;", "Lcom/larus/bmhome/rc/ResourceRegisterRequest;", "(Lcom/larus/bmhome/rc/ResourceRegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createVideoFrameWork", "Lcom/larus/bmhome/rc/CreateVideoFrameTaskRequest;", "(Lcom/larus/bmhome/rc/CreateVideoFrameTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUrl", "Lcom/larus/bmhome/rc/ResourceSignUrlData;", "Lcom/larus/bmhome/rc/ResourceSignUrlRequest;", "(Lcom/larus/bmhome/rc/ResourceSignUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUrlV2", "", "Lcom/larus/bmhome/rc/ResourceSignUrlDataV2;", "Lcom/larus/bmhome/rc/ResourceSignUrlRequestV2;", "(Lcom/larus/bmhome/rc/ResourceSignUrlRequestV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ShareChannel.DELETE, "Lcom/larus/bmhome/rc/ResourceDeleteRequest;", "(Lcom/larus/bmhome/rc/ResourceDeleteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAudioFileDetailUrl", "Lcom/larus/bmhome/rc/GetAudioFileH5Request;", "(Lcom/larus/bmhome/rc/GetAudioFileH5Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoModel", "Lcom/larus/bmhome/rc/GetVideoModelResults;", "Lcom/larus/bmhome/rc/GetVideoModelRequest;", "(Lcom/larus/bmhome/rc/GetVideoModelRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ResourceApi {
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
            return FlowHttpConnection.g("Basic", ResourceApi.class, r11, true, r10, null, null, r12, 224);
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/resource/create_video_frame_task")
    Object createVideoFrameWork(@Body CreateVideoFrameTaskRequest r1, Continuation<? super BizResponse<Map<String, String>>> r2);

    @POST("/alice/resource/delete")
    Object delete(@Body ResourceDeleteRequest r1, Continuation<? super BizResponse<String>> r2);

    @POST("/alice/resource/get_audio_file_h5")
    Object getAudioFileDetailUrl(@Body GetAudioFileH5Request r1, Continuation<? super BizResponse<Map<String, String>>> r2);

    @POST("/alice/resource/get_video_model")
    Object getVideoModel(@Body GetVideoModelRequest r1, Continuation<? super BizResponse<GetVideoModelResults>> r2);

    @POST("/alice/resource/prepare_upload")
    Object prepareUpload(@Body ResourcePrepareUploadRequest r1, Continuation<? super BizResponse<ResourcePrepareUploadData>> r2);

    @POST("/alice/resource/register")
    Object register(@Body ResourceRegisterRequest r1, Continuation<? super BizResponse<Map<String, ResourceRegisterData>>> r2);

    @POST("/alice/resource/sign_url")
    Object signUrl(@Body ResourceSignUrlRequest r1, Continuation<? super BizResponse<Map<String, ResourceSignUrlData>>> r2);

    @POST("/alice/resource/v2/sign_url")
    Object signUrlV2(@Body ResourceSignUrlRequestV2 r1, Continuation<? super BizResponse<List<ResourceSignUrlDataV2>>> r2);
}
