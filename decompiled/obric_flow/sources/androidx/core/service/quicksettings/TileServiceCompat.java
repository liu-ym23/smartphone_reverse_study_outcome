package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class TileServiceCompat {
    private static TileServiceWrapper sTileServiceWrapper;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void startActivityAndCollapse(TileService r5, Intent r10) {
            r5.startActivityAndCollapse(r10);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static void startActivityAndCollapse(TileService r5, PendingIntent r10) {
            r5.startActivityAndCollapse(r10);
        }
    }

    public interface TileServiceWrapper {
        void startActivityAndCollapse(PendingIntent r5);

        void startActivityAndCollapse(Intent r5);
    }

    private TileServiceCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void clearTileServiceWrapper() {
        sTileServiceWrapper = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setTileServiceWrapper(@NonNull TileServiceWrapper r5) {
        sTileServiceWrapper = r5;
    }

    public static void startActivityAndCollapse(@NonNull TileService r5, @NonNull PendingIntentActivityWrapper r10) {
        if (Build.VERSION.SDK_INT < 34) goto L8;
        TileServiceWrapper r11 = sTileServiceWrapper;
        if (r11 == null) goto L7;
        r11.startActivityAndCollapse(r10.getPendingIntent());
        return;
    L7:
        Api34Impl.startActivityAndCollapse(r5, r10.getPendingIntent());
        return;
    L8:
        TileServiceWrapper r12 = sTileServiceWrapper;
        if (r12 == null) goto L11;
        r12.startActivityAndCollapse(r10.getIntent());
        return;
    L11:
        Api24Impl.startActivityAndCollapse(r5, r10.getIntent());
    }
}
