package androidx.room.jarjarred.org.antlr.v4.misc;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.unicode.UnicodeData;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class EscapeSequenceParsing {

    public static class Result {
        public final int codePoint;
        public final int parseLength;
        public final IntervalSet propertyIntervalSet;
        public final int startOffset;
        public final Type type;

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type CODE_POINT = null;
            public static final Type INVALID = null;
            public static final Type PROPERTY = null;

            static {
                Type r5 = new Type("INVALID", 0);
                INVALID = r5;
                Type r10 = new Type("CODE_POINT", 1);
                CODE_POINT = r10;
                Type r11 = new Type("PROPERTY", 2);
                PROPERTY = r11;
                $VALUES = new Type[]{r5, r10, r11};
            }

            private Type(String r5, int r10) {
                super(r5, r10);
            }

            public static Type valueOf(String r5) {
                return (Type) Enum.valueOf(Type.class, r5);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }
        }

        public Result(Type r5, int r10, IntervalSet r11, int r12, int r13) {
            this.type = r5;
            this.codePoint = r10;
            this.propertyIntervalSet = r11;
            this.startOffset = r12;
            this.parseLength = r13;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof Result) == true) goto L5;
            return false;
        L5:
            Result r10 = (Result) r5;
            if (this != r10) goto L9;
            return true;
        L9:
            if (Objects.equals(this.type, r10.type) == true) goto L11;
            return false;
        L11:
            if (Integer.valueOf(this.codePoint).equals(Integer.valueOf(r10.codePoint)) == true) goto L13;
            return false;
        L13:
            if (Objects.equals(this.propertyIntervalSet, r10.propertyIntervalSet) == true) goto L15;
            return false;
        L15:
            if (Integer.valueOf(this.parseLength).equals(Integer.valueOf(r10.parseLength)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.type, Integer.valueOf(this.codePoint), this.propertyIntervalSet, Integer.valueOf(this.parseLength)});
        }

        public String toString() {
            return String.format("%s type=%s codePoint=%d propertyIntervalSet=%s parseLength=%d", new Object[]{super.toString(), this.type, Integer.valueOf(this.codePoint), this.propertyIntervalSet, Integer.valueOf(this.parseLength)});
        }
    }

    public EscapeSequenceParsing() {
    }

    private static Result invalid(int r10, int r11) {
        return new Result(Result.Type.INVALID, 0, IntervalSet.EMPTY_SET, r10, (r11 - r10) + 1);
    }

    public static Result parseEscape(String r13, int r14) {
        if ((r14 + 2) > r13.length()) goto L75;
        if (r13.codePointAt(r14) != 92) goto L75;
        int r5 = r14 + 1;
        int r10 = r13.codePointAt(r5);
        int r11 = Character.charCount(r10) + r5;
        if (r10 != 117) goto L35;
        if ((r11 + 3) <= r13.length()) goto L14;
        return invalid(r14, r13.length() - 1);
    L14:
        if (r13.codePointAt(r11) != 123) goto L20;
        r11 = r11 + 1;
        int r12 = r13.indexOf(125, r11);
        if (r12 == (-1)) goto L18;
        int r15 = r12 + 1;
    L25:
        int r16 = CharSupport.parseHexValue(r13, r11, r12);
        if (r16 == (-1)) goto L33;
        if (r16 > 1114111) goto L33;
        return new Result(Result.Type.CODE_POINT, r16, IntervalSet.EMPTY_SET, r14, r15 - r14);
    L33:
        return invalid(r14, r14 + 5);
    L18:
        return invalid(r14, r13.length() - 1);
    L20:
        r12 = r11 + 4;
        if (r12 > r13.length()) goto L23;
        r15 = r12;
        goto L25
    L23:
        return invalid(r14, r13.length() - 1);
    L35:
        if (r10 == 112) goto L54;
        if (r10 == 80) goto L54;
        int[] r17 = CharSupport.ANTLRLiteralEscapedCharValue;
        if (r10 >= r17.length) goto L52;
        int r18 = r17[r10];
        if (r18 == 0) goto L43;
    L49:
        int r19 = r11 - r14;
        return new Result(Result.Type.CODE_POINT, r18, IntervalSet.EMPTY_SET, r14, r19);
    L43:
        if (r10 != 93) goto L45;
    L48:
        r18 = r10;
        goto L49
    L45:
        if (r10 == 45) goto L48;
        return invalid(r14, r5);
    L52:
        return invalid(r14, r13.length() - 1);
    L54:
        if ((r11 + 3) <= r13.length()) goto L58;
        return invalid(r14, r13.length() - 1);
    L58:
        if (r13.codePointAt(r11) != 123) goto L60;
        int r20 = r13.indexOf(125, r11);
        if (r20 == (-1)) goto L64;
        IntervalSet r110 = UnicodeData.getPropertyCodePoints(r13.substring(r11 + 1, r20));
        if (r110 == null) goto L68;
        int r21 = r20 + 1;
        if (r10 != 80) goto L73;
        r110 = r110.complement(IntervalSet.COMPLETE_CHAR_SET);
    L73:
        return new Result(Result.Type.PROPERTY, -1, r110, r14, r21 - r14);
    L68:
        return invalid(r14, r20);
    L64:
        return invalid(r14, r13.length() - 1);
    L60:
        return invalid(r14, r11);
    L75:
        return invalid(r14, r13.length() - 1);
    }
}
