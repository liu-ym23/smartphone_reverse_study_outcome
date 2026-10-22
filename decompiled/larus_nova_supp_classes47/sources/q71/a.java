package q71;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdk.message.model.e3;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends b {

    /* JADX INFO: renamed from: q71.a$a, reason: collision with other inner class name */
    public static final class C0298a {
        public static /* synthetic */ d a(a r1, e3 r2) {
            return r1.c(r2, MsgWindowPosition.BOTTOM_RIGHT);
        }
    }

    @Override // q71.b
    d a();

    d<f> c(e3 r1, MsgWindowPosition r2);
}
