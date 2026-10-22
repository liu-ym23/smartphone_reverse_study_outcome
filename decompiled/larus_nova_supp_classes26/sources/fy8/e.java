package fy8;

import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final String b;
    public final List<UIInstructionTab> c;

    public e() {
        this(null, null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.c.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasEditorUIData(prompt=" + this.a + ", hint=" + this.b + ", uiInstructionTabList=" + this.c + ')';
    }

    public e(String r3, List r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = new ArrayList();
    L8:
        Intrinsics.checkNotNullParameter(r4, "uiInstructionTabList");
        this.a = r3;
        this.b = null;
        this.c = r4;
    }
}
