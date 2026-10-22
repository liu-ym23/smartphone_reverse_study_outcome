package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherPropertyFactory {

    /* JADX INFO: renamed from: org.apache.poi.ddf.EscherPropertyFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder = null;

        static {
            int[] r0 = new int[EscherPropertyTypesHolder.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder = r0;
            r0[EscherPropertyTypesHolder.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder[EscherPropertyTypesHolder.RGB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder[EscherPropertyTypesHolder.SHAPE_PATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public EscherPropertyFactory() {
    }

    public List<EscherProperty> createProperties(byte[] r10, int r11, short r12) {
        ArrayList r9 = new ArrayList();
        int r1 = 0;
    L3:
        if (r1 >= r12) goto L24;
        short r2 = LittleEndian.getShort(r10, r11);
        int r3 = LittleEndian.getInt(r10, r11 + 2);
        if ((Short.MIN_VALUE & r2) == 0) goto L7;
        boolean r4 = true;
    L8:
        EscherPropertyTypes r6 = EscherPropertyTypes.forPropertyID(r2);
        int r7 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder[r6.holder.ordinal()];
        if (r7 != 1) goto L11;
        BiFunction r5 = $$Lambda$PYy7PuIoqVbRIN4JI6lgZAqVUAs.INSTANCE;
    L23:
        r9.add(r5.apply(Short.valueOf(r2), Integer.valueOf(r3)));
        r11 = r11 + 6;
        r1 = r1 + 1;
        goto L3
    L11:
        if (r7 != 2) goto L13;
        r5 = $$Lambda$unM9hPeJZ0iVihRg4_jmAzNDI.INSTANCE;
        goto L23
    L13:
        if (r7 == 3) goto L20;
        if (r4 == true) goto L16;
        r5 = $$Lambda$qVLegw2v8PeuvNGvuDrntrxBfY.INSTANCE;
        goto L23
    L16:
        if (r6.holder != EscherPropertyTypesHolder.ARRAY) goto L18;
        r5 = $$Lambda$pk1uUVYqCbq77aRSz1NN2gpy7E.INSTANCE;
        goto L23
    L18:
        r5 = $$Lambda$GEjf9BlSYWSKcoLzAesJntrbg_E.INSTANCE;
        goto L23
    L20:
        r5 = $$Lambda$di6TIDxa7mvk0dcYeC83fLdYjKw.INSTANCE;
        goto L23
    L7:
        r4 = false;
        goto L8
    L24:
        Iterator r13 = r9.iterator();
    L26:
        if (r13.hasNext() == false) goto L38;
        EscherProperty r0 = (EscherProperty) ZeusTransformUtils.preCheckCast(r13.next(), EscherProperty.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, EscherArrayProperty.class) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r0, EscherComplexProperty.class) == false) goto L26;
        EscherComplexProperty r8 = (EscherComplexProperty) ZeusTransformUtils.preCheckCast(r0, EscherComplexProperty.class, "com.obric.memorydata.plugin");
        int r14 = r8.getComplexData().length;
        int r15 = r10.length - r11;
        if (r15 < r14) goto L37;
        int r16 = r8.setComplexData(r10, r11);
    L30:
        r11 = r11 + r16;
        goto L26
    L37:
        throw new IllegalStateException("Could not read complex escher property, length was " + r14 + ", but had only " + r15 + " bytes left");
    L29:
        r16 = ((EscherArrayProperty) ZeusTransformUtils.preCheckCast(r0, EscherArrayProperty.class, "com.obric.memorydata.plugin")).setArrayData(r10, r11);
        goto L30
    L38:
        return r9;
    }
}
