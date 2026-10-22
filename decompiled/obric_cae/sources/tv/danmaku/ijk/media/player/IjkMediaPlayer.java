package tv.danmaku.ijk.media.player;

import android.os.Bundle;
import android.support.v4.media.a;
import android.view.Surface;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* JADX INFO: loaded from: classes2.dex */
public final class IjkMediaPlayer extends a {
    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int r8);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int r8, float r10);

    private native long _getPropertyLong(int r8, long r10);

    private native String _getVideoCodecInfo();

    private native void _pause();

    private native void _release();

    private native void _reset();

    private native void _setDataSource(String r8, String[] r10, String[] r11);

    private native void _setDataSource(IMediaDataSource r8);

    private native void _setDataSourceFd(int r8);

    private native void _setLoopCount(int r8);

    private native void _setOption(int r8, String r10, long r11);

    private native void _setOption(int r8, String r10, String r11);

    private native void _setPropertyFloat(int r8, float r10);

    private native void _setPropertyLong(int r8, long r10);

    private native void _setStreamSelected(int r8, boolean r10);

    private native void _setVideoSurface(Surface r8);

    private native void _start();

    private native void _stop();

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object r8);

    public static native void native_profileBegin(String r8);

    public static native void native_profileEnd();

    private static native void native_setIsUploadLog(int r8);

    public static native void native_setLogLevel(int r8);

    private static native void native_setNetControl(int r8);

    private static native void native_setTcpReadTimeOut(int r8);

    private native void native_setup(Object r8);

    public native void _prepareAsync();

    public final void finalize() {
        super.finalize();
        native_finalize();
    }

    public native int getAudioSessionId();

    public native long getCurrentPosition();

    public native long getDuration();

    public native boolean isPlaying();

    public native void seekTo(long r8);

    public native void setVolume(float r8, float r10);
}
