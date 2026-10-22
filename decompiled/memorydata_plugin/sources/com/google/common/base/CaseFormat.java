package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum CaseFormat extends Enum<CaseFormat> {
    private static final /* synthetic */ CaseFormat[] $VALUES = null;
    public static final CaseFormat LOWER_CAMEL = null;
    public static final CaseFormat LOWER_HYPHEN = null;
    public static final CaseFormat LOWER_UNDERSCORE = null;
    public static final CaseFormat UPPER_CAMEL = null;
    public static final CaseFormat UPPER_UNDERSCORE = null;
    private final b wordBoundary;
    private final String wordSeparator;

    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        StringConverter(CaseFormat r3, CaseFormat r4) {
            this.sourceFormat = (CaseFormat) ZeusTransformUtils.preCheckCast(n.a(r3), CaseFormat.class, "com.obric.memorydata.plugin");
            this.targetFormat = (CaseFormat) ZeusTransformUtils.preCheckCast(n.a(r4), CaseFormat.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ String doBackward(String r3) {
            return doBackward2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(String r2) {
            return this.targetFormat.to(this.sourceFormat, r2);
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ String doForward(String r3) {
            return doForward2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public String doForward2(String r2) {
            return this.sourceFormat.to(this.targetFormat, r2);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, StringConverter.class) == false) goto L10;
            StringConverter r5 = (StringConverter) ZeusTransformUtils.preCheckCast(r4, StringConverter.class, "com.obric.memorydata.plugin");
            if (this.sourceFormat.equals(r5.sourceFormat) == true) goto L7;
            return false;
        L7:
            if (this.targetFormat.equals(r5.targetFormat) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.sourceFormat.hashCode();
            return this.targetFormat.hashCode() ^ r0;
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    private static /* synthetic */ CaseFormat[] $values() {
        return new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    static {
        final b r1 = b.a('-');
        final String r2 = "LOWER_HYPHEN";
        final int r3 = 0;
        final String r4 = "-";
        LOWER_HYPHEN = new AnonymousClass1(r2, r3, r1, r4);
        final b r5 = b.a('_');
        final String r6 = "LOWER_UNDERSCORE";
        final int r7 = 1;
        final String r8 = "_";
        LOWER_UNDERSCORE = new AnonymousClass2(r6, r7, r5, r8);
        final b r9 = b.a('A', 'Z');
        final String r10 = "LOWER_CAMEL";
        final int r11 = 2;
        final String r12 = "";
        LOWER_CAMEL = new AnonymousClass3(r10, r11, r9, r12);
        final b r13 = b.a('A', 'Z');
        final String r14 = "UPPER_CAMEL";
        final int r15 = 3;
        UPPER_CAMEL = new AnonymousClass4(r14, r15, r13, r12);
        final b r16 = b.a('_');
        final String r17 = "UPPER_UNDERSCORE";
        final int r18 = 4;
        UPPER_UNDERSCORE = new AnonymousClass5(r17, r18, r16, r8);
        $VALUES = $values();
    }

    private CaseFormat(String r1, int r2, b r3, String r4) {
        super(r1, r2);
        this.wordBoundary = r3;
        this.wordSeparator = r4;
    }

    /* synthetic */ CaseFormat(String r1, int r2, b r3, String r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ String access$100(String r0) {
        return firstCharOnlyToUpper(r0);
    }

    private static String firstCharOnlyToUpper(String r2) {
        if (r2.isEmpty() == false) goto L6;
        return r2;
    L6:
        return a.a(r2.charAt(0)) + a.a(r2.substring(1));
    }

    public static CaseFormat valueOf(String r2) {
        return (CaseFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(CaseFormat.class, r2), CaseFormat.class, "com.obric.memorydata.plugin");
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CaseFormat[].class, "com.obric.memorydata.plugin");
    }

    String convert(CaseFormat r8, String r9) {
        StringBuilder r1 = null;
        int r2 = 0;
        int r3 = -1;
    L3:
        r3 = this.wordBoundary.a(r9, r3 + 1);
        if (r3 == (-1)) goto L9;
        if (r2 != 0) goto L7;
        r1 = new StringBuilder(r9.length() + (r8.wordSeparator.length() * 4));
        r1.append(r8.normalizeFirstWord(r9.substring(r2, r3)));
    L8:
        r1.append(r8.wordSeparator);
        r2 = this.wordSeparator.length() + r3;
        goto L3
    L7:
        ((StringBuilder) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r1), StringBuilder.class, "com.obric.memorydata.plugin")).append(r8.normalizeWord(r9.substring(r2, r3)));
        goto L8
    L9:
        if (r2 != 0) goto L12;
        return r8.normalizeFirstWord(r9);
    L12:
        return ((StringBuilder) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r1), StringBuilder.class, "com.obric.memorydata.plugin")).append(r8.normalizeWord(r9.substring(r2))).toString();
    }

    public Converter<String, String> converterTo(CaseFormat r2) {
        return new StringConverter(this, r2);
    }

    String normalizeFirstWord(String r1) {
        return normalizeWord(r1);
    }

    abstract String normalizeWord(String r1);

    public final String to(CaseFormat r1, String r2) {
        n.a(r1);
        n.a(r2);
        if (r1 != this) goto L6;
        return r2;
    L6:
        return convert(r1, r2);
    }
}
