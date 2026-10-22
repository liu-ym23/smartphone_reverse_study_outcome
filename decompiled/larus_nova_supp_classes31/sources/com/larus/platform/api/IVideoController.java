package com.larus.platform.api;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface IVideoController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/IVideoController$MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO", "VOICE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum MediaType extends Enum<MediaType> {
        public static final MediaType VIDEO = null;
        public static final MediaType VOICE = null;
        public static final /* synthetic */ MediaType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<MediaType> getEntries() {
            return b;
        }

        static {
            MediaType r0 = new MediaType("VIDEO", 0);
            VIDEO = r0;
            MediaType r1 = new MediaType("VOICE", 1);
            VOICE = r1;
            MediaType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static MediaType[] values() {
            return (MediaType[]) a.clone();
        }

        public static MediaType valueOf(String r1) {
            return (MediaType) r27.a.a(MediaType.class, r1);
        }

        public MediaType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/IVideoController$PlayType;", "", "<init>", "(Ljava/lang/String;I)V", "PLAY", "PREPARE", "PAUSE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum PlayType extends Enum<PlayType> {
        public static final PlayType PAUSE = null;
        public static final PlayType PLAY = null;
        public static final PlayType PREPARE = null;
        public static final /* synthetic */ PlayType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PlayType> getEntries() {
            return b;
        }

        static {
            PlayType r0 = new PlayType("PLAY", 0);
            PLAY = r0;
            PlayType r1 = new PlayType("PREPARE", 1);
            PREPARE = r1;
            PlayType r3 = new PlayType("PAUSE", 2);
            PAUSE = r3;
            PlayType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PlayType[] values() {
            return (PlayType[]) a.clone();
        }

        public static PlayType valueOf(String r1) {
            return (PlayType) r27.a.a(PlayType.class, r1);
        }

        public PlayType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IVideoController r7, com.larus.video.impl.sdk.a r8, long r9, int r11) {
            if ((r11 & 4) == 0) goto L5;
            r9 = 512000;
        L5:
            long r3 = r9;
            if ((r11 & 8) == 0) goto L8;
            DataLoaderPreloadPriority r10 = DataLoaderPreloadPriority.DEFAULT;
        L9:
            r7.m(r8, null, r3, r10, null);
            return;
        L8:
            r10 = null;
            goto L9
        }
    }

    void A(int r1, l0 r2);

    void B(float r1, float r2);

    void C(boolean r1);

    void D(VideoEngineMusicPlayerViewImpl.h r1, String r2);

    void E(String r1);

    boolean F(String r1);

    int G(VideoEngineState r1);

    void H(n r1);

    void I(boolean r1);

    n a();

    void b();

    void c(float r1);

    PlayType d();

    int e(com.larus.video.impl.sdk.a r1);

    void f(String r1, l4 r2);

    float g();

    String getBotId();

    int getCurrentPlaybackTime();

    String getCurrentResolution();

    String getMediaId();

    int getWatchedDuration();

    void h(k4 r1);

    void i(int r1);

    boolean isReleased();

    void j(p0 r1, boolean r2);

    void k(String r1);

    void l();

    void m(com.larus.video.impl.sdk.a r1, String r2, long r3, DataLoaderPreloadPriority r5, k0 r6);

    int n();

    int o();

    void p(n0 r1);

    boolean p3();

    void play();

    void q(VideoEngineMusicPlayerViewImpl.h r1, String r2);

    void r(String r1);

    void release();

    void releaseSurface();

    void s(o0 r1);

    void setDirectURL(String r1);

    void setDirectUrlUseDataLoader(String r1, String r2);

    void setLocalURL(String r1);

    void setLooping(boolean r1);

    void setStartTime(int r1);

    void setSubTag(String r1);

    void setSurface(Surface r1);

    void setSurfaceHolder(SurfaceHolder r1);

    void stop();

    void t();

    List<String> u();

    boolean v();

    void w(int r1);

    void x(String r1);

    void y(boolean r1, String r2);

    boolean z();
}
