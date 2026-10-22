package du9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/larus/settings/provider/chat/GenImgCardStyleConfig;", "", "<init>", "()V", "adaptiveImage4Box", "", "getAdaptiveImage4Box", "()Z", "isHorizontalScroll", "horizontalScrollShowShare", "getHorizontalScrollShowShare", "horizontalScrollShowDownload", "getHorizontalScrollShowDownload", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class t0 {

    @SerializedName("adaptive_image_4_box")
    private final boolean adaptiveImage4Box;

    @SerializedName("horizontal_scroll_show_download")
    private final boolean horizontalScrollShowDownload;

    @SerializedName("horizontal_scroll_show_share")
    private final boolean horizontalScrollShowShare;

    @SerializedName("gen_img_horizontal_scroll")
    private final boolean isHorizontalScroll;

    public t0() {
        this.isHorizontalScroll = true;
        this.horizontalScrollShowDownload = true;
    }

    public final boolean a() {
        return this.adaptiveImage4Box;
    }

    public final boolean b() {
        return this.horizontalScrollShowDownload;
    }

    public final boolean c() {
        return this.horizontalScrollShowShare;
    }

    public final boolean d() {
        return this.isHorizontalScroll;
    }
}
