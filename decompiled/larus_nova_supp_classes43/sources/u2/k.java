package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/applet/granting/PermissionData;", "", "scopeName", "", "scopeDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getScopeName", "()Ljava/lang/String;", "getScopeDescription", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("scopeDescription")
    private final String scopeDescription;

    @SerializedName("scopeName")
    private final String scopeName;

    public k() {
        this(null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L8;
        return false;
    L8:
        k r11 = (k) r10;
        if (Intrinsics.areEqual(this.scopeName, r11.scopeName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scopeDescription, r11.scopeDescription) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.scopeName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.scopeDescription;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PermissionData(scopeName=" + this.scopeName + ", scopeDescription=" + this.scopeDescription + ')';
    }

    public final String b() {
        return this.scopeDescription;
    }

    public final String c() {
        return this.scopeName;
    }

    public k(String r1, String r10) {
        this.scopeName = r1;
        this.scopeDescription = r10;
    }

    public static k a(k r1, String r10) {
        String r0 = r1.scopeName;
        r1.getClass();
        return new k(r0, r10);
    }
}
