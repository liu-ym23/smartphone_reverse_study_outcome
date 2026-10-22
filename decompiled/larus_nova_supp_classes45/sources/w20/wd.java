package w20;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001f¨\u0006/"}, d2 = {"Lw20/wd;", "", "", "mode", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "", "imageCountLimit", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setImageCountLimit", "(Ljava/lang/Integer;)V", "videoCountLimit", "g", "setVideoCountLimit", "maxImageFileSize", "d", "setMaxImageFileSize", "durationLimit", "a", "setDurationLimit", "", "videoNeedCoverData", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "setVideoNeedCoverData", "(Ljava/lang/Boolean;)V", "hintText", "b", "setHintText", "", "preSelectedPaths", "Ljava/util/List;", "f", "()Ljava/util/List;", "setPreSelectedPaths", "(Ljava/util/List;)V", "isPreSelectReally", "i", "setPreSelectReally", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wd {

    @SerializedName("durationLimit")
    private Integer durationLimit;

    @SerializedName("hintText")
    private String hintText;

    @SerializedName("imageCountLimit")
    private Integer imageCountLimit;

    @SerializedName("isPreSelectReally")
    private Boolean isPreSelectReally;

    @SerializedName("maxImageFileSize")
    private Integer maxImageFileSize;

    @SerializedName("mode")
    private String mode;

    @SerializedName("preSelectedPaths")
    private List<String> preSelectedPaths;

    @SerializedName("videoCountLimit")
    private Integer videoCountLimit;

    @SerializedName("videoNeedCoverData")
    private Boolean videoNeedCoverData;

    public wd() {
    }

    public final Integer a() {
        return this.durationLimit;
    }

    public final String b() {
        return this.hintText;
    }

    public final Integer c() {
        return this.imageCountLimit;
    }

    public final Integer d() {
        return this.maxImageFileSize;
    }

    public final String e() {
        return this.mode;
    }

    public final List<String> f() {
        return this.preSelectedPaths;
    }

    public final Integer g() {
        return this.videoCountLimit;
    }

    public final Boolean h() {
        return this.videoNeedCoverData;
    }

    public final Boolean i() {
        return this.isPreSelectReally;
    }
}
