package ws1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lws1/a;", "", "", "tabListSize", "I", "c", "()I", "normalPageStickerListSize", "a", "offscreenPageLimit", "b", "searchPageStickerListSize", "getSearchPageStickerListSize", "<init>", "()V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("normal_page_sticker_list_size")
    private final int normalPageStickerListSize;

    @SerializedName("offscreen_page_limit")
    private final int offscreenPageLimit;

    @SerializedName("search_page_sticker_list_size")
    private final int searchPageStickerListSize;

    @SerializedName("tab_list_size")
    private final int tabListSize;

    public a() {
        this.offscreenPageLimit = 2;
        this.searchPageStickerListSize = 60;
    }

    public final int a() {
        return this.normalPageStickerListSize;
    }

    public final int b() {
        return this.offscreenPageLimit;
    }

    public final int c() {
        return this.tabListSize;
    }
}
