package com.larus.bmhome.chat.layout.holder.helper;

import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.c4;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.common.spi.interaction.ObricMessagePopupServiceDelegate;
import com.skydoves.balloon.Balloon;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w0 implements View.OnLongClickListener {
    public final /* synthetic */ a1 a;

    public /* synthetic */ w0(a1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(final View r25) {
        final a1 r11 = this.a;
        com.larus.bmhome.chat.api.q0 r1 = r11.b;
        if (r1 != null) goto L5;
    L4:
        return true;
    L5:
        wc9.e r19 = (wc9.e) r1.A7().invoke();
        Fragment r2 = (Fragment) r11.b.getHostFragment().invoke();
        z19.j r23 = null;
        if (r2 == null) goto L10;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L10;
        ss8.g r4 = (ss8.g) r3.getAbility(ss8.g.class);
    L11:
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        FLogger r6 = FLogger.a;
        r6.i("LongClickHelper", "onLongClick: forbidSendMsg=" + ic8.n.d(r19) + ", isLongPressBlocked=" + r5);
        if (ic8.n.d(r19) == true) goto L19;
    L21:
        if (r5 == true) goto L4;
        com.larus.bmhome.chat.api.q0.a r7 = r11.c;
        if (r7 == null) goto L4;
        com.larus.bmhome.chat.component.cvs.y r8 = r7.u0();
        if (r8 == null) goto L4;
        BotModel r18 = r8.j0();
        if (r18 == null) goto L4;
        List<? extends ot8.a> r13 = t0.a.a(r11.d, r25.getContext(), r11.a, null, r11.b, r18, r19, r11.c, r11.f, 4);
        final Integer r14 = a1.e(r11.f);
        if (r13.isEmpty() == true) goto L4;
        ObricMessagePopupServiceDelegate r15 = ObricMessagePopupServiceDelegate.b;
        r15.filterMessageMenuItemsIfNeeded(r25.getContext(), r13);
        if (ObricFeatureServiceDelegate.b.a() == true) goto L36;
    L38:
        final ef8.c r9 = new ef8.c(r13);
        final boolean r10 = com.larus.platform.service.z2.a.enableMessageMenuTimestamp();
        if (r10 == false) goto L41;
        Calendar r12 = oo8.b.a;
        String r16 = oo8.b.a(r11.a.getCreateTime() * 1000, true);
    L42:
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        r17.element = new x0(r11, r25, r9, r10, r17, r14);
        List r20 = com.larus.bmhome.view.screenmenu.u0.b(r13, r10, r16);
        CommonMenu r110 = new CommonMenu(r25.getContext());
        com.larus.bmhome.view.screenmenu.g.a(r110);
        com.larus.bmhome.view.screenmenu.u0.a(r110, r10);
        r110.g(r20, (Function1) r17.element);
        r11.i = r110;
        com.larus.bmhome.view.screenmenu.d r21 = com.larus.bmhome.view.screenmenu.d.a;
        Intrinsics.checkNotNull(r25);
        Balloon r22 = com.larus.bmhome.view.screenmenu.d.a(r21, r25, r110.i(), false, null, null, null, new z0(r11), 60);
        if ((r25 instanceof z19.j) == false) goto L45;
        r23 = (z19.j) r25;
    L45:
        if (r23 == null) goto L49;
        Float r24 = r23.getLastMotionX();
        if (r24 == null) goto L49;
        int r26 = (int) r24.floatValue();
    L50:
        if (r23 == null) goto L54;
        Float r27 = r23.getLastMotionY();
        if (r27 == null) goto L54;
        int r28 = (int) r27.floatValue();
    L55:
        r15.markNextDropdownRewriteIfNeeded(r25, r22.e);
        if (Build.VERSION.SDK_INT >= 26) goto L61;
        ChatMessageList r29 = r11.b.B7();
        if (r29 == null) goto L60;
        Point r30 = com.larus.utils.e1.n(r25, r29);
        r110.measure(0, 0);
        r28 = Math.max(r110.getMeasuredHeight() - r30.y, r28);
    L60:
        r22.v(r25, 0, r28);
    L62:
        r11.g = r22;
        ChatMessageList r31 = r11.b.B7();
        if (r31 == null) goto L65;
        r31.requestDisallowInterceptTouchEvent(true);
    L65:
        ViewGroup r32 = r11.e;
        if (r32 == null) goto L68;
        r32.requestDisallowInterceptTouchEvent(true);
    L68:
        r11.b(r13, false, r14);
        r11.d();
        return true;
    L61:
        r22.v(r25, r26, r28);
    L54:
        r28 = r25.getHeight() / 2;
    L49:
        r26 = r25.getWidth() / 2;
        goto L50
    L41:
        r16 = null;
        goto L42
    L36:
        if (r13.isEmpty() == false) goto L38;
        r6.i("LongClickHelper", "skip empty message menu after OBRIC filter, messageId=" + r11.a.getMessageId());
        goto L4
    L19:
        if (c4.a((Fragment) r11.b.getHostFragment().invoke()) == true) goto L21;
    L13:
        if (r4.bc(ChatUIBlockConfig.DISABLE_MSG_LONG_PRESS) != true) goto L15;
        r5 = true;
    L10:
        r4 = null;
        goto L11
    }
}
