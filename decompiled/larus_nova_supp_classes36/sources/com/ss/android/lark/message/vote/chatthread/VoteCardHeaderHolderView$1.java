package com.ss.android.lark.message.vote.chatthread;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class VoteCardHeaderHolderView$1 extends UIGetDataCallback<rrb.a> {
    final /* synthetic */ a this$0;

    public VoteCardHeaderHolderView$1(a r1) {
    }

    public void onErrored(ErrorResult r3) {
        Log.e("vote action fail:" + r3.toString());
    }

    public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
        onSuccessed((rrb.a) r1);
    }

    public void onSuccessed(rrb.a r1) {
        Log.i("vote action success");
    }
}
