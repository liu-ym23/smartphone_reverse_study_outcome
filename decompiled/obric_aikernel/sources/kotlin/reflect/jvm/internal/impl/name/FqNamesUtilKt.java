package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FqNamesUtilKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[State.values().length];
            r10[State.BEGINNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[State.AFTER_DOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[State.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public static final <V> V findValueForMostSpecificFqname(FqName r10, Map<FqName, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "values");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> r13 = r11.entrySet().iterator();
    L3:
        boolean r14 = true;
        if (r13.hasNext() == false) goto L14;
        Map.Entry<FqName, ? extends V> r15 = r13.next();
        FqName r16 = r15.getKey();
        if (Intrinsics.areEqual(r10, r16) == false) goto L8;
    L11:
        if (r14 == false) goto L3;
        r12.put(r15.getKey(), r15.getValue());
        goto L3
    L8:
        if (isChildOf(r10, r16) == true) goto L11;
        r14 = false;
        goto L11
    L14:
        if ((!r12.isEmpty()) == true) goto L17;
        r12 = null;
    L17:
        if (r12 != null) goto L19;
        return null;
    L19:
        Iterator r17 = r12.entrySet().iterator();
        if (r17.hasNext() == true) goto L22;
        Object r18 = null;
    L31:
        Map.Entry r19 = (Map.Entry) r18;
        if (r19 != null) goto L34;
        return null;
    L34:
        return (V) r19.getValue();
    L22:
        r18 = r17.next();
        if (r17.hasNext() == false) goto L31;
        int r20 = tail((FqName) ((Map.Entry) r18).getKey(), r10).asString().length();
    L26:
        Object r21 = r17.next();
        int r22 = tail((FqName) ((Map.Entry) r21).getKey(), r10).asString().length();
        if (r20 <= r22) goto L30;
        r18 = r21;
        r20 = r22;
    L30:
        if (r17.hasNext() == true) goto L26;
        goto L31
    }

    public static final boolean isChildOf(FqName r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        return Intrinsics.areEqual(parentOrNull(r10), r11);
    }

    private static final boolean isSubpackageOf(String r10, String r11) {
        if (StringsKt.startsWith$default(r10, r11, false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r10.charAt(r11.length()) != '.') goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean isSubpackageOf(FqName r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        if (Intrinsics.areEqual(r10, r11) == false) goto L6;
        return true;
    L6:
        if (r11.isRoot() == true) goto L11;
        String r12 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r12, "this.asString()");
        String r13 = r11.asString();
        Intrinsics.checkNotNullExpressionValue(r13, "packageName.asString()");
        return isSubpackageOf(r12, r13);
    L11:
        return true;
    }

    public static final boolean isValidJavaFqName(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        State r11 = State.BEGINNING;
        int r12 = 0;
    L7:
        if (r12 >= r10.length()) goto L27;
        char r13 = r10.charAt(r12);
        int r14 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r14 == 1) goto L22;
        if (r14 == 2) goto L22;
        if (r14 != 3) goto L25;
        if (r13 != '.') goto L19;
        r11 = State.AFTER_DOT;
        goto L25
    L19:
        if (Character.isJavaIdentifierPart(r13) == true) goto L25;
        return false;
    L25:
        r12 = r12 + 1;
    L22:
        if (Character.isJavaIdentifierPart(r13) == false) goto L23;
        r11 = State.MIDDLE;
        goto L25
    L23:
        return false;
    L27:
        if (r11 != State.AFTER_DOT) goto L29;
        return false;
    L29:
        return true;
    }

    public static final FqName parentOrNull(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isRoot() == false) goto L6;
        return null;
    L6:
        return r10.parent();
    }

    public static final FqName tail(FqName r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (isSubpackageOf(r10, r11) == true) goto L5;
        return r10;
    L5:
        if (r11.isRoot() == false) goto L8;
        return r10;
    L8:
        if (Intrinsics.areEqual(r10, r11) == false) goto L10;
        FqName r12 = FqName.ROOT;
        Intrinsics.checkNotNullExpressionValue(r12, "ROOT");
        return r12;
    L10:
        String r13 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r13, "asString()");
        String r14 = r13.substring(r11.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        return new FqName(r14);
    }
}
