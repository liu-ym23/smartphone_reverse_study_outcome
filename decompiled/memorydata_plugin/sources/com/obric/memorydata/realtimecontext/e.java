package com.obric.memorydata.realtimecontext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"EXTRA_VISIBLE_TO_USER", "", "toBooleanStrictOrNullIgnoreCase", "", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "toDoubleOrNullFlexible", "", "(Ljava/lang/Object;)Ljava/lang/Double;", "realtime_context_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final /* synthetic */ Double a(Object r0) {
        return d(r0);
    }

    public static final /* synthetic */ Boolean b(Object r0) {
        return c(r0);
    }

    private static final Boolean c(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L6;
        return (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L15;
        String r4 = ((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        if (Intrinsics.areEqual(r4, "true") == false) goto L12;
        boolean r5 = true;
    L16:
        return Boolean.valueOf(r5);
    L12:
        if (Intrinsics.areEqual(r4, "false") == false) goto L17;
        r5 = false;
        goto L16
    L17:
        return null;
    L15:
        return null;
    }

    private static final Double d(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L6;
        return Double.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).doubleValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L11;
        return null;
    L11:
        return StringsKt.toDoubleOrNull((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    }
}
