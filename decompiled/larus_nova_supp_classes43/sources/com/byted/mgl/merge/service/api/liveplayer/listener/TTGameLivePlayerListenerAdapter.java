package com.byted.mgl.merge.service.api.liveplayer.listener;

import com.byted.cast.sink.api.IAPI;
import com.byted.mgl.merge.service.api.liveplayer.IGameTTLivePlayer;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/listener/TTGameLivePlayerListenerAdapter;", "Lcom/byted/mgl/merge/service/api/liveplayer/listener/IGameTTLivePlayerListener;", "()V", "onCompletion", "", "onError", IHostStyleUIDepend.TOAST_TYPE_ERROR, "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$LiveError;", "onFirstFrame", "isFirstFrame", "", "onLivePlayerPrepared", "onMonitorLog", "data", "Lorg/json/JSONObject;", "onPlayStateChanged", "state", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$PlayerState;", "onResolutionDegrade", "resolution", "", "onSeiUpdate", a.KEY_MSG, "onStallEnd", "onStallStart", "onVideoSizeChanged", "videoWidth", "", "videoHeight", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public class TTGameLivePlayerListenerAdapter implements IGameTTLivePlayerListener {
    public TTGameLivePlayerListenerAdapter() {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onCompletion() {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onError(IGameTTLivePlayer.LiveError r1) {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onFirstFrame(boolean r1) {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onLivePlayerPrepared() {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onMonitorLog(JSONObject r1) {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onPlayStateChanged(IGameTTLivePlayer.PlayerState r1) {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onResolutionDegrade(String r1) {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onSeiUpdate(String r1) {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onStallEnd() {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onStallStart() {
    }

    @Override // com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener
    public void onVideoSizeChanged(int r1, int r10) {
    }
}
