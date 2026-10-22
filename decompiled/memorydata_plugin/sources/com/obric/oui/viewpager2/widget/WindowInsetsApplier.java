package com.obric.oui.viewpager2.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    private WindowInsetsApplier() {
    }

    private WindowInsetsCompat consumeAllInsets(WindowInsetsCompat r1) {
        if (WindowInsetsCompat.CONSUMED.toWindowInsets() == null) goto L7;
        return WindowInsetsCompat.CONSUMED;
    L7:
        return r1.consumeSystemWindowInsets().consumeStableInsets();
    }

    public static boolean install(ViewPager2 r3) {
        ApplicationInfo r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L8:
        ViewCompat.setOnApplyWindowInsetsListener(r3, new WindowInsetsApplier());
        return true;
    L5:
        if (r0.targetSdkVersion < 30) goto L8;
        return false;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        ViewPager2 r7 = (ViewPager2) ZeusTransformUtils.preCheckCast(r5, ViewPager2.class, "com.obric.memorydata.plugin");
        WindowInsetsCompat r8 = ViewCompat.onApplyWindowInsets(r7, r6);
        if (r8.isConsumed() == false) goto L5;
        return r8;
    L5:
        RecyclerView r9 = r7.e;
        int r0 = 0;
        int r1 = r9.getChildCount();
    L6:
        if (r0 >= r1) goto L9;
        ViewCompat.dispatchApplyWindowInsets(r9.getChildAt(r0), new WindowInsetsCompat(r8));
        r0 = r0 + 1;
        goto L6
    L9:
        return consumeAllInsets(r8);
    }
}
