package com.bytedance.android.livesdk.chatroom.widget.unionlive;

import am2.n;
import am2.q;
import am2.x;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.AnchorUnionLiveDataContext;
import com.bytedance.android.livesdk.config.ji1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.GuestAnchor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.UnionLiveInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.l;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/unionlive/UnionAnchorWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionAnchorWidget extends RoomRecyclableWidget implements Observer<KVData> {
    public final UnionLiveAvatarAdapter a;
    public RecyclerView b;
    public TextView c;
    public final boolean d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UnionAnchorWidget a;

        public a(UnionAnchorWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            UnionAnchorWidget r10 = this.a;
            RoomContext r0 = r10.getDataContext();
            if (r0 == null) goto L36;
            m r1 = r0.getRoom();
            if (r1 == null) goto L37;
            Room r2 = (Room) r1.getValue();
            if (r2 == null) goto L38;
            UnionLiveInfo r3 = r2.unionLiveInfo;
            if (r3 == null) goto L39;
            RoomPermissionContext.a r4 = RoomPermissionContext.Companion;
            DataCenter r5 = ((Widget) r10).dataCenter;
            LiveRoomPermission.D.getClass();
            LiveRoomPermission r6 = LiveRoomPermission.A;
            r4.getClass();
            boolean r7 = RoomPermissionContext.a.e(r5, r6);
            if (z.e(((Widget) r10).dataCenter, false) == true) goto L20;
            if (r7 == true) goto L20;
            ILiveActionHandler r8 = k.n(ILiveActionHandler.class);
            Context r11 = ((Widget) r10).context;
            int r12 = com.bytedance.android.live.room.utils.c.a;
            if (((Widget) r10).dataCenter != null) goto L18;
            String r13 = "";
        L19:
            r8.handle(r11, r13);
        L29:
            HashMap r14 = new HashMap();
            DataCenter r15 = ((Widget) r10).dataCenter;
            if (r15 == null) goto L34;
            String r16 = (String) r15.get("data_joint_anchor_id", "");
            if (r16 == null) goto L34;
            r14.put("joint_anchor_id", r16);
        L34:
            r14.put("is_joint_room", "1");
            u.l().sendLog("livesdk_live_top_head_area_click", r14, new Object[]{x.class, Room.class, n.f(), q.class});
            int r17 = d.a;
            d.a("click union widget isAnchor = " + z.e(((Widget) r10).dataCenter, false) + ", isUnionAdmin = " + r7 + " , isUgcUnion = " + r3.isOgcUnion());
            return;
        L18:
            r13 = ji1.a.getValue();
        L20:
            RoomContext r18 = r10.getDataContext();
            if (r18 != null) goto L24;
            return;
        L24:
            if (r18.getAnchorUnionLiveDataContext().hasValue() == true) goto L26;
            r18.getAnchorUnionLiveDataContext().d(new AnchorUnionLiveDataContext());
        L26:
            com.bytedance.android.live.room.c r19 = (com.bytedance.android.live.room.c) r18.getAnchorUnionLiveDataContext().getValue();
            if (r19 == null) goto L29;
            r19.onAnchorClickUnion(((Widget) r10).context, ((Widget) r10).dataCenter);
            goto L29
        L39:
            return;
        L38:
            return;
        L37:
            return;
        }
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ UnionAnchorWidget a;

        public b(UnionAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Room r5 = (Room) r4;
            DataCenter r6 = ((Widget) this.a).dataCenter;
            if (r6 == null) goto L5;
            r6.put("data_extra_open_union_live_panel", Boolean.FALSE);
        L5:
            ILiveActionHandler r7 = k.n(ILiveActionHandler.class);
            UnionAnchorWidget r0 = this.a;
            Context r1 = ((Widget) r0).context;
            int r2 = com.bytedance.android.live.room.utils.c.a;
            if (((Widget) r0).dataCenter != null) goto L8;
            String r3 = "";
        L9:
            r7.handle(r1, r3);
            d.a("auto open union live panel when enter");
            return;
        L8:
            r3 = ji1.a.getValue();
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ UnionAnchorWidget a;

        public c(UnionAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            i1 r3 = (i1) r2;
            UnionAnchorWidget r0 = this.a;
            if (r3 != null) goto L5;
            r0.getClass();
            return;
        L5:
            View r1 = ((Widget) r0).contentView;
            if (r1 == null) goto L10;
            r1.setTranslationY(r3.a);
            return;
        }
    }

    public UnionAnchorWidget() {
        this(false);
    }

    public final int getLayoutId() {
        return 2131567548;
    }

    public final void onUnload() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public final Animator startShowAnimation() {
        if (this.d == false) goto L7;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(((Widget) this).contentView, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
        r0.start();
        return r0;
    L7:
        return super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.startShowAnimation();
    }

    public UnionAnchorWidget(boolean r1) {
        this.d = r1;
        this.a = new UnionLiveAvatarAdapter();
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L22;
        String r5 = r4.getKey();
        if (r5.hashCode() == 560852175) goto L9;
        return;
    L9:
        if (r5.equals("data_union_room_change") == false) goto L18;
        RoomContext r6 = getDataContext();
        if (r6 == null) goto L19;
        m r7 = r6.getRoom();
        if (r7 == null) goto L20;
        Room r8 = (Room) r7.getValue();
        if (r8 == null) goto L21;
        xq(r8);
        wq(r8);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void onInit(Object[] r1) {
        ImageView r2 = (ImageView) findViewById(2131391873);
        this.b = findViewById(2131391872);
        this.c = (TextView) findViewById(2131391874);
    }

    public final void onLoad(Object[] r4) {
        RecyclerView r5 = this.b;
        if (r5 == null) goto L5;
        r5.setLayoutManager(new LinearLayoutManager(((Widget) this).context, 0, false));
    L5:
        RecyclerView r6 = this.b;
        if (r6 == null) goto L8;
        r6.setAdapter(this.a);
    L8:
        RecyclerView r7 = this.b;
        Boolean r1 = null;
        if (r7 == null) goto L11;
        r7.setItemAnimator(null);
    L11:
        RoomContext r8 = getDataContext();
        if (r8 == null) goto L18;
        m r9 = r8.getRoom();
        if (r9 == null) goto L18;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L18;
        xq(r10);
        wq(r10);
    L18:
        View r11 = ((Widget) this).contentView;
        if (r11 == null) goto L21;
        r11.setOnClickListener(new a(this));
    L21:
        View r12 = ((Widget) this).contentView;
        if (r12 == null) goto L24;
        a1.o(r12, 0);
        a1.l(r12, 0);
    L24:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L27;
        r13.observe("data_union_room_change", this);
    L27:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L31;
        r1 = (Boolean) r14.get("data_extra_open_union_live_panel", Boolean.FALSE);
    L31:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L33;
        runWithRoomEntered(new b(this));
    L33:
        c r0 = new c(this);
        ((ObservableSubscribeProxy) xs2.b.a().b(i1.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r0);
    }

    public final void wq(Room r5) {
        UnionLiveInfo r6 = r5.unionLiveInfo;
        if (r6 != null) goto L5;
        return;
    L5:
        RoomPermissionContext.a r0 = RoomPermissionContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r2 = LiveRoomPermission.A;
        r0.getClass();
        boolean r3 = RoomPermissionContext.a.e(r1, r2);
        RoomContext r4 = getDataContext();
        if (r4 != null) goto L9;
        return;
    L9:
        if (z.e(((Widget) this).dataCenter, false) == true) goto L11;
        if (r3 == true) goto L11;
        return;
    L11:
        List r7 = r6.guestAnchors;
        if (r7 != null) goto L14;
        return;
    L14:
        if ((!r7.isEmpty()) != true) goto L32;
        com.bytedance.android.live.room.c r8 = (com.bytedance.android.live.room.c) r4.getAnchorUnionLiveDataContext().getValue();
        if (r8 == null) goto L22;
        l r9 = r8.getAuthorized();
        if (r9 == null) goto L22;
        if (((Boolean) r9.getValue()).booleanValue() != true) goto L22;
        return;
    L22:
        if (r4.getAnchorUnionLiveDataContext().hasValue() == true) goto L24;
        r4.getAnchorUnionLiveDataContext().d(new AnchorUnionLiveDataContext());
    L24:
        com.bytedance.android.live.room.c r10 = (com.bytedance.android.live.room.c) r4.getAnchorUnionLiveDataContext().getValue();
        if (r10 == null) goto L34;
        l r11 = r10.getAuthorized();
        if (r11 == null) goto L35;
        r11.setValue(Boolean.TRUE);
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void xq(Room r8) {
        ArrayList r0 = new ArrayList();
        User r1 = r8.getOwner();
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        String r2 = (String) ((Widget) this).dataCenter.get("data_joint_anchor_id", "");
        UnionLiveInfo r3 = r8.unionLiveInfo;
        if (r3 == null) goto L24;
        List r4 = r3.guestAnchors;
        if (r4 == null) goto L24;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L24;
        GuestAnchor r6 = (GuestAnchor) r5.next();
        if (r6 == null) goto L11;
        if (r6.isUnionStarted() != true) goto L11;
        User r7 = r6.user;
        if (r7 == null) goto L11;
        o0.a r9 = o0.a;
        String r10 = r7.getIdStr();
        r9.getClass();
        if (o0.a.a(r10, r2) == false) goto L23;
        if (r8.unionLiveInfo.fixSort == true) goto L23;
        ListProtector.add(r0, 1, r7);
    L23:
        r0.add(r7);
    L24:
        UnionLiveAvatarAdapter r11 = this.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "anchors");
        DiffUtil.calculateDiff(new UnionLiveAvatarAdapter.DiffUtilCallback(r0, r11.a)).dispatchUpdatesTo(r11);
        ((ArrayList) r11.a).clear();
        ((ArrayList) r11.a).addAll(r0);
        TextView r12 = this.c;
        if (r12 == null) goto L47;
        UnionLiveInfo r13 = r8.unionLiveInfo;
        if (r13 == null) goto L31;
        String r14 = r13.avatarDescription;
        if (r14 == null) goto L31;
    L32:
        r12.setText(r14);
        return;
    L31:
        r14 = "共创团队";
        goto L32
    }
}
