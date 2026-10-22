package m90;

import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.depend.prefs.PropertyCache;
import java.util.EnumMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements a<T> {
    public final EnumMap<LiveEffectContextFactoryDelegate$Type, Property<T>> a;
    public final String b;
    public final T c;

    @Override // m90.a
    public final T b(LiveEffectContextFactoryType r2) {
        return c((LiveEffectContextFactoryDelegate$Type) ((IMiddlewareEffectService) k.f(IMiddlewareEffectService.class)).convertLiveEffectContextFactoryType(r2));
    }

    public final T c(LiveEffectContextFactoryDelegate$Type r3) {
        if (r3 != null) goto L4;
        r3 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
    L4:
        d(r3);
        Property<T> r0 = this.a.get(r3);
        T r1 = (T) f.b(r0);
        if (r1 != null) goto L8;
        T r2 = (T) PropertyCache.getValue(r0);
        e(r3, r2);
        return r2;
    L8:
        return r1;
    }

    public final void d(LiveEffectContextFactoryDelegate$Type r6) {
        if (this.a.containsKey(r6) == false) goto L8;
        if (this.a.get(r6) == null) goto L8;
        return;
    L8:
        if (r6.getSpName() != null) goto L10;
        this.a.put(r6, new Property(this.b, this.c));
        return;
    L10:
        this.a.put(r6, new Property(r6.getSpName(), this.b, this.c));
    }

    public c(String r3, T r4) {
        this.a = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        this.b = r3;
        this.c = r4;
    }

    @Override // m90.a
    public final void a(LiveEffectContextFactoryType r2, T r3) {
        e((LiveEffectContextFactoryDelegate$Type) ((IMiddlewareEffectService) k.f(IMiddlewareEffectService.class)).convertLiveEffectContextFactoryType(r2), r3);
    }

    public final void e(LiveEffectContextFactoryDelegate$Type r2, T r3) {
        if (r2 != null) goto L4;
        r2 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
    L4:
        d(r2);
        f.d(this.a.get(r2), r3);
    }
}
