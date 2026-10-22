package z0c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.playerconfig.LarkPlayerSettings;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    static {
    }

    public static void b() {
        ArrayList<LarkPlayerSettings.SettingItem> r0 = ((LarkPlayerSettings.MDLSetting) LarkPlayerSettings.c.getValue()).getBase();
        if (r0 == null) goto L44;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L54;
        LarkPlayerSettings.SettingItem r2 = (LarkPlayerSettings.SettingItem) r1.next();
        if (r2.getKey() == Integer.MAX_VALUE) goto L6;
        if (r2.getValue() == null) goto L6;
        if (r2.getType().length() <= 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L6;
        String r4 = r2.getType();
        switch(r4.hashCode()) {
            case -1510353399: goto L40;
            case -891985903: goto L36;
            case 104431: goto L32;
            case 3327612: goto L28;
            case 97526364: goto L24;
            case 564910315: goto L20;
            default: goto L43;
        };
    L43:
        Log.i("LarkPlayerMDLConfig", "set mdl key:" + r2.getDesc() + ", value:" + r2.getValue());
        goto L6
    L20:
        if (r4.equals("int_sync") == false) goto L43;
        int r5 = r2.getKey();
        Object r6 = r2.getValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Double");
        TTVideoEngine.setIntValueSync(r5, (int) ((Double) r6).doubleValue());
        goto L43
    L24:
        if (r4.equals("float") == false) goto L43;
        int r7 = r2.getKey();
        Object r8 = r2.getValue();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Double");
        TTVideoEngine.setFloatValue(r7, (float) ((Double) r8).doubleValue());
        goto L43
    L28:
        if (r4.equals("long") == false) goto L43;
        int r9 = r2.getKey();
        Object r10 = r2.getValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Double");
        TTVideoEngine.setLongValue(r9, (long) ((Double) r10).doubleValue());
        goto L43
    L32:
        if (r4.equals("int") == false) goto L43;
        int r11 = r2.getKey();
        Object r12 = r2.getValue();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Double");
        TTVideoEngine.setIntValue(r11, (int) ((Double) r12).doubleValue());
        goto L43
    L36:
        if (r4.equals("string") == false) goto L43;
        int r13 = r2.getKey();
        Object r14 = r2.getValue();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.String");
        TTVideoEngine.setStringValue(r13, (String) r14);
        goto L43
    L40:
        if (r4.equals("string_sync") == false) goto L43;
        int r15 = r2.getKey();
        Object r16 = r2.getValue();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.String");
        TTVideoEngine.setStringValueSync(r15, (String) r16);
        goto L43
    L14:
        r3 = false;
        goto L15
    L54:
        return;
    }

    @JvmStatic
    public static final void a() {
        a.a();     // Catch: Exception -> L10
        String r0 = jcb.b.c().a("tt_dns_server_host");     // Catch: Exception -> L10
        if (r0 == null) goto L5;
        TTVideoEngine.setStringValue(107, r0);     // Catch: Exception -> L10
        TTVideoEngine.setTTDNSServerHost(r0);     // Catch: Exception -> L10
    L5:
        String r1 = jcb.b.c().a("tt_google_dns");     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        TTVideoEngine.setStringValue(108, r1);     // Catch: Exception -> L10
    L8:
        b();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("LarkPlayerMDLConfig", "config failed:" + e.getMessage());
    }
}
