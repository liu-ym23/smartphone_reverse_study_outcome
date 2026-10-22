package com.bytedance.android.live.effect.beauty.presets;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ LiveBeautyPresetsFragment a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ List c;
    public final /* synthetic */ LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 d;

    public n(LiveBeautyPresetsFragment r1, Ref.ObjectRef r2, List r3, LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        if (((AtomicBoolean) this.b.element).compareAndSet(false, true) == false) goto L6;
        ALogger.e("LiveBeautyPresetsFragment", "waitForRestoreComplete timeout after 10 seconds, force update UI");
        LiveBeautyPresetsFragment.S90(this.a, this.c);
        List<String> r5 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.a.d).a().A(this.d);
        return;
    }
}
