package com.larus.bmhome.chat.standarduikit.interaction.view;

import com.larus.bmhome.share.panel.ShareType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class InteractionQuickReplyViewInput {
    public final String a;
    public final String b;
    public final Integer c;
    public final CharSequence d;
    public final CharSequence e;
    public final CharSequence f;
    public final CharSequence g;
    public final List<Button> h;
    public final Integer i;

    public static final class Button {
        public final CharSequence a;
        public final Style b;
        public final boolean c;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewInput$Button$Style;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Style extends Enum<Style> {
            public static final Style PRIMARY = null;
            public static final Style SECONDARY = null;
            public static final /* synthetic */ Style[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<Style> getEntries() {
                return b;
            }

            static {
                Style r0 = new Style("PRIMARY", 0);
                PRIMARY = r0;
                Style r1 = new Style("SECONDARY", 1);
                SECONDARY = r1;
                Style[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
            }

            public static Style[] values() {
                return (Style[]) a.clone();
            }

            public static Style valueOf(String r1) {
                return (Style) a.a(Style.class, r1);
            }

            public Style(String r1, int r2) {
                super(r1, r2);
            }
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Button) == true) goto L8;
            return false;
        L8:
            Button r6 = (Button) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Button(text=" + this.a + ", style=" + this.b + ", enabled=" + this.c + ')';
        }

        public Button(CharSequence r2, Style r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            Intrinsics.checkNotNullParameter(r3, "style");
            this.a = r2;
            this.b = r3;
            this.c = true;
        }
    }

    public InteractionQuickReplyViewInput() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InteractionQuickReplyViewInput) == true) goto L8;
        return false;
    L8:
        InteractionQuickReplyViewInput r6 = (InteractionQuickReplyViewInput) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
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
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        CharSequence r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        CharSequence r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        CharSequence r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        CharSequence r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((r18 + r20) * 31) + this.h.hashCode()) * 31;
        Integer r22 = this.i;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionQuickReplyViewInput(iconUrlLight=" + this.a + ", iconUrlDark=" + this.b + ", iconRes=" + this.c + ", label=" + this.d + ", title=" + this.e + ", description=" + this.f + ", folderName=" + this.g + ", buttons=" + this.h + ", loadingIndex=" + this.i + ')';
    }

    public InteractionQuickReplyViewInput(String r3, String r4, CharSequence r5, CharSequence r6, CharSequence r7, CharSequence r8, List r9, Integer r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 64) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 128) == 0) goto L24;
        r9 = CollectionsKt.emptyList();
    L24:
        if ((r11 & 256) == 0) goto L26;
        r10 = null;
    L26:
        Intrinsics.checkNotNullParameter(r9, "buttons");
        this.a = r3;
        this.b = r4;
        this.c = null;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
