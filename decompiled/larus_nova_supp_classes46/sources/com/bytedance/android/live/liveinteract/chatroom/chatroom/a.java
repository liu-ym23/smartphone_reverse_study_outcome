package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.config.fj1;
import com.bytedance.android.livesdk.config.gj1;
import com.bytedance.android.livesdk.config.ij1;
import com.bytedance.android.livesdk.config.vi1;
import com.bytedance.android.livesdk.config.wi1;
import com.bytedance.android.livesdk.config.zi1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import jc1.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final Integer a = null;
    public static final Integer b = null;
    public static final Integer c = null;
    public static final Integer d = null;
    public static final Integer e = null;
    public static final Integer f = null;

    static {
        a = (Integer) zi1.a.getValue();
        b = (Integer) ij1.a.getValue();
        c = (Integer) wi1.a.getValue();
        d = (Integer) gj1.a.getValue();
        e = (Integer) vi1.a.getValue();
        f = (Integer) fj1.a.getValue();
    }

    @JvmStatic
    public static final boolean b() {
        int r0 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r0 == 5) goto L13;
        if (r0 == 12) goto L15;
        if (r0 == 8) goto L15;
        if (r0 == 9) goto L13;
        return false;
    L15:
        return vm2.d.w();
    L13:
        return vm2.d.X0();
    }

    public static int c() {
        int r0 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        Integer r3 = 0;
        if (r0 == 5) goto L14;
        if (r0 == 8) goto L10;
        if (r0 == 12) goto L10;
        return 0;
    L10:
        if (vm2.d.w() == false) goto L18;
        r3 = a;
    L18:
        return r3.intValue();
    L14:
        if (vm2.d.X0() == false) goto L17;
        r3 = b;
    L17:
        return r3.intValue();
    }

    @JvmStatic
    public static final boolean a(IRoom r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isThirdParty() == true) goto L76;
        int r1 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        Boolean r2 = m.i().isAnchor();
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L12:
        if (r1 != 5) goto L14;
    L52:
        if (r3 == false) goto L59;
        Integer r6 = f;
        if (r6 == null) goto L59;
        if (r6.intValue() != 1) goto L59;
        boolean r7 = true;
    L60:
        if (r3 == true) goto L67;
        Integer r4 = d;
        if (r4 == null) goto L67;
        if (r4.intValue() != 1) goto L67;
        boolean r8 = true;
    L68:
        if (r7 == true) goto L70;
        if (r8 == true) goto L70;
        return false;
    L70:
        return true;
    L67:
        r8 = false;
    L59:
        r7 = false;
        goto L60
    L14:
        if (r1 != 12) goto L16;
    L20:
        Map r9 = r5.getAnchorABMap();
        if (r9 == null) goto L23;
        String r10 = (String) r9.get("video_anchor_apply_reason_enable");
    L24:
        if (r3 == false) goto L31;
        Integer r11 = e;
        if (r11 == null) goto L31;
        if (r11.intValue() != 1) goto L31;
        boolean r12 = true;
    L32:
        if (r3 == true) goto L39;
        Integer r13 = c;
        if (r13 == null) goto L39;
        if (r13.intValue() != 1) goto L39;
        boolean r14 = true;
    L40:
        if (r12 == true) goto L42;
        if (r14 == true) goto L42;
        return false;
    L42:
        if (r10 != null) goto L44;
    L47:
        boolean r15 = true;
    L48:
        if (r15 == true) goto L70;
        if (CastIntegerProtector.parseInt(r10) == 1) goto L70;
        return false;
    L44:
        if (r10.length() == 0) goto L47;
        r15 = false;
    L39:
        r14 = false;
    L31:
        r12 = false;
        goto L32
    L23:
        r10 = null;
        goto L24
    L16:
        if (r1 == 8) goto L20;
        if (r1 == 9) goto L52;
        return false;
    L10:
        r3 = false;
        goto L12
    L76:
        return false;
    }
}
