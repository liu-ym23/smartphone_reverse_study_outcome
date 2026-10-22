package nh0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lnh0/q;", "Ltf0/d;", "", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "description", "getDescription", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q extends tf0.d {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("description")
    private final String description;

    @Override // tf0.d
    public final String toString() {
        return super.toString() + ", backgroundColor = " + this.backgroundColor + ", description = " + this.description;
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
        if ((!Intrinsics.areEqual(q.class, r5.getClass())) == true) goto L21;
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r6.description) == false) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    }
}
