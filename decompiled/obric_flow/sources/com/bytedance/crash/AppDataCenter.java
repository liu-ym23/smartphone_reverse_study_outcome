package com.bytedance.crash;

import com.bytedance.crash.util.ListMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppDataCenter extends ListMap<CrashType, AttachUserData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICrashFilter f4024b;

    public AppDataCenter() {
        this.f4023a = new HashMap();
    }

    public final void a(AttachUserData r10, CrashType r11) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (r11 != CrashType.ALL) goto L8;
        a(r10, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE, CrashType.CUSTOM_JAVA});     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L8:
        a(r11).add(r10);     // Catch: Throwable -> L6
        goto L9
    }

    public final void a(CrashType r5, AttachUserData r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r5 != CrashType.ALL) goto L11;
        Iterator r11 = values().iterator();     // Catch: Throwable -> L9
    L7:
        if (r11.hasNext() == false) goto L12;
        ((List) r11.next()).remove(r10);     // Catch: Throwable -> L9
    L12:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        a(r5).remove(r10);     // Catch: Throwable -> L9
        goto L12
    }

    public static void a(JSONObject r10) {
        Map r5 = n.d().u();
        if (r10 == null) goto L21;
        String[] r11 = {"filters", "plugin_version"};     // Catch: Throwable -> L16
        JSONObject r12 = mh.e.q(r10, r11);     // Catch: Throwable -> L16
        if (r12 != null) goto L8;
        String r13 = null;
    L9:
        if (r13 == null) goto L13;
        if (r13 == "") goto L13;
        return;
    L13:
        if (r5.containsKey("tv_plugin_version") == false) goto L20;
        z8.c.l(r10, "filters", "plugin_version", r5.get("tv_plugin_version"));     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L8:
        r13 = r12.optString(r11[1]);     // Catch: Throwable -> L16
    L22:
        return;
    }
}
