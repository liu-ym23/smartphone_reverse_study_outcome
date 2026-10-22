package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface i4 extends t {
    a5 getDisplayText();

    IBaseUser getSender();

    a5 getSuffixText();

    User getTargetUser();

    long getType();
}
