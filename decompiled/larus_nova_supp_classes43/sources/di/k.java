package di;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Ldi/k;", "", "", "ttnetVersion", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTtnetVersion", "(Ljava/lang/String;)V", "", "netThreadPriority", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setNetThreadPriority", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("net_thread_priority")
    private Integer netThreadPriority;

    @SerializedName("ttnet_version")
    private String ttnetVersion;

    public k() {
    }

    public final Integer a() {
        return this.netThreadPriority;
    }

    public final String b() {
        return this.ttnetVersion;
    }
}
