package com.xiphias.browser.scanner.barcode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a7\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"resolveCameraZoomFactor", "", "requested", "supportedMin", "supportedMax", "current", "minimumDelta", "(FFFFF)Ljava/lang/Float;", "scanner_selectedRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final Float a(float r4, float r5, float r6, float r7, float r8) {
        boolean r1 = true;
        if (Float.isInfinite(r4) == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        if (r4 > 0.0f) goto L14;
        return null;
    L14:
        if (Float.isInfinite(r5) == false) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L21;
        return null;
    L21:
        if (Float.isInfinite(r6) == false) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r3 == true) goto L29;
        return null;
    L29:
        if (r5 <= r6) goto L31;
        return null;
    L31:
        Float r9 = Float.valueOf(RangesKt.coerceIn(r4, r5, r6));
        if (Math.abs(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).floatValue() - r7) >= r8) goto L35;
        r1 = false;
    L35:
        if (r1 == true) goto L37;
        return null;
    L37:
        return r9;
    L23:
        if (Float.isNaN(r6) == true) goto L25;
        r3 = true;
        goto L26
    L16:
        if (Float.isNaN(r5) == true) goto L18;
        r2 = true;
        goto L19
    L5:
        if (Float.isNaN(r4) == true) goto L7;
        r0 = true;
        goto L9
    }
}
