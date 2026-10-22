package rtb;

import com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements stb.a {

    /* JADX INFO: renamed from: rtb.a$a, reason: collision with other inner class name */
    public static final class C0184a {
    }

    static {
    }

    public a() {
    }

    @Override // stb.a
    public final String a() {
        stb.a r0 = (stb.a) OfficeSDKManager.getHostGlobalService(stb.a.class);
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // stb.a
    public final void Y0(FeedItemsMoltenLocalCache.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        stb.a r0 = (stb.a) OfficeSDKManager.getHostGlobalService(stb.a.class);
        if (r0 == null) goto L6;
        r0.Y0(r2);
        return;
    }
}
