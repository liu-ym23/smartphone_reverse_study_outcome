package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NestedMenuRightModel {
    public boolean a;
    public final Style b;
    public String c;
    public final Integer d;
    public final Integer e;
    public final String f;
    public final Integer g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestedMenuRightModel$Style;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "SWITCH", "BUTTON", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum Style extends Enum<Style> {
        public static final Style BUTTON = null;
        public static final Style NORMAL = null;
        public static final Style SWITCH = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("NORMAL", 0);
            NORMAL = r0;
            Style r1 = new Style("SWITCH", 1);
            SWITCH = r1;
            Style r3 = new Style("BUTTON", 2);
            BUTTON = r3;
            Style[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public NestedMenuRightModel() {
        this(null, null, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NestedMenuRightModel) == true) goto L8;
        return false;
    L8:
        NestedMenuRightModel r6 = (NestedMenuRightModel) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        int r2 = 0;
        int r3 = (((((r1 + 0) * 31) + 0) * 31) + 0) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.g;
        if (r16 == null) goto L27;
        r2 = r16.hashCode();
    L27:
        return r15 + r2;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "NestedMenuRightModel(selected=" + this.a + ", style=" + this.b + ", buttonBackgroundColor=null, buttonTitleColor=null, buttonPressColor=null, text=" + this.c + ", textColor=" + this.d + ", iconRes=" + this.e + ", iconUrl=" + this.f + ", textColorValue=" + this.g + ')';
    }

    public NestedMenuRightModel(String r4, Integer r5, String r6, Integer r7, int r8) {
        if ((r8 & 2) == 0) goto L5;
        Style r0 = Style.NORMAL;
    L7:
        if ((r8 & 32) == 0) goto L10;
        r4 = null;
    L10:
        if ((r8 & 128) == 0) goto L13;
        r5 = null;
    L13:
        if ((r8 & 256) == 0) goto L16;
        r6 = null;
    L16:
        if ((r8 & 512) == 0) goto L18;
        r7 = null;
    L18:
        Intrinsics.checkNotNullParameter(r0, "style");
        this.a = false;
        this.b = r0;
        this.c = r4;
        this.d = null;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
