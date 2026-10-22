package com.ss.android.lark.contact.base.contact_search;

import com.bytedance.lark.pb.contact.v1.SendUserInvitationResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.IModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends IModel {
    void w4(String r1, boolean r2, IGetDataCallback<SendUserInvitationResponse> r3);

    <T> void x3(String r1, IGetDataCallback<T> r2);
}
