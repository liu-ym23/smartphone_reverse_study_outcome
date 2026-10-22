package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Entity
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Preference {

    @PrimaryKey
    @ColumnInfo(name = "key")
    private final String key;

    @ColumnInfo(name = "long_value")
    private final Long value;

    public Preference(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.key = r10;
        this.value = r11;
    }

    public Preference(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (r11 == false) goto L5;
        long r12 = 1;
    L6:
        this(r10, Long.valueOf(r12));
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public static /* synthetic */ Preference copy$default(Preference r10, String r11, Long r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.key;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.value;
    L9:
        return r10.copy(r11, r12);
    }

    public final String component1() {
        return this.key;
    }

    public final Long component2() {
        return this.value;
    }

    public final Preference copy(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return new Preference(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Preference) == true) goto L8;
        return false;
    L8:
        Preference r11 = (Preference) r10;
        if (Intrinsics.areEqual(this.key, r11.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r11.value) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int r10 = this.key.hashCode() * 31;
        Long r11 = this.value;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }
}
