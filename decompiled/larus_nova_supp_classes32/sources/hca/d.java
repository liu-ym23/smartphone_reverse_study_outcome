package hca;

import android.view.ViewGroup;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface d extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(d r2, boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 4) == 0) goto L9;
            r3 = false;
        L9:
            r2.Ns(0, r0, r3);
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    void C1(boolean r1, boolean r2, String r3);

    int G1();

    boolean Hu();

    void Ns(int r1, boolean r2, boolean r3);

    void P5(int r1);

    void T7(Float r1, boolean r2, String r3);

    void T8(float r1, boolean r2);

    boolean UR(String r1);

    ObricFloatChatPageState getPageState();

    ViewGroup getTitleContainer();

    void i2(boolean r1, int r2, Float r3, boolean r4, boolean r5, PageStateChangedReason r6);

    void o2(int r1);
}
