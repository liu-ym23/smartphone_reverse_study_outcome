package c49;

import android.service.notification.StatusBarNotification;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final int a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final StatusBarNotification k;

    public final String toString() {
        if (AppHost.a.isTestChannel() == false) goto L7;
        return "NLMsg{when=" + this.b + ", pkg='" + this.c + "', pkg_name='" + this.d + "', title='" + this.e + "', subTitle='" + this.f + "', content='" + this.g + "', channel='" + this.h + "', category='" + this.i + "', sbn=" + this.k + '}';
    L7:
        return "NLMsg{when=" + this.b + ", pkg='" + this.c + "', pkg_name='" + this.d + "', title='" + this.e.length() + "', subTitle='" + this.f.length() + "', content='" + this.g.length() + "', channel='" + this.h + "', category='" + this.i + "', sbn=" + this.k + '}';
    }

    public a(int r1, long r2, String r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, StatusBarNotification r12) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
