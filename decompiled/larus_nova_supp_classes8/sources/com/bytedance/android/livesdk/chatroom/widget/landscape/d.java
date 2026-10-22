package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LandscapeQuickRecordWidget a;

    public d(LandscapeQuickRecordWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        boolean r0 = true;
        if (((Boolean) r5).booleanValue() == false) goto L6;
        LandscapeQuickRecordWidget r6 = this.a;
        boolean r1 = LandscapeQuickRecordWidget.j;
        r6.xq(true);
        return;
    L6:
        if (PadConfigUtils.c() == false) goto L17;
        LandscapeQuickRecordWidget r7 = this.a;
        PadOrientation r2 = null;
        vr1.u r3 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, r7, 1);
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.n<PadOrientation> r4 = r3.w();
        if (r4 == null) goto L13;
        r2 = (PadOrientation) r4.getValue();
    L13:
        if (r2 != PadOrientation.LANDSCAPE) goto L16;
        r0 = false;
    L16:
        boolean r8 = LandscapeQuickRecordWidget.j;
        r7.xq(r0);
        return;
    L17:
        LandscapeQuickRecordWidget r9 = this.a;
        boolean r10 = LandscapeQuickRecordWidget.j;
        r9.xq(false);
    }
}
