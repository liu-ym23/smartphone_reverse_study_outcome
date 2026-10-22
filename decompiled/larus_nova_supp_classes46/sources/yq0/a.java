package yq0;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lyq0/a;", "", "", "canUploadCode", "I", "a", "()I", "setCanUploadCode", "(I)V", "", MultiLinkOpenSource.MESSAGE, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "", "protocolList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setProtocolList", "(Ljava/util/List;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("can_upload_code")
    private int canUploadCode;

    @SerializedName(MultiLinkOpenSource.MESSAGE)
    private String message;

    @SerializedName("protocol_id_list")
    private List<Integer> protocolList;

    public a() {
        this.canUploadCode = -1;
        this.message = "";
    }

    public final int a() {
        return this.canUploadCode;
    }

    public final String b() {
        return this.message;
    }

    public final List<Integer> c() {
        return this.protocolList;
    }
}
