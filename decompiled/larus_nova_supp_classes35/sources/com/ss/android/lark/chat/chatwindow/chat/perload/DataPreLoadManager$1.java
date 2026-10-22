package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.concurrent.CountDownLatch;
import u3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class DataPreLoadManager$1 implements IGetDataCallback<e> {
    final /* synthetic */ c this$0;
    final /* synthetic */ CountDownLatch val$countDownLatch;
    final /* synthetic */ e val$preLoadResult;

    public void onError(ErrorResult r2) {
        this.val$preLoadResult.b = r2;
        this.val$countDownLatch.countDown();
    }

    public void onSuccess(e r3) {
        e r0 = this.val$preLoadResult;
        r0.a = r3.a;
        r0.b = r3.b;
        this.val$countDownLatch.countDown();
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((e) r1);
    }

    public DataPreLoadManager$1(c r1, e r2, CountDownLatch r3) {
        this.this$0 = r1;
        this.val$preLoadResult = r2;
        this.val$countDownLatch = r3;
    }
}
