package com.larus.dora.impl.device;

import androidx.appcompat.widget.AppCompatTextView;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraSodaVipBannerBinding;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraDeviceLayoutInfoKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a0());
    }

    public static final void c(LarusDoraDeviceBatteryLayoutBinding r2) {
        r2.a.setAlpha(0.3f);
        e1.x(r2.d);
        e1.o(r2.c);
        AppCompatTextView r3 = r2.e;
        int r0 = com.larus.utils.j0.a;
        r3.setText(com.larus.utils.j0.d(2131903646));
    }

    public static final void d(LarusDoraDeviceInfoLayoutBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.j0() != true) goto L9;
    L10:
        if (r2 == false) goto L15;
        e1.x(r3.v);
        if (r0 == null) goto L14;
        r0.e();
    L14:
        r3.u.U5();
        return;
    L15:
        e1.o(r3.v);
        return;
    L9:
        r2 = false;
        goto L10
    }

    public static final void a(final LarusDoraSodaVipBannerBinding r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        e1.x(r2.a);
        e1.d(r2.b, new h0(r2));
        r2.c.setOnClickListener(new i0(r2, r3));
    }

    public static final void b(LarusDoraDeviceBatteryLayoutBinding r3, boolean r4, boolean r5, int r6) {
        r3.a.setAlpha(1.0f);
        e1.o(r3.d);
        r3.c.cancelAnimation();
        LottieAdapterView r0 = r3.c;
        Intrinsics.checkNotNull(r0);
        e1.x(r0);
        if (r5 == false) goto L5;
        String r2 = "charging";
    L6:
        r0.setContentDescription(r2);
        if (r4 == false) goto L11;
        if (r5 == false) goto L10;
        String r7 = "charging_dark";
    L14:
        r0.setAnimation(r7.concat("/data.json"));
        r0.setImageAssetsFolder(r7.concat("/images/"));
        float r8 = RangesKt.coerceIn((r6 / 100.0f) - 0.02f, 0.0f, 1.0f);
        r0.setMinAndMaxProgress(r8, r8);
        r0.playAnimation();
        AppCompatTextView r9 = r3.e;
        StringBuilder r10 = new StringBuilder();
        r10.append(r6);
        r10.append('%');
        r9.setText(r10.toString());
        return;
    L10:
        r7 = "default_dark";
        goto L14
    L11:
        if (r5 == false) goto L13;
        r7 = "charging_light";
        goto L14
    L13:
        r7 = "default_light";
        goto L14
    L5:
        r2 = "not charging";
        goto L6
    }
}
