package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... r10) {
        ContentValues r5 = new ContentValues(r10.length);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L37;
        Pair<String, ? extends Object> r13 = r10[r12];
        String r14 = r13.component1();
        Object r15 = r13.component2();
        if (r15 != null) goto L8;
        r5.putNull(r14);
    L34:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r15 instanceof String) == false) goto L11;
        r5.put(r14, (String) r15);
        goto L34
    L11:
        if ((r15 instanceof Integer) == false) goto L14;
        r5.put(r14, (Integer) r15);
        goto L34
    L14:
        if ((r15 instanceof Long) == false) goto L17;
        r5.put(r14, (Long) r15);
        goto L34
    L17:
        if ((r15 instanceof Boolean) == false) goto L20;
        r5.put(r14, (Boolean) r15);
        goto L34
    L20:
        if ((r15 instanceof Float) == false) goto L23;
        r5.put(r14, (Float) r15);
        goto L34
    L23:
        if ((r15 instanceof Double) == false) goto L26;
        r5.put(r14, (Double) r15);
        goto L34
    L26:
        if ((r15 instanceof byte[]) == false) goto L29;
        r5.put(r14, (byte[]) r15);
        goto L34
    L29:
        if ((r15 instanceof Byte) == false) goto L32;
        r5.put(r14, (Byte) r15);
        goto L34
    L32:
        if ((r15 instanceof Short) == false) goto L36;
        r5.put(r14, (Short) r15);
        goto L34
    L36:
        throw new IllegalArgumentException("Illegal value type " + r15.getClass().getCanonicalName() + " for key \"" + r14 + Typography.quote);
    L37:
        return r5;
    }
}
