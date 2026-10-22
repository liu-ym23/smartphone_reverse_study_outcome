package com.bytedance.android.live.feature.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R4\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR4\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/feature/config/LiveFeatureEventFilterConfig;", "", "()V", "liveAppendParamsMap", "", "", "", "getLiveAppendParamsMap", "()Ljava/util/Map;", "setLiveAppendParamsMap", "(Ljava/util/Map;)V", "liveAppendRealtimeParamsMap", "getLiveAppendRealtimeParamsMap", "setLiveAppendRealtimeParamsMap", "liveFeaturesCollection", "getLiveFeaturesCollection", "()Ljava/util/List;", "setLiveFeaturesCollection", "(Ljava/util/List;)V", "liveFeaturesCollectionEventList", "getLiveFeaturesCollectionEventList", "setLiveFeaturesCollectionEventList", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeatureEventFilterConfig {

    @SerializedName("live_append_params_map")
    private Map<String, ? extends List<String>> liveAppendParamsMap;

    @SerializedName("live_append_realtime_params_map")
    private Map<String, ? extends List<String>> liveAppendRealtimeParamsMap;

    @SerializedName("live_features_collection")
    private List<String> liveFeaturesCollection;

    @SerializedName("live_features_collection_event_list")
    private List<String> liveFeaturesCollectionEventList;

    public LiveFeatureEventFilterConfig() {
    }

    public final Map<String, List<String>> getLiveAppendParamsMap() {
        return this.liveAppendParamsMap;
    }

    public final Map<String, List<String>> getLiveAppendRealtimeParamsMap() {
        return this.liveAppendRealtimeParamsMap;
    }

    public final List<String> getLiveFeaturesCollection() {
        return this.liveFeaturesCollection;
    }

    public final List<String> getLiveFeaturesCollectionEventList() {
        return this.liveFeaturesCollectionEventList;
    }

    public final void setLiveAppendParamsMap(Map<String, ? extends List<String>> r1) {
        this.liveAppendParamsMap = r1;
    }

    public final void setLiveAppendRealtimeParamsMap(Map<String, ? extends List<String>> r1) {
        this.liveAppendRealtimeParamsMap = r1;
    }

    public final void setLiveFeaturesCollection(List<String> r1) {
        this.liveFeaturesCollection = r1;
    }

    public final void setLiveFeaturesCollectionEventList(List<String> r1) {
        this.liveFeaturesCollectionEventList = r1;
    }
}
