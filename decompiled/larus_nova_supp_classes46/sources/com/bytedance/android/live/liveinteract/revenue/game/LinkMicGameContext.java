package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.livesdk.config.at;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.message.model.rm;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b \u0010!R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/game/LinkMicGameContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/revenue/game/d;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/revenue/game/LinkMicGameWidget;", "widget$delegate", "Lcom/bytedance/live/datacontext/p;", "getWidget", "()Lcom/bytedance/live/datacontext/j;", "widget", "", "Lcom/bytedance/android/livesdk/message/model/rm$b;", "gameScores", "Ljava/util/List;", "getGameScores", "()Ljava/util/List;", "setGameScores", "(Ljava/util/List;)V", "", "hasClickFoldButtonBySelf", "Z", "getHasClickFoldButtonBySelf", "()Z", "setHasClickFoldButtonBySelf", "(Z)V", "", "targetUiLayout", "J", "getTargetUiLayout", "()J", "setTargetUiLayout", "(J)V", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMicGameContext extends DataContext implements d {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private List<rm.b> gameScores;
    private boolean hasClickFoldButtonBySelf;
    private long targetUiLayout;
    private final p widget$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final LinkMicGameContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(d.class);
            if ((r0 instanceof LinkMicGameContext) == true) goto L6;
            r0 = null;
        L6:
            return (LinkMicGameContext) r0;
        }

        public final LinkMicGameWidget a() {
            LinkMicGameContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<LinkMicGameWidget> r1 = r0.getWidget();
            if (r1 == null) goto L7;
            return (LinkMicGameWidget) r1.getValue();
        L7:
            return null;
        }

        public final boolean c() {
            com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L10;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L10;
            RoomExtra r2 = r1.getExtra();
            if (r2 == null) goto L10;
            if (r2.isGroupLiveGame() != true) goto L10;
        L37:
            return false;
        L10:
            LinkMicGameContext r3 = getContext();
            if (r3 != null) goto L13;
        L14:
            LinkMicGameContext r4 = getContext();
            if (r4 != null) goto L17;
        L18:
            Integer r5 = je0.d.h();
            if (r5 != null) goto L22;
        L23:
            Integer r6 = je0.d.h();
            if (r6 != null) goto L27;
        L29:
            com.bytedance.android.live.broadcastgame.api.xplay.f r7 = com.bytedance.android.live.broadcastgame.api.xplay.n.b.n();
            if (r7 == null) goto L32;
            XplayGuestType r8 = r7.a();
        L34:
            if (r8 != XplayGuestType.SILENCE) goto L36;
            return false;
        L36:
            return true;
        L32:
            r8 = null;
            goto L34
        L27:
            if (r6.intValue() != 65) goto L29;
        L22:
            if (r5.intValue() == 16) goto L37;
        L17:
            if (r4.getTargetUiLayout() == 65) goto L37;
        L13:
            if (r3.getTargetUiLayout() == 16) goto L37;
            goto L14
        }

        public final boolean d() {
            LinkMicGameContext r0 = getContext();
            if (r0 == null) goto L11;
            if (r0.getTargetUiLayout() != 16) goto L8;
            return true;
        L8:
            if (r0.getTargetUiLayout() != 65) goto L11;
            return true;
        L11:
            return ((Boolean) at.a.getValue()).booleanValue();
        }

        public final boolean e() {
            LinkMicGameWidget r0 = a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isOpen();
        }

        public static void b(ti6.f r3) {
            Intrinsics.checkNotNullParameter(r3, "region");
            tc0.c r0 = tc0.c.h();
            String r1 = r3.b;
            r0.getClass();
            int r2 = tc0.e.a;
            Map.Entry r4 = tc0.e.a(r1, r0.o);
            if (r4 == null) goto L9;
            g2 r5 = (g2) r4.getValue();
            if (r5 == null) goto L9;
            boolean r6 = true;
            if (r5.getRoomLinkSilenceStatus() != 1) goto L9;
        L10:
            r3.m = r6;
            return;
        L9:
            r6 = false;
            goto L10
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkMicGameContext.class, "widget", "getWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final LinkMicGameContext getContext() {
        return Companion.getContext();
    }

    public final com.bytedance.live.datacontext.j<LinkMicGameWidget> getWidget() {
        return (com.bytedance.live.datacontext.j) this.widget$delegate.a(this, $$delegatedProperties[0]);
    }

    public LinkMicGameContext() {
        this.widget$delegate = ConstantKt.c(this);
    }

    public final List<rm.b> getGameScores() {
        return this.gameScores;
    }

    public final boolean getHasClickFoldButtonBySelf() {
        return this.hasClickFoldButtonBySelf;
    }

    public final long getTargetUiLayout() {
        return this.targetUiLayout;
    }

    public final void setGameScores(List<rm.b> r1) {
        this.gameScores = r1;
    }

    public final void setHasClickFoldButtonBySelf(boolean r1) {
        this.hasClickFoldButtonBySelf = r1;
    }

    public final void setTargetUiLayout(long r1) {
        this.targetUiLayout = r1;
    }
}
