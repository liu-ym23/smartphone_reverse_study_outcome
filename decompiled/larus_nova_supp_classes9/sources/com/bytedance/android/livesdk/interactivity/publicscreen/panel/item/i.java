package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends b {
    public final DataCenter f;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        return 2131565180;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b == true) goto L5;
        return false;
    L5:
        t r0 = this.c;
        User r3 = null;
        if ((r0 instanceof m4) == true) goto L8;
        r0 = null;
    L8:
        m4 r1 = (m4) r0;
        if (r1 == null) goto L11;
        IBaseUser r2 = r1.getUser();
    L13:
        if ((r2 instanceof User) == true) goto L16;
        r2 = null;
    L16:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.d((User) r2) == true) goto L39;
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 2);
        if (r4 == null) goto L23;
        m r5 = r4.getUser();
        if (r5 == null) goto L23;
        r3 = (User) r5.getValue();
    L23:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.d(r3) == true) goto L39;
        if (g() == false) goto L29;
        return true;
    L29:
        if (d() == false) goto L31;
        return false;
    L31:
        DataCenter r6 = this.f;
        m4 r7 = this.c;
        if (r7 == null) goto L38;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b(r6, r7.getUser()) == true) goto L36;
        return false;
    L36:
        return true;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ISupportLikeMessage");
    L39:
        return false;
    L11:
        r2 = null;
        goto L13
    }

    public final boolean g() {
        t r0 = this.c;
        if (r0 == null) goto L9;
        String r1 = r0.getMessageMethod();
        if (r1 == null) goto L9;
        if (r1.equals("WebcastSecretChatMessage") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public i(DataCenter r2) {
        super(AudiencePanelItemSymbol.SECRET_CHAT);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r8) {
        super.onClick(r8);
        IMiddlewareUserService r9 = k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L10;
        com.bytedance.android.livesdk.user.e r10 = r9.user();
        if (r10 == null) goto L10;
        IBaseUser r11 = r10.b();
        if (r11 == null) goto L10;
        String r13 = r11.getUserId();
        if (r13 == null) goto L10;
    L11:
        m4 r0 = this.c;
        if (r0 == null) goto L44;
        IBaseUser r1 = r0.getUser();
        if (r1 != null) goto L17;
        return;
    L17:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.b(r13, String.valueOf(r1.getUserId())) == false) goto L22;
        v r14 = this.d;
        if (r14 == null) goto L45;
        r14.l20(false);
        return;
    L45:
        return;
    L22:
        Long r2 = null;
        if (g() == false) goto L33;
        t r15 = this.c;
        if ((r15 instanceof i4) == true) goto L27;
        r15 = null;
    L27:
        i4 r16 = (i4) r15;
        if (r16 != null) goto L30;
    L32:
        OpenInputSource r17 = OpenInputSource.ReplySecretChat;
    L35:
        if (g() == false) goto L39;
        t r3 = this.c;
        if (r3 == null) goto L39;
        r2 = Long.valueOf(r3.getMessageId());
    L39:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.d(r1, r17, r2, 2);
        v r18 = this.d;
        if (r18 == null) goto L46;
        r18.l20(false);
        return;
    L46:
        return;
    L30:
        if (r16.getType() != 3) goto L32;
        r17 = OpenInputSource.ReplyHeartSecretChat;
        goto L35
    L33:
        r17 = OpenInputSource.SecretChat;
        goto L35
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ISupportLikeMessage");
    L10:
        r13 = BuildConfig.FLAVOR;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void b(t r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        super.b(r2, r3);
        if (g() == false) goto L5;
        f((String) ListProtector.get(this.e.getOutsideName(), 1));
        return;
    L5:
        f((String) ListProtector.get(this.e.getOutsideName(), 0));
    }
}
