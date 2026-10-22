package dp0;

import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {
    public final OpenPlatformContext a;

    public abstract boolean a();

    public abstract void b(String r1, String r2, boolean r3);

    public abstract void c(String r1, String r2, boolean r3);

    public abstract void d(String r1, String r2, String r3);

    public abstract void e(String r1, LinkScreenCastType r2, String r3);

    public abstract void f(String r1, LinkScreenCastType r2);

    public abstract void g();

    public abstract void h(String r1, int r2, int r3, LinkScreenCastType r4, boolean r5);

    public abstract void i(String r1, LinkScreenCastType r2, boolean r3);

    public a(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        this.a = r2;
    }
}
