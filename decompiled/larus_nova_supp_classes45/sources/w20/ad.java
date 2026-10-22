package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lw20/ad;", "", "", "resourcePath", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setResourcePath", "(Ljava/lang/String;)V", "", "enableAudio", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setEnableAudio", "(Ljava/lang/Boolean;)V", "enableVibrate", "d", "setEnableVibrate", "displayImmediately", "b", "setDisplayImmediately", "aboveLynxView", "a", "setAboveLynxView", "Lcom/google/gson/JsonObject;", "trackExtra", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", "setTrackExtra", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ad {

    @SerializedName("aboveLynxView")
    private Boolean aboveLynxView;

    @SerializedName("displayImmediately")
    private Boolean displayImmediately;

    @SerializedName("enableAudio")
    private Boolean enableAudio;

    @SerializedName("enableVibrate")
    private Boolean enableVibrate;

    @SerializedName("resourcePath")
    private String resourcePath;

    @SerializedName("trackExtra")
    private JsonObject trackExtra;

    public ad() {
    }

    public final Boolean a() {
        return this.aboveLynxView;
    }

    public final Boolean b() {
        return this.displayImmediately;
    }

    public final Boolean c() {
        return this.enableAudio;
    }

    public final Boolean d() {
        return this.enableVibrate;
    }

    public final String e() {
        return this.resourcePath;
    }

    public final JsonObject f() {
        return this.trackExtra;
    }
}
