package l90;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Ll90/a;", "", "Ll90/c;", "stickerConfig", "Ll90/c;", "getStickerConfig", "()Ll90/c;", "setStickerConfig", "(Ll90/c;)V", "Ll90/b;", "performanceConfig", "Ll90/b;", "a", "()Ll90/b;", "setPerformanceConfig", "(Ll90/b;)V", "<init>", "()V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("performanceConfig")
    private b performanceConfig;

    @SerializedName("stickerConfig")
    private c stickerConfig;

    public a() {
        this.stickerConfig = new c();
        this.performanceConfig = new b();
    }

    public final b a() {
        return this.performanceConfig;
    }
}
