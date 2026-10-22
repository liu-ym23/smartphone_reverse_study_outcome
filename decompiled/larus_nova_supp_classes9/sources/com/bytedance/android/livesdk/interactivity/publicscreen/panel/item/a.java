package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import u22.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends b {
    public final String f;

    public a() {
        super(AudiencePanelItemSymbol.AT);
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L9;
        String r3 = r2.getIdString();
    L10:
        this.f = r3;
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        if (this.e.getShowOutside() == false) goto L6;
        return 2131565169;
    L6:
        return 2131565170;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        t r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        t r1 = this.c;
        if ((r1 instanceof m4) == true) goto L10;
        r1 = null;
    L10:
        m4 r2 = (m4) r1;
        if (r2 != null) goto L13;
    L15:
        return true;
    L13:
        if (r2.isSecretChat() != true) goto L15;
        return false;
    L5:
        if (r0.isFromOtherIntercomRoom() != true) goto L7;
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r15) {
        super.onClick(r15);
        t r16 = this.c;
        Boolean r1 = null;
        if ((r16 instanceof u3) == true) goto L5;
        r16 = null;
    L5:
        u3 r17 = (u3) r16;
        if (r17 == null) goto L37;
        IBaseUser r18 = r17.getUserInMessage();
        if (r18 == null) goto L39;
        t r0 = this.c;
        if ((r0 instanceof h0) == true) goto L13;
        r0 = null;
    L13:
        h0 r2 = (h0) r0;
        if (r2 != null) goto L16;
        return;
    L16:
        xs2.b r3 = xs2.b.a();
        m r4 = new m(r18.getNickName());
        IBaseUser r5 = r2.getChatUserInfo();
        if ((r5 instanceof User) == true) goto L19;
        r5 = null;
    L19:
        User r6 = (User) r5;
        if (r6 == null) goto L23;
        String r7 = r6.getIdString();
        if (r7 == null) goto L23;
    L24:
        String r8 = r7;
        IRoomContextService r9 = k.f(IRoomContextService.class);
        if (r9 == null) goto L29;
        o r10 = IRoomContextService.a.a(r9, null, 0, 3);
        if (r10 == null) goto L29;
        r1 = r10.isAnchor();
    L29:
        m.a r11 = new m.a("message", Intrinsics.areEqual(r1, Boolean.TRUE), r8, 7, r18.getNickName(), r2.getPinBaseMessageId(), r2.getChatUserInfo().getWebcastUid());
        t r19 = this.c;
        if (r19 == null) goto L32;
        boolean r110 = r19.isFromOtherIntercomRoom();
    L33:
        r11.k = r110;
        r11.j = r2.getChatUserInfo();
        Unit r111 = Unit.INSTANCE;
        r4.e = r11;
        r4.l = OpenInputSource.AudiencePSDialogReply;
        r3.post(r4);
        v r112 = this.d;
        if (r112 == null) goto L38;
        r112.l20(false);
        return;
    L38:
        return;
    L32:
        r110 = false;
    L23:
        r7 = BuildConfig.FLAVOR;
        goto L24
    L39:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void b(t r4, v r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "bridge");
        super.b(r4, r5);
        if ((r4 instanceof h0) == true) goto L5;
        r4 = null;
    L5:
        h0 r6 = (h0) r4;
        if (r6 == null) goto L25;
        a5 r7 = r6.getRichText();
        if (r7 == null) goto L25;
        List r8 = r7.getPieces();
        if (r8 == null) goto L25;
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L25;
        c5 r1 = (c5) r9.next();
        if (r1.getUserValue() == null) goto L13;
        i5 r2 = r1.getUserValue();
        if (r2 == null) goto L13;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L13;
        String r10 = r3.getIdString();
        if (r10 == null) goto L13;
        if (r10.equals(this.f) != true) goto L13;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L32;
        f((String) ListProtector.get(this.e.getOutsideName(), 1));
        View r13 = this.a;
        if (r13 == null) goto L46;
        ImageView r14 = (ImageView) r13.findViewById(2131375773);
        if (r14 == null) goto L47;
        r14.setBackgroundResource(2131248667);
        return;
    L47:
        return;
    L46:
        return;
    L32:
        f((String) ListProtector.get(this.e.getOutsideName(), 0));
        return;
    L25:
        r11 = false;
        goto L26
    }
}
