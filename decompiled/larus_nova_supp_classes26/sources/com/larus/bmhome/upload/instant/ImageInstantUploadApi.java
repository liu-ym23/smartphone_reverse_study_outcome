package com.larus.bmhome.upload.instant;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/upload/instant/ImageInstantUploadApi;", "", "preQuery", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryResponse;", MusicAppletPage.KEY_PATH, "", "request", "Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryRequest;", "(Ljava/lang/String;Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageInstantUploadApi {
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
            return FlowHttpConnection.g("Infra", ImageInstantUploadApi.class, r10, false, null, null, null, r11, 248);
        }
    }

    static {
        a = a.a;
    }

    @POST
    Object preQuery(@Url String r1, @Body ImageInstantUploadPreQueryRequest r2, Continuation<? super BizResponse<ImageInstantUploadPreQueryResponse>> r3);
}
