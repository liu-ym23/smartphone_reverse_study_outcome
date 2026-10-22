package com.ss.android.lark.member_manage.export.callback;

import com.larksuite.framework.callback.CancelableCallback;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.ICallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class JoinGroupCallbackWrap extends CancelableCallback<IJoinGroupCallback> implements IJoinGroupCallback {
    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onCancelSendApply() {
        ICallback r0 = ((CancelableCallback) this).callback;
        if (r0 == null) goto L6;
        ((IJoinGroupCallback) r0).onCancelSendApply();
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onShowSendApplyDialog() {
        ICallback r0 = ((CancelableCallback) this).callback;
        if (r0 == null) goto L6;
        ((IJoinGroupCallback) r0).onShowSendApplyDialog();
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void sendApplySuccess() {
        ICallback r0 = ((CancelableCallback) this).callback;
        if (r0 == null) goto L6;
        ((IJoinGroupCallback) r0).sendApplySuccess();
        return;
    }

    public JoinGroupCallbackWrap(IJoinGroupCallback r1) {
        super(r1);
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void joinGroupChatSuccess(String r2) {
        ICallback r0 = ((CancelableCallback) this).callback;
        if (r0 == null) goto L6;
        ((IJoinGroupCallback) r0).joinGroupChatSuccess(r2);
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onError(ErrorResult r2) {
        ICallback r0 = ((CancelableCallback) this).callback;
        if (r0 == null) goto L6;
        ((IJoinGroupCallback) r0).onError(r2);
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onSendApplyError(ErrorResult r2) {
        ICallback r0 = ((CancelableCallback) this).callback;
        if (r0 == null) goto L6;
        ((IJoinGroupCallback) r0).onSendApplyError(r2);
        return;
    }
}
