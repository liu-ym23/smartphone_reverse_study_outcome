package com.obric.aikernel.runtime;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class VmEngine$vmExecuteRaw$2 extends Lambda implements Function1<Bundle, Unit> {
    public static final VmEngine$vmExecuteRaw$2 INSTANCE = null;

    static {
        INSTANCE = new VmEngine$vmExecuteRaw$2();
    }

    VmEngine$vmExecuteRaw$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Bundle r3) {
        invoke2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
    }
}
