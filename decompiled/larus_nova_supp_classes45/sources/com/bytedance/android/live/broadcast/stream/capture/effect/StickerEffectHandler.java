package com.bytedance.android.live.broadcast.stream.capture.effect;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StickerEffectHandler extends ov0.a {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public StickerEffectHandler() {
        this.a = LazyKt.lazy(StickerEffectHandler$composerManager$2.INSTANCE);
        this.b = LazyKt.lazy(new StickerEffectHandler$renderFilterEffectMsgListener$2(this));
        this.c = LazyKt.lazy(new StickerEffectHandler$renderFilterFaceDetectListener$2(this));
        this.d = LazyKt.lazy(StickerEffectHandler$renderFilterExpressionDetectListener$2.INSTANCE);
    }
}
