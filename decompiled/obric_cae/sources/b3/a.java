package b3;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f3032a;

    static {
        new HashSet();
        f3032a = new Handler(Looper.getMainLooper());
    }
}
