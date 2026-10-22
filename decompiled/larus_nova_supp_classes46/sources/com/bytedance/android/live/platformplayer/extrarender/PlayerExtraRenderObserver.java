package com.bytedance.android.live.platformplayer.extrarender;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.platformplayer.utils.c;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PlayerExtraRenderObserver {
    public final a a;
    public final PlayerExtraRenderObserver$mainFrameChangedObserver$1 b;
    public final PlayerExtraRenderObserver$rotateToPortraitObserver$1 c;
    public final b d;
    public final Lazy e;
    public final RoomBaseSession f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ PlayerExtraRenderObserver a;

        public a(PlayerExtraRenderObserver r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            ILivePlayerClient r7 = c.b(this.a.f);
            if (r7 == null) goto L7;
            IPlayerLogger r8 = r7.logger();
            if (r8 == null) goto L7;
            r8.logExtraRender("notify public screen width change!");
        L7:
            DataCenter r9 = this.a.f.getDataCenter();
            if (r9 == null) goto L10;
            Integer r10 = Integer.valueOf(r9.hashCode());
        L11:
            LayerEventDispatcher r11 = o70.c.a(r10);
            if (r11 == null) goto L15;
            r11.b(new o42.c(true, false, "CMD_PLAYER_EXTRA_RENDER Tetris"));
            return;
        L15:
            return;
        L10:
            r10 = null;
            goto L11
        }
    }

    public static final class b implements ILivePlayerExtraRenderController.RoomStatusService {
        public final /* synthetic */ PlayerExtraRenderObserver a;

        public final boolean curOrientationIsPortrait() {
            if (this.a.f.getContext().getResources().getConfiguration().orientation == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean isInCast() {
            ILiveByteCastService.Companion r0 = ILiveByteCastService.Companion;
            ILiveByteCastService r1 = r0.getInst();
            if (r1 != null) goto L5;
        L6:
            ILiveByteCastService r2 = r0.getInst();
            if (r2 == null) goto L9;
            Boolean r3 = r2.isSysExtendedCastMode();
        L11:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L16;
            return false;
        L16:
            return true;
        L9:
            r3 = null;
            goto L11
        L5:
            if (r1.isCasting() != true) goto L6;
            return true;
        }

        public final int statusBarHeight() {
            RoomContext r0 = this.a.a();
            if (r0 == null) goto L9;
            j r1 = r0.getPlatformPlayerRoomDepend();
            if (r1 == null) goto L9;
            bs0.a r2 = (bs0.a) r1.getValue();
            if (r2 == null) goto L9;
            return r2.statusBarHeight();
        L9:
            return 0;
        }

        public b(PlayerExtraRenderObserver r1) {
            this.a = r1;
        }
    }

    public final RoomContext a() {
        return RoomContext.a.c(RoomContext.Companion, this.f.getDataCenter(), 0, 2);
    }

    public final void b() {
        ILivePlayerClient r0 = c.b(this.f);
        if (r0 == null) goto L16;
        final ILivePlayerExtraRenderController r1 = r0.extraRenderController();
        if (r1 == null) goto L17;
        ILivePlayerExtraRenderController.DefaultImpls.log$default(r1, "register extra render event observer", false, 2, null);
        if (r1.isUgcRoom() == false) goto L14;
        r1.eventHub().getExtraViewWidth().observeForever(this.a);
        r1.eventHub().getRotateToPortrait().observeForever(this.c);
        RoomContext r2 = a();
        if (r2 == null) goto L13;
        j r3 = r2.getMessageManager();
        if (r3 == null) goto L13;
        r3.c(new PlayerExtraRenderObserver$onRoomEnter$$inlined$run$lambda$1(r1, this));
    L13:
        r1.eventHub().getMainFrameChanged().observeForever(this.b);
    L14:
        r1.injectRoomStatusService(this.d);
        return;
    L17:
        return;
    }

    public final void c() {
        ILivePlayerClient r0 = c.b(this.f);
        if (r0 == null) goto L16;
        final ILivePlayerExtraRenderController r1 = r0.extraRenderController();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isUgcRoom() == false) goto L14;
        r1.eventHub().getExtraViewWidth().removeObserver(this.a);
        r1.eventHub().getRotateToPortrait().removeObserver(this.c);
        RoomContext r2 = a();
        if (r2 == null) goto L13;
        j r3 = r2.getMessageManager();
        if (r3 == null) goto L13;
        r3.c(new PlayerExtraRenderObserver$onRoomExit$$inlined$run$lambda$1(r1, this));
    L13:
        r1.eventHub().getMainFrameChanged().removeObserver(this.b);
    L14:
        r1.injectRoomStatusService(null);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.platformplayer.extrarender.PlayerExtraRenderObserver$mainFrameChangedObserver$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.platformplayer.extrarender.PlayerExtraRenderObserver$rotateToPortraitObserver$1] */
    public PlayerExtraRenderObserver(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.f = r2;
        this.a = new a(this);
        this.b = new PlayerExtraRenderObserver$mainFrameChangedObserver$1(this);
        this.c = new PlayerExtraRenderObserver$rotateToPortraitObserver$1(this);
        this.d = new b(this);
        this.e = LazyKt.lazy(new PlayerExtraRenderObserver$commentaryChangeListener$2(this));
    }
}
