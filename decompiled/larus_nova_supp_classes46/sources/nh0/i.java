package nh0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lnh0/i;", "Ltf0/d;", "", "resourceType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setResourceType", "(Ljava/lang/String;)V", "value", "i", "setValue", "Lnh0/j;", "style", "Lnh0/j;", "h", "()Lnh0/j;", "setStyle", "(Lnh0/j;)V", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i extends tf0.d {

    @SerializedName("resource_type")
    private String resourceType;

    @SerializedName("style")
    private j style;

    @SerializedName("value")
    private String value;

    public static final class a {
    }

    static {
    }

    public i() {
        super(0);
        this.resourceType = "0";
    }

    @Override // tf0.d
    public final String toString() {
        StringBuilder r0 = new StringBuilder("resourceType = ");
        r0.append(this.resourceType);
        r0.append(", value = ");
        r0.append(this.value);
        r0.append(",visible:");
        r0.append(d());
        r0.append("--");
        r0.append(c());
        r0.append("---animationType:");
        j r1 = this.style;
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String g() {
        return this.resourceType;
    }

    public final j h() {
        return this.style;
    }

    public final String i() {
        return this.value;
    }

    @Override // tf0.d
    public final boolean e(tf0.d r5) {
        if (super.e(r5) == true) goto L6;
        return false;
    L6:
        if (this != r5) goto L8;
        return true;
    L8:
        if (r5 != null) goto L10;
        return false;
    L10:
        if ((!Intrinsics.areEqual(i.class, r5.getClass())) == true) goto L27;
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.resourceType, r6.resourceType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value, r6.value) == false) goto L24;
        j r2 = this.style;
        if (r2 != null) goto L19;
        return false;
    L19:
        if (r2.f(r6.style) != true) goto L26;
        return true;
    L26:
        return false;
    L24:
        return false;
    L27:
        return false;
    }
}
