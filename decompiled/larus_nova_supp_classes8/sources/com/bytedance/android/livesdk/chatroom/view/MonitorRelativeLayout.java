package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.log.b0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class MonitorRelativeLayout extends RelativeLayout {

    public interface a {
    }

    public void setOnSizeChangeListener(a r1) {
    }

    public MonitorRelativeLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public void setVisibility(int r4) {
        super.setVisibility(r4);
        if (r4 == 0) goto L6;
        b0 r0 = b0.o();
        String r5 = "on Text message Widget Container visibility set to  : " + r4 + " by" + ThreadMethodProxy.currentThread().getStackTrace()[0].getMethodName();
        r0.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_comment", r5);
        return;
    }

    public MonitorRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r3, int r4) {
        super.onVisibilityChanged(r3, r4);
        if (r4 == 0) goto L6;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_comment", "on Text message Widget Container visibility changed : " + r4);
        return;
    }

    public MonitorRelativeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }
}
