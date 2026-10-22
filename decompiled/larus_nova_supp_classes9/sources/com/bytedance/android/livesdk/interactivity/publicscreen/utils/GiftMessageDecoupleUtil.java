package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.message.model.o7;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.m4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMessageDecoupleUtil {
    static {
    }

    @JvmStatic
    public static final boolean a(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (Intrinsics.areEqual(r2.getMessageMethod(), "WebcastRoomMessage") == true) goto L5;
    L12:
        return false;
    L5:
        if ((r2 instanceof c4) == true) goto L7;
        r2 = null;
    L7:
        c4 r3 = (c4) r2;
        if (r3 == null) goto L12;
        if (r3.isGiftTypeMessage() != true) goto L12;
        return true;
    }

    public static boolean b(tlc.d r2) {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L18;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L18;
        String r3 = r1.n();
        if (r3 == null) goto L18;
        if ((r2 instanceof o7) == false) goto L18;
        IBaseUser r4 = ((o7) r2).getFromUser();
        if (r4 == null) goto L14;
        String r5 = r4.getIdString();
    L16:
        if (Intrinsics.areEqual(r3, r5) == false) goto L18;
        return true;
    L14:
        r5 = null;
    L18:
        return false;
    }

    @JvmStatic
    public static final boolean c(final tlc.d r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        String r1 = null;
        boolean r3 = true;
        if (r0 == null) goto L24;
        com.bytedance.android.livesdk.user.e r2 = r0.user();
        if (r2 == null) goto L24;
        String r4 = r2.n();
        if (r4 == null) goto L24;
        if (a(r5) == false) goto L24;
        if ((r5 instanceof u3) == true) goto L14;
        tlc.d r6 = null;
    L15:
        u3 r7 = (u3) r6;
        if (r7 == null) goto L24;
        IBaseUser r8 = r7.getUserInMessage();
        if (r8 == null) goto L24;
        String r9 = r8.getIdString();
        if (r9 == null) goto L24;
        if (r9.equals(r4) != true) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L28;
        return true;
    L28:
        if ((!Intrinsics.areEqual(r5.getMessageMethod(), "WebcastGiftMessage")) == false) goto L33;
        if ((!Intrinsics.areEqual(r5.getMessageMethod(), "GiftGroupMessage")) == false) goto L33;
        return false;
    L33:
        if ((r5 instanceof o7) == true) goto L35;
        boolean r11 = r5 instanceof kc2.b;
        if (r11 == false) goto L75;
        IMiddlewareUserService r13 = jc1.k.f(IMiddlewareUserService.class);
        if (r13 == null) goto L70;
        com.bytedance.android.livesdk.user.e r14 = r13.user();
        if (r14 == null) goto L70;
        String r15 = r14.n();
        if (r15 == null) goto L70;
        if (r11 == false) goto L70;
        IBaseUser r16 = ((kc2.b) r5).a;
        if (r16 == null) goto L68;
        r1 = r16.getIdString();
    L68:
        if (Intrinsics.areEqual(r15, r1) == false) goto L70;
    L71:
        if (r3 == false) goto L74;
        return false;
    L74:
        return ((kc2.b) r5).h;
    L70:
        r3 = false;
        goto L71
    L75:
        return false;
    L35:
        if (b(r5) == false) goto L42;
        o7 r17 = (o7) r5;
        if (r17.isLocal() == false) goto L39;
    L40:
        PublicScreenTraceMonitor.n("receive self-send GiftMessage", new GiftMessageDecoupleUtil$shouldInterceptGiftMessage$1(r5));
        return false;
    L39:
        if (r17.getDisplayForSelf() == true) goto L40;
    L42:
        o7 r18 = (o7) r5;
        if (r18.getUseRoomMessage() == false) goto L46;
        return true;
    L46:
        if (((Boolean) m4.a.getValue()).booleanValue() == true) goto L48;
    L53:
        return false;
    L48:
        if (b(r5) == false) goto L53;
        if (r18.isLocal() == true) goto L53;
        PublicScreenTraceMonitor.n("intercept msg", GiftMessageDecoupleUtil$shouldInterceptGiftMessage$2.INSTANCE);
        return true;
    L14:
        r6 = r5;
    L24:
        r10 = false;
        goto L25
    }
}
