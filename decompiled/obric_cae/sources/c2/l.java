package c2;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f3306a = null;

        static {
            f3306a = new l();
        }
    }

    public l() {
        new HashSet();
    }

    public static void a(Throwable r8) {
        if (k.d() == true) goto L14;
        JSONObject r10 = k.f3299c;
        if (r10 != null) goto L7;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L14;
        return;
    L7:
        if (r10.optString("channel") == null) goto L10;
        r11 = r10.optString("channel").contains("local");
    L14:
        throw new RuntimeException(r8);
    }
}
