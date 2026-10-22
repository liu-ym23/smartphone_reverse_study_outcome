package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rRB\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/vf1;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/config/wf1;", "Lkotlin/collections/HashMap;", "spatialAudiolistenerPositionConfigByLayout", "Ljava/util/HashMap;", "getSpatialAudiolistenerPositionConfigByLayout", "()Ljava/util/HashMap;", "setSpatialAudiolistenerPositionConfigByLayout", "(Ljava/util/HashMap;)V", "<init>", "()V", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class vf1 {

    @SerializedName("listener_position_config_by_layout")
    private HashMap<Integer, wf1> spatialAudiolistenerPositionConfigByLayout;

    public vf1() {
        this.spatialAudiolistenerPositionConfigByLayout = new HashMap();
    }
}
