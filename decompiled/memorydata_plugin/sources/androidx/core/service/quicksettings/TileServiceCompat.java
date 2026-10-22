package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TileServiceCompat {
    private static TileServiceWrapper sTileServiceWrapper;

    private static class Api24Impl {
        private Api24Impl() {
        }

        static void startActivityAndCollapse(TileService r2, Intent r3) {
            ((TileService) ZeusTransformUtils.wrapperContextForParams(r2, TileService.class, "com.obric.memorydata.plugin")).startActivityAndCollapse(r3);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void startActivityAndCollapse(TileService r2, PendingIntent r3) {
            ((TileService) ZeusTransformUtils.wrapperContextForParams(r2, TileService.class, "com.obric.memorydata.plugin")).startActivityAndCollapse(r3);
        }
    }

    interface TileServiceWrapper {
        void startActivityAndCollapse(PendingIntent r1);

        void startActivityAndCollapse(Intent r1);
    }

    private TileServiceCompat() {
    }

    public static void clearTileServiceWrapper() {
        sTileServiceWrapper = null;
    }

    public static void setTileServiceWrapper(TileServiceWrapper r2) {
        sTileServiceWrapper = (TileServiceWrapper) ZeusTransformUtils.wrapperContextForParams(r2, TileServiceWrapper.class, "com.obric.memorydata.plugin");
    }

    public static void startActivityAndCollapse(TileService r2, PendingIntentActivityWrapper r3) {
        TileService r4 = (TileService) ZeusTransformUtils.wrapperContextForParams(r2, TileService.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L9;
        TileServiceWrapper r0 = sTileServiceWrapper;
        if (r0 == null) goto L7;
        r0.startActivityAndCollapse(r3.getPendingIntent());
        return;
    L7:
        Api34Impl.startActivityAndCollapse(r4, r3.getPendingIntent());
        return;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        TileServiceWrapper r1 = sTileServiceWrapper;
        if (r1 == null) goto L13;
        r1.startActivityAndCollapse(r3.getIntent());
        return;
    L13:
        Api24Impl.startActivityAndCollapse(r4, r3.getIntent());
        return;
    }
}
