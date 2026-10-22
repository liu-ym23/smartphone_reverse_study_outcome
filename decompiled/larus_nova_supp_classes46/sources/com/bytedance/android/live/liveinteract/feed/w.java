package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ List b;

    public w(x r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        List r3 = this.b;
        if (r3 != null) goto L5;
        return;
    L5:
        DataCenter r9 = this.a.a.getFeedDataCenter();
        if (r9 == null) goto L9;
        r9.put("data_multi_lick_dynamic_event_change", new nh0.f("seat", null, r3, null, null, null, false, 246));
    L9:
        if ((!this.b.isEmpty()) == false) goto L11;
        this.a.a.E();
    L11:
        MultiLinkVoiceChatFeedView r0 = this.a.a;
        if (r0.g != null) goto L14;
        return;
    L14:
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r0.M1) == false) goto L18;
        qb r1 = r0.g;
        r0.g = null;
        r0.F(r1);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
