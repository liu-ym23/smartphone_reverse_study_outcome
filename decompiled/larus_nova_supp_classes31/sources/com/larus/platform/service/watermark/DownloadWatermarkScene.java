package com.larus.platform.service.watermark;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/service/watermark/DownloadWatermarkScene;", "", "scene", "", "subScene", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getScene", "()Ljava/lang/String;", "getSubScene", "CI_GEN_IMAGE_DOWNLOAD", "CI_GEN_IMAGE_SHARE", "CI_GEN_VIDEO_DOWNLOAD", "CI_GEN_VIDEO_SHARE", "MESSAGE_LONG_IMAGE", "MESSAGE_EXPORT_FILE", "MESSAGE_EXPORT_CODE", "USER_SHARE_IMAGE", "NESTED_FILE_DOWNLOAD", "IM_GALLERY_IMAGE_DOWNLOAD", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DownloadWatermarkScene extends Enum<DownloadWatermarkScene> {
    public static final DownloadWatermarkScene CI_GEN_IMAGE_DOWNLOAD = null;
    public static final DownloadWatermarkScene CI_GEN_IMAGE_SHARE = null;
    public static final DownloadWatermarkScene CI_GEN_VIDEO_DOWNLOAD = null;
    public static final DownloadWatermarkScene CI_GEN_VIDEO_SHARE = null;
    public static final DownloadWatermarkScene IM_GALLERY_IMAGE_DOWNLOAD = null;
    public static final DownloadWatermarkScene MESSAGE_EXPORT_CODE = null;
    public static final DownloadWatermarkScene MESSAGE_EXPORT_FILE = null;
    public static final DownloadWatermarkScene MESSAGE_LONG_IMAGE = null;
    public static final DownloadWatermarkScene NESTED_FILE_DOWNLOAD = null;
    public static final DownloadWatermarkScene USER_SHARE_IMAGE = null;
    public static final /* synthetic */ DownloadWatermarkScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;
    private final String subScene;

    public static EnumEntries<DownloadWatermarkScene> getEntries() {
        return b;
    }

    static {
        DownloadWatermarkScene r0 = new DownloadWatermarkScene("CI_GEN_IMAGE_DOWNLOAD", 0, "Creation", "ci_image_download");
        CI_GEN_IMAGE_DOWNLOAD = r0;
        DownloadWatermarkScene r1 = new DownloadWatermarkScene("CI_GEN_IMAGE_SHARE", 1, "Creation", "ci_image_share");
        CI_GEN_IMAGE_SHARE = r1;
        DownloadWatermarkScene r2 = new DownloadWatermarkScene("CI_GEN_VIDEO_DOWNLOAD", 2, "Creation", "ci_video_download");
        CI_GEN_VIDEO_DOWNLOAD = r2;
        DownloadWatermarkScene r5 = new DownloadWatermarkScene("CI_GEN_VIDEO_SHARE", 3, "Creation", "ci_video_share");
        CI_GEN_VIDEO_SHARE = r5;
        DownloadWatermarkScene r4 = new DownloadWatermarkScene("MESSAGE_LONG_IMAGE", 4, "IMShare", "long_image_export");
        MESSAGE_LONG_IMAGE = r4;
        DownloadWatermarkScene r7 = new DownloadWatermarkScene("MESSAGE_EXPORT_FILE", 5, "IMShare", "file_export_h5");
        MESSAGE_EXPORT_FILE = r7;
        DownloadWatermarkScene r9 = new DownloadWatermarkScene("MESSAGE_EXPORT_CODE", 6, "Coding", "code_to_trae");
        MESSAGE_EXPORT_CODE = r9;
        DownloadWatermarkScene r13 = new DownloadWatermarkScene("USER_SHARE_IMAGE", 7, "Share", "user_share_image");
        USER_SHARE_IMAGE = r13;
        DownloadWatermarkScene r11 = new DownloadWatermarkScene("NESTED_FILE_DOWNLOAD", 8, "IMShare", "nested_file_download");
        NESTED_FILE_DOWNLOAD = r11;
        DownloadWatermarkScene r14 = new DownloadWatermarkScene("IM_GALLERY_IMAGE_DOWNLOAD", 9, "IMShare", "im_gallery_image_download");
        IM_GALLERY_IMAGE_DOWNLOAD = r14;
        DownloadWatermarkScene[] r10 = {r0, r1, r2, r5, r4, r7, r9, r13, r11, r14};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static DownloadWatermarkScene[] values() {
        return (DownloadWatermarkScene[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSubScene() {
        return this.subScene;
    }

    public static DownloadWatermarkScene valueOf(String r1) {
        return (DownloadWatermarkScene) r27.a.a(DownloadWatermarkScene.class, r1);
    }

    public DownloadWatermarkScene(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.scene = r3;
        this.subScene = r4;
    }
}
