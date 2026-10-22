package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface m4 {
    boolean enablePanel();

    com.bytedance.android.live.base.model.data.b getStatusInfo();

    IBaseUser getUser();

    boolean isSecretChat();

    void setStatusInfo(com.bytedance.android.live.base.model.data.b r1);
}
