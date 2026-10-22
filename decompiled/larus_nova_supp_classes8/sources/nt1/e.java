package nt1;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.dislike.layout.ShareFansItemLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements View.OnTouchListener {
    public final /* synthetic */ ShareFansItemLayout a;

    public e(ShareFansItemLayout r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        int r5 = r4.getAction();
        if (r5 == 0) goto L9;
        if (r5 != 1) goto L6;
    L8:
        ShareFansItemLayout.a(this.a, false, r3);
    L10:
        return false;
    L6:
        if (r5 == 3) goto L8;
    L9:
        ShareFansItemLayout.a(this.a, true, r3);
        goto L10
    }
}
