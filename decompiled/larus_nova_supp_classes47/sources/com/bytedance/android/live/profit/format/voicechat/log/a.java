package com.bytedance.android.live.profit.format.voicechat.log;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mz0.n;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final Map<String, String> a;
    public String b;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.format.voicechat.log.a$a, reason: collision with other inner class name */
    public static final class C0020a {
        public static void a(String r3, Map r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            Intrinsics.checkNotNullParameter(r4, "params");
            n r0 = new n();
            Map<String, String> r1 = r0.a;
            Intrinsics.checkNotNullParameter(r1, "map");
            Intrinsics.checkNotNullParameter(r4, "map");
            r1.putAll(r4);
            c.b(kr2.a.class).Xj(r3, r0.a, r0.b);
        }
    }

    static {
    }

    public a() {
        this.a = new LinkedHashMap();
        this.b = "";
    }

    public static /* synthetic */ void b(a r1, String r2) {
        r1.a(r2, VoiceChatLogger$sendCommonLog$1.INSTANCE);
    }

    public final void a(String r2, Function0<? extends Map<String, String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "paramsBuilder");
        C0020a.a(r2, MapsKt.plus((Map) r3.invoke(), this.a));
    }
}
