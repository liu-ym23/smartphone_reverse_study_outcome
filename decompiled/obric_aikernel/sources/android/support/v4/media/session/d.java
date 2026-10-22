package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class d {

    static class a {
        public static Object a(Object r10, long r11) {
            return new MediaSession.QueueItem((MediaDescription) r10, r11);
        }

        public static Object b(Object r10) {
            return ((MediaSession.QueueItem) r10).getDescription();
        }

        public static long c(Object r10) {
            return ((MediaSession.QueueItem) r10).getQueueId();
        }
    }

    public static Object a(Object r10) {
        if ((r10 instanceof MediaSession.Token) == false) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
