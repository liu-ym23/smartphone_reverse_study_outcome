package com.larus.voice.output.volume;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class IZeroVolumeHandlerKt {
    public static final void a(c r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new IZeroVolumeHandlerKt$mobZeroVolumeToast$1(r7, null), 2, null);
    }
}
