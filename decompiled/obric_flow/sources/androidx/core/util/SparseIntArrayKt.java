package androidx.core.util;

import android.util.SparseIntArray;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u0018*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001f"}, d2 = {"size", "", "Landroid/util/SparseIntArray;", "getSize", "(Landroid/util/SparseIntArray;)I", "contains", "", STGroup.DICT_KEY, "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray r5, int r10) {
        if (r5.indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseIntArray r5, int r10) {
        if (r5.indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseIntArray r5, int r10) {
        if (r5.indexOfValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseIntArray r5, Function2<? super Integer, ? super Integer, Unit> r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.mo2invoke(Integer.valueOf(r5.keyAt(r12)), Integer.valueOf(r5.valueAt(r12)));
        r12 = r12 + 1;
        goto L3
    }

    public static final int getOrDefault(SparseIntArray r5, int r10, int r11) {
        return r5.get(r10, r11);
    }

    public static final int getOrElse(SparseIntArray r5, int r10, Function0<Integer> r11) {
        int r12 = r5.indexOfKey(r10);
        if (r12 < 0) goto L6;
        return r5.valueAt(r12);
    L6:
        return r11.invoke().intValue();
    }

    public static final int getSize(SparseIntArray r5) {
        return r5.size();
    }

    public static final boolean isEmpty(SparseIntArray r5) {
        if (r5.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseIntArray r5) {
        if (r5.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseIntArray r5) {
        return new AnonymousClass1(r5);
    }

    public static final SparseIntArray plus(SparseIntArray r5, SparseIntArray r10) {
        int r11 = r5.size();
        SparseIntArray r12 = new SparseIntArray(r10.size() + r11);
        putAll(r12, r5);
        putAll(r12, r10);
        return r12;
    }

    public static final void putAll(SparseIntArray r5, SparseIntArray r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5.put(r10.keyAt(r12), r10.valueAt(r12));
        r12 = r12 + 1;
        goto L3
    }

    public static final boolean remove(SparseIntArray r5, int r10, int r11) {
        int r12 = r5.indexOfKey(r10);
        if (r12 >= 0) goto L5;
        return false;
    L5:
        if (r11 != r5.valueAt(r12)) goto L10;
        r5.removeAt(r12);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseIntArray r5, int r10, int r11) {
        r5.put(r10, r11);
    }

    public static final IntIterator valueIterator(final SparseIntArray r5) {
        return new C00771(r5);
    }
}
