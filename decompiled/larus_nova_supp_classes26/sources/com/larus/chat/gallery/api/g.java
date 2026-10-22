package com.larus.chat.gallery.api;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.o0;
import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class g<T> extends com.larus.gallery.api.t<T> {
    public LarusGalleryChatTitleBinding f;

    public abstract String B();

    public abstract bb9.a C();

    public abstract by7.e D();

    public void E() {
    }

    public abstract void F();

    public abstract void G();

    public final boolean n() {
        return false;
    }

    public View z() {
        List r4 = CollectionsKt.mutableListOf(new l0[]{new l0(2131906511, 2131906511, null, null, null, 2131103298, null, 2131241236, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127), new l0(2131906512, 2131906512, null, null, null, 2131103298, null, 2131242073, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)});
        Context r0 = getContext();
        if (r0 != null) goto L6;
        r0 = AppHost.a.getApplication();
    L6:
        return CreateMenu.f(new CreateMenu(r0), r4, 0, true, null, null, null, null, new f(this), 502);
    }

    public final ViewGroup.LayoutParams q() {
        int r1 = i5.c0();
        i0.a.getClass();
        return new ViewGroup.LayoutParams(-1, r1 + i0.g());
    }

    public g() {
    }

    private static Bundle A(ni8.e r4) {
        Boolean r5 = Boolean.TRUE;
        return com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", "chat"), TuplesKt.to("argConversationId", r4.a), TuplesKt.to("argBotId", r4.j), TuplesKt.to("argBotType", r4.n), TuplesKt.to("argClickEnterFrom", r4.k), TuplesKt.to("argCvsBgImgUrl", r4.b), TuplesKt.to("argCvsBgImgColor", r4.c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r4.d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r4.i)), TuplesKt.to("enter_method", "image_preview_click"), TuplesKt.to("enter_from", "image_preview_click"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r4.o)), TuplesKt.to("target_middle_msg_id", r4.q), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r4.r), TuplesKt.to("argBotConversationType", Integer.valueOf(r4.v)), TuplesKt.to("is_from_image_preview", r5), TuplesKt.to("ignore_same_page_check", r5)});
    }

    public View p(ViewGroup r2) {
        LarusGalleryChatTitleBinding r3 = LarusGalleryChatTitleBinding.a(LayoutInflater.from(getContext()), r2);
        this.f = r3;
        ImageView r4 = r3.b;
        if (r4 == null) goto L5;
        r4.setOnClickListener(new d(this));
    L5:
        LarusGalleryChatTitleBinding r5 = this.f;
        if (r5 == null) goto L10;
        ImageView r6 = r5.c;
        if (r6 == null) goto L10;
        r6.setOnClickListener(new e(this));
    L10:
        LarusGalleryChatTitleBinding r7 = this.f;
        if (r7 == null) goto L15;
        ConstraintLayout r8 = r7.e;
        if (r8 == null) goto L15;
        r8.setOnClickListener(new dg5.d());
    L15:
        LarusGalleryChatTitleBinding r9 = this.f;
        if (r9 != null) goto L20;
        return null;
    L20:
        return r9.a;
    }

    public static final void y(final g r10, ni8.e r11) {
        r10.getClass();
        if (r11.e == true) goto L5;
    L34:
        Integer r0 = r11.l;
        if (r0 != null) goto L38;
        return;
    L38:
        if (r0.intValue() != 3) goto L45;
        com.bytedance.router.i r1 = SmartRouter.buildRoute(r10.getContext(), "//flow/chat_page");
        Bundle r12 = A(r11);
        by7.e r3 = r10.D();
        if (r3 == null) goto L42;
        by7.h.k(r12, r3);
    L42:
        r1.c.putExtras(r12);
        r1.d = 2130772399;
        r1.e = 2130772399;
        r1.d();
        t0.a.postDelayed(new c(r10), 300);
        return;
    L45:
        return;
    L5:
        if (AccountService.a.a() == true) goto L34;
        int r6 = 0;
        if (ic8.l0.a(r11.m) == false) goto L29;
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r10.getContext(), "//flow/chat_multi_tab");
        Bundle r4 = A(r11);
        ArrayList<Integer> r7 = new ArrayList();
        ConversationPage r8 = r11.h;
        if (r8 == null) goto L13;
        List r9 = r8.getPageList();
        if (r9 == null) goto L13;
    L14:
        r7.addAll(r9);
        Unit r13 = Unit.INSTANCE;
        r4.putIntegerArrayList("argument_multi_tab_list", r7);
        ConversationPage r14 = r11.h;
        if (r14 == null) goto L19;
        Integer r15 = r14.getDefaultStatus();
        if (r15 == null) goto L19;
        int r16 = r15.intValue();
    L20:
        r4.putInt("argument_multi_tab_default_tab", r16);
        ConversationPage r17 = r11.h;
        if (r17 == null) goto L25;
        Integer r18 = r17.getPagePosition();
        if (r18 == null) goto L25;
        r6 = r18.intValue();
    L25:
        r4.putInt("argument_multi_tab_title_style", r6);
        by7.e r19 = r10.D();
        if (r19 == null) goto L28;
        by7.h.k(r4, r19);
    L28:
        r2.c.putExtras(r4);
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
    L33:
        t0.a.postDelayed(new b(r10), 300);
        return;
    L19:
        r16 = PageType.Chat.getType();
    L13:
        r9 = CollectionsKt.emptyList();
        goto L14
    L29:
        com.bytedance.router.i r5 = SmartRouter.buildRoute(r10.getContext(), "//flow/chat_page_double_tab");
        Bundle r110 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", "chat"), TuplesKt.to("argConversationId", r11.a), TuplesKt.to("argClickEnterFrom", r11.k), TuplesKt.to("argBotId", r11.j), TuplesKt.to("argBotType", r11.n), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r11.i)), TuplesKt.to("conversation_page", r11.h), TuplesKt.to("default_tab", Integer.valueOf(r11.g)), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r11.o)), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r11.r), TuplesKt.to("ignore_same_page_check", Boolean.TRUE)});
        by7.e r20 = r10.D();
        if (r20 == null) goto L32;
        by7.h.k(r110, r20);
    L32:
        r5.c.putExtras(r110);
        r5.d = 2130772401;
        r5.e = 2130772399;
        r5.d();
        goto L33
    }

    public void w(T r5, int r6) {
        ((com.larus.gallery.api.t) this).d = r5;
        LarusGalleryChatTitleBinding r7 = this.f;
        if (r7 == null) goto L13;
        TextView r8 = r7.g;
        if (r8 == null) goto L13;
        Calendar r9 = oo8.b.a;
        bb9.a r10 = C();
        if (r10 == null) goto L11;
        Message r11 = r10.a;
        if (r11 == null) goto L11;
        long r0 = r11.getCreateTime();
    L12:
        r8.setText(oo8.b.a(r0 * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY), false));
    L11:
        r0 = 0;
    L13:
        String r12 = B();
        Unit r1 = null;
        if (o0.d(r12) == true) goto L17;
        r12 = null;
    L17:
        if (r12 == null) goto L29;
        LarusGalleryChatTitleBinding r13 = this.f;
        if (r13 == null) goto L23;
        TextView r14 = r13.f;
        if (r14 == null) goto L23;
        r14.setText(r12);
    L23:
        LarusGalleryChatTitleBinding r15 = this.f;
        if (r15 == null) goto L28;
        TextView r16 = r15.f;
        if (r16 == null) goto L28;
        e1.x(r16);
        r1 = Unit.INSTANCE;
    L28:
        if (r1 == null) goto L29;
        return;
    L29:
        LarusGalleryChatTitleBinding r17 = this.f;
        if (r17 == null) goto L36;
        TextView r18 = r17.f;
        if (r18 == null) goto L37;
        e1.o(r18);
        Unit r19 = Unit.INSTANCE;
        return;
    L37:
        return;
    }
}
