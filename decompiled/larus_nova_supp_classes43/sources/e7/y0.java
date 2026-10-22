package e7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Le7/y0;", "", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "customIcon", "a", "setCustomIcon", "icon", "getIcon", "setIcon", "", com.bytedance.android.ec.core.event.a.KEY_DURATION, "Ljava/lang/Integer;", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("customIcon")
    private String customIcon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_DURATION)
    private Integer duration;

    @SerializedName("icon")
    private String icon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MSG)
    private String message;

    public y0() {
    }

    public final String a() {
        return this.customIcon;
    }

    public final String b() {
        return this.message;
    }
}
