package com.ss.android.lark.profile.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ProfileFinishResult implements Serializable {
    private static final long serialVersionUID = 3442091501736892805L;
    public boolean isBlocked;
    public boolean isFriend;
    public boolean isRequestUserApplied;
    public boolean isTargetUserApplied;
    public String userId;

    public ProfileFinishResult() {
    }

    public ProfileFinishResult(String r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.isBlocked = r2;
        this.userId = r1;
        this.isFriend = r3;
        this.isRequestUserApplied = r4;
        this.isTargetUserApplied = r5;
    }
}
