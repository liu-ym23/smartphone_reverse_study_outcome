package hs1;

import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends AbilityCenter {
    public final String a;

    public a() {
        Intrinsics.checkNotNullParameter("BroadcastStreamPage", "tag");
        this.a = "BroadcastStreamPage";
    }

    public final <T extends IAbility> T getAbility(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        T r0 = (T) super.getAbility(r4);
        if (r0 == null) goto L5;
    L7:
        ALogger.i(this.a, "getAbility: ".concat(r4.getSimpleName()));
        return r0;
    L5:
        if (v.a() == false) goto L7;
        SafetyGuard.a(null, null, this.a + " getAbility " + r4.getSimpleName() + " is null");
        ALogger.e(this.a, Log.getStackTraceString(new Exception()));
        goto L7
    }

    public final <T extends IAbility> void unregisterAbility(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        ALogger.i(this.a, "registerAbility: ".concat(r4.getSimpleName()));
        super.unregisterAbility(r4);
    }

    public final <T extends IAbility> void registerAbility(Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "ability");
        ALogger.i("StartLiveSceneAbilityCenter", "registerAbility: ".concat(r3.getSimpleName()));
        super.registerAbility(r3, r4);
    }
}
