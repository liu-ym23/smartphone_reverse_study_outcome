package com.bytedance.android.live.base.model;

import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FansClubMedal {

    @SerializedName("anchor")
    private User anchor;

    @SerializedName("badge")
    private Badge badge;

    @SerializedName("intimacy")
    private int intimacy;
    private boolean isSelected;

    @SerializedName("level")
    private int level;

    @SerializedName("status")
    private int status;

    public FansClubMedal() {
        this.isSelected = false;
    }

    public User getAnchor() {
        return this.anchor;
    }

    public Badge getBadge() {
        return this.badge;
    }

    public int getIntimacy() {
        return this.intimacy;
    }

    public int getLevel() {
        return this.level;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setAnchor(User r1) {
        this.anchor = r1;
    }

    public void setBadge(Badge r1) {
        this.badge = r1;
    }

    public void setIntimacy(int r1) {
        this.intimacy = r1;
    }

    public void setLevel(int r1) {
        this.level = r1;
    }

    public void setSelected(boolean r1) {
        this.isSelected = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }
}
