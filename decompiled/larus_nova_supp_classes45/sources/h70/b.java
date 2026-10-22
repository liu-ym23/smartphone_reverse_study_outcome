package h70;

import android.content.Context;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b {
    public z70.b a;
    public final Context b;
    public final IAbilityCenter c;

    public IAbilityCenter a() {
        return this.c;
    }

    public Context getContext() {
        return this.b;
    }

    public b(Context r3) {
        AbilityCenter r0 = new AbilityCenter();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "abilityCenter");
        this.b = r3;
        this.c = r0;
    }
}
