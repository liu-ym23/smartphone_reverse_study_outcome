package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class d {

    static class a {
        public static Object a(Object r2) {
            return ((MediaSession.QueueItem) ZeusTransformUtils.preCheckCast(r2, MediaSession.QueueItem.class, "com.obric.memorydata.plugin")).getDescription();
        }

        public static Object a(Object r3, long r4) {
            return new MediaSession.QueueItem((MediaDescription) ZeusTransformUtils.preCheckCast(r3, MediaDescription.class, "com.obric.memorydata.plugin"), r4);
        }

        public static long b(Object r2) {
            return ((MediaSession.QueueItem) ZeusTransformUtils.preCheckCast(r2, MediaSession.QueueItem.class, "com.obric.memorydata.plugin")).getQueueId();
        }
    }

    public static Object a(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, MediaSession.Token.class) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
