package jc2;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.o;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements j {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(f<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "textMessage");
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.a) == true) goto L5;
        r5 = null;
    L5:
        com.bytedance.android.livesdk.interactivity.textmessage.model.a r6 = (com.bytedance.android.livesdk.interactivity.textmessage.model.a) r5;
        if (r6 == null) goto L24;
        o r7 = r6.b;
        if (r7 == null) goto L26;
        m0 r8 = r7.getBaseMessage();
        if (r8 == null) goto L27;
        long r2 = Long.valueOf(r8.getRoomId()).longValue();
        IRoomContextService r9 = k.f(IRoomContextService.class);
        if (r9 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.o r10 = r9.getRoomDataContext(null, r2);
        if (r10 == null) goto L29;
        m r11 = r10.getRoom();
        if (r11 == null) goto L30;
        IRoom r13 = (IRoom) r11.getValue();
        if (r13 == null) goto L31;
        IBaseUser r14 = r13.getOwner();
        if (r14 != null) goto L22;
        return false;
    L22:
        if (r14.getSecret() != 1) goto L33;
        return true;
    L33:
        return false;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L24:
        return false;
    }
}
