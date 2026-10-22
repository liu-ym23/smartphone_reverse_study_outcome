package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.game.GameAbsInteractionDelegate;
import com.bytedance.android.livesdk.chatroom.game.GameAnchorInteractionDelegate;
import com.bytedance.android.livesdk.chatroom.model.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.v4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.GameExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/GameDelegateWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/o;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDelegateWidget extends MiddlewareRoomWidget implements Observer<KVData>, o, vlc.l {
    public GameAbsInteractionDelegate a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c c;
    public final CompositeDisposable d;

    public static final class a implements Runnable {
        public final /* synthetic */ GameDelegateWidget a;
        public final /* synthetic */ Fragment b;

        public a(GameDelegateWidget r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            IInteractGameService r0 = jc1.k.f(IInteractGameService.class);
            int r1 = 0;
            if (r0 == null) goto L5;
            r0.initGameContext(this.b, false);
        L5:
            Room r2 = com.bytedance.android.live.core.utils.z.o(((Widget) this.a).dataCenter);
            Integer r3 = null;
            if (r2 == null) goto L8;
            GameExtraInfo r4 = r2.gameExtraInfo;
        L9:
            if (r4 == null) goto L18;
            GameExtraInfo r5 = r2.gameExtraInfo;
            if (r5 == null) goto L13;
            Long r6 = Long.valueOf(r5.getGameId());
        L14:
            long r7 = r6.longValue();
            GameExtraInfo r8 = r2.gameExtraInfo;
            if (r8 == null) goto L17;
            r3 = Integer.valueOf(r8.getGameKind());
        L17:
            r1 = r3.intValue();
        L19:
            int r9 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;
            boolean r10 = com.bytedance.android.live.broadcastgame.api.interactgame.k.a(r7, r1);
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r11 = AudienceGameContext.a.a();
            if (r11 == null) goto L25;
            com.bytedance.live.datacontext.m r12 = r11.isPlayingGame();
            if (r12 == null) goto L26;
            r12.setValue(Boolean.valueOf(r10));
            return;
        L26:
            return;
        L25:
            return;
        L13:
            r6 = null;
            goto L14
        L18:
            r7 = 0;
            goto L19
        L8:
            r4 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public GameDelegateWidget() {
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.c = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
    L7:
        if (com.bytedance.android.livesdk.chatroom.game.e.a(r1, getMiddlewareRoomContext()) == false) goto L33;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.c;
        if (r2 == null) goto L29;
        DataContext r3 = this.dataContext;
        if ((r3 instanceof RoomContext) == true) goto L14;
        r3 = null;
    L14:
        RoomContext r4 = (RoomContext) r3;
        if (r4 == null) goto L29;
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L29;
        j r6 = new j(this);
        if (r2.dg() == false) goto L24;
        GameAnchorInteractionDelegate r7 = new GameAnchorInteractionDelegate(r4, r5, r6);
    L30:
        this.a = r7;
        if (r7 == null) goto L33;
        ((GameAbsInteractionDelegate) r7).c = this.b;
        goto L33
    L24:
        if (r2.V9() == false) goto L27;
        r7 = new com.bytedance.android.livesdk.chatroom.game.d(r4, r5, r6);
        goto L30
    L27:
        if (r2.o5() == false) goto L29;
        r7 = new com.bytedance.android.livesdk.chatroom.game.c(r4, r5, r6);
    L29:
        r7 = null;
    L33:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.c;
        if (r8 == null) goto L36;
        Fragment r9 = r8.getFragment();
    L38:
        if (r9 != null) goto L40;
    L49:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.c;
        if (r10 != null) goto L52;
    L67:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L70;
        r11.observeForever("cmd_widget_loaded", this);
    L70:
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L73;
        r12.observe("cmd_video_orientation_changed", this, true);
    L73:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r13 = this.b;
        if (r13 == null) goto L80;
        PropertyOwner r14 = r13.getLoadState();
        if (r14 == null) goto L80;
        Disposable r15 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r14, new AnonymousClass2(this));
        if (r15 == null) goto L80;
        RxUtilKt.c(r15, this.d);
    L80:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L85;
        vlc.d r17 = (vlc.d) r16.get("data_message_manager", null);
        if (r17 == null) goto L85;
        r17.addMessageListener(MessageType.GAME_CP_USER_DOWNLOAD_MESSAGE.getIntType(), this);
    L85:
        h70.b r18 = getComponentContext();
        if (r18 == null) goto L90;
        IAbilityCenter r19 = r18.a();
        if (r19 == null) goto L90;
        r19.registerAbility(o.class, this);
    L90:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r20 = this.c;
        if (r20 != null) goto L93;
    L95:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r21 = this.b;
        if (r21 == null) goto L103;
        PropertyOwner r22 = r21.getLoadState();
        if (r22 == null) goto L104;
        Disposable r23 = com.bytedance.android.livesdk.chatroom.ui.framework.b.d(r22, new GameDelegateWidget$handleAIPredictorService$1(this));
        if (r23 == null) goto L105;
        RxUtilKt.c(r23, this.d);
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L93:
        if (r20.dg() != true) goto L95;
        return;
    L52:
        if (r10.dg() != true) goto L67;
        IHostGameCP r24 = jc1.k.f(IHostGameCP.class);
        if (r24 == null) goto L60;
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L58;
        Room r26 = com.bytedance.android.live.core.utils.z.o(r25);
    L59:
        r24.onAnchorRoomContextCreated(r26);
        goto L60
    L58:
        r26 = null;
    L60:
        IInteractGameService r27 = jc1.k.f(IInteractGameService.class);
        if (r27 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r28 = ho1.a.i(getComponentContext());
        if (r28 == null) goto L65;
        ViewGroup r29 = r28.M7();
    L66:
        Intrinsics.checkNotNull(r29);
        r27.setAnchorInteractPlayContainer(r29);
        goto L67
    L65:
        r29 = null;
        goto L66
    L40:
        if (kjc.a.a() != 2) goto L42;
        boolean r30 = true;
    L43:
        if (r30 == true) goto L49;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r31 = this.c;
        if (r31 == null) goto L49;
        if (r31.R7() != true) goto L49;
        int r32 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.d, "GameDelegateWidget#initGameContext", new a(this, r9));
        goto L49
    L42:
        r30 = false;
        goto L43
    L36:
        r9 = null;
        goto L38
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.d.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L10;
        vlc.d r2 = (vlc.d) r1.get("data_message_manager", null);
        if (r2 == null) goto L10;
        r2.removeMessageListener(this);
    L10:
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L15;
        IAbilityCenter r4 = r3.a();
        if (r4 == null) goto L15;
        r4.unregisterAbility(o.class);
    L15:
        GameAbsInteractionDelegate r5 = this.a;
        if (r5 == null) goto L18;
        r5.c();
    L18:
        this.a = null;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r6 = this.c;
        if (r6 != null) goto L21;
    L31:
        this.b = null;
        this.c = null;
        return;
    L21:
        if (r6.dg() == true) goto L31;
        IHostGameCP r7 = jc1.k.f(IHostGameCP.class);
        if (r7 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.c;
        if (r8 == null) goto L29;
        Room r9 = r8.getRoom();
        if (r9 == null) goto L29;
        long r10 = r9.getRoomId();
    L30:
        r7.onUnloadAiPredictor(r10);
    L29:
        r10 = 0;
        goto L30
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L54;
        Room r1 = null;
        if (r7 == null) goto L10;
        String r2 = r7.getKey();
    L11:
        if (r2 == null) goto L55;
        int r3 = r2.hashCode();
        if (r3 == (-1836833765)) goto L22;
        if (r3 == 1631824572) goto L19;
        return;
    L19:
        if (r2.equals("cmd_video_orientation_changed") == false) goto L48;
        k3 r8 = (k3) r7.getData();
        return;
    L48:
        return;
    L22:
        if (r2.equals("cmd_widget_loaded") == false) goto L50;
        y3 r9 = (y3) r7.getData();
        if (r9 != null) goto L27;
        return;
    L27:
        if (r9.a == true) goto L58;
        GameAbsInteractionDelegate r10 = this.a;
        if (r10 == null) goto L32;
        r10.a();
    L32:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r11 = this.c;
        if (r11 != null) goto L35;
        return;
    L35:
        if (r11.R7() == true) goto L37;
        return;
    L37:
        if (((Boolean) ((Widget) this).dataCenter.get("data_current_is_preview", Boolean.FALSE)).booleanValue() == false) goto L39;
        String r12 = ILiveRoomControllerProvider.ProviderSource.PREVIEW.name();
        int r4 = ((Number) ((Widget) this).dataCenter.get("data_current_unique_id_preview", 0)).intValue();
    L40:
        IHostGameCP r5 = jc1.k.f(IHostGameCP.class);
        if (r5 == null) goto L53;
        Context r13 = getContext();
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L45;
        r1 = com.bytedance.android.live.core.utils.z.o(r14);
    L45:
        r5.onWidgetLoaded(r13, r1, r4, r12);
        return;
    L53:
        return;
    L39:
        r12 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();
        r4 = ((Number) ((Widget) this).dataCenter.get("room_controller_unique_key", 0)).intValue();
        goto L40
    L58:
        return;
    L50:
        return;
    L55:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof v4) == false) goto L18;
        v4 r7 = (v4) r6;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L19;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 != null) goto L10;
        return;
    L10:
        if (r7.isCurrentRoom(r1.id) == true) goto L12;
        return;
    L12:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.k) r52.o0.a.getValue()).a() != 0) goto L14;
        return;
    L14:
        if (r7.getDownloadCount() < 1) goto L23;
        ((Widget) this).dataCenter.put("data_game_download_message", r7);
        return;
    L23:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.o
    public final boolean Qa(com.bytedance.android.live.room.h.b r2, kj r3) {
        GameAbsInteractionDelegate r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.b(r2, r3);
    }
}
