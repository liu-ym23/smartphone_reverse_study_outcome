package com.larus.dora.impl.device.settings.camera;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/DoraCameraApi;", "", "updateDoraVisionSettings", "Lcom/larus/network/bean/BizResponse;", "", "postBody", "Lcom/larus/dora/impl/device/settings/camera/UpdateDoraVisionSettingsRequest;", "(Lcom/larus/dora/impl/device/settings/camera/UpdateDoraVisionSettingsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDoraVisionSettings", "Lcom/larus/dora/impl/device/settings/camera/VisionSettingsData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraCameraApi {
    @POST("/alice/audio/get_dora_vision_settings")
    Object getDoraVisionSettings(Continuation<? super BizResponse<VisionSettingsData>> r1);

    @POST("/alice/audio/update_dora_vision_settings")
    Object updateDoraVisionSettings(@Body UpdateDoraVisionSettingsRequest r1, Continuation<? super BizResponse<Unit>> r2);
}
