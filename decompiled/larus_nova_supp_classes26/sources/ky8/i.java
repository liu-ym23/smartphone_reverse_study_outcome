package ky8;

import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final InstructionTab a;
    public final OptionItem b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final long g;
    public final int h;
    public final List<InstructionTab> i;

    public i() {
        this(null, null, null, false, null, null, 0, null, 511);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        InstructionTab r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        OptionItem r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.e;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        long r18 = this.g;
        int r19 = (((r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31) + this.h) * 31;
        List<InstructionTab> r20 = this.i;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r19 + r1;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "InputDataSnapShot(clickInstructionTab=" + this.a + ", clickOptionItem=" + this.b + ", inputContent=" + this.c + ", isRegenerate=" + this.d + ", scene=" + this.e + ", instructionTraceContent=" + this.f + ", createTime=" + this.g + ", generateType=" + this.h + ", instructionTabList=" + this.i + ')';
    }

    public final String a() {
        String r0 = this.c;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L21;
        OptionItem r1 = this.b;
        if (r1 == null) goto L13;
        r0 = r1.getMessageText();
        goto L21
    L13:
        InstructionTab r3 = this.a;
        if (r3 == null) goto L20;
        OptionItem r4 = r3.getSingleOption();
        if (r4 == null) goto L18;
        r0 = r4.getMessageText();
    L19:
        if (r0 != null) goto L21;
    L18:
        r0 = null;
    L20:
        r0 = "";
    L21:
        if (r0 != null) goto L24;
        return "";
    L24:
        return r0;
    L8:
        r2 = false;
        goto L9
    }

    public final boolean c() {
        InstructionTab r0 = this.a;
        if (r0 == null) goto L10;
        Integer r1 = r0.getTabType();
        if (r1 == null) goto L10;
        if (r1.intValue() != 4) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L25;
        InstructionTab r3 = this.a;
        if (r3 == null) goto L20;
        Integer r4 = r3.getTabType();
        if (r4 == null) goto L20;
        if (r4.intValue() != 3) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L26;
        return false;
    L26:
        return true;
    L20:
        r5 = false;
        goto L21
    L25:
        return true;
    L10:
        r2 = false;
        goto L11
    }

    public final Long b() {
        if (c() == false) goto L12;
        InstructionTab r0 = this.a;
        if (r0 == null) goto L9;
        OptionItem r1 = r0.getSingleOption();
        if (r1 == null) goto L9;
    L14:
        return Long.valueOf(r1.getId());
    L9:
        r1 = this.b;
        if (r1 != null) goto L14;
    L12:
        return null;
    }

    public i(InstructionTab r5, OptionItem r6, String r7, boolean r8, String r9, String r10, int r11, List r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r6 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r7 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r8 = false;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r9 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r10 = null;
    L21:
        if ((r13 & 64) == 0) goto L23;
        long r2 = System.currentTimeMillis();
    L25:
        if ((r13 & 128) == 0) goto L28;
        r11 = 1;
    L28:
        if ((r13 & 256) == 0) goto L30;
        r12 = null;
    L30:
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r2;
        this.h = r11;
        this.i = r12;
        return;
    L23:
        r2 = 0;
        goto L25
    }
}
