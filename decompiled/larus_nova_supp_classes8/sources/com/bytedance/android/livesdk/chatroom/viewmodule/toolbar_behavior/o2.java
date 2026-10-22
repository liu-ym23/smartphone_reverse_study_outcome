package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public boolean a;
    public Disposable b;
    public Room c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ o2 a;
        public final /* synthetic */ View b;

        public a(o2 r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            o2 r0 = this.a;
            View r1 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter((zg1.e3) r4, "event");
            Intrinsics.checkNotNullParameter(r1, "v");
            boolean r5 = ((Boolean) l42.a.g.getValue()).booleanValue();
            r0.a = r5;
            r1.setSelected(r5);
        }
    }

    public o2() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        boolean r0 = !this.a;
        this.a = r0;
        if (r7 == null) goto L5;
        r7.setSelected(r0);
    L5:
        Room r8 = this.c;
        if (r8 == null) goto L10;
        if (r8.isMediaRoom() != true) goto L10;
    L13:
        com.bytedance.android.livesdk.sharedpref.e r9 = l42.a.g;
        Boolean r2 = Boolean.valueOf(this.a);
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r2);
        xs2.b.a().post(new zg1.e3(this.a, "toolbar", 2));
        com.bytedance.android.livesdk.log.g r10 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r3 = new Pair[2];
        r3[0] = TuplesKt.to("room_orientation", "1");
        if (this.a == false) goto L16;
        String r4 = "close";
    L17:
        r3[1] = TuplesKt.to("mute_barrage_type", r4);
        Map r5 = MapsKt.mapOf(r3);
        am2.x r1 = new am2.x();
        r1.a = "live";
        r1.e = "click";
        r1.b = "live_detail";
        r10.sendLog("livesdk_landscape_mute_gift_barrage_click", r5, new Object[]{Room.class, r1});
        return;
    L16:
        r4 = "open";
    L10:
        if (this.a == false) goto L12;
        com.bytedance.android.live.core.utils.f2.b(2131915309, 0);
        goto L13
    L12:
        com.bytedance.android.live.core.utils.f2.b(2131915308, 0);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Disposable r4 = this.b;
        if (r4 == null) goto L6;
        r4.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Room r0 = (Room) r8.get("data_room", null);
        this.c = r0;
        boolean r1 = ((Boolean) l42.a.g.getValue()).booleanValue();
        this.a = r1;
        r7.setSelected(r1);
        xs2.b.a().post(new zg1.e3(this.a, "toolbar", 2));
        this.b = xs2.b.a().b(zg1.e3.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r7));
        if (com.bytedance.android.livesdk.utils.landscape.e.b(com.bytedance.android.live.core.utils.z.e(r8, false), r0) == false) goto L6;
        HashMap r9 = new HashMap();
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_landscape_mute_gift_barrage_show", r9, new Object[]{new am2.x(), IRoom.class});
        return;
    }
}
