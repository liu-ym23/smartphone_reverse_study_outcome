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
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class c {

    public interface a {
        void M(Bundle r10);

        void Q(List<?> r10);

        void a(Object r10);

        void b(int r10, int r11, int r12, int r13, int r14);

        void c(Object r10);

        void d(String r10, Bundle r11);

        void j0(CharSequence r10);

        void k0();
    }

    static class b<T extends a> extends MediaController.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f206a;

        public b(T r10) {
            this.f206a = r10;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r10) {
            this.f206a.b(r10.getPlaybackType(), C0012c.b(r10), r10.getVolumeControl(), r10.getMaxVolume(), r10.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r10) {
            MediaSessionCompat.a(r10);
            this.f206a.M(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r10) {
            this.f206a.a(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r10) {
            this.f206a.c(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r10) {
            this.f206a.Q(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r10) {
            this.f206a.j0(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f206a.k0();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r10, Bundle r11) {
            MediaSessionCompat.a(r11);
            this.f206a.d(r10, r11);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.c$c, reason: collision with other inner class name */
    public static class C0012c {
        public static AudioAttributes a(Object r10) {
            return ((MediaController.PlaybackInfo) r10).getAudioAttributes();
        }

        public static int b(Object r10) {
            return c(a(r10));
        }

        private static int c(AudioAttributes r10) {
            if ((r10.getFlags() & 1) != 1) goto L7;
            return 7;
        L7:
            if ((r10.getFlags() & 4) != 4) goto L10;
            return 6;
        L10:
            int r11 = r10.getUsage();
            if (r11 == 13) goto L24;
            switch(r11) {
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
    }

    public static Object a(a r10) {
        return new b(r10);
    }

    public static boolean b(Object r10, KeyEvent r11) {
        return ((MediaController) r10).dispatchMediaButtonEvent(r11);
    }

    public static Object c(Context r10, Object r11) {
        return new MediaController(r10, (MediaSession.Token) r11);
    }

    public static void d(Object r10, String r11, Bundle r12, ResultReceiver r13) {
        ((MediaController) r10).sendCommand(r11, r12, r13);
    }
}
