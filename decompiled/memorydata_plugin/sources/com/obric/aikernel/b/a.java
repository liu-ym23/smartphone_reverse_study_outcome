package com.obric.aikernel.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\n¨\u0006\u000b"}, d2 = {"Lcom/obric/aikernel/dump/DumpHelper;", "", "()V", "dumpPackage", "", "", "", "printer", "Ljava/io/PrintWriter;", "cmd", "Lkotlin/Function1;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5986a = null;

    static {
        f5986a = new a();
    }

    private a() {
    }

    public final void a(List<String> r2, PrintWriter r3, Function1<? super String, Unit> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "printer");
        Intrinsics.checkNotNullParameter(r5, "cmd");
        String r6 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r1, 1), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        r5.invoke(r6);
        Unit r7 = Unit.INSTANCE;
    L6:
        if (r7 != null) goto L9;
        r3.println("target package name required");
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
