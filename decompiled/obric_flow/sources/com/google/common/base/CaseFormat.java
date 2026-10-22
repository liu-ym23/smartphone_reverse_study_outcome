package com.google.common.base;

import androidx.room.writer.DaoWriter;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum CaseFormat extends Enum<CaseFormat> {
    public static final CaseFormat LOWER_CAMEL = null;
    public static final CaseFormat LOWER_HYPHEN = null;
    public static final CaseFormat LOWER_UNDERSCORE = null;
    public static final CaseFormat UPPER_CAMEL = null;
    public static final CaseFormat UPPER_UNDERSCORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CaseFormat[] f8640a = null;
    private final g wordBoundary;
    private final String wordSeparator;

    public static final class StringConverter extends m implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public StringConverter(CaseFormat r5, CaseFormat r10) {
            r5.getClass();
            this.sourceFormat = r5;
            r10.getClass();
            this.targetFormat = r10;
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ Object doBackward(Object r5) {
            return doBackward((String) r5);
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ Object doForward(Object r5) {
            return doForward((String) r5);
        }

        @Override // com.google.common.base.m, com.google.common.base.q
        public boolean equals(Object r5) {
            if ((r5 instanceof StringConverter) == false) goto L10;
            StringConverter r10 = (StringConverter) r5;
            if (this.sourceFormat.equals(r10.sourceFormat) == true) goto L7;
            return false;
        L7:
            if (this.targetFormat.equals(r10.targetFormat) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r5 = this.sourceFormat.hashCode();
            return this.targetFormat.hashCode() ^ r5;
        }

        public String toString() {
            String r5 = String.valueOf(this.sourceFormat);
            String r10 = String.valueOf(this.targetFormat);
            int r11 = r5.length() + 14;
            StringBuilder r12 = new StringBuilder(r10.length() + r11);
            r12.append(r5);
            r12.append(".converterTo(");
            r12.append(r10);
            r12.append(")");
            return r12.toString();
        }

        public String doBackward(String r5) {
            return this.targetFormat.to(this.sourceFormat, r5);
        }

        public String doForward(String r5) {
            return this.sourceFormat.to(this.targetFormat, r5);
        }
    }

    static {
        final int r5 = 4;
        final int r10 = 3;
        final int r11 = 2;
        final int r12 = 1;
        final int r13 = 0;
        final e r14 = new e('-', 0);
        final String r15 = "LOWER_HYPHEN";
        final String r16 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        CaseFormat r17 = new AnonymousClass1(r15, r13, r14, r16);
        LOWER_HYPHEN = r17;
        final e r18 = new e('_', 0);
        final String r19 = "LOWER_UNDERSCORE";
        final String r110 = "_";
        CaseFormat r20 = new AnonymousClass2(r19, r12, r18, r110);
        LOWER_UNDERSCORE = r20;
        final c r21 = new d();
        final String r111 = "LOWER_CAMEL";
        final String r112 = "";
        CaseFormat r22 = new AnonymousClass3(r111, r11, r21, r112);
        LOWER_CAMEL = r22;
        final c r113 = new d();
        final String r114 = "UPPER_CAMEL";
        CaseFormat r23 = new AnonymousClass4(r114, r10, r113, r112);
        UPPER_CAMEL = r23;
        final e r115 = new e('_', 0);
        final String r24 = "UPPER_UNDERSCORE";
        CaseFormat r116 = new AnonymousClass5(r24, r5, r115, r110);
        UPPER_UNDERSCORE = r116;
        f8640a = new CaseFormat[]{r17, r20, r22, r23, r116};
    }

    public CaseFormat(String r5, int r10, g r11, String r12, AnonymousClass1 r13) {
        super(r5, r10);
        this.wordBoundary = r11;
        this.wordSeparator = r12;
    }

    public static String access$100(String r5) {
        if (r5.isEmpty() == true) goto L12;
        char r10 = r5.charAt(0);
        if (r10 >= 'a') goto L8;
    L10:
        String r11 = b0.D(r5.substring(1));
        StringBuilder r12 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(1, r11));
        r12.append(r10);
        r12.append(r11);
        return r12.toString();
    L8:
        if (r10 > 'z') goto L10;
        r10 = (char) (r10 ^ ' ');
        goto L10
    L12:
        return r5;
    }

    public static CaseFormat valueOf(String r5) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, r5);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) f8640a.clone();
    }

    public String convert(CaseFormat r10, String r11) {
        StringBuilder r5 = null;
        int r12 = 0;
        int r13 = -1;
    L3:
        g r14 = this.wordBoundary;
        r13 = r13 + 1;
        r14.getClass();
        int r15 = r11.length();
        b0.o(r13, r15);
    L4:
        if (r13 >= r15) goto L9;
        if (r14.b(r11.charAt(r13)) == true) goto L10;
        r13 = r13 + 1;
    L10:
        if (r13 == (-1)) goto L15;
        if (r12 != 0) goto L13;
        r5 = new StringBuilder((r10.wordSeparator.length() * 4) + r11.length());
        r5.append(r10.normalizeFirstWord(r11.substring(r12, r13)));
    L14:
        r5.append(r10.wordSeparator);
        r12 = this.wordSeparator.length() + r13;
        goto L3
    L13:
        Objects.requireNonNull(r5);
        r5.append(r10.normalizeWord(r11.substring(r12, r13)));
        goto L14
    L15:
        if (r12 == 0) goto L24;
        Objects.requireNonNull(r5);
        r5.append(r10.normalizeWord(r11.substring(r12)));
        return r5.toString();
    L24:
        return r10.normalizeFirstWord(r11);
    L9:
        r13 = -1;
        goto L10
    }

    public m converterTo(CaseFormat r5) {
        return new StringConverter(this, r5);
    }

    public String normalizeFirstWord(String r5) {
        return normalizeWord(r5);
    }

    public abstract String normalizeWord(String r5);

    public final String to(CaseFormat r5, String r10) {
        r5.getClass();
        r10.getClass();
        if (r5 != this) goto L6;
        return r10;
    L6:
        return convert(r5, r10);
    }
}
