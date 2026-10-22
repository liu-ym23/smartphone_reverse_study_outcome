package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MediaItemStats {

    @SerializedName("comment_count")
    private int commentCount;

    @SerializedName("digg_count")
    private int diggCount;

    @SerializedName("id")
    private long id;

    @SerializedName("play_count")
    private int playCount;

    @SerializedName("share_count")
    private int shareCount;

    public MediaItemStats() {
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public int getDiggCount() {
        return this.diggCount;
    }

    public long getId() {
        return this.id;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public void setCommentCount(int r1) {
        this.commentCount = r1;
    }

    public void setDiggCount(int r1) {
        this.diggCount = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setPlayCount(int r1) {
        this.playCount = r1;
    }

    public void setShareCount(int r1) {
        this.shareCount = r1;
    }
}
