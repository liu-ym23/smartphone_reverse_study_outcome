package pn0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lpn0/a;", "", "", "uiLayout", "I", "d", "()I", "seiVersion", "getSeiVersion", "orientation", "c", "", "devicePlatform", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "fileName", "b", "<init>", "()V", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("device_platform")
    private final String devicePlatform;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("orientation")
    private final int orientation;

    @SerializedName("sei_version")
    private final int seiVersion;

    @SerializedName("ui_layout")
    private final int uiLayout;

    public final String toString() {
        return "LinkWindowLayoutConfigParams{uiLayout=" + this.uiLayout + ", seiVersion=" + this.seiVersion + ", orientation=" + this.orientation + ", fileName=" + this.fileName + "}";
    }

    public a() {
        this.devicePlatform = "";
        this.fileName = "";
    }

    public final String a() {
        return this.devicePlatform;
    }

    public final String b() {
        return this.fileName;
    }

    public final int c() {
        return this.orientation;
    }

    public final int d() {
        return this.uiLayout;
    }
}
