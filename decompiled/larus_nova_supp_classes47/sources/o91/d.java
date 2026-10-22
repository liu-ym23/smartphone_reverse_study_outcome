package o91;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.UserInfoFlipperLayout;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.list.UserTabList;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import s91.f;
import w91.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements s91.a<f> {
    public final /* synthetic */ c a;
    public final /* synthetic */ UserInfoFlipperLayout b;
    public final /* synthetic */ List c;
    public final /* synthetic */ w91.b d;

    @Override // s91.a
    public final boolean a(Class<? extends b> r2) {
        Intrinsics.checkNotNullParameter(r2, "tabType");
        View r0 = this.b.getCurDisplayView();
        if (r0 == null) goto L9;
        e r1 = com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.b(r0);
        if (r1 == null) goto L9;
        b r3 = r1.getTabType();
        if (r3 == null) goto L9;
        Class<?> r4 = r3.getClass();
    L11:
        return Intrinsics.areEqual(r4, r2);
    L9:
        r4 = null;
        goto L11
    }

    @Override // s91.a
    public final void c(f r8) {
        f r9 = r8;
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        c r0 = this.a;
        List r1 = this.c;
        w91.b r2 = this.d;
        UserInfoFlipperLayout r3 = this.b;
        r0.getClass();
        ALogger.d("UserInfoTabManager", "change tab dataSet.the operate is " + r9.d.getClass() + "\tthe tabData is " + r9.e);
        s91.d r4 = r9.d;
        if ((r4 instanceof s91.d.a) == false) goto L11;
        r1.add(r9.e);
        if (r2 == null) goto L8;
        r2.notifyDataSetChange();
    L8:
        if (r9.a == false) goto L21;
        r3.j(r1.indexOf(r9.e), r9.b);
        return;
    L21:
        return;
    L11:
        if ((r4 instanceof s91.d.c) == false) goto L16;
        r1.remove(r9.e);
        if (r2 == null) goto L23;
        r2.notifyDataSetChange();
        return;
    L23:
        return;
    L16:
        if ((r4 instanceof s91.d.b) == false) goto L25;
        Integer r10 = r9.c;
        if (r10 == null) goto L26;
        int r12 = r10.intValue();
        ALogger.d("UserInfoTabManager", "reload tab and the render type is " + r12);
        r0.b(r12);
        return;
    L26:
        return;
    }

    public d(c r1, UserInfoFlipperLayout r2, UserTabList r3, com.bytedance.android.live.room.navi.userinfo_p.flipper.core.b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
