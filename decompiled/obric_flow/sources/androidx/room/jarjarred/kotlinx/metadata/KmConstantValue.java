package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmConstantValue;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmConstantValue {
    private final Object value;

    public KmConstantValue(Object r5) {
        this.value = r5;
    }

    public static /* synthetic */ KmConstantValue copy$default(KmConstantValue r5, Object r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.value;
    L6:
        return r5.copy(r10);
    }

    public final Object component1() {
        return this.value;
    }

    public final KmConstantValue copy(Object r5) {
        return new KmConstantValue(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmConstantValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.value, ((KmConstantValue) r5).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object r5 = this.value;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public String toString() {
        return "KmConstantValue(value=" + this.value + ')';
    }
}
