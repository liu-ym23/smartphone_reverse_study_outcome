package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class n81 {

    @SerializedName("check_abnormal_case_add")
    public boolean isCheckAbnormalCaseAdd;

    @SerializedName("check_abnormal_case")
    public boolean mCheckAbnormalCase;

    @SerializedName("surface_render_click")
    public boolean mSurfaceRenderClick;

    @SerializedName("surface_render_click_use_share_player")
    public boolean mSurfaceRenderClickUseSharePlayer;

    @SerializedName("surface_render_draw")
    public boolean mSurfaceRenderDraw;

    @SerializedName("surface_render_draw_audio")
    public boolean mSurfaceRenderDrawAudio;

    @SerializedName("surface_render_draw_other")
    public boolean mSurfaceRenderDrawOther;

    @SerializedName("surface_render_draw_video")
    public boolean mSurfaceRenderDrawVideo;

    @SerializedName("surface_render_draw_vs")
    public boolean mSurfaceRenderDrawVs;

    @SerializedName("surface_scroll_refactor")
    public boolean surfaceScrollRefactor;

    public n81() {
        this.isCheckAbnormalCaseAdd = false;
        this.surfaceScrollRefactor = false;
    }
}
