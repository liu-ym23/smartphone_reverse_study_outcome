package com.obric.cae.utils;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Lambda implements Function1<Bundle, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float[] f7357b;

    public a(String r1, float[] r2) {
        this.f7356a = r1;
        this.f7357b = r2;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Bundle r3) {
        Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$this$setCustomArgs");
        r4.putFloatArray(this.f7356a, this.f7357b);
        return Unit.INSTANCE;
    }
}
