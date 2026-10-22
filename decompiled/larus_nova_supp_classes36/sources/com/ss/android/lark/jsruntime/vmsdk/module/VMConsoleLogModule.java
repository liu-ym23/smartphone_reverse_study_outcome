package com.ss.android.lark.jsruntime.vmsdk.module;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\u0007H\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VMConsoleLogModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "log", "", INotificationHitPoint.NoticeType.MESSAGE, "", "level", "", "info", "setup", "Companion", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VMConsoleLogModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "VMLog";
    private static final String TAG = "VMSDK_VMConsoleLogModule";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JSMethod
    public final void setup() {
        rnb.c.c(TAG, "setup: ");
    }

    public VMConsoleLogModule(Context r1) {
        super(r1);
    }

    @JSMethod
    public final void info(String r3) {
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        rnb.c.c(TAG, "log:" + r3 + ' ');
    }

    @JSMethod
    public final void log(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        rnb.c.c(TAG, "log level: " + r4 + ", " + r3 + ' ');
    }
}
