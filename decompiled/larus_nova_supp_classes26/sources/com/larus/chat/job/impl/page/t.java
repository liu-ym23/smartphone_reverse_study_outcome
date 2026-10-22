package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import com.larus.im.bean.job.AIJobListResult;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t implements IIMCallback<AIJobListResult> {
    public final /* synthetic */ int a;
    public final /* synthetic */ ChatJobListLoader b;
    public final /* synthetic */ String c;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        if (this.a == this.b.q) goto L6;
        FLogger.a.i("ChatJobListLoader", "loadLocalRecommendJobs failure ignored stale generation reason=" + this.c);
        return;
    L6:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("loadLocalRecommendJobs failed reason=");
        r1.append(this.c);
        r1.append(' ');
        int r3 = ChatJobListLoader.t;
        r1.append(ChatJobListLoader.a.d(r5));
        r0.e("ChatJobListLoader", r1.toString());
        gz8.h.b(r5);
        ChatJobListLoader.a(this.b, "loadLocalRecommendFailed:" + this.c);
    }

    public final void onSuccess(Object r8) {
        AIJobListResult r9 = (AIJobListResult) r8;
        Intrinsics.checkNotNullParameter(r9, "result");
        int r0 = this.a;
        ChatJobListLoader r1 = this.b;
        if (r0 == r1.q) goto L5;
        FLogger.a.i("ChatJobListLoader", "loadLocalRecommendJobs success ignored stale generation reason=" + this.c);
        return;
    L5:
        List<AIJob> r2 = r1.f;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L6:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L14;
        Object r6 = r4.next();
        if (((AIJob) r6).getJobType() != 2) goto L12;
        r5 = false;
    L12:
        if (r5 == false) goto L6;
        r3.add(r6);
        goto L6
    L14:
        this.b.f = CollectionsKt.plus(r3, r9.getJobs());
        this.b.p = true;
        FLogger r7 = FLogger.a;
        StringBuilder r10 = new StringBuilder("loadLocalRecommendJobs success reason=");
        r10.append(this.c);
        r10.append(" count=");
        r10.append(r9.getJobs().size());
        r10.append(" hasMore=");
        r10.append(r9.getHasMore());
        r10.append(" statuses=");
        int r11 = ChatJobListLoader.t;
        r10.append(ChatJobListLoader.a.b(r9.getJobs()));
        r7.i("ChatJobListLoader", r10.toString());
        if (r9.getHasMore() == false) goto L17;
        r7.e("ChatJobListLoader", "loadLocalRecommendJobs hasMore reason=" + this.c + " count=" + r9.getJobs().size());
    L17:
        ChatJobListLoader.a(this.b, this.c);
    }

    public t(int r1, ChatJobListLoader r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
