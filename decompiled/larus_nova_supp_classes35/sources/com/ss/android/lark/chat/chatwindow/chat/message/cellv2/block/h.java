package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends OnSingleClickListener {
    public final /* synthetic */ AvatarBlock a;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> b;
    public final /* synthetic */ y6b.a<?> c;
    public final /* synthetic */ y6b.b d;
    public final /* synthetic */ AvatarBlock.a e;

    public final void onSingleClick(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        boolean r1 = true;
        if (r9.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        e6b.b r3 = null;
        if (r0 == true) goto L9;
    L45:
        com.ss.android.lark.blueprint.m<y6b.a<?>> r10 = this.b;
        if ((r10 instanceof e6b.b) == false) goto L48;
        r3 = (e6b.b) r10;
    L48:
        if (r3 == null) goto L52;
        r3.j(this.a, this.c);
        return;
    L52:
        return;
    L9:
        if (this.a.c.s8() == true) goto L45;
        rcc.e.a.a.getClass();
        r9.getLocationInWindow(new int[2]);
        r9.getTop();
        r9.getRight();
        r9.getWidth();
        r9.getHeight();
        r9.getLocationOnScreen(new int[2]);
        if (this.d.x == false) goto L15;
        Log.i("AvatarBlock", "chatter is anonymous block avatar click");
        return;
    L15:
        com.ss.android.lark.biz.im.api.message.params.c r11 = this.a.c.d0(com.ss.android.lark.biz.im.api.message.params.c.class);
        if (r11 == null) goto L18;
        boolean r12 = r11.a;
    L20:
        if (this.a.c.j5().b(mya.l.class) == null) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L25;
    L28:
        boolean r5 = true;
    L29:
        if (r5 == true) goto L31;
    L37:
        ChatHitPointNew.f(this.a.c.getChat(), "icon", ChatHitPointNew.c("icon"), ChatHitPointNew.b(this.a.c, this.c, null, null, null));
        ImageView r13 = this.e.b.getDecorationView();
        if (r13 == null) goto L51;
        y6b.b r6 = this.d;
        if (r13.getDrawable() != null) goto L43;
        r1 = false;
    L43:
        String r14 = com.ss.android.lark.utils.y.b(r6.a);
        Intrinsics.checkNotNullParameter(r14, "toUserId");
        JSONObject r15 = new JSONObject().put("click", "icon").put("is_medal", String.valueOf(r1)).put("target", "profile_main_view").put("to_user_id", r14);
        ChatHitPointNew.d().sendEvent("im_chat_main_click", r15);
        return;
    L51:
        return;
    L31:
        if (this.d.r == false) goto L37;
        if (r12 == false) goto L37;
        if (this.a.c.e0() == false) goto L36;
        w4b.b0 r16 = ChatCoreModule.a().getProfileDependency();
        Context r7 = this.a.getContext();
        ProfileSource.a r8 = new ProfileSource.a();
        y6b.b r17 = this.d;
        r8.e = r17.a;
        r8.g = r17.j;
        r8.d = this.a.c.getChatId();
        r8.a = 2;
        r8.b = 0;
        r8.c = com.ss.android.lark.chat.utils.k.a(this.a.c.getChat());
        r16.e(r7, new ProfileSource(r8));
        goto L37
    L36:
        ChatCoreModule.a().getProfileDependency().b(this.a.getContext(), this.d, this.a.c.getChat());
        goto L37
    L25:
        if (this.a.d != null) goto L28;
        r5 = false;
        goto L29
    L22:
        r4 = false;
        goto L23
    L18:
        r12 = true;
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    public h(AvatarBlock r1, com.ss.android.lark.blueprint.m<y6b.a<?>> r2, y6b.a<?> r3, y6b.b r4, AvatarBlock.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
