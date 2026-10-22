package nt1;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.dislike.layout.IMContactLayoutV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements View.OnTouchListener {
    public final /* synthetic */ IMContactLayoutV2 a;

    public a(IMContactLayoutV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        int r5 = r4.getAction();
        if (r5 == 0) goto L9;
        if (r5 != 1) goto L6;
    L8:
        IMContactLayoutV2.a(this.a, false, r3);
    L10:
        return false;
    L6:
        if (r5 == 3) goto L8;
    L9:
        IMContactLayoutV2.a(this.a, true, r3);
        goto L10
    }
}
