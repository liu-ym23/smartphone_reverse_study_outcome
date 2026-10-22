package com.bytedance.android.live.player.api;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000bH&J\b\u0010=\u001a\u00020>H&J\n\u0010?\u001a\u0004\u0018\u00010@H&J\b\u0010A\u001a\u00020BH&J\n\u0010C\u001a\u0004\u0018\u00010DH&J\n\u0010E\u001a\u0004\u0018\u00010\u000bH&J\n\u0010F\u001a\u0004\u0018\u00010\u000bH&J\u0016\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH&J\n\u0010I\u001a\u0004\u0018\u00010DH&J\n\u0010J\u001a\u0004\u0018\u00010\u000bH&J\n\u0010K\u001a\u0004\u0018\u00010@H&J\b\u0010L\u001a\u00020\u000bH&J\n\u0010M\u001a\u0004\u0018\u00010DH&J\n\u0010N\u001a\u0004\u0018\u00010\u000bH&J\n\u0010O\u001a\u0004\u0018\u00010@H&J\n\u0010P\u001a\u0004\u0018\u00010QH&J\b\u0010R\u001a\u000205H&J\b\u0010S\u001a\u00020\u000bH&J\b\u0010T\u001a\u00020\u0007H&J\u0010\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u000bH&J\b\u0010W\u001a\u00020\u0007H&J\b\u0010X\u001a\u00020;H&J\b\u0010Y\u001a\u00020\u0007H&J\u0010\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0018\u0010\u0016\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u0011R\u0012\u0010\u0019\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0012\u0010\u001a\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\tR\u0018\u0010\u001b\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u0004\u0018\u00010\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0012\u0010'\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0014\u0010)\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0018\u0010+\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u0011R\u0018\u0010.\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u0011R\u0012\u00101\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\rR$\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020504X¦\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006\\"}, d2 = {"Lcom/bytedance/android/live/player/api/ILivePlayerStatus;", "", "audioLostFocusTime", "", "getAudioLostFocusTime", "()J", "bufferFull", "", "getBufferFull", "()Z", "currentResolution", "", "getCurrentResolution", "()Ljava/lang/String;", "enableBackgroundStop", "getEnableBackgroundStop", "setEnableBackgroundStop", "(Z)V", "hasAudioFocus", "getHasAudioFocus", "hasFirstFrame", "getHasFirstFrame", "hasFirstFrameCacheForSurfaceView", "getHasFirstFrameCacheForSurfaceView", "setHasFirstFrameCacheForSurfaceView", "isPlaying", "isVideoHorizontal", "liveLiteEnterRoomOpt", "getLiveLiteEnterRoomOpt", "setLiveLiteEnterRoomOpt", "liveMode", "getLiveMode", "()Ljava/lang/Object;", "liveRequest", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "getLiveRequest", "()Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "mobileTrafficThreshold", "getMobileTrafficThreshold", "playerStartPullStreamTime", "getPlayerStartPullStreamTime", "pullStreamData", "getPullStreamData", "releaseCalled", "getReleaseCalled", "setReleaseCalled", "shouldDestroy", "getShouldDestroy", "setShouldDestroy", "streamFormat", "getStreamFormat", "videoSize", "Lkotlin/Pair;", "", "getVideoSize", "()Lkotlin/Pair;", "setVideoSize", "(Lkotlin/Pair;)V", "callLog", "", "msg", "context", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerClientContext;", "getActualPlayerSurface", "Landroid/view/Surface;", "getCurrentState", "Lcom/bytedance/android/livesdk/player/State;", "getFirstFrameBlockInfo", "Lorg/json/JSONObject;", "getLiveManagerHashCode", "getLivePlayerState", "getLiveStreamBaseInfo", "", "getLiveStreamInfoForSlardarReport", "getPlayerState", "getPlayerSurface", "getSessionId", "getStatsLog", "getTTlivePlayerHashCode", "getViewSurface", "getViewSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getVoiceDB", "identifier", "isPrePrepare", "isSupportResolutionSwitch", "resolution", "isTextureRender", "logEnd", "supportHardwareBufferOutput", "updateIdentifier", "newIdentifier", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerStatus {
    void callLog(String r1);

    LivePlayerClientContext context();

    Surface getActualPlayerSurface();

    long getAudioLostFocusTime();

    boolean getBufferFull();

    String getCurrentResolution();

    State getCurrentState();

    boolean getEnableBackgroundStop();

    JSONObject getFirstFrameBlockInfo();

    boolean getHasAudioFocus();

    boolean getHasFirstFrame();

    boolean getHasFirstFrameCacheForSurfaceView();

    boolean getLiveLiteEnterRoomOpt();

    String getLiveManagerHashCode();

    Object getLiveMode();

    String getLivePlayerState();

    LiveRequest getLiveRequest();

    Map<String, String> getLiveStreamBaseInfo();

    JSONObject getLiveStreamInfoForSlardarReport();

    long getMobileTrafficThreshold();

    long getPlayerStartPullStreamTime();

    String getPlayerState();

    Surface getPlayerSurface();

    String getPullStreamData();

    boolean getReleaseCalled();

    String getSessionId();

    boolean getShouldDestroy();

    JSONObject getStatsLog();

    String getStreamFormat();

    String getTTlivePlayerHashCode();

    Pair<Integer, Integer> getVideoSize();

    Surface getViewSurface();

    SurfaceTexture getViewSurfaceTexture();

    int getVoiceDB();

    String identifier();

    boolean isPlaying();

    boolean isPrePrepare();

    boolean isSupportResolutionSwitch(String r1);

    boolean isTextureRender();

    boolean isVideoHorizontal();

    void logEnd();

    void setEnableBackgroundStop(boolean r1);

    void setHasFirstFrameCacheForSurfaceView(boolean r1);

    void setLiveLiteEnterRoomOpt(boolean r1);

    void setReleaseCalled(boolean r1);

    void setShouldDestroy(boolean r1);

    void setVideoSize(Pair<Integer, Integer> r1);

    boolean supportHardwareBufferOutput();

    void updateIdentifier(String r1);
}
