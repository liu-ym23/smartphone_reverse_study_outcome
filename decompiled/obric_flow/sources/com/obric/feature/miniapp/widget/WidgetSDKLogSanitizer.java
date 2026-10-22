package com.obric.feature.miniapp.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001J#\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/feature/miniapp/widget/WidgetSDKLogSanitizer;", "", "", "tag", "msg", "sanitizeMessage", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "throwable", "sanitizeThrowable", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "LYNX_APPLET_MODEL_CLASS_TAG", "Ljava/lang/String;", "REDACTED_LYNX_APPLET_LOG_MESSAGE", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetSDKLogSanitizer {
    public static final WidgetSDKLogSanitizer INSTANCE = null;
    public static final String LYNX_APPLET_MODEL_CLASS_TAG = "LynxAppletModelClass";
    public static final String REDACTED_LYNX_APPLET_LOG_MESSAGE = "LynxAppletModelClass log redacted";

    static {
        INSTANCE = new WidgetSDKLogSanitizer();
    }

    public WidgetSDKLogSanitizer() {
    }

    public final String sanitizeMessage(String r5, String r10) {
        if (Intrinsics.areEqual(r5, "LynxAppletModelClass") == false) goto L6;
        return REDACTED_LYNX_APPLET_LOG_MESSAGE;
    L6:
        return r10;
    }

    public final Throwable sanitizeThrowable(String r5, Throwable r10) {
        if (Intrinsics.areEqual(r5, "LynxAppletModelClass") == false) goto L6;
        return null;
    L6:
        return r10;
    }
}
