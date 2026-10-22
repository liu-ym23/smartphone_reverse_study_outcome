package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = null;

    static {
        INSTANCE = new ConstantValueFactory();
    }

    private ConstantValueFactory() {
    }

    private final ArrayValue createArrayValue(List<?> r10, final PrimitiveType r11) {
        List r12 = CollectionsKt.toList(r10);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        ConstantValue<?> r15 = createConstantValue(r14.next());
        if (r15 == null) goto L4;
        r13.add(r15);
        goto L4
    L9:
        return new ArrayValue(r13, new AnonymousClass3(r11));
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> r10, final KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        return new ArrayValue(r10, new AnonymousClass1(r11));
    }

    public final ConstantValue<?> createConstantValue(Object r10) {
        if ((r10 instanceof Byte) == false) goto L6;
        return new ByteValue(((Number) r10).byteValue());
    L6:
        if ((r10 instanceof Short) == false) goto L9;
        return new ShortValue(((Number) r10).shortValue());
    L9:
        if ((r10 instanceof Integer) == false) goto L12;
        return new IntValue(((Number) r10).intValue());
    L12:
        if ((r10 instanceof Long) == false) goto L15;
        return new LongValue(((Number) r10).longValue());
    L15:
        if ((r10 instanceof Character) == false) goto L18;
        return new CharValue(((Character) r10).charValue());
    L18:
        if ((r10 instanceof Float) == false) goto L21;
        return new FloatValue(((Number) r10).floatValue());
    L21:
        if ((r10 instanceof Double) == false) goto L24;
        return new DoubleValue(((Number) r10).doubleValue());
    L24:
        if ((r10 instanceof Boolean) == false) goto L27;
        return new BooleanValue(((Boolean) r10).booleanValue());
    L27:
        if ((r10 instanceof String) == false) goto L30;
        return new StringValue((String) r10);
    L30:
        if ((r10 instanceof byte[]) == false) goto L34;
        List<?> r11 = ArraysKt.toList((byte[]) r10);
        PrimitiveType r12 = PrimitiveType.BYTE;
    L67:
        return createArrayValue(r11, r12);
    L34:
        if ((r10 instanceof short[]) == false) goto L37;
        r11 = ArraysKt.toList((short[]) r10);
        r12 = PrimitiveType.SHORT;
        goto L67
    L37:
        if ((r10 instanceof int[]) == false) goto L40;
        r11 = ArraysKt.toList((int[]) r10);
        r12 = PrimitiveType.INT;
        goto L67
    L40:
        if ((r10 instanceof long[]) == false) goto L43;
        r11 = ArraysKt.toList((long[]) r10);
        r12 = PrimitiveType.LONG;
        goto L67
    L43:
        if ((r10 instanceof char[]) == false) goto L46;
        r11 = ArraysKt.toList((char[]) r10);
        r12 = PrimitiveType.CHAR;
        goto L67
    L46:
        if ((r10 instanceof float[]) == false) goto L49;
        r11 = ArraysKt.toList((float[]) r10);
        r12 = PrimitiveType.FLOAT;
        goto L67
    L49:
        if ((r10 instanceof double[]) == false) goto L52;
        r11 = ArraysKt.toList((double[]) r10);
        r12 = PrimitiveType.DOUBLE;
        goto L67
    L52:
        if ((r10 instanceof boolean[]) == false) goto L54;
        r11 = ArraysKt.toList((boolean[]) r10);
        r12 = PrimitiveType.BOOLEAN;
        goto L67
    L54:
        if (r10 == null) goto L68;
        return null;
    L68:
        return new NullValue();
    }
}
