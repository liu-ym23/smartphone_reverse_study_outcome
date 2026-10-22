package e3;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f7114a = null;

    static {
        HashMap<String, Integer> r8 = new HashMap();
        f7114a = r8;
        r8.put("xx", 12334);
    }

    public static Integer a(String r8) {
        return f7114a.get(r8);
    }
}
