package com.bytedance.android.live.core.setting.v2.update;

import a70.c;
import b70.a;
import com.bytedance.android.live.core.setting.d6;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w60.b;
import z60.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SettingIncStrategy {
    public static final b a = null;
    public static final List<a> b = null;
    public static volatile boolean c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "", "COLD_LAUNCH", "FRONTIER", "STICK", "OBJECT", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final enum IncScene extends Enum<IncScene> {
        public static final IncScene COLD_LAUNCH = null;
        public static final IncScene FRONTIER = null;
        public static final IncScene OBJECT = null;
        public static final IncScene STICK = null;
        public static final /* synthetic */ IncScene[] a = null;

        static {
            IncScene r1 = new IncScene("COLD_LAUNCH", 0);
            COLD_LAUNCH = r1;
            IncScene r2 = new IncScene("FRONTIER", 1);
            FRONTIER = r2;
            IncScene r3 = new IncScene("STICK", 2);
            STICK = r3;
            IncScene r4 = new IncScene("OBJECT", 3);
            OBJECT = r4;
            a = new IncScene[]{r1, r2, r3, r4};
        }

        public static IncScene valueOf(String r1) {
            return (IncScene) r27.a.a(IncScene.class, r1);
        }

        public static IncScene[] values() {
            return (IncScene[]) a.clone();
        }

        public IncScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        a = new b();
        b = new ArrayList();
    }

    public static void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "updateListener");
        ArrayList r0 = (ArrayList) b;
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
        return;
    }

    public static boolean b(IncScene r12, JsonObject r13, JsonObject r14) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        String r3 = null;
        a70.b.e("_MAIN", "///...............................开始更新数据, scene = " + r12.name() + ": ......................///");     // Catch: Exception -> L16
        a70.b.f("incUpdate");     // Catch: Exception -> L16
        int r2 = b70.b.a[r12.ordinal()];     // Catch: Exception -> L16
        if (r2 != 1) goto L6;
        boolean r15 = new z60.b(new z60.a()).update(r13, r14, null);     // Catch: Exception -> L16
    L10:
        c = true;     // Catch: Exception -> L16
        b r4 = a;     // Catch: Exception -> L16
        r4.d(r4.b());     // Catch: Exception -> L16
        Iterator r5 = ((ArrayList) b).iterator();     // Catch: Exception -> L16
    L12:
        if (r5.hasNext() == false) goto L14;
        a r6 = (a) r5.next();     // Catch: Exception -> L16
        IncScene r7 = IncScene.COLD_LAUNCH;     // Catch: Exception -> L16
        r6.onSuccess();     // Catch: Exception -> L16
        goto L12
    L14:
        a70.b.a("incUpdate");     // Catch: Exception -> L16
        a70.b.e("_MAIN", "///...............................更新数据结束, 结果为: " + r15 + ".............................................///");     // Catch: Exception -> L16
        return r15;
    L6:
        if (r2 == 2) goto L8;
        r15 = false;
        goto L10
    L8:
        r15 = new z60.b(new d()).update(r13, r14, null);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Map<String, Long> r0 = a70.b.a;
        Intrinsics.checkNotNullParameter(e, "e");
        d6.a("SettingReportMonitor_MAIN", e);
        if (r14 == null) goto L22;
        JsonElement r16 = r14.get("setting_update_mode");
        if (r16 == null) goto L22;
        r3 = r16.getAsString();
    L22:
        String r17 = "full";
        if (Intrinsics.areEqual(r3, "full") == true) goto L26;
        r17 = "incr";
    L26:
        String r8 = r17;
        if (r12 != IncScene.COLD_LAUNCH) goto L29;
        String r18 = "clod";
    L30:
        c.a(1, r8, r18, null, -1, -1, e.getMessage());
        return false;
    L29:
        r18 = "frontier";
        goto L30
    }
}
