package b0;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f815c;

    public f(int r5, int r10, int r11) {
        this.f813a = r5;
        this.f814b = r10;
        this.f815c = r11;
    }

    public f(e r10) {
        Context r5 = (Context) r10.f811b;
        ActivityManager r11 = (ActivityManager) r10.f812c;
        if (r11.isLowRamDevice() == false) goto L5;
        int r12 = 2097152;
    L6:
        this.f815c = r12;
        float r13 = r11.getMemoryClass() * 1048576;
        if (r11.isLowRamDevice() == false) goto L9;
        float r14 = 0.33f;
    L10:
        int r15 = Math.round(r13 * r14);
        DisplayMetrics r16 = (DisplayMetrics) ((ug.e) r10.d).f22361b;
        float r17 = (r16.widthPixels * r16.heightPixels) * 4;
        float r18 = r10.f810a;
        int r19 = Math.round(r17 * r18);
        int r20 = Math.round(r17 * 2.0f);
        int r21 = r15 - r12;
        int r22 = r20 + r19;
        if (r22 > r21) goto L13;
        this.f814b = r20;
        this.f813a = r19;
    L15:
        if (Log.isLoggable("MemorySizeCalculator", 3) == false) goto L22;
        StringBuilder r23 = new StringBuilder("Calculation complete, Calculated memory cache size: ");
        r23.append(Formatter.formatFileSize(r5, this.f814b));
        r23.append(", pool size: ");
        r23.append(Formatter.formatFileSize(r5, this.f813a));
        r23.append(", byte array size: ");
        r23.append(Formatter.formatFileSize(r5, r12));
        r23.append(", memory class limited? ");
        if (r22 <= r15) goto L19;
        boolean r24 = true;
    L20:
        r23.append(r24);
        r23.append(", max size: ");
        r23.append(Formatter.formatFileSize(r5, r15));
        r23.append(", memoryClass: ");
        r23.append(r11.getMemoryClass());
        r23.append(", isLowMemoryDevice: ");
        r23.append(r11.isLowRamDevice());
        Log.d("MemorySizeCalculator", r23.toString());
        return;
    L19:
        r24 = false;
        goto L20
    L22:
        return;
    L13:
        float r25 = r21 / (r18 + 2.0f);
        this.f814b = Math.round(2.0f * r25);
        this.f813a = Math.round(r25 * r18);
        goto L15
    L9:
        r14 = 0.4f;
        goto L10
    L5:
        r12 = 4194304;
        goto L6
    }
}
