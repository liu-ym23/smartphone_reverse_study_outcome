package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.lifecycle.LifecycleOwner;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.impl.converter.m;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import td.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IECLivePlayerClient {
    public final ILivePlayerClient a;
    public final LivePlayerView b;

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final Integer livePlayClientHashCode() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void saveFrameV2(Function2<? super Map<String, ? extends Object>, ? super Bitmap, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void switchStreamData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "streamData");
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void switchStreamData(String r10, le.a r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "streamData");
        Intrinsics.checkNotNullParameter(r11, "updateRequest");
        Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_ROOM_ID);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void bindRenderView() {
        IRenderView r0 = this.a.getRenderView();
        if (r0 == null) goto L6;
        this.a.bindRenderView(r0);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void blur() {
        this.a.blur();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final float curPlayerVolume() {
        return this.a.curPlayerVolume();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final long getAudioLostFocusTime() {
        return this.a.getAudioLostFocusTime();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final Bitmap getBitmap() {
        return this.a.getBitmap();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean getBufferFull() {
        return this.a.getBufferFull();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final String getCurrentResolution() {
        return this.a.getCurrentResolution();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean getEnableBackgroundStop() {
        return this.a.getEnableBackgroundStop();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final e getEventHub() {
        IRoomEventHub r0 = this.a.getEventHub();
        Intrinsics.checkNotNullParameter(r0, "$this$convert2EC");
        return m.b.a(r0);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final LifecycleOwner getLifecycleOwner() {
        return this.a.getLifecycleOwner();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final String getPullStreamData() {
        return this.a.getPullStreamData();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean getShouldDestroy() {
        return this.a.getShouldDestroy();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final JSONObject getStatsLog() {
        return this.a.getStatsLog();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean getStopBarrier() {
        return this.a.getStopBarrier();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final String getStreamFormat() {
        return this.a.getStreamFormat();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final Pair<Integer, Integer> getVideoSize() {
        return this.a.getVideoSize();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final int getVoiceDB() {
        return this.a.getVoiceDB();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final String identifier() {
        return this.a.identifier();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean isMute() {
        return this.a.isMute();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean isPlaying() {
        return this.a.isPlaying();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean isVideoHorizontal() {
        return this.a.isVideoHorizontal();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void mute() {
        this.a.mute();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void pause() {
        this.a.pause();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void release() {
        this.b.release();
        final Boolean r0 = Boolean.TRUE;
        int r1 = sg.a.a;
        final String r10 = "ec_live_player_clear_room_event_hub_convertor_cache_on_release";
        if (((Boolean) sg.a.a("ec_live_player_clear_room_event_hub_convertor_cache_on_release", r0, new ECLivePlayerClient$getLiveSettingsValue$1(r10, r0))).booleanValue() == false) goto L6;
        m.b.clear();
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void resume() {
        this.a.resume();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void resumePlay() {
        LivePlayerView.resumePlay$default(this.b, null, 1, null);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void stop() {
        this.b.stop();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void unblur() {
        this.a.unblur();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void unmute() {
        this.a.unmute();
    }

    public a(LivePlayerView r10) {
        Intrinsics.checkNotNullParameter(r10, "livePlayerView");
        this.b = r10;
        this.a = r10.getClient();
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void disableVideoRender(boolean r10) {
        this.a.disableVideoRender(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void getBitmap(Function1<? super Bitmap, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        this.a.getBitmap(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final boolean preCreateSurface(Context r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return this.a.preCreateSurface(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void saveFrame(Function1<? super Bitmap, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        this.a.saveFrame(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void seekBy(int r10) {
        this.a.seekBy(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void setEnableBackgroundStop(boolean r10) {
        this.a.setEnableBackgroundStop(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void setImageLayout(int r10) {
        this.a.setImageLayout(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void setPlayerVolume(float r10) {
        this.a.setPlayerVolume(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void setShouldDestroy(boolean r10) {
        this.a.setShouldDestroy(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void setStopBarrier(boolean r10) {
        this.a.setStopBarrier(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void setVideoSize(Pair<Integer, Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.a.setVideoSize(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void switchResolution(String r10) {
        Intrinsics.checkNotNullParameter(r10, "resolutionKey");
        this.a.switchResolution(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void clipRenderViewVertical(int r10, int r11) {
        this.a.clipRenderViewVertical(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient
    public final void stream(le.a r10, Function1<? super LifecycleOwner, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        ILivePlayerClient r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$trans");
        LiveRequest.Builder r12 = new LiveRequest.Builder().mute(r10.h).inBackground(false).openSei(r10.g).preview(r10.f).resolution(r10.b);
        ECLiveMode r13 = r10.c;
        Intrinsics.checkNotNullParameter(r13, "$this$trans");
        int r1 = com.bytedance.android.ec.adapter.impl.utils.b.a[r13.ordinal()];
        if (r1 != 1) goto L5;
        LiveStreamType r14 = LiveStreamType.AUDIO;
    L9:
        r0.stream(r12.streamType(r14).streamData(r10.a).enterType(r10.e).enterLiveSource(r10.d).build(), r11);
        return;
    L5:
        if (r1 == 2) goto L7;
        r14 = LiveStreamType.UNDEFINED;
        goto L9
    L7:
        r14 = LiveStreamType.VIDEO;
        goto L9
    }
}
