package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o4 {
    public static boolean a = false;
    public static String b = "unknown";
    public static boolean c = true;
    public static boolean d;
    public static boolean e;
    public static boolean f;

    public class a implements Function2<Boolean, String, Unit> {
        public a() {
        }

        public final Object invoke(Object r1, Object r2) {
            String r3 = (String) r2;
            o4.d = ((Boolean) r1).booleanValue();
            return null;
        }
    }

    public static void b(boolean r4) {
        if (r4 == false) goto L5;
        a("live_desktop_business", "leave_live_room", "", "normal", new a());
        return;
    }

    public static void c(String r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("guide_type", r5);
        r0.put("install_type", b);
        com.bytedance.android.livesdk.log.u.l().sendLog(r4, r0, new Object[]{Room.class, am2.x.class});
    }

    public static void a(String r7, String r8, String r9, String r10, Function2 r11) {
        jc1.k.f(IHostBusiness.class).canShowDesktopGuide(r7, r8, r9, r10, "ug_desktop_guide", r11);
    }
}
