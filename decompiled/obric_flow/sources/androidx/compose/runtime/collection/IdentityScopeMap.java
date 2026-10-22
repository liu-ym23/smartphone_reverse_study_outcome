package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0011\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0002H\u0086\u0002J\u0012\u0010\"\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020\fH\u0002J7\u0010&\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00022!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001f0(H\u0086\bø\u0001\u0000J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u001b\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0013\u0010-\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010.J/\u0010/\u001a\u00020\u001f2!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001a0(H\u0086\bø\u0001\u0000J#\u00101\u001a\u00020\u001f2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u001f0(H\u0082\bJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00104\u001a\u00020\fH\u0002R<\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00052\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "<set-?>", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "scopeSets", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize", "()I", "setSize", "(I)V", "", "valueOrder", "getValueOrder", "()[I", "values", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getOrCreateIdentitySet", "remove", "removeScope", "(Ljava/lang/Object;)V", "removeValueIf", "predicate", "removingScopes", "removalOperation", "scopeSetAt", "index", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIdentityScopeMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdentityScopeMap.kt\nandroidx/compose/runtime/collection/IdentityScopeMap\n+ 2 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n*L\n1#1,331:1\n244#1,8:339\n252#1,17:366\n244#1,25:383\n108#2,7:332\n269#2,19:347\n*S KotlinDebug\n*F\n+ 1 IdentityScopeMap.kt\nandroidx/compose/runtime/collection/IdentityScopeMap\n*L\n228#1:339,8\n228#1:366,17\n238#1:383,25\n82#1:332,7\n229#1:347,19\n*E\n"})
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public IdentityScopeMap() {
        int[] r5 = new int[50];
        int r10 = 0;
    L3:
        if (r10 >= 50) goto L5;
        r5[r10] = r10;
        r10 = r10 + 1;
        goto L3
    L5:
        this.valueOrder = r5;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    public static final /* synthetic */ int access$find(IdentityScopeMap r5, Object r10) {
        return r5.find(r10);
    }

    public static final /* synthetic */ IdentityArraySet access$scopeSetAt(IdentityScopeMap r5, int r10) {
        return r5.scopeSetAt(r10);
    }

    private final int find(Object r10) {
        int r5 = ActualJvm_jvmKt.identityHashCode(r10);
        int r11 = this.size - 1;
        Object[] r12 = this.values;
        int[] r13 = this.valueOrder;
        int r14 = 0;
    L3:
        if (r14 > r11) goto L14;
        int r15 = (r14 + r11) >>> 1;
        Object r16 = r12[r13[r15]];
        int r17 = ActualJvm_jvmKt.identityHashCode(r16);
        if (r17 < r5) goto L6;
        if (r17 <= r5) goto L9;
        r11 = r15 - 1;
        goto L3
    L9:
        if (r10 != r16) goto L12;
        return r15;
    L12:
        return findExactIndex(r15, r10, r5);
    L6:
        r14 = r15 + 1;
        goto L3
    L14:
        return -(r14 + 1);
    }

    private final int findExactIndex(int r5, Object r10, int r11) {
        Object[] r12 = this.values;
        int[] r13 = this.valueOrder;
        int r14 = r5 - 1;
    L4:
        if ((-1) >= r14) goto L12;
        Object r15 = r12[r13[r14]];
        if (r15 == r10) goto L7;
        if (ActualJvm_jvmKt.identityHashCode(r15) != r11) goto L12;
        r14 = r14 - 1;
        goto L4
    L7:
        return r14;
    L12:
        int r16 = r5 + 1;
        int r17 = this.size;
    L13:
        if (r16 >= r17) goto L23;
        Object r18 = r12[r13[r16]];
        if (r18 == r10) goto L16;
        if (ActualJvm_jvmKt.identityHashCode(r18) != r11) goto L20;
        r16 = r16 + 1;
        goto L13
    L20:
        return -(r16 + 1);
    L16:
        return r16;
    L23:
        return -(this.size + 1);
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object r10) {
        int r5 = this.size;
        int[] r11 = this.valueOrder;
        Object[] r12 = this.values;
        IdentityArraySet<T>[] r13 = this.scopeSets;
        if (r5 <= 0) goto L8;
        int r14 = find(r10);
        if (r14 >= 0) goto L7;
    L9:
        int r15 = -(r14 + 1);
        if (r5 >= r11.length) goto L18;
        int r16 = r11[r5];
        r12[r16] = r10;
        IdentityArraySet<T> r17 = r13[r16];
        if (r17 != null) goto L14;
        r17 = new IdentityArraySet();
        r13[r16] = r17;
    L14:
        if (r15 >= r5) goto L16;
        ArraysKt.a(r15 + 1, r15, r11, r11, r5);
    L16:
        r11[r15] = r16;
        this.size++;
        return r17;
    L18:
        int r18 = r11.length * 2;
        IdentityArraySet<T>[] r19 = (IdentityArraySet[]) Arrays.copyOf(r13, r18);
        IdentityArraySet<T> r20 = new IdentityArraySet();
        r19[r5] = r20;
        Object[] r21 = Arrays.copyOf(r12, r18);
        r21[r5] = r10;
        int[] r22 = new int[r18];
        int r23 = r5 + 1;
    L19:
        if (r23 >= r18) goto L21;
        r22[r23] = r23;
        r23 = r23 + 1;
        goto L19
    L21:
        if (r15 >= r5) goto L23;
        ArraysKt.a(r15 + 1, r15, r11, r22, r5);
    L23:
        r22[r15] = r5;
        if (r15 <= 0) goto L26;
        ArraysKt.d(r15, 6, r11, r22);
    L26:
        this.scopeSets = r19;
        this.values = r21;
        this.valueOrder = r22;
        this.size++;
        return r20;
    L7:
        return scopeSetAt(r14);
    L8:
        r14 = -1;
        goto L9
    }

    private final void removingScopes(Function1<? super IdentityArraySet<T>, Unit> r10) {
        int[] r5 = getValueOrder();
        IdentityArraySet<T>[] r11 = getScopeSets();
        Object[] r12 = getValues();
        int r13 = getSize();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L10;
        int r16 = r5[r14];
        IdentityArraySet<T> r17 = r11[r16];
        Intrinsics.checkNotNull(r17);
        r10.invoke(r17);
        if (r17.size() <= 0) goto L9;
        if (r15 == r14) goto L8;
        int r18 = r5[r15];
        r5[r15] = r16;
        r5[r14] = r18;
    L8:
        r15 = r15 + 1;
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        int r19 = getSize();
        int r20 = r15;
    L11:
        if (r20 >= r19) goto L13;
        r12[r5[r20]] = null;
        r20 = r20 + 1;
        goto L11
    L13:
        setSize(r15);
    }

    private final IdentityArraySet<T> scopeSetAt(int r5) {
        IdentityArraySet<T> r10 = this.scopeSets[this.valueOrder[r5]];
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final boolean add(Object r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r10, "scope");
        return getOrCreateIdentitySet(r5).add(r10);
    }

    public final void clear() {
        IdentityArraySet<T>[] r5 = this.scopeSets;
        int[] r10 = this.valueOrder;
        Object[] r11 = this.values;
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        IdentityArraySet<T> r14 = r5[r13];
        if (r14 == null) goto L7;
        r14.clear();
    L7:
        r10[r13] = r13;
        r11[r13] = null;
        r13 = r13 + 1;
        goto L3
    L8:
        this.size = 0;
    }

    public final boolean contains(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        if (find(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void forEachScopeOf(Object r5, Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r10, "block");
        int r11 = access$find(this, r5);
        if (r11 < 0) goto L7;
        IdentityArraySet r12 = access$scopeSetAt(this, r11);
        Object[] r13 = r12.getValues();
        int r14 = r12.size();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L9;
        Object r16 = r13[r15];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        r10.invoke(r16);
        r15 = r15 + 1;
        goto L5
    L9:
        return;
    }

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final boolean remove(Object r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "value");
        Intrinsics.checkNotNullParameter(r11, "scope");
        int r12 = find(r10);
        int[] r5 = this.valueOrder;
        IdentityArraySet<T>[] r13 = this.scopeSets;
        Object[] r14 = this.values;
        int r15 = this.size;
        if (r12 < 0) goto L14;
        int r16 = r5[r12];
        IdentityArraySet<T> r17 = r13[r16];
        if (r17 != null) goto L7;
        return false;
    L7:
        boolean r18 = r17.remove(r11);
        if (r17.size() != 0) goto L13;
        int r19 = r12 + 1;
        if (r19 >= r15) goto L12;
        ArraysKt.a(r12, r19, r5, r5, r15);
    L12:
        int r20 = r15 - 1;
        r5[r20] = r16;
        r14[r16] = null;
        this.size = r20;
    L13:
        return r18;
    L14:
        return false;
    }

    public final void removeScope(T r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        int[] r5 = getValueOrder();
        IdentityArraySet<T>[] r11 = getScopeSets();
        Object[] r12 = getValues();
        int r13 = getSize();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L10;
        int r16 = r5[r14];
        IdentityArraySet<T> r17 = r11[r16];
        Intrinsics.checkNotNull(r17);
        r17.remove(r10);
        if (r17.size() <= 0) goto L9;
        if (r15 == r14) goto L8;
        int r18 = r5[r15];
        r5[r15] = r16;
        r5[r14] = r18;
    L8:
        r15 = r15 + 1;
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        int r19 = getSize();
        int r20 = r15;
    L11:
        if (r20 >= r19) goto L13;
        r12[r5[r20]] = null;
        r20 = r20 + 1;
        goto L11
    L13:
        setSize(r15);
    }

    public final void removeValueIf(Function1<? super T, Boolean> r17) {
        Intrinsics.checkNotNullParameter(r17, "predicate");
        int[] r5 = getValueOrder();
        IdentityArraySet<T>[] r10 = getScopeSets();
        Object[] r11 = getValues();
        int r12 = getSize();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r12) goto L22;
        int r15 = r5[r13];
        IdentityArraySet<T> r16 = r10[r15];
        Intrinsics.checkNotNull(r16);
        Object[] r18 = r16.getValues();
        int r19 = r16.size();
        int r110 = 0;
        int r111 = 0;
    L6:
        if (r110 >= r19) goto L13;
        Object r112 = r18[r110];
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        if (r17.invoke(r112).booleanValue() == true) goto L12;
        if (r111 == r110) goto L11;
        r18[r111] = r112;
    L11:
        r111 = r111 + 1;
    L12:
        r110 = r110 + 1;
        goto L6
    L13:
        int r20 = r111;
    L14:
        if (r20 >= r19) goto L16;
        r18[r20] = null;
        r20 = r20 + 1;
        goto L14
    L16:
        IdentityArraySet.access$setSize$p(r16, r111);
        if (r16.size() <= 0) goto L21;
        if (r14 == r13) goto L20;
        int r21 = r5[r14];
        r5[r14] = r15;
        r5[r13] = r21;
    L20:
        r14 = r14 + 1;
    L21:
        r13 = r13 + 1;
        goto L4
    L22:
        int r22 = getSize();
        int r23 = r14;
    L23:
        if (r23 >= r22) goto L25;
        r11[r5[r23]] = null;
        r23 = r23 + 1;
        goto L23
    L25:
        setSize(r14);
    }

    public final void setSize(int r5) {
        this.size = r5;
    }
}
