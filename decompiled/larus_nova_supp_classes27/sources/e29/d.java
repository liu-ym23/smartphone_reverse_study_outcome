package e29;

import androidx.fragment.app.Fragment;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ICommunityHostBehaviorProvider c() {
        return (ICommunityHostBehaviorProvider) ServiceManager.get().getService(ICommunityHostBehaviorProvider.class);
    }

    public static e a(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        ICommunityHostBehaviorProvider r0 = c();
        if (r0 == null) goto L7;
        e r2 = r0.d(r1);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return new e(false, 0);
    }

    public static a b(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        ICommunityHostBehaviorProvider r0 = c();
        if (r0 == null) goto L7;
        a r2 = r0.p(r1);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return new a(0);
    }
}
