package fy8;

import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import com.larus.canvas.service.bean.InstructionTab;
import java.util.List;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface i extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(i r6, String r7, int r8) {
            if ((r8 & 2) == 0) goto L5;
            boolean r2 = true;
        L6:
            r6.t4(r7, r2, false, null, null);
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    e BZ();

    void J3();

    String K5();

    List<InstructionTab> Qp(List<UIInstructionTab> r1);

    void XX(j r1);

    void fC(boolean r1);

    a1 jY();

    void p2(String r1);

    void t4(String r1, boolean r2, boolean r3, Integer r4, Integer r5);

    String xs();
}
