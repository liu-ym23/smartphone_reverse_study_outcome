package yn0;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.message.model.kk;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements l81.r {
    public static final r a = null;

    public r() {
    }

    static {
        a = new r();
    }

    public final void a(DataContext r11, long r12, String r14, String r15) {
        if ((r11 instanceof RoomContext) == true) goto L5;
        return;
    L5:
        kk r13 = ag1.c.d(r12, null, "", 5, r14, "#FF8533", "7", "");
        r13.a = 2131251160;
        if (TextUtils.isEmpty(r15) == true) goto L8;
        r13.X(r15);
    L8:
        vlc.d r16 = n3.d((MiddlewareRoomContext) r11);
        if (r16 == null) goto L12;
        r16.j(r13, true);
        return;
    }
}
