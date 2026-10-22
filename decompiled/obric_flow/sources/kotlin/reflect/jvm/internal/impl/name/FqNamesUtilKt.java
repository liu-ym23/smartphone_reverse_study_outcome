package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFqNamesUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqNamesUtil.kt\norg/jetbrains/kotlin/name/FqNamesUtilKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n515#2:87\n500#2,6:88\n1#3:94\n*S KotlinDebug\n*F\n+ 1 FqNamesUtil.kt\norg/jetbrains/kotlin/name/FqNamesUtilKt\n*L\n73#1:87\n73#1:88,6\n*E\n"})
public final class FqNamesUtilKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[State.values().length];
            r5[State.BEGINNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[State.AFTER_DOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[State.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final <V> V findValueForMostSpecificFqname(FqName r5, Map<FqName, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "values");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<FqName, ? extends V> r13 = r12.next();
        FqName r14 = r13.getKey();
        if (Intrinsics.areEqual(r5, r14) == true) goto L9;
        if (isChildOf(r5, r14) == false) goto L4;
    L9:
        r11.put(r13.getKey(), r13.getValue());
        goto L4
    L11:
        if (r11.isEmpty() == false) goto L14;
        r11 = null;
    L14:
        if (r11 != null) goto L16;
        return null;
    L16:
        Iterator r15 = r11.entrySet().iterator();
        if (r15.hasNext() == true) goto L19;
        Object r16 = null;
    L28:
        Map.Entry r17 = (Map.Entry) r16;
        if (r17 != null) goto L31;
        return null;
    L31:
        return (V) r17.getValue();
    L19:
        r16 = r15.next();
        if (r15.hasNext() == false) goto L28;
        int r18 = tail((FqName) ((Map.Entry) r16).getKey(), r5).asString().length();
    L23:
        Object r19 = r15.next();
        int r20 = tail((FqName) ((Map.Entry) r19).getKey(), r5).asString().length();
        if (r18 <= r20) goto L27;
        r16 = r19;
        r18 = r20;
    L27:
        if (r15.hasNext() == true) goto L23;
        goto L28
    }

    public static final boolean isChildOf(FqName r5, FqName r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "packageName");
        return Intrinsics.areEqual(parentOrNull(r5), r10);
    }

    public static final boolean isSubpackageOf(FqName r5, FqName r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "packageName");
        if (Intrinsics.areEqual(r5, r10) == false) goto L6;
        return true;
    L6:
        if (r10.isRoot() == false) goto L9;
        return true;
    L9:
        return isSubpackageOf(r5.asString(), r10.asString());
    }

    public static final boolean isValidJavaFqName(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        State r5 = State.BEGINNING;
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L27;
        char r12 = r10.charAt(r11);
        int r13 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L22;
        if (r13 != 3) goto L25;
        if (r12 != '.') goto L19;
        r5 = State.AFTER_DOT;
        goto L25
    L19:
        if (Character.isJavaIdentifierPart(r12) == true) goto L25;
        return false;
    L25:
        r11 = r11 + 1;
    L22:
        if (Character.isJavaIdentifierStart(r12) == false) goto L23;
        r5 = State.MIDDLE;
        goto L25
    L23:
        return false;
    L27:
        if (r5 != State.AFTER_DOT) goto L29;
        return false;
    L29:
        return true;
    }

    public static final FqName parentOrNull(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isRoot() == false) goto L6;
        return null;
    L6:
        return r5.parent();
    }

    public static final FqName tail(FqName r5, FqName r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        if (isSubpackageOf(r5, r10) == true) goto L5;
        return r5;
    L5:
        if (r10.isRoot() == false) goto L8;
        return r5;
    L8:
        if (Intrinsics.areEqual(r5, r10) == false) goto L11;
        return FqName.ROOT;
    L11:
        return new FqName(r5.asString().substring(r10.asString().length() + 1));
    }

    private static final boolean isSubpackageOf(String r5, String r10) {
        if (StringsKt.P(r5, r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.charAt(r10.length()) != '.') goto L7;
        return true;
    }
}
