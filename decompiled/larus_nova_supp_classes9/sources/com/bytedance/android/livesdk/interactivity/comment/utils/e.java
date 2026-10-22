package com.bytedance.android.livesdk.interactivity.comment.utils;

import am2.x;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final Long a = null;
    public static int b;
    public static boolean c;

    static {
        a = (Long) new SettingKey("live_comment_entry_expose_report_delay_ms", BuildConfig.FLAVOR, 3000L, 3000L).getValue();
    }

    @JvmStatic
    public static final void a(x22.a r5) {
        Intrinsics.checkNotNullParameter(r5, "curHint");
        if (c == true) goto L5;
        return;
    L5:
        j0.l().sendLog("livesdk_live_bottom_comment_default_text_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("default_text", r5.a), TuplesKt.to("default_text_type", r5.getType().getTypeName())}), new Object[]{Room.class, x.class});
    }
}
