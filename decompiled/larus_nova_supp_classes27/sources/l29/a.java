package l29;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/community/impl/landing/model/CreationNewUserLandingData;", "", "isCreationNewUser", "", "landingType", "", "materialType", "landingCreation", "Lcom/larus/platform/api/creation/UserCreation;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreation;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLandingType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaterialType", "getLandingCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreation;)Lcom/larus/community/impl/landing/model/CreationNewUserLandingData;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("is_creation_new_user")
    private final Boolean isCreationNewUser;

    @SerializedName("landing_creation")
    private final UserCreation landingCreation;

    @SerializedName("landing_type")
    private final Integer landingType;

    @SerializedName("material_type")
    private final Integer materialType;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.isCreationNewUser, r6.isCreationNewUser) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.landingType, r6.landingType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.materialType, r6.materialType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.landingCreation, r6.landingCreation) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.isCreationNewUser;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.landingType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.materialType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        UserCreation r10 = this.landingCreation;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationNewUserLandingData(isCreationNewUser=" + this.isCreationNewUser + ", landingType=" + this.landingType + ", materialType=" + this.materialType + ", landingCreation=" + this.landingCreation + ')';
    }

    public a() {
        this.isCreationNewUser = Boolean.FALSE;
        this.landingType = null;
        this.materialType = null;
        this.landingCreation = null;
    }

    public final UserCreation a() {
        return this.landingCreation;
    }

    public final Integer b() {
        return this.landingType;
    }

    public final Integer c() {
        return this.materialType;
    }

    public final Boolean d() {
        return this.isCreationNewUser;
    }
}
