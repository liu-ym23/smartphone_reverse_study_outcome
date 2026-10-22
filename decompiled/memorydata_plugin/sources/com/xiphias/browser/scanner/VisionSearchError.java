package com.xiphias.browser.scanner;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/xiphias/browser/scanner/VisionSearchError;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIGURATION_ERROR", "SESSION_EXPIRED", "IMAGE_DECODE_FAILED", "UNSUPPORTED_IMAGE", "IMAGE_TOO_LARGE", "NETWORK_ERROR", "HTTP_ERROR", "SERVER_ERROR", "HTML_EMPTY", "WEBVIEW_RENDER_ERROR", "BRIDGE_ARGUMENT_ERROR", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum VisionSearchError extends Enum<VisionSearchError> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ VisionSearchError[] $VALUES = null;
    public static final VisionSearchError BRIDGE_ARGUMENT_ERROR = null;
    public static final VisionSearchError CONFIGURATION_ERROR = null;
    public static final VisionSearchError HTML_EMPTY = null;
    public static final VisionSearchError HTTP_ERROR = null;
    public static final VisionSearchError IMAGE_DECODE_FAILED = null;
    public static final VisionSearchError IMAGE_TOO_LARGE = null;
    public static final VisionSearchError NETWORK_ERROR = null;
    public static final VisionSearchError SERVER_ERROR = null;
    public static final VisionSearchError SESSION_EXPIRED = null;
    public static final VisionSearchError UNSUPPORTED_IMAGE = null;
    public static final VisionSearchError WEBVIEW_RENDER_ERROR = null;

    private static final /* synthetic */ VisionSearchError[] $values() {
        return new VisionSearchError[]{CONFIGURATION_ERROR, SESSION_EXPIRED, IMAGE_DECODE_FAILED, UNSUPPORTED_IMAGE, IMAGE_TOO_LARGE, NETWORK_ERROR, HTTP_ERROR, SERVER_ERROR, HTML_EMPTY, WEBVIEW_RENDER_ERROR, BRIDGE_ARGUMENT_ERROR};
    }

    static {
        CONFIGURATION_ERROR = new VisionSearchError("CONFIGURATION_ERROR", 0);
        SESSION_EXPIRED = new VisionSearchError("SESSION_EXPIRED", 1);
        IMAGE_DECODE_FAILED = new VisionSearchError("IMAGE_DECODE_FAILED", 2);
        UNSUPPORTED_IMAGE = new VisionSearchError("UNSUPPORTED_IMAGE", 3);
        IMAGE_TOO_LARGE = new VisionSearchError("IMAGE_TOO_LARGE", 4);
        NETWORK_ERROR = new VisionSearchError("NETWORK_ERROR", 5);
        HTTP_ERROR = new VisionSearchError("HTTP_ERROR", 6);
        SERVER_ERROR = new VisionSearchError("SERVER_ERROR", 7);
        HTML_EMPTY = new VisionSearchError("HTML_EMPTY", 8);
        WEBVIEW_RENDER_ERROR = new VisionSearchError("WEBVIEW_RENDER_ERROR", 9);
        BRIDGE_ARGUMENT_ERROR = new VisionSearchError("BRIDGE_ARGUMENT_ERROR", 10);
        VisionSearchError[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private VisionSearchError(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<VisionSearchError> getEntries() {
        return $ENTRIES;
    }

    public static VisionSearchError valueOf(String r2) {
        return (VisionSearchError) ZeusTransformUtils.preCheckCast(Enum.valueOf(VisionSearchError.class, r2), VisionSearchError.class, "com.obric.memorydata.plugin");
    }

    public static VisionSearchError[] values() {
        return (VisionSearchError[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VisionSearchError[].class, "com.obric.memorydata.plugin");
    }
}
