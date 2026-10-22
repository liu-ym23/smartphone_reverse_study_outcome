package androidx.core.content;

import android.content.ContentValues;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        ContentValues r11 = new ContentValues(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L37;
        Pair<String, ? extends Object> r14 = r10[r13];
        String r15 = r14.component1();
        Object r16 = r14.component2();
        if (r16 != null) goto L8;
        r11.putNull(r15);
    L34:
        r13 = r13 + 1;
        goto L3
    L8:
        if ((r16 instanceof String) == false) goto L11;
        r11.put(r15, (String) r16);
        goto L34
    L11:
        if ((r16 instanceof Integer) == false) goto L14;
        r11.put(r15, (Integer) r16);
        goto L34
    L14:
        if ((r16 instanceof Long) == false) goto L17;
        r11.put(r15, (Long) r16);
        goto L34
    L17:
        if ((r16 instanceof Boolean) == false) goto L20;
        r11.put(r15, (Boolean) r16);
        goto L34
    L20:
        if ((r16 instanceof Float) == false) goto L23;
        r11.put(r15, (Float) r16);
        goto L34
    L23:
        if ((r16 instanceof Double) == false) goto L26;
        r11.put(r15, (Double) r16);
        goto L34
    L26:
        if ((r16 instanceof byte[]) == false) goto L29;
        r11.put(r15, (byte[]) r16);
        goto L34
    L29:
        if ((r16 instanceof Byte) == false) goto L32;
        r11.put(r15, (Byte) r16);
        goto L34
    L32:
        if ((r16 instanceof Short) == false) goto L36;
        r11.put(r15, (Short) r16);
        goto L34
    L36:
        throw new IllegalArgumentException("Illegal value type " + r16.getClass().getCanonicalName() + " for key \"" + r15 + Typography.quote);
    L37:
        return r11;
    }
}
