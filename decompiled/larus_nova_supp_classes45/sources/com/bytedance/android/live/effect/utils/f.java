package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(Sticker r1);

        void b(ExceptionResult r1);
    }

    public f() {
    }

    static {
    }

    public static void a(String r4, Sticker r5, com.bytedance.android.livesdk.revenue.service.effect.k.b r6) {
        EffectResourceUtil$tryDownloadSticker$1 r0 = EffectResourceUtil$tryDownloadSticker$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "panel");
        Intrinsics.checkNotNullParameter(r5, "sticker");
        Intrinsics.checkNotNullParameter(r0, "processAction");
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContextFactoryDelegate$Type r2 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        if (LiveEffectContext.a.a(r2).b().r().q(r5) == false) goto L5;
        r5.setDownloading(false);
        r5.setDownloaded(true);
        r6.a(r5);
        return;
    L5:
        r5.setDownloading(true);
        LiveEffectContext.a.a(r2).b().r().g(r4, r5, new g(r6, r0));
    }
}
