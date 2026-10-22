package ym0;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lym0/b;", "", "", "Lym0/a;", "camerasInfo", "Ljava/util/List;", "b", "()Ljava/util/List;", "setCamerasInfo", "(Ljava/util/List;)V", "", "bizType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("biz_type")
    private Integer bizType;

    @SerializedName("multi_stream_cameras")
    private List<a> camerasInfo;

    public b() {
        this.bizType = 0;
    }

    public final Integer a() {
        return this.bizType;
    }

    public final List<a> b() {
        return this.camerasInfo;
    }
}
