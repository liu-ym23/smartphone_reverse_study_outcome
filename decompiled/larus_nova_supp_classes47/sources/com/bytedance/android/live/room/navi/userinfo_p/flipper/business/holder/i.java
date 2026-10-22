package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends g {
    public static final /* synthetic */ int p = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return new r91.b(this.e);
    }

    public i(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
