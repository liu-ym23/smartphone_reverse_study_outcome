package nh0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lnh0/d;", "", "", "dressId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "fromUid", "b", "setFromUid", "(Ljava/lang/String;)V", "toUid", "c", "setToUid", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("dress_id")
    private final String dressId;

    @SerializedName("from_uid")
    private String fromUid;

    @SerializedName("to_uid")
    private String toUid;

    public final String a() {
        return this.dressId;
    }

    public final String b() {
        return this.fromUid;
    }

    public final String c() {
        return this.toUid;
    }
}
