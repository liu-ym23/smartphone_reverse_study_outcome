package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z0 extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ a1.b b;

    public z0(a1.b r2) {
        this.a = true;
        this.b = r2;
    }

    public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r2) {
        a1.b r3 = this.b;
        if (r3 == null) goto L6;
        r3.onFail(new RuntimeException());
        return;
    }

    public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isFinished() == true) goto L6;
        return;
    L6:
        if (r4.getResult() != null) goto L8;
        return;
    L8:
        if (((CloseableReference) r4.getResult()).get() == null) goto L15;
        Observable r5 = Observable.just((PooledByteBuffer) ((CloseableReference) r4.getResult()).get()).subscribeOn(Schedulers.io()).map(new x0()).compose(RxUtil.rxSchedulerHelper());
        final boolean r0 = this.a;
        final a1.b r1 = this.b;
        r5.subscribe(new y0(r0, r1), RxUtil.getNoOpThrowable());
        return;
    }
}
