package com.larus.bmhome.chat.component.title;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import by7.h;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.helper.f;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.a;
import de8.c;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c1 implements Function1 {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ c1(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        ChatTitleComponent r0 = this.a;
        if (((Boolean) r14).booleanValue() == true) goto L5;
        int r15 = ChatTitleComponent.P1;
    L59:
        return Unit.INSTANCE;
    L5:
        if (r0.p1 == true) goto L59;
        e r16 = r0.V3();
        BotModel r1 = r0.j0();
        boolean r2 = f.a;
        z2 r3 = z2.a;
        boolean r4 = true;
        boolean r5 = false;
        if (r3.getSubConversationNewSimplifySettings() == true) goto L9;
    L11:
        boolean r6 = false;
    L12:
        Boolean r7 = null;
        if (r6 == false) goto L15;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatTitleComponent$startSettings$1$1(r16, r0, r1, null), 3, null);
        goto L59
    L15:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        TraceFragment r8 = a.b(r0, r0);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        TraceFragment r9 = r8;
        if (r16 == null) goto L18;
        String r10 = r16.a;
    L19:
        c r11 = r0.f1();
        BotModel r12 = r0.j0();
        ICoreInputAbility r13 = r0.W3();
        if (r13 == null) goto L22;
        r7 = Boolean.valueOf(r13.Qd(false));
    L22:
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r11, "argumentData");
        r3.w3();
        i r17 = SmartRouter.buildRoute(r9.getContext(), "//flow/chat_setting");
        Bundle r18 = com.larus.utils.f.c(new Pair[0]);
        if (r16 == null) goto L30;
        Integer r19 = r16.f;
        if (r19 == null) goto L30;
        if (r19.intValue() != 1) goto L30;
    L31:
        if (r4 == false) goto L33;
        r18.putString("setting_local_conversation_id", r10);
    L34:
        if (r12 == null) goto L37;
        String r20 = r12.getBotId();
        if (r20 == null) goto L37;
    L38:
        r18.putString("setting_bot_id", r20);
        if (r16 == null) goto L43;
        Integer r110 = r16.v;
        if (r110 == null) goto L43;
        int r111 = r110.intValue();
    L44:
        r18.putInt("setting_bot_cvs_type", r111);
        r18.putParcelable("setting_bot_recommend_from", r11.d);
        r18.putParcelable("argSearchMobParam", r11.e);
        r18.putBoolean("setting_is_immersive_bot", r11.C());
        r18.putString("from_activity_name", r11.e());
        r18.putString("from_activity_module", r11.d());
        ChatControlTrace.b.getClass();
        if (com.larus.utils.o0.d(ChatControlTrace.P) == false) goto L48;
        r18.putString("argBotCaseFrom", ChatControlTrace.P);
    L48:
        if (com.larus.utils.o0.d(ChatControlTrace.L) == false) goto L51;
        r18.putString("create_sub_conv_case_id", ChatControlTrace.L);
    L51:
        if (com.larus.utils.o0.d(ChatControlTrace.M) == false) goto L53;
        r18.putString("create_sub_conv_case_request_id", ChatControlTrace.M);
    L53:
        r18.putString("from_activity_module", r11.d());
        if (r7 == null) goto L56;
        r5 = r7.booleanValue();
    L56:
        r18.putBoolean("setting_is_can_send_image", r5);
        h.k(r18, r9);
        r17.c.putExtras(r18);
        r17.c.addFlags(536870912);
        r17.d = 2130772401;
        r17.e = 2130772399;
        r17.e(100);
    L43:
        r111 = 2;
    L37:
        r20 = "";
        goto L38
    L33:
        r18.putString("setting_conversation_id", r10);
    L30:
        r4 = false;
        goto L31
    L18:
        r10 = null;
        goto L19
    L9:
        if (f.c(r16) == false) goto L11;
        r6 = true;
        goto L12
    }
}
