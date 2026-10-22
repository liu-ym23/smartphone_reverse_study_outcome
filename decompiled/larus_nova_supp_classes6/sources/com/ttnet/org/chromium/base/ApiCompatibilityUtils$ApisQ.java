package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApiCompatibilityUtils$ApisQ {
    private ApiCompatibilityUtils$ApisQ() {
    }

    public static boolean isRunningInUserTestHarness() {
        return ActivityManager.isRunningInUserTestHarness();
    }

    public static List<Integer> getTargetableDisplayIds(Activity r9) {
        ArrayList r0 = new ArrayList();
        if (r9 != null) goto L5;
        return r0;
    L5:
        DisplayManager r1 = (DisplayManager) r9.getSystemService("display");
        if (r1 != null) goto L8;
        return r0;
    L8:
        Display[] r2 = r1.getDisplays();
        ActivityManager r3 = (ActivityManager) r9.getSystemService("activity");
        int r4 = r2.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L16;
        Display r6 = r2[r5];
        if (r6.getState() != 2) goto L15;
        if (r3.isActivityStartAllowedOnDisplay(r9, r6.getDisplayId(), new Intent(r9, r9.getClass())) == false) goto L15;
        r0.add(Integer.valueOf(r6.getDisplayId()));
    L15:
        r5 = r5 + 1;
        goto L9
    L16:
        return r0;
    }
}
