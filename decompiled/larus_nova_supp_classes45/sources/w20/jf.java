package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lw20/jf;", "", "", "sceneName", "Ljava/lang/String;", "getSceneName", "()Ljava/lang/String;", "setSceneName", "(Ljava/lang/String;)V", "enterFrom", "getEnterFrom", "setEnterFrom", "passControlLevel", "getPassControlLevel", "setPassControlLevel", "guideStyleType", "getGuideStyleType", "setGuideStyleType", "", "needLoading", "Ljava/lang/Integer;", "getNeedLoading", "()Ljava/lang/Integer;", "setNeedLoading", "(Ljava/lang/Integer;)V", "Lcom/google/gson/JsonObject;", "extraParams", "Lcom/google/gson/JsonObject;", "getExtraParams", "()Lcom/google/gson/JsonObject;", "setExtraParams", "(Lcom/google/gson/JsonObject;)V", "", "needFrequency", "Ljava/lang/Boolean;", "getNeedFrequency", "()Ljava/lang/Boolean;", "setNeedFrequency", "(Ljava/lang/Boolean;)V", "<init>", "()V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jf {

    @SerializedName("enterFrom")
    private String enterFrom;

    @SerializedName("extraParams")
    private JsonObject extraParams;

    @SerializedName("guideStyleType")
    private String guideStyleType;

    @SerializedName("needFrequency")
    private Boolean needFrequency;

    @SerializedName("needLoading")
    private Integer needLoading;

    @SerializedName("passControlLevel")
    private String passControlLevel;

    @SerializedName("sceneName")
    private String sceneName;

    public jf() {
    }
}
