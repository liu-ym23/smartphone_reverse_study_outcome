package com.bytedance.android.live.effect.api;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0 implements r {

    public static final class a {
    }

    public static final class b implements IFetchEffectListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function0 b;

        public final void onStart(Effect r1) {
        }

        public final void onSuccess(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((Effect) r2);
        }

        public b(Function1 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFail(Effect r1, ExceptionResult r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.b.invoke();
        }
    }

    static {
    }

    public k0() {
    }

    @Override // com.bytedance.android.live.effect.api.r
    public final void a(String r3, Function1<? super Effect, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "effectId");
        Intrinsics.checkNotNullParameter(r4, "effectHandler");
        Intrinsics.checkNotNullParameter(r5, "failHandler");
        Map<LiveEffectContextFactoryDelegate$Type, e> r0 = u.a;
        u.a(LiveEffectContextFactoryDelegate$Type.VR).getEffectManager().fetchEffect(r3, new b(r4, r5));
    }
}
