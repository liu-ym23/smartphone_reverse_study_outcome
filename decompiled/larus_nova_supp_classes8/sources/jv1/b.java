package jv1;

import bt2.d;
import com.bytedance.android.livesdk.room.LiveScope;
import com.bytedance.android.livesdk.room.LiveSessionStateManager;
import com.bytedance.android.livesdk.room.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ks2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.android.livesdk.room.a a(LiveScope r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "scope");
        int r6 = a.a[r4.ordinal()];
        if (r6 != 1) goto L5;
        ct2.a r1 = new ct2.a();
        if ((r5 instanceof ks2.b) == true) goto L18;
        r5 = null;
    L18:
        LiveSessionStateManager r7 = new LiveSessionStateManager(r1, (ks2.b) r5);
        r7.initState();
        return r7;
    L5:
        if (r6 != 2) goto L7;
        com.bytedance.android.livesdk.room.b r2 = new com.bytedance.android.livesdk.room.b();
        if ((r5 instanceof ks2.a) == true) goto L14;
        r5 = null;
    L14:
        e r8 = new e(r2, (ks2.a) r5);
        r8.setInit(true);
        return r8;
    L7:
        if (r6 != 3) goto L10;
        d r9 = new d(new bt2.a());
        r9.setInit(true);
        return r9;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
