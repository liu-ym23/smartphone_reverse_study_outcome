package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.av0;
import com.bytedance.android.livesdk.config.ox0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarMultiCameraBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final String a;
    public RoomContext b;
    public HSImageView c;
    public HSImageView d;
    public DraweeController e;
    public Disposable f;
    public final a g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    public final DataCenter m;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodel.c {
        public final /* synthetic */ ToolbarMultiCameraBehavior a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.MULTI_CAMERA;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.g.b;
        }

        public a(ToolbarMultiCameraBehavior r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r9) {
            this.a.c("vrAnimScheduled");
            long r10 = System.currentTimeMillis();
            int r0 = av0.a.getValue().a();
            ToolbarMultiCameraBehavior r1 = this.a;
            if ((r10 - r1.j) >= (r0 - 100)) goto L6;
            r1.c("return time=" + (r10 - this.a.j) + ",interval=" + r0);
            return false;
        L6:
            r1.j = r10;
            HSImageView r11 = r1.d;
            if (r11 != null) goto L9;
            return true;
        L9:
            if (r11 == null) goto L11;
            r11.setVisibility(0);
        L11:
            DraweeController r12 = this.a.e;
            if (r12 == null) goto L16;
            Animatable r13 = r12.getAnimatable();
            if (r13 == null) goto L16;
            r13.start();
        L16:
            ToolbarMultiCameraBehavior r14 = this.a;
            if (r14.h == false) goto L21;
            HSImageView r15 = r14.c;
            if (r15 == null) goto L21;
            r15.setVisibility(8);
        L21:
            this.a.i = true;
            return true;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ToolbarMultiCameraBehavior a;

        public b(ToolbarMultiCameraBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            es0.a r12 = (es0.a) ((KVData) r11).getData();
            String r3 = "0";
            if ((r12 instanceof es0.a.d) == false) goto L42;
            final ToolbarMultiCameraBehavior r13 = this.a;
            LiveToolbarData r0 = com.bytedance.android.live.core.utils.z.o(r13.m).getToolbarData();
            String r6 = null;
            if (r0 == null) goto L29;
            List r1 = r0.getToolbarDataList();
            if (r1 == null) goto L29;
            Iterator<T> r2 = r1.iterator();
        L10:
            if (r2.hasNext() == false) goto L17;
            T r7 = r2.next();
            if (((IToolbarComponentData) r7).getId() != 42) goto L14;
            boolean r8 = true;
        L15:
            if (r8 == false) goto L10;
        L18:
            IToolbarComponentData r9 = (IToolbarComponentData) r7;
            if (r9 == null) goto L29;
            String r4 = r9.getExtraData();
            if (r4 == null) goto L29;
            ym0.b r5 = (ym0.b) GsonProtectorUtils.fromJson(new Gson(), r4, ym0.b.class);
            if (r5 == null) goto L29;
            List r10 = r5.b();
            if (r10 == null) goto L29;
            ym0.a r14 = (ym0.a) CollectionsKt.firstOrNull(r10);
            if (r14 == null) goto L29;
            final String r15 = r14.a();
        L30:
            if (r15 == null) goto L35;
            HSImageView r16 = r13.d;
            if (r16 == null) goto L35;
            r16.post(new ToolbarMultiCameraBehavior$setSubCameraIcon$1(r13, r15));
        L35:
            this.a.k = System.currentTimeMillis();
            if (this.a.b() == false) goto L61;
            ToolbarMultiCameraBehavior r17 = this.a;
            String r18 = String.valueOf(VrUtils.l(r17.m));
            com.bytedance.android.livesdk.log.g r19 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r20 = new Pair[6];
            User r21 = com.bytedance.android.live.core.utils.z.o(r17.m).getOwner();
            if (r21 == null) goto L40;
            r6 = r21.getIdString();
        L40:
            r20[0] = TuplesKt.to("anchor_id", r6);
            r20[1] = TuplesKt.to("room_id", com.bytedance.android.live.core.utils.z.o(r17.m).getIdStr());
            r20[2] = TuplesKt.to("vr_type", VrUtils.n());
            r20[3] = TuplesKt.to("is_vr_machine", "1");
            r20[4] = TuplesKt.to("is_original_vr", "0");
            r20[5] = TuplesKt.to("screen_direction", r18);
            r19.sendLog("livesdk_live_vr_label_show", MapsKt.mapOf(r20), new Object[]{Room.class, am2.x.class});
            return;
        L61:
            return;
        L14:
            r8 = false;
            goto L15
        L17:
            r7 = null;
        L29:
            r15 = null;
            goto L30
        L42:
            if ((r12 instanceof es0.a.c) == false) goto L63;
            ToolbarMultiCameraBehavior r110 = this.a;
            r110.getClass();
            IAnimationScheduler.M0.getClass();
            if (IAnimationScheduler.Companion.b() == false) goto L49;
            IAnimationScheduler r22 = IAnimationScheduler.Companion.a(r110.m);
            if (r22 == null) goto L49;
            r22.unRegisterListener(r110.g);
        L49:
            ToolbarMultiCameraBehavior.a(this.a);
            if (this.a.b() == false) goto L64;
            boolean r111 = this.a.b();
            com.bytedance.android.livesdk.log.g r23 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r24 = new Pair[2];
            r24[0] = TuplesKt.to("entrance_action_type", "show");
            if (r111 == false) goto L54;
            r3 = "1";
        L54:
            r24[1] = TuplesKt.to("is_vr_multicamera", r3);
            r23.sendLog("livesdk_live_multicamera_entrance", MapsKt.mapOf(r24), new Object[]{Room.class, am2.x.class});
            return;
        L64:
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ToolbarMultiCameraBehavior a;
        public final /* synthetic */ DataCenter b;

        public c(ToolbarMultiCameraBehavior r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) ((KVData) r4).getData();
            if (r5 != null) goto L5;
            r5 = Boolean.FALSE;
        L5:
            boolean r6 = r5.booleanValue();
            Object r2 = null;
            Object r0 = this.b.get("cmd_current_camera_info", null);
            if ((r0 instanceof ym0.a) == false) goto L9;
            r2 = r0;
        L9:
            ym0.a r3 = (ym0.a) r2;
            if (r6 == false) goto L15;
            if (r3 != null) goto L13;
            return;
        L13:
            if (r3.d() != 0) goto L21;
            ToolbarMultiCameraBehavior.a(this.a);
            this.a.k = -1;
            return;
        L21:
            return;
        L15:
            if (r3 != null) goto L17;
            return;
        L17:
            if (r3.d() != 0) goto L24;
            ToolbarMultiCameraBehavior r7 = this.a;
            r7.k = System.currentTimeMillis();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DataCenter a;

        public d(DataCenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            com.bytedance.android.livesdk.interactivity.api.h r4 = com.bytedance.android.livesdk.interactivity.api.i.b(this.a, 1);
            if (r4 == null) goto L10;
            com.bytedance.live.datacontext.n r5 = r4.getMultiCameraContext();
            if (r5 == null) goto L11;
            b42.b r6 = (b42.b) r5.getValue();
            if (r6 == null) goto L12;
            r6.m6();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
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

    public final boolean b() {
        Integer r0 = (Integer) this.m.get("cmd_multicamera_biz_type", -1);
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public ToolbarMultiCameraBehavior(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.m = r3;
        this.a = "ToolbarMultiCameraBehavior";
        this.g = new a(this);
        this.k = -1;
    }

    public static final void a(ToolbarMultiCameraBehavior r5) {
        if (r5.k <= 0) goto L5;
        r5.l += System.currentTimeMillis() - r5.k;
    L5:
        r5.m.put("cmd_sub_camera_total_duration", Long.valueOf(r5.l));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.l.b == true) goto L6;
        return;
    L6:
        if (ox0.a.getValue().booleanValue() == false) goto L16;
        py.k r4 = r3.c;
        if (r4 == null) goto L10;
        ImageUtil.loadImage(this.c, r4, 0);
        return;
    L10:
        HSImageView r5 = this.c;
        if (r5 == null) goto L18;
        r5.setActualImageResource(2131251761);
        return;
    L18:
        return;
    }

    public final void c(String r2) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d(this.a, r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r7) {
        Intrinsics.checkNotNullParameter(r7, "command");
        if ((r7 instanceof pp1.m) == false) goto L6;
        int r8 = ((pp1.m) r7).a;
        return;
    L6:
        if ((r7 instanceof pp1.c) == false) goto L23;
        RoomContext r0 = this.b;
        Context r1 = null;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r0.getToolbarBubbleManager();
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0 r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0) r2.getValue();
    L13:
        HSImageView r4 = this.c;
        if (r4 == null) goto L16;
        r1 = r4.getContext();
    L16:
        if (r1 == null) goto L24;
        HSImageView r5 = this.c;
        if (r3 == null) goto L25;
        if (r5 == null) goto L26;
        r3.addBubble(r7, ((pp1.c) r7).k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.m, r1, r5), new ToolbarMultiCameraBehavior$onCommand$$inlined$lets$lambda$1(this, r7));
        System.currentTimeMillis();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r3 = null;
        goto L13
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        c("ToolbarMultiCameraBehavior Click");
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.m).F0(PaidInteractEntry.CONTROL_ENTRY_COMMUNITY_MULTI_CAMERA) == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.h r3 = com.bytedance.android.livesdk.interactivity.api.i.b(this.m, 1);
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.n r4 = r3.getMultiCameraContext();
        if (r4 == null) goto L14;
        b42.b r5 = (b42.b) r4.getValue();
        if (r5 == null) goto L15;
        r5.on();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Disposable r4 = this.f;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isDisposed() == true) goto L12;
        Disposable r5 = this.f;
        if (r5 == null) goto L9;
        r5.dispose();
    L9:
        this.f = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        this.b = RoomContext.a.c(RoomContext.Companion, r8, 0, 2);
        this.c = r7.findViewById(2131387276);
        LiveToolbarData r0 = com.bytedance.android.live.core.utils.z.o(r8).getToolbarData();
        IToolbarComponentData r2 = null;
        Object r3 = null;
        r2 = null;
        if (r0 == null) goto L16;
        List r1 = r0.getToolbarDataList();
        if (r1 == null) goto L16;
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        if (((IToolbarComponentData) r5).getId() != 42) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L8;
        r3 = r5;
        goto L15
    L12:
        r6 = false;
    L15:
        r2 = (IToolbarComponentData) r3;
    L16:
        int r9 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(r8, false))) == false) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(this.c);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r7.findViewById(2131380426));
        if (r2 == null) goto L23;
        py.k r10 = r2.getIcon();
        if (r10 == null) goto L23;
        ImageUtil.loadImage(this.c, r10, 0);
    L23:
        HSImageView r11 = this.c;
        if (r11 == null) goto L26;
        r11.setActualImageResource(2131251761);
    L26:
        this.d = r7.findViewById(2131362952);
        r8.observe("cmd_current_sub_camera_state", new b(this));
        r8.observe("cmd_is_current_in_background", new c(this, r8));
        this.f = Observable.timer(10, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r8));
    }
}
