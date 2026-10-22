package com.obric.memorydata.memory.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ8\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/provider/RecorderSettingsCallerPolicy;", "", "<init>", "()V", "RECORDER_PACKAGE_NAME", "", "isRecorderProcessCaller", "", "isSystemCaller", "isSelfCaller", "callingPackages", "", "isAllowed", "isPackageSignatureValid", "Lkotlin/Function1;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10363a = null;

    static {
        f10363a = new e();
    }

    private e() {
    }

    public final boolean a(boolean r2, boolean r3, List<String> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "callingPackages");
        if (r2 == true) goto L8;
        if (r3 == true) goto L8;
        if (Intrinsics.areEqual(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), SetsKt.setOf("com.obric.recorder")) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean a(boolean r3, boolean r4, List<String> r5, Function1<? super String, Boolean> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "callingPackages");
        Intrinsics.checkNotNullParameter(r8, "isPackageSignatureValid");
        if (r3 == true) goto L12;
        if (r4 == false) goto L7;
        return true;
    L7:
        if (a(r3, r4, r7) == true) goto L11;
        return false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke("com.obric.recorder"), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L12:
        return true;
    }
}
