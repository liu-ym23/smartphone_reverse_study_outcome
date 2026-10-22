package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific.util.units;

import android.content.res.Resources;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"density", "", "getDensity", "()F", "density$delegate", "Lkotlin/Lazy;", "dp", "", "getDp", "(I)F", "(F)F", "product-platform_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DisplayUnitsKt {
    private static final Lazy density$delegate = null;

    static {
        density$delegate = LazyKt.lazy($$Lambda$DisplayUnitsKt$z9fHfusf0F2T1qohFLWrwVcSx18.INSTANCE);
    }

    private static final float density_delegate$lambda$0() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static final float getDensity() {
        return ((Number) ZeusTransformUtils.preCheckCast(density$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).floatValue();
    }

    public static final float getDp(float r1) {
        return r1 * getDensity();
    }

    public static final float getDp(int r1) {
        return r1 * getDensity();
    }

    public static /* synthetic */ float lambda$z9fHfusf0F2T1qohFLWrwVcSx18() {
        return density_delegate$lambda$0();
    }
}
