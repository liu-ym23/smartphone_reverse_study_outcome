package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.base.model.MessageContentFoldingControlParams;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.lynxcard.settings.CardMessageUserLynxRenderSettings;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.chat.core.model.b.a<y6b.c<?>> {
    public final s2b.e a;
    public final boolean b;
    public final boolean c;

    public d(s2b.e r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void c(List r2, int r3) {
        e(r2, r3, 1);
        d(r2, r3 - 1, 3);
    }

    public d(s2b.e r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void a(List<y6b.c<?>> r1, int r2, int r3) {
        d(r1, r2 - 1, r3 + 2);
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void b(List<y6b.c<?>> r1, int r2, int r3) {
        e(r1, r2, r3);
        d(r1, r2 - 1, r3 + 2);
    }

    public final void d(List<y6b.c<?>> r8, int r9, int r10) {
        int r0 = Math.max(r9, 0);
    L3:
        ArrayList r2 = (ArrayList) r8;
        if (r0 > Math.min(r9 + r10, r2.size() - 1)) goto L12;
        y6b.c r1 = (y6b.c) ListProtector.get(r2, r0);
        int r3 = r1.R2;
        s2b.e r4 = this.a;
        String r5 = r1.d;
        if (((HashMap) r4.d).containsKey(r5) == false) goto L8;
        int r6 = ((Integer) ((HashMap) r4.d).get(r5)).intValue();
    L9:
        if (r6 == r3) goto L11;
        r1.T2 = true;
    L11:
        s2b.e r7 = this.a;
        String r11 = r1.d;
        Map<String, Integer> r12 = r7.d;
        HashMap r13 = (HashMap) r12;
        r13.put(r11, Integer.valueOf(r3));
        r0 = r0 + 1;
        goto L3
    L8:
        r6 = r3;
        goto L9
    }

    public final void e(List<y6b.c<?>> r16, int r17, int r18) {
        int r1 = r17;
    L4:
        if (r1 >= (r17 + r18)) goto L49;
        y6b.c r3 = (y6b.c) ListProtector.get(r16, r1);
        String r4 = r3.c;
        r3.P2 = r4.equals(this.a.a);
        LynxCardContentVO r5 = r3.o;
        Boolean r7 = null;
        boolean r9 = false;
        boolean r10 = true;
        if ((r5 instanceof BaseTextContentVO) == false) goto L35;
        BaseTextContentVO r6 = (BaseTextContentVO) r5;
        s2b.e r8 = this.a;
        Map<String, s2b.e.b> r11 = r8.b;
        HashMap r12 = (HashMap) r11;
        if (((s2b.e.b) r12.get(r3.c)) != null) goto L21;
        s2b.e.b r13 = new s2b.e.b();
        if (r3.i == false) goto L13;
    L19:
        r13.a = true;
    L20:
        Map<String, s2b.e.b> r14 = r8.b;
        HashMap r15 = (HashMap) r14;
        r15.put(r3.c, r13);
        goto L21
    L13:
        if (r3.X <= 0) goto L15;
        boolean r19 = true;
    L16:
        if (r19 == true) goto L19;
        r13.a = true;
        MessageContentFoldingControlParams r110 = (MessageContentFoldingControlParams) SettingManager.getInstance().get(MessageContentFoldingControlParams.class);
        r13.c = new EllipsizeFrameLayout.a(r110.b(), r110.a());
        goto L20
    L15:
        r19 = false;
    L21:
        s2b.e.b r20 = (s2b.e.b) ((HashMap) this.a.b).get(r4);
        r6.p = -1;
        EllipsizeFrameLayout.a r21 = this.a.a(r4);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r6.s = r21;
        if (this.b == false) goto L24;
    L26:
        r10 = false;
    L27:
        r6.q = r10;
        s2b.e.b r22 = (s2b.e.b) ((HashMap) this.a.b).get(r4);
        if (r22 == null) goto L30;
        r9 = r22.b;
    L30:
        r6.r = r9;
        s2b.e.b r23 = (s2b.e.b) ((HashMap) this.a.b).get(r4);
        if (r23 == null) goto L33;
        r7 = r23.f;
    L33:
        r6.D = r7;
    L46:
        r1 = r1 + 1;
        goto L4
    L24:
        if (this.a.c(r4) == false) goto L26;
    L35:
        if ((r5 instanceof com.ss.android.lark.message.card.view.a) == true) goto L47;
        if ((r5 instanceof LynxCardContentVO) == false) goto L46;
        CardMessageUserLynxRenderSettings r24 = lrb.a.a;
        if (com.ss.android.lark.message.card.b.a().getFgValue("im.message_card.auto_fold") == false) goto L46;
        LynxCardContentVO r25 = r5;
        this.a.b(r4);
        EllipsizeFrameLayout.a r26 = this.a.a(r4);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r25.m = r26;
        if (this.c == false) goto L43;
    L45:
        r25.l = r9;
        goto L46
    L43:
        if (this.a.c(r4) == false) goto L45;
        r9 = true;
        goto L45
    L47:
        ((com.ss.android.lark.message.card.view.a) r5).getClass();
        throw null;
    }
}
