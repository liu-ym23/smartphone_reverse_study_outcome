package com.larus.uaigc.helper;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/uaigc/helper/EnterpriseFileWatermarkApi;", "", "requestWatermarkDownload", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/helper/WatermarkDownloadResponse;", "request", "Lcom/larus/uaigc/helper/WatermarkDownloadRequest;", "(Lcom/larus/uaigc/helper/WatermarkDownloadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestWatermarkTask", "Lcom/larus/uaigc/helper/WatermarkTaskResponse;", "taskId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface EnterpriseFileWatermarkApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/resource/watermark_download")
    Object requestWatermarkDownload(@Body p0 r1, Continuation<? super BizResponse<q0>> r2);

    @GET("/alice/resource/watermark_task")
    Object requestWatermarkTask(@Query("task_id") String r1, Continuation<? super BizResponse<r0>> r2);
}
