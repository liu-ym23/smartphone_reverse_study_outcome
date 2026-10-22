package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.MultiLinkBizBackupSeiExperimentUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b1 implements ye1.c {
    public final /* synthetic */ SeiCompositeWidget a;

    public b1(SeiCompositeWidget r1) {
        this.a = r1;
    }

    public final void onSei(String r6, ye1.a r7) {
        Intrinsics.checkNotNullParameter(r6, "seiStr");
        Intrinsics.checkNotNullParameter(r7, "backupSeiInfo");
        SeiCompositeWidget r0 = this.a;
        int r1 = SeiCompositeWidget.v;
        r0.getClass();
        MultiLinkBizBackupSeiExperimentUtils r2 = MultiLinkBizBackupSeiExperimentUtils.INSTANCE;
        DataCenter r3 = ((Widget) r0).dataCenter;
        if (r3 == null) goto L5;
        Room r4 = com.bytedance.android.live.core.utils.z.o(r3);
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = r0.a;
        if (r5 == null) goto L9;
        boolean r8 = r5.dg();
    L11:
        if (r2.isTotalEnable(r2.getMultiLinkConfig(r4, r8)) == false) goto L25;
        int r9 = af1.a.a;
        af1.a.a("SeiCompositeWidget", r0.hashCode(), "call onSeiCallbackByBackup, " + r7 + ", sei = " + r6, false);
        gd0.k r10 = r0.zq();
        if (r10 == null) goto L15;
        r10.k(r6, r7);
    L15:
        iy.d r11 = r0.xq();
        if (r11 == null) goto L19;
        r11.k(r6, r7);
    L19:
        if (r0.p != null) goto L21;
        r0.p = ho1.a.m(r0.getComponentContext());
    L21:
        yh0.c r12 = r0.p;
        if (r12 == null) goto L26;
        r12.k(r6, r7);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        r8 = false;
        goto L11
    L5:
        r4 = null;
        goto L6
    }
}
