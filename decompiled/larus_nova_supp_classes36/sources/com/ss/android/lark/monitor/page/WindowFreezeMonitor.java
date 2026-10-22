package com.ss.android.lark.monitor.page;

import android.os.SystemClock;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.setting.WindowFreezeMonitorConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class WindowFreezeMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/monitor/page/WindowFreezeMonitor$TouchSource;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVITY", "POPUP_WINDOW", "DIALOG", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum TouchSource extends Enum<TouchSource> {
        public static final TouchSource ACTIVITY = null;
        public static final TouchSource DIALOG = null;
        public static final TouchSource POPUP_WINDOW = null;
        public static final /* synthetic */ TouchSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TouchSource> getEntries() {
            return b;
        }

        static {
            TouchSource r0 = new TouchSource("ACTIVITY", 0);
            ACTIVITY = r0;
            TouchSource r1 = new TouchSource("POPUP_WINDOW", 1);
            POPUP_WINDOW = r1;
            TouchSource r3 = new TouchSource("DIALOG", 2);
            DIALOG = r3;
            TouchSource[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static TouchSource[] values() {
            return (TouchSource[]) a.clone();
        }

        public static TouchSource valueOf(String r1) {
            return (TouchSource) a.a(TouchSource.class, r1);
        }

        public TouchSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        if (gsb.a.a != null) goto L6;
        long r0 = SystemClock.elapsedRealtime();
        gsb.a.a = (WindowFreezeMonitorConfig) SettingManager.getInstance().get(WindowFreezeMonitorConfig.class);
        Log.i("MonitorConfig", "getWindowFreezeMonitorConfig = " + gsb.a.a + ", cost = " + (SystemClock.elapsedRealtime() - r0));
    L6:
        if (gsb.a.a != null) goto L9;
        new WindowFreezeMonitorConfig(false, 0, 0, 0, false, false, false, false, false, false, 1023, null);
        return;
    }

    public static boolean a(LKUIRoundLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.isAttachedToWindow() == true) goto L5;
    L10:
        return false;
    L5:
        if (r2.getWindowVisibility() == 0) goto L8;
        return true;
    L8:
        if (r2.getChildCount() != 0) goto L10;
        return true;
    }
}
