package com.ss.android.lark.member_manage.export.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.ICallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IJoinGroupCallback extends ICallback {
    void joinGroupChatSuccess(String r1);

    void onCancelSendApply();

    void onError(ErrorResult r1);

    void onSendApplyError(ErrorResult r1);

    void onShowSendApplyDialog();

    void sendApplySuccess();
}
