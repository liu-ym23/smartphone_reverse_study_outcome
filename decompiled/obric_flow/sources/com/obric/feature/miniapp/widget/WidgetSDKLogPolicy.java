package com.obric.feature.miniapp.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/feature/miniapp/widget/WidgetSDKLogPolicy;", "", "", "applicationInfoFlags", "priority", "", "tag", "", "shouldLog", "(IILjava/lang/String;)Z", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetSDKLogPolicy {
    public static final WidgetSDKLogPolicy INSTANCE = null;

    static {
        INSTANCE = new WidgetSDKLogPolicy();
    }

    public WidgetSDKLogPolicy() {
    }

    public final boolean shouldLog(int r5, int r10, String r11) {
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        if (r10 >= 6) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r11, "LynxAppletModelClass") == true) goto L12;
        return true;
    L12:
        return false;
    }
}
