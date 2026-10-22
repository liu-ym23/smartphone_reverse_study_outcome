package e7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Le7/w0;", "", "", "key", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "data", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "biz", "a", "setBiz", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("biz")
    private String biz;

    @SerializedName("data")
    private Object data;

    @SerializedName("key")
    private String key;

    public w0() {
    }

    public final String a() {
        return this.biz;
    }

    public final Object b() {
        return this.data;
    }

    public final String c() {
        return this.key;
    }
}
