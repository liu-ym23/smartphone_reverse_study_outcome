package co;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1225b;

    public d(HashMap r5) {
        if (r5.get("category") == null) goto L6;
        String r10 = (String) r5.get("category");
    L6:
        if (r5.get("sizeBytes") == null) goto L8;
        long r11 = ((Long) r5.get("sizeBytes")).longValue();
    L9:
        this.f1224a = r11;
        if (r5.get("detail") == null) goto L12;
        HashMap r12 = (HashMap) r5.get("detail");
    L13:
        this.f1225b = r12;
        return;
    L12:
        r12 = new HashMap();
        goto L13
    L8:
        r11 = -1;
        goto L9
    }
}
