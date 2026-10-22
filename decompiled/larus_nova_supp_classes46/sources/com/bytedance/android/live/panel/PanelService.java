package com.bytedance.android.live.panel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.panel.panelobserver.PanelCoverObserver;
import com.bytedance.android.live.room.api.panel.IPanelService;
import com.bytedance.android.live.room.api.panel.c;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.zi0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/panel/PanelService;", "Lcom/bytedance/android/live/room/api/panel/IPanelService;", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "createPanelManager", "roomContext", "Lcom/bytedance/android/live/room/api/panel/c;", "getPanelManager", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PanelService implements IPanelService {
    public PanelService() {
    }

    public DataContext createPanelManager(DataContext r3) {
        Intrinsics.checkNotNullParameter(r3, "dataContext");
        Lazy r4 = PanelSetting.a;
        zi0 r5 = zi0.a;
        Integer r0 = (Integer) r5.getValue();
        boolean r1 = true;
        if (r0 != null) goto L6;
    L7:
        Integer r6 = (Integer) r5.getValue();
        if (r6 != null) goto L11;
    L13:
        r1 = false;
    L14:
        if (r1 == true) goto L16;
    L22:
        ALogger.i(PanelManager.TAG, "disable PanelManager");
        return null;
    L16:
        if (PadConfigUtils.c() == true) goto L22;
        if (FoldScreenUtils.f() == true) goto L22;
        PanelManager r7 = new PanelManager();
        r7.init();
        r7.registerPanelObserver(new PanelCoverObserver());
        return r7;
    L11:
        if (r6.intValue() != 2) goto L13;
    L6:
        if (r0.intValue() == 1) goto L14;
        goto L7
    }

    public c getPanelManager(DataContext r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        DataContext r1 = null;
        if ((r3 instanceof RoomContext) == true) goto L5;
        r3 = null;
    L5:
        RoomContext r4 = (RoomContext) r3;
        if (r4 == null) goto L10;
        j r5 = r4.getPanelManager();
        if (r5 == null) goto L10;
        DataContext r6 = (DataContext) r5.getValue();
    L12:
        if ((r6 instanceof c) == false) goto L16;
        r1 = r6;
    L16:
        return (c) r1;
    L10:
        r6 = null;
        goto L12
    }

    public c getPanelManager(DataCenter r2, long r3) {
        RoomContext.Companion.getClass();
        RoomContext r4 = RoomContext.a.a(r2, r3);
        DataContext r5 = null;
        if (r4 == null) goto L7;
        j r6 = r4.getPanelManager();
        if (r6 == null) goto L7;
        DataContext r7 = (DataContext) r6.getValue();
    L9:
        if ((r7 instanceof c) == false) goto L13;
        r5 = r7;
    L13:
        return (c) r5;
    L7:
        r7 = null;
        goto L9
    }
}
