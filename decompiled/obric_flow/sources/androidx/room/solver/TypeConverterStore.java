package androidx.room.solver;

import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.types.CompositeTypeConverter;
import androidx.room.solver.types.NoOpConverter;
import androidx.room.solver.types.RequireNotNullTypeConverter;
import androidx.room.solver.types.TypeConverter;
import androidx.room.solver.types.UpCastTypeConverter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH&J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/room/solver/TypeConverterStore;", "", "typeConverters", "", "Landroidx/room/solver/types/TypeConverter;", "getTypeConverters", "()Ljava/util/List;", "findConverterFromCursor", "columnTypes", "Landroidx/room/compiler/processing/XType;", "output", "findConverterIntoStatement", "input", "findTypeConverter", "reverse", "converter", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TypeConverterStore {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¨\u0006\f"}, d2 = {"Landroidx/room/solver/TypeConverterStore$Companion;", "", "()V", "create", "Landroidx/room/solver/TypeConverterStore;", "context", "Landroidx/room/processor/Context;", "typeConverters", "", "Landroidx/room/solver/types/TypeConverter;", "knownColumnTypes", "Landroidx/room/compiler/processing/XType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final TypeConverterStore create(Context r5, List<? extends TypeConverter> r10, List<? extends XType> r11) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r10, "typeConverters");
            Intrinsics.checkNotNullParameter(r11, "knownColumnTypes");
            if (r5.getUseNullAwareConverter() == false) goto L6;
            return new NullAwareTypeConverterStore(r5, r10, r11);
        L6:
            return new TypeConverterStoreImpl(r10, r11);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    TypeConverter findConverterFromCursor(List<? extends XType> r5, XType r10);

    TypeConverter findConverterIntoStatement(XType r5, List<? extends XType> r10);

    TypeConverter findTypeConverter(XType r5, XType r10);

    List<TypeConverter> getTypeConverters();

    default TypeConverter reverse(TypeConverter r10) {
        Intrinsics.checkNotNullParameter(r10, "converter");
        if ((r10 instanceof NoOpConverter) == true) goto L35;
        Object r5 = null;
        if ((r10 instanceof CompositeTypeConverter) == false) goto L15;
        CompositeTypeConverter r11 = (CompositeTypeConverter) r10;
        TypeConverter r12 = reverse(r11.getConv1());
        if (r12 != null) goto L10;
        return null;
    L10:
        TypeConverter r13 = reverse(r11.getConv2());
        if (r13 != null) goto L33;
        return null;
    L33:
        return new CompositeTypeConverter(r13, r12);
    L15:
        if ((r10 instanceof RequireNotNullTypeConverter) == true) goto L34;
        Iterator<T> r14 = getTypeConverters().iterator();
    L19:
        if (r14.hasNext() == false) goto L26;
        Object r15 = r14.next();
        TypeConverter r16 = (TypeConverter) r15;
        if (r16.getFrom().isSameType(r10.getTo()) == false) goto L19;
        if (r16.getTo().isSameType(r10.getFrom()) == false) goto L19;
        r5 = r15;
    L26:
        return (TypeConverter) r5;
    L34:
        return new UpCastTypeConverter(r10.getTo(), r10.getFrom());
    L35:
        return r10;
    }
}
