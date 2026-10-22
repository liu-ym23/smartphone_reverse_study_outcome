package com.obric.common.oea.style.scene.qsanim.a;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u001e\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/KtExt;", "", "()V", "dampedClamp", "", "input", "threshold", "factor", "safeCastTo", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Ljava/lang/Object;", "AutoExpireFlag", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7828a = null;

    static {
        f7828a = new b();
    }

    private b() {
    }

    public static /* synthetic */ float a(b r0, float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 1.0f;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final float a(float r4, float r5, float r6) {
        boolean r3 = false;
        float r0 = 0;
        if (r5 < r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L24;
        if (r6 >= r0) goto L10;
    L12:
        if (r3 == false) goto L22;
        if (r4 != 0.0f) goto L17;
        return 0.0f;
    L17:
        if (r5 != 0.0f) goto L20;
        return 0.0f;
    L20:
        return (1.0f - (1.0f / (((Math.abs(r4) * r6) / r5) + 1.0f))) * r5;
    L22:
        throw new IllegalArgumentException("factor must be in the range [0, 1]".toString());
    L10:
        if (r6 > 1.0f) goto L12;
        r3 = true;
        goto L12
    L24:
        throw new IllegalArgumentException("threshold must be non-negative".toString());
    L5:
        r1 = false;
        goto L6
    }
}
