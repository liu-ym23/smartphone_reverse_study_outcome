package io.reactivex.exceptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static void a(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, VirtualMachineError.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, ThreadDeath.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r2, LinkageError.class) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) ZeusTransformUtils.preCheckCast(r2, LinkageError.class, "com.obric.memorydata.plugin"));
    L12:
        throw ((ThreadDeath) ZeusTransformUtils.preCheckCast(r2, ThreadDeath.class, "com.obric.memorydata.plugin"));
    L14:
        throw ((VirtualMachineError) ZeusTransformUtils.preCheckCast(r2, VirtualMachineError.class, "com.obric.memorydata.plugin"));
    }
}
