package v91;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.UserInfoFlipperLayout;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper;
import kotlin.jvm.internal.Intrinsics;
import w91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements v91.a {
    public Integer a;
    public BaseTabFlipper b;
    public final boolean c;
    public final BaseTabFlipper d;
    public final BaseTabFlipper e;

    public static final class a {
    }

    static {
    }

    public static void c(String r2) {
        ALogger.d("UserInfoTabFlipSynchronizer", "no need to sync tab because: " + r2);
    }

    @Override // v91.a
    public final boolean a(BaseTabFlipper r12) {
        Intrinsics.checkNotNullParameter(r12, "wannaSyncFlipper");
        if (this.c == true) goto L5;
        return false;
    L5:
        ALogger.d("UserInfoTabFlipSynchronizer", "judge is need to sync tab");
        if (Intrinsics.areEqual(this.d, r12) == false) goto L8;
        BaseTabFlipper r2 = this.e;
    L9:
        w91.b<? extends Object, ? extends f> r3 = r2.getAdapter();
        w91.b<? extends Object, ? extends f> r5 = null;
        if ((r3 instanceof w91.b) == true) goto L12;
        r3 = null;
    L12:
        if (r3 != null) goto L15;
        c("the compare flipper layout's adapter is null");
        return false;
    L15:
        w91.b<? extends Object, ? extends f> r4 = r12.getAdapter();
        if ((r4 instanceof w91.b) == false) goto L19;
        r5 = r4;
    L19:
        if (r5 != null) goto L22;
        c("the flipper layout's adapter is null");
        return false;
    L22:
        View r6 = r12.getCurDisplayView();
        if (r6 == null) goto L25;
        int r13 = r12.f(r6);
    L26:
        int r7 = r5.getItemSize();
        if (r13 <= 0) goto L30;
        r7 = r7 - 1;
    L30:
        if (r7 == r3.getItemSize()) goto L33;
        c("the flipper tab item size is not same");
        return false;
    L33:
        int r8 = 0;
    L35:
        if (r8 >= r7) goto L48;
        if (r13 == (-1)) goto L39;
        if (r8 < r13) goto L39;
        int r9 = r8 + 1;
    L60:
    L45:
        e = move-exception;
        c("compare tab data fail.error:" + e);
        ALogger.e("UserInfoTabFlipSynchronizer", e);
        return false;
    L41:
        if ((true ^ Intrinsics.areEqual(r3.getData(r8), r5.getData(r9))) == true) goto L42;
        r8 = r8 + 1;
        goto L35
    L42:
        c("the flipper data is not match");     // Catch: Exception -> L45
        return false;
    L39:
        r9 = r8;
        goto L60
    L48:
        View r14 = r2.getCurDisplayView();
        if (r14 == null) goto L58;
        this.a = Integer.valueOf(r2.f(r14) + 1);
        this.b = r2;
        StringBuilder r15 = new StringBuilder("should sync:");
        if (this.a == null) goto L53;
        boolean r10 = true;
    L54:
        r15.append(r10);
        ALogger.d("UserInfoTabFlipSynchronizer", r15.toString());
        if (this.a == null) goto L64;
        return true;
    L64:
        return false;
    L53:
        r10 = false;
        goto L54
    L58:
        c("the compare flipper does not display a tab now");
        return false;
    L25:
        r13 = -1;
        goto L26
    L8:
        r2 = this.d;
        goto L9
    }

    @Override // v91.a
    public final void b(BaseTabFlipper r6) {
        Intrinsics.checkNotNullParameter(r6, "wannaSyncFlipper");
        BaseTabFlipper r0 = this.b;
        Integer r1 = this.a;
        this.b = null;
        this.a = null;
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
        ALogger.i("UserInfoTabFlipSynchronizer", "do sync tab,target pos is" + r2);
        if (r0 == null) goto L7;
        r0.j(r2, true);
    L7:
        r6.j(r2, true);
        return;
    L8:
        ALogger.i("UserInfoTabFlipSynchronizer", "do sync tab,just show next");
        r6.i();
    }

    public b(boolean r2, UserInfoFlipperLayout r3, UserInfoFlipperLayout r4) {
        Intrinsics.checkNotNullParameter(r3, "firstTab");
        Intrinsics.checkNotNullParameter(r4, "second");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
