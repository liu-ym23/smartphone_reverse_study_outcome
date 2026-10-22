package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = null;
    private static final List<String> PREDEFINED_STRINGS = null;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f0kotlin = null;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            r0[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
        String r1 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f0kotlin = r1;
        List<String> r0 = CollectionsKt.listOf(new String[]{r1 + "/Any", r1 + "/Nothing", r1 + "/Unit", r1 + "/Throwable", r1 + "/Number", r1 + "/Byte", r1 + "/Double", r1 + "/Float", r1 + "/Int", r1 + "/Long", r1 + "/Short", r1 + "/Boolean", r1 + "/Char", r1 + "/CharSequence", r1 + "/String", r1 + "/Comparable", r1 + "/Enum", r1 + "/Array", r1 + "/ByteArray", r1 + "/DoubleArray", r1 + "/FloatArray", r1 + "/IntArray", r1 + "/LongArray", r1 + "/ShortArray", r1 + "/BooleanArray", r1 + "/CharArray", r1 + "/Cloneable", r1 + "/Annotation", r1 + "/collections/Iterable", r1 + "/collections/MutableIterable", r1 + "/collections/Collection", r1 + "/collections/MutableCollection", r1 + "/collections/List", r1 + "/collections/MutableList", r1 + "/collections/Set", r1 + "/collections/MutableSet", r1 + "/collections/Map", r1 + "/collections/MutableMap", r1 + "/collections/Map.Entry", r1 + "/collections/MutableMap.MutableEntry", r1 + "/collections/Iterator", r1 + "/collections/MutableIterator", r1 + "/collections/ListIterator", r1 + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = r0;
        Iterable r2 = CollectionsKt.withIndex(r0);
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        IndexedValue r5 = (IndexedValue) r4.next();
        r3.put((String) r5.getValue(), Integer.valueOf(r5.getIndex()));
        goto L4
    L6:
        PREDEFINED_STRINGS_MAP = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r1) {
        return getString(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r13) {
        JvmProtoBuf.StringTableTypes.Record r0 = (JvmProtoBuf.StringTableTypes.Record) ListProtector.get(this.records, r13);
        if (r0.hasString() == false) goto L6;
        String r14 = r0.getString();
    L16:
        if (r0.getSubstringIndexCount() < 2) goto L24;
        List<Integer> r1 = r0.getSubstringIndexList();
        Intrinsics.checkNotNull(r1);
        Integer r5 = (Integer) ListProtector.get(r1, 0);
        Integer r2 = (Integer) ListProtector.get(r1, 1);
        if (r5.intValue() < 0) goto L24;
        if (r5.intValue() > r2.intValue()) goto L24;
        if (r2.intValue() > r14.length()) goto L24;
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r5);
        int r6 = r5.intValue();
        Intrinsics.checkNotNull(r2);
        r14 = r14.substring(r6, r2.intValue());
    L24:
        String r7 = r14;
        if (r0.getReplaceCharCount() < 2) goto L27;
        List<Integer> r15 = r0.getReplaceCharList();
        Intrinsics.checkNotNull(r15);
        Integer r3 = (Integer) ListProtector.get(r15, 0);
        Integer r16 = (Integer) ListProtector.get(r15, 1);
        Intrinsics.checkNotNull(r7);
        r7 = StringsKt.replace$default(r7, (char) r3.intValue(), (char) r16.intValue(), false, 4, null);
    L27:
        String r8 = r7;
        JvmProtoBuf.StringTableTypes.Record.Operation r17 = r0.getOperation();
        if (r17 != null) goto L30;
        r17 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    L30:
        int r18 = WhenMappings.$EnumSwitchMapping$0[r17.ordinal()];
        if (r18 == 1) goto L42;
        if (r18 != 2) goto L34;
        Intrinsics.checkNotNull(r8);
        r8 = StringsKt.replace$default(r8, '$', '.', false, 4, null);
        goto L42
    L34:
        if (r18 != 3) goto L40;
        if (r8.length() < 2) goto L38;
        Intrinsics.checkNotNull(r8);
        r8 = r8.substring(1, r8.length() - 1);
    L38:
        String r4 = r8;
        Intrinsics.checkNotNull(r4);
        r8 = StringsKt.replace$default(r4, '$', '.', false, 4, null);
        goto L42
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        Intrinsics.checkNotNull(r8);
        return r8;
    L6:
        if (r0.hasPredefinedIndex() == false) goto L14;
        List<String> r9 = PREDEFINED_STRINGS;
        int r10 = r9.size();
        int r11 = r0.getPredefinedIndex();
        if (r11 < 0) goto L11;
        if (r11 >= r10) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L14;
        r14 = (String) ListProtector.get(r9, r0.getPredefinedIndex());
    L11:
        r12 = false;
    L14:
        r14 = this.strings[r13];
        goto L16
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r2) {
        return this.localNameIndices.contains(Integer.valueOf(r2));
    }

    public JvmNameResolverBase(String[] r2, Set<Integer> r3, List<JvmProtoBuf.StringTableTypes.Record> r4) {
        Intrinsics.checkNotNullParameter(r2, "strings");
        Intrinsics.checkNotNullParameter(r3, "localNameIndices");
        Intrinsics.checkNotNullParameter(r4, "records");
        this.strings = r2;
        this.localNameIndices = r3;
        this.records = r4;
    }
}
