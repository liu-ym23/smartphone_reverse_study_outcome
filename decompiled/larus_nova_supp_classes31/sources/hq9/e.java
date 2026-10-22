package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/AigcMetadataCheckConfig;", "", "enable", "", "defaultSampleRate", "", "sceneSampleRates", "", "", "ignoreFileTypes", "", "<init>", "(ZFLjava/util/Map;Ljava/util/List;)V", "getEnable", "()Z", "getDefaultSampleRate", "()F", "getSceneSampleRates", "()Ljava/util/Map;", "getIgnoreFileTypes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class e {

    @SerializedName("default_sample_rate")
    private final float defaultSampleRate;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("ignore_file_types")
    private final List<String> ignoreFileTypes;

    @SerializedName("scene_sample_rates")
    private final Map<String, Float> sceneSampleRates;

    public e() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Float.compare(this.defaultSampleRate, r6.defaultSampleRate) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sceneSampleRates, r6.sceneSampleRates) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ignoreFileTypes, r6.ignoreFileTypes) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + Float.floatToIntBits(this.defaultSampleRate)) * 31;
        Map<String, Float> r2 = this.sceneSampleRates;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        List<String> r6 = this.ignoreFileTypes;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AigcMetadataCheckConfig(enable=" + this.enable + ", defaultSampleRate=" + this.defaultSampleRate + ", sceneSampleRates=" + this.sceneSampleRates + ", ignoreFileTypes=" + this.ignoreFileTypes + ')';
    }

    public final float a() {
        return this.defaultSampleRate;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.ignoreFileTypes;
    }

    public final Map<String, Float> d() {
        return this.sceneSampleRates;
    }

    public e(Object r5) {
        Map<String, Float> r6 = MapsKt.mapOf(new Pair[]{TuplesKt.to("creation_gallery_long_press_share", Float.valueOf(0.1f)), TuplesKt.to("creation_gallery_download", Float.valueOf(0.1f)), TuplesKt.to("creation_gallery_share_save", Float.valueOf(0.1f)), TuplesKt.to("creation_share_save", Float.valueOf(0.1f)), TuplesKt.to("chat_thumbnail_download", Float.valueOf(0.1f)), TuplesKt.to("photoshop_page_download", Float.valueOf(0.1f)), TuplesKt.to("photoshop_page_image_long_press", Float.valueOf(0.1f)), TuplesKt.to("chat_long_press_download", Float.valueOf(0.1f)), TuplesKt.to("chat_long_press_share_save", Float.valueOf(0.1f)), TuplesKt.to("profile_creation_share_save", Float.valueOf(0.1f)), TuplesKt.to("profile_long_click_creation_share", Float.valueOf(0.1f)), TuplesKt.to("profile_creation_long_click_share", Float.valueOf(0.1f)), TuplesKt.to("profile_creation_thumbnail_download", Float.valueOf(0.1f)), TuplesKt.to("profile_private_canvas_download", Float.valueOf(0.1f)), TuplesKt.to("profile_private_share_save", Float.valueOf(0.1f)), TuplesKt.to("chat_music_video_download", Float.valueOf(0.1f)), TuplesKt.to("chat_music_share_video", Float.valueOf(0.1f)), TuplesKt.to("music_share_save_video", Float.valueOf(0.1f)), TuplesKt.to("music_canvas_video_download", Float.valueOf(0.1f)), TuplesKt.to("music_thumbnail_image_download", Float.valueOf(0.1f))});
        this.enable = false;
        this.defaultSampleRate = 0.1f;
        this.sceneSampleRates = r6;
        this.ignoreFileTypes = null;
    }
}
