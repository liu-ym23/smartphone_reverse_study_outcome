package p91;

import android.view.ViewGroup;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.list.UserTabList;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import w91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.bytedance.android.live.room.navi.userinfo_p.flipper.core.b<u91.a, f> {
    public final List<u91.a> c;
    public final DataCenter d;

    @Override // w91.b
    public final int getItemSize() {
        return this.c.size();
    }

    @Override // w91.b
    public final u91.a getData(int r2) {
        return (u91.a) e.d(this.c, r2);
    }

    @Override // w91.b
    public final int getDataPosition(Object r2) {
        u91.a r3 = (u91.a) r2;
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        return this.c.indexOf(r3);
    }

    @Override // w91.b
    public final int getItemViewType(int r2) {
        u91.a r3 = (u91.a) e.d(this.c, r2);
        if (r3 == null) goto L5;
        o91.b r4 = r3.f;
    L7:
        return x91.a.c(2, r4);
    L5:
        r4 = null;
        goto L7
    }

    @Override // w91.b
    public final void a(f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "vh");
        if ((r2 instanceof CommonTabHolder) == true) goto L5;
        r2 = null;
    L5:
        CommonTabHolder r4 = (CommonTabHolder) r2;
        if (r4 == null) goto L9;
        r4.k((u91.a) e.d(this.c, r3));
        return;
    }

    @Override // w91.b
    public final CommonTabHolder b(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        DataCenter r0 = this.d;
        return x91.a.a(r0, (IRoom) r0.get("data_room", null), 2, r5, r4);
    }

    public b(UserTabList r1, DataCenter r2, DataContext r3) {
        Intrinsics.checkNotNullParameter(r1, "tabsList");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r1;
        this.d = r2;
    }
}
