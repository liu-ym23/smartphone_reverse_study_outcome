package wg0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ne0.a {
    public final /* synthetic */ e a;

    public c(e r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        e r4 = this.a;
        r4.getClass();
        m r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r5 == null) goto L15;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L15;
        if (r6.isLiveTypeAudio() != true) goto L15;
        j r7 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r7 == null) goto L22;
        f r8 = (f) r7.getValue();
        if (r8 == null) goto L22;
        i r9 = r8.t();
        if (r9 == null) goto L22;
        ClientUIInfo r10 = r9.a();
    L23:
        BaseMultiLinkWindowManager r11 = r4.g;
        int r0 = BaseMultiLinkWindowManager.H;
        r11.P0(r11.z.getUiLayout(), r10);
        return;
    L22:
        r10 = null;
    L15:
        j r12 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r12 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r12.getValue();
        if (r13 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r14 = r13.t();
        if (r14 == null) goto L22;
        r10 = r14.e;
        goto L23
    }
}
