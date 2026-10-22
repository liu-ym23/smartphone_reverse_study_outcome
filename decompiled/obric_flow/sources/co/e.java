package co;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f1228c;

    public e(HashMap r5) {
        String r10 = "";
        if (r5.get("name") == null) goto L5;
        String r11 = (String) r5.get("name");
    L6:
        this.f1226a = r11;
        if (r5.get("entryType") == null) goto L9;
        r10 = (String) r5.get("entryType");
    L9:
        this.f1227b = r10;
        this.f1228c = r5;
        return;
    L5:
        r11 = "";
        goto L6
    }
}
