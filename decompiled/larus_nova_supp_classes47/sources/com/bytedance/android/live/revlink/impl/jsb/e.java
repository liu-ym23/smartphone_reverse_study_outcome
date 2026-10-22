package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(ExtraParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/e;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.j<e> {

    @JsonAdapter(ExtraParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "if_mutual_online")
    String d2();

    @FieldName(name = "auto_match_info")
    j8 getAutoMatchInfo();

    @FieldName(name = "game_app_id")
    String getGameAppId();

    @FieldName(name = "is_season_rank")
    boolean r6();
}
