package op1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lop1/d;", "", "", "timeStart", "F", "b", "()F", "setTimeStart", "(F)V", "", "lrc", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("text")
    private String lrc;

    @SerializedName("timeId")
    private float timeStart;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return this.lrc;
    }

    public final float b() {
        return this.timeStart;
    }

    public d(float r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.timeStart = r2;
        this.lrc = r3;
    }
}
