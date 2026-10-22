package a10;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"La10/c;", "La10/a;", "", "isOpen", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setOpen", "(Ljava/lang/String;)V", "scheme", "a", "setScheme", "isDone", "c", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c extends a {

    @SerializedName("is_done")
    private String isDone;

    @SerializedName("is_open")
    private String isOpen;

    @SerializedName("schema")
    private String scheme;

    public c() {
        this.isOpen = "false";
        this.scheme = "";
        this.isDone = "false";
    }

    public final String a() {
        return this.scheme;
    }

    public final String b() {
        return this.isOpen;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isDone = r2;
    }
}
