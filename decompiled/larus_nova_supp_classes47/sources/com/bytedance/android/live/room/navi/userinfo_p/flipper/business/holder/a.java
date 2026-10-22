package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.message.model.t;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends CommonTabHolder {
    public static final /* synthetic */ int i = 0;
    public TextView h;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.a$a, reason: collision with other inner class name */
    public static final class C0214a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return new r91.c();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        View r0 = this.f.findViewById(2131390378);
        if ((r0 instanceof TextView) == true) goto L5;
        r0 = null;
    L5:
        this.h = (TextView) r0;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r5) {
        if (r5 == null) goto L5;
        tlc.d r1 = r5.e;
    L7:
        if ((r1 instanceof t) == true) goto L9;
        r1 = null;
    L9:
        t r2 = (t) r1;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r5.c != 1) goto L18;
        Text r6 = r2.topText;
        if (r6 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r6, null, new y(0.0f), new b(this));
        return;
    L24:
        return;
    L18:
        Text r7 = r2.bottomText;
        if (r7 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r7, null, new y(0.0f), new b(this));
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public a(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
