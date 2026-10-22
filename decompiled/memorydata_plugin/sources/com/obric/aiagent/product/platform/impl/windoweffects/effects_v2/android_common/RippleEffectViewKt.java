package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"normalizedDeviceValue", "", "product-platform_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RippleEffectViewKt {
    public static final /* synthetic */ String access$normalizedDeviceValue(String r0) {
        return normalizedDeviceValue(r0);
    }

    private static final String normalizedDeviceValue(String r2) {
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r3;
    }
}
