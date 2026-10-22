package com.bytedance.android.livesdk.interactivity.base.im;

import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements c {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) bc2.b.a.getValue()).booleanValue();
    }

    public final void b(String r3) {
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a314.a999").addArg("info", r3), "RoomChannelMessageTracer");
    }

    public final void c(Set r13) {
        Intrinsics.checkNotNullParameter(r13, "channels");
        b("channel changed, channels is " + CollectionsKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null));
    }

    public final void log(String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LocalTestManager.a(new Class[]{wy.a.class});
        if (LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG().b() == false) goto L8;
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b3000").addArg("info", r4), "RoomChannelMessageTracer");
        return;
    }
}
