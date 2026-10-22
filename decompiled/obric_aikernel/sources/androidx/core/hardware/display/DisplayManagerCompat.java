package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = null;
    private final Context mContext;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Display getDisplay(DisplayManager r10, int r11) {
            return r10.getDisplay(r11);
        }

        @DoNotInline
        static Display[] getDisplays(DisplayManager r10) {
            return r10.getDisplays();
        }
    }

    static {
        sInstances = new WeakHashMap();
    }

    private DisplayManagerCompat(Context r10) {
        this.mContext = r10;
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context r10) {
        WeakHashMap<Context, DisplayManagerCompat> r11 = sInstances;
        monitor-enter(r11);
        DisplayManagerCompat r12 = r11.get(r10);     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        r12 = new DisplayManagerCompat(r10);     // Catch: Throwable -> L9
        r11.put(r10, r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    @Nullable
    public Display getDisplay(int r10) {
        int r11 = Build.VERSION.SDK_INT;
        Context r12 = this.mContext;
        if (r11 >= 17) goto L5;
        Display r13 = ((WindowManager) r12.getSystemService("window")).getDefaultDisplay();
        if (r13.getDisplayId() != r10) goto L9;
        return r13;
    L9:
        return null;
    L5:
        return Api17Impl.getDisplay((DisplayManager) r12.getSystemService("display"), r10);
    }

    @NonNull
    public Display[] getDisplays() {
        int r10 = Build.VERSION.SDK_INT;
        Context r11 = this.mContext;
        if (r10 < 17) goto L7;
        return Api17Impl.getDisplays((DisplayManager) r11.getSystemService("display"));
    L7:
        return new Display[]{((WindowManager) r11.getSystemService("window")).getDefaultDisplay()};
    }

    @NonNull
    public Display[] getDisplays(@Nullable String r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    L7:
        if (r10 != null) goto L11;
        return new Display[0];
    L11:
        return new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
    }
}
