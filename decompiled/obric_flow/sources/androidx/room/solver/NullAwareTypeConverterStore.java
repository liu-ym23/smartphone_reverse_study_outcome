package androidx.room.solver;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.types.CompositeTypeConverter;
import androidx.room.solver.types.NoOpConverter;
import androidx.room.solver.types.NullSafeTypeConverter;
import androidx.room.solver.types.RequireNotNullTypeConverter;
import androidx.room.solver.types.TypeConverter;
import androidx.room.solver.types.UpCastTypeConverter;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\r\u0018\u00002\u00020\u0001:\u000256B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00042\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u0004\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ)\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b(\u0010)R&\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R&\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010)R!\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u0010)¨\u00067"}, d2 = {"Landroidx/room/solver/NullAwareTypeConverterStore;", "Landroidx/room/solver/TypeConverterStore;", "Landroidx/room/processor/Context;", "context", "", "Landroidx/room/solver/types/TypeConverter;", "typeConverters", "Landroidx/room/compiler/processing/XType;", "knownColumnTypes", "<init>", "(Landroidx/room/processor/Context;Ljava/util/List;Ljava/util/List;)V", "Landroidx/room/compiler/processing/XNullability;", "nullability", "explicitColumnTypes", "getColumnTypesInPreferenceBuckets", "(Landroidx/room/compiler/processing/XNullability;Ljava/util/List;)Ljava/util/List;", "type", "", "isColumnType", "(Landroidx/room/compiler/processing/XType;)Z", "input", "columnTypes", "Landroidx/room/solver/NullAwareTypeConverterStore$TypeConverterEntry;", "findConverterIntoStatementInternal", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;)Landroidx/room/solver/NullAwareTypeConverterStore$TypeConverterEntry;", "output", "findConverterFromCursorInternal", "(Ljava/util/List;Landroidx/room/compiler/processing/XType;)Landroidx/room/solver/NullAwareTypeConverterStore$TypeConverterEntry;", "getAllTypeConvertersFrom", "(Landroidx/room/compiler/processing/XType;)Ljava/util/List;", "getAllTypeConvertersTo", "findConverterIntoStatement", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;)Landroidx/room/solver/types/TypeConverter;", "findConverterFromCursor", "(Ljava/util/List;Landroidx/room/compiler/processing/XType;)Landroidx/room/solver/types/TypeConverter;", "findTypeConverter", "(Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;)Landroidx/room/solver/types/TypeConverter;", "Ljava/util/List;", "Lcom/squareup/javapoet/x;", "knownColumnTypeNames", "getTypeConverters", "()Ljava/util/List;", "", "typeConvertersByFromCache", "Ljava/util/Map;", "typeConvertersByToCache", "knownNullableColumnTypes$delegate", "Lkotlin/Lazy;", "getKnownNullableColumnTypes", "knownNullableColumnTypes", "knownNonNullableColumnTypes$delegate", "getKnownNonNullableColumnTypes", "knownNonNullableColumnTypes", "TypeConverterEntry", "TypeConverterQueue", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NullAwareTypeConverterStore implements TypeConverterStore {
    private final List<x> knownColumnTypeNames;
    private final List<XType> knownColumnTypes;
    private final Lazy knownNonNullableColumnTypes$delegate;
    private final Lazy knownNullableColumnTypes$delegate;
    private final List<TypeConverter> typeConverters;
    private final Map<XType, List<TypeConverter>> typeConvertersByFromCache;
    private final Map<XType, List<TypeConverter>> typeConvertersByToCache;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u0007J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Landroidx/room/solver/NullAwareTypeConverterStore$TypeConverterEntry;", "", "tieBreakerPriority", "", "type", "Landroidx/room/compiler/processing/XType;", "converter", "Landroidx/room/solver/types/TypeConverter;", "convertsBetweenDbAndNonDbType", "", "(ILandroidx/room/compiler/processing/XType;Landroidx/room/solver/types/TypeConverter;Z)V", "getConverter", "()Landroidx/room/solver/types/TypeConverter;", "getConvertsBetweenDbAndNonDbType", "()Z", "getTieBreakerPriority", "()I", "getType", "()Landroidx/room/compiler/processing/XType;", "appendConverter", "nextConverter", "compareTo", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "getOrCreateConverter", "hashCode", "prependConverter", "previous", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TypeConverterEntry implements Comparable<TypeConverterEntry> {
        private final TypeConverter converter;
        private final boolean convertsBetweenDbAndNonDbType;
        private final int tieBreakerPriority;
        private final XType type;

        public TypeConverterEntry(int r5, XType r10, TypeConverter r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "type");
            this.tieBreakerPriority = r5;
            this.type = r10;
            this.converter = r11;
            this.convertsBetweenDbAndNonDbType = r12;
        }

        public static /* synthetic */ TypeConverterEntry copy$default(TypeConverterEntry r5, int r10, XType r11, TypeConverter r12, boolean r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = r5.tieBreakerPriority;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = r5.type;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = r5.converter;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r13 = r5.convertsBetweenDbAndNonDbType;
        L15:
            return r5.copy(r10, r11, r12, r13);
        }

        public final TypeConverter appendConverter(TypeConverter r5) {
            Intrinsics.checkNotNullParameter(r5, "nextConverter");
            TypeConverter r10 = this.converter;
            if (r10 != null) goto L6;
            return r5;
        L6:
            return new CompositeTypeConverter(r10, r5);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(TypeConverterEntry r5) {
            return compareTo2(r5);
        }

        public final int component1() {
            return this.tieBreakerPriority;
        }

        public final XType component2() {
            return this.type;
        }

        public final TypeConverter component3() {
            return this.converter;
        }

        public final boolean component4() {
            return this.convertsBetweenDbAndNonDbType;
        }

        public final TypeConverterEntry copy(int r5, XType r10, TypeConverter r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "type");
            return new TypeConverterEntry(r5, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TypeConverterEntry) == true) goto L8;
            return false;
        L8:
            TypeConverterEntry r10 = (TypeConverterEntry) r5;
            if (this.tieBreakerPriority == r10.tieBreakerPriority) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.converter, r10.converter) == true) goto L18;
            return false;
        L18:
            if (this.convertsBetweenDbAndNonDbType == r10.convertsBetweenDbAndNonDbType) goto L20;
            return false;
        L20:
            return true;
        }

        public final TypeConverter getConverter() {
            return this.converter;
        }

        public final boolean getConvertsBetweenDbAndNonDbType() {
            return this.convertsBetweenDbAndNonDbType;
        }

        public final TypeConverter getOrCreateConverter() {
            TypeConverter r5 = this.converter;
            if (r5 == null) goto L5;
            return r5;
        L5:
            return new NoOpConverter(this.type);
        }

        public final int getTieBreakerPriority() {
            return this.tieBreakerPriority;
        }

        public final XType getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r5 = Integer.hashCode(this.tieBreakerPriority) * 31;
            int r10 = (this.type.hashCode() + r5) * 31;
            TypeConverter r11 = this.converter;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r10 + r12) * 31;
            boolean r14 = this.convertsBetweenDbAndNonDbType;
            ?? r15 = r14;
            if (r14 == false) goto L10;
            r15 = 1;
        L10:
            return r13 + r15;
        L5:
            r12 = r11.hashCode();
            goto L6
        }

        public final TypeConverter prependConverter(TypeConverter r5) {
            Intrinsics.checkNotNullParameter(r5, "previous");
            TypeConverter r10 = this.converter;
            if (r10 != null) goto L6;
            return r5;
        L6:
            return new CompositeTypeConverter(r5, r10);
        }

        public String toString() {
            return "TypeConverterEntry(tieBreakerPriority=" + this.tieBreakerPriority + ", type=" + this.type + ", converter=" + this.converter + ", convertsBetweenDbAndNonDbType=" + this.convertsBetweenDbAndNonDbType + ")";
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(TypeConverterEntry r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            TypeConverter r10 = this.converter;
            if (r10 != null) goto L9;
            if (r5.converter == null) goto L16;
            return -1;
        L16:
            return Intrinsics.compare(this.tieBreakerPriority, r5.tieBreakerPriority);
        L9:
            if (r5.converter != null) goto L12;
            return 1;
        L12:
            int r11 = r10.getCost().compareTo2(r5.converter.getCost());
            if (r11 == 0) goto L16;
            return r11;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\rR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\"\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/solver/NullAwareTypeConverterStore$TypeConverterQueue;", "", "sourceType", "Landroidx/room/compiler/processing/XType;", "isKnownColumnType", "Lkotlin/Function1;", "", "keyType", "Landroidx/room/solver/types/TypeConverter;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/compiler/processing/XType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "cheapestEntry", "", "Landroidx/room/solver/NullAwareTypeConverterStore$TypeConverterEntry;", "insertionOrder", "", "()Lkotlin/jvm/functions/Function1;", "getKeyType", "queue", "Ljava/util/PriorityQueue;", "maybeEnqueue", "prevEntry", "converter", "next", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TypeConverterQueue {
        private final Map<XType, TypeConverterEntry> cheapestEntry;
        private int insertionOrder;
        private final Function1<XType, Boolean> isKnownColumnType;
        private final Function1<TypeConverter, XType> keyType;
        private final PriorityQueue<TypeConverterEntry> queue;

        /* JADX WARN: Multi-variable type inference failed */
        public TypeConverterQueue(XType r5, Function1<? super XType, Boolean> r10, Function1<? super TypeConverter, ? extends XType> r11) {
            Intrinsics.checkNotNullParameter(r5, "sourceType");
            Intrinsics.checkNotNullParameter(r10, "isKnownColumnType");
            Intrinsics.checkNotNullParameter(r11, "keyType");
            this.isKnownColumnType = r10;
            this.keyType = r11;
            LinkedHashMap r12 = new LinkedHashMap();
            this.cheapestEntry = r12;
            PriorityQueue<TypeConverterEntry> r13 = new PriorityQueue();
            this.queue = r13;
            int r14 = this.insertionOrder;
            this.insertionOrder = r14 + 1;
            TypeConverterEntry r15 = new TypeConverterEntry(r14, r5, null, false);
            r12.put(r5, r15);
            r13.add(r15);
        }

        public final Function1<TypeConverter, XType> getKeyType() {
            return this.keyType;
        }

        public final Function1<XType, Boolean> isKnownColumnType() {
            return this.isKnownColumnType;
        }

        public final boolean maybeEnqueue(TypeConverterEntry r10, TypeConverter r11) {
            Intrinsics.checkNotNullParameter(r10, "prevEntry");
            Intrinsics.checkNotNullParameter(r11, "converter");
            XType r5 = this.keyType.invoke(r11);
            if (this.isKnownColumnType.invoke(r11.getFrom()).booleanValue() == this.isKnownColumnType.invoke(r11.getTo()).booleanValue()) goto L5;
            boolean r12 = true;
        L7:
            if (r10.getConvertsBetweenDbAndNonDbType() == false) goto L10;
            if (r12 == true) goto L10;
            return false;
        L10:
            TypeConverterEntry r13 = this.cheapestEntry.get(r5);
            if (r13 != null) goto L13;
        L18:
            int r14 = this.insertionOrder;
            this.insertionOrder = r14 + 1;
            TypeConverterEntry r15 = new TypeConverterEntry(r14, r5, r11, r12);
            this.cheapestEntry.put(r5, r15);
            this.queue.add(r15);
            return true;
        L13:
            if (r13.getConverter() != null) goto L15;
        L17:
            return false;
        L15:
            if (r13.getConverter().getCost().compareTo2(r11.getCost()) <= 0) goto L17;
        L5:
            r12 = false;
            goto L7
        }

        public final TypeConverterEntry next() {
        L3:
            if (this.queue.isEmpty() == true) goto L8;
            TypeConverterEntry r5 = this.queue.remove();
            if (this.cheapestEntry.get(r5.getType()) != r5) goto L3;
            return r5;
        L8:
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[XNullability.values().length];
            r5[XNullability.NULLABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[XNullability.NONNULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[XNullability.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullAwareTypeConverterStore(Context r5, List<? extends TypeConverter> r10, List<? extends XType> r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "typeConverters");
        Intrinsics.checkNotNullParameter(r11, "knownColumnTypes");
        this.knownColumnTypes = r11;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((XType) r13.next()).getTypeName());
        goto L4
    L6:
        this.knownColumnTypeNames = r12;
        List r14 = r10;
        if (r5.getProcessingEnv().getBackend() != XProcessingEnv.Backend.KSP) goto L28;
        List r15 = CollectionsKt.toMutableList(r10);
        Iterator<T> r16 = r10.iterator();
    L10:
        if (r16.hasNext() == false) goto L27;
        TypeConverter r17 = (TypeConverter) r16.next();
        if (r17.getFrom().getNullability() != XNullability.NONNULL) goto L10;
        NullSafeTypeConverter r18 = new NullSafeTypeConverter(r17);
        if (r15 != null) goto L16;
    L18:
        Iterator r19 = r15.iterator();
    L20:
        if (r19.hasNext() == false) goto L26;
        TypeConverter r20 = (TypeConverter) r19.next();
        if (r20.getFrom().isAssignableFrom(r18.getFrom()) == false) goto L20;
        if (r18.getTo().isAssignableFrom(r20.getTo()) == false) goto L20;
    L26:
        r15.add(r18);
        goto L10
    L16:
        if (r15.isEmpty() == false) goto L18;
    L27:
        r14 = r15;
    L28:
        this.typeConverters = r14;
        this.typeConvertersByFromCache = new LinkedHashMap();
        this.typeConvertersByToCache = new LinkedHashMap();
        this.knownNullableColumnTypes$delegate = LazyKt.lazy(new NullAwareTypeConverterStore$knownNullableColumnTypes$2(this));
        this.knownNonNullableColumnTypes$delegate = LazyKt.lazy(new NullAwareTypeConverterStore$knownNonNullableColumnTypes$2(this));
    }

    public static final /* synthetic */ List access$getKnownColumnTypes$p(NullAwareTypeConverterStore r5) {
        return r5.knownColumnTypes;
    }

    public static final /* synthetic */ boolean access$isColumnType(NullAwareTypeConverterStore r5, XType r10) {
        return r5.isColumnType(r10);
    }

    private final TypeConverterEntry findConverterFromCursorInternal(List<? extends XType> r10, XType r11) {
        if (r10.isEmpty() == false) goto L5;
        return null;
    L5:
        TypeConverterQueue r5 = new TypeConverterQueue(r11, new NullAwareTypeConverterStore$findConverterFromCursorInternal$queue$1(this), NullAwareTypeConverterStore$findConverterFromCursorInternal$queue$2.INSTANCE);
    L6:
        TypeConverterEntry r12 = r5.next();
        if (r12 == null) goto L8;
        if (r10.isEmpty() == true) goto L18;
        Iterator<T> r13 = r10.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        if (((XType) r13.next()).isSameType(r12.getType()) == false) goto L14;
        return r12;
    L18:
        Iterator<T> r14 = r10.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        XType r15 = (XType) r14.next();
        if (r12.getType().isAssignableFrom(r15) == false) goto L20;
        r5.maybeEnqueue(r12, r12.prependConverter(new UpCastTypeConverter(r15, r12.getType())));
        goto L20
    L24:
        Iterator<T> r16 = getAllTypeConvertersTo(r12.getType()).iterator();
    L26:
        if (r16.hasNext() == false) goto L6;
        r5.maybeEnqueue(r12, r12.prependConverter((TypeConverter) r16.next()));
        goto L26
    L8:
        return null;
    }

    private final TypeConverterEntry findConverterIntoStatementInternal(XType r10, List<? extends XType> r11) {
        if (r11.isEmpty() == false) goto L5;
        return null;
    L5:
        TypeConverterQueue r5 = new TypeConverterQueue(r10, new NullAwareTypeConverterStore$findConverterIntoStatementInternal$queue$1(this), NullAwareTypeConverterStore$findConverterIntoStatementInternal$queue$2.INSTANCE);
    L6:
        TypeConverterEntry r12 = r5.next();
        if (r12 == null) goto L8;
        if (r11.isEmpty() == true) goto L18;
        Iterator<T> r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        if (((XType) r13.next()).isSameType(r12.getType()) == false) goto L14;
        return r12;
    L18:
        Iterator<T> r14 = r11.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        XType r15 = (XType) r14.next();
        if (r15.isAssignableFrom(r12.getType()) == false) goto L20;
        r5.maybeEnqueue(r12, r12.appendConverter(new UpCastTypeConverter(r12.getType(), r15)));
        goto L20
    L24:
        Iterator<T> r16 = getAllTypeConvertersFrom(r12.getType()).iterator();
    L26:
        if (r16.hasNext() == false) goto L6;
        r5.maybeEnqueue(r12, r12.appendConverter((TypeConverter) r16.next()));
        goto L26
    L8:
        return null;
    }

    private final List<TypeConverter> getAllTypeConvertersFrom(XType r10) {
        Map<XType, List<TypeConverter>> r5 = this.typeConvertersByFromCache;
        List<TypeConverter> r11 = r5.get(r10);
        if (r11 != null) goto L18;
        List<TypeConverter> r12 = getTypeConverters();
        r11 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L16;
        TypeConverter r14 = (TypeConverter) r13.next();
        if (r14.getFrom().isSameType(r10) == false) goto L11;
    L14:
        if (r14 == null) goto L6;
        r11.add(r14);
        goto L6
    L11:
        if (r14.getFrom().isAssignableFrom(r10) == false) goto L13;
        r14 = new CompositeTypeConverter(new UpCastTypeConverter(r10, r14.getFrom()), r14);
        goto L14
    L13:
        r14 = null;
        goto L14
    L16:
        r5.put(r10, r11);
    L18:
        return r11;
    }

    private final List<TypeConverter> getAllTypeConvertersTo(XType r10) {
        Map<XType, List<TypeConverter>> r5 = this.typeConvertersByToCache;
        List<TypeConverter> r11 = r5.get(r10);
        if (r11 != null) goto L18;
        List<TypeConverter> r12 = getTypeConverters();
        r11 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L16;
        TypeConverter r14 = (TypeConverter) r13.next();
        if (r14.getTo().isSameType(r10) == false) goto L11;
    L14:
        if (r14 == null) goto L6;
        r11.add(r14);
        goto L6
    L11:
        if (r10.isAssignableFrom(r14.getTo()) == false) goto L13;
        r14 = new CompositeTypeConverter(r14, new UpCastTypeConverter(r14.getTo(), r10));
        goto L14
    L13:
        r14 = null;
        goto L14
    L16:
        r5.put(r10, r11);
    L18:
        return r11;
    }

    private final List<List<XType>> getColumnTypesInPreferenceBuckets(XNullability r10, List<? extends XType> r11) {
        if (r11 != null) goto L11;
        int r12 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r12 == 1) goto L39;
        if (r12 == 2) goto L38;
        return CollectionsKt.listOf(this.knownColumnTypes);
    L38:
        return CollectionsKt.listOf(new List[]{getKnownNonNullableColumnTypes(), getKnownNullableColumnTypes()});
    L39:
        return CollectionsKt.listOf(new List[]{getKnownNullableColumnTypes(), getKnownNonNullableColumnTypes()});
    L11:
        if (WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] == 3) goto L40;
        ArrayList r13 = new ArrayList();
        Iterator<T> r5 = r11.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r14 = r5.next();
        if (((XType) r14).getNullability() != r10) goto L15;
        r13.add(r14);
        goto L15
    L19:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r11.iterator();
    L21:
        if (r16.hasNext() == false) goto L26;
        Object r17 = r16.next();
        if (((XType) r17).getNullability() == r10) goto L21;
        r15.add(r17);
        goto L21
    L26:
        return CollectionsKt.listOf(new List[]{r13, r15});
    L40:
        return CollectionsKt.listOf(r11);
    }

    private final List<XType> getKnownNonNullableColumnTypes() {
        return (List) this.knownNonNullableColumnTypes$delegate.getValue();
    }

    private final List<XType> getKnownNullableColumnTypes() {
        return (List) this.knownNullableColumnTypes$delegate.getValue();
    }

    private final boolean isColumnType(XType r5) {
        return this.knownColumnTypeNames.contains(r5.getTypeName());
    }

    @Override // androidx.room.solver.TypeConverterStore
    public TypeConverter findConverterFromCursor(List<? extends XType> r5, XType r10) {
        Intrinsics.checkNotNullParameter(r10, "output");
        if (r5 != null) goto L5;
        r5 = this.knownColumnTypes;
    L5:
        Iterator<T> r11 = getColumnTypesInPreferenceBuckets(XNullability.NULLABLE, r5).iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        TypeConverterEntry r12 = findConverterFromCursorInternal((List) r11.next(), r10);
        if (r12 == null) goto L7;
        return r12.getOrCreateConverter();
    L13:
        if (r10.getNullability() != XNullability.NONNULL) goto L21;
        TypeConverterEntry r13 = findConverterFromCursorInternal(r5, r10.makeNullable());
        if (r13 != null) goto L17;
        return null;
    L17:
        return r13.appendConverter(new RequireNotNullTypeConverter(r10.makeNullable()));
    L21:
        return null;
    }

    @Override // androidx.room.solver.TypeConverterStore
    public TypeConverter findConverterIntoStatement(XType r5, List<? extends XType> r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Iterator<T> r11 = getColumnTypesInPreferenceBuckets(r5.getNullability(), r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        TypeConverterEntry r12 = findConverterIntoStatementInternal(r5, (List) r11.next());
        if (r12 == null) goto L4;
        TypeConverter r13 = r12.getOrCreateConverter();
        if (r13 == null) goto L4;
        return r13;
    L10:
        return null;
    }

    @Override // androidx.room.solver.TypeConverterStore
    public TypeConverter findTypeConverter(XType r5, XType r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "output");
        TypeConverterEntry r11 = findConverterIntoStatementInternal(r5, CollectionsKt.listOf(r10));
        if (r11 == null) goto L7;
        return r11.getOrCreateConverter();
    L7:
        if (r10.getNullability() != XNullability.NONNULL) goto L12;
        TypeConverterEntry r12 = findConverterIntoStatementInternal(r5, CollectionsKt.listOf(r10.makeNullable()));
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.appendConverter(new RequireNotNullTypeConverter(r10.makeNullable()));
    L12:
        return null;
    }

    @Override // androidx.room.solver.TypeConverterStore
    public List<TypeConverter> getTypeConverters() {
        return this.typeConverters;
    }
}
