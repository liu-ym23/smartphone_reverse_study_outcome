package w3;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<Integer> f13312a;

    static {
        HashSet r10 = new HashSet();
        f13312a = r10;
        r10.add(114);
        f13312a.add(115);
        f13312a.add(116);
        f13312a.add(121);
        f13312a.add(122);
        f13312a.add(123);
    }

    public static boolean a(Message r10) {
        return f13312a.contains(Integer.valueOf(r10.what));
    }
}
