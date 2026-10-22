package gb;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lgb/b;", "", "", "id", "Ljava/lang/String;", "a", "()Ljava/lang/String;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "b", "defaultValue", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "param", "c", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("d")
    private final Object defaultValue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("$t")
    private final String f20id;

    @SerializedName("n")
    private final String name;

    @SerializedName("p")
    private final Object param;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.f20id, r11.f20id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultValue, r11.defaultValue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.param, r11.param) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.f20id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.name;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        Object r15 = this.defaultValue;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Object r18 = this.param;
        if (r18 == null) goto L19;
        r1 = r18.hashCode();
    L19:
        return r17 + r1;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Expression(id=" + this.f20id + ", name=" + this.name + ", defaultValue=" + this.defaultValue + ", param=" + this.param + ')';
    }

    public b() {
        this.f20id = null;
        this.name = null;
        this.defaultValue = null;
        this.param = null;
    }

    public final String a() {
        return this.f20id;
    }

    public final String b() {
        return this.name;
    }

    public final Object c() {
        return this.param;
    }
}
