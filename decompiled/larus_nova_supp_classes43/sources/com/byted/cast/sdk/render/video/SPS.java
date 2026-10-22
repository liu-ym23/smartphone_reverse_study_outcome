package com.byted.cast.sdk.render.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class SPS {
    public boolean bVaild;
    int bit_depth_chroma;
    int bit_depth_luma;
    int chroma_format_idc;
    int crop;
    int crop_bottom;
    int crop_left;
    int crop_right;
    int crop_top;
    int frame_mbs_only_flag;
    public int height;
    int level_idc;
    int log2_max_frame_num;
    int mb_height;
    int mb_width;
    int pic_order_cnt_type;
    int profile_idc;
    int ref_frame_count;
    public int width;

    public SPS() {
        this.bVaild = false;
        this.width = 0;
        this.height = 0;
    }
}
