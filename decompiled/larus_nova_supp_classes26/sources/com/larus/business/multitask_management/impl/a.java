package com.larus.business.multitask_management.impl;

import androidx.fragment.app.Fragment;
import com.larus.business.multitask_management.impl.fullscreen.MultiTaskManagementFullscreenFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    public final Object invoke(Object r2) {
        Fragment r3 = (Fragment) r2;
        int r0 = MultiTaskServiceImpl.e;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(r3 instanceof MultiTaskManagementFullscreenFragment);
    }
}
