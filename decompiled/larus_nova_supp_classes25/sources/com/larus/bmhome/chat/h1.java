package com.larus.bmhome.chat;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.bmhome.chat.immerse.MessageListMaskWrapper;
import com.larus.bmhome.chat.layout.widget.NestedScrollableContainer;
import com.larus.bmhome.chat.view.ImmerseBgVideoView;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h1 {
    public final ChatFragment a;
    public final LarusPageChatBinding b;
    public final com.larus.platform.api.g0 c;
    public final Integer d;
    public final boolean e;
    public final String f;
    public final Lazy g;
    public MessageListMaskWrapper h;
    public Integer i;
    public int j;
    public ImmerseBgVideoView k;
    public String l;
    public boolean m;
    public com.larus.bmhome.chat.component.immerse.m n;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final com.larus.bmhome.chat.component.list.b a() {
        return this.a.WF().getAbility(com.larus.bmhome.chat.component.list.b.class);
    }

    public final boolean b() {
        int r0 = this.j;
        Integer r1 = this.i;
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0 != r1.intValue()) goto L8;
        return true;
    }

    public final void c() {
        ChatTitleAlignLeftStyle r0 = this.c;
        if ((r0 instanceof ChatTitleAlignLeftStyle) == false) goto L5;
        ChatTitleAlignLeftStyle r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getHistoryChecked() == false) goto L12;
        MessageListMaskWrapper r2 = this.h;
        if (r2 == null) goto L17;
        r2.m();
        return;
    L17:
        return;
    L12:
        MessageListMaskWrapper r3 = this.h;
        if (r3 == null) goto L19;
        FLogger r4 = FLogger.a;
        r4.d(r3.g, "showLastRoundChat");
        r3.p();
        ChatMessageList r5 = r3.b.n;
        r4.d(r3.g, "showLastRoundChat, canScrollVertically(1)=" + r5.canScrollVertically(1) + ", canScrollVertically(-1)=" + r5.canScrollVertically(-1));
        r3.k = r3.b.n.getHeight() - r3.e().a;
        r4.d(r3.g, "showLastRoundChat, immerseHeight=" + r3.k);
        r3.n(true);
        r3.d();
        r3.a.MQ(true);
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final int d(int r5) {
        Bundle r0 = this.a.getArguments();
        Object r1 = null;
        if (r0 != null) goto L5;
    L11:
        Bundle r2 = this.a.getArguments();
        if (r2 == null) goto L16;
        boolean r3 = true;
        if (r2.getBoolean("argIsHalfScreen") != true) goto L16;
    L17:
        if (r3 == false) goto L34;
        Integer r4 = com.larus.platform.service.o2.a.d();
        if (r4 == null) goto L34;
        int r6 = r4.intValue();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L23
        Object r8 = Result.constructor-impl(Integer.valueOf(ContextCompat.getColor(AppHost.a.getApplication(), r6)));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r8) == true) goto L29;
        r1 = r8;
    L29:
        Integer r9 = (Integer) r1;
        if (r9 == null) goto L34;
        return r9.intValue();
    L23:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        return com.larus.bmhome.chat.immerse.k0.a(r5, 0.4f, 0.15f);
    L16:
        r3 = false;
        goto L17
    L5:
        if (r0.containsKey("argHostChatBackgroundColor") == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0.getInt("argHostChatBackgroundColor");
    }

    public final void e(boolean r18, boolean r19) {
        ChatTitleAlignLeftStyle r0 = this.c;
        String r3 = null;
        if ((r0 instanceof ChatTitleAlignLeftStyle) == false) goto L5;
        ChatTitleAlignLeftStyle r2 = r0;
    L6:
        if (r2 == null) goto L139;
        MessageListMaskWrapper r1 = this.h;
        if (r1 == null) goto L10;
        boolean r5 = r1.t;
    L11:
        FLogger.a.i("ChatListDecorateWrap", "switchHistoryCheckState, historyChecked = " + r2.getHistoryChecked() + ", hasMultiMessage = " + r5);
        if (r18 == true) goto L52;
        if (r19 == true) goto L52;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L49
        de8.c r6 = (de8.c) this.a.WF().a(de8.c.class);     // Catch: Throwable -> L49
        com.larus.bmhome.chat.component.cvs.y r7 = this.a.WF().getAbility(com.larus.bmhome.chat.component.cvs.y.class);     // Catch: Throwable -> L49
        if (r7 == null) goto L17;
        BotModel r8 = r7.j0();     // Catch: Throwable -> L49
    L19:
        if (r2.getHistoryChecked() == false) goto L21;
        String r9 = "enter";
    L22:
        String r10 = r9;
        if (r8 == null) goto L25;
        String r11 = r8.getBotId();     // Catch: Throwable -> L49
    L26:
        if (r6 == null) goto L30;
        RecommendFrom r12 = r6.d;     // Catch: Throwable -> L49
        if (r12 == null) goto L30;
        String r13 = r12.a;     // Catch: Throwable -> L49
    L32:
        if (com.larus.platform.service.z2.a.V1() == false) goto L34;
        String r14 = "chat_action_bar";
    L35:
        String r15 = r14;
        if (r6 == null) goto L40;
        RecommendFrom r16 = r6.d;     // Catch: Throwable -> L49
        if (r16 == null) goto L40;
        String r17 = r16.b;     // Catch: Throwable -> L49
    L41:
        if (r6 == null) goto L43;
        String r110 = r6.p();     // Catch: Throwable -> L49
    L44:
        String r111 = com.larus.bmhome.utils.s.a(r8);     // Catch: Throwable -> L49
        com.larus.bmhome.chat.component.cvs.y r20 = this.a.WF().getAbility(com.larus.bmhome.chat.component.cvs.y.class);     // Catch: Throwable -> L49
        if (r20 == null) goto L47;
        r3 = r20.Y1();     // Catch: Throwable -> L49
    L47:
        tx9.n1.a(r10, r11, r13, r15, r17, r110, r111, r3);     // Catch: Throwable -> L49
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L49
        goto L52
    L43:
        r110 = null;
    L40:
        r17 = null;
        goto L41
    L34:
        r14 = "right_corner";
    L30:
        r13 = null;
        goto L32
    L25:
        r11 = null;
        goto L26
    L21:
        r9 = "exit";
        goto L22
    L17:
        r8 = null;
    L49:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L52:
        if (com.larus.platform.service.z2.a.V1() == false) goto L125;
        if (r5 == true) goto L59;
        FLogger.a.d("ChatListDecorateWrap", "switchHistoryCheckState, no multi message");
        if (r18 == true) goto L137;
        if (r19 == true) goto L138;
        t19.s.j(t19.s.a, this.a.getContext(), this.a.getResources().getString(2131900195), null, false, 28);
        return;
    L138:
        return;
    L137:
        return;
    L59:
        LarusPageChatBinding r22 = this.a.u;
        if (r22 == null) goto L64;
        NestedScrollableContainer r23 = r22.o;
        if (r23 == null) goto L64;
        boolean r24 = r23.getEnableDamping();
    L65:
        com.larus.bmhome.chat.component.immerse.a r25 = this.a.WF().getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r25 != null) goto L68;
    L70:
        boolean r26 = false;
    L71:
        if (r26 == true) goto L73;
    L99:
        if (r24 == false) goto L125;
        LarusPageChatBinding r27 = this.a.u;
        if (r27 == null) goto L105;
        NestedScrollableContainer r28 = r27.o;
        if (r28 == null) goto L105;
        r28.setEnableDamping(false);
    L105:
        LarusPageChatBinding r29 = this.a.u;
        if (r29 == null) goto L110;
        LinearLayout r30 = r29.s;
        if (r30 == null) goto L110;
        com.larus.utils.e1.o(r30);
    L110:
        LarusPageChatBinding r31 = this.a.u;
        if (r31 == null) goto L115;
        LinearLayout r32 = r31.t;
        if (r32 == null) goto L115;
        com.larus.utils.e1.o(r32);
    L115:
        if (r18 == false) goto L117;
        r2.postDelayed(new b1(this), 400);
        goto L125
    L117:
        LarusPageChatBinding r33 = this.a.u;
        if (r33 == null) goto L125;
        final NestedScrollableContainer r34 = r33.o;
        if (r34 == null) goto L125;
        FLogger.a.d("NestedScrollableContainerDamping", "scrollToBottomWithAnim, scrollY = " + r34.getScrollY());
        if (r34.getScrollY() == 0) goto L125;
        r34.e = false;
        r34.f = false;
        ValueAnimator r35 = ValueAnimator.ofInt(new int[]{r34.getScrollY(), 0});
        r35.setDuration((long) ((((double) Math.abs(r34.getScrollY())) / ((double) r34.h)) * ((double) DoraCallStateCode.DORA_OB_USER_END)));
        r35.addUpdateListener(new com.larus.bmhome.chat.layout.widget.a1(r34));
        r35.start();
        goto L125
    L73:
        if (r2.getHistoryChecked() == true) goto L99;
        if (r24 == true) goto L99;
        if (r19 == true) goto L99;
        LarusPageChatBinding r36 = this.a.u;
        if (r36 == null) goto L81;
        NestedScrollableContainer r37 = r36.o;
        if (r37 == null) goto L81;
        r37.setEnableDamping(true);
    L81:
        LarusPageChatBinding r38 = this.a.u;
        if (r38 == null) goto L90;
        LinearLayout r39 = r38.s;
        if (r39 == null) goto L90;
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        if (r40 == null) goto L89;
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
        r41.bottomMargin = -c7.b(120);
        r39.setLayoutParams(r41);
        com.larus.utils.e1.x(r39);
        goto L90
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L90:
        LarusPageChatBinding r42 = this.a.u;
        if (r42 == null) goto L125;
        LinearLayout r43 = r42.t;
        if (r43 == null) goto L125;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
        if (r44 == null) goto L98;
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        r45.topMargin = -c7.b(120);
        r43.setLayoutParams(r45);
        com.larus.utils.e1.x(r43);
        goto L125
    L98:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L68:
        if (r25.ui() != true) goto L70;
        r26 = true;
    L64:
        r24 = false;
    L125:
        if (r2.getHistoryChecked() == true) goto L129;
        if (r19 == false) goto L129;
        return;
    L129:
        if (r2.getHistoryChecked() == false) goto L133;
        ld8.n r46 = (ld8.n) this.a.WF().getAbility(ld8.n.class);
        if (r46 == null) goto L133;
        r46.m60(BottomFloatingButtonAction.SCROLL_DOWN);
    L133:
        r2.setHistoryChecked(!r2.getHistoryChecked());
        c();
        return;
    L10:
        r5 = false;
        goto L11
    L139:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void f(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "immerseBgUrl");
        int r0 = d(r7);
        this.b.a.setBackgroundColor(r0);
        com.larus.bmhome.chat.component.list.b r1 = a();
        if (r1 == null) goto L7;
        final SimpleDraweeView r2 = r1.eJ();
        if (r2 == null) goto L7;
        ImageLoaderKt.y(r2, r6, "chat_immerse_decorate_wrap_1", new a1(r2), 4);
    L7:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r8 = this.a.WF().getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r8 == null) goto L10;
        r8.cl(r7);
    L10:
        this.b.e.setBackgroundColor(r0);
        MessageListMaskWrapper r9 = this.h;
        if (r9 != null) goto L13;
        return;
    L13:
        if (r9.d == r7) goto L17;
        FLogger.a.d(r9.g, "updateImmerseBgColor");
        r9.d = r7;
        r9.j();
        return;
    }

    public h1(ChatFragment r2, LarusPageChatBinding r3, com.larus.platform.api.g0 r4, Integer r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = "ChatListDecorateWrap" + hashCode();
        this.g = LazyKt.lazy(new w0(this));
    }
}
