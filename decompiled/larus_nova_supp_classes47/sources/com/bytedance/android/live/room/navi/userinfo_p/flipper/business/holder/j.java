package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends CommonTabHolder {
    public int h;

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final q91.a c() {
        return new q91.a();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final boolean f() {
        return a0.d(this.e, false);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return new r91.a();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final int b() {
        return this.h;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final boolean d(w91.e r1) {
        return r1 instanceof o91.b.g;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final void e(int r1) {
        this.h = r1;
    }

    public j(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
