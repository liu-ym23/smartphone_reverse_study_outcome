package c6;

import android.content.IntentFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f1125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1126b;

    static {
        f1125a = new ArrayList();
        f1126b = false;
    }

    public static boolean a() {
        if (f1126b == false) goto L6;
        return false;
    L6:
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
        throw null;
    }
}
