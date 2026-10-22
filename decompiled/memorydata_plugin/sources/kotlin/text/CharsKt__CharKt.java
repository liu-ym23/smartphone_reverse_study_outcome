package kotlin.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public CharsKt__CharKt() {
    }

    public static final char digitToChar(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L11;
        return (char) (r3 + 48);
    L11:
        throw new IllegalArgumentException("Int " + r3 + " is not a decimal digit");
    L5:
        if (r3 >= 10) goto L7;
        r0 = true;
        goto L7
    }

    public static final char digitToChar(int r3, int r4) {
        boolean r0 = false;
        if (2 <= r4) goto L5;
    L7:
        if (r0 == false) goto L19;
        if (r3 < 0) goto L17;
        if (r3 >= r4) goto L17;
        if (r3 >= 10) goto L13;
        int r5 = r3 + 48;
    L15:
        return (char) r5;
    L13:
        r5 = ((char) (r3 + 65)) - '\n';
    L17:
        throw new IllegalArgumentException("Digit " + r3 + " does not represent a valid digit in radix " + r4);
    L19:
        throw new IllegalArgumentException("Invalid radix: " + r4 + ". Valid radix values are in range 2..36");
    L5:
        if (r4 >= 37) goto L7;
        r0 = true;
        goto L7
    }

    public static final int digitToInt(char r3) {
        int r0 = CharsKt.digitOf(r3, 10);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Char " + r3 + " is not a decimal digit");
    }

    public static final int digitToInt(char r3, int r4) {
        Integer r0 = CharsKt.digitToIntOrNull(r3, r4);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        throw new IllegalArgumentException("Char " + r3 + " is not a digit in the given radix=" + r4);
    }

    public static final Integer digitToIntOrNull(char r2) {
        Integer r3 = Integer.valueOf(CharsKt.digitOf(r2, 10));
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public static final Integer digitToIntOrNull(char r1, int r2) {
        CharsKt.checkRadix(r2);
        Integer r3 = Integer.valueOf(CharsKt.digitOf(r1, r2));
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L10;
        return null;
    L10:
        return r3;
    L5:
        r4 = false;
        goto L6
    }

    public static final boolean equals(char r2, char r3, boolean r4) {
        if (r2 != r3) goto L6;
        return true;
    L6:
        if (r4 == true) goto L8;
        return false;
    L8:
        char r5 = Character.toUpperCase(r2);
        char r6 = Character.toUpperCase(r3);
        if (r5 != r6) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r5) != Character.toLowerCase(r6)) goto L14;
        return true;
    L14:
        return false;
    }

    public static /* synthetic */ boolean equals$default(char r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return CharsKt.equals(r0, r1, r2);
    }

    public static final boolean isSurrogate(char r2) {
        if (55296 <= r2) goto L5;
        return false;
    L5:
        if (r2 >= 57344) goto L9;
        return true;
    L9:
        return false;
    }

    private static final String plus(char r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        return r1 + r2;
    }

    public static final String titlecase(char r0) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(r0);
    }
}
