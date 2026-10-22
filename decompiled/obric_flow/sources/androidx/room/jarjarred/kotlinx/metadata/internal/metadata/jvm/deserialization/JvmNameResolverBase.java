package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolverBase;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "strings", "", "", "localNameIndices", "", "", "records", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$StringTableTypes$Record;", "([Ljava/lang/String;Ljava/util/Set;Ljava/util/List;)V", "getStrings", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getQualifiedClassName", "index", "getString", "isLocalClassName", "", "Companion", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = null;
    private static final List<String> PREDEFINED_STRINGS = null;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f617kotlin = null;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolverBase$Companion;", "", "()V", "PREDEFINED_STRINGS", "", "", "getPREDEFINED_STRINGS", "()Ljava/util/List;", "PREDEFINED_STRINGS_MAP", "", "", "kotlin", "getPredefinedStringIndex", "string", "(Ljava/lang/String;)Ljava/lang/Integer;", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<String> getPREDEFINED_STRINGS() {
            return JvmNameResolverBase.access$getPREDEFINED_STRINGS$cp();
        }

        public final Integer getPredefinedStringIndex(String r5) {
            Intrinsics.checkNotNullParameter(r5, "string");
            return (Integer) JvmNameResolverBase.access$getPREDEFINED_STRINGS_MAP$cp().get(r5);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
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
        f617kotlin = r5;
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

    public static final /* synthetic */ List access$getPREDEFINED_STRINGS$cp() {
        return PREDEFINED_STRINGS;
    }

    public static final /* synthetic */ Map access$getPREDEFINED_STRINGS_MAP$cp() {
        return PREDEFINED_STRINGS_MAP;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r5) {
        return getString(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver
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

    public final String[] getStrings() {
        return this.strings;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r5) {
        return this.localNameIndices.contains(Integer.valueOf(r5));
    }
}
