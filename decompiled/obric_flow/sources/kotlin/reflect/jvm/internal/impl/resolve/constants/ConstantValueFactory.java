package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConstantValueFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstantValueFactory.kt\norg/jetbrains/kotlin/resolve/constants/ConstantValueFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1603#2,9:104\n1855#2:113\n1856#2:115\n1612#2:116\n1#3:114\n*S KotlinDebug\n*F\n+ 1 ConstantValueFactory.kt\norg/jetbrains/kotlin/resolve/constants/ConstantValueFactory\n*L\n64#1:104,9\n64#1:113\n64#1:115\n64#1:116\n64#1:114\n*E\n"})
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = null;

    static {
        INSTANCE = new ConstantValueFactory();
    }

    private ConstantValueFactory() {
    }

    public static /* synthetic */ ConstantValue createConstantValue$default(ConstantValueFactory r5, Object r10, ModuleDescriptor r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = null;
    L6:
        return r5.createConstantValue(r10, r11);
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> r5, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r10, "type");
        return new TypedArrayValue(r5, r10);
    }

    public final ConstantValue<?> createConstantValue(Object r5, ModuleDescriptor r10) {
        if ((r5 instanceof Byte) == false) goto L6;
        return new ByteValue(((Number) r5).byteValue());
    L6:
        if ((r5 instanceof Short) == false) goto L9;
        return new ShortValue(((Number) r5).shortValue());
    L9:
        if ((r5 instanceof Integer) == false) goto L12;
        return new IntValue(((Number) r5).intValue());
    L12:
        if ((r5 instanceof Long) == false) goto L15;
        return new LongValue(((Number) r5).longValue());
    L15:
        if ((r5 instanceof Character) == false) goto L18;
        return new CharValue(((Character) r5).charValue());
    L18:
        if ((r5 instanceof Float) == false) goto L21;
        return new FloatValue(((Number) r5).floatValue());
    L21:
        if ((r5 instanceof Double) == false) goto L24;
        return new DoubleValue(((Number) r5).doubleValue());
    L24:
        if ((r5 instanceof Boolean) == false) goto L27;
        return new BooleanValue(((Boolean) r5).booleanValue());
    L27:
        if ((r5 instanceof String) == false) goto L30;
        return new StringValue((String) r5);
    L30:
        if ((r5 instanceof byte[]) == false) goto L33;
        return createArrayValue(ArraysKt.toList((byte[]) r5), r10, PrimitiveType.BYTE);
    L33:
        if ((r5 instanceof short[]) == false) goto L36;
        return createArrayValue(ArraysKt.toList((short[]) r5), r10, PrimitiveType.SHORT);
    L36:
        if ((r5 instanceof int[]) == false) goto L39;
        return createArrayValue(ArraysKt.toList((int[]) r5), r10, PrimitiveType.INT);
    L39:
        if ((r5 instanceof long[]) == false) goto L42;
        return createArrayValue(ArraysKt.toList((long[]) r5), r10, PrimitiveType.LONG);
    L42:
        if ((r5 instanceof char[]) == false) goto L45;
        return createArrayValue(ArraysKt.toList((char[]) r5), r10, PrimitiveType.CHAR);
    L45:
        if ((r5 instanceof float[]) == false) goto L48;
        return createArrayValue(ArraysKt.toList((float[]) r5), r10, PrimitiveType.FLOAT);
    L48:
        if ((r5 instanceof double[]) == false) goto L51;
        return createArrayValue(ArraysKt.toList((double[]) r5), r10, PrimitiveType.DOUBLE);
    L51:
        if ((r5 instanceof boolean[]) == true) goto L73;
        if (r5 == null) goto L74;
        return null;
    L74:
        return new NullValue();
    L73:
        return createArrayValue(ArraysKt.toList((boolean[]) r5), r10, PrimitiveType.BOOLEAN);
    }

    private final ArrayValue createArrayValue(List<?> r5, ModuleDescriptor r10, final PrimitiveType r11) {
        List r12 = CollectionsKt.toList(r5);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        ConstantValue r15 = createConstantValue$default(this, r14.next(), null, 2, null);
        if (r15 == null) goto L4;
        r13.add(r15);
        goto L4
    L8:
        if (r10 == null) goto L11;
        return new TypedArrayValue(r13, r10.getBuiltIns().getPrimitiveArrayKotlinType(r11));
    L11:
        return new ArrayValue(r13, new AnonymousClass1(r11));
    }
}
