package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmNameResolverBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1208#2,2:107\n1238#2,4:109\n*S KotlinDebug\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n*L\n101#1:107,2\n101#1:109,4\n*E\n"})
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = null;
    private static final List<String> PREDEFINED_STRINGS = null;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f18754kotlin = null;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            r5[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
        String r5 = CollectionsKt.q(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62);
        f18754kotlin = r5;
        List<String> r10 = CollectionsKt.listOf(new String[]{j0.j(r5, "/Any"), j0.j(r5, "/Nothing"), j0.j(r5, "/Unit"), j0.j(r5, "/Throwable"), j0.j(r5, "/Number"), j0.j(r5, "/Byte"), j0.j(r5, "/Double"), j0.j(r5, "/Float"), j0.j(r5, "/Int"), j0.j(r5, "/Long"), j0.j(r5, "/Short"), j0.j(r5, "/Boolean"), j0.j(r5, "/Char"), j0.j(r5, "/CharSequence"), j0.j(r5, "/String"), j0.j(r5, "/Comparable"), j0.j(r5, "/Enum"), j0.j(r5, "/Array"), j0.j(r5, "/ByteArray"), j0.j(r5, "/DoubleArray"), j0.j(r5, "/FloatArray"), j0.j(r5, "/IntArray"), j0.j(r5, "/LongArray"), j0.j(r5, "/ShortArray"), j0.j(r5, "/BooleanArray"), j0.j(r5, "/CharArray"), j0.j(r5, "/Cloneable"), j0.j(r5, "/Annotation"), j0.j(r5, "/collections/Iterable"), j0.j(r5, "/collections/MutableIterable"), j0.j(r5, "/collections/Collection"), j0.j(r5, "/collections/MutableCollection"), j0.j(r5, "/collections/List"), j0.j(r5, "/collections/MutableList"), j0.j(r5, "/collections/Set"), j0.j(r5, "/collections/MutableSet"), j0.j(r5, "/collections/Map"), j0.j(r5, "/collections/MutableMap"), j0.j(r5, "/collections/Map.Entry"), j0.j(r5, "/collections/MutableMap.MutableEntry"), j0.j(r5, "/collections/Iterator"), j0.j(r5, "/collections/MutableIterator"), j0.j(r5, "/collections/ListIterator"), j0.j(r5, "/collections/MutableListIterator")});
        PREDEFINED_STRINGS = r10;
        Iterable r11 = CollectionsKt.withIndex(r10);
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r11)), 16));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        IndexedValue r14 = (IndexedValue) r13.next();
        r12.put((String) r14.getValue(), Integer.valueOf(r14.getIndex()));
        goto L4
    L6:
        PREDEFINED_STRINGS_MAP = r12;
    }

    public JvmNameResolverBase(String[] r5, Set<Integer> r10, List<JvmProtoBuf.StringTableTypes.Record> r11) {
        Intrinsics.checkNotNullParameter(r5, "strings");
        Intrinsics.checkNotNullParameter(r10, "localNameIndices");
        Intrinsics.checkNotNullParameter(r11, "records");
        this.strings = r5;
        this.localNameIndices = r10;
        this.records = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r5) {
        return getString(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r10) {
        JvmProtoBuf.StringTableTypes.Record r5 = this.records.get(r10);
        if (r5.hasString() == false) goto L6;
        String r11 = r5.getString();
    L13:
        if (r5.getSubstringIndexCount() < 2) goto L22;
        List<Integer> r12 = r5.getSubstringIndexList();
        Integer r13 = r12.get(0);
        Integer r14 = r12.get(1);
        if (r13.intValue() < 0) goto L22;
        if (r13.intValue() > r14.intValue()) goto L22;
        if (r14.intValue() > r11.length()) goto L22;
        r11 = r11.substring(r13.intValue(), r14.intValue());
    L22:
        if (r5.getReplaceCharCount() < 2) goto L24;
        List<Integer> r15 = r5.getReplaceCharList();
        Integer r16 = r15.get(0);
        Integer r17 = r15.get(1);
        r11 = StringsKt.E(r11, (char) r16.intValue(), (char) r17.intValue());
    L24:
        JvmProtoBuf.StringTableTypes.Record.Operation r18 = r5.getOperation();
        if (r18 != null) goto L27;
        r18 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    L27:
        int r19 = WhenMappings.$EnumSwitchMapping$0[r18.ordinal()];
        if (r19 == 2) goto L37;
        if (r19 == 3) goto L33;
        return r11;
    L33:
        if (r11.length() < 2) goto L38;
        r11 = a.n(r11, 1, 1);
    L38:
        return StringsKt.E(r11, Typography.dollar, '.');
    L37:
        return StringsKt.E(r11, Typography.dollar, '.');
    L6:
        if (r5.hasPredefinedIndex() == false) goto L11;
        List<String> r20 = PREDEFINED_STRINGS;
        int r21 = r20.size();
        int r22 = r5.getPredefinedIndex();
        if (r22 < 0) goto L11;
        if (r22 >= r21) goto L11;
        r11 = r20.get(r5.getPredefinedIndex());
    L11:
        r11 = this.strings[r10];
        goto L13
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r5) {
        return this.localNameIndices.contains(Integer.valueOf(r5));
    }
}
