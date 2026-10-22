package u32;

import android.graphics.PointF;
import android.view.MotionEvent;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface k {

    public static final class a {
        public static /* synthetic */ boolean a(k r9, MotionEvent r10, long r11, PointF r13, boolean r14, boolean r15, boolean r16, int r17) {
            if ((r17 & 4) == 0) goto L5;
            PointF r5 = null;
        L7:
            if ((r17 & 8) == 0) goto L9;
            boolean r6 = false;
        L11:
            if ((r17 & 16) == 0) goto L13;
            boolean r7 = false;
        L15:
            if ((r17 & 32) == 0) goto L17;
            boolean r8 = false;
        L19:
            return r9.Km(r10, r11, r5, r6, r7, r8);
        L17:
            r8 = r16;
            goto L19
        L13:
            r7 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }
    }

    void A9(int r1);

    boolean D8(MotionEvent r1);

    boolean Eg();

    boolean Km(MotionEvent r1, long r2, PointF r4, boolean r5, boolean r6, boolean r7);

    Observable<Long> Lo();

    long getDiggCount();

    boolean needPerformHapticFeedback();

    void xo();
}
