package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.discovery.adapter.AnchorTogetherAvatarAdapter;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.iz;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/discovery/LiveAnchorTogetherWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorTogetherWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int d = 0;
    public final AnchorTogetherAvatarAdapter a;
    public RecyclerView b;
    public TextView c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveAnchorTogetherWidget a;

        public b(LiveAnchorTogetherWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            LiveAnchorTogetherWidget r7 = this.a;
            int r0 = LiveAnchorTogetherWidget.d;
            IRoomContextService r1 = r7.getDataService();
            if (r1 == null) goto L44;
            com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, ((Widget) r7).dataCenter, 0, 2);
            if (r2 == null) goto L45;
            com.bytedance.live.datacontext.m r3 = r2.getRoom();
            if (r3 == null) goto L46;
            IRoom r4 = (IRoom) r3.getValue();
            if (r4 == null) goto L47;
            IRoomOthersData r5 = r4.getRoomOthers();
            if (r5 == null) goto L48;
            IAnchorTogetherLive r8 = r5.getAnchorTogetherLive();
            if (r8 != null) goto L15;
            return;
        L15:
            if (((Boolean) iz.a.getValue()).booleanValue() == false) goto L39;
            Uri r9 = UriProtector.parse(r8.getSchemaUrl());
            IGroupLiveService r10 = jc1.k.f(IGroupLiveService.class);
            if (r10 == null) goto L36;
            String r12 = r10.getAnchorIdBeforeJump();
            if (r12 == null) goto L36;
            boolean r13 = false;
            if (r12.length() <= 0) goto L23;
            boolean r14 = true;
        L24:
            if (r14 == true) goto L26;
        L28:
            if (r13 == true) goto L31;
            r12 = null;
        L31:
            if (r12 == null) goto L36;
            Uri r15 = r9.buildUpon().appendQueryParameter("enter_by_uid", r12).build();
            if (r15 == null) goto L36;
            r9 = r15;
            goto L36
        L26:
            if ((!Intrinsics.areEqual(r12, DataType.FALSE)) == false) goto L28;
            r13 = true;
            goto L28
        L23:
            r14 = false;
        L36:
            ILiveActionHandler r16 = jc1.k.f(ILiveActionHandler.class);
            if (r16 == null) goto L42;
            r16.handle(((Widget) r7).context, r9);
        L42:
            LiveAnchorTogetherWidget.wq("click");
            return;
        L39:
            ILiveActionHandler r17 = jc1.k.f(ILiveActionHandler.class);
            if (r17 == null) goto L42;
            r17.handle(((Widget) r7).context, r8.getSchemaUrl());
            goto L42
        L48:
            return;
        L47:
            return;
        L46:
            return;
        L45:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveAnchorTogetherWidget a;

        public c(LiveAnchorTogetherWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            i1 r4 = (i1) r3;
            LiveAnchorTogetherWidget r0 = this.a;
            int r1 = LiveAnchorTogetherWidget.d;
            if (r4 != null) goto L5;
            r0.getClass();
            return;
        L5:
            View r2 = ((Widget) r0).contentView;
            if (r2 == null) goto L10;
            r2.setTranslationY(r4.a);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567521;
    }

    public final void onUnload() {
    }

    public final Animator startShowAnimation() {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(((Widget) this).contentView, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
        r0.start();
        return r0;
    }

    public LiveAnchorTogetherWidget() {
        this.a = new AnchorTogetherAvatarAdapter();
    }

    public static void wq(String r4) {
        HashMap r0 = new HashMap();
        r0.put("action_type", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_group_live_member_list_entrance", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L25;
        String r7 = r6.getKey();
        if (r7.hashCode() == 869073220) goto L9;
        return;
    L9:
        if (r7.equals("data_anchor_together_room_change") == false) goto L20;
        IRoomContextService r8 = getDataService();
        if (r8 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.o r9 = IRoomContextService.a.a(r8, ((Widget) this).dataCenter, 0, 2);
        if (r9 == null) goto L22;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L23;
        IRoom r12 = (IRoom) r10.getValue();
        if (r12 == null) goto L24;
        xq(r12);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onInit(Object[] r1) {
        ImageView r2 = (ImageView) findViewById(2131391873);
        this.b = findViewById(2131391872);
        this.c = (TextView) findViewById(2131391874);
    }

    public final void onLoad(Object[] r7) {
        RecyclerView r8 = this.b;
        if (r8 == null) goto L5;
        r8.setLayoutManager(new LinearLayoutManager(((Widget) this).context, 0, false));
    L5:
        RecyclerView r9 = this.b;
        if (r9 == null) goto L8;
        r9.setAdapter(this.a);
    L8:
        RecyclerView r10 = this.b;
        List r1 = null;
        if (r10 == null) goto L11;
        r10.setItemAnimator(null);
    L11:
        IRoomContextService r12 = getDataService();
        if (r12 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r12, ((Widget) this).dataCenter, 0, 2);
        if (r13 == null) goto L20;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L20;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L20;
        xq(r15);
    L20:
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r16 == null) goto L38;
        com.bytedance.live.datacontext.m r17 = r16.getRoom();
        if (r17 == null) goto L38;
        Room r18 = (Room) r17.getValue();
        if (r18 == null) goto L38;
        StringBuilder r2 = new StringBuilder("onLoad cloudCollaborateData:");
        r2.append(r18.hashCode());
        r2.append(", ");
        RoomOthersData r4 = r18.others;
        if (r4 == null) goto L31;
        IAnchorTogetherLive r5 = r4.getAnchorTogetherLive();
        if (r5 == null) goto L31;
        Integer r6 = Integer.valueOf(r5.hashCode());
    L32:
        r2.append(r6);
        r2.append(", ");
        RoomOthersData r19 = r18.others;
        if (r19 == null) goto L37;
        IAnchorTogetherLive r20 = r19.getAnchorTogetherLive();
        if (r20 == null) goto L37;
        r1 = r20.getTogetherAnchor();
    L37:
        r2.append(r1);
        ALogger.d("LiveAnchorTogetherWidget", r2.toString());
    L31:
        r6 = null;
    L38:
        View r22 = ((Widget) this).contentView;
        if (r22 == null) goto L41;
        r22.setOnClickListener(new b(this));
    L41:
        View r23 = ((Widget) this).contentView;
        if (r23 == null) goto L44;
        a1.o(r23, 0);
        a1.l(r23, 0);
    L44:
        DataCenter r24 = ((Widget) this).dataCenter;
        if (r24 == null) goto L47;
        r24.observe("data_anchor_together_room_change", this);
    L47:
        wq("show");
        ((ObservableSubscribeProxy) xs2.b.a().b(i1.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new c(this));
    }

    public final void xq(IRoom r5) {
        ArrayList r0 = new ArrayList();
        IRoomOthersData r1 = r5.getRoomOthers();
        if (r1 == null) goto L13;
        IAnchorTogetherLive r2 = r1.getAnchorTogetherLive();
        if (r2 == null) goto L13;
        List r3 = r2.getTogetherAnchor();
        if (r3 == null) goto L13;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        r0.add((IBaseUser) r4.next());
    L13:
        if (r0.size() != 1) goto L17;
        IBaseUser r6 = r5.getOwner();
        if (r6 == null) goto L17;
        ListProtector.add(r0, 0, r6);
    L17:
        AnchorTogetherAvatarAdapter r7 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "anchors");
        DiffUtil.calculateDiff(new AnchorTogetherAvatarAdapter.DiffUtilCallback(r0, r7.a)).dispatchUpdatesTo(r7);
        ((ArrayList) r7.a).clear();
        ((ArrayList) r7.a).addAll(r0);
        TextView r8 = this.c;
        if (r8 == null) goto L33;
        IRoomOthersData r9 = r5.getRoomOthers();
        if (r9 == null) goto L26;
        IAnchorTogetherLive r10 = r9.getAnchorTogetherLive();
        if (r10 == null) goto L26;
        String r12 = r10.getAvatarTitle();
        if (r12 == null) goto L26;
    L30:
        r8.setText(r12);
        return;
    L26:
        Context r13 = ((Widget) this).context;
        if (r13 == null) goto L29;
        r12 = r13.getString(2131914872);
        goto L30
    L29:
        r12 = null;
        goto L30
    }
}
