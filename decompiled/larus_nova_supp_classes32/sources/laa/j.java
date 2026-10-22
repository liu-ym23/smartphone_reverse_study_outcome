package laa;

import android.widget.LinearLayout;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import java.util.Map;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface j extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(j r7, boolean r8, StateInfo r9, ObricSpecialInputScene r10, z0 r11, boolean r12, boolean r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            boolean r1 = true;
        L7:
            if ((r14 & 2) == 0) goto L9;
            StateInfo r2 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            ObricSpecialInputScene r3 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            z0 r4 = null;
        L19:
            if ((r14 & 16) == 0) goto L21;
            boolean r5 = false;
        L23:
            if ((r14 & 64) == 0) goto L25;
            boolean r6 = false;
        L26:
            r7.zI(r1, r2, r3, r4, r5, r6);
            return;
        L25:
            r6 = r13;
            goto L26
        L21:
            r5 = r12;
            goto L23
        L17:
            r4 = r11;
            goto L19
        L13:
            r3 = r10;
            goto L15
        L9:
            r2 = r9;
            goto L11
        L5:
            r1 = r8;
            goto L7
        }
    }

    void Fq(LinearLayout r1);

    void HY();

    boolean J70();

    b1 O4();

    void RC(u r1);

    boolean Re();

    void Z50(Message r1, String r2, Map<String, String> r3);

    void e00(u r1);

    void e90();

    void ed();

    b1 i80();

    void j1(boolean r1);

    boolean or();

    void ph();

    void td();

    void zI(boolean r1, StateInfo r2, ObricSpecialInputScene r3, z0 r4, boolean r5, boolean r6);
}
