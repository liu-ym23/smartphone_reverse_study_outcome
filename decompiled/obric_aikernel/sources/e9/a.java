package e9;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8754a = null;

    static {
        f8754a = new a();
    }

    private a() {
    }

    public final JSONObject a(String r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r11 = true;
    L8:
        if (r11 == true) goto L16;
        return new JSONObject(r10);
    L13:
        return new JSONObject();
    L16:
        return new JSONObject();
    L4:
        if (r10.length() == 0) goto L7;
        r11 = false;
        goto L8
    }
}
