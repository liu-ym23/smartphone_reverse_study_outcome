package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, WeakReference<DisplayManagerCompat>> sInstances = null;
    private final Context mContext;

    static class Api17Impl {
        private Api17Impl() {
        }

        static Display getDisplay(DisplayManager r0, int r1) {
            return r0.getDisplay(r1);
        }

        static Display[] getDisplays(DisplayManager r0) {
            return r0.getDisplays();
        }
    }

    static {
        sInstances = new WeakHashMap();
    }

    private DisplayManagerCompat(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static DisplayManagerCompat getInstance(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        WeakHashMap<Context, WeakReference<DisplayManagerCompat>> r0 = sInstances;
        monitor-enter(r0);
        WeakReference<DisplayManagerCompat> r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
    L8:
        r1 = new WeakReference(new DisplayManagerCompat(r5));     // Catch: Throwable -> L12
        r0.put(r5, r1);     // Catch: Throwable -> L12
    L9:
        DisplayManagerCompat r6 = (DisplayManagerCompat) ZeusTransformUtils.preCheckCast(r1.get(), DisplayManagerCompat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L7:
        if (r1.get() != null) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public Display getDisplay(int r4) {
        int r0 = Build.VERSION.SDK_INT;
        Context r3 = this.mContext;
        if (r0 >= 17) goto L5;
        Display r5 = ((WindowManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
        if (r5.getDisplayId() != r4) goto L9;
        return r5;
    L9:
        return null;
    L5:
        return Api17Impl.getDisplay((DisplayManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("display"), DisplayManager.class, "com.obric.memorydata.plugin"), r4);
    }

    public Display[] getDisplays() {
        int r0 = Build.VERSION.SDK_INT;
        Context r3 = this.mContext;
        if (r0 < 17) goto L7;
        return Api17Impl.getDisplays((DisplayManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("display"), DisplayManager.class, "com.obric.memorydata.plugin"));
    L7:
        return new Display[]{((WindowManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay()};
    }

    public Display[] getDisplays(String r4) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getDisplays((DisplayManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("display"), DisplayManager.class, "com.obric.memorydata.plugin"));
    L7:
        if (r4 != null) goto L11;
        return new Display[0];
    L11:
        return new Display[]{((WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay()};
    }
}
