package ki;

import com.bytedance.ies.bullet.core.j;
import com.bytedance.sdk.xbridge.cn.utils.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f18647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f18648c;
    public static j d;
    public static boolean e;

    static {
        f18646a = new a();
        d = new j();
        e = true;
    }

    public static final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (f18648c == false) goto L5;
        return;
    L5:
        ((g) d.f5320b).a("##BDXBridge: " + r5);
    }
}
