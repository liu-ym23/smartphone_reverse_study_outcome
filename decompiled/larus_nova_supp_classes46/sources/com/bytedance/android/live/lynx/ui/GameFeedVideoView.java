package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePlayCard;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/GameFeedVideoView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/view/View;", "Lcom/lynx/react/bridge/ReadableMap;", "params", "", "bindVideoData", "", "loop", "setLoop", "muted", "setMuted", "", "type", "setScaleType", "playFeedVideoIfNeeded", "play", "pause", "stop", "seek", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameFeedVideoView extends LynxUI<View> {
    public static final /* synthetic */ int c = 0;
    public IGamePlayCard a;
    public boolean b;

    public static final class a {
    }

    public static final class b implements IGamePlayCard.IGamePlayController.IGameUIPlayListener {
        public final /* synthetic */ GameFeedVideoView a;

        public final /* synthetic */ void onItemSelected(int r1) {
            IGamePlayCard.IGamePlayController.IGameUIPlayListener.-CC.$default$onItemSelected(this, r1);
        }

        public final /* synthetic */ void onSeekEnd(String r1, boolean r2) {
            IGamePlayCard.IGamePlayController.IGameUIPlayListener.-CC.$default$onSeekEnd(this, r1, r2);
        }

        public b(GameFeedVideoView r1) {
            this.a = r1;
        }

        public final void onPlayPause(String r4) {
            GameFeedVideoView r0 = this.a;
            Pair[] r1 = new Pair[1];
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            r1[0] = TuplesKt.to("sourceId", r4);
            Map<String, Object> r5 = MapsKt.mutableMapOf(r1);
            int r2 = GameFeedVideoView.c;
            r0.M("onPause", r5);
        }

        public final void onPlayPrepare(String r3) {
            GameFeedVideoView r4 = this.a;
            LinkedHashMap r0 = new LinkedHashMap();
            int r1 = GameFeedVideoView.c;
            r4.M("onReady", r0);
        }

        public final void onPlayStop(String r4) {
            GameFeedVideoView r0 = this.a;
            Pair[] r1 = new Pair[1];
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            r1[0] = TuplesKt.to("sourceId", r4);
            Map<String, Object> r5 = MapsKt.mutableMapOf(r1);
            int r2 = GameFeedVideoView.c;
            r0.M("onStop", r5);
        }

        public final void onPlaying(String r4) {
            GameFeedVideoView r0 = this.a;
            Pair[] r1 = new Pair[1];
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            r1[0] = TuplesKt.to("sourceId", r4);
            Map<String, Object> r5 = MapsKt.mutableMapOf(r1);
            int r2 = GameFeedVideoView.c;
            r0.M("onPlay", r5);
        }

        public final void onBuffering(String r2, boolean r3) {
            GameFeedVideoView r4 = this.a;
            LinkedHashMap r5 = new LinkedHashMap();
            int r0 = GameFeedVideoView.c;
            r4.M("onBufferingChange", r5);
        }

        public final void onPlayCompleted(String r3, int r4) {
            GameFeedVideoView r5 = this.a;
            Pair[] r0 = new Pair[1];
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            r0[0] = TuplesKt.to("sourceId", r3);
            Map<String, Object> r6 = MapsKt.mutableMapOf(r0);
            int r1 = GameFeedVideoView.c;
            r5.M("onEnded", r6);
        }

        public final void onPlayFail(String r5, int r6, String r7) {
            GameFeedVideoView r0 = this.a;
            Pair[] r1 = new Pair[3];
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r1[0] = TuplesKt.to("sourceId", r5);
            r1[1] = TuplesKt.to("err_code", Integer.valueOf(r6));
            if (r7 != null) goto L8;
            r7 = "";
        L8:
            r1[2] = TuplesKt.to("err_msg", r7);
            Map<String, Object> r8 = MapsKt.mutableMapOf(r1);
            int r9 = GameFeedVideoView.c;
            r0.M("onError", r8);
        }

        public final void onPlayProgressChange(String r4, long r5, long r7) {
            GameFeedVideoView r0 = this.a;
            Pair[] r1 = new Pair[3];
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            r1[0] = TuplesKt.to("sourceId", r4);
            r1[1] = TuplesKt.to("current", Long.valueOf(r5));
            r1[2] = TuplesKt.to("total", Long.valueOf(r7));
            Map<String, Object> r6 = MapsKt.mutableMapOf(r1);
            int r8 = GameFeedVideoView.c;
            r0.M("onTimeUpdate", r6);
        }
    }

    static {
    }

    @LynxUIMethod
    public final void pause() {
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.pause();
        return;
    L9:
        return;
    }

    @LynxUIMethod
    public final void play() {
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.play();
        return;
    L9:
        return;
    }

    @LynxUIMethod
    public final void playFeedVideoIfNeeded() {
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.feedVideoPlayIfNeeded();
        return;
    L9:
        return;
    }

    @LynxUIMethod
    public final void stop() {
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.stop();
        return;
    L9:
        return;
    }

    public final void destroy() {
        super.destroy();
        if (this.b == true) goto L9;
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L9;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.release();
    L9:
        this.b = true;
    }

    public GameFeedVideoView(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @LynxProp(name = "video-data")
    public final void bindVideoData(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Objects.toString(r4);
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.bind(r4.toHashMap()));
    L7:
        if ((!Intrinsics.areEqual(r1, Boolean.TRUE)) == false) goto L13;
        Pair[] r2 = new Pair[3];
        String r5 = r4.getString("associatedFeedId");
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r2[0] = TuplesKt.to("sourceId", r5);
        r2[1] = TuplesKt.to("err_code", -1801);
        r2[2] = TuplesKt.to("err_msg", "relate video fail!");
        M("onError", MapsKt.mutableMapOf(r2));
        return;
    L13:
        IGamePlayCard r6 = this.a;
        if (r6 == null) goto L19;
        IGamePlayCard.IGamePlayController r7 = r6.getPlayController();
        if (r7 == null) goto L20;
        r7.setOnUIPlayListener(new b(this));
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final View createView(Context r3) {
        IHostGameCP r0 = jc1.k.f(IHostGameCP.class);
        View r1 = null;
        if (r0 == null) goto L5;
        IGamePlayCard r2 = r0.createGamePlayCard();
    L6:
        this.a = r2;
        if (r3 == null) goto L12;
        if (r2 == null) goto L10;
        r1 = r2.getView(r3);
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return new View(r3);
    L5:
        r2 = null;
        goto L6
    }

    @LynxUIMethod
    public final void seek(ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L8;
        r1.seek((float) r5.getDouble("position", 0.0d));
    L8:
        if (r5.hasKey("play") == true) goto L10;
        return;
    L10:
        if (r5.getBoolean("play") == false) goto L18;
        IGamePlayCard r6 = this.a;
        if (r6 == null) goto L19;
        IGamePlayCard.IGamePlayController r7 = r6.getPlayController();
        if (r7 == null) goto L20;
        r7.play();
        return;
    L20:
        return;
    L19:
        return;
    }

    @LynxProp(name = "loop")
    public final void setLoop(boolean r2) {
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.setLoop(r2);
        return;
    L9:
        return;
    }

    @LynxProp(name = "muted")
    public final void setMuted(boolean r2) {
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.setMute(r2);
        return;
    L9:
        return;
    }

    @LynxProp(name = "objectfit")
    public final void setScaleType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        IGamePlayCard r0 = this.a;
        if (r0 == null) goto L8;
        IGamePlayCard.IGamePlayController r1 = r0.getPlayController();
        if (r1 == null) goto L9;
        r1.setScaleType(r2);
        return;
    L9:
        return;
    }

    public final void M(String r4, Map<String, Object> r5) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L25;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L26;
        m7a.a r2 = new m7a.a(getSign(), r4);
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<String, Object> r7 = r6.next();
        String r3 = r7.getKey();
        if (r3 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L8;
        r2.a(r7.getKey(), r7.getValue());
        goto L8
    L12:
        if (r3.length() == 0) goto L15;
        r8 = false;
        goto L16
    L18:
        Unit r9 = Unit.INSTANCE;
        r1.sendCustomEvent(r2);
        return;
    L26:
        return;
    }
}
