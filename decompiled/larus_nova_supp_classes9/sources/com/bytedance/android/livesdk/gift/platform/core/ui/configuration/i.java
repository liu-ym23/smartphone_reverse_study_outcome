package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public final GiftEffectSwitchConfigType a;
    public final String b;
    public final Function1<Switch, Unit> c;
    public final Function1<Switch, Unit> d;
    public final boolean e;
    public final Function0<Unit> f;
    public final String g;

    public final GiftEffectSwitchConfigType getType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(GiftEffectSwitchConfigType r2, String r3, Function1<? super Switch, Unit> r4, Function1<? super Switch, Unit> r5, boolean r6, Function0<Unit> r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "initialCheckStatus");
        Intrinsics.checkNotNullParameter(r5, "onCheckStateChanged");
        Intrinsics.checkNotNullParameter(r8, "hintAccessibilityTag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
