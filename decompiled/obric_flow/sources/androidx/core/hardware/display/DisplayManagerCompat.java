package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private final Context mContext;

    private DisplayManagerCompat(Context r5) {
        this.mContext = r5;
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context r5) {
        return new DisplayManagerCompat(r5);
    }

    @Nullable
    public Display getDisplay(int r5) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(r5);
    }

    @NonNull
    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    @NonNull
    public Display[] getDisplays(@Nullable String r5) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }
}
