package androidx.compose.runtime.internal;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", STGroup.DICT_KEY, "", "get", "newWith", "value", "trySet", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThreadMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadMap.kt\nandroidx/compose/runtime/internal/ThreadMap\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,111:1\n12904#2,3:112\n*S KotlinDebug\n*F\n+ 1 ThreadMap.kt\nandroidx/compose/runtime/internal/ThreadMap\n*L\n42#1:112,3\n*E\n"})
public final class ThreadMap {
    private final long[] keys;
    private final int size;
    private final Object[] values;

    public ThreadMap(int r5, long[] r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        Intrinsics.checkNotNullParameter(r11, "values");
        this.size = r5;
        this.keys = r10;
        this.values = r11;
    }

    private final int find(long r10) {
        int r5 = this.size - 1;
        if (r5 == (-1)) goto L29;
        int r11 = 0;
        if (r5 == 0) goto L15;
    L6:
        if (r11 > r5) goto L14;
        int r12 = (r11 + r5) >>> 1;
        long r13 = this.keys[r12] - r10;
        if (r13 < 0) goto L9;
        if (r13 <= 0) goto L12;
        r5 = r12 - 1;
        goto L6
    L12:
        return r12;
    L9:
        r11 = r12 + 1;
        goto L6
    L14:
        return -(r11 + 1);
    L15:
        long r14 = this.keys[0];
        if (r14 != r10) goto L19;
        return 0;
    L19:
        if (r14 <= r10) goto L31;
        return -2;
    L31:
        return -1;
    L29:
        return -1;
    }

    public final Object get(long r5) {
        int r10 = find(r5);
        if (r10 >= 0) goto L7;
        return null;
    L7:
        return this.values[r10];
    }

    public final ThreadMap newWith(long r12, Object r14) {
        int r5 = this.size;
        Object[] r10 = this.values;
        int r11 = r10.length;
        int r13 = 0;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r11) goto L8;
        if (r10[r15] == null) goto L7;
        r16 = r16 + 1;
    L7:
        r15 = r15 + 1;
        goto L3
    L8:
        int r17 = r16 + 1;
        long[] r18 = new long[r17];
        Object[] r19 = new Object[r17];
        if (r17 <= 1) goto L26;
        int r20 = 0;
    L11:
        if (r13 >= r17) goto L19;
        if (r20 >= r5) goto L19;
        long r21 = this.keys[r20];
        Object r22 = this.values[r20];
        if (r21 > r12) goto L15;
        if (r22 == null) goto L18;
        r18[r13] = r21;
        r19[r13] = r22;
        r13 = r13 + 1;
    L18:
        r20 = r20 + 1;
        goto L11
    L15:
        r18[r13] = r12;
        r19[r13] = r14;
        r13 = r13 + 1;
    L19:
        if (r20 != r5) goto L21;
        r18[r16] = r12;
        r19[r16] = r14;
    L28:
        return new ThreadMap(r17, r18, r19);
    L21:
        if (r13 >= r17) goto L28;
        long r110 = this.keys[r20];
        Object r111 = this.values[r20];
        if (r111 == null) goto L25;
        r18[r13] = r110;
        r19[r13] = r111;
        r13 = r13 + 1;
    L25:
        r20 = r20 + 1;
        goto L21
    L26:
        r18[0] = r12;
        r19[0] = r14;
        goto L28
    }

    public final boolean trySet(long r5, Object r10) {
        int r11 = find(r5);
        if (r11 >= 0) goto L6;
        return false;
    L6:
        this.values[r11] = r10;
        return true;
    }
}
