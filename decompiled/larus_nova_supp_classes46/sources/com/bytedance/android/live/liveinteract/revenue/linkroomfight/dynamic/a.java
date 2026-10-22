package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import android.text.SpannableString;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements q {
    public final /* synthetic */ DynamicLinkRoomFightWidget a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ eb c;

    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public final void b(SpannableString r14, q.a r15) {
        Intrinsics.checkNotNullParameter(r14, "spannable");
        Intrinsics.checkNotNullParameter(r15, "info");
        if (((Widget) this.a).isDestroyed == false) goto L5;
        return;
    L5:
        Ref.ObjectRef r16 = this.b;
        r16.element = new pp1.c(null, this.c.getRichText(), this.c.getSchema(), 10, null, null, 1, 0, this.c.getExtra(), 0, 7856);
        pp1.c r17 = (pp1.c) this.b.element;
        if (r17 == null) goto L9;
        r17.a = r14;
    L9:
        if (gh0.a.d() == false) goto L15;
        if (this.c.getAnchorShowPosition() != 1) goto L13;
        ((Widget) this.a).dataCenter.put("cmd_show_self_bubble_on_scene_game", (pp1.c) this.b.element);
        return;
    L13:
        ((Widget) this.a).dataCenter.put("cmd_show_self_bubble_on_openplatform_behavior", (pp1.c) this.b.element);
        return;
    L15:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L20;
        y3.m(((Widget) this.a).dataCenter).b(ToolbarButton.MORE, (pp1.c) this.b.element);
        return;
    }

    public a(DynamicLinkRoomFightWidget r1, Ref.ObjectRef r2, eb r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
