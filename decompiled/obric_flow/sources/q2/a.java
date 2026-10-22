package q2;

import android.app.Activity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList f21471b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList f21472c = null;
    public static final ArrayList d = null;
    public static boolean e;
    public static List f;

    static {
        f21470a = new a();
        f21471b = new LinkedList();
        f21472c = new LinkedList();
        d = new ArrayList();
        e = true;
    }

    public final synchronized Activity a() {
        monitor-enter(this);
        LinkedList r5 = f21471b;     // Catch: Throwable -> L13
        if (r5.isEmpty() == false) goto L6;
        Activity r10 = null;
    L7:
        if (r10 != null) goto L9;
    L15:
        monitor-exit(this);
        return r10;
    L9:
        if (r10.isFinishing() == false) goto L15;
        r5.removeLast();     // Catch: Throwable -> L13
        Activity r11 = a();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r11;
    L6:
        r10 = (Activity) r5.getLast();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
