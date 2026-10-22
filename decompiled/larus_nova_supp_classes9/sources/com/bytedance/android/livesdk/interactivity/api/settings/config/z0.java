package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;
import r52.j4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0 {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean b() {
        Integer r0 = (Integer) j4.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    static {
    }

    @JvmStatic
    public static final boolean a(boolean r2, IRoom r3) {
        if (r2 == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L7;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L24;
        Integer r5 = (Integer) j4.a.getValue();
        if (r5 != null) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r5.intValue() != 1) goto L19;
        r6 = true;
        goto L20
    L24:
        return false;
    L7:
        if (r3.isMediaRoom() == false) goto L9;
    L10:
        r4 = true;
        goto L12
    L9:
        if (r3.isMergeVSRoom() == false) goto L11;
        goto L10
    }

    @JvmStatic
    public static final boolean c(boolean r2, IRoom r3) {
        if (r2 == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L7;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        return false;
    L14:
        if (b() == false) goto L19;
        return true;
    L19:
        return false;
    L7:
        if (r3.isMediaRoom() == false) goto L9;
    L10:
        r4 = true;
        goto L12
    L9:
        if (r3.isMergeVSRoom() == false) goto L11;
        goto L10
    }
}
