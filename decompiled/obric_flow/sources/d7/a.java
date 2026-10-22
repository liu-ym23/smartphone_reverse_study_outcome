package d7;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f16611a = null;

    static {
        HashMap r5 = new HashMap();
        f16611a = r5;
        r5.put("xx", 12334);
    }

    public static Integer a(String r5) {
        return (Integer) f16611a.get(r5);
    }
}
