package xe0;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static final int a = 0;
    public static final int b = 0;

    public static boolean b() {
        if (o.o(null) == false) goto L5;
        return false;
    L5:
        Room r0 = m.i().getCurrentRoom();
        if (r0 == null) goto L13;
        RoomExtra r1 = r0.getExtra();
        if (r1 == null) goto L13;
        if (r1.isGroupLiveGame() != true) goto L13;
        return false;
    L13:
        if (qi0.e.c() == false) goto L15;
        return false;
    L15:
        Integer r2 = (Integer) b6.j.getValue();
        if (r2 != null) goto L19;
    L20:
        return false;
    L19:
        if (r2.intValue() != 0) goto L20;
        if (((Number) b6.z.getValue()).intValue() >= a) goto L29;
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.A;
        if (((Number) r3.getValue()).longValue() > 0) goto L26;
    L28:
        return true;
    L26:
        if ((System.currentTimeMillis() - ((Number) r3.getValue()).longValue()) > b) goto L28;
    L29:
        return false;
    }

    static {
        a = vm2.h.j().a();
        b = vm2.h.j().b() * 60000;
    }

    public static boolean a() {
        ReadOnlyProperty r0 = vm2.d.g7;
        KProperty[] r1 = vm2.d.a;
        if (((Boolean) r0.getValue(null, r1[419(0x1a3, float:5.87E-43)])).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) vm2.d.l7.getValue(null, r1[424(0x1a8, float:5.94E-43)])).booleanValue() == true) goto L8;
        return false;
    }

    public static boolean c() {
        return ((Boolean) vm2.d.h7.getValue(null, vm2.d.a[420(0x1a4, float:5.89E-43)])).booleanValue();
    }

    public static boolean d() {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        if (LinkmicOnlineFloatWindowManager.c.a().r == null) goto L5;
    L14:
        return true;
    L5:
        if (LinkmicOnlineFloatWindowManager.c.a().x != null) goto L14;
        com.bytedance.live.datacontext.m r1 = m.d().m();
        if (r1 != null) goto L10;
        return false;
    L10:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L15;
        return true;
    L15:
        return false;
    }
}
