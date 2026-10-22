package com.bytedance.android.live.room.api.playopt.topspeed;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements LevelAbility {
    public final String a;

    public final void onPropertyChange(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a = r2;
    }

    public final boolean onLevelChange(int r7) {
        TopSpeedModeManager r0 = TopSpeedModeManager.l;
        List<g61.a> r1 = TopSpeedModeManager.l.i.get(this.a);
        StringBuilder r2 = new StringBuilder("the scene listeners size ");
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.size());
    L6:
        r2.append(r3);
        ALogger.w("LiveTopSpeedLog", r2.toString());
        boolean r4 = false;
        if (r7 >= 0) goto L14;
        if (r1 == null) goto L13;
        Iterator<T> r8 = r1.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        r4 = ((g61.a) r8.next()).b();
        ALogger.w("LiveTopSpeedLog", "the scene " + this.a + " was degrade");
    L13:
        TopSpeedModeManager r9 = TopSpeedModeManager.l;
        TopSpeedModeManager r10 = TopSpeedModeManager.l;
        String r5 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "scene");
        r10.c.add(r5);
    L20:
        return r4;
    L14:
        if (r1 == null) goto L19;
        Iterator<T> r12 = r1.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        r4 = ((g61.a) r12.next()).a();
        ALogger.w("LiveTopSpeedLog", "the scene " + this.a + " was origin");
    L19:
        TopSpeedModeManager r13 = TopSpeedModeManager.l;
        TopSpeedModeManager r14 = TopSpeedModeManager.l;
        String r6 = this.a;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r6, "scene");
        r14.c.remove(r6);
        goto L20
    L5:
        r3 = null;
        goto L6
    }
}
