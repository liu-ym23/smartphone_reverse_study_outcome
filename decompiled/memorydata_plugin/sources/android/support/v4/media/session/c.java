package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class c {

    public interface a {
        void a();

        void a(int r1, int r2, int r3, int r4, int r5);

        void a(Bundle r1);

        void a(CharSequence r1);

        void a(Object r1);

        void a(String r1, Bundle r2);

        void a(List<?> r1);

        void b(Object r1);
    }

    static class b<T extends a> extends MediaController.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f75a;

        public b(T r3) {
            this.f75a = (T) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r7) {
            this.f75a.a(r7.getPlaybackType(), C0014c.b(r7), r7.getVolumeControl(), r7.getMaxVolume(), r7.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r1) {
            MediaSessionCompat.a(r1);
            this.f75a.a(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r1) {
            this.f75a.b(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r1) {
            this.f75a.a(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r3) {
            List<?> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.f75a.a(r4);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.f75a.a(r4);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f75a.a();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r1, Bundle r2) {
            MediaSessionCompat.a(r2);
            this.f75a.a(r1, r2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.c$c, reason: collision with other inner class name */
    public static class C0014c {
        private static int a(AudioAttributes r3) {
            if ((r3.getFlags() & 1) != 1) goto L7;
            return 7;
        L7:
            if ((r3.getFlags() & 4) != 4) goto L10;
            return 6;
        L10:
            int r4 = r3.getUsage();
            if (r4 == 13) goto L24;
            switch(r4) {
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L17;
                case 8: goto L17;
                case 9: goto L17;
                case 10: goto L17;
                default: goto L13;
            };
        L13:
            return 3;
        L15:
            return 2;
        L17:
            return 5;
        L19:
            return 4;
        L20:
            return 8;
        L22:
            return 0;
        L24:
            return 1;
        }

        public static AudioAttributes a(Object r2) {
            return ((MediaController.PlaybackInfo) ZeusTransformUtils.preCheckCast(r2, MediaController.PlaybackInfo.class, "com.obric.memorydata.plugin")).getAudioAttributes();
        }

        public static int b(Object r0) {
            return a(a(r0));
        }
    }

    public static Object a(Context r3, Object r4) {
        return new MediaController((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (MediaSession.Token) ZeusTransformUtils.preCheckCast(r4, MediaSession.Token.class, "com.obric.memorydata.plugin"));
    }

    public static Object a(a r2) {
        return new b((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"));
    }

    public static void a(Object r2, String r3, Bundle r4, ResultReceiver r5) {
        ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.memorydata.plugin")).sendCommand(r3, r4, r5);
    }

    public static boolean a(Object r2, KeyEvent r3) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.memorydata.plugin")).dispatchMediaButtonEvent(r3);
    }
}
