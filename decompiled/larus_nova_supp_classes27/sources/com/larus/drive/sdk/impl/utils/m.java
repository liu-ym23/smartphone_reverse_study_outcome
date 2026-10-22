package com.larus.drive.sdk.impl.utils;

import com.larus.common.apphost.AppHost;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m {
    static {
    }

    public static String a(long r11) {
        if (r11 <= ((System.currentTimeMillis() / 1000) * ((long) 10))) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Date r1 = new Date(r11);
    L9:
        Calendar r12 = Calendar.getInstance();
        Calendar r13 = Calendar.getInstance();
        r13.setTime(r1);
        int r2 = r12.get(1);
        int r3 = r12.get(2) + 1;
        int r7 = r12.get(5);
        int r8 = r13.get(1);
        int r9 = r13.get(2) + 1;
        int r6 = r13.get(5);
        if (r2 != r8) goto L14;
        if (r3 != r9) goto L14;
        if (r7 != r6) goto L14;
        boolean r4 = true;
    L15:
        Calendar r10 = Calendar.getInstance();
        r10.setTime(r12.getTime());
        r10.add(6, -1);
        if (r10.get(1) == r8) goto L18;
    L20:
        boolean r14 = false;
    L21:
        SimpleDateFormat r15 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        if (r4 == false) goto L25;
        return String.valueOf(r15.format(r1));
    L25:
        if (r14 == true) goto L32;
        if (r2 != r8) goto L29;
        StringBuilder r16 = new StringBuilder();
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r16.append(String.format(AppHost.a.getApplication().getString(2131899559), Arrays.copyOf(new Object[]{Integer.valueOf(r9), Integer.valueOf(r6)}, 2)));
        r16.append(' ');
        r16.append(r15.format(r1));
        return r16.toString();
    L29:
        StringBuilder r17 = new StringBuilder();
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        r17.append(String.format(AppHost.a.getApplication().getString(2131899560), Arrays.copyOf(new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r6)}, 3)));
        r17.append(' ');
        r17.append(r15.format(r1));
        return r17.toString();
    L32:
        return AppHost.a.getApplication().getString(2131905308) + ' ' + r15.format(r1);
    L18:
        if (r10.get(6) != r13.get(6)) goto L20;
        r14 = true;
    L14:
        r4 = false;
        goto L15
    L8:
        r1 = new Date(r11 * 1000);
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
