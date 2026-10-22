package nh0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnh0/t;", "Ltf0/d;", "", "userNickName", "Ljava/lang/String;", "getUserNickName", "()Ljava/lang/String;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t extends tf0.d {

    @SerializedName("user_nick_name")
    private final String userNickName;

    @Override // tf0.d
    public final String toString() {
        return super.toString() + ", userNickName = " + this.userNickName;
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
    L14:
        return false;
    L10:
        if ((true ^ Intrinsics.areEqual(t.class, r5.getClass())) == true) goto L14;
        return Intrinsics.areEqual(this.userNickName, ((t) r5).userNickName);
    }
}
