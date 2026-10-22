package tf0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Ltf0/f;", "", "", "itemId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "", "itemType", "I", "b", "()I", "setItemType", "(I)V", "timestamp", "c", "setTimestamp", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f {

    @SerializedName("item_id")
    private String itemId;

    @SerializedName("item_type")
    private int itemType;

    @SerializedName("timestamp")
    private String timestamp;

    public final String toString() {
        return "DynamicLoadDuration(itemId=" + this.itemId + ", itemType=" + this.itemType + ", groups=" + this.timestamp + ')';
    }

    public f() {
        this.itemId = null;
        this.itemType = 0;
        this.timestamp = null;
    }

    public final String a() {
        return this.itemId;
    }

    public final int b() {
        return this.itemType;
    }

    public final String c() {
        return this.timestamp;
    }
}
