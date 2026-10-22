package com.larus.bmhome.chat.component.bottom.core;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e7 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ CoreInputComponent a;

    public e7(CoreInputComponent r1) {
        this.a = r1;
    }

    public final void c(Object r10) {
        BotModel r11 = (BotModel) r10;
        Intrinsics.checkNotNullParameter(r11, "new");
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        this.a.k4().eQ(r0.F4().getEditPosFromBotModel(r11), r11);
        CoreInputComponent r2 = this.a;
        LarusWidgetInputBinding r3 = r2.W;
        if (r3 == null) goto L9;
        com.larus.bmhome.chat.component.cvs.y r4 = r2.u0();
        if (r4 == null) goto L7;
        String r5 = r4.Y1();
    L8:
        CoreInputComponent.C3(r2, r3, r11, r5);
        goto L9
    L7:
        r5 = null;
    L9:
        CoreInputComponent r6 = this.a;
        com.larus.bmhome.chat.component.cvs.y r7 = r6.u0();
        if (r7 == null) goto L12;
        String r8 = r7.Y1();
    L13:
        boolean r9 = false;
        if (r6.F4().getInputStatus() != 2) goto L32;
        int r12 = com.larus.bmhome.utils.r.a;
        if (com.larus.bmhome.utils.r.a(s1a.d.a(r6)).d == false) goto L30;
        ILegacyChatUiServiceDelegate r13 = ILegacyChatUiServiceDelegate.b;
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        if (r13.y8(r11, r8, true, false) == false) goto L30;
        com.larus.bmhome.instruction.g r14 = r6.vc();
        if (r14 != null) goto L25;
    L27:
        boolean r15 = false;
    L28:
        if (r15 == false) goto L30;
        boolean r16 = true;
    L31:
        r6.sz(r16);
        goto L32
    L25:
        if (r14.z0() == true) goto L27;
        r15 = true;
    L30:
        r16 = false;
    L32:
        int r17 = com.larus.bmhome.utils.r.a;
        if (com.larus.bmhome.utils.r.a(s1a.d.a(this.a)).b == false) goto L37;
        com.larus.bmhome.instruction.g r18 = this.a.vc();
        if (r18 == null) goto L37;
        r18.NZ();
    L37:
        CoreInputComponent r19 = this.a;
        BotModel r20 = r19.k4().q();
        if (r20 == null) goto L40;
        String r21 = r20.getBotId();
    L42:
        if (Intrinsics.areEqual(r21, r11.getBotId()) == true) goto L57;
        String r22 = r19.w6();
        if (r22 != null) goto L47;
    L49:
        boolean r23 = false;
    L50:
        if (r23 == false) goto L57;
        if (r19.u7().length() != 0) goto L54;
        r9 = true;
    L54:
        if (r9 == true) goto L57;
        r19.k4().p80(true);
        r19.k4().g2(2, true);
        r19.F4().updateCoreInputText("");
        goto L57
    L47:
        if (com.larus.utils.o0.d(r22) != true) goto L49;
        r23 = true;
    L57:
        this.a.m6();
        CoreInputComponent r24 = this.a;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r24.F4()), null, null, new CoreInputComponent$addDynamicShortcut$1(r24, null), 3, null);
        FLogger.a.i("CoreInputComponent", "bot change: botId:" + r11.getBotId() + ", name:" + r11.getName() + ", editPos:" + r11.getEditPos());
        return;
    L40:
        r21 = null;
        goto L42
    L12:
        r8 = null;
        goto L13
    }
}
