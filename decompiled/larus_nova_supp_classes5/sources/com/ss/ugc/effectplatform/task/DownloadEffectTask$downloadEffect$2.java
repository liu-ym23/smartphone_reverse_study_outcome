package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import nlc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DownloadEffectTask$downloadEffect$2 implements p1<a> {
    public final /* synthetic */ DownloadEffectTask a;

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void f(o1<a> r1) {
    }

    public DownloadEffectTask$downloadEffect$2(DownloadEffectTask r1) {
        this.a = r1;
    }

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void a(o1<a> r3) {
        Logger.INSTANCE.d("DownloadEffectTask", "[特效][回调][取消][" + this.a.getId() + ']');
        this.a.e(new onCancel.1(this));
    }

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void b(o1<a> r2) {
        this.a.e(new DownloadEffectTask$downloadEffect$2$onStart$1(this));
    }

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void g(o1<a> r3) {
        Logger.INSTANCE.d("DownloadEffectTask", "[特效][回调][暂停][" + this.a.getId() + ']');
        this.a.e(new onPause.1(this));
    }

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void c(o1<a> r3, ExceptionResult r4) {
        DownloadEffectTask.f(this.a, false, r4);
        Logger.INSTANCE.d("DownloadEffectTask", "[特效][回调][失败][" + this.a.getId() + "][错误码:" + r4.getErrorCode() + "][错误信息:" + r4.getMsg() + ']');
        this.a.e(new onFailed.1(this, r4));
    }

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void e(o1<a> r3, a r4) {
        final a r5 = r4;
        DownloadEffectTask.f(this.a, true, null);
        Logger.INSTANCE.d("DownloadEffectTask", "[特效][回调][成功][" + this.a.getId() + ']');
        this.a.e(new DownloadEffectTask$downloadEffect$2$onResponse$1(this, r5));
    }

    @Override // com.ss.ugc.effectplatform.task.p1
    public final void d(y r2, int r3, long r4) {
        this.a.e(new onProgress.1(this, r3, r4));
    }
}
