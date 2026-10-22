package com.obric.oui.image;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"resolveEffectiveRadius", "", "shape", "Lcom/obric/oui/image/OImageShape;", "styleRadiusPx", "roundedRadiusPx", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13893a = null;

        static {
            int[] r0 = new int[OImageShape.values().length];
            r0[OImageShape.STANDARD.ordinal()] = 1;
            r0[OImageShape.ROUNDED.ordinal()] = 2;
            f13893a = r0;
        }
    }

    public static final float a(OImageShape r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "shape");
        int r4 = a.f13893a[r1.ordinal()];
        if (r4 != 1) goto L5;
        return r2;
    L5:
        if (r4 != 2) goto L8;
        return r3;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
