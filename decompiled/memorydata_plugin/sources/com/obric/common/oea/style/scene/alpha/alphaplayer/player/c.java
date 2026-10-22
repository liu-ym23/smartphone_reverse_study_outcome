package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.view.Surface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0004$%&'J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0010H&J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020\u0007H&J\b\u0010#\u001a\u00020\u0007H&¨\u0006("}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;", "", "getPlayerType", "", "getVideoInfo", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/VideoInfo;", "initMediaPlayer", "", "pause", "prepareAsync", "release", "reset", "setDataSource", "dataPath", "setLooping", "looping", "", "setOnCompletionListener", "completionListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "setOnErrorListener", "errorListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "setOnFirstFrameListener", "firstFrameListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "setOnPreparedListener", "preparedListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "setScreenOnWhilePlaying", "onWhilePlaying", "setSurface", "surface", "Landroid/view/Surface;", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "OnCompletionListener", "OnErrorListener", "OnFirstFrameListener", "OnPreparedListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface c {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "", "onCompletion", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface a {
        void a();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "", "onError", "", "what", "", WsConstants.KEY_EXTRA, "desc", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface b {
        void a(int r1, int r2, String r3);
    }

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.player.c$c, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "", "onFirstFrame", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface InterfaceC0380c {
        void a();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "", "onPrepared", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface d {
        void a();
    }

    void a(Surface r1);

    void a(a r1);

    void a(b r1);

    void a(InterfaceC0380c r1);

    void a(d r1);

    void a(String r1);

    void a(boolean r1);

    void b(boolean r1);

    void e();

    void f();

    void g();

    void h();

    void i();

    void j();

    void k();

    com.obric.common.oea.style.scene.alpha.alphaplayer.model.c l();

    String m();
}
