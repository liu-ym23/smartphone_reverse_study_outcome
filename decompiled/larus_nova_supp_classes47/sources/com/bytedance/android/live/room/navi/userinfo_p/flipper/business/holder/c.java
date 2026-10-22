package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends CommonTabHolder {
    public static final /* synthetic */ int j = 0;
    public com.bytedance.android.live.room.navi.userinfo.cert.a h;
    public String i;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.room.navi.userinfo.cert.a.InterfaceC0211a {
        public final /* synthetic */ c a;

        @Override // com.bytedance.android.live.room.navi.userinfo.cert.a.InterfaceC0211a
        public final void a() {
        }

        @Override // com.bytedance.android.live.room.navi.userinfo.cert.a.InterfaceC0211a
        public final void onShow() {
        }

        @Override // com.bytedance.android.live.room.navi.userinfo.cert.a.InterfaceC0211a
        public final void onUnload() {
        }

        @Override // com.bytedance.android.live.room.navi.userinfo.cert.a.InterfaceC0211a
        public final ViewGroup getContainer() {
            View r0 = this.a.f;
            if ((r0 instanceof ViewGroup) == true) goto L6;
            r0 = null;
        L6:
            return (ViewGroup) r0;
        }

        public b(c r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        com.bytedance.android.live.room.navi.userinfo.cert.a r0 = this.h;
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
    public final void k(u91.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        IRoom r2 = this.d;
        if (r2 == null) goto L7;
        AnchorTabLabel r3 = r2.getAnchorTabLabel();
    L8:
        r(r3);
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void o(IRoom r1) {
        this.d = r1;
        if (r1 == null) goto L5;
        AnchorTabLabel r2 = r1.getAnchorTabLabel();
    L6:
        r(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void r(AnchorTabLabel r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r3.getKey(), this.i) == true) goto L12;
        String r0 = r3.getKey();
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        this.i = r0;
        com.bytedance.android.live.room.navi.userinfo.cert.a r1 = new com.bytedance.android.live.room.navi.userinfo.cert.a(new b(this));
        r1.c();
        r1.d(r3);
        Unit r4 = Unit.INSTANCE;
        this.h = r1;
        q("poi");
        return;
    }

    public c(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
        this.i = "";
    }
}
