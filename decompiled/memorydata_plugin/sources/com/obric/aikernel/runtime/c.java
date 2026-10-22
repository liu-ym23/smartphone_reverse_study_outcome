package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/runtime/PackageDumpCommandParser;", "", "()V", "parse", "Lcom/obric/aikernel/runtime/PackageDumpCommand;", "args", "", "", "parseUpdateTargetBackground", "Lcom/obric/aikernel/runtime/PackageDumpCommand$UpdateTargetBackground;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6192a = null;

    static {
        f6192a = new c();
    }

    private c() {
    }

    private final b.c b(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r7, 1), String.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L25;
        int r3 = r7.size();
        if (r3 != 3) goto L13;
        b.c r4 = new b.c(r1, "", (String) ZeusTransformUtils.preCheckCast(r7.get(2), String.class, "com.obric.memorydata.plugin"));
    L17:
        if (r4 != null) goto L19;
        return null;
    L19:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L21;
        return null;
    L21:
        return r4;
    L13:
        if (r3 == 4) goto L15;
        r4 = null;
        goto L17
    L15:
        r4 = new b.c(r1, (String) ZeusTransformUtils.preCheckCast(r7.get(2), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.get(3), String.class, "com.obric.memorydata.plugin"));
        goto L17
    L25:
        return null;
    }

    public final b a(List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "args");
        String r0 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r8), String.class, "com.obric.memorydata.plugin");
        b.C0276b r2 = null;
        if (r0 == null) goto L40;
        int r3 = r0.hashCode();
        if (r3 == (-632373700)) goto L29;
        if (r3 == 546429833) goto L18;
        if (r3 == 1898063526) goto L12;
        return null;
    L12:
        if (r0.equals("update_target_background") == false) goto L43;
        Object r6 = b(r8);
    L15:
        Object r9 = ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
    L41:
        return (b) r9;
    L43:
        return null;
    L18:
        if (r0.equals("download_status") == false) goto L44;
        String r1 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r8, 1), String.class, "com.obric.memorydata.plugin");
        String r4 = "";
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        String r10 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r8, 2), String.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L27;
        r4 = r10;
    L27:
        r6 = new b.a(r1, r4);
        goto L15
    L44:
        return null;
    L29:
        if (r0.equals("request_all_background") == false) goto L45;
        String r11 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r8, 1), String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L34;
    L39:
        r9 = ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
        goto L41
    L34:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L37;
        r11 = null;
    L37:
        if (r11 == null) goto L39;
        r2 = new b.C0276b(r11);
        goto L39
    L45:
        return null;
    L40:
        return null;
    }
}
