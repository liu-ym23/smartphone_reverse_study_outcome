package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerService;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class DrawerCommonLiveViewHolder extends CommonLiveViewHolder implements an2.a {
    public static final /* synthetic */ int I = 0;
    public final TextureRenderView D;
    public final FrameLayout E;
    public ILivePlayerClient F;
    public boolean G;
    public long H;

    public boolean f4() {
        return false;
    }

    public final void play() {
        Room r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.G == false) goto L7;
        return;
    L7:
        if (this.D != null) goto L9;
        return;
    L9:
        if (r0.getStreamType() != LiveMode.AUDIO) goto L11;
        return;
    L11:
        if (this.n.isPaidRoom() == true) goto L39;
        ILiveService r1 = TTLiveService.getLiveService();
        if (r1 != null) goto L16;
        return;
    L16:
        ILivePlayerService r2 = r1.livePlayerService();
        if (r2 != null) goto L19;
        return;
    L19:
        ILivePlayerClient r3 = r2.createClient(LivePlayerConfig.buildWith(LivePlayerScene.INSTANCE.getDRAWER_FEED(), this.n.getRoomId()));
        this.F = r3;
        r3.bindRenderView(this.D);
        UIUtils.setViewVisibility(this.D, 0);
        String r4 = "";
        String r5 = "-1";
        if (jc1.k.f(IResolutionService.class) != null) goto L25;
        r4 = this.n.getMultiStreamDefaultQualitySdkKey();     // Catch: Exception -> L30
        if (r4 != null) goto L28;
        r4 = "origin";
    L28:
        HashMap r6 = new HashMap();     // Catch: Exception -> L30
        r6.put("resolution_strategy", r5);     // Catch: Exception -> L30
        this.F.injectAppLoggerParams("live_player_play_start", r6);     // Catch: Exception -> L30
        LiveRequest.Builder r7 = new LiveRequest.Builder().streamData(this.n.getMultiStreamData()).resolution(r4).preview(true).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(this.n.getStreamType())).mute(true);     // Catch: Exception -> L30
        com.bytedance.android.livesdk.performance.a.a(r7).enableAdaptiveGrading(t9.a.getValue().getEnableDraw());     // Catch: Exception -> L30
        LiveRequest r8 = r7.build();     // Catch: Exception -> L30
        this.F.stream(r8, new e(this));     // Catch: Exception -> L30
        return;
    L25:
        PlayerResolution.PickResult r9 = jc1.k.f(IResolutionService.class).getWindowDefaultResolutionSdkKey(this.n, "small_window_resolution");     // Catch: Exception -> L30
        if (r9 == null) goto L28;
        r4 = r9.getResultSdkKey();     // Catch: Exception -> L30
        r5 = r9.getPickStrategy();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void reset() {
        ILivePlayerClient r0 = this.F;
        if (r0 != null) goto L5;
    L7:
        this.G = false;
        return;
    L5:
        if (this.D == null) goto L7;
        r0.release();
        UIUtils.setViewVisibility(this.D, 8);
        goto L7
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        reset();
    }

    public final boolean t7() {
        return !xv1.b.a().isEmpty();
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public void U3(FeedItem r1, Room r2, int r3) {
        super.U3(r1, r2, r3);
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final boolean Y3(FeedItem r1, boolean r2, String r3, Bundle r4) {
        boolean r5 = super.Y3(r1, false, "small_picture", r4);
        if (r5 == false) goto L5;
        reset();
        xs2.b.a().post(new uv1.e(0));
    L5:
        return r5;
    }

    public DrawerCommonLiveViewHolder(View r1, tv1.c r2, com.bytedance.android.livesdk.feed.f r3, FeedDataKey r4, com.bytedance.android.livesdk.feed.j r5, ILiveRoomListDataSource r6, PublishSubject r7, PublishSubject r8, com.bytedance.android.livesdk.feed.h r9) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        this.i = true;
        TextureRenderView r10 = r1.findViewById(2131388537);
        this.D = r10;
        this.E = (FrameLayout) r1.findViewById(2131372951);
        if (r10 == null) goto L6;
        r2.a(r10, s1.f(2.0f));
        return;
    }
}
