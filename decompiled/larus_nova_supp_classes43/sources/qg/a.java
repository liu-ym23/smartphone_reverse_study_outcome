package qg;

import com.byted.cast.sink.api.IServerListener;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Lqg/a;", "", "", "clickDebounceDuration", "I", "a", "()I", "serverTimeOffsetDuration", "getServerTimeOffsetDuration", "textPoolSize", "c", "imagePoolSize", "b", "viewPoolSize", "d", "", "enableRefactorText", "Z", "getEnableRefactorText", "()Z", "enableLayoutTwiceOpt", "getEnableLayoutTwiceOpt", "enableLayoutDirtyOpt", "getEnableLayoutDirtyOpt", "enableLayoutParamOpt", "getEnableLayoutParamOpt", "enableStyleMergeOpt", "getEnableStyleMergeOpt", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("click_debounce_duration")
    private final int clickDebounceDuration;

    @SerializedName("enable_layout_dirty_opt")
    private final boolean enableLayoutDirtyOpt;

    @SerializedName("enable_layout_dirty_opt")
    private final boolean enableLayoutParamOpt;

    @SerializedName("enable_layout_twice_opt")
    private final boolean enableLayoutTwiceOpt;

    @SerializedName("enable_refactor_text")
    private final boolean enableRefactorText;

    @SerializedName("enable_layout_dirty_opt")
    private final boolean enableStyleMergeOpt;

    @SerializedName("image_pool_size")
    private final int imagePoolSize;

    @SerializedName("server_time_offset_duration")
    private final int serverTimeOffsetDuration;

    @SerializedName("text_pool_size")
    private final int textPoolSize;

    @SerializedName("view_pool_size")
    private final int viewPoolSize;

    public a() {
        this(0);
    }

    public final int a() {
        return this.clickDebounceDuration;
    }

    public final int b() {
        return this.imagePoolSize;
    }

    public final int c() {
        return this.textPoolSize;
    }

    public final int d() {
        return this.viewPoolSize;
    }

    public a(int r1) {
        this.clickDebounceDuration = IServerListener.WHAT_BYTELINK_SINK_ERROR;
        this.serverTimeOffsetDuration = 5;
        this.textPoolSize = 200;
        this.imagePoolSize = 200;
        this.viewPoolSize = 200;
        this.enableRefactorText = true;
        this.enableLayoutTwiceOpt = true;
        this.enableLayoutDirtyOpt = true;
        this.enableLayoutParamOpt = true;
        this.enableStyleMergeOpt = true;
    }
}
