package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.c b;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.g c;

    public p(MultiLinkUniversalAnimWidget r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        ALogger.i("MultiLinkEffect.Widget", "startAnim.timeout, try kill it.giftInfo:" + this.b + ",curGiftInfo:" + this.a.p);
        String r7 = this.b.a;
        if (this.a.Zg(r7) == false) goto L21;
        MultiLinkUniversalAnimWidget r1 = this.a;
        r1.getClass();
        ALogger.i("MultiLinkEffect.Widget", "stopAnim,curGiftInfo:" + r1.p + ",animationId:" + r7);
        if (r7.length() != 0) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L16;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2 = r1.p;
        if (r2 == null) goto L13;
        String r3 = r2.a;
    L15:
        if (Intrinsics.areEqual(r7, r3) == true) goto L16;
    L17:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r8 = this.c;
        if (r8 == null) goto L22;
        r8.c(this.b, TaskState.COMPLETE);
        return;
    L22:
        return;
    L13:
        r3 = null;
    L16:
        r1.j = false;
        MultiLinkUniversalAnimWidget.yq(r1, r7, false, 2);
        r1.Bq();
        r1.p = null;
        goto L17
    L7:
        r0 = false;
        goto L9
    }
}
