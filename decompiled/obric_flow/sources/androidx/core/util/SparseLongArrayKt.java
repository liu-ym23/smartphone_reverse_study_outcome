package androidx.core.util;

import android.util.SparseLongArray;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0086\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0086\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0002\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086\n\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", STGroup.DICT_KEY, "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray r5, int r10) {
        if (r5.indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseLongArray r5, int r10) {
        if (r5.indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseLongArray r5, long r10) {
        if (r5.indexOfValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseLongArray r5, Function2<? super Integer, ? super Long, Unit> r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.mo2invoke(Integer.valueOf(r5.keyAt(r12)), Long.valueOf(r5.valueAt(r12)));
        r12 = r12 + 1;
        goto L3
    }

    public static final long getOrDefault(SparseLongArray r5, int r10, long r11) {
        return r5.get(r10, r11);
    }

    public static final long getOrElse(SparseLongArray r5, int r10, Function0<Long> r11) {
        int r12 = r5.indexOfKey(r10);
        if (r12 < 0) goto L6;
        return r5.valueAt(r12);
    L6:
        return r11.invoke().longValue();
    }

    public static final int getSize(SparseLongArray r5) {
        return r5.size();
    }

    public static final boolean isEmpty(SparseLongArray r5) {
        if (r5.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray r5) {
        if (r5.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseLongArray r5) {
        return new AnonymousClass1(r5);
    }

    public static final SparseLongArray plus(SparseLongArray r5, SparseLongArray r10) {
        int r11 = r5.size();
        SparseLongArray r12 = new SparseLongArray(r10.size() + r11);
        putAll(r12, r5);
        putAll(r12, r10);
        return r12;
    }

    public static final void putAll(SparseLongArray r5, SparseLongArray r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5.put(r10.keyAt(r12), r10.valueAt(r12));
        r12 = r12 + 1;
        goto L3
    }

    public static final boolean remove(SparseLongArray r5, int r10, long r11) {
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

    public static final void set(SparseLongArray r5, int r10, long r11) {
        r5.put(r10, r11);
    }

    public static final LongIterator valueIterator(final SparseLongArray r5) {
        return new C00781(r5);
    }
}
