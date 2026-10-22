package cs1;

import android.view.MotionEvent;
import com.bytedance.android.livesdk.tetris.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {

    public interface a {
        void c(MotionEvent r1);
    }

    void a(e r1);

    void b(e r1);

    MotionEvent c();

    boolean d(MotionEvent r1);

    float getViewTouchSlop();
}
