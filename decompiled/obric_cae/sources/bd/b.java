package bd;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> f3164d = null;

    static {
        new ConcurrentHashMap();
        f3164d = new ConcurrentHashMap();
    }

    public b() {
        new a();
    }
}
