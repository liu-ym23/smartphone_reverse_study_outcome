package laa;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface d extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(d r1, float r2, boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0.0f;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = false;
        L8:
            r1.T8(r2, r3);
        }

        public static /* synthetic */ void b(d r2, Boolean r3, boolean r4, boolean r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = false;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = false;
        L11:
            r2.qT(r3, r4, r5);
        }

        public static /* synthetic */ void c(d r1, Float r2, boolean r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = true;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L11:
            r1.T7(r2, r3, r4);
        }

        public static /* synthetic */ void d(d r7, boolean r8, int r9, Float r10, boolean r11, boolean r12, PageStateChangedReason r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            boolean r1 = true;
        L7:
            if ((r14 & 4) == 0) goto L9;
            r10 = null;
        L9:
            Float r3 = r10;
            if ((r14 & 8) == 0) goto L12;
            boolean r4 = false;
        L14:
            if ((r14 & 16) == 0) goto L16;
            boolean r5 = false;
        L18:
            if ((r14 & 32) == 0) goto L20;
            r13 = PageStateChangedReason.OTHER;
        L20:
            r7.i2(r1, r9, r3, r4, r5, r13);
            return;
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L5:
            r1 = r8;
            goto L7
        }
    }

    void AN(hca.b r1);

    void Bn(AVKitDuplexState r1);

    void C0(boolean r1, boolean r2);

    void C00(boolean r1);

    void C1(boolean r1, boolean r2, String r3);

    void D50(String r1, String r2);

    boolean Da();

    void F0(boolean r1);

    void Gm(boolean r1);

    void H30(laa.a r1);

    void HU(hca.b r1);

    void Hd(boolean r1);

    boolean JY();

    void Ks(boolean r1);

    void MO(boolean r1);

    void Mx(laa.a r1);

    void Nq();

    void P5(int r1);

    void T7(Float r1, boolean r2, String r3);

    void T8(float r1, boolean r2);

    void U3(boolean r1);

    boolean Xh();

    RecyclerView Xw();

    void Yx(MotionEvent r1);

    void a7(boolean r1);

    boolean aF();

    String bl();

    void g8(int r1);

    ObricFloatChatPageState getPageState();

    void h1(boolean r1);

    void i2(boolean r1, int r2, Float r3, boolean r4, boolean r5, PageStateChangedReason r6);

    boolean isFullScreen();

    boolean isVisible();

    void j1(boolean r1);

    void le();

    int mb();

    void o2(int r1);

    void onScreenOff();

    void qT(Boolean r1, boolean r2, boolean r3);

    void refresh();

    void sN(int r1);

    void tV();

    void uv();

    void xK();

    void xw(String r1, boolean r2);

    void zf(boolean r1);
}
