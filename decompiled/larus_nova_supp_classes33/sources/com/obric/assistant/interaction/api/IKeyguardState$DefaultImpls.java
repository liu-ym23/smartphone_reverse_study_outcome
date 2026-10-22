package com.obric.assistant.interaction.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class IKeyguardState$DefaultImpls {
    public static void registerKeyguardLockStateChangedListener(IKeyguardState r0, OnKeyguardLockStateChangedListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
    }

    public static void unregisterKeyguardLockStateChangedListener(IKeyguardState r0, OnKeyguardLockStateChangedListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
    }
}
