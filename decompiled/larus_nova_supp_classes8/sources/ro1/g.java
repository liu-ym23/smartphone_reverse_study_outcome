package ro1;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnTouchListener {
    public final /* synthetic */ BaseBannerWidget a;

    public g(BaseBannerWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (r2 == null) goto L6;
        this.a.g.onTouchEvent(r2);
        return false;
    L6:
        return false;
    }
}
