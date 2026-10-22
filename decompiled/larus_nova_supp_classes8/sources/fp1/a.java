package fp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.PanelButtonStatusSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h a(Object r3) {
        if ((r3 instanceof mk1.a) == false) goto L17;
        mk1.a r4 = (mk1.a) r3;
        int r1 = r4.a;
        if (r1 != 3) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L13;
        IRoomAuthStatusStyle r5 = r4.c;
        if (r5 == null) goto L13;
        String r6 = r5.getContent();
        if (r6 == null) goto L13;
    L15:
        return new h(r1, PanelButtonStatusSource.ROOM_AUTH, r6);
    L13:
        r6 = "";
        goto L15
    L7:
        r2 = false;
        goto L8
    L17:
        if ((r3 instanceof h) == true) goto L19;
        return null;
    L19:
        return (h) r3;
    }
}
