package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends fm3.b {
    public final /* synthetic */ LandscapeQuickRecordWidget d;

    public b(LandscapeQuickRecordWidget r1) {
        this.d = r1;
        super(0);
    }

    public final void a(View r3) {
        long r0 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickRecordBtnClick(r0);
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r4 = this.d.a;     // Catch: Exception -> L7
        if (r4 == null) goto L12;
        r4.a(r0);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        StringBuilder r1 = new StringBuilder("record fail: ");
        e.printStackTrace();
        r1.append(Unit.INSTANCE);
        ALogger.e("LandscapeQuickRecordWidget", r1.toString());
    }
}
