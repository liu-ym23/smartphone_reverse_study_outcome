package com.obric.aikernel.init.tasks.autoupdate;

import android.content.Context;
import com.obric.aikernel.utils.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class AutoUpdateProcessWakeScheduler$sync$1 extends FunctionReferenceImpl implements Function1<Context, Boolean> {
    AutoUpdateProcessWakeScheduler$sync$1(Object r10) {
        super(1, r10, m.class, "isMainProcess", "isMainProcess(Landroid/content/Context;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        return Boolean.valueOf(((m) this.receiver).a(r10));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Context r10) {
        return invoke2(r10);
    }
}
