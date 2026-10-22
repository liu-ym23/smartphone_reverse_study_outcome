package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/ExtraParamsSerializableObjectImpl;", "Lcom/bytedance/android/live/revlink/impl/jsb/e;", "Lcom/bytedance/android/livesdk/link/model/j8;", "autoMatchInfo", "Lcom/bytedance/android/livesdk/link/model/j8;", "getAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/j8;", "", "ifMutualOnline", "Ljava/lang/String;", "d2", "()Ljava/lang/String;", "gameAppId", "getGameAppId", "", "limitedByMixstreamType", "Z", "getLimitedByMixstreamType", "()Z", "isSeasonRank", "r6", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExtraParamsSerializableObjectImpl implements e {

    @SerializedName("auto_match_info")
    private final j8 autoMatchInfo;

    @SerializedName("game_app_id")
    private final String gameAppId;

    @SerializedName("if_mutual_online")
    private final String ifMutualOnline;

    @SerializedName("is_season_rank")
    private final boolean isSeasonRank;

    @SerializedName("limited_by_mix_stream_type")
    private final boolean limitedByMixstreamType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/ExtraParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ExtraParamsSerializableObjectImpl.class);
        }
    }

    public ExtraParamsSerializableObjectImpl() {
        this.autoMatchInfo = null;
        this.ifMutualOnline = DataType.FALSE;
        this.gameAppId = DataType.FALSE;
        this.limitedByMixstreamType = false;
        this.isSeasonRank = false;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.e
    public final String d2() {
        return this.ifMutualOnline;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.e
    public final j8 getAutoMatchInfo() {
        return this.autoMatchInfo;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.e
    public final String getGameAppId() {
        return this.gameAppId;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.e
    public final boolean r6() {
        return this.isSeasonRank;
    }
}
