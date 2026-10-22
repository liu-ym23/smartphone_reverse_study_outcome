package j2a;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.settings.value.tb;
import com.larus.utils.l0;
import com.larus.utils.m0;
import com.ss.android.vesdk.VEPreviewSettings;
import com.ss.android.vesdk.VESize;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pq9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class c {
    public final Ratio a;
    public final int b;
    public final int c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Ratio.values().length];
            r0[Ratio.RATIO_3_4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Ratio.RATIO_9_16.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Ratio.RATIO_FULL_SCREEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public int c() {
        throw null;
    }

    public final Pair<Integer, Integer> b() {
        int r0 = a.a[this.a.ordinal()];
        if (r0 != 1) goto L5;
        int r1 = (c() * 4) / 3;
    L12:
        return new Pair(Integer.valueOf(c()), Integer.valueOf(r1));
    L5:
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L8;
        r1 = (c() * 16) / 9;
        goto L12
    L8:
        int r2 = m0.a;
        AppHost.Companion r3 = AppHost.a;
        r1 = (int) (c() * (m0.a(r3.getApplication()) / m0.b(r3.getApplication())));
        goto L12
    L9:
        r1 = (c() * 16) / 9;
        goto L12
    }

    public final VEPreviewSettings a() {
        Pair<Integer, Integer> r0 = b();
        return new VEPreviewSettings.Builder().setRenderSize(new VESize(((Number) r0.getFirst()).intValue(), ((Number) r0.getSecond()).intValue())).setAsyncDetection(true).build();
    }

    public c(Ratio r4) {
        Intrinsics.checkNotNullParameter(r4, "ratio");
        this.a = r4;
        z2 r5 = z2.a;
        if (r5.getCameraSettings().getSupport1080p() != 1) goto L8;
        e10 r0 = e10.a;
        int r1 = l0.a;
        Integer r2 = ((oq9.b) l0.a(new oq9.b(0), new tb())).a();
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L9:
        this.b = r3;
        if (r5.getCameraSettings().getSupport1080p() != 1) goto L15;
        int r6 = c();
        k.a.getClass();
        Pair<Integer, Integer> r7 = k.b;
        if (r6 < ((Number) r7.getFirst()).intValue()) goto L14;
        int r8 = ((Number) r7.getSecond()).intValue();
    L16:
        this.c = r8;
        return;
    L14:
        r8 = ((Number) k.c.getSecond()).intValue();
        goto L16
    L15:
        k.a.getClass();
        r8 = ((Number) k.d.getSecond()).intValue();
        goto L16
    L7:
        k.a.getClass();
        r3 = ((Number) k.c.getFirst()).intValue();
        goto L9
    L8:
        k.a.getClass();
        r3 = ((Number) k.d.getFirst()).intValue();
        goto L9
    }
}
