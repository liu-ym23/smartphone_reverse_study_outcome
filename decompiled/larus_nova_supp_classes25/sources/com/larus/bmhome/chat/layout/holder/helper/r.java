package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.trace.tracknode.TraceFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public r() {
    }

    public static boolean a(Fragment r11, Message r12, com.larus.bmhome.chat.api.q0.a r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "data");
        TraceFragment r0 = null;
        if (r11 == null) goto L8;
        Context r1 = r11.getContext();
        if (r1 == null) goto L8;
    L7:
        Context r7 = r1;
        Map r2 = r12.getExt();
        if (r2 == null) goto L16;
        String r3 = (String) r2.get("onboarding_from");
    L17:
        boolean r4 = Intrinsics.areEqual(r3, "meeting_minutes");
        if (r14 != null) goto L22;
        if (r4 == false) goto L21;
        r14 = "long_press_meeting_record_create_button";
        goto L22
    L21:
        r14 = "long_press_message_create";
    L22:
        String r8 = r14;
        if (r15 != null) goto L27;
        if (r4 == false) goto L26;
        r15 = "pc";
        goto L27
    L26:
        String r10 = null;
    L28:
        IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r16 == null) goto L58;
        r16.N();
        com.larus.home.impl.sdk.n1 r5 = com.larus.home.impl.sdk.n1.a;
        if (r13 == null) goto L36;
        com.larus.bmhome.chat.component.cvs.y r17 = r13.u0();
        if (r17 == null) goto L36;
        String r18 = r17.Y1();
        if (r18 == null) goto L36;
    L37:
        String r6 = r18;
        if (r13 == null) goto L44;
        com.larus.bmhome.chat.component.cvs.y r19 = r13.u0();
        if (r19 == null) goto L44;
        wc9.e r110 = r19.h();
        if (r110 == null) goto L44;
        boolean r9 = ic8.n.v(r110);
    L45:
        if (r13 == null) goto L49;
        com.larus.bmhome.chat.component.cvs.y r111 = r13.u0();
        if (r111 == null) goto L49;
        String r20 = r111.getBotId();
    L51:
        if ((r11 instanceof TraceFragment) == false) goto L53;
        r0 = (TraceFragment) r11;
    L53:
        if (r0 == null) goto L56;
        String r112 = r0.k();
        if (r112 == null) goto L56;
    L57:
        r5.Q1(r12, r6, r9, r20, r7, r8, r112, r10);
    L56:
        r112 = "chat";
    L49:
        r20 = null;
    L44:
        r9 = true;
    L36:
        r18 = "";
    L58:
        return true;
    L27:
        r10 = r15;
        goto L28
    L16:
        r3 = null;
    L8:
        if (r11 == null) goto L10;
        r1 = r11.getActivity();
    L11:
        if (r1 != null) goto L7;
        return false;
    L10:
        r1 = null;
        goto L11
    }
}
