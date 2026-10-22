package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/t21;", "", "", "ugcRoomMultiTabEnable", "Z", "b", "()Z", "gameFantasyResolutionHidePaidTagEnable", "a", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t21 {

    @SerializedName("game_fantasy_resolution_hide_paid_tag_enable")
    private final boolean gameFantasyResolutionHidePaidTagEnable;

    @SerializedName("ugc_room_multi_tab_enable")
    private final boolean ugcRoomMultiTabEnable;

    public t21() {
    }

    public final boolean a() {
        return this.gameFantasyResolutionHidePaidTagEnable;
    }

    public final boolean b() {
        return this.ugcRoomMultiTabEnable;
    }
}
