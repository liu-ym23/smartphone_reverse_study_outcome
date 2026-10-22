package androidx.core.content;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ContextCompat$Api30Impl {
    private ContextCompat$Api30Impl() {
    }

    public static String getAttributionTag(Context r0) {
        return r0.getAttributionTag();
    }

    public static Display getDisplayOrDefault(Context r1) {
        return r1.getDisplay();
    L4:
        Objects.toString(r1);
        return ((DisplayManager) r1.getSystemService(DisplayManager.class)).getDisplay(0);
    }

    public static Context createAttributionContext(Context r0, String r1) {
        return r0.createAttributionContext(r1);
    }
}
