package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.bdinstall.DrLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DisplayLoader extends BaseLoader {
    private final Context mApp;

    DisplayLoader(Context r10) {
        super(true, false);
        this.mApp = r10;
    }

    private void addNewDisplayInfo(JSONObject r10, DisplayMetrics r11) {
        int r12 = r11.densityDpi;
        if (r12 > 120) goto L6;
        String r13 = "ldpi";
    L21:
        r10.put("display_density_v2", r13);
        int[] r14 = getScreenPixels();
        r10.put("resolution_v2", r14[1] + "x" + r14[0]);
        if (DrLog.debug() == false) goto L25;
        DrLog.d("resolution " + r14[1] + "x" + r14[0]);
        return;
    L25:
        return;
    L6:
        if (r12 > 160) goto L9;
        r13 = "mdpi";
        goto L21
    L9:
        if (r12 > 240) goto L12;
        r13 = "hdpi";
        goto L21
    L12:
        if (r12 > 320) goto L15;
        r13 = "xhdpi";
        goto L21
    L15:
        if (r12 > 480) goto L18;
        r13 = "xxhdpi";
        goto L21
    L18:
        if (r12 > 640) goto L20;
        r13 = "xxxhdpi";
        goto L21
    L20:
        r13 = "xxxxhdpi";
        goto L21
    }

    private void addOldDisplayInfo(JSONObject r10, DisplayMetrics r11) {
        int r12 = r11.densityDpi;     // Catch: Exception -> L14
        if (r12 != 120) goto L5;
        String r13 = "ldpi";
    L12:
        r10.put("density_dpi", r12);     // Catch: Exception -> L14
        r10.put("display_density", r13);     // Catch: Exception -> L14
        r10.put("resolution", r11.heightPixels + "x" + r11.widthPixels);     // Catch: Exception -> L14
        return;
    L5:
        if (r12 != 240) goto L7;
        r13 = "hdpi";
        goto L12
    L7:
        if (r12 == 320) goto L9;
        r13 = "mdpi";
        goto L12
    L9:
        r13 = "xhdpi";
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    private int[] getScreenPixels() {
        WindowManager r10 = (WindowManager) this.mApp.getSystemService("window");     // Catch: Throwable -> L34
        DisplayMetrics r11 = new DisplayMetrics();     // Catch: Throwable -> L34
        Display r12 = r10.getDefaultDisplay();     // Catch: Throwable -> L34
        int r13 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L34
        if (r13 < 17) goto L41;
        r12.getRealMetrics(r11);     // Catch: Throwable -> L34
        int r14 = r11.widthPixels;     // Catch: Throwable -> L34
        int r15 = r11.heightPixels;     // Catch: Throwable -> L8
    L38:
        return new int[]{r14, r15};
    L8:
        th = th;
    L42:
    L36:
        th.printStackTrace();
        r15 = 0;
        goto L38
    L41:
        Method r16 = Display.class.getMethod("getRawHeight", new Class[0]);     // Catch: Throwable -> L34
        int r17 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(r12, new Object[0])).intValue();     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L25 IllegalArgumentException -> L28 Throwable -> L34
        r15 = ((Integer) r16.invoke(r12, new Object[0])).intValue();     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16 IllegalArgumentException -> L18 Throwable -> L32
    L24:
        r14 = r17;
        goto L38
    L16:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L32
    L23:
        r15 = 0;
    L18:
        e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L32
    L14:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L32
        goto L23
    L25:
        e = e;
        r17 = 0;
    L28:
        e = e;
        r17 = 0;
    L20:
        e = e;
        r17 = 0;
    L32:
        th = th;
        r14 = r13;
    L34:
        th = th;
        r14 = 0;
        goto L36
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        DisplayMetrics r11 = this.mApp.getResources().getDisplayMetrics();
        addOldDisplayInfo(r10, r11);
        addNewDisplayInfo(r10, r11);
        return true;
    }
}
