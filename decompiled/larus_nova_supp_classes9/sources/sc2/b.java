package sc2;

import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ a.C0280a b;

    public b(a r1, a.C0280a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        com.bytedance.android.livesdk.interactivity.virtualinteract.model.a r9 = (com.bytedance.android.livesdk.interactivity.virtualinteract.model.a) ((BaseResponse) ((Response) r8)).data;
        if (r9 != null) goto L6;
        this.a.finishWithFailure();
        return;
    L6:
        if (Intrinsics.areEqual(r9.b(), Boolean.TRUE) == false) goto L11;
        this.a.finishWithResult(new com.bytedance.android.livesdk.interactivity.virtualinteract.model.d(null));
        String r10 = r9.c();
        if (r10 != null) goto L10;
        r10 = s1.B(2131923692);
    L10:
        f2.c(r10, 0);
        return;
    L11:
        this.a.finishWithResult(new com.bytedance.android.livesdk.interactivity.virtualinteract.model.d(new com.bytedance.android.livesdk.interactivity.virtualinteract.model.b(r9.d(), r9.a())));
        Text r11 = r9.e();
        if (r11 == null) goto L55;
        List r0 = r11.getPieces();
        if (r0 == null) goto L30;
        Iterator<T> r1 = r0.iterator();
    L17:
        if (r1.hasNext() == false) goto L24;
        T r3 = r1.next();
        if (((c5) r3).getType() != PieceType.USER.getPieceType()) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L17;
    L25:
        c5 r5 = (c5) r3;
        if (r5 == null) goto L30;
        i5 r2 = r5.getUserValue();
        if (r2 == null) goto L30;
        IBaseUser r6 = r2.getUser();
    L31:
        int r7 = s.k;
        PublicScreenConfig$MessageModelType r13 = PublicScreenConfig$MessageModelType.VIRTUAL_INTERACT;
        if ((r6 instanceof User) == true) goto L34;
        r6 = null;
    L34:
        u r14 = s.b.c(r13, r11, (User) r6, PSMessageAction.SYSTEM);
        RoomContext.a r15 = RoomContext.Companion;
        Long r16 = this.b.b();
        if (r16 == null) goto L37;
        long r17 = r16.longValue();
    L38:
        r15.getClass();
        RoomContext r18 = RoomContext.a.a(null, r17);
        if (r18 == null) goto L56;
        h r19 = i.c(r18);
        if (r19 == null) goto L57;
        j<l> r20 = r19.getPublicScreenContext();
        if (r20 == null) goto L58;
        l r21 = (l) r20.getValue();
        if (r21 == null) goto L59;
        r21.insertMessage(r14);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L37:
        r17 = 0;
        goto L38
    L21:
        r4 = false;
        goto L22
    L24:
        r3 = null;
    L30:
        r6 = null;
        goto L31
    }
}
