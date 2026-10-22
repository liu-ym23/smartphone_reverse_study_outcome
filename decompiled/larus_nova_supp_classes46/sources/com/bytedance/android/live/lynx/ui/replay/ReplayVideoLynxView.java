package com.bytedance.android.live.lynx.ui.replay;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0007J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\b\u0010\"\u001a\u00020\u0005H\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/replay/ReplayVideoLynxView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/android/live/lynx/ui/replay/ReplayVideoViewForLynx;", "", "str", "", "setEpisode", "url", "setPoster", "", "muted", "setMuted", "autoShowCover", "setAutoShowCover", "repeat", "setLoop", "autoPlay", "setAutoPlay", "objectFit", "setObjectFit", "Lcom/lynx/react/bridge/ReadableMap;", "logExtra", "setLogExtra", "enable", "setEnableEnterRoom", "(Ljava/lang/Boolean;)V", "", "startPosition", "setStartPosition", "params", "play", "pause", "seek", "mute", "enterRoom", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVideoLynxView extends LynxUI<ReplayVideoViewForLynx> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    @LynxUIMethod
    public final void enterRoom() {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).d();
    }

    public final void destroy() {
        super.destroy();
        ReplayVideoViewForLynx r0 = (ReplayVideoViewForLynx) ((LynxUI) this).mView;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public ReplayVideoLynxView(LynxContext r1) {
        super(r1);
    }

    public final View createView(Context r5) {
        Intrinsics.checkNotNull(r5);
        AttributeSet r3 = null;
        ReplayVideoViewForLynx r0 = new ReplayVideoViewForLynx(r5, r3, 6, 0);
        r0.setEventChangeListener(new ReplayVideoLynxView$createView$$inlined$apply$lambda$1(this));
        return r0;
    }

    @LynxUIMethod
    public final void mute(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Objects.toString(r4);
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setMuted(r4.getBoolean("muted", true));
    }

    @LynxUIMethod
    public final void pause(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        ReplayVideoViewForLynx r0 = (ReplayVideoViewForLynx) ((LynxUI) this).mView;
        String r5 = r4.getString("reason", "");
        if (r5 == null) goto L8;
        r0.getClass();
        if (r5.equals("from_lynx") != true) goto L8;
        if (r0.j == false) goto L8;
    L11:
        r0.u = false;
        return;
    L8:
        IReplayPlayerHelper r6 = r0.A;
        if (r6 == null) goto L11;
        r6.pause();
        goto L11
    }

    @LynxUIMethod
    public final void play(ReadableMap r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        ReplayVideoViewForLynx r0 = (ReplayVideoViewForLynx) ((LynxUI) this).mView;
        long r2 = -1;
        Long r8 = Long.valueOf(r7.getLong("start_position", -1));
        if (r8 == null) goto L6;
        r0.getClass();
        r2 = r8.longValue();
    L6:
        if (r2 < 0) goto L8;
        r0.g = r8;
    L8:
        r0.c();
    }

    @LynxUIMethod
    public final void seek(ReadableMap r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Objects.toString(r6);
        ReplayVideoViewForLynx r0 = (ReplayVideoViewForLynx) ((LynxUI) this).mView;
        long r1 = r6.getLong("position", 0);
        r0.t = r6.getBoolean("shouldPlay", true);
        r0.h = r1;
        IReplayPlayerHelper r7 = r0.A;
        if (r7 == null) goto L6;
        r7.seek(r1);
        return;
    }

    @LynxProp(name = "autoplay")
    public final void setAutoPlay(boolean r2) {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setAutoPlay(r2);
    }

    @LynxProp(name = "autoshowcover")
    public final void setAutoShowCover(boolean r2) {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setAutoShowCover(r2);
    }

    @LynxProp(name = "enablelynxenterroom")
    public final void setEnableEnterRoom(Boolean r2) {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setEnableEnterRoom(r2);
    }

    @LynxProp(name = "episode")
    public final void setEpisode(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        Episode r4 = (Episode) GsonHelper.get().fromJson(r3, Episode.class);     // Catch: Exception -> L5
    L7:
        if (r4 == null) goto L12;
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setEpisode(r4);
        return;
    L12:
        return;
    L5:
        e = move-exception;
        e.toString();
        r4 = null;
        goto L7
    }

    @LynxProp(name = "logextra")
    public final void setLogExtra(ReadableMap r2) {
        Objects.toString(r2);
        if (r2 == null) goto L6;
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setLogExtra(r2.toHashMap());
        return;
    }

    @LynxProp(name = "repeat")
    public final void setLoop(boolean r2) {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setRepeat(r2);
    }

    @LynxProp(name = "muted")
    public final void setMuted(boolean r2) {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setMuted(r2);
    }

    @LynxProp(name = "objectfit")
    public final void setObjectFit(String r2) {
        Intrinsics.checkNotNullParameter(r2, "objectFit");
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setObjectFit(r2);
    }

    @LynxProp(name = "poster")
    public final void setPoster(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setPoster(r2);
    }

    @LynxProp(name = "startposition")
    public final void setStartPosition(int r4) {
        ((ReplayVideoViewForLynx) ((LynxUI) this).mView).setStartPosition(r4);
    }

    public final void updateLayout(int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Rect r18) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updateLayout(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final void updateLayoutInfo(int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Rect r18) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updateLayoutInfo(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
