package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r10) {
        if (r10 != null) goto L6;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L41;
        if (r10 == null) goto L30;
        List r12 = CollectionsKt.mutableListOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L23:
        if (r14.hasNext() == false) goto L28;
        String r15 = (String) r14.next();
        if (ContextCompat.checkSelfPermission(r10, r15) != (-1)) goto L23;
        r13.add(r15);
        goto L23
    L28:
        if ((!r13.isEmpty()) == true) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == false) goto L42;
        return true;
    L42:
        return false;
    L30:
        r16 = false;
        goto L31
    L41:
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L34;
        Object r17 = r10.getSystemService(com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        if ((r17 instanceof LocationManager) == true) goto L10;
        r17 = null;
    L10:
        LocationManager r18 = (LocationManager) r17;
        if (r18 == null) goto L18;
        r11 = r18.isLocationEnabled();
        goto L19
    L34:
        if (Settings.Secure.getInt(r10.getContentResolver(), "location_mode") == 0) goto L18;
        r11 = true;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }
}
