package com.larus.audio.call;

import com.larus.im.internal.audio.u;
import com.larus.im.internal.d;
import com.larus.im.internal.utils.x;
import com.larus.im.service.audio.autotest.SaveEncodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public final SaveEncodeType a;
    public final String b;

    public final void a() {
        if (c78.a.g.getBoolean("keva_rtc_video_dump_enable", false) == true) goto L5;
        return;
    L5:
        int r0 = com.larus.im.a.a;
        gd9.o r1 = d.a;
        u.c.getClass();
        x r2 = x.a;
        com.larus.audio.call.util.e.a.i(this.b, "[start]: dumper: null, with saveEncodeType: " + this.a);
    }

    public final void b(com.larus.im.service.audio.u r5) {
        if (c78.a.g.getBoolean("keva_rtc_video_dump_enable", false) == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        com.larus.audio.call.util.e.a.d(this.b, "[startSavingFile] frame: " + r5);
    }

    public l(boolean r1, SaveEncodeType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "saveEncodeType");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a = r2;
        this.b = "RawVideoFileSaver_" + r3 + '_' + hashCode();
    }
}
