package com.bytedance.android.livesdk.chatroom.ui.behavior;

import android.view.View;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements c0.b {
    public a a;
    public boolean b;
    public DataCenter c;

    public static final class a<T> implements Observer {
        public final /* synthetic */ c a;
        public final /* synthetic */ View b;

        public a(c r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.intValue() != 0) goto L8;
            this.b.setBackgroundResource(2131252973);
            this.a.b = false;
            return;
        L8:
            this.b.setBackgroundResource(2131251197);
            this.a.b = true;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public c() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.b == false) goto L5;
        return;
    L5:
        DataCenter r4 = this.c;
        if (r4 == null) goto L15;
        IAbilityCenter r5 = a0.a(r4);
        if (r5 == null) goto L15;
        IRoomRecordService r6 = r5.getAbility(IRoomRecordService.class);
        if (r6 == null) goto L15;
        if (r6.isRecording() != true) goto L15;
        f2.b(2131921971, 0);
        return;
    L15:
        u.h = "0";
        j0.d = "0";
        b0.o().getClass();
        g.a("ttlive_room_exit", "ToolbarScreenOrientationBehavior cause to hide interaction");
        xs2.b.a().post(new HorizontalPlayEvent(1, 1));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (this.a == null) goto L6;
        hd0.c.f().e(this.a);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c = r3;
        r3.c(r2, s1.B(2131918656), true);
        this.a = new a(this, r2);
        hd0.c.f().c(this.a);
    }
}
