package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayInstanceApi;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ XplayCoreService a;

    public m(XplayCoreService r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        ExtraResponse r8 = (ExtraResponse) r7;
        int r0 = XplayLog.a;
        StringBuilder r1 = new StringBuilder("ask for switch guide resp, isShowGuide: ");
        Long r2 = null;
        if (r8 == null) goto L9;
        XplayApi.a r3 = (XplayApi.a) r8.data;
        if (r3 == null) goto L9;
        XplayApi.e r4 = r3.a();
        if (r4 == null) goto L9;
        Boolean r5 = Boolean.valueOf(r4.b());
    L10:
        r1.append(r5);
        r1.append(", duration: ");
        if (r8 == null) goto L17;
        XplayApi.a r6 = (XplayApi.a) r8.data;
        if (r6 == null) goto L17;
        XplayApi.e r9 = r6.a();
        if (r9 == null) goto L17;
        Long r11 = Long.valueOf(r9.a());
    L18:
        r1.append(r11);
        XplayLog.c("XplayCoreService", r1.toString());
        if (r8 == null) goto L40;
        XplayApi.a r12 = (XplayApi.a) r8.data;
        if (r12 == null) goto L41;
        XplayApi.e r13 = r12.a();
        if (r13 != null) goto L25;
        return;
    L25:
        if (r13.b() != true) goto L43;
        XplayCoreService r14 = this.a;
        r14.getClass();
        XplayLog.c("XplayCoreService", "run guide player, state=" + r14.h + ", instance=" + r14.d);
        IXplayInstanceApi r15 = r14.d;
        if (r15 != null) goto L29;
    L33:
        XplayCoreService r16 = this.a;
        XplayApi.a r17 = (XplayApi.a) r8.data;
        if (r17 == null) goto L38;
        XplayApi.e r18 = r17.a();
        if (r18 == null) goto L38;
        r2 = Long.valueOf(r18.a());
    L38:
        r16.f = r2.longValue();
        return;
    L29:
        if (r15.isInitialized() != true) goto L33;
        if (r15.isGuidePlaying() == true) goto L33;
        r15.playGuideGame();
        goto L33
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L17:
        r11 = null;
    L9:
        r5 = null;
        goto L10
    }
}
