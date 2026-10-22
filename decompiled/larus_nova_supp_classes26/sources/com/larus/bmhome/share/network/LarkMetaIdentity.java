package com.larus.bmhome.share.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\rHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/share/network/LarkMetaIdentity;", "", "larkMetaId", "", "larkMetaToken", "larkMetaObjectType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLarkMetaId", "()Ljava/lang/String;", "getLarkMetaToken", "getLarkMetaObjectType", "objectTypeOrNull", "", "()Ljava/lang/Integer;", "isValid", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkMetaIdentity {

    @SerializedName("lark_meta_id")
    private final String larkMetaId;

    @SerializedName("lark_meta_object_type")
    private final String larkMetaObjectType;

    @SerializedName("lark_meta_token")
    private final String larkMetaToken;

    public LarkMetaIdentity() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LarkMetaIdentity copy$default(LarkMetaIdentity r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.larkMetaId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.larkMetaToken;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.larkMetaObjectType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.larkMetaId;
    }

    public final String component2() {
        return this.larkMetaToken;
    }

    public final String component3() {
        return this.larkMetaObjectType;
    }

    public final LarkMetaIdentity copy(String r2, String r3, String r4) {
        return new LarkMetaIdentity(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkMetaIdentity) == true) goto L8;
        return false;
    L8:
        LarkMetaIdentity r6 = (LarkMetaIdentity) r5;
        if (Intrinsics.areEqual(this.larkMetaId, r6.larkMetaId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.larkMetaToken, r6.larkMetaToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.larkMetaObjectType, r6.larkMetaObjectType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.larkMetaId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.larkMetaToken;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.larkMetaObjectType;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkMetaIdentity(larkMetaId=" + this.larkMetaId + ", larkMetaToken=" + this.larkMetaToken + ", larkMetaObjectType=" + this.larkMetaObjectType + ')';
    }

    public final boolean isValid() {
        String r0 = this.larkMetaToken;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L16;
        Integer r2 = objectTypeOrNull();
        if (r2 == null) goto L13;
        int r3 = r2.intValue();
    L14:
        if (r3 <= 0) goto L16;
        return true;
    L13:
        r3 = 0;
    L16:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final Integer objectTypeOrNull() {
        String r0 = this.larkMetaObjectType;
        if (r0 == null) goto L7;
        String r1 = StringsKt.trim(r0).toString();
        if (r1 == null) goto L7;
        return StringsKt.toIntOrNull(r1);
    L7:
        return null;
    }

    public final String getLarkMetaId() {
        return this.larkMetaId;
    }

    public final String getLarkMetaObjectType() {
        return this.larkMetaObjectType;
    }

    public final String getLarkMetaToken() {
        return this.larkMetaToken;
    }

    public LarkMetaIdentity(String r1, String r2, String r3) {
        this.larkMetaId = r1;
        this.larkMetaToken = r2;
        this.larkMetaObjectType = r3;
    }

    public /* synthetic */ LarkMetaIdentity(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
