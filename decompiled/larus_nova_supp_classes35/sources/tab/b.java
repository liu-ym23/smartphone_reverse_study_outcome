package tab;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {
    public final WheelView a;

    public b(WheelView r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r8, MotionEvent r9, float r10, float r11) {
        WheelView r12 = this.a;
        r12.a();
        r12.I = r12.d.scheduleWithFixedDelay(new sab.a(r12, r11), 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
