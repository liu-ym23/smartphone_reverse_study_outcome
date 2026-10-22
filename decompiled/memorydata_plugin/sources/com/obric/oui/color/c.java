package com.obric.oui.color;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"toConfig", "Lcom/obric/oui/color/BlendConfig;", "Lcom/obric/oui/color/BlendConfigCore;", "toConfigArray", "", "([Lcom/obric/oui/color/BlendConfigCore;)[Lcom/obric/oui/color/BlendConfig;", "toCoreArray", "([Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {
    public static final a a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new a(r2.a(), r2.b());
    }

    public static final a[] a(b[] r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(a(r6[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new a[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (a[]) ZeusTransformUtils.preCheckCast(r7, a[].class, "com.obric.memorydata.plugin");
    }

    public static final b[] a(a[] r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(r6[r4].c());
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new b[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (b[]) ZeusTransformUtils.preCheckCast(r7, b[].class, "com.obric.memorydata.plugin");
    }
}
