package xs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lxs1/a;", "", "", "enableLazyLoad", "Z", "b", "()Z", "setEnableLazyLoad", "(Z)V", "", "lazyTime", "I", "d", "()I", "setLazyTime", "(I)V", "enableAnimAndGest", "a", "setEnableAnimAndGest", "enablePopUp", "c", "setEnablePopUp", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("enable_anim_and_gest")
    private boolean enableAnimAndGest;

    @SerializedName("enable_lazy_load")
    private boolean enableLazyLoad;

    @SerializedName("enable_pop_up")
    private boolean enablePopUp;

    @SerializedName("lazy_time")
    private int lazyTime;

    public a() {
        this.lazyTime = 8000;
        this.enableAnimAndGest = true;
        this.enablePopUp = true;
    }

    public final boolean a() {
        return this.enableAnimAndGest;
    }

    public final boolean b() {
        return this.enableLazyLoad;
    }

    public final boolean c() {
        return this.enablePopUp;
    }

    public final int d() {
        return this.lazyTime;
    }
}
