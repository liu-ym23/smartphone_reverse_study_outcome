package com.larus.bmhome.chat.layout.holder.answeraction;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.j0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MsgRegenMode;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RegenInstructionPanel {
    public static final /* synthetic */ int i = 0;
    public final View a;
    public final Message b;
    public final long c;
    public final q0.a d;
    public final boolean e;
    public Balloon f;
    public final CompletableDeferred<Boolean> g;
    public e h;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f == null) goto L6;
        FLogger.a.d("RegenInstructionPanel", "show called, balloon is not null, skip");
        return;
    L6:
        q0.a r1 = this.d;
        if (r1 == null) goto L11;
        y r2 = r1.u0();
        if (r2 == null) goto L11;
        BotModel r3 = r2.j0();
    L12:
        boolean r4 = this.e;
        if (r3 == null) goto L15;
        List r5 = r3.getMsgRegenModeList();
    L16:
        ArrayList r6 = new ArrayList();
        if (r4 == false) goto L23;
        View r8 = this.a;
        if (r8 == null) goto L21;
        Context r9 = r8.getContext();
    L22:
        r6.add(new l0(2131908739, 2131908739, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971826, r9, 2131241964)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
        LruCache r7 = ko8.a.a;
        Message r10 = this.b;
        long r11 = this.c;
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter("default", "regenInstruction");
        IAIChatControlTraceService.a.Ib(r10, r11, "default");
        goto L23
    L21:
        r9 = null;
    L23:
        List r12 = r5;
        boolean r13 = true;
        if (r12 != null) goto L26;
    L29:
        boolean r14 = true;
    L31:
        if (r14 == false) goto L33;
        FLogger.a.d("RegenInstructionPanel", "msgRegenModeList is empty, addRegen: " + r4);
    L72:
        if (r6.isEmpty() == false) goto L75;
        FLogger.a.d("ActionCreator", "showRegenInstructionPanel called, buildMenuItems empty, skip");
        this.g.complete(Boolean.FALSE);
        return;
    L75:
        CommonMenu r15 = new CommonMenu(this.a.getContext());
        r15.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r15.g(r6, new RegenInstructionPanel$show$commonMenu$1(this));
        r15.h = i5.H();
        Paint r16 = new Paint(1);
        r16.setTextSize(i5.q());
        r16.setTypeface(Typeface.create("sans-serif-medium", 0));
        if (r6.isEmpty() == true) goto L114;
        Iterator r17 = r6.iterator();
    L80:
        if (r17.hasNext() == false) goto L114;
        l0 r18 = (ot8.a) r17.next();
        if ((r18 instanceof l0) == false) goto L111;
        l0 r19 = r18;
        String r20 = r19.c;
        if (r20 != null) goto L86;
    L89:
        boolean r21 = true;
    L90:
        if (r21 == true) goto L95;
        String r22 = r19.c;
        if (r22 != null) goto L99;
    L97:
        r22 = "";
    L99:
        if (r19.m == null) goto L101;
    L104:
        boolean r23 = true;
    L105:
        if (r23 == false) goto L107;
        int r24 = i5.A() + i5.h();
    L109:
        if (((((r19.o + i5.A()) + r24) + i5.C()) + ((int) Math.ceil(r16.measureText(r22)))) <= i5.F()) goto L111;
        boolean r25 = true;
    L112:
        if (r25 == false) goto L80;
    L115:
        if (r13 == false) goto L117;
        r15.d(i5.F());
    L120:
        View r26 = r15.i();
        Balloon r27 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, this.a, r26, false, null, new c(), null, new d(this), 44);
        this.f = r27;
        r26.measure(0, 0);
        int r28 = ((this.a.getWidth() / 2) + r26.getPaddingEnd()) - (r26.getMeasuredWidth() / 2);
        int r29 = r26.getPaddingBottom() - i5.g();
        FLogger.a.d("ActionCreator", "xOff: " + r28 + ", yOff: " + r29 + ", menuView.measuredWidth: " + r26.getMeasuredWidth() + ", menuView.measuredHeight: " + r26.getMeasuredHeight() + ", menuView.paddingEnd: " + r26.getPaddingEnd() + ", menuView.paddingBottom: " + r26.getPaddingBottom());
        r27.v(this.a, r28, r29);
        return;
    L117:
        ViewGroup.LayoutParams r30 = r15.getLayoutParams();
        if (r30.width == (-2)) goto L120;
        r30.width = -2;
        r15.setLayoutParams(r30);
        goto L120
    L107:
        r24 = 0;
        goto L109
    L101:
        if (o0.d(r19.n) == true) goto L104;
        r23 = false;
        goto L105
    L95:
        if (r19.b == 0) goto L97;
        r22 = this.a.getContext().getText(r19.b).toString();
        goto L99
    L86:
        if (r20.length() == 0) goto L89;
        r21 = false;
    L111:
        r25 = false;
    L114:
        r13 = false;
        goto L115
    L33:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r5.iterator();
    L35:
        if (r32.hasNext() == false) goto L48;
        Object r33 = r32.next();
        Integer r110 = ((MsgRegenMode) r33).getRegenType();
        int r111 = RegenInstructionEnum.REGEN_DEEP_THINK.getType();
        if (r110 != null) goto L40;
    L45:
        boolean r112 = true;
    L46:
        if (r112 == false) goto L35;
        r31.add(r33);
        goto L35
    L40:
        if (r110.intValue() != r111) goto L45;
        if (com.larus.im.bean.message.a.C0(this.b) == false) goto L45;
        r112 = false;
        goto L46
    L48:
        Iterator r34 = r31.iterator();
    L50:
        if (r34.hasNext() == false) goto L72;
        MsgRegenMode r35 = (MsgRegenMode) r34.next();
        boolean r36 = h.a;
        if (h.a(null) == false) goto L54;
        String r113 = r35.getRegenDarkIcon();
    L55:
        String r64 = r113;
        if (o0.d(r35.getRegenText()) == true) goto L58;
    L67:
        l0 r114 = null;
    L68:
        if (r114 != null) goto L69;
        FLogger.a.d("RegenInstructionPanel", "createMenuItem failed, msgRegenMode: " + r35);
        goto L50
    L69:
        r6.add(r114);
        goto L50
    L58:
        if (o0.d(r64) == false) goto L67;
        LruCache r115 = ko8.a.a;
        Message r116 = this.b;
        long r117 = this.c;
        String r118 = r35.getRegenInstruction();
        if (r118 != null) goto L62;
        r118 = "";
    L62:
        Intrinsics.checkNotNullParameter(r116, "message");
        Intrinsics.checkNotNullParameter(r118, "regenInstruction");
        IAIChatControlTraceService.a.Ib(r116, r117, r118);
        String r53 = r35.getRegenText();
        View r119 = this.a;
        if (r119 == null) goto L65;
        Context r120 = r119.getContext();
    L66:
        r114 = new l0(2131380351, 0, r53, null, null, null, null, null, null, false, false, r35, Integer.valueOf(v19.c.b(2130971800, r120, 2131241836)), r64, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -14342, 127);
        goto L68
    L65:
        r120 = null;
        goto L66
    L54:
        r113 = r35.getRegenLightIcon();
        goto L55
    L26:
        if (r12.isEmpty() == true) goto L29;
        r14 = false;
        goto L31
    L15:
        r5 = null;
    L11:
        r3 = null;
        goto L12
    }

    public final Object a(Continuation<? super e> r5) {
        if ((r5 instanceof RegenInstructionPanel$getResult$1) == false) goto L7;
        RegenInstructionPanel$getResult$1 r0 = (RegenInstructionPanel$getResult$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L18:
        if (((Boolean) r6).booleanValue() == true) goto L20;
        return null;
    L20:
        return this.h;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        CompletableDeferred<Boolean> r7 = this.g;
        r0.label = 1;
        r6 = r7.await(r0);
        if (r6 != r2) goto L18;
        return r2;
    L7:
        r0 = new RegenInstructionPanel$getResult$1(this, r5);
        goto L8
    }

    public RegenInstructionPanel(View r2, Message r3, long r4, q0.a r6) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Intrinsics.checkNotNullParameter(r3, "answer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = true;
        this.g = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }
}
