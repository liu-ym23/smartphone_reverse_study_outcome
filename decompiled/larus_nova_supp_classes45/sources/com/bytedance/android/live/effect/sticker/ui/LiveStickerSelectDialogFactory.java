package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveStickerSelectDialogFactory {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final LiveEffectScene r2, final d2 r3, final Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "liveEffectScene");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "callback");
        String r0 = r3.c;
        Function1<Sticker, Unit> r1 = new LiveStickerSelectDialogFactory$createLiveStickerSelectDialog$1(r4, r2, r3);
        if (r0.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        r1.invoke(null);
        return;
    L8:
        List<String> r6 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(r0, new h(r1));
        return;
    L5:
        r5 = false;
        goto L6
    }
}
