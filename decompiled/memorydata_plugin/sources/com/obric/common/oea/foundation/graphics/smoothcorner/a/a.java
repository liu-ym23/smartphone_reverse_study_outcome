package com.obric.common.oea.foundation.graphics.smoothcorner.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J@\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/BasicRoundCornerImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "()V", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "", "top", "right", "bottom", "radius", "drawSmoothCornerRect", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7758b;

    public a() {
        this.f7758b = "BasicRoundCornerImpl";
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public Path a(float r1, float r2, float r3, float r4, float r5) {
        return b(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public void a(Canvas r9, Paint r10, float r11, float r12, float r13, float r14, float r15) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r10, "paint");
        r9.drawRoundRect(r11, r12, r13, r14, r15, r15, r10);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public String getType() {
        return this.f7758b;
    }
}
