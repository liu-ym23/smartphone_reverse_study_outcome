package h4;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static void a(LynxBaseUI r5, g4.a r10) {
        if ((r5 instanceof LynxUI) == false) goto L5;
        LynxUI r11 = (LynxUI) r5;
    L6:
        if (r11 == null) goto L9;
        r11.getView().setOnClickListener(new a(r11, r10));
    L9:
        if (r5.getChildren().size() <= 0) goto L17;
        int r12 = r5.getChildren().size();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L21;
        LynxBaseUI r14 = r5.getChildAt(r13);
        if (r14 == null) goto L16;
        a(r14, r10);
    L16:
        r13 = r13 + 1;
        goto L11
    L21:
        return;
    L17:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
