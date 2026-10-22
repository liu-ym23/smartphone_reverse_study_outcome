package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.common.ui.GameExitConformDialog;
import com.bytedance.android.live.broadcastgame.widget.AnchorGameWidget;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements com.bytedance.android.live.broadcastgame.api.e {
    public WeakReference<IAnchorGameWidget> a;
    public final Handler b;
    public final b c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ x a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c("key_game_in_cast", null, 1, true);     // Catch: Throwable -> L8
            WeakReference<IAnchorGameWidget> r0 = this.a.a;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            IAnchorGameWidget r1 = r0.get();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.Aq();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public b(x r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void a() {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.xq();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void b() {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.Cq();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final com.bytedance.android.live.broadcastgame.api.model.u getCurrentPlayingGame() {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.u> r1 = r0.getCurrentGame();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.broadcastgame.api.model.u) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final String getGameCategory() {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L8;
        String r2 = r1.wq();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final boolean isPlayingGame() {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isPlayingGame();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void stopGameCastToAudience() {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.Fq();
        return;
    L9:
        return;
    }

    public x() {
        this.b = new Handler(Looper.getMainLooper());
        this.c = new b(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final h0 getLiveOpenFeatureSceneFilter(DataCenter r2) {
        h0 r0 = new h0();
        r0.a = r2;
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final boolean isPlayingGame(InteractID r2) {
        Intrinsics.checkNotNullParameter(r2, "gameType");
        AnchorGameContext.Companion.getClass();
        return AnchorGameContext.a.b(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void notifyStopLinkCastResult(boolean r2) {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.zq(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void stopRunningPlugin(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.Eq(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final GameExitConformDialog getGameExitConformDialog(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        return new GameExitConformDialog(r2, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void sendGameCastStatusSEI(boolean r6, JSONObject r7) {
        int r1 = com.bytedance.android.live.broadcastgame.api.interactgame.f.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L12
        r3.put("key_game_in_cast", r6);     // Catch: Throwable -> L12
        if (r7 == null) goto L10;
        Iterator<String> r4 = r7.keys();     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
    L8:
        if (r4.hasNext() == false) goto L10;
        String r5 = r4.next();     // Catch: Throwable -> L12
        r3.put(r5, r7.get(r5));     // Catch: Throwable -> L12
    L10:
        Object r8 = Result.constructor-impl(r3.toString());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r8) == false) goto L17;
        r8 = "";
    L17:
        String r9 = (String) r8;
        ALogger.i("GameAnchorService", "sendGameCastStatusSEI, inCast: " + r6 + ", data: " + r9);
        if (r6 == false) goto L20;
        this.b.removeCallbacks(this.c);
        c("key_game_in_cast", r9, -1, true);
        return;
    L20:
        c("key_game_in_cast", null, 1, false);
        c("key_game_in_cast", r9, -1, true);
        this.b.postDelayed(this.c, n5.DEFAULT_SHOW_DURATION);
        return;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void sendGameSeiData(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        c(r3, r4, -1, true);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void sendServerMergeCastStatusSEI(boolean r7, JSONObject r8) {
        int r0 = com.bytedance.android.live.broadcastgame.api.interactgame.f.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L12
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L12
        r3.put("key_game_in_cast", r7);     // Catch: Throwable -> L12
        if (r8 == null) goto L10;
        Iterator<String> r4 = r8.keys();     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
    L8:
        if (r4.hasNext() == false) goto L10;
        String r5 = r4.next();     // Catch: Throwable -> L12
        r3.put(r5, r8.get(r5));     // Catch: Throwable -> L12
    L10:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r2.put("key_game_in_cast", r3.toString());     // Catch: Throwable -> L12
        r2.put("source", "TTLiveSDK_Android");     // Catch: Throwable -> L12
        Object r11 = Result.constructor-impl(r2.toString());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r11) == false) goto L17;
        r11 = "";
    L17:
        String r12 = (String) r11;
        ALogger.i("GameAnchorService", "sendServerMergeCastStatusSEI, inCast: " + r7 + ", data: " + r12);
        if (r7 == false) goto L20;
        this.b.removeCallbacks(this.c);
        c("key_game_in_cast", r12, -1, true);
        return;
    L20:
        c("key_game_in_cast", null, 1, false);
        c("key_game_in_cast", r12, -1, true);
        this.b.postDelayed(this.c, n5.DEFAULT_SHOW_DURATION);
        return;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void notifyStartLinkCastResult(boolean r2, Surface r3, int r4) {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.yq(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final void c(String r2, String r3, int r4, boolean r5) {
        WeakReference<IAnchorGameWidget> r0 = this.a;
        if (r0 == null) goto L8;
        IAnchorGameWidget r1 = r0.get();
        if (r1 == null) goto L9;
        r1.Bq(r2, r3, r4, r5);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final AnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r2, Room r3, Fragment r4, FragmentManager r5) {
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.PAGE.ROOM);
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        AnchorGameWidget r0 = new AnchorGameWidget(r2, r3, r4, r5);
        this.a = new WeakReference(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.e
    public final void tryGetSwitchGameConfirmDialog(com.bytedance.android.live.broadcastgame.api.model.u r2, Context r3, DataCenter r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "gameItem");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "onSuccess");
        Intrinsics.checkNotNullParameter(r6, "onFail");
        com.bytedance.android.live.broadcastgame.common.utils.b.a(r2, r3, r4, r5, r6);
    }
}
