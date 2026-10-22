package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline;

import android.content.Context;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = vm2.d.t0().introScheme;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        u6 r1 = new u6(r0);
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.a.b() != 1) goto L8;
        u6 r2 = r1.d("url");
        r2.b("mode_name", SelfDisciplineContext.a.c());
        r2.b("intro_type", "15");
    L8:
        k.n(IBaseLiveActionHandler.class).handle(r4, r1.c());
    }

    public static void a(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "userId");
        String r0 = vm2.d.t0().recordScheme;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        u6 r2 = new u6(r0);
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.a.b() != 1) goto L10;
        String r3 = vm2.d.t0().recordUrlV2;
        if (r3 == null) goto L14;
    L13:
        r1 = r3;
    L14:
        r2.b("url", r1);
        if (Intrinsics.areEqual(je0.d.b0(), r5) == false) goto L17;
        r2.b("height", "480");
    L18:
        r2.d("url").b("to_user_id", r5.toString());
        k.n(IBaseLiveActionHandler.class).handle(r4, r2.c());
        return;
    L17:
        r2.b("height", "420");
        goto L18
    L10:
        r3 = vm2.d.t0().recordUrl;
        if (r3 != null) goto L13;
        goto L13
    }
}
