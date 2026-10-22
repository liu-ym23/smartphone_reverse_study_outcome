package com.bytedance.android.live.room.api.record;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends i<d90.d> {
    public e() {
    }

    public final Class<? extends Widget> c() {
        return LiveRecordMonitorServiceWidget.class;
    }

    public final boolean B(h70.b r6) {
        d90.d r7 = (d90.d) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        LiveScreenRecordGuideConfig.a r0 = LiveScreenRecordGuideConfig.c;
        DataCenter r8 = r7.h;
        r0.getClass();
        if (r8 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r8 == null) goto L16;
        IRoom r3 = gb2.a.e(r8);
        if (r3 == null) goto L16;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L16;
        if (r4.isEnablePinHighlight() != true) goto L16;
        boolean r5 = true;
    L18:
        if (LiveScreenRecordGuideConfig.a.b().c() == false) goto L26;
        if (r5 == false) goto L27;
        if (r2 == false) goto L28;
        if (r8 != null) goto L23;
        return false;
    L23:
        if (gb2.a.c(r8, true) != true) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L16:
        r5 = false;
        goto L18
    L5:
        if (gb2.a.a(r8, false) == true) goto L7;
        r2 = true;
        goto L8
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.d2;
    }
}
