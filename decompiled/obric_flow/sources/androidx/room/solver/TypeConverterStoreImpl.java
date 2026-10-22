package androidx.room.solver;

import androidx.room.compiler.processing.XType;
import androidx.room.solver.types.CompositeTypeConverter;
import androidx.room.solver.types.NoOpConverter;
import androidx.room.solver.types.TypeConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/room/solver/TypeConverterStoreImpl;", "Landroidx/room/solver/TypeConverterStore;", "typeConverters", "", "Landroidx/room/solver/types/TypeConverter;", "knownColumnTypes", "Landroidx/room/compiler/processing/XType;", "(Ljava/util/List;Ljava/util/List;)V", "getTypeConverters", "()Ljava/util/List;", "findConverterFromCursor", "columnTypes", "output", "findConverterIntoStatement", "input", "findTypeConverter", "inputs", "outputs", "getAllTypeConverters", "excludes", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypeConverterStoreImpl implements TypeConverterStore {
    private final List<XType> knownColumnTypes;
    private final List<TypeConverter> typeConverters;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeConverterStoreImpl(List<? extends TypeConverter> r5, List<? extends XType> r10) {
        Intrinsics.checkNotNullParameter(r5, "typeConverters");
        Intrinsics.checkNotNullParameter(r10, "knownColumnTypes");
        this.typeConverters = r5;
        this.knownColumnTypes = r10;
    }

    private static final TypeConverter findTypeConverter$findMatchingConverter(List<? extends TypeConverter> r5, List<? extends XType> r10) {
        Iterator<T> r11 = r5.iterator();
        TypeConverter r12 = null;
    L4:
        if (r11.hasNext() == false) goto L15;
        TypeConverter r13 = (TypeConverter) r11.next();
        Iterator<T> r14 = r10.iterator();
    L7:
        if (r14.hasNext() == false) goto L4;
        XType r15 = (XType) r14.next();
        if (r15.isSameType(r13.getTo()) == true) goto L10;
        if (r12 != null) goto L7;
        if (r15.isAssignableFrom(r13.getTo()) == false) goto L7;
        r12 = r13;
        goto L7
    L10:
        return r13;
    L15:
        return r12;
    }

    private final List<TypeConverter> getAllTypeConverters(final XType r10, List<? extends XType> r11) {
        List<TypeConverter> r12 = getTypeConverters();
        ArrayList r5 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        Object r14 = r13.next();
        TypeConverter r15 = (TypeConverter) r14;
        if (r15.getFrom().isAssignableFrom(r10) == false) goto L4;
        if (r11 != null) goto L9;
    L11:
        Iterator<T> r16 = r11.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        if (((XType) r16.next()).isSameType(r15.getTo()) == false) goto L13;
    L17:
        r5.add(r14);
        goto L4
    L9:
        if (r11.isEmpty() == false) goto L11;
    L19:
        return CollectionsKt.sortedWith(r5, new TypeConverterStoreImpl$getAllTypeConverters$$inlined$sortedByDescending$1(r10));
    }

    @Override // androidx.room.solver.TypeConverterStore
    public TypeConverter findConverterFromCursor(List<? extends XType> r5, XType r10) {
        Intrinsics.checkNotNullParameter(r10, "output");
        if (r5 != null) goto L6;
        r5 = this.knownColumnTypes;
    L6:
        return findTypeConverter(r5, CollectionsKt.listOf(r10));
    }

    @Override // androidx.room.solver.TypeConverterStore
    public TypeConverter findConverterIntoStatement(XType r5, List<? extends XType> r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        List<? extends XType> r11 = CollectionsKt.listOf(r5);
        if (r10 != null) goto L6;
        r10 = this.knownColumnTypes;
    L6:
        return findTypeConverter(r11, r10);
    }

    @Override // androidx.room.solver.TypeConverterStore
    public TypeConverter findTypeConverter(XType r5, XType r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "output");
        return findTypeConverter(CollectionsKt.listOf(r5), CollectionsKt.listOf(r10));
    }

    @Override // androidx.room.solver.TypeConverterStore
    public List<TypeConverter> getTypeConverters() {
        return this.typeConverters;
    }

    private final TypeConverter findTypeConverter(List<? extends XType> r10, List<? extends XType> r11) {
        if (r10.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<T> r5 = r10.iterator();
    L7:
        if (r5.hasNext() == false) goto L20;
        XType r12 = (XType) r5.next();
        if (r11 == null) goto L13;
        if (r11.isEmpty() == true) goto L7;
    L13:
        Iterator<T> r13 = r11.iterator();
    L15:
        if (r13.hasNext() == false) goto L7;
        if (r12.isSameType((XType) r13.next()) == false) goto L15;
        return new NoOpConverter(r12);
    L20:
        ArrayList r14 = new ArrayList();
        LinkedList r15 = new LinkedList();
        Iterator<T> r16 = r10.iterator();
    L22:
        if (r16.hasNext() == false) goto L30;
        List<TypeConverter> r17 = getAllTypeConverters((XType) r16.next(), r14);
        TypeConverter r18 = findTypeConverter$findMatchingConverter(r17, r11);
        if (r18 != null) goto L25;
        Iterator<T> r19 = r17.iterator();
    L28:
        if (r19.hasNext() == false) goto L22;
        TypeConverter r20 = (TypeConverter) r19.next();
        r14.add(r20.getTo());
        r15.add(r20);
        goto L28
    L25:
        return r18;
    L30:
        r14.addAll(r10);
    L32:
        if (r15.isEmpty() == true) goto L41;
        TypeConverter r21 = (TypeConverter) r15.pop();
        List<TypeConverter> r22 = getAllTypeConverters(r21.getTo(), r14);
        TypeConverter r23 = findTypeConverter$findMatchingConverter(r22, r11);
        if (r23 != null) goto L36;
        Iterator<T> r24 = r22.iterator();
    L39:
        if (r24.hasNext() == false) goto L32;
        TypeConverter r25 = (TypeConverter) r24.next();
        r14.add(r25.getTo());
        r15.add(new CompositeTypeConverter(r21, r25));
        goto L39
    L36:
        return new CompositeTypeConverter(r21, r23);
    L41:
        return null;
    }
}
