package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.sticker.presenter.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/presenter/s;", "kotlin.jvm.PlatformType", "invoke", "()Lcom/bytedance/android/live/effect/sticker/presenter/s;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class EffectLivePreviewActivityProxy$aigcTaskManager$2 extends Lambda implements Function0<s> {
    public static final EffectLivePreviewActivityProxy$aigcTaskManager$2 INSTANCE = null;

    static {
        INSTANCE = new EffectLivePreviewActivityProxy$aigcTaskManager$2();
    }

    public EffectLivePreviewActivityProxy$aigcTaskManager$2() {
        super(0);
    }

    public final s invoke() {
        List<String> r0 = LiveEffectContext.h;
        return LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().i();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m845invoke() {
        return invoke();
    }
}
