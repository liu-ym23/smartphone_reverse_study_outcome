package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lw20/nc;", "", "", "maxFileSize", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setMaxFileSize", "(Ljava/lang/Integer;)V", "maxSelectCount", "b", "setMaxSelectCount", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class nc {

    @SerializedName("maxFileSize")
    private Integer maxFileSize;

    @SerializedName("maxSelectCount")
    private Integer maxSelectCount;

    public nc() {
    }

    public final Integer a() {
        return this.maxFileSize;
    }

    public final Integer b() {
        return this.maxSelectCount;
    }
}
