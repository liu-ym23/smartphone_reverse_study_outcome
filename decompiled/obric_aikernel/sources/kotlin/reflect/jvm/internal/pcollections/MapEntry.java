package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K r10, V r11) {
        this.key = r10;
        this.value = r11;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof MapEntry) == true) goto L5;
        return false;
    L5:
        MapEntry r11 = (MapEntry) r10;
        K r12 = this.key;
        if (r12 != null) goto L11;
        if (r11.key != null) goto L21;
    L12:
        V r13 = this.value;
        if (r13 != null) goto L18;
        if (r11.value != null) goto L23;
    L19:
        return true;
    L23:
        return false;
    L18:
        if (r13.equals(r11.value) == true) goto L19;
        return false;
    L21:
        return false;
    L11:
        if (r12.equals(r11.key) == true) goto L12;
        return false;
    }

    public int hashCode() {
        K r10 = this.key;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        V r13 = this.value;
        if (r13 == null) goto L11;
        r11 = r13.hashCode();
    L11:
        return r12 ^ r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
