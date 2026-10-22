package e7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Le7/d0;", "", "", "socketTaskID", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setSocketTaskID", "(Ljava/lang/String;)V", "containerID", "getContainerID", "setContainerID", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("containerID")
    private String containerID;

    @SerializedName("socketTaskID")
    private String socketTaskID;

    public d0() {
    }

    public final String a() {
        return this.socketTaskID;
    }
}
