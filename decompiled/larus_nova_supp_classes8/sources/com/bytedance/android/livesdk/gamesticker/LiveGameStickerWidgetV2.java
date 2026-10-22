package com.bytedance.android.livesdk.gamesticker;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.f;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.k;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.o;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.LiveGameStickerLayoutStrategy;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.LiveUniversalLayoutStrategy;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.e;
import com.bytedance.android.livesdk.gamesticker.layoutstrategy.h;
import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOrientation;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/LiveGameStickerWidgetV2;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGameStickerWidgetV2 extends LiveRecyclableWidget {
    public com.bytedance.android.livesdk.chatroom.gamestickerv2.c a;
    public LiveGameStickerLayoutStrategy b;
    public d c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public GameStickerOrientation h;
    public Room i;
    public boolean j;
    public Boolean k;
    public final b l;
    public final c m;
    public final a n;
    public final Fragment o;
    public final View p;
    public final long q;
    public final Bundle r;

    public static final class a implements l {
        public final /* synthetic */ LiveGameStickerWidgetV2 a;

        public a(LiveGameStickerWidgetV2 r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r7) {
            if (r7 != null) goto L4;
            return;
        L4:
            if ((r7 instanceof GameRoomStickerOprMessage) == false) goto L10;
            GameRoomStickerOprMessage r8 = (GameRoomStickerOprMessage) r7;
            long r0 = ((BaseMessage) r8).baseMessage.roomId;
            LiveGameStickerWidgetV2 r2 = this.a;
            if (r0 != r2.q) goto L11;
            r2.Bq("onMessage");
            LiveGameStickerWidgetV2 r1 = this.a;
            r1.e = true;
            r1.Cq(LivePlatformPlayerManager.a(r1.q, false));
            this.a.wq(SetsKt.setOf(Integer.valueOf(r8.getStickerType())));
            f r3 = f.a;
            k.b.dispatch(this.a.zq(), r8);
            return;
        L11:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ LiveGameStickerWidgetV2 a;

        public b(LiveGameStickerWidgetV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            LiveGameStickerWidgetV2 r0 = this.a;
            r0.Cq(LivePlatformPlayerManager.a(r0.q, false));
            com.bytedance.android.livesdk.chatroom.gamestickerv2.c r1 = this.a.a;
            if (r1 == null) goto L6;
            r1.setFirstFrameState(r6.booleanValue());
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LiveGameStickerWidgetV2 a;

        public c(LiveGameStickerWidgetV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            this.a.Bq("onSei");
            f r0 = f.a;
            k r1 = k.b;
            String r2 = this.a.zq();
            r1.dispatch(r2, (String) r3);
        }
    }

    public final int getLayoutId() {
        return 2131566105;
    }

    public final void onInit(Object[] r1) {
    }

    public final void Aq() {
        if (this.a != null) goto L6;
        xq();
    L6:
        if (this.j == true) goto L10;
        Fragment r0 = this.o;
        if (r0 == null) goto L10;
        f.a.initDataContext(r0, this, GameStickerScene.ENTER);
        this.j = true;
    L10:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r4 = this.a;
        if (r4 == null) goto L16;
        String r5 = this.h.name();
        Room r6 = this.i;
        GameStickerOrientation r8 = this.h;
        long r2 = this.r.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", -1);
        if (r2 > 0) goto L15;
        r2 = System.currentTimeMillis();
    L15:
        r4.onPageVisibilityChange(r5, r6, true, r8, r2);
    L16:
        Bq("loadSticker");
        ILivePlayerClient r1 = LivePlatformPlayerManager.a(this.q, false);
        if (r1 != null) goto L19;
        return;
    L19:
        if (this.b != null) goto L25;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r3 = this.a;
        if (r3 == null) goto L25;
        Bq("attachLayoutStrategy");
        LiveGameStickerLayoutStrategy r7 = new LiveGameStickerLayoutStrategy(this.q, this, r1, ((Widget) this).dataCenter);
        this.b = r7;
        Intrinsics.checkNotNullParameter(r3, "viewProxy");
        r7.h = r3;
        r7.a("attach");
    L25:
        if (this.g == true) goto L31;
        Bq("observePlayerFirstFrame");
        this.g = true;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r9 = this.a;
        if (r9 == null) goto L30;
        r9.setFirstFrameState(Intrinsics.areEqual((Boolean) r1.getEventHub().getFirstFrame().getValue(), Boolean.TRUE));
    L30:
        r1.getEventHub().getFirstFrame().observe(this, this.l);
    L31:
        Cq(r1);
    }

    public final void Fq() {
        Bq("unLoadSticker");
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(this.q, false);
        if (r0 == null) goto L10;
        Bq("removeSeiObserver " + this.d);
        this.d = false;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L9;
        MutableLiveData r2 = r1.getSeiUpdate();
        if (r2 == null) goto L9;
        r2.removeObserver(this.m);
    L9:
        this.g = false;
        Bq("removePlayerFirstFrameObserver");
        r0.getEventHub().getFirstFrame().removeObserver(this.l);
    L10:
        Bq("detachLayoutStrategy");
        LiveGameStickerLayoutStrategy r3 = this.b;
        if (r3 == null) goto L16;
        r3.a("detach");
        if (((Boolean) r3.a.getValue()).booleanValue() == false) goto L15;
        ((LiveUniversalLayoutStrategy) r3.g.getValue()).detach();
        goto L16
    L15:
        ((h) r3.b.getValue()).detach();
        ((e) r3.c.getValue()).detach();
    L16:
        this.b = null;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r4 = this.a;
        if (r4 == null) goto L19;
        r4.unbindTask();
    L19:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r5 = this.a;
        if (r5 == null) goto L22;
        r5.detachView();
    L22:
        this.a = null;
        Bq("view proxy detach");
    }

    public final void onUnload() {
        Bq("onUnload");
        Fq();
        f r0 = f.a;
        k.b.recycle(zq());
    }

    public final void xq() {
        Bq("view proxy attach");
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r0 = f.a.buildContainerViewProxy(((Widget) this).context, zq(), GameStickerScene.ENTER);
        this.a = r0;
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L15;
        r0.attachView((ViewGroup) r1);
        Room r2 = this.i;
        if (r2 == null) goto L8;
        Set r3 = r2.getGameStickerTypes();
        if (r3 == null) goto L8;
    L9:
        Set<Integer> r4 = CollectionsKt.toMutableSet(r3);
        r4.addAll(o.b.get(zq()));
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r5 = this.a;
        if (r5 == null) goto L12;
        r5.k = !r4.isEmpty();
    L12:
        ALogger.i("LiveGameStickerWidgetV2", this.q + " stickerTypes:" + r4);
        wq(r4);
        return;
    L8:
        r3 = SetsKt.emptySet();
        goto L9
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final String zq() {
        return String.valueOf(this.q);
    }

    public final void Bq(String r4) {
        ALogger.d("LiveGameStickerWidgetV2", this.q + " live " + r4);
    }

    public final void Cq(ILivePlayerClient r4) {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.f == false) goto L31;
        f r0 = f.a;
        boolean r1 = true;
        if ((!o.b.get(zq()).isEmpty()) == false) goto L10;
    L11:
        if (r4 == null) goto L15;
        IRoomEventHub r5 = r4.getEventHub();
        if (r5 == null) goto L15;
        MutableLiveData r6 = r5.getSeiUpdate();
    L16:
        if (r6 != null) goto L19;
        r1 = false;
    L19:
        this.d = r1;
        k r2 = k.b;
        String r3 = zq();
        if (r6 == null) goto L23;
        String r7 = (String) r6.getValue();
        if (r7 == null) goto L23;
    L24:
        r2.dispatch(r3, r7);
        if (r6 == null) goto L27;
        r6.observe(this, this.m);
    L27:
        Bq("observeSei " + this.d);
        return;
    L23:
        r7 = "";
    L15:
        r6 = null;
        goto L16
    L10:
        if (this.e == true) goto L11;
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        Boolean r4 = this.k;
        if (r4 == null) goto L9;
        boolean r5 = r4.booleanValue();
        Room r0 = this.i;
        if (r0 != null) goto L7;
        return;
    L7:
        Eq(r5, r0, "system");
        return;
    }

    public final void onLoad(Object[] r1) {
        Bq("onLoad");
        this.f = false;
        this.e = false;
        this.g = false;
        xq();
    }

    public final void wq(Set<Integer> r4) {
        f r0 = f.a;
        o.b.cache(zq(), r4);
        if (r4.isEmpty() == true) goto L13;
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r1 = this.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.hasTask() == true) goto L16;
        Bq("obtain task and bind task " + r4);
        IGameStickerTask r5 = k.b.obtainTask(GameStickerScene.ENTER, zq(), r4);
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r2 = this.a;
        if (r2 == null) goto L15;
        r2.bindTask(r5);
        return;
    L15:
        return;
    L16:
        return;
    }

    public final void yq(boolean r5) {
        View r0 = this.p.findViewById(2131387340);
        View r1 = this.p.findViewById(2131382474);
        if ((!Intrinsics.areEqual(r1.getParent(), r0.getParent())) == false) goto L5;
        return;
    L5:
        if ((r0.getParent() instanceof ViewGroup) == false) goto L18;
        ViewParent r2 = r0.getParent();
        if (r2 == null) goto L16;
        ViewGroup r3 = (ViewGroup) r2;
        int r4 = r3.indexOfChild(r1);
        r3.removeView(r0);
        if (r5 == false) goto L12;
        int r6 = r4 + 1;
    L13:
        r3.addView(r0, r6);
        Bq("changeStickerViewIndex isPortrait:" + r5 + ", player Index:" + r4 + " sticker Index:" + r6);
        return;
    L12:
        r6 = r4 - 1;
        goto L13
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void Eq(boolean r3, Room r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "source");
        Bq("on " + r5 + " ConfigurationChanged isPortrait:" + r3);     // Catch: Exception -> L17
        this.i = r4;     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r5, "interact") == false) goto L6;
        this.k = Boolean.valueOf(r3);     // Catch: Exception -> L17
    L6:
        yq(r3);     // Catch: Exception -> L17
        if (r3 == false) goto L9;
        GameStickerOrientation r6 = GameStickerOrientation.VERTICAL;     // Catch: Exception -> L17
    L10:
        this.h = r6;     // Catch: Exception -> L17
        Aq();     // Catch: Exception -> L17
        this.f = true;     // Catch: Exception -> L17
        com.bytedance.android.livesdk.chatroom.gamestickerv2.c r7 = this.a;     // Catch: Exception -> L17
        if (r7 == null) goto L13;
        r7.onOrientationChanged(!r3 ? 1 : 0);     // Catch: Exception -> L17
    L13:
        LiveGameStickerLayoutStrategy r8 = this.b;     // Catch: Exception -> L17
        if (r8 == null) goto L22;
        r8.b(r3);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L9:
        r6 = GameStickerOrientation.LANDSCAPE;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("LiveGameStickerWidgetV2", "onConfigurationChanged", e);
    }

    public LiveGameStickerWidgetV2(Fragment r2, View r3, long r4, Bundle r6) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r6, "args");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r6;
        this.h = GameStickerOrientation.VERTICAL;
        this.l = new b(this);
        this.m = new c(this);
        this.n = new a(this);
    }
}
