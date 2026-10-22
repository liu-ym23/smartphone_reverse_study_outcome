package com.bytedance.android.livesdk.groupliverts.widget;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.q1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.revenue.model.extension.main.c;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.z5;
import com.bytedance.android.livesdk.gift.model.v0;
import com.bytedance.android.livesdk.groupliverts.salamander.generated.GroupLiveRTSController;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveRtsService;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.message.model.t5;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.thirdrow.ThirdRowContentCount;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.salamander.anniex.q4;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tlc.d;
import vlc.l;
import zg1.f1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/groupliverts/widget/GroupLiveRtsServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/groupliverts/salamander/generated/a;", "Lvlc/l;", "Lwlc/b;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupLiveRtsServiceWidget extends MiddlewareRoomRecyclableWidget implements com.bytedance.android.livesdk.groupliverts.salamander.generated.a, l, wlc.b {
    public GroupLiveRTSController a;
    public GroupLiveRtsCard b;
    public boolean c;
    public final CompositeDisposable d;
    public double e;
    public double f;
    public String g;
    public long h;
    public boolean i;
    public final CompositeDisposable j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GroupLiveRtsServiceWidget a;

        public b(GroupLiveRtsServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Integer r11 = (Integer) r10;
            GroupLiveRTSController r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.c(r0.f, r0.g, r0.d, r0.e);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double fm() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r0 == null) goto L7;
        i r1 = r0.getThirdRowContentCount();
        if (r1 == null) goto L7;
        ThirdRowContentCount r2 = (ThirdRowContentCount) r1.getValue();
    L8:
        if (r2 == null) goto L10;
        Triple r3 = new Triple(r2.getShortTouchCount().getValue(), r2.getNormalBannerCount().getValue(), r2.getActivityBannerCount().getValue());
    L11:
        Integer r4 = (Integer) r3.component1();
        Integer r5 = (Integer) r3.component2();
        Integer r6 = (Integer) r3.component3();
        int r7 = 0;
        if (r4 == null) goto L14;
        int r8 = r4.intValue();
    L15:
        if (r5 == null) goto L17;
        int r9 = r5.intValue();
    L18:
        int r10 = r8 + r9;
        if (r6 == null) goto L21;
        r7 = r6.intValue();
    L21:
        int r11 = r10 + r7;
        if (r4 == null) goto L29;
        if (r5 == null) goto L29;
        if (r6 == null) goto L29;
        if (r11 != 0) goto L29;
        if (this.c == false) goto L29;
        float r13 = 74.0f;
    L31:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L38;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L38;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L38;
        r13 = r13 + UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(((Widget) this).context));
    L38:
        return (int) UtilityKotlinExtentionsKt.h(r13);
    L29:
        r13 = 128.0f;
        goto L31
    L17:
        r9 = 0;
        goto L18
    L14:
        r8 = 0;
        goto L15
    L10:
        r3 = new Triple(null, null, null);
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final String getUserId() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        if (r2 == null) goto L11;
        String r3 = r2.getAnchorId();
        if (r3 == null) goto L11;
        return r3;
    L11:
        return "0";
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final void ho() {
        GroupLiveRtsCard r0 = this.b;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        GroupLiveRTSController r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.h != true) goto L14;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L15;
        r2.put("data_live_bottom_right_card_show", new f1(false, 0));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double io() {
        return UtilityKotlinExtentionsKt.i(12);
    }

    public final void onUnload() {
        GroupLiveRtsCard r0 = this.b;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        IGroupLiveRtsService r1 = (IGroupLiveRtsService) k.f(IGroupLiveRtsService.class);
        if (r1 == null) goto L8;
        r1.setGroupLiveRtsWidget(null);
    L8:
        GroupLiveRTSController r2 = this.a;
        if (r2 == null) goto L11;
        r2.o = null;
        r2.b("controller_unbind", Boolean.valueOf(r2.i), Boolean.valueOf(r2.p));
    L11:
        this.a = null;
        this.d.dispose();
        this.j.dispose();
        MiddlewareRoomContext.a r3 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(r3, ((Widget) this).dataCenter, 0, 2);
        if (r4 == null) goto L16;
        j r5 = r4.getMessageManager();
        if (r5 == null) goto L16;
        r5.c(new C03011(this));
    L16:
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(r3, ((Widget) this).dataCenter, 0, 2);
        if (r6 == null) goto L22;
        j r7 = r6.getStreamMessageManager();
        if (r7 == null) goto L23;
        r7.c(new C03022(this));
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final boolean pe() {
        IGroupLiveService r0 = (IGroupLiveService) k.f(IGroupLiveService.class);
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getAnchorIdBeforeJump();
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L22;
        r1 = r2;
    L22:
        if (r1 == null) goto L25;
        return true;
    L25:
        return false;
    L15:
        if ((!Intrinsics.areEqual(r2, "0")) == false) goto L19;
        if ((!Intrinsics.areEqual(r2, this.g)) == false) goto L19;
        r5 = true;
        goto L20
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public final void wq() {
        GroupLiveRtsCard r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        GroupLiveRTSController r1 = this.a;
        if (r1 != null) goto L8;
    L10:
        CardConstraint r2 = new CardConstraint(-2, -2);
        r2.b(CardConstraint.Position.TopLeft);
        r2.a(new GroupLiveRtsServiceWidget$refreshCardConstraint$2(this));
        r0.P(r2);
        return;
    L8:
        if (r1.h != true) goto L10;
        CardConstraint r3 = new CardConstraint(-2, -2);
        r3.b(CardConstraint.Position.BottomRight);
        r3.a(GroupLiveRtsServiceWidget$refreshCardConstraint$1.INSTANCE);
        r0.P(r3);
    }

    public GroupLiveRtsServiceWidget() {
        this.d = new CompositeDisposable();
        this.g = BuildConfig.FLAVOR;
        this.i = true;
        this.j = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double getScreenHeight() {
        return RangesKt.coerceAtLeast(s1.y(), s1.w());
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double getScreenWidth() {
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double k9() {
        return getScreenHeight() - ((double) UtilityKotlinExtentionsKt.i(52));
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final long ob() {
        return e.a() - System.currentTimeMillis();
    L4:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double sh() {
        double r0 = getScreenHeight();
        InteractionWidgetsPosContext r2 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r2 == null) goto L9;
        m r3 = r2.getPublicScreenHeight();
        if (r3 == null) goto L9;
        Integer r4 = (Integer) r3.getValue();
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L11:
        return (r0 - ((double) r5)) - ((double) s1.f(34.0f));
    L9:
        r5 = UtilityKotlinExtentionsKt.i(160);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final double ul() {
        return getScreenWidth() - ((double) UtilityKotlinExtentionsKt.i(12));
    }

    public final void Rk(IStreamMessage r8) {
        if ((r8 instanceof t5) == true) goto L5;
        return;
    L5:
        if (this.i == true) goto L7;
        return;
    L7:
        if (((Boolean) z5.a.getValue()).booleanValue() == false) goto L24;
        t5 r9 = (t5) r8;
        m0 r0 = r9.getCommonData();
        long r1 = 0;
        if (r0 == null) goto L11;
        long r3 = r0.getCreateTime();
    L13:
        if (r3 >= this.h) goto L15;
        return;
    L15:
        v0 r2 = (v0) ListProtector.get(r9.getGroupContainerList(), 0);
        m0 r10 = r9.getCommonData();
        if (r10 == null) goto L18;
        r1 = r10.getCreateTime();
    L18:
        this.h = r1;
        GroupLiveRTSController r11 = this.a;
        if (r11 == null) goto L25;
        r11.a(r2);
        return;
    L25:
        return;
    L11:
        r3 = 0;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final void la(boolean r5) {
        this.c = r5;
        if (r5 == false) goto L11;
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r6 == null) goto L13;
        i r7 = r6.getThirdRowContentCount();
        if (r7 == null) goto L14;
        ThirdRowContentCount r8 = (ThirdRowContentCount) r7.getValue();
        if (r8 == null) goto L15;
        xq(r8.getShortTouchCount(), this.j);
        xq(r8.getNormalBannerCount(), this.j);
        xq(r8.getActivityBannerCount(), this.j);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L11:
        this.j.clear();
    }

    public final void onInit(Object[] r11) {
        MiddlewareRoomContext r13 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r13 == null) goto L7;
        m r14 = r13.getRoom();
        if (r14 == null) goto L7;
        Room r15 = (Room) r14.getValue();
    L8:
        String r0 = "0";
        if (r15 == null) goto L28;
        RoomOthersData r2 = r15.others;
        int r3 = 0;
        if (r2 == null) goto L15;
        IGroupLiveData r4 = r2.getGroupData();
        if (r4 == null) goto L15;
        boolean r5 = r4.isCurrentGroupLive();
    L16:
        Boolean r6 = Boolean.valueOf(r5);
        String r7 = r15.getAnchorId();
        if (r7 == null) goto L20;
        r0 = r7;
    L20:
        Long r8 = Long.valueOf(r15.getRoomId());
        Intrinsics.checkNotNullParameter(r15, "$this$groupLiveMode");
        IMainRoom r16 = r15.castToOrNull(IMainRoom.class);
        if (r16 == null) goto L27;
        c r17 = r16.getMainOthers();
        if (r17 == null) goto L27;
        IGroupLiveData r18 = r17.getGroupData();
        if (r18 == null) goto L27;
        r3 = r18.getGroupLiveMode();
    L27:
        q1 r1 = new q1(r6, r0, r8, Long.valueOf(r3));
    L29:
        boolean r19 = ((Boolean) r1.a).booleanValue();
        String r9 = (String) r1.b;
        long r10 = ((Number) r1.c).longValue();
        long r20 = ((Number) r1.d).longValue();
        this.g = r9;
        this.i = r19;
        jy0.b.d("GroupLiveRts", "params: " + r19 + ' ' + r9 + ' ' + r10 + ' ' + r20);
        if (r19 == false) goto L36;
        IGroupLiveRtsService r110 = (IGroupLiveRtsService) k.f(IGroupLiveRtsService.class);
        if (r110 == null) goto L34;
        r110.setGroupLiveRtsWidget(this);
    L34:
        this.a = new GroupLiveRTSController(this, r10, r9, r20, ((Widget) this).context);
        return;
    L36:
        return;
    L15:
        r5 = false;
        goto L16
    L28:
        r1 = new q1(Boolean.FALSE, "0", 0L, 0L);
    L7:
        r15 = null;
        goto L8
    }

    public final void onLoad(Object[] r8) {
        if (this.i == true) goto L5;
        return;
    L5:
        MiddlewareRoomContext.a r9 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(r9, ((Widget) this).dataCenter, 0, 2);
        if (r0 == null) goto L18;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L18;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L18;
        if (((Boolean) e22.a.b.getValue(null, e22.a.a[0])).booleanValue() == false) goto L18;
        jy0.b.d("GroupLiveRts", "use streamMessageManager");
        MiddlewareRoomContext r2 = MiddlewareRoomContext.a.c(r9, ((Widget) this).dataCenter, 0, 2);
        if (r2 == null) goto L23;
        j r3 = r2.getStreamMessageManager();
        if (r3 == null) goto L23;
        r3.c(new AnonymousClass1(this));
    L23:
        MiddlewareRoomContext r10 = MiddlewareRoomContext.a.c(r9, ((Widget) this).dataCenter, 0, 2);
        if (r10 == null) goto L28;
        j r11 = r10.getMessageManager();
        if (r11 == null) goto L28;
        r11.c(new AnonymousClass3(this));
    L28:
        this.d.clear();
        InteractionWidgetsPosContext r13 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r13 == null) goto L34;
        m<Integer> r14 = r13.getPublicScreenHeight();
        if (r14 == null) goto L35;
        xq(r14, this.d);
        return;
    L35:
        return;
    L34:
        return;
    L18:
        jy0.b.d("GroupLiveRts", "use MessageManager");
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(r9, ((Widget) this).dataCenter, 0, 2);
        if (r4 == null) goto L23;
        j r5 = r4.getMessageManager();
        if (r5 == null) goto L23;
        r5.c(new AnonymousClass2(this));
        goto L23
    }

    public final void onMessage(d r2) {
        if ((r2 instanceof t5) == true) goto L5;
        return;
    L5:
        if (this.i == true) goto L7;
        return;
    L7:
        if (((Boolean) z5.a.getValue()).booleanValue() == false) goto L14;
        v0 r3 = (v0) ListProtector.get(((t5) r2).getGroupContainerList(), 0);
        GroupLiveRTSController r0 = this.a;
        if (r0 == null) goto L15;
        r0.a(r3);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final void vm(double r14, double r16) {
        GroupLiveRTSController r1 = this.a;
        if (r1 == null) goto L5;
        q4<Map<String, Object>> r2 = r1.a;
    L6:
        Intrinsics.checkNotNull(r2);
        this.b = new GroupLiveRtsCard(r2, ((Widget) this).dataCenter);
        GroupLiveRTSController r4 = this.a;
        if (r4 == null) goto L9;
        r4.d = r14;
        r4.e = r16;
        r4.c(r4.f, r4.g, r14, r16);
    L9:
        wq();
        GroupLiveRtsCard r3 = this.b;
        if (r3 == null) goto L13;
        r3.show();
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void xq(m<Integer> r2, CompositeDisposable r3) {
        r3.add(r2.a().subscribe(new b(this)));
    }

    @Override // com.bytedance.android.livesdk.groupliverts.salamander.generated.b
    public final void pb(double r1, double r3, double r5) {
        this.e = r1;
        this.f = r3;
        GroupLiveRTSController r2 = this.a;
        if (r2 != null) goto L5;
    L9:
        wq();
        return;
    L5:
        if (r2.h != true) goto L9;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L9;
        r4.put("data_live_bottom_right_card_show", new f1(true, (int) r5));
        goto L9
    }
}
