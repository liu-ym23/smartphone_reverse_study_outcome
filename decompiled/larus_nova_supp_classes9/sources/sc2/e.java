package sc2;

import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.u;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ d.a b;

    public e(d r1, d.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        com.bytedance.android.livesdk.interactivity.virtualinteract.model.c r8 = (com.bytedance.android.livesdk.interactivity.virtualinteract.model.c) ((BaseResponse) ((Response) r7)).data;
        if (r8 != null) goto L5;
        this.a.finishWithResult(null);
        return;
    L5:
        this.a.finishWithResult(new com.bytedance.android.livesdk.interactivity.virtualinteract.model.d(new com.bytedance.android.livesdk.interactivity.virtualinteract.model.b(r8.b(), r8.a())));
        Text r9 = r8.c();
        if (r9 == null) goto L48;
        List r1 = r9.getPieces();
        if (r1 == null) goto L24;
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L18;
        T r3 = r2.next();
        if (((c5) r3).getType() != PieceType.USER.getPieceType()) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L11;
    L19:
        c5 r5 = (c5) r3;
        if (r5 == null) goto L24;
        i5 r6 = r5.getUserValue();
        if (r6 == null) goto L24;
        IBaseUser r10 = r6.getUser();
    L25:
        int r11 = s.k;
        PublicScreenConfig$MessageModelType r13 = PublicScreenConfig$MessageModelType.VIRTUAL_INTERACT;
        if ((r10 instanceof User) == true) goto L28;
        r10 = null;
    L28:
        u r14 = s.b.c(r13, r9, (User) r10, PSMessageAction.SYSTEM);
        RoomContext.a r15 = RoomContext.Companion;
        Long r16 = this.b.c();
        if (r16 == null) goto L31;
        long r17 = r16.longValue();
    L32:
        r15.getClass();
        RoomContext r0 = RoomContext.a.a(null, r17);
        if (r0 == null) goto L49;
        h r18 = i.c(r0);
        if (r18 == null) goto L50;
        j<l> r19 = r18.getPublicScreenContext();
        if (r19 == null) goto L51;
        l r20 = (l) r19.getValue();
        if (r20 == null) goto L52;
        r20.insertMessage(r14);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L31:
        r17 = 0;
        goto L32
    L15:
        r4 = false;
        goto L16
    L18:
        r3 = null;
    L24:
        r10 = null;
        goto L25
    }
}
