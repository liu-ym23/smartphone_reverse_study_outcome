package ms.bd.c;

import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.view.WindowCallbackWrapper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class w extends WindowCallbackWrapper {
    public int a;

    public w(Window.Callback r1) {
        super(r1);
    }

    public final boolean dispatchTouchEvent(MotionEvent r5) {
        int r0 = this.a;
        this.a = r0 + 1;
        if ((r0 % 4) != 0) goto L9;
        s0 r1 = new s0(r5.getDeviceId(), (int) r5.getX(), (int) r5.getY());
        ArrayList r2 = s2.c;
        if (r2.size() != 300) goto L7;
        ListProtector.remove(r2, 299);
    L7:
        ListProtector.add(r2, 0, r1);
    L9:
        return super.dispatchTouchEvent(r5);
    }
}
