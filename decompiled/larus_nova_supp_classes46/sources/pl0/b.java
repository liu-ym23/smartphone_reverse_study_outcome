package pl0;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.lynx.tasm.LynxEnv;
import jc1.k;
import kjc.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (LynxEnv.inst().hasInited() == false) goto L6;
        return;
    L6:
        if ((r6 instanceof Application) == true) goto L8;
        Context r0 = null;
    L9:
        Application r1 = (Application) r0;
        if (r1 != null) goto L15;
        Context r7 = r6.getApplicationContext();
        if ((r7 instanceof Application) == true) goto L14;
        r7 = null;
    L14:
        r1 = (Application) r7;
    L15:
        if (r1 == null) goto L37;
        k.n(IHostAction.class).initLynxEnv();
        c r8 = new c();
        if (2 != kjc.a.a()) goto L29;
        kjc.b r2 = r8.a;
        if (LynxEnv.inst().hasInited() == true) goto L27;
        String r3 = LiveSlardarConstants.suffixError("ttlive_lynx_initial");
        JSONObject r4 = new JSONObject();
        ClassLoader r5 = r4.getClass().getClassLoader();
        if (r5 == null) goto L25;
        String r9 = r5.getClass().toString();
        if (r9 == null) goto L25;
    L26:
        r4.put("class_loader", r9);
        r4.put("status", "1");
        Unit r10 = Unit.INSTANCE;
        LiveSlardarMonitor.monitorEvent(r3, r4, null, null);
    L25:
        r9 = "null";
    L27:
        r2.a = Unit.INSTANCE;
        r8.b = true;
    L29:
        if (r8.b == true) goto L31;
        r8.a.a = Unit.INSTANCE;
    L31:
        Object r11 = r8.a.a;
        Npth.addAttachUserData(a.a, CrashType.ALL);     // Catch: Throwable -> L34
        return;
    L38:
        return;
    L37:
        return;
    L8:
        r0 = r6;
        goto L9
    }
}
