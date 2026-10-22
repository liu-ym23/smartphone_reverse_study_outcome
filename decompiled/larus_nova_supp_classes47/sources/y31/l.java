package y31;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.link.model.o2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final boolean a(k r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$isDisableHandle");
        a9 r3 = null;
        if (r8 != 1) goto L57;
        m2 r9 = r7.a;
        if (r9 == null) goto L14;
        String r10 = r9.getLinkText();
        if (r10 == null) goto L14;
        if (r10.length() <= 0) goto L11;
        boolean r12 = true;
    L12:
        if (r12 != true) goto L14;
        return true;
    L11:
        r12 = false;
    L14:
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r5).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r13);
        IBaseUser r14 = ((com.bytedance.live.kmp.core.c) r13).b();
        if (r14 == null) goto L17;
        String r15 = r14.getIdString();
    L18:
        IRoom r6 = r7.b;
        if (r6 == null) goto L23;
        IBaseUser r16 = r6.getOwnerKt();
        if (r16 == null) goto L23;
        String r17 = r16.getIdString();
    L25:
        if (Intrinsics.areEqual(r15, r17) == false) goto L27;
        return true;
    L27:
        m2 r18 = r7.a;
        if (r18 == null) goto L34;
        n2 r19 = r18.getInviteButton();
        if (r19 == null) goto L34;
        if (r19.getForbidden() != true) goto L34;
        return true;
    L34:
        m2 r20 = r7.a;
        if (r20 != null) goto L37;
    L94:
        return false;
    L37:
        if (o2.a(r20) != true) goto L94;
        vh7.c r22 = r7.b;
        if (r22 == null) goto L43;
        IRoomLinkExt r23 = (IRoomLinkExt) r22.castTo(IRoomLinkExt.class);
        if (r23 == null) goto L43;
        r3 = r23.getLinkMicInfo();
    L43:
        if (r3 != null) goto L56;
        IRoom r24 = r7.b;
        if (r24 == null) goto L50;
        Map r25 = IRoomKt_androidKt.getLinkMapKt(r24);
        if (r25 == null) goto L50;
        if (r25.containsKey(String.valueOf(8)) == true) goto L56;
    L50:
        IRoom r26 = r7.b;
        if (r26 == null) goto L94;
        Map r27 = IRoomKt_androidKt.getLinkMapKt(r26);
        if (r27 == null) goto L94;
        if (r27.containsKey(String.valueOf(7)) != true) goto L94;
    L56:
        return true;
    L23:
        r17 = null;
        goto L25
    L17:
        r15 = null;
        goto L18
    L57:
        m2 r28 = r7.a;
        if (r28 == null) goto L64;
        n2 r29 = r28.getInviteButton();
        if (r29 == null) goto L64;
        if (r29.getForbidden() != true) goto L64;
        return true;
    L64:
        vh7.c r30 = r7.b;
        if (r30 == null) goto L69;
        IRoomLinkExt r32 = (IRoomLinkExt) r30.castTo(IRoomLinkExt.class);
        if (r32 == null) goto L69;
        r3 = r32.getLinkMicInfo();
    L69:
        if (r3 != null) goto L95;
        IRoom r33 = r7.b;
        if (r33 == null) goto L80;
        Map r34 = IRoomKt_androidKt.getLinkMapKt(r33);
        if (r34 == null) goto L80;
        if (r34.containsKey(String.valueOf(8)) != true) goto L80;
        oq2.c r35 = vh6.c.b(qr2.c.class).Qd();
        if (r35 == null) goto L80;
        if (r35.a() == true) goto L95;
    L80:
        IRoom r36 = r7.b;
        if (r36 == null) goto L87;
        Map r37 = IRoomKt_androidKt.getLinkMapKt(r36);
        if (r37 == null) goto L87;
        if (r37.containsKey(String.valueOf(7)) == true) goto L95;
    L87:
        IRivalExtraInfo r38 = r7.f;
        if (r38 == null) goto L94;
        com.bytedance.android.livesdk.link.model.h r39 = r38.getAnchorBattleSetting();
        if (r39 == null) goto L94;
        if (r39.isTurnOn() == true) goto L94;
        return true;
    L95:
        return true;
    }
}
