package androidx.work;

import com.bytedance.crash.entity.EventBody;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    public ArrayCreatingInputMerger() {
    }

    private final Object concatenateArrayAndNonArray(Object r10, Object r11, Class<?> r12) {
        int r13 = Array.getLength(r10);
        Object r14 = Array.newInstance(r12, r13 + 1);
        System.arraycopy(r10, 0, r14, 0, r13);
        Array.set(r14, r13, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "newArray");
        return r14;
    }

    private final Object concatenateArrays(Object r10, Object r11) {
        int r12 = Array.getLength(r10);
        int r13 = Array.getLength(r11);
        Class<?> r14 = r10.getClass().getComponentType();
        Intrinsics.checkNotNull(r14);
        Object r15 = Array.newInstance(r14, r12 + r13);
        System.arraycopy(r10, 0, r15, 0, r12);
        System.arraycopy(r11, 0, r15, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r15, "newArray");
        return r15;
    }

    private final Object createArrayFor(Object r10, Class<?> r11) {
        Object r12 = Array.newInstance(r11, 1);
        Array.set(r12, 0, r10);
        Intrinsics.checkNotNullExpressionValue(r12, "newArray");
        return r12;
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> r10) {
        Intrinsics.checkNotNullParameter(r10, "inputs");
        Data.Builder r11 = new Data.Builder();
        HashMap r12 = new HashMap();
        Iterator<Data> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L27;
        Map<String, Object> r14 = r13.next().getKeyValueMap();
        Intrinsics.checkNotNullExpressionValue(r14, "input.keyValueMap");
        Iterator<Map.Entry<String, Object>> r15 = r14.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L4;
        Map.Entry<String, Object> r16 = r15.next();
        String r17 = r16.getKey();
        Object r18 = r16.getValue();
        if (r18 == null) goto L11;
        Class<?> r19 = r18.getClass();
    L12:
        Object r20 = r12.get(r17);
        Intrinsics.checkNotNullExpressionValue(r17, "key");
        if (r20 == null) goto L15;
        Class<?> r21 = r20.getClass();
        if (Intrinsics.areEqual(r21, r19) == false) goto L22;
        Intrinsics.checkNotNullExpressionValue(r18, EventBody.KEY_VALUE);
        r18 = concatenateArrays(r20, r18);
    L24:
        Intrinsics.checkNotNullExpressionValue(r18, "if (existingValue == nul…      }\n                }");
        r12.put(r17, r18);
        goto L7
    L22:
        if (Intrinsics.areEqual(r21.getComponentType(), r19) == false) goto L26;
        r18 = concatenateArrayAndNonArray(r20, r18, r19);
        goto L24
    L26:
        throw new IllegalArgumentException();
    L15:
        if (r19.isArray() == true) goto L24;
        r18 = createArrayFor(r18, r19);
        goto L24
    L11:
        r19 = String.class;
        goto L12
    L27:
        r11.putAll(r12);
        Data r22 = r11.build();
        Intrinsics.checkNotNullExpressionValue(r22, "output.build()");
        return r22;
    }
}
