package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends CommonTabHolder {
    public static final /* synthetic */ int i = 0;
    public TextView h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        q("");
        View r0 = this.f.findViewById(2131390378);
        if ((r0 instanceof TextView) == true) goto L5;
        r0 = null;
    L5:
        this.h = (TextView) r0;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r2) {
        TextView r3 = this.h;
        if (r3 == null) goto L12;
        IRoom r0 = this.d;
        if (r0 == null) goto L9;
        AnchorTabLabel r1 = r0.getAnchorTabLabel();
        if (r1 == null) goto L9;
        String r4 = r1.getContent();
    L10:
        r3.setText(r4);
        return;
    L9:
        r4 = null;
        goto L10
    }

    public f(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
