package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d extends MessageHub, m {

    public static final class a {
        public static /* synthetic */ void a(d r6, String r7, int r8, String r9, boolean r10, int r11) {
            if ((r11 & 8) == 0) goto L5;
            boolean r4 = false;
        L6:
            r6.m(r7, r8, r9, r4, false);
            return;
        L5:
            r4 = r10;
            goto L6
        }
    }

    void a();

    void b(int r1);

    List<ILinkPlayerInfoBridge> c();

    List<LinkmicPositionItem> d();

    void f(com.bytedance.android.live.liveinteract.plantform.base.i.d r1);

    List<ILinkPlayerInfoBridge> getOnlineList();

    int getShowFrom();

    void j(boolean r1);

    void k(com.bytedance.android.live.liveinteract.plantform.base.i.d r1);

    void m(String r1, int r2, String r3, boolean r4, boolean r5);

    boolean n();

    ILivePlayerClient o(DataCenter r1);
}
