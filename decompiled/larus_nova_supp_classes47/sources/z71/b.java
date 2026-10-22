package z71;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final a a(RoomContext r2) {
        ViewModel r0 = null;
        if (r2 == null) goto L7;
        j r3 = r2.getRotateContext();
        if (r3 == null) goto L7;
        ViewModel r4 = (ViewModel) r3.getValue();
    L9:
        if ((r4 instanceof a) == false) goto L13;
        r0 = r4;
    L13:
        return (a) r0;
    L7:
        r4 = null;
        goto L9
    }
}
