package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0005H\u0002JD\u0010\u001c\u001a\u00020\u001326\u0010\u001d\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00130\u001eH\u0086\bø\u0001\u0000J\u0018\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\u0015J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010#JD\u0010'\u001a\u00020\u001326\u0010\u001d\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150\u001eH\u0086\bø\u0001\u0000J/\u0010(\u001a\u00020\u00132!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150)H\u0086\bø\u0001\u0000J\u001e\u0010*\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010+R0\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "<set-?>", "", "keys", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "size", "getSize", "()I", "values", "getValues", "clear", "", "contains", "", STGroup.DICT_KEY, "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeIf", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIdentityArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdentityArrayMap.kt\nandroidx/compose/runtime/collection/IdentityArrayMap\n*L\n1#1,219:1\n125#1,22:220\n*S KotlinDebug\n*F\n+ 1 IdentityArrayMap.kt\nandroidx/compose/runtime/collection/IdentityArrayMap\n*L\n149#1:220,22\n*E\n"})
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    private int size;
    private Object[] values;

    public IdentityArrayMap() {
        int r5 = 0;
        this(r5, 1, null);
    }

    public static final /* synthetic */ void access$setSize$p(IdentityArrayMap r5, int r10) {
        r5.size = r10;
    }

    private final int find(Object r10) {
        int r5 = ActualJvm_jvmKt.identityHashCode(r10);
        int r11 = this.size - 1;
        Object[] r12 = this.keys;
        int r13 = 0;
    L3:
        if (r13 > r11) goto L14;
        int r14 = (r13 + r11) >>> 1;
        Object r15 = r12[r14];
        int r16 = ActualJvm_jvmKt.identityHashCode(r15);
        if (r16 < r5) goto L6;
        if (r16 <= r5) goto L9;
        r11 = r14 - 1;
        goto L3
    L9:
        if (r10 != r15) goto L12;
        return r14;
    L12:
        return findExactIndex(r14, r10, r5);
    L6:
        r13 = r14 + 1;
        goto L3
    L14:
        return -(r13 + 1);
    }

    private final int findExactIndex(int r5, Object r10, int r11) {
        Object[] r12 = this.keys;
        int r13 = this.size;
        int r14 = r5 - 1;
    L4:
        if ((-1) >= r14) goto L12;
        Object r15 = r12[r14];
        if (r15 == r10) goto L7;
        if (ActualJvm_jvmKt.identityHashCode(r15) != r11) goto L12;
        r14 = r14 - 1;
        goto L4
    L7:
        return r14;
    L12:
        r5 = r5 + 1;
        if (r5 >= r13) goto L22;
        Object r16 = r12[r5];
        if (r16 == r10) goto L16;
        if (ActualJvm_jvmKt.identityHashCode(r16) == r11) goto L12;
        return -(r5 + 1);
    L16:
        return r5;
    L22:
        return -(r13 + 1);
    }

    public final void clear() {
        this.size = 0;
        ArraysKt.j(this.keys, null);
        ArraysKt.j(this.values, null);
    }

    public final boolean contains(Key r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (find(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        int r10 = getSize();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Object r12 = getKeys()[r11];
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
        r5.mo2invoke(r12, getValues()[r11]);
        r11 = r11 + 1;
        goto L3
    }

    public final Value get(Key r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        int r10 = find(r5);
        if (r10 >= 0) goto L7;
        return null;
    L7:
        return (Value) this.values[r10];
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this.size <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Value remove(Key r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        int r11 = find(r10);
        if (r11 < 0) goto L6;
        Object[] r5 = this.values;
        Value r12 = (Value) r5[r11];
        int r13 = this.size;
        Object[] r14 = this.keys;
        int r15 = r11 + 1;
        ArraysKt.copyInto(r14, r14, r11, r15, r13);
        ArraysKt.copyInto(r5, r5, r11, r15, r13);
        int r16 = r13 - 1;
        r14[r16] = null;
        r5[r16] = null;
        this.size = r16;
        return r12;
    L6:
        return null;
    }

    public final void removeIf(Function2<? super Key, ? super Value, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        int r5 = getSize();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r5) goto L11;
        Object r13 = getKeys()[r11];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
        if (r10.mo2invoke(r13, getValues()[r11]).booleanValue() == true) goto L9;
        if (r12 == r11) goto L8;
        getKeys()[r12] = r13;
        getValues()[r12] = getValues()[r11];
    L8:
        r12 = r12 + 1;
    L9:
        r11 = r11 + 1;
        goto L3
    L11:
        if (getSize() <= r12) goto L21;
        int r14 = getSize();
        int r15 = r12;
    L13:
        if (r15 >= r14) goto L15;
        getKeys()[r15] = null;
        getValues()[r15] = null;
        r15 = r15 + 1;
        goto L13
    L15:
        access$setSize$p(this, r12);
        return;
    }

    public final void removeValueIf(Function1<? super Value, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        int r5 = getSize();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r5) goto L11;
        Object r13 = getKeys()[r11];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
        if (r10.invoke(getValues()[r11]).booleanValue() == true) goto L9;
        if (r12 == r11) goto L8;
        getKeys()[r12] = r13;
        getValues()[r12] = getValues()[r11];
    L8:
        r12 = r12 + 1;
    L9:
        r11 = r11 + 1;
        goto L3
    L11:
        if (getSize() <= r12) goto L21;
        int r14 = getSize();
        int r15 = r12;
    L13:
        if (r15 >= r14) goto L15;
        getKeys()[r15] = null;
        getValues()[r15] = null;
        r15 = r15 + 1;
        goto L13
    L15:
        access$setSize$p(this, r12);
        return;
    }

    public final void set(Key r11, Value r12) {
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        Object[] r5 = this.keys;
        Object[] r10 = this.values;
        int r13 = this.size;
        int r14 = find(r11);
        if (r14 < 0) goto L5;
        r10[r14] = r12;
        return;
    L5:
        int r15 = -(r14 + 1);
        if (r13 != r5.length) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == false) goto L11;
        Object[] r17 = new Object[r13 * 2];
    L12:
        int r18 = r15 + 1;
        ArraysKt.copyInto(r5, r17, r18, r15, r13);
        if (r16 == false) goto L15;
        ArraysKt.f(r5, r17, 0, r15, 6);
    L15:
        r17[r15] = r11;
        this.keys = r17;
        if (r16 == false) goto L18;
        Object[] r19 = new Object[r13 * 2];
    L19:
        ArraysKt.copyInto(r10, r19, r18, r15, r13);
        if (r16 == false) goto L22;
        ArraysKt.f(r10, r19, 0, r15, 6);
    L22:
        r19[r15] = r12;
        this.values = r19;
        this.size++;
        return;
    L18:
        r19 = r10;
        goto L19
    L11:
        r17 = r5;
        goto L12
    L8:
        r16 = false;
        goto L9
    }

    public IdentityArrayMap(int r5) {
        this.keys = new Object[r5];
        this.values = new Object[r5];
    }

    public /* synthetic */ IdentityArrayMap(int r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = 16;
    L5:
        this(r5);
    }
}
