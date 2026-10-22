package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class CommonToastLayout extends FrameLayout {
    public a a;

    public interface a {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a r0 = this.a;
        if (r0 == null) goto L6;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.d0) r0).getClass();
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    }

    public void setOnDetachListener(a r1) {
        this.a = r1;
    }

    public CommonToastLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
