package jc2;

import aa2.r;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.q;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.interactivity.textmessage.model.k;
import com.bytedance.android.livesdk.interactivity.textmessage.model.l;
import com.bytedance.android.livesdk.interactivity.textmessage.model.m;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import ec2.s1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements j {
    public final int a;
    public final IRoom b;
    public final boolean c;
    public final Function0<Long> d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(f<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "textMessage");
        if ((r11 instanceof z) == false) goto L5;
        return false;
    L5:
        o7 r0 = r11.b;
        if (this.c == true) goto L8;
    L14:
        boolean r2 = false;
    L15:
        if (r0 != null) goto L17;
    L98:
        return true;
    L17:
        if (r0.isCurrentRoom(this.b.getId()) == true) goto L20;
        if (r2 == false) goto L98;
    L20:
        if (r0.canText() == false) goto L98;
        if ((r11 instanceof m) == false) goto L25;
    L28:
        boolean r3 = true;
    L29:
        if (r3 == true) goto L31;
    L35:
        if (r3 == true) goto L39;
        if ((r11 instanceof k) == true) goto L39;
    L41:
        String r13 = r0.getMessageMethod();
        if (r13 == null) goto L112;
        h1 r6 = null;
        switch(r13.hashCode()) {
            case -1441604104: goto L95;
            case -414786051: goto L84;
            case 539087825: goto L75;
            case 799725124: goto L48;
            default: goto L113;
        };
    L113:
        return false;
    L48:
        if (r13.equals("WebcastGiftMessage") == false) goto L99;
        o7 r1 = r0;
        boolean r14 = r1.isBannedInChat();
        if (r1.getClientGiftSource() != 1) goto L52;
    L55:
        r6 = r1.getGift();
    L56:
        if (r6 != null) goto L58;
        boolean r4 = h.a;
        r6 = h.d(ca0.j.class).findLiteGiftById(r1.getGiftId());
    L58:
        if (r6 == null) goto L102;
        if (r6.getRepeat() == true) goto L66;
        if (r6.getType() == 11) goto L66;
        if (r6.getType() != 15) goto L102;
    L66:
        if (r6.getType() != 15) goto L72;
        Intrinsics.checkNotNullParameter(r1, "$this$chatFromServer");
        if ((r1.getForceDisplayEffects() & 1) == 0) goto L70;
        boolean r15 = true;
    L71:
        if (r15 == false) goto L72;
        return false;
    L70:
        r15 = false;
    L72:
        return true;
    L102:
        return r14;
    L52:
        if (r1.getClientGiftSource() != 0) goto L56;
        if (r1.getGift() == null) goto L56;
    L99:
        return false;
    L75:
        if (r13.equals("WebcastLuckyBoxMessage") == false) goto L103;
        IRoomContextService r16 = jc1.k.f(IRoomContextService.class);
        if (r16 == null) goto L104;
        o r17 = IRoomContextService.a.a(r16, null, this.b.getId(), 1);
        if (r17 == null) goto L105;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L106;
        IRoom r19 = (IRoom) r18.getValue();
        return false;
    L106:
        return false;
    L105:
        return false;
    L104:
        return false;
    L103:
        return false;
    L84:
        if (r13.equals("WebcastLikeMessage") == false) goto L108;
        IRoomContextService r110 = jc1.k.f(IRoomContextService.class);
        if (r110 == null) goto L92;
        o r111 = IRoomContextService.a.a(r110, null, this.b.getId(), 1);
        if (r111 == null) goto L92;
        com.bytedance.live.datacontext.m r112 = r111.getRoom();
        if (r112 == null) goto L92;
        r6 = (IRoom) r112.getValue();
    L92:
        if (r6 != null) goto L110;
        return false;
    L110:
        return r6.isD3Room();
    L108:
        return false;
    L95:
        if (r13.equals("GiftGroupMessage") == true) goto L97;
        return false;
    L97:
        return ((kc2.b) r0).j;
    L112:
        return false;
    L39:
        if (q.a() == true) goto L41;
        return true;
    L31:
        if (((Boolean) s1.a.getValue()).booleanValue() == false) goto L35;
        if (this.b.getGiftMessageStyle() != this.a) goto L35;
        return true;
    L25:
        if ((r11 instanceof l) == true) goto L28;
        r3 = false;
        goto L29
    L8:
        if (((Number) this.d.invoke()).longValue() <= 0) goto L14;
        if (((u) b4.a.getValue()).f() == false) goto L14;
        if (r0.isCurrentRoom(((Number) this.d.invoke()).longValue()) == false) goto L14;
        r2 = true;
        goto L15
    }

    public b(IRoom r2, boolean r3, r r4) {
        Intrinsics.checkNotNullParameter(r2, "currRoom");
        Intrinsics.checkNotNullParameter(r4, "otherRoomGetter");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = 1;
    }
}
