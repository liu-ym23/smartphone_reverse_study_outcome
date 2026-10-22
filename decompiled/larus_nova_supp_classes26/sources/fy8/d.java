package fy8;

import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final CanvasEditorEventType a;
    public final String b;
    public final InstructionTab c;
    public final OptionItem d;
    public final a e;
    public final m f;

    public d() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        InstructionTab r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        OptionItem r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        a r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + 0) * 31;
        m r11 = this.f;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasEditorEvent(eventType=" + this.a + ", prompt=" + this.b + ", instructionTab=" + this.c + ", optionItem=" + this.d + ", bottomInsetUpdateInfo=" + this.e + ", instructionRenderInfo=null, selectorPanelStatusChangeInfo=" + this.f + ')';
    }

    public d(CanvasEditorEventType r3, String r4, InstructionTab r5, OptionItem r6, a r7, m r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = CanvasEditorEventType.NONE;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r9 & 64) == 0) goto L20;
        r8 = null;
    L20:
        Intrinsics.checkNotNullParameter(r3, "eventType");
        Intrinsics.checkNotNullParameter(r4, "prompt");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
