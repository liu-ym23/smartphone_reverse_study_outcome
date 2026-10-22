package com.obric.memorydata.memory.ui.automemory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryIconRandomizer;", "", "<init>", "()V", "resolveIconKey", "", "semanticKey", "oldIconKey", "stableSeed", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10685a = null;

    static {
        f10685a = new m();
    }

    private m() {
    }

    public final String a(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "stableSeed");
        String r0 = null;
        if (r4 == null) goto L7;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r7 == null) goto L7;
        String r8 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
    L8:
        List r9 = (List) ZeusTransformUtils.preCheckCast(l.f10683a.a().get(r8), List.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L11;
        if (r5 == null) goto L16;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r10 == null) goto L16;
        r0 = r10.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "toLowerCase(...)");
    L16:
        if (r0 == null) goto L21;
        if (r9.contains(r0) == false) goto L21;
        return r0;
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r9.get(Math.floorMod(r6.hashCode(), r9.size())), String.class, "com.obric.memorydata.plugin");
    L11:
        return AutoMemoryResolvedIcon.GENERAL_3.getKey();
    L7:
        r8 = null;
        goto L8
    }
}
