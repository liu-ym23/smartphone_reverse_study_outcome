package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends CommonTabHolder {
    public static final /* synthetic */ int i = 0;
    public RoomImageLayoutController h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        q("brand_flagship");
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        RoomImageLayoutController r0 = this.h;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.h = null;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void i(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        h(r2);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void o(IRoom r3) {
        this.d = r3;
        if (r3 == null) goto L7;
        AnchorTabLabel r4 = r3.getAnchorTabLabel();
        if (r4 == null) goto L7;
        py.k r5 = r4.getLabel();
    L8:
        if (r5 != null) goto L21;
        Spm.Companion.getClass();
        Spm r6 = Spm.a.a("a100.c100.d100");
        IRoom r0 = this.d;
        String r1 = "";
        if (r0 == null) goto L13;
        String r2 = r0.getOwnerUserIdString();
        if (r2 == null) goto L13;
    L14:
        Spm r7 = r6.anchorId(r2);
        IRoom r8 = this.d;
        if (r8 == null) goto L20;
        String r9 = r8.getIdStr();
        if (r9 == null) goto L20;
        r1 = r9;
    L20:
        sw2.a.b(r7.roomId(r1).aliasAppend("render_cert_failed").result(-1).reason("cert info is null").w(), "AudienceImageHolder");
        return;
    L13:
        r2 = "";
        goto L14
    L21:
        RoomImageLayoutController r10 = new RoomImageLayoutController(new e(this));
        r10.d();
        r10.e(r5);
        Unit r12 = Unit.INSTANCE;
        this.h = r10;
        return;
    L7:
        r5 = null;
        goto L8
    }

    public d(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
