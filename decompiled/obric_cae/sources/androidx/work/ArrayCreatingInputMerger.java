package androidx.work;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends j {
    public ArrayCreatingInputMerger() {
    }

    @Override // androidx.work.j
    public final e a(ArrayList r12) {
        e.a r11 = new e.a();
        HashMap r8 = new HashMap();
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L28;
        Map r10 = Collections.unmodifiableMap(((e) r13.next()).f2824a);
        he.i.e(r10, "input.keyValueMap");
        Iterator r14 = r10.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L4;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        Object r17 = r15.getValue();
        if (r17 == null) goto L11;
        Class<?> r18 = r17.getClass();
    L12:
        Object r19 = r8.get(r16);
        he.i.e(r16, "key");
        if (r19 == null) goto L15;
        Class<?> r20 = r19.getClass();
        if (he.i.a(r20, r18) == false) goto L23;
        he.i.e(r17, "value");
        int r21 = Array.getLength(r19);
        int r22 = Array.getLength(r17);
        Class<?> r23 = r19.getClass().getComponentType();
        he.i.c(r23);
        Object r24 = Array.newInstance(r23, r21 + r22);
        System.arraycopy(r19, 0, r24, 0, r21);
        System.arraycopy(r17, 0, r24, r21, r22);
        he.i.e(r24, "newArray");
        r17 = r24;
    L25:
        he.i.e(r17, "if (existingValue == nul…      }\n                }");
        r8.put(r16, r17);
        goto L7
    L23:
        if (he.i.a(r20.getComponentType(), r18) == false) goto L27;
        int r25 = Array.getLength(r19);
        Object r26 = Array.newInstance(r18, r25 + 1);
        System.arraycopy(r19, 0, r26, 0, r25);
        Array.set(r26, r25, r17);
        he.i.e(r26, "newArray");
    L18:
        r17 = r26;
        goto L25
    L27:
        throw new IllegalArgumentException();
    L15:
        if (r18.isArray() == true) goto L25;
        r26 = Array.newInstance(r18, 1);
        Array.set(r26, 0, r17);
        he.i.e(r26, "newArray");
        goto L18
    L11:
        r18 = String.class;
        goto L12
    L28:
        r11.b(r8);
        return r11.a();
    }
}
