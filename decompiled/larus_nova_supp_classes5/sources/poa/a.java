package poa;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public final boolean a() {
        if (TextUtils.isEmpty(this.e) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.e.equals("0") == true) goto L8;
        return false;
    }

    public final String toString() {
        return "AppInfo{appID=" + this.a + ", version='" + this.b + "', updateVersionCode='" + this.c + "', deviceID='" + this.d + "', userID='" + this.e + "', channel='" + this.f + "', packageName='" + this.g + "'}";
    }

    public a() {
    }
}
