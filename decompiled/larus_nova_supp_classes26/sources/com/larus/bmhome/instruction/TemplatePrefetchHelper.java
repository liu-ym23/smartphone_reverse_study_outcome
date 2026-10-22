package com.larus.bmhome.instruction;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TemplatePrefetchHelper implements m {
    public boolean a;

    public TemplatePrefetchHelper() {
    }

    @Override // com.larus.bmhome.instruction.m
    public final void b(Integer r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TemplatePrefetchHelper$prefetchTemplateBitmapOnDestroy$1(r7, null), 2, null);
    }

    @Override // com.larus.bmhome.instruction.m
    public final void a(LifecycleCoroutineScope r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleScope");
        BuildersKt.launch$default(r8, Dispatchers.getIO(), null, new TemplatePrefetchHelper$prefetchTemplateBitmapOnCreate$1(r9, null), 2, null);
    }
}
