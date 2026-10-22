package lh;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19632a = null;

    static {
        StringBuilder r5 = new StringBuilder("(Linux; Android ");
        r5.append(Build.VERSION.RELEASE);
        String r10 = Build.MODEL;
        if (r10.isEmpty() == false) goto L5;
    L7:
        boolean r11 = false;
    L8:
        String r12 = Build.ID;
        if (r12.isEmpty() == true) goto L13;
        if (r11 == true) goto L12;
        r5.append("; ");
    L12:
        r5.append(" Build/");
        r5.append(r12);
    L13:
        r5.append(") Mobile PIA/2.0.0");
        f19632a = r5.toString();
        return;
    L5:
        if ("REL".equals(Build.VERSION.CODENAME) == false) goto L7;
        r5.append("; ");
        r5.append(r10);
        r11 = true;
        goto L8
    }
}
