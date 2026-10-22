package vs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lvs1/f;", "", "", "lazyTextOpt", "Z", "b", "()Z", "decodeOpt", "a", "setDecodeOpt", "(Z)V", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {
    public static final /* synthetic */ int a = 0;

    @SerializedName("decode_opt")
    private boolean decodeOpt;

    @SerializedName("lazy_text_opt")
    private final boolean lazyTextOpt;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final boolean a() {
        return this.decodeOpt;
    }

    public final boolean b() {
        return this.lazyTextOpt;
    }
}
