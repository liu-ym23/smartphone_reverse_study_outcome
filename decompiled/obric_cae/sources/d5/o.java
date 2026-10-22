package d5;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class o extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6823e;

    public o(Context r8) {
        super(true, false);
        this.f6823e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r13) {
        String r8 = "mdpi";
        Context r12 = this.f6823e;
        DisplayMetrics r10 = r12.getResources().getDisplayMetrics();
        int r11 = r10.densityDpi;     // Catch: Exception -> L13
        if (r11 == 120) goto L10;
        if (r11 == 240) goto L9;
        if (r11 == 320) goto L8;
        Object r14 = "mdpi";
    L11:
        r13.put("density_dpi", r11);     // Catch: Exception -> L13
        r13.put("display_density", r14);     // Catch: Exception -> L13
        r13.put("resolution", r10.heightPixels + "x" + r10.widthPixels);     // Catch: Exception -> L13
    L15:
        int r15 = r10.densityDpi;
        if (r15 > 120) goto L19;
        r8 = "ldpi";
    L32:
        r13.put("display_density_v2", r8);
        WindowManager r16 = (WindowManager) r12.getSystemService("window");     // Catch: Throwable -> L38
        DisplayMetrics r17 = new DisplayMetrics();     // Catch: Throwable -> L38
        r16.getDefaultDisplay().getRealMetrics(r17);     // Catch: Throwable -> L38
        int r18 = r17.widthPixels;     // Catch: Throwable -> L38
        int r19 = r17.heightPixels;     // Catch: Throwable -> L36
    L41:
        int[] r110 = {r18, r19};
        r13.put("resolution_v2", r110[1] + "x" + r110[0]);
        int r111 = x4.r.f13543a;
        return true;
    L36:
        Throwable th = th;
    L40:
        th.printStackTrace();
        r19 = 0;
    L38:
        th = move-exception;
        th = th;
        r18 = 0;
        goto L40
    L19:
        if (r15 <= 160) goto L32;
        if (r15 > 240) goto L23;
        r8 = "hdpi";
        goto L32
    L23:
        if (r15 > 320) goto L26;
        r8 = "xhdpi";
        goto L32
    L26:
        if (r15 > 480) goto L29;
        r8 = "xxhdpi";
        goto L32
    L29:
        if (r15 > 640) goto L31;
        r8 = "xxxhdpi";
        goto L32
    L31:
        r8 = "xxxxhdpi";
        goto L32
    L8:
        r14 = "xhdpi";
        goto L11
    L9:
        r14 = "hdpi";
        goto L11
    L10:
        r14 = "ldpi";
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
