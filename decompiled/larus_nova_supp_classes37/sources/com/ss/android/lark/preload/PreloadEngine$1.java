package com.ss.android.lark.preload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.preload.moment.PreloadMoment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
class PreloadEngine$1 implements IGetDataCallback<Object> {
    final /* synthetic */ a this$0;
    final /* synthetic */ PreloadMoment val$moment;
    final /* synthetic */ d1c.a val$preloadTask;

    public void onError(ErrorResult r3) {
        a.a(this.this$0, this.val$preloadTask, this.val$moment);
    }

    public void onSuccess(Object r3) {
        a.a(this.this$0, this.val$preloadTask, this.val$moment);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public PreloadEngine$1(a r1, d1c.a r2, PreloadMoment r3) {
        this.this$0 = r1;
        this.val$preloadTask = r2;
        this.val$moment = r3;
    }
}
