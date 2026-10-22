package com.bytedance.android.livesdk.interactivity.medialink.contract;

import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.widget.RevMediaLinkInternalServiceContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {
    public static final C0183a Q0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.medialink.contract.a$a, reason: collision with other inner class name */
    public static final class C0183a {
        public static final /* synthetic */ C0183a a = null;

        public C0183a() {
        }

        static {
            a = new C0183a();
        }

        public static a a() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L21;
            m r1 = r0.getRoom();
            if (r1 == null) goto L22;
            Room r2 = (Room) r1.getValue();
            if (r2 != null) goto L9;
            return null;
        L9:
            if (r2.isMediaRoom() == false) goto L15;
            DataContext r3 = com.bytedance.live.datacontext.d.d("IMediaRoomService");
            if ((r3 instanceof MediaRoomContext) == true) goto L13;
            return null;
        L13:
            return (a) ((MediaRoomContext) r3).getLinkInternalService().getValue();
        L15:
            RevMediaLinkInternalServiceContext r4 = RevMediaLinkInternalServiceContext.Companion.getContext();
            if (r4 == null) goto L24;
            j<a> r5 = r4.getService();
            if (r5 != null) goto L20;
            return null;
        L20:
            return (a) r5.getValue();
        L24:
            return null;
        L22:
            return null;
        L21:
            return null;
        }
    }

    static {
        Q0 = C0183a.a;
    }

    void K4(int r1);

    LiveWidget Yf();

    void Zh();

    int getCurrentMode();

    void gq(e r1);

    boolean k0(int r1);

    void m();

    void onClickLinkIcon();

    void onMultiAnchorStateChange(int r1);

    DialogFragment rg();
}
