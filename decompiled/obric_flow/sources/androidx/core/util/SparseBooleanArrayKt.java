package androidx.core.util;

import android.util.SparseBooleanArray;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006 "}, d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", STGroup.DICT_KEY, "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray r5, int r10) {
        if (r5.indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseBooleanArray r5, int r10) {
        if (r5.indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseBooleanArray r5, boolean r10) {
        if (r5.indexOfValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseBooleanArray r5, Function2<? super Integer, ? super Boolean, Unit> r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.mo2invoke(Integer.valueOf(r5.keyAt(r12)), Boolean.valueOf(r5.valueAt(r12)));
        r12 = r12 + 1;
        goto L3
    }

    public static final boolean getOrDefault(SparseBooleanArray r5, int r10, boolean r11) {
        return r5.get(r10, r11);
    }

    public static final boolean getOrElse(SparseBooleanArray r5, int r10, Function0<Boolean> r11) {
        int r12 = r5.indexOfKey(r10);
        if (r12 < 0) goto L6;
        return r5.valueAt(r12);
    L6:
        return r11.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray r5) {
        return r5.size();
    }

    public static final boolean isEmpty(SparseBooleanArray r5) {
        if (r5.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseBooleanArray r5) {
        if (r5.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseBooleanArray r5) {
        return new AnonymousClass1(r5);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray r5, SparseBooleanArray r10) {
        int r11 = r5.size();
        SparseBooleanArray r12 = new SparseBooleanArray(r10.size() + r11);
        putAll(r12, r5);
        putAll(r12, r10);
        return r12;
    }

    public static final void putAll(SparseBooleanArray r5, SparseBooleanArray r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5.put(r10.keyAt(r12), r10.valueAt(r12));
        r12 = r12 + 1;
        goto L3
    }

    public static final boolean remove(SparseBooleanArray r5, int r10, boolean r11) {
        int r12 = r5.indexOfKey(r10);
        if (r12 >= 0) goto L5;
        return false;
    L5:
        if (r11 != r5.valueAt(r12)) goto L10;
        r5.delete(r10);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseBooleanArray r5, int r10, boolean r11) {
        r5.put(r10, r11);
    }

    public static final BooleanIterator valueIterator(final SparseBooleanArray r5) {
        return new C00761(r5);
    }
}
