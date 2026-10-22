package t1c;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import x1c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements d {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // x1c.d
    public final x1c.b y1() {
        d r0 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r0 != null) goto L7;
        Log.w("OfficeProfileProtocolProxy", "Using fallback getCurrentDoubaoUserInfo implementation");
        return new x1c.b("", "", false, false);
    L7:
        return r0.y1();
    }

    @Override // x1c.d
    public final void A0(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "doubaoUserId");
        d r0 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r0 == null) goto L5;
        r0.A0(r2, r3);
        return;
    L5:
        Log.w("OfficeProfileProtocolProxy", "Using fallback navigateToDoubaoHomepage implementation");
    }

    @Override // x1c.d
    public final Object C(String r2, Continuation<? super x1c.a> r3) {
        d r0 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r0 != null) goto L5;
        Log.w("OfficeProfileProtocolProxy", "Using fallback getDoubaoHomepageData implementation");
        return new x1c.a(CollectionsKt.emptyList());
    L5:
        return r0.C(r2, r3);
    }

    @Override // x1c.d
    public final Object n1(String r2, Continuation<? super x1c.b> r3) {
        d r0 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        if (r0 != null) goto L5;
        Log.w("OfficeProfileProtocolProxy", "Using fallback getDoubaoUserInfo implementation");
        return new x1c.b("", "", false, false);
    L5:
        return r0.n1(r2, r3);
    }
}
