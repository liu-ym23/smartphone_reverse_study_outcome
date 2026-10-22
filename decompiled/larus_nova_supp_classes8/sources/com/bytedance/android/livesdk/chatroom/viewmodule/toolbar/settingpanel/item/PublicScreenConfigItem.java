package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import com.bytedance.android.livesdk.interactivity.api.settings.config.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PublicScreenConfigItem {
    public static final x a = null;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    static {
        a = f.a();
    }

    public static np1.b a(final np1.c r4) {
        Intrinsics.checkNotNullParameter(r4, "panelContext");
        Intrinsics.checkNotNullParameter(r4, "panelContext");
        boolean r1 = false;
        if (z.e(r4.getDataCenter(), false) == true) goto L12;
        x r0 = a;
        if (r0.enable == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        r1 = true;
        goto L12
    L7:
        if (r0.settingEntryPos != 2) goto L9;
        r2 = true;
    L12:
        if (r1 == true) goto L15;
        return null;
    L15:
        np1.b.a r3 = np1.b.a;
        Function0<g> r5 = new PublicScreenConfigItem$provide$1(r4);
        PublicScreenConfigItem$provide$2 r6 = PublicScreenConfigItem$provide$2.INSTANCE;
        r3.getClass();
        return np1.b.a.a(r5, r6);
    }
}
