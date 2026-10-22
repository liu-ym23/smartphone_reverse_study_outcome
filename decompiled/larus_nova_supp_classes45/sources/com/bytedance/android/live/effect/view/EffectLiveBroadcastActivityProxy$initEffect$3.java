package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class EffectLiveBroadcastActivityProxy$initEffect$3 extends Lambda implements Function0<Unit> {
    public static final EffectLiveBroadcastActivityProxy$initEffect$3 INSTANCE = null;

    static {
        INSTANCE = new EffectLiveBroadcastActivityProxy$initEffect$3();
    }

    public EffectLiveBroadcastActivityProxy$initEffect$3() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m843invoke() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().c(d0.c);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m843invoke();
        return Unit.INSTANCE;
    }
}
