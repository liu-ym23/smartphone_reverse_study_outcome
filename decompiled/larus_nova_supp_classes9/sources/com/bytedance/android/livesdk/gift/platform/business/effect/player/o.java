package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttm.player.IMediaDataSource;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.MediaPlayerClient;
import com.ss.ttm.player.MediaTransport;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TraitObject;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements MediaPlayer {
    public MediaPlayerClient a;

    public final /* synthetic */ void preDemux() {
        MediaPlayer.-CC.$default$preDemux(this);
    }

    public final void selectTrack(int r1) {
    }

    public final void setDataSource(IMediaDataSource r1) throws IllegalArgumentException, IOException {
    }

    public final void setDataSource(FileDescriptor r1, long r2, long r4) throws IllegalStateException, IllegalArgumentException, IOException {
    }

    public final /* synthetic */ void setFloatOptionArray(int[] r1, float[] r2) {
        MediaPlayer.-CC.$default$setFloatOptionArray(this, r1, r2);
    }

    public final /* synthetic */ void setIntOptionArray(int[] r1, int[] r2) {
        MediaPlayer.-CC.$default$setIntOptionArray(this, r1, r2);
    }

    public final /* synthetic */ void setLongOptionArray(int[] r1, long[] r2) {
        MediaPlayer.-CC.$default$setLongOptionArray(this, r1, r2);
    }

    public final void setMediaTransport(MediaTransport r1) {
    }

    public final /* synthetic */ void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r1, Handler r2) {
        MediaPlayer.-CC.$default$setOnImageAvailableListener(this, r1, r2);
    }

    public final void setOnSARChangedListener(MediaPlayer.onSARChangedListener r1) {
    }

    public final /* synthetic */ void setStringOptionArray(int[] r1, String[] r2) {
        MediaPlayer.-CC.$default$setStringOptionArray(this, r1, r2);
    }

    public final /* synthetic */ void setSurfaceTimeOut(Surface r1, int r2) {
        MediaPlayer.-CC.$default$setSurfaceTimeOut(this, r1, r2);
    }

    public final /* synthetic */ void setTraitObject(int r1, TraitObject r2) {
        MediaPlayer.-CC.$default$setTraitObject(this, r1, r2);
    }

    public final /* synthetic */ void setWindowClient(TTAVWindowClient r1) {
        MediaPlayer.-CC.$default$setWindowClient(this, r1);
    }

    public final void switchStream(int r1, int r2) {
    }

    public final int getCurrentPosition() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getCurrentPosition();
    }

    public final String getDataSource() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getDataSource();
    }

    public final int getDuration() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getDuration();
    }

    public final int getPlayerType() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getType();
    }

    public final MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L7;
        r0.getTrackInfo();
        return null;
    L7:
        return null;
    }

    public final int getVideoHeight() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getVideoHeight();
    }

    public final int getVideoType() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getVideoType();
    }

    public final int getVideoWidth() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getVideoWidth();
    }

    public final boolean isLooping() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isLooping();
    }

    public final boolean isMute() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isMute();
    }

    public final boolean isOSPlayer() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.getType() == 0) goto L8;
        return false;
    }

    public final boolean isPlaying() {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isPlaying();
    }

    public final void pause() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public final void prepare() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.prepare();
        return;
    }

    public final void prepareAsync() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.prepareAsync();
        return;
    }

    public final void prevClose() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.prevClose();
        return;
    }

    public final void release() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final void releaseAsync() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.releaseAsync();
        return;
    }

    public final void reset() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.reset();
        return;
    }

    public final void start() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    public final void stop() {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public o() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final void deselectTrack(int r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.deselectTrack(r2);
        return;
    }

    public final int getSelectedTrack(int r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L7;
        r0.getSelectedTrack(r2);
        return 0;
    L7:
        return 0;
    }

    public final String getStringOption(int r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getStringOption(r2);
    }

    public final void seekTo(int r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.seekTo(r2);
        return;
    }

    public final void setDataSource(String r2) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setDataSource(r2);
        return;
    }

    public final void setDisplay(SurfaceHolder r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setDisplay(r2);
        return;
    }

    public final void setIsMute(boolean r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setIsMute(r2);
        return;
    }

    public final void setLooping(boolean r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setLooping(r2);
        return;
    }

    public final void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnBufferingUpdateListener(r2);
        return;
    }

    public final void setOnCompletionListener(MediaPlayer.OnCompletionListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnCompletionListener(r2);
        return;
    }

    public final void setOnErrorListener(MediaPlayer.OnErrorListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnErrorListener(r2);
        return;
    }

    public final void setOnExternInfoListener(MediaPlayer.OnExternInfoListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnExternInfoListener(r2);
        return;
    }

    public final void setOnInfoListener(MediaPlayer.OnInfoListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnInfoListener(r2);
        return;
    }

    public final void setOnLogListener(MediaPlayer.OnLogListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnLogListener(r2);
        return;
    }

    public final void setOnPreparedListener(MediaPlayer.OnPreparedListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnPreparedListener(r2);
        return;
    }

    public final void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnSeekCompleteListener(r2);
        return;
    }

    public final void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnVideoSizeChangedListener(r2);
        return;
    }

    public final void setPanoVideoControlModel(int r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setPanoVideoControlModel(r2);
        return;
    }

    public final void setPlaybackParams(PlaybackParams r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setPlaybackParams(r2);
        return;
    }

    public final void setScreenOnWhilePlaying(boolean r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setScreenOnWhilePlaying(r2);
        return;
    }

    public final void setSurface(Surface r2) {
        if (r2 != null) goto L4;
    L5:
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L10;
        r0.setSurface(r2);
        return;
    L10:
        return;
    L4:
        if (r2.isValid() == true) goto L5;
    }

    public final void takeScreenshot(MediaPlayer.OnScreenshotListener r2) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.takeScreenshot(r2);
        return;
    }

    public final float getFloatOption(int r2, float r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.getFloatOption(r2, r3);
    }

    public final int getIntOption(int r2, int r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.getIntOption(r2, r3);
    }

    public final long getLongOption(int r2, long r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.getLongOption(r2, r3);
    }

    public final void rotateCamera(float r2, float r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.rotateCamera(r2, r3);
        return;
    }

    public final void setCacheFile(String r2, int r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setCacheFile(r2, r3);
        return;
    }

    public final void setDataSource(Context r2, Uri r3) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setDataSource(r2, r3);
        return;
    }

    public final int setFloatOption(int r2, float r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L7;
        r0.setFloatOption(r2, r3);
        return 0;
    L7:
        return 0;
    }

    public final void setIntOption(int r2, int r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setIntOption(r2, r3);
        return;
    }

    public final long setLongOption(int r2, long r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.setLongOption(r2, r3);
    }

    public final void setStringOption(int r2, String r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setStringOption(r2, r3);
        return;
    }

    public final void setVolume(float r2, float r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVolume(r2, r3);
        return;
    }

    public final void setWakeMode(Context r2, int r3) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setWakeMode(r2, r3);
        return;
    }

    public final void mouseEvent(int r2, int r3, int r4) {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.mouseEvent(r2, r3, r4);
        return;
    }

    public final void setDataSource(Context r2, Uri r3, Map<String, String> r4) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.setDataSource(r2, r3, r4);
        return;
    }
}
