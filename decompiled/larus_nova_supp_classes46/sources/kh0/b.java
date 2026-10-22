package kh0;

import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.api.o;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final o a(boolean r1) {
        if (r1 == false) goto L5;
        return k.n(IMiddlewareEffectService.class).effectContext(LiveEffectContextFactoryType.DEFAULT).b();
    L5:
        return k.n(IMiddlewareEffectService.class).effectContext(LiveEffectContextFactoryType.LINK).b();
    }
}
