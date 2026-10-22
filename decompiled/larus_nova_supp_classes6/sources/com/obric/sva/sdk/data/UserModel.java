package com.obric.sva.sdk.data;

import com.obric.sva.sdk.utils.LogUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class UserModel implements IUserModel {
    private final String TAG;
    private int mUserId;
    private String mUserName;

    @Override // com.obric.sva.sdk.data.IUserModel
    public int getUserId() {
        return this.mUserId;
    }

    @Override // com.obric.sva.sdk.data.IUserModel
    public String getUserName() {
        return this.mUserName;
    }

    public UserModel(String r2) {
        this.TAG = "UserModel";
        this.mUserId = -1;
        this.mUserName = r2;
    }

    private String maskUserIdForLog(int r4) {
        String r5 = String.valueOf(r4);
        return "****" + r5.substring(Math.max(0, r5.length() - 4));
    }

    @Override // com.obric.sva.sdk.data.IUserModel
    public void setUserId(int r5) {
        LogUtils.d(this.TAG, "setUserId: userId = " + maskUserIdForLog(r5), new Object[0]);
        if (r5 >= (-1)) goto L6;
        LogUtils.d(this.TAG, "setUserId: invalid userId", new Object[0]);
        return;
    L6:
        this.mUserId = r5;
    }

    @Override // com.obric.sva.sdk.data.IUserModel
    public void setUserName(String r1) {
        this.mUserName = r1;
    }
}
