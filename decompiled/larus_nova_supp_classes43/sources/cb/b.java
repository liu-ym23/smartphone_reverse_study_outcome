package cb;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(LynxBaseUI r10, bb.a r11) {
        if ((r10 instanceof LynxUI) == false) goto L5;
        LynxUI r0 = (LynxUI) r10;
    L6:
        if (r0 == null) goto L9;
        r0.getView().setOnClickListener(new a(r0, r11));
    L9:
        if (r10.getChildren().size() <= 0) goto L17;
        int r1 = r10.getChildren().size();
        int r12 = 0;
    L11:
        if (r12 >= r1) goto L21;
        LynxBaseUI r13 = r10.getChildAt(r12);
        if (r13 == null) goto L16;
        a(r13, r11);
    L16:
        r12 = r12 + 1;
        goto L11
    L21:
        return;
    L17:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
