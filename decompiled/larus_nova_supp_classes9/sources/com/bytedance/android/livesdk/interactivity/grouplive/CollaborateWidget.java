package com.bytedance.android.livesdk.interactivity.grouplive;

import am2.x;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.data.c;
import com.bytedance.android.live.base.model.message.i0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.jz;
import com.bytedance.android.livesdk.config.kz;
import com.bytedance.android.livesdk.config.yh0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/grouplive/CollaborateWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollaborateWidget extends RoomRecyclableWidget implements l {
    public TextView a;
    public TextView b;
    public Disposable c;
    public Disposable d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ICloudCollaborateData a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Room c;
        public final /* synthetic */ CollaborateWidget d;

        public b(ICloudCollaborateData r1, Map r2, Room r3, CollaborateWidget r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            if (r14 == null) goto L11;
            if (r14.longValue() != 0) goto L11;
            ViewGroup r2 = ((Widget) this.d).containerView;
            if (r2 == null) goto L11;
            UtilityKotlinExtentionsKt.z(r2, true);
        L11:
            if (((this.a.getJumpCollaborateRoomTime() - r14.longValue()) - 1) <= 0) goto L15;
            TextView r0 = this.d.a;
            if (r0 == null) goto L17;
            r0.setText(String.valueOf((this.a.getJumpCollaborateRoomTime() - r14.longValue()) - 1));
            return;
        L17:
            return;
        L15:
            CollaborateWidget.xq(this.d, this.a.getCollaborateRoomId(), this.b, this.c.getOwnerUserIdString(), Long.valueOf(this.c.id), true, EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_ENTER_ROOM, false, 64);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565315;
    }

    public final void onUnload() {
        f.d(this);
        o r0 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r0 == null) goto L9;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        d r2 = (d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(this);
    L9:
        Disposable r3 = this.c;
        if (r3 != null) goto L12;
    L16:
        this.c = null;
        Disposable r4 = this.d;
        if (r4 != null) goto L19;
    L23:
        this.d = null;
        if (this.e == true) goto L28;
        IGroupLiveService r5 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r5 == null) goto L29;
        r5.setAnchorIdBeforeJump(BuildConfig.FLAVOR);
        r5.setRoomIdBeforeJump(0);
        r5.setRequestIdBeforeJump(BuildConfig.FLAVOR);
    L29:
        ViewGroup r6 = ((Widget) this).containerView;
        if (r6 == null) goto L33;
        UtilityKotlinExtentionsKt.z(r6, false);
        return;
    L33:
        return;
    L28:
        this.e = false;
        goto L29
    L19:
        if (r4.isDisposed() == true) goto L23;
        Disposable r7 = this.d;
        if (r7 == null) goto L23;
        r7.dispose();
        goto L23
    L12:
        if (r3.isDisposed() == true) goto L16;
        Disposable r8 = this.c;
        if (r8 == null) goto L16;
        r8.dispose();
        goto L16
    }

    public CollaborateWidget() {
    }

    public static boolean wq(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        if ((!Intrinsics.areEqual(r3, "0")) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void onInit(Object[] r3) {
        this.a = (TextView) findViewById(2131376751);
        this.b = (TextView) findViewById(2131376752);
        IHostService r4 = TTLiveSDK.hostService();
        if (r4 == null) goto L12;
        IHostLiveOpenPlatform r5 = r4.hostOpenPlatform();
        if (r5 == null) goto L13;
        Typeface r6 = r5.getDuxFontSync(((Widget) this).context);
        if (r6 == null) goto L14;
        TextView r0 = this.a;
        if (r0 == null) goto L15;
        r0.setTypeface(r6, 2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void onLoad(Object[] r10) {
        if (((Boolean) yh0.a.getValue()).booleanValue() == false) goto L14;
        if (z.e(((Widget) this).dataCenter, false) == true) goto L14;
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L14;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L14;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L14;
        a1.o(((Widget) this).containerView, UtilityKotlinExtentionsKt.i(UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(((Widget) this).context)) + 138));
    L14:
        if (this.f == false) goto L18;
        this.f = false;
        IGroupLiveService r11 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r11 == null) goto L18;
        r11.setAnchorIdBeforeJump(BuildConfig.FLAVOR);
        r11.setRoomIdBeforeJump(0);
        r11.setRequestIdBeforeJump(BuildConfig.FLAVOR);
    L18:
        f.c(this);
        ViewGroup r13 = ((Widget) this).containerView;
        if (r13 == null) goto L21;
        UtilityKotlinExtentionsKt.z(r13, false);
    L21:
        StringBuilder r14 = new StringBuilder("onLoad anchorIdBeforeJump:");
        IGroupLiveService r3 = (IGroupLiveService) k.f(IGroupLiveService.class);
        ICloudCollaborateData r4 = null;
        if (r3 == null) goto L24;
        String r5 = r3.getAnchorIdBeforeJump();
    L25:
        r14.append(r5);
        ALogger.d("CollaborateWidget", r14.toString());
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r15 == null) goto L54;
        d r6 = (d) r15.getMessageManager().getValue();
        if (r6 == null) goto L30;
        r6.addMessageListener("WebcastCloudCollaborateMemberMessage", this);
    L30:
        Room r16 = (Room) r15.getRoom().getValue();
        StringBuilder r7 = new StringBuilder("onLoad cloudCollaborateData:, ");
        RoomOthersData r8 = r16.others;
        if (r8 == null) goto L35;
        ICloudCollaborateData r9 = r8.getCloudCollaborateData();
        if (r9 == null) goto L35;
        Long r17 = Long.valueOf(r9.getCollaborateRoomId());
    L36:
        r7.append(r17);
        ALogger.d("CollaborateWidget", r7.toString());
        RoomOthersData r18 = r16.others;
        if (r18 == null) goto L55;
        ICloudCollaborateData r19 = r18.getCloudCollaborateData();
        if (r19 != null) goto L41;
        return;
    L41:
        if (r19.getCollaborateRoomId() != 0) goto L43;
    L45:
        boolean r1 = false;
    L46:
        if (r1 == false) goto L48;
        r4 = r19;
    L48:
        if (r4 == null) goto L57;
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_grouped_lived", "1")});
        TextView r2 = this.b;
        if (r2 == null) goto L52;
        r2.setText(s1.B(2131918179));
    L52:
        this.c = Observable.interval(1, TimeUnit.SECONDS).take(r4.getJumpCollaborateRoomTime()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(r4, r0, r16, this));
        return;
    L57:
        return;
    L43:
        if (r19.getCollaborateRoomId() == r16.id) goto L45;
        r1 = true;
        goto L46
    L55:
        return;
    L35:
        r17 = null;
        goto L36
    L54:
        return;
    L24:
        r5 = null;
        goto L25
    }

    public final void onMessage(tlc.d r20) {
        if ((r20 instanceof i0) == false) goto L201;
        c r0 = ((i0) r20).getCollaborateInfo();
        if (r0 == null) goto L202;
        List r1 = r0.a();
        if (r1 != null) goto L9;
        return;
    L9:
        if ((!r1.isEmpty()) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L204;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = null;
        IGroupLiveService r4 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r4 == null) goto L24;
        String r5 = r4.getAnchorIdBeforeJump();
        if (r5 == null) goto L24;
        if (wq(r5) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L24;
    L37:
        boolean r7 = wq(r5);
        o r8 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r8 == null) goto L205;
        m r9 = r8.getRoom();
        if (r9 == null) goto L206;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L207;
        long r11 = r10.getId();
        Iterator r3 = r1.iterator();
        com.bytedance.android.live.base.model.data.d r13 = null;
        com.bytedance.android.live.base.model.data.d r14 = null;
    L45:
        if (r3.hasNext() == false) goto L63;
        com.bytedance.android.live.base.model.data.d r15 = (com.bytedance.android.live.base.model.data.d) r3.next();
        if (r15.d() != r11) goto L50;
        r13 = r15;
    L50:
        if (r15.c() == 1) goto L51;
        if (r7 == false) goto L45;
        if (r15.c() != 2) goto L45;
        IBaseUser r16 = r15.f();
        if (r16 == null) goto L58;
        String r17 = r16.getIdString();
    L60:
        if (Intrinsics.areEqual(r17, r5) == false) goto L45;
        r2.element = r15;
        goto L45
    L58:
        r17 = null;
        goto L60
    L51:
        r14 = r15;
        goto L45
    L63:
        if (r14 != null) goto L83;
        StringBuilder r6 = new StringBuilder("Dispose roomLeaveDisposable Group Room Closed，Join Dispose:");
        Disposable r18 = this.c;
        if (r18 == null) goto L67;
        Boolean r19 = Boolean.valueOf(r18.isDisposed());
    L68:
        r6.append(r19);
        r6.append(", Leave Dispose:");
        Disposable r21 = this.d;
        if (r21 == null) goto L71;
        Boolean r23 = Boolean.valueOf(r21.isDisposed());
    L72:
        r6.append(r23);
        ALogger.d("CollaborateWidget", r6.toString());
        Disposable r24 = this.c;
        if (r24 != null) goto L75;
        return;
    L75:
        if (r24.isDisposed() == true) goto L209;
        ViewGroup r25 = ((Widget) this).containerView;
        if (r25 == null) goto L79;
        UtilityKotlinExtentionsKt.z(r25, false);
    L79:
        Disposable r26 = this.c;
        if (r26 == null) goto L82;
        r26.dispose();
    L82:
        this.c = null;
        return;
    L209:
        return;
    L71:
        r23 = null;
        goto L72
    L67:
        r19 = null;
        goto L68
    L83:
        StringBuilder r27 = new StringBuilder("find collaborateGroupRoom:");
        r27.append(r14);
        r27.append("，needFindAnchorRoom:");
        r27.append(r7);
        r27.append(", collaborateAnchorRoom:");
        r27.append((com.bytedance.android.live.base.model.data.d) r2.element);
        r27.append(", Join Dispose:");
        Disposable r28 = this.c;
        if (r28 == null) goto L86;
        Boolean r29 = Boolean.valueOf(r28.isDisposed());
    L87:
        r27.append(r29);
        r27.append(", Leave Dispose:");
        Disposable r30 = this.d;
        if (r30 == null) goto L90;
        Boolean r31 = Boolean.valueOf(r30.isDisposed());
    L91:
        r27.append(r31);
        ALogger.d("CollaborateWidget", r27.toString());
        if (r13 == null) goto L211;
        StringBuilder r33 = new StringBuilder("currentRoomId:");
        r33.append(r13.d());
        r33.append("， collaborateAnchorRoom:");
        com.bytedance.android.live.base.model.data.d r34 = (com.bytedance.android.live.base.model.data.d) r2.element;
        if (r34 == null) goto L96;
        Integer r35 = Integer.valueOf(r34.e());
    L97:
        r33.append(r35);
        ALogger.d("CollaborateWidget", r33.toString());
        if (r14.d() != r13.d()) goto L147;
        com.bytedance.android.live.base.model.data.d r36 = (com.bytedance.android.live.base.model.data.d) r2.element;
        if (r36 != null) goto L102;
    L127:
        StringBuilder r37 = new StringBuilder("Dispose roomLeaveDisposable If Need，Join Dispose:");
        Disposable r38 = this.c;
        if (r38 == null) goto L130;
        Boolean r39 = Boolean.valueOf(r38.isDisposed());
    L131:
        r37.append(r39);
        r37.append(", Leave Dispose:");
        Disposable r40 = this.d;
        if (r40 == null) goto L134;
        Boolean r41 = Boolean.valueOf(r40.isDisposed());
    L135:
        r37.append(r41);
        ALogger.d("CollaborateWidget", r37.toString());
        Disposable r43 = this.d;
        if (r43 != null) goto L138;
        return;
    L138:
        if (r43.isDisposed() == true) goto L214;
        ViewGroup r44 = ((Widget) this).containerView;
        if (r44 == null) goto L142;
        UtilityKotlinExtentionsKt.z(r44, false);
    L142:
        Disposable r45 = this.d;
        if (r45 == null) goto L145;
        r45.dispose();
    L145:
        this.d = null;
        return;
    L214:
        return;
    L134:
        r41 = null;
        goto L135
    L130:
        r39 = null;
        goto L131
    L102:
        if (r36.e() == 2) goto L104;
    L106:
        boolean r46 = false;
    L107:
        if (r46 == true) goto L110;
        r36 = null;
    L110:
        if (r36 == null) goto L127;
        Disposable r47 = this.d;
        if (r47 != null) goto L114;
    L116:
        ALogger.d("CollaborateWidget", "jumpToRoom targetRoom:" + r36);
        if (r36.a() <= r36.b()) goto L119;
        Random.Default r48 = Random.Default;
        long r49 = r36.b();
        long r110 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        long r50 = r48.nextLong(r49 * r110, r110 * r36.a());
    L120:
        Map r51 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_grouped_lived", "0")});
        Ref.LongRef r53 = new Ref.LongRef();
        long r54 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        r53.element = r50 / r54;
        ViewGroup r55 = ((Widget) this).containerView;
        if (r55 == null) goto L123;
        UtilityKotlinExtentionsKt.z(r55, true);
    L123:
        TextView r56 = this.b;
        if (r56 == null) goto L126;
        r56.setText(s1.B(2131915226));
    L126:
        this.d = Observable.interval(r50 % r54, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new z72.a(r53, r36, r51, this));
        return;
    L119:
        r50 = r36.a() * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        goto L120
    L114:
        if (r47.isDisposed() == true) goto L116;
        return;
    L104:
        if (r36.d() <= 0) goto L106;
        r46 = true;
        goto L107
    L147:
        if (r14.d() > 0) goto L149;
    L151:
        boolean r57 = false;
    L152:
        if (r57 == true) goto L155;
        r14 = null;
    L155:
        if (r14 == null) goto L169;
        Disposable r58 = this.c;
        if (r58 != null) goto L159;
    L161:
        ALogger.d("CollaborateWidget", "jumpToRoom targetRoom:" + r14);
        if (r14.a() <= r14.b()) goto L164;
        Random.Default r59 = Random.Default;
        long r60 = r14.b();
        long r111 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        long r61 = r59.nextLong(r60 * r111, r111 * r14.a());
    L165:
        Map r63 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_grouped_lived", "1")});
        Ref.LongRef r64 = new Ref.LongRef();
        long r65 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        r64.element = r61 / r65;
        TextView r66 = this.b;
        if (r66 == null) goto L168;
        r66.setText(s1.B(2131918179));
    L168:
        this.c = Observable.interval(r61 % r65, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new z72.b(r64, r14, r63, r13, this));
        return;
    L164:
        r61 = r14.a() * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        goto L165
    L159:
        if (r58.isDisposed() == true) goto L161;
        return;
    L169:
        StringBuilder r67 = new StringBuilder("Dispose roomJoinDisposable If Need，Join Dispose:");
        Disposable r68 = this.c;
        if (r68 == null) goto L172;
        Boolean r69 = Boolean.valueOf(r68.isDisposed());
    L173:
        r67.append(r69);
        r67.append(", Leave Dispose:");
        Disposable r70 = this.d;
        if (r70 == null) goto L176;
        Boolean r71 = Boolean.valueOf(r70.isDisposed());
    L177:
        r67.append(r71);
        ALogger.d("CollaborateWidget", r67.toString());
        Disposable r73 = this.c;
        if (r73 != null) goto L180;
        return;
    L180:
        if (r73.isDisposed() == true) goto L218;
        ViewGroup r74 = ((Widget) this).containerView;
        if (r74 == null) goto L184;
        UtilityKotlinExtentionsKt.z(r74, false);
    L184:
        Disposable r75 = this.c;
        if (r75 == null) goto L187;
        r75.dispose();
    L187:
        this.c = null;
        return;
    L218:
        return;
    L176:
        r71 = null;
        goto L177
    L172:
        r69 = null;
        goto L173
    L149:
        if (r13.e() != 1) goto L151;
        r57 = true;
        goto L152
    L96:
        r35 = null;
        goto L97
    L211:
        return;
    L90:
        r31 = null;
        goto L91
    L86:
        r29 = null;
        goto L87
    L207:
        return;
    L206:
        return;
    L205:
        return;
    L24:
        if (((Boolean) kz.a.getValue()).booleanValue() == false) goto L36;
        o r76 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r76 == null) goto L36;
        m r77 = r76.getRoom();
        if (r77 == null) goto L36;
        IRoom r78 = (IRoom) r77.getValue();
        if (r78 == null) goto L36;
        IRoomOthersData r79 = r78.getRoomOthers();
        if (r79 == null) goto L36;
        IChangeRoomInfo r80 = r79.getChangeRoomInfo();
        if (r80 == null) goto L36;
        r5 = String.valueOf(r80.getBeforeAnchorId());
    L36:
        r5 = null;
        goto L37
    L204:
        return;
    L202:
        return;
    }

    public static void xq(CollaborateWidget r16, long r17, Map r19, String r20, Long r21, boolean r23, EnterRoomRedirect r24, boolean r25, int r26) {
        Long r4 = null;
        if ((r26 & 4) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r26 & 8) != 0) goto L11;
        r4 = r21;
    L11:
        if ((r26 & 16) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r26 & 64) == 0) goto L17;
        boolean r7 = false;
    L18:
        r16.getClass();
        long r8 = 0;
        if (r17 == 0) goto L58;
        com.bytedance.android.livesdk.log.filter.o r10 = u.l().c(x.class);
        boolean r11 = r10.getMap().containsKey("enter_from_merge");
        String r13 = BuildConfig.FLAVOR;
        if (r11 == false) goto L24;
        String r14 = (String) r10.getMap().get("enter_from_merge");
    L26:
        if (r10.getMap().containsKey("enter_method") == false) goto L28;
        String r15 = (String) r10.getMap().get("enter_method");
    L29:
        Bundle r18 = new Bundle();
        r18.putString("enter_from_merge", r14);
        r18.putString("enter_method", r15);
        r18.putInt("enter_room_redirect_form", r24.getValue());
        if (r5 == true) goto L32;
    L34:
        JumpToOtherRoomEvent r6 = new JumpToOtherRoomEvent(r17, "live_detail", r18);
        r6.source = "jump_source_cloud_collaborate";
        r6.jumpSource = "jump_source_cloud_collaborate";
        r6.isBackPreRoom = false;
        j0.l().sendLog("livesdk_live_show", r19, new Object[]{am2.u.class, PadLoggerData.class});
        IGroupLiveService r1 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r1 != null) goto L37;
    L56:
        r16.e = true;
        xs2.b.a().post(r6);
        return;
    L37:
        if (wq(r3) == false) goto L55;
        if (r3 != null) goto L40;
        r3 = BuildConfig.FLAVOR;
    L40:
        r1.setAnchorIdBeforeJump(r3);
        if (r4 == null) goto L43;
        r8 = r4.longValue();
    L43:
        r1.setRoomIdBeforeJump(r8);
        com.bytedance.android.livesdk.log.filter.o r2 = u.l().c(Room.class);
        if (r2 == null) goto L51;
        Map r9 = r2.getMap();
        if (r9 == null) goto L51;
        String r27 = (String) r9.get("request_id");
        if (r27 == null) goto L51;
        r13 = r27;
    L51:
        r1.setRequestIdBeforeJump(r13);
        if (r7 == false) goto L56;
        if (r4 == null) goto L56;
        k.n(IMiddlewareRoomService.class).roomCacheManager().d(r4.longValue());
        goto L56
    L55:
        r16.f = true;
        goto L56
    L32:
        if (((Boolean) jz.a.getValue()).booleanValue() == false) goto L34;
        r18.putBoolean("finish_current_activity", true);
        goto L34
    L28:
        r15 = BuildConfig.FLAVOR;
        goto L29
    L24:
        r14 = BuildConfig.FLAVOR;
        goto L26
    L58:
        return;
    L17:
        r7 = r25;
        goto L18
    L13:
        r5 = r23;
        goto L15
    L5:
        r3 = r20;
        goto L7
    }
}
