package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h0 extends q3 {
    String getChatContent();

    IBaseUser getChatUserInfo();

    @Override // com.bytedance.android.live.base.model.message.q3
    long getPinBaseMessageId();

    a5 getRichText();
}
