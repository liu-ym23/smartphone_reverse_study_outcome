package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(b.class, "AI_GUEST_RTC_PARAM", "getAI_GUEST_RTC_PARAM()Lcom/bytedance/android/live/liveinteract/plantform/utils/AIGuestRtcConfig;", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_aigc_rtc_stream_config", new a(), a.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }

    public static final void a(boolean r4, com.bytedance.android.live.liveinteract.plantform.core.y r5, hg6.g r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r5, "mInfoCenter");
        Intrinsics.checkNotNullParameter(r7, "interactID");
        Iterator<ILinkPlayerInfoBridge> r9 = r5.c.iterator();
    L3:
        String r1 = null;
        if (r9.hasNext() == false) goto L8;
        ILinkPlayerInfoBridge r0 = r9.next();
        if (Intrinsics.areEqual(r0.getInteractId(), r7) == false) goto L3;
    L9:
        ILinkPlayerInfoBridge r2 = r0;
        if (r2 == null) goto L43;
        boolean r10 = com.bytedance.android.live.liveinteract.plantform.a.a(r2);
        boolean r3 = true;
        if (r10 == true) goto L14;
        return;
    L14:
        if (r8 != 0) goto L17;
        return;
    L17:
        if (r4 == false) goto L24;
        String r11 = ((a) b.getValue(null, a[0])).b();
        if (r11.length() > 0) goto L22;
        r3 = false;
    L22:
        if (r3 == true) goto L29;
    L30:
        if (r1 != null) goto L32;
        return;
    L32:
        if (r6 == null) goto L45;
        ei6.a r12 = r6.V0();
        if (r12 == null) goto L48;
        JSONObject r13 = new JSONObject();
        r13.put("room_id", r8);
        r13.put("remote_user_id", r7);
        r13.put("stream_index", 0);
        si6.b r14 = r12.b();
        if (r14 == null) goto L46;
        JSONObject r15 = new JSONObject();
        JSONObject r16 = new JSONObject();
        r16.put("config_name", r1);
        r16.put("config_info", r13);
        Unit r17 = Unit.INSTANCE;
        r15.put("rtc.custom_room_stream_config", r16);
        r14.d(r15);
        return;
    L46:
        return;
    L48:
        return;
    L45:
        return;
    L29:
        r1 = r11;
        goto L30
    L24:
        r11 = ((a) b.getValue(null, a[0])).a();
        if (r11.length() > 0) goto L28;
        r3 = false;
    L28:
        if (r3 == false) goto L30;
    L43:
        return;
    L8:
        r0 = null;
        goto L9
    }
}
