package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lw20/df;", "", "", "appKey", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setAppKey", "(Ljava/lang/String;)V", "", "sosSilenceTimeout", "Ljava/lang/Integer;", "k", "()Ljava/lang/Integer;", "setSosSilenceTimeout", "(Ljava/lang/Integer;)V", "eosSilenceTimeout", "e", "setEosSilenceTimeout", "sentenceMaxSeconds", "j", "setSentenceMaxSeconds", "", "useLLM", "Ljava/lang/Boolean;", "l", "()Ljava/lang/Boolean;", "setUseLLM", "(Ljava/lang/Boolean;)V", "domain", "d", "setDomain", "path", "f", "setPath", "appId", "a", "setAppId", "appToken", "c", "setAppToken", "resourceId", "h", "setResourceId", "saveAudioToFile", "i", "setSaveAudioToFile", "Lcom/google/gson/JsonObject;", "requestParam", "Lcom/google/gson/JsonObject;", "g", "()Lcom/google/gson/JsonObject;", "setRequestParam", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class df {

    @SerializedName("appId")
    private String appId;

    @SerializedName("appKey")
    private String appKey;

    @SerializedName("appToken")
    private String appToken;

    @SerializedName("domain")
    private String domain;

    @SerializedName("eosSilenceTimeout")
    private Integer eosSilenceTimeout;

    @SerializedName("path")
    private String path;

    @SerializedName("requestParam")
    private JsonObject requestParam;

    @SerializedName("resourceId")
    private String resourceId;

    @SerializedName("saveAudioToFile")
    private Boolean saveAudioToFile;

    @SerializedName("sentenceMaxSeconds")
    private Integer sentenceMaxSeconds;

    @SerializedName("sosSilenceTimeout")
    private Integer sosSilenceTimeout;

    @SerializedName("useLLM")
    private Boolean useLLM;

    public df() {
    }

    public final String a() {
        return this.appId;
    }

    public final String b() {
        return this.appKey;
    }

    public final String c() {
        return this.appToken;
    }

    public final String d() {
        return this.domain;
    }

    public final Integer e() {
        return this.eosSilenceTimeout;
    }

    public final String f() {
        return this.path;
    }

    public final JsonObject g() {
        return this.requestParam;
    }

    public final String h() {
        return this.resourceId;
    }

    public final Boolean i() {
        return this.saveAudioToFile;
    }

    public final Integer j() {
        return this.sentenceMaxSeconds;
    }

    public final Integer k() {
        return this.sosSilenceTimeout;
    }

    public final Boolean l() {
        return this.useLLM;
    }
}
