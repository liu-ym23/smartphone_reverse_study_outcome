package com.ss.android.lark.reaction.widget.detailwindow.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionDetailViewModel implements Serializable {
    private String reactionKey;
    private boolean selfInvoke;
    private String tipText;
    private int totalCount;
    private List<DetailUserInfo> userInfoList;

    public int hashCode() {
        return Objects.hash(new Object[]{this.reactionKey, Integer.valueOf(this.totalCount), this.userInfoList, Boolean.valueOf(this.selfInvoke)});
    }

    public ReactionDetailViewModel() {
        this.tipText = "";
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public String getTipText() {
        return this.tipText;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<DetailUserInfo> getUserInfoList() {
        return this.userInfoList;
    }

    public boolean isSelfInvoke() {
        return this.selfInvoke;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReactionDetailViewModel) == true) goto L8;
        return false;
    L8:
        ReactionDetailViewModel r6 = (ReactionDetailViewModel) r5;
        if (this.totalCount == r6.totalCount) goto L11;
    L17:
        return false;
    L11:
        if (this.selfInvoke != r6.selfInvoke) goto L17;
        if (Objects.equals(this.reactionKey, r6.reactionKey) == false) goto L17;
        if (Objects.equals(this.userInfoList, r6.userInfoList) == false) goto L17;
        return true;
    }

    public void setReactionKey(String r1) {
        this.reactionKey = r1;
    }

    public void setSelfInvoke(boolean r1) {
        this.selfInvoke = r1;
    }

    public void setTipText(String r1) {
        this.tipText = r1;
    }

    public void setTotalCount(int r1) {
        this.totalCount = r1;
    }

    public void setUserInfoList(List<DetailUserInfo> r1) {
        this.userInfoList = r1;
    }
}
