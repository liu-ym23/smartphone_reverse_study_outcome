package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/FileSizeConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Z", "baseConfig", "Lcom/ss/android/lark/image/uploader/config/FormatConfig;", "getBaseConfig", "()Lcom/ss/android/lark/image/uploader/config/FormatConfig;", "jpgConfig", "getJpgConfig", "pngConfig", "getPngConfig", "gifConfig", "getGifConfig", "rawConfig", "getRawConfig", "diskFreeSizeLimit", "", "getDiskFreeSizeLimit", "()J", "getConfigByType", "mimeType", "", "Companion", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class c {

    @SerializedName("base_config")
    private final e baseConfig;

    @SerializedName("disk_free_size_limit")
    private final long diskFreeSizeLimit;

    @SerializedName("enable_file_size_check")
    private final boolean enable;

    @SerializedName("gif_config")
    private final e gifConfig;

    @SerializedName("jpg_config")
    private final e jpgConfig;

    @SerializedName("png_config")
    private final e pngConfig;

    @SerializedName("raw_config")
    private final e rawConfig;

    public static final class a {
    }

    static {
    }

    public c() {
        this.enable = true;
        this.baseConfig = new e();
        this.jpgConfig = new e();
        this.pngConfig = new e();
        this.gifConfig = new e();
        this.rawConfig = new e();
        this.diskFreeSizeLimit = 52428800;
    }

    public final long b() {
        return this.diskFreeSizeLimit;
    }

    public final boolean c() {
        return this.enable;
    }

    public final e a(String r2) {
        if (r2 != null) goto L4;
    L71:
        e r3 = this.baseConfig;
    L72:
        if (r3 == null) goto L74;
        return r3;
    L74:
        return new e();
    L4:
        switch(r2.hashCode()) {
            case -1967456358: goto L68;
            case -1875291391: goto L65;
            case -1594371159: goto L62;
            case -1594353930: goto L59;
            case -1594353878: goto L56;
            case -1522638489: goto L53;
            case -1522633342: goto L50;
            case -1522631746: goto L47;
            case -1487394660: goto L43;
            case -1423313290: goto L40;
            case -985161510: goto L37;
            case -879267568: goto L33;
            case -879264467: goto L29;
            case -879258763: goto L25;
            case -435903240: goto L22;
            case -332763809: goto L19;
            case 1378106698: goto L16;
            case 2099152104: goto L13;
            case 2111234748: goto L10;
            case 2111234817: goto L7;
            default: goto L71;
        };
    L7:
        if (r2.equals("image/x-canon-crw") == false) goto L71;
    L70:
        r3 = this.rawConfig;
        goto L72
    L10:
        if (r2.equals("image/x-canon-cr2") == true) goto L70;
    L13:
        if (r2.equals("image/x-nikon-nef") == true) goto L70;
    L16:
        if (r2.equals("image/x-olympus-orf") == true) goto L70;
    L19:
        if (r2.equals("image/x-pentax-pef") == true) goto L70;
    L22:
        if (r2.equals("image/x-minolta-mrw") == true) goto L70;
    L25:
        if (r2.equals("image/png") == false) goto L71;
        r3 = this.pngConfig;
        goto L72
    L29:
        if (r2.equals("image/jpg") == false) goto L71;
        r3 = this.jpgConfig;
        goto L72
    L33:
        if (r2.equals("image/gif") == false) goto L71;
        r3 = this.gifConfig;
        goto L72
    L37:
        if (r2.equals("image/x-panasonic-raw") == true) goto L70;
    L40:
        if (r2.equals("image/x-adobe-dng") == true) goto L70;
    L43:
        if (r2.equals("image/jpeg") == false) goto L71;
        r3 = this.jpgConfig;
        goto L72
    L47:
        if (r2.equals("image/x-kodak-kdc") == true) goto L70;
    L50:
        if (r2.equals("image/x-kodak-k25") == true) goto L70;
    L53:
        if (r2.equals("image/x-kodak-dcr") == true) goto L70;
    L56:
        if (r2.equals("image/x-sony-srf") == true) goto L70;
    L59:
        if (r2.equals("image/x-sony-sr2") == true) goto L70;
    L62:
        if (r2.equals("image/x-sony-arw") == true) goto L70;
    L65:
        if (r2.equals("image/x-fuji-raf") == true) goto L70;
    L68:
        if (r2.equals("image/x-sigma-x3f") == true) goto L70;
        goto L70
    }
}
