package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = null;
    private static final List<String> PREDEFINED_STRINGS = null;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f10217kotlin = null;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            r10[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        Companion = new Companion(null);
        String r10 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f10217kotlin = r10;
        List<String> r11 = CollectionsKt.listOf(new String[]{r10 + "/Any", r10 + "/Nothing", r10 + "/Unit", r10 + "/Throwable", r10 + "/Number", r10 + "/Byte", r10 + "/Double", r10 + "/Float", r10 + "/Int", r10 + "/Long", r10 + "/Short", r10 + "/Boolean", r10 + "/Char", r10 + "/CharSequence", r10 + "/String", r10 + "/Comparable", r10 + "/Enum", r10 + "/Array", r10 + "/ByteArray", r10 + "/DoubleArray", r10 + "/FloatArray", r10 + "/IntArray", r10 + "/LongArray", r10 + "/ShortArray", r10 + "/BooleanArray", r10 + "/CharArray", r10 + "/Cloneable", r10 + "/Annotation", r10 + "/collections/Iterable", r10 + "/collections/MutableIterable", r10 + "/collections/Collection", r10 + "/collections/MutableCollection", r10 + "/collections/List", r10 + "/collections/MutableList", r10 + "/collections/Set", r10 + "/collections/MutableSet", r10 + "/collections/Map", r10 + "/collections/MutableMap", r10 + "/collections/Map.Entry", r10 + "/collections/MutableMap.MutableEntry", r10 + "/collections/Iterator", r10 + "/collections/MutableIterator", r10 + "/collections/ListIterator", r10 + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = r11;
        Iterable r12 = CollectionsKt.withIndex(r11);
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        IndexedValue r15 = (IndexedValue) r14.next();
        r13.put((String) r15.getValue(), Integer.valueOf(r15.getIndex()));
        goto L4
    L6:
        PREDEFINED_STRINGS_MAP = r13;
    }

    public JvmNameResolverBase(String[] r10, Set<Integer> r11, List<JvmProtoBuf.StringTableTypes.Record> r12) {
        Intrinsics.checkNotNullParameter(r10, "strings");
        Intrinsics.checkNotNullParameter(r11, "localNameIndices");
        Intrinsics.checkNotNullParameter(r12, "records");
        this.strings = r10;
        this.localNameIndices = r11;
        this.records = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r10) {
        return getString(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r15) {
        JvmProtoBuf.StringTableTypes.Record r10 = this.records.get(r15);
        if (r10.hasString() == false) goto L6;
        String r14 = r10.getString();
    L16:
        if (r10.getSubstringIndexCount() < 2) goto L24;
        List<Integer> r16 = r10.getSubstringIndexList();
        Intrinsics.checkNotNullExpressionValue(r16, "substringIndexList");
        Integer r11 = r16.get(0);
        Integer r17 = r16.get(1);
        Intrinsics.checkNotNullExpressionValue(r11, "begin");
        if (r11.intValue() < 0) goto L24;
        int r12 = r11.intValue();
        Intrinsics.checkNotNullExpressionValue(r17, "end");
        if (r12 > r17.intValue()) goto L24;
        if (r17.intValue() > r14.length()) goto L24;
        Intrinsics.checkNotNullExpressionValue(r14, TypedValues.Custom.S_STRING);
        r14 = r14.substring(r11.intValue(), r17.intValue());
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
    L24:
        String r13 = r14;
        if (r10.getReplaceCharCount() < 2) goto L27;
        List<Integer> r18 = r10.getReplaceCharList();
        Intrinsics.checkNotNullExpressionValue(r18, "replaceCharList");
        Integer r19 = r18.get(0);
        Integer r110 = r18.get(1);
        Intrinsics.checkNotNullExpressionValue(r13, TypedValues.Custom.S_STRING);
        r13 = StringsKt.replace$default(r13, (char) r19.intValue(), (char) r110.intValue(), false, 4, null);
    L27:
        String r20 = r13;
        JvmProtoBuf.StringTableTypes.Record.Operation r111 = r10.getOperation();
        if (r111 != null) goto L30;
        r111 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    L30:
        int r112 = WhenMappings.$EnumSwitchMapping$0[r111.ordinal()];
        if (r112 != 2) goto L33;
        Intrinsics.checkNotNullExpressionValue(r20, TypedValues.Custom.S_STRING);
        r20 = StringsKt.replace$default(r20, Typography.dollar, '.', false, 4, null);
    L40:
        Intrinsics.checkNotNullExpressionValue(r20, TypedValues.Custom.S_STRING);
        return r20;
    L33:
        if (r112 != 3) goto L40;
        if (r20.length() < 2) goto L38;
        Intrinsics.checkNotNullExpressionValue(r20, TypedValues.Custom.S_STRING);
        r20 = r20.substring(1, r20.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r20, "this as java.lang.String…ing(startIndex, endIndex)");
    L38:
        String r21 = r20;
        Intrinsics.checkNotNullExpressionValue(r21, TypedValues.Custom.S_STRING);
        r20 = StringsKt.replace$default(r21, Typography.dollar, '.', false, 4, null);
        goto L40
    L6:
        if (r10.hasPredefinedIndex() == false) goto L14;
        List<String> r22 = PREDEFINED_STRINGS;
        int r23 = r22.size();
        int r24 = r10.getPredefinedIndex();
        if (r24 < 0) goto L11;
        if (r24 >= r23) goto L11;
        boolean r25 = true;
    L12:
        if (r25 == false) goto L14;
        r14 = r22.get(r10.getPredefinedIndex());
    L11:
        r25 = false;
    L14:
        r14 = this.strings[r15];
        goto L16
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r10) {
        return this.localNameIndices.contains(Integer.valueOf(r10));
    }
}
