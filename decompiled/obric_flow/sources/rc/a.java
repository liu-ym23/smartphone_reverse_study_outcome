package rc;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f21720c;

    public a(Context r5, boolean r10) {
        this.f21718a = r5;
        this.f21719b = r10;
        this.f21720c = new z(11);
    }

    public final ConcurrentHashMap a() {
        z r5 = this.f21720c;
        r5.getClass();
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        Iterator r11 = ((ConcurrentHashMap) r5.f23549a).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getKey(), ((tc.b) r12.getValue()).f22118a);
        goto L4
    L6:
        return r10;
    }

    public final void b(Class r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        z r11 = this.f21720c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "clazz");
        if (r10 == null) goto L6;
        ((ConcurrentHashMap) r11.f23549a).put(r5, new tc.b(r10));
        return;
    }
}
